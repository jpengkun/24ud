package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.entity.VipAddress;
import cn.huaruan.ud24.service.VipAddressService;
import cn.huaruan.ud24.vo.FindVipAddressParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/vip/address")
@AllArgsConstructor
@Api(tags = "VIP地址簿管理接口")
public class VipAddressController {

    private final VipAddressService vipAddressService;

    @ApiOperation("添加地址簿")
    @PostMapping
    public ResultMessage addAddressBook(@RequestBody VipAddress vipAddress){
        vipAddressService.addAddressBook(vipAddress);
        return new ResultMessage();
    }

    @ApiOperation("根据ID删除")
    @DeleteMapping
    public ResultMessage deleteAddressBook(@RequestBody List<Integer> ids){
        vipAddressService.deleteAddressBook(ids);
        return new ResultMessage();
    }

    @ApiOperation("修改一个地址")
    @PutMapping
    public ResultMessage updateAddressBook(@RequestBody VipAddress vipAddress){
        vipAddressService.updateAddressBook(vipAddress);
        return new ResultMessage();
    }

    @ApiOperation("根据条件查询 并分页")
    @GetMapping("/findAddressBooks")
    public ResultMessage<Page<VipAddress>> findByOpenIdAndState(FindVipAddressParam findAddressBook){
        return new ResultMessage<>(vipAddressService.findByOpenIdAndState(findAddressBook));
    }

    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public ResultMessage<VipAddress> getAddressBookById(@PathVariable("id") int id){
        return new ResultMessage<>(vipAddressService.getAddressBookById(id));
    }
}
