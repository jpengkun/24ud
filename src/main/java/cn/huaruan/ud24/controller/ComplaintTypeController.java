package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.query.entity.ComplaintType;
import cn.huaruan.ud24.service.ComplaintTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaintType")
@AllArgsConstructor
@Api(tags = "投诉类型管理")
public class ComplaintTypeController {

    private final ComplaintTypeService complaintTypeService;


    @ApiOperation("查询所有投诉及条件查询")
    @GetMapping
    //@PreAuthorize("hasAuthority('" + AuthorityCodes.USER_MANAGE + "')")
    public ResultMessage<List<ComplaintType>> findComplaintType(ComplaintType complaintType) {
        return new ResultMessage<>(complaintTypeService.findComplaintTypeList(complaintType));
    }

    @ApiOperation("添加公告")
    @PostMapping
    //@PreAuthorize("hasAuthority('" + AuthorityCodes.USER_ADD + "')")
    public ResultMessage<Object> addComplaintType(@RequestBody ComplaintType complaintType) {
        complaintTypeService.addComplaintType(complaintType);
        return new ResultMessage<>();
    }

    @ApiOperation("更新投诉状态")
    @PutMapping
    //@PreAuthorize("hasAuthority('" + AuthorityCodes.USER_UPDATE + "')")
    public ResultMessage<Object> updateComplaintType(@RequestBody ComplaintType complaintType) {
        complaintTypeService.updateComplaintType(complaintType);
        return new ResultMessage<>();
    }

    @ApiOperation("根据ID删除投诉")
    @DeleteMapping
    //@PreAuthorize("hasAuthority('" + AuthorityCodes.USER_DELETE + "')")
    public ResultMessage<Object> deleteComplaintType(@RequestBody List<String> complaintTypeIds) {
        complaintTypeService.deleteComplaintTypeList(complaintTypeIds);
        return new ResultMessage<>();
    }


}
