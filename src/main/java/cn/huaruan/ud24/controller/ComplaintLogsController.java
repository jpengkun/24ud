package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.query.entity.ComplaintLogs;
import cn.huaruan.ud24.service.ComplaintLogsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/complaintLogs")
@AllArgsConstructor
@Api(tags = "投诉操作记录")
public class ComplaintLogsController {

    private final ComplaintLogsService complaintLogsService;


    @ApiOperation("查询所有投诉及条件查询")
    @GetMapping
    //@PreAuthorize("hasAuthority('" + AuthorityCodes.USER_MANAGE + "')")
    public ResultMessage<List<ComplaintLogs>> findComplaintLogs(String complaintId) {
        return new ResultMessage<>(complaintLogsService.findById(complaintId));
    }

}
