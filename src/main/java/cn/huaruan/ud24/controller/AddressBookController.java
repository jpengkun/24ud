package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.entity.AddressBook;
import cn.huaruan.ud24.service.AddressBookService;
import cn.huaruan.ud24.vo.FindAddressBookParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/addressBooks")
@AllArgsConstructor
@Api(tags = "地址簿管理接口")
public class AddressBookController {

    private final AddressBookService addressBookService;

    @ApiOperation("添加地址簿并返回ID")
    @PostMapping
    public ResultMessage<?> addAddressBook(@RequestBody AddressBook addressBook) {
        addressBookService.addAddressBook(addressBook);
        return new ResultMessage();
    }

    @ApiOperation("根据ID删除")
    @DeleteMapping("/{id}")
    public ResultMessage deleteAddressBook(@PathVariable Integer id) {
        addressBookService.deleteAddressBook(id);
        return new ResultMessage();
    }

    @ApiOperation("修改一个地址")
    @PutMapping
    public ResultMessage updateAddressBook(@RequestBody AddressBook addressBook) {
        addressBookService.updateAddressBook(addressBook);
        return new ResultMessage();
    }

    @ApiOperation("根据条件查询 并分页")
    @GetMapping("/findAddressBooks")
    public ResultMessage<Page<AddressBook>> findByOpenIdAndState(FindAddressBookParam findAddressBook) {
        return new ResultMessage<>(addressBookService.findByOpenIdAndState(findAddressBook));
    }

    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public ResultMessage<AddressBook> getAddressBookById(@PathVariable("id") Integer id) {
        return new ResultMessage<>(addressBookService.getAddressBookById(id));
    }
}
