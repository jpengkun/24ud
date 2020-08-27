package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.query.entity.QuoteToday;
import cn.huaruan.ud24.service.QuoteTodayService;
import cn.huaruan.ud24.vo.FindQuoteParam;
import cn.huaruan.ud24.vo.OrganizationWithQuoteNode;
import cn.huaruan.ud24.vo.QuoteVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@SuppressWarnings("all")
@RestController
@RequestMapping("/quoteToday")
@AllArgsConstructor
@Api(tags = "当日达计价规则管理")
public class QuoteTodayController {

    private final QuoteTodayService quoteTodayService;

    @ApiOperation("根据oid查询计价规则")
    @GetMapping
    public ResultMessage<QuoteToday> getAllQuotes(String oId) {
        return new ResultMessage(quoteTodayService.findAllByOId(oId));
    }

    @ApiOperation("查询计价规则")
    @GetMapping("/findAll")
    public ResultMessage<List<OrganizationWithQuoteNode>> findAll(FindQuoteParam findQuoteParam){
        return new ResultMessage<>(quoteTodayService.findAll(findQuoteParam));
    }

    @ApiOperation("添加计价规则")
    @PostMapping
    public ResultMessage<Object> createQuote(@RequestBody QuoteToday quoteToday) throws URISyntaxException {
        return new ResultMessage<>(quoteTodayService.save(quoteToday));
    }

    @ApiOperation("修改计价规则")
    @PutMapping
    public ResultMessage<Object> updateQuote(@RequestBody QuoteToday quoteToday) {
        return new ResultMessage<>(quoteTodayService.update(quoteToday));
    }

    @ApiOperation("删除计价规则")
    @DeleteMapping
    public ResultMessage<Object> deleteQuote(@RequestBody LinkedHashMap data) {
        List<String> ids = Arrays.asList(((String) data.get("ids")).split(","));
        quoteTodayService.delete(ids);
        return new ResultMessage<>();
    }

   @ApiOperation("计算")
   @PostMapping("/calCharges")
   public ResultMessage<QuoteToday> calCharges(@RequestBody QuoteVo quoteVo) {
       return new ResultMessage<>(quoteTodayService.calCharges(quoteVo));
   }
}
