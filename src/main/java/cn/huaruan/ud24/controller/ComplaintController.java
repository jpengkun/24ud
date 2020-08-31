package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.entity.Complaint;
import cn.huaruan.ud24.query.entity.ComplaintPageUtil;
import cn.huaruan.ud24.query.entity.TimelyWbLog;
import cn.huaruan.ud24.service.ComplaintService;
import cn.huaruan.ud24.vo.ComplaintVo;
import cn.huaruan.ud24.vo.FindComplaintParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaint")
@AllArgsConstructor
@Api(tags = "投诉管理")
public class ComplaintController {

    private final ComplaintService complaintService;


    @ApiOperation("查询所有投诉及条件查询")
    @GetMapping
    //@PreAuthorize("hasAuthority('" + AuthorityCodes.USER_MANAGE + "')")
    public ResultMessage<Page<Complaint>> findComplaint(FindComplaintParam findComplaintParam) {
        return new ResultMessage<>(complaintService.findComplaint(findComplaintParam));
    }

    @ApiOperation("投诉")
    @PostMapping
    //@PreAuthorize("hasAuthority('" + AuthorityCodes.USER_ADD + "')")
    public ResultMessage<Object> addComplaint(@RequestBody Complaint complaint) {
        complaintService.addComplaint(complaint);
        return new ResultMessage<>();
    }

    @ApiOperation("更新投诉状态")
    @PutMapping
    //@PreAuthorize("hasAuthority('" + AuthorityCodes.USER_UPDATE + "')")
    public ResultMessage<Object> updateComplaint(@RequestBody ComplaintVo complaintVo) {
        complaintService.updateComplaint(complaintVo);
        return new ResultMessage<>();
    }

    @ApiOperation("根据ID删除投诉")
    @DeleteMapping
    //@PreAuthorize("hasAuthority('" + AuthorityCodes.USER_DELETE + "')")
    public ResultMessage<Object> deleteComplaint(@RequestBody List<String> complaintIds) {
        complaintService.deleteComplaintList(complaintIds);
        return new ResultMessage<>();
    }

    @PostMapping("/addPinSingle")
    @ApiOperation("添加快递员申诉销单接口")
    public ResultMessage<String> addPinSingle(@RequestBody Complaint complaint){
        complaintService.addPinSingle(complaint);
        return new ResultMessage<>();
    }

    @ApiOperation("查询所有投诉")
    @PostMapping("/findByPhoneAll")
    public ResultMessage findByPhoneAll(@RequestBody ComplaintPageUtil complaintPageUtil) {
        return new ResultMessage(complaintService.findByPhoneAll(complaintPageUtil));
    }


}
