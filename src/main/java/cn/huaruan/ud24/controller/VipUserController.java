package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.entity.VipUser;
import cn.huaruan.ud24.service.VipUserService;
import cn.huaruan.ud24.vo.FindVipUserParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/vip/user")
@AllArgsConstructor
@Api(tags = "VIP用户接口")
public class VipUserController {

    private final VipUserService userService;

    @ApiOperation("添加用户并返回ID")
    @PostMapping
    public ResultMessage add(@RequestBody VipUser vipUser){
        return new ResultMessage<>( userService.add(vipUser));
    }

    @ApiOperation("根据ID删除")
    @DeleteMapping
    public ResultMessage deleteUser(@RequestBody List<String> ids){
        userService.deleteUser(ids);
        return new ResultMessage();
    }

    @ApiOperation("修改")
    @PutMapping
    public ResultMessage update(@RequestBody VipUser vipUser){
        userService.updateUser(vipUser);
        return new ResultMessage();
    }

    @ApiOperation("根据条件查询 并分页")
    @GetMapping("/findUser")
    public ResultMessage<Page<VipUser>> findUser(FindVipUserParam vipUserParam){
        return new ResultMessage<>(userService.findUser(vipUserParam));
    }

    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public ResultMessage<VipUser> getUser(@PathVariable("id") String id){
        return new ResultMessage<>(userService.findOne(id));
    }
}
