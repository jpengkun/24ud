package cn.huaruan.ud24.application.common;

import cn.huaruan.ud24.query.entity.InvoiceWaybill;
import cn.huaruan.ud24.vo.InvoiceWithItem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class InvoiceUtils {

    static String appid = "c08d57322030b1386355eb0f5b39c9827a2756fcbe4c4e9eda840ac56e6b637c";//appid
    static String contentPassword = "D91EAF386677952D";//AES加密密钥

    public static String getRequestBody(InvoiceWithItem invoiceWithItem) throws Exception {
        String content = "";
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"interface\": {");
        sb.append("\"globalInfo\": {");
        sb.append("\"appId\": \"").append(appid).append("\",");
        sb.append("\"interfaceId\": \"\",");
        sb.append("\"interfaceCode\": \"").append(Utils.dfxj1001).append("\",");
        sb.append("\"requestCode\": \"DZFPQZ\",");
        sb.append("\"requestTime\": \"").append(new Date()).append("\",");
        sb.append("\"responseCode\": \"Ds\",");
        sb.append("\"dataExchangeId\": \"").append("DZFPQZ").append(Utils.dfxj1001).append(Utils.formatToDay()).append(Utils.randNineData()).append("\"");
        sb.append("},");
        sb.append("\"returnStateInfo\": {");
        sb.append("\"returnCode\": \"\",");
        sb.append("\"returnMessage\": \"\"");
        sb.append("},");
        sb.append("\"Data\": {");
        sb.append("\"dataDescription\": {");
        sb.append("\"zipCode\": \"0\"");
        sb.append("},");
        sb.append("\"content\": \"");
        content = getUploadContent(invoiceWithItem);
        content = content.replace("\r\n", "").replace("\n", "").replace("\r", "");//json的报文不允许有换行，base64会产生。因此此处做去换行处理。
        sb.append(content).append("\",");
        sb.append("\"contentKey\":\"");
        String contentMD5 = MyAES.MD5(content.getBytes("UTF-8"));
        String contentKey = MyAES.encryptBASE64(MyAES.encrypt(contentMD5.getBytes("UTF-8"), contentPassword)).replaceAll("\r\n", "").replaceAll("\n", "").replace("\r", "");
        sb.append(contentKey).append("\"");
        sb.append("}");
        sb.append("}");
        sb.append("}");
        return sb.toString();
    }

    private static String getUploadContent(InvoiceWithItem invoiceWithItem) throws UnsupportedEncodingException {
        List<InvoiceWaybill> itemList = invoiceWithItem.getItems();
        BigDecimal amount = itemList.stream().map(InvoiceWaybill::getAmount).reduce((a, b) -> a.add(b)).get();
        BigDecimal taxRate = new BigDecimal(Double.toString(0.03));
        BigDecimal taxAmount = amount.multiply(taxRate).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal total = amount.add(taxAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
        StringBuffer content = new StringBuffer("{");
        content.append("\"REQUEST_COMMON_FPKJ\": {");
        content.append("\"FPQQLSH\": \"ESYD" + Utils.formatToTime() + "01" + "\",");
        content.append("\"ZSFS\": \"0\",");
        content.append("\"KPLX\": \"0\",");
        content.append("\"XSF_NSRSBH\": \"9132050931410577X8\",");
        content.append("\"XSF_MC\": \"江苏二四优递生活服务有限公司\",");
        content.append("\"XSF_DZDH\": \"江苏省苏州市吴江区松陵镇人民路450号2幢401室0521-63332424\",");
        content.append("\"XSF_YHZH\": \"招商银行股份有限公司吴江支行512908099010606\",");
        content.append("\"GMF_NSRSBH\": \"" + invoiceWithItem.getTaxNum() + "\",");
        content.append("\"GMF_MC\": \"" + invoiceWithItem.getTitle() + "\",");
        content.append("\"GMF_DZDH\": \"" + invoiceWithItem.getAddressAndPhoneNum() + "\",");
        content.append("\"GMF_YHZH\": \"" + invoiceWithItem.getBankAndNum() + "\",");
        content.append("\"GMF_SJH\": \"" + invoiceWithItem.getTel() + "\",");
        content.append("\"GMF_DZYX\": \"" + invoiceWithItem.getEmail() + "\",");
        content.append("\"FPT_ZH\": \"\",");
        content.append("\"WX_OPENID\": \"\",");
        content.append("\"KPR\": \"管理员\",");
        content.append("\"SKR\": \"\",");
        content.append("\"FHR\": \"\",");
        content.append("\"YFP_DM\": \"\",");
        content.append("\"YFP_HM\": \"\",");
        content.append("\"JSHJ\": \"" + total.doubleValue() + "\",");
        content.append("\"HJJE\": \"" + amount.doubleValue() + "\",");
        content.append("\"HJSE\": \"" + taxAmount.doubleValue() + "\",");
        content.append("\"KCE\": \"\",");
        content.append("\"BZ\": \"" + invoiceWithItem.getRemark() + "\",");
        content.append("\"HYLX\": \"\",");
        content.append("\"BY1\": \"\",");
        content.append("\"BY2\": \"\",");
        content.append("\"BY3\": \"\",");
        content.append("\"BY4\": \"\",");
        content.append("\"BY5\": \"\",");
        content.append("\"BY6\": \"\",");
        content.append("\"BY7\": \"\",");
        content.append("\"BY8\": \"\",");
        content.append("\"BY9\": \"\",");
        content.append("\"BY10\": \"\",");
        content.append("\"WX_ORDER_ID\": \"\",");
        content.append("\"WX_APP_ID\": \"\",");
        content.append("\"ZFB_UID\": \"\",");
        content.append("\"COMMON_FPKJ_XMXXS\": {");
        content.append("\"COMMON_FPKJ_XMXX\": [{");
        content.append("\"FPHXZ\": \"0\",");
        content.append("\"SPBM\": \"3079900000000000000\",");
        content.append("\"ZXBM\": \"\",");
        content.append("\"YHZCBS\": \"\",");
        content.append("\"LSLBS\": \"\",");
        content.append("\"ZZSTSGL\": \"\",");
        content.append("\"XMMC\": \"同城配送服务费\",");
        content.append("\"GGXH\": \"无\",");
        content.append("\"DW\": \"次\",");
        content.append("\"XMSL\": \"1\",");
        content.append("\"XMDJ\": \"" + amount.doubleValue() + "\",");
        content.append("\"XMJE\": \"" + amount.doubleValue() + "\",");
        content.append("\"SL\": \"0.03\",");
        content.append("\"SE\": \"" + taxAmount.doubleValue() + "\",");
        content.append("\"BY1\": \"\",");
        content.append("\"BY2\": \"\",");
        content.append("\"BY3\": \"\",");
        content.append("\"BY4\": \"\",");
        content.append("\"BY5\": \"\"}]");
        content.append("}");
        content.append("}");
        content.append("}");
        content.append("}");
        return new BASE64Encoder().encodeBuffer(content.toString().getBytes(StandardCharsets.UTF_8));
    }

    public static HashMap jsonToMap(String json) throws IOException {
        TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
        };
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, typeRef);
    }
}
