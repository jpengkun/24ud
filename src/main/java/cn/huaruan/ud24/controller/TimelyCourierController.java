package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.common.IdCard;
import cn.huaruan.ud24.application.common.SmsUtils;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.constant.ResultStatus;
import cn.huaruan.ud24.query.dao.TimelyCourierDao;
import cn.huaruan.ud24.query.dao.TimelyWaybillDao;
import cn.huaruan.ud24.query.entity.*;
import cn.huaruan.ud24.service.TimelyCourierService;
import cn.huaruan.ud24.service.TimelyWaybillService;
import cn.huaruan.ud24.vo.*;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

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
    @ApiOperation("快递员修改接口")
    public ResultMessage findOne(@RequestBody TimelyCourier courier) {
        TimelyCourier byPhone = courierService.findByPhone(courier.getPhone());
        byPhone.setPassword(courier.getNewPassword());
        return new ResultMessage<>(courierService.updateCourier(byPhone));
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


    @PostMapping("/getOrderHistory")
    @ApiOperation("根据id查找历史订单")
    public ResultMessage<Page<TimelyWaybill>> getOrderHistory(@RequestBody Map map) {
        return new ResultMessage<Page<TimelyWaybill>>(timelyWaybillService.getOrderHistory(map));
    }

    @GetMapping("/scanPackge/{orderId}")
    @ApiOperation("装包扫描待配送")
    public ResultMessage scanPackge(@PathVariable("orderId") String orderId) {
        //生成运单uuid
        String wb_id = UUIDUtil.get();
        TimelyWaybill timelyWaybill = new TimelyWaybill();
        timelyWaybill.setTmNo("24" + LocalDateTime.now(ZoneOffset.of("+8")).format(DateTimeFormatter.ofPattern("yyyyMMddhhmmssSS")));
        //查询该笔订单来自哪家店铺
        String result = restTemplate.getForObject("http://localhost:8899/woho/myOrder/getOrderDetailsById/" + orderId, String.class);
        //查看该店铺下的骑手
        com.alibaba.fastjson.JSONObject jsonObject = JSONObject.parseObject(result);
        String shopName = jsonObject.getString("data");
        System.out.println("==========店铺名666=========" + shopName);
        //List<String> timelyCouriers = timelyCourierService.queryRidersByShopName(shopName);
        /**
         * 派单规则(优先级：是否开启接单模式、是否已达单次接单上限、评分高低)
         */

        //找出符合以上条件的骑手
        TimelyCourier timelyCourier = timelyCourierService.queryConformRiders(shopName);
        //给骑手推送
        Announcement announcement = new Announcement();
        announcement.setType(0);
        announcement.setContext("你有新的订单了,快去超市取货吧>>>>>");
        announcement.setContextType("0");
        announcement.setUserId(timelyCourier.getId());
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
}
