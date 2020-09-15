package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.common.IdCard;
import cn.huaruan.ud24.application.common.SmsUtils;
import cn.huaruan.ud24.query.entity.TimelyUtil;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.dao.TimelyWaybillDao;
import cn.huaruan.ud24.query.entity.*;
import cn.huaruan.ud24.service.TimelyCourierService;
import cn.huaruan.ud24.service.TimelyWaybillService;
import cn.huaruan.ud24.vo.*;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/timely/courier")
@AllArgsConstructor
@Api(tags = "即时达快递员接口")
public class TimelyCourierController {

    private final TimelyCourierService courierService;


    private final TimelyWaybillService timelyWaybillService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TimelyCourierService timelyCourierService;

    @Autowired
    private TimelyWaybillDao timelyWaybillDao;

    @Autowired
    private AnnouncementController announcementController;

    @Autowired
    private TimelyWaybillController timelyWaybillController;

    @GetMapping("/condition")
    @ApiOperation("条件查询分页接口")
    public ResultMessage<Page<TimelyCourier>> findCourierWithSubCourier(FindTimelyCourierParam findCourierParam) {
        return new ResultMessage<>(courierService.findCourierWithSubCourier(findCourierParam));
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查找接口")
    public ResultMessage<TimelyCourier> findOne(@PathVariable("id") String id) {
        return new ResultMessage<>(courierService.getCourierByKey(id));
    }

    @PostMapping("/findOneTimelyCourier")
    @ApiOperation("快递员修改密码接口")
    public ResultMessage findOne(@RequestBody TimelyCourier courier) {
        return new ResultMessage<>(courierService.updateCourier(courier));
    }

    @PostMapping("/updateInformation")
    @ApiOperation("快递员修改个人信息接口")
    public ResultMessage updateInformation(@RequestBody TimelyCourier courier) {
        return new ResultMessage<>(courierService.updateInformation(courier));
    }


    @PostMapping("/forget")
    @ApiOperation("忘记密码接口")
    public ResultMessage forget(@RequestBody TimelyCourier courier) {
        return new ResultMessage<>(courierService.forget(courier));
    }

    @PostMapping("/addRider")
    @ApiOperation("添加快递员接口")
    public ResultMessage<String> addCourier(@RequestBody TimelyCourier courier) {
        courierService.addTimelyArrive(courier);
        return new ResultMessage<>();
    }

    @DeleteMapping("/deleteRider")
    @ApiOperation("删除快递员接口")
    public ResultMessage delete(@RequestBody List<String> ids) {
        return new ResultMessage<>(courierService.delete(ids));
    }


    @ApiOperation("发送验证码接口")
    @PostMapping(value = "/sendMsg")
    public ResultMessage<SendMsgParam> sendMsg(@NotNull @RequestBody SendMsgParam sendMsgParam) throws Exception {
        return new ResultMessage<>(SmsUtils.sendCode(sendMsgParam.getPhone()));
    }

    /**
     * 验证
     *
     * @param sendMsgParam
     * @return
     */
    @ApiOperation("验证验证码接口")
    @PostMapping(value = "/validateNum")
    public ResultMessage validateNum(@NotNull @RequestBody SendMsgParam sendMsgParam) {
        SmsUtils.validate(sendMsgParam);
        return new ResultMessage();
    }


    /**
     * 上传身份证
     *
     * @param idCardUpload
     * @return
     */
    @ApiOperation("上传身份证")
    @PostMapping(value = "/idCardUpload")
    public ResultMessage frontUpload(IdCardUpload idCardUpload) {
        return new ResultMessage(IdCard.recognize(idCardUpload));
    }

    @PutMapping("/batch")
    @ApiOperation("批量修改")
    public ResultMessage updateCourierStateByIds(@RequestBody UpdateCourierStateVo updateCourierStateVo) {
        return new ResultMessage(courierService.updateCourierState(updateCourierStateVo));
    }


    @PostMapping("/getOrder/history")
    @ApiOperation("根据id查找历史订单")
    public ResultMessage getOrderHistory(@RequestBody TimelyUtil timelyUtil) {
        return new ResultMessage<>(timelyWaybillService.getOrderHistory(timelyUtil));
    }

    @GetMapping("/scanPackge/{orderId}")
    @ApiOperation("装包扫描待配送")
    public ResultMessage scanPackge(@PathVariable("orderId") String orderId) {
        //生成运单uuid
        String wb_id = UUIDUtil.get();
        TimelyWaybill timelyWaybill = new TimelyWaybill();
        timelyWaybill.setTmNo("24" + LocalDateTime.now(ZoneOffset.of("+8")).format(DateTimeFormatter.ofPattern("yyyyMMddhhmmssSS")));
        //查询该笔订单来自哪家店铺
        String result = restTemplate.getForObject("http://39.100.129.155:8899/woho/myOrder/getOrderDetailsById/" + orderId, String.class);
        //修改订单状态为配送中
        //restTemplate.getForObject("http://39.98.153.56:8899/woho/myOrder/updateSend/" + orderId, String.class);
        //查看该店铺下的骑手
        JSONObject jsonObject = JSONObject.parseObject(result);
        String data = jsonObject.getString("data");
        JSONObject dateO = JSONObject.parseObject(data);
        String shopName = dateO.getString("shopName");
        String receiverPhone = dateO.getString("receiverPhone");
        String receiverName = dateO.getString("receiverName");
        String receiverAddress = dateO.getString("receiverAddress");
        String sellerAddress = dateO.getString("sellerAddress");
        String sellerPhone = dateO.getString("sellerPhone");
        String sellerName = dateO.getString("sellerName");
        String postFee = dateO.getString("postFee");
        String weight = dateO.getString("weight");
        TimelyWaybillVo waybill = new TimelyWaybillVo();
        waybill.setReceiverPhone(receiverPhone);
        waybill.setReceiver(receiverName);
        waybill.setReceiverAddress(receiverAddress);
        waybill.setSender(sellerName);
        waybill.setSenderAddress(sellerAddress);
        waybill.setSenderPhone(sellerPhone);
        if (weight == null){
            BigDecimal bigDecimalWeight = new BigDecimal(0.0);
            waybill.setGoodsWeight(bigDecimalWeight);
        }else {
            BigDecimal bigDecimalWeight = new BigDecimal(0.5);
            waybill.setGoodsWeight(bigDecimalWeight);
        }
        BigDecimal bigDecimal = new BigDecimal(7.5);
        waybill.setAmount(bigDecimal);
        waybill.setType(1);

        //List<String> timelyCouriers = timelyCourierService.queryRidersByShopName(shopName);
        /**
         * 派单规则(优先级：是否开启接单模式、是否已达单次接单上限、评分高低)
         */

        //找出符合以上条件的骑手
        TimelyCourier timelyCourier = timelyCourierService.queryConformRiders(shopName);
        //给骑手推送
        Announcement announcement = new Announcement();
        announcement.setType(2);
        announcement.setContext("你有新的订单了,快去超市取货吧>>>>>");
        announcement.setContextType("0");
        if (timelyCourier != null){
            announcement.setUserId(timelyCourier.getId());
            waybill.setRiderId(timelyCourier.getId());
            TimelyWbWithLogs wb = timelyWaybillService.insert(waybill);
            //将生成的运单存到woho订单表中
            restTemplate.getForObject("http://39.100.129.155:8899/woho/myOrder/save24No?no="+ wb.getTmNo() + "&orderId=" + orderId,String.class);

        }
        announcement.setPushType(2);
        announcementController.push(announcement);
        return new ResultMessage();
    }


    @PostMapping(value = "/getNo")
    @ApiOperation("运单查询")
    public ResultMessage getNo(@RequestBody GetTimelyNo getTimelyNo) {
        List<TimelyWbInfo> no = courierService.getNo(getTimelyNo);
        System.out.println("==========" + no);
        return new ResultMessage<>(no);
    }

    @GetMapping(value = "/income/{userId}")
    @ApiOperation(value = "快递员收入信息等")
    public ResultMessage income(@PathVariable(value = "userId") String userId) {
        IncomeInfo income = courierService.income(userId);
        return new ResultMessage<>(income);
    }

    @GetMapping(value = "/isOpen/{userId}")
    @ApiOperation(value = "快递员开启关闭接单")
    public ResultMessage isOpen(@PathVariable(value = "userId") String userId) {
        courierService.isOpen(userId);
        return new ResultMessage().success();
    }

    @CrossOrigin
    @GetMapping(value = "/queryRiders/{shopId}")
    @ApiOperation(value = "根据店铺id查询快递员列表")
    public ResultMessage queryRiders(@PathVariable(value = "shopId") String shopId) {
        List<TimelyCourier> timelyCouriers = courierService.queryRiders(shopId);
        return new ResultMessage<>(timelyCouriers);
    }

    @CrossOrigin
    @GetMapping(value = "/zhiDing")
    @ApiOperation(value = "根据店铺id查询快递员列表")
    public ResultMessage zhiDing(String orderId,String id){
        //生成运单uuid
        String wb_id = UUIDUtil.get();
        TimelyWaybill timelyWaybill = new TimelyWaybill();
        timelyWaybill.setTmNo("24" + LocalDateTime.now(ZoneOffset.of("+8")).format(DateTimeFormatter.ofPattern("yyyyMMddhhmmssSS")));
        //查询该笔订单来自哪家店铺
        String result = restTemplate.getForObject("http://39.100.129.155:8899/woho/myOrder/getOrderDetailsById/" + orderId, String.class);
        //修改订单状态为配送中
        String forObject = restTemplate.getForObject("http://39.100.129.155:8899/woho/myOrder/updateSend/" + orderId, String.class);
        System.out.println("&&&&&&======="+forObject);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String data = jsonObject.getString("data");
        JSONObject dateO = JSONObject.parseObject(data);
        String shopName = dateO.getString("shopName");
        String receiverPhone = dateO.getString("receiverPhone");
        String receiverName = dateO.getString("receiverName");
        String receiverAddress = dateO.getString("receiverAddress");
        String sellerAddress = dateO.getString("sellerAddress");
        String sellerPhone = dateO.getString("sellerPhone");
        String sellerName = dateO.getString("sellerName");
        String postFee = dateO.getString("postFee");
        String weight = dateO.getString("weight");
        TimelyWaybillVo waybill = new TimelyWaybillVo();
        waybill.setReceiverPhone(receiverPhone);
        waybill.setReceiver(receiverName);
        waybill.setReceiverAddress(receiverAddress);
        waybill.setSender(sellerName);
        waybill.setSenderAddress(sellerAddress);
        waybill.setSenderPhone(sellerPhone);
        if (weight == null){
            BigDecimal bigDecimalWeight = new BigDecimal(0.0);
            waybill.setGoodsWeight(bigDecimalWeight);
        }else {
            BigDecimal bigDecimalWeight = new BigDecimal(0.5);
            waybill.setGoodsWeight(bigDecimalWeight);
        }
        BigDecimal bigDecimal = new BigDecimal(7.5);
        waybill.setAmount(bigDecimal);
        waybill.setType(1);

        //List<String> timelyCouriers = timelyCourierService.queryRidersByShopName(shopName);
        /**
         * 派单规则(优先级：是否开启接单模式、是否已达单次接单上限、评分高低)
         */

        //找出符合以上条件的骑手
        TimelyCourier timelyCourier = timelyCourierService.findById(id);
        //给骑手推送
        Announcement announcement = new Announcement();
        announcement.setType(2);
        announcement.setContext("你有新的订单了,快去超市取货吧>>>>>");
        announcement.setContextType("0");
        if (timelyCourier != null){
            announcement.setUserId(timelyCourier.getId());
            waybill.setRiderId(timelyCourier.getId());
            timelyWaybillController.add(waybill);
        }
        announcement.setPushType(2);
        announcementController.push(announcement);
        return new ResultMessage();
    }

    /**
     * 根据wbNo查询骑手名字以及送达时间
     */
    @ApiOperation(value = "根据wbNo查询骑手名字以及送达时间")
    @GetMapping(value = "/getRiderName/{wbNo}")
    public ResultMessage getRiderName(@PathVariable("wbNo") String wbNo){
        return new ResultMessage(timelyCourierService.getRiderName(wbNo));
    }
}
