package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.entity.TodaysCourier;
import cn.huaruan.ud24.service.TodaysCourierService;
import cn.huaruan.ud24.vo.FindCourierParam;
import cn.huaruan.ud24.vo.TodaysCourierWithOrganization;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todays/courier")
@AllArgsConstructor
@Api(tags = "快递员接口")
@CrossOrigin
public class TodaysCourierController {

    private final TodaysCourierService courierService;

    @GetMapping("/condition")
    @ApiOperation("条件查询分页接口")
    public ResultMessage<Page<TodaysCourierWithOrganization>> findCourierWithSubCourier(FindCourierParam findCourierParam){
        return new ResultMessage<>(courierService.findCourierWithSubCourier(findCourierParam));
    }

    @GetMapping("/all")
    @ApiOperation("条件查询不分页接口")
    public ResultMessage<List<TodaysCourierWithOrganization>> findAll(FindCourierParam findCourierParam){
        return new ResultMessage<>(courierService.findAll(findCourierParam));
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查找接口")
    public ResultMessage<TodaysCourier> findOne(@PathVariable("id") String id){
        return new ResultMessage<>(courierService.getCourierByKey(id));
    }

    @PutMapping
    @ApiOperation("快递员修改接口")
    public ResultMessage findOne(@RequestBody TodaysCourier courier){
        return new ResultMessage<>(courierService.updateCourier(courier));
    }

    @PostMapping("/forget")
    @ApiOperation("忘记密码接口")
    public ResultMessage forget(@RequestBody TodaysCourier courier){
        return new ResultMessage<>(courierService.forget(courier));
    }

    @PostMapping
    @ApiOperation("添加快递员接口")
    public ResultMessage<String> addCourier(@RequestBody TodaysCourier courier){
        return new ResultMessage<>(courierService.addCourier(courier));
    }

    @DeleteMapping
    @ApiOperation("删除快递员接口")
    public ResultMessage delete(@RequestBody List<String> ids){
        return new ResultMessage<>(courierService.delete(ids));
    }

    //todo 根据坐标派件
}
