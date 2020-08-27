package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.entity.StationUser;
import cn.huaruan.ud24.service.StationUserService;
import cn.huaruan.ud24.vo.FindStationUserParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/station/user")
@Api(tags = "站点账号")
public class StationUserController {

    private final StationUserService userService;


    @PostMapping
    @ApiOperation("添加账号")
    public ResultMessage<String> addStation(@RequestBody StationUser stationUser){
        return new ResultMessage(userService.addStationUser(stationUser));
    }

    @PutMapping
    @ApiOperation("修改账号")
    public ResultMessage updateStation(@RequestBody StationUser stationUser){
        return new ResultMessage(userService.updateStationUser(stationUser));
    }

    @DeleteMapping
    @ApiOperation("删除账号")
    public ResultMessage deleteStationByIds(@RequestBody List<String> ids){
        return new ResultMessage(userService.deleteStationUserByIds(ids));
    }

    @GetMapping
    @ApiOperation("条件查询")
    public ResultMessage<Page<StationUser>> findStationByParam(FindStationUserParam userParam){
        return new ResultMessage<>(userService.findStationUserByParam(userParam));
    }

    @GetMapping("/{id}")
    @ApiOperation("查找单个")
    public ResultMessage<StationUser> findStationById(@PathVariable("id") String id){
        return new ResultMessage<>(userService.findStationUserById(id));
    }
}
