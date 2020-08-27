package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.common.IdCard;
import cn.huaruan.ud24.application.common.SmsUtils;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.entity.TimelyCourier;
import cn.huaruan.ud24.service.TimelyCourierService;
import cn.huaruan.ud24.vo.FindTimelyCourierParam;
import cn.huaruan.ud24.vo.IdCardUpload;
import cn.huaruan.ud24.vo.SendMsgParam;
import cn.huaruan.ud24.vo.UpdateCourierStateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timely/courier")
@AllArgsConstructor
@Api(tags = "即时达快递员接口")
public class TimelyCourierController {

    private final TimelyCourierService courierService;

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

    @PutMapping
    @ApiOperation("快递员修改接口")
    public ResultMessage findOne(@RequestBody TimelyCourier courier) {
        return new ResultMessage<>(courierService.updateCourier(courier));
    }

    @PostMapping("/forget")
    @ApiOperation("忘记密码接口")
    public ResultMessage forget(@RequestBody TimelyCourier courier) {
        return new ResultMessage<>(courierService.forget(courier));
    }

    @PostMapping
    @ApiOperation("添加快递员接口")
    public ResultMessage<String> addCourier(@RequestBody TimelyCourier courier) {
        return courierService.addTimelyArrive(courier);
    }

    @DeleteMapping
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

}
