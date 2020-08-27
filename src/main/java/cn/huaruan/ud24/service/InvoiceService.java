package cn.huaruan.ud24.service;


import cn.huaruan.ud24.application.common.RequestUtils;
import cn.huaruan.ud24.application.common.InvoiceUtils;
import cn.huaruan.ud24.application.common.MyAES;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.dao.InvoiceDao;
import cn.huaruan.ud24.query.dao.InvoiceWaybillDao;
import cn.huaruan.ud24.query.entity.InvoiceWaybill;
import cn.huaruan.ud24.vo.FindInvoiceParam;
import cn.huaruan.ud24.vo.InvoiceWithItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class InvoiceService {

    private final String requestUrl = "https://www.fapiao.com:63089/fpt-dsqz/invoice";

    private final static String RESPONSE_SUCCESS = "0000";

    private final InvoiceDao invoiceDao;

    private final InvoiceWaybillDao itemDao;

    public HashMap save(InvoiceWithItem invoiceWithItem) throws Exception {
        String response = RequestUtils.getHttpConnectResult(InvoiceUtils.getRequestBody(invoiceWithItem), requestUrl);
        HashMap<String, HashMap<String, HashMap<String, String>>> map = InvoiceUtils.jsonToMap(response);
        HashMap result = map.get("interface").get("returnStateInfo");
        if (RESPONSE_SUCCESS.equals(result.get("returnCode"))) {
            String content = new String(MyAES.decryptBASE64(map.get("interface").get("Data").get("content")));
            HashMap invoiceInfo = InvoiceUtils.jsonToMap(content);
            invoiceWithItem.setPdfUrl(invoiceInfo.get("PDF_URL") + "");
            invoiceWithItem.setInvoiceUrl(invoiceInfo.get("SP_URL") + "");
            invoiceWithItem.setInvoiceCode(invoiceInfo.get("FP_DM") + "");
            invoiceWithItem.setInvoiceNum(invoiceInfo.get("FP_HM") + "");
            invoiceWithItem.setCreateTime(new Date());
            invoiceWithItem.setId(UUIDUtil.get());
            invoiceDao.insertSelective(invoiceWithItem);

            List<InvoiceWaybill> items = invoiceWithItem.getItems();
            items.forEach(item ->item.setInvoiceId(invoiceWithItem.getId()));
            itemDao.insertInvoiceItems(items);
            /*List<String> ids = invoiceWithItem.getItemList().stream().map(Item::getOrderId).collect(Collectors.toList());
            HashMap orders = new HashMap(1);
            orders.put("ids", ids);
            orders.put("receiptState", 0);
            WebClient.builder().baseUrl("https://api.24ud.cn").build()
                    .patch()
                    .uri("/order/orders")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .body(BodyInserters.fromObject(new JSONObject(orders).toString()))
                    .retrieve()
                    .bodyToMono(List.class).block();*/
        }
        return result;
    }

    /**
     * 根据openid查找开票
     * @param invoiceParam
     * @return
     */
    public Page<InvoiceWithItem> findByOpenIdPaged(FindInvoiceParam invoiceParam) {
        long total = invoiceDao.countInvoice(invoiceParam);
        List<InvoiceWithItem> invoices= invoiceDao.findByOpenId(invoiceParam);
        return new Page<>(total,invoices);
    }
}
