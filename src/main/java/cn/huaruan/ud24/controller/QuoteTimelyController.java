package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.query.entity.QuoteTimely;
import cn.huaruan.ud24.service.QuoteTimelyService;
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
@RequestMapping("/quoteTimely")
@AllArgsConstructor
@Api(tags = "即时达计价规则管理")
public class QuoteTimelyController {

    private final QuoteTimelyService quoteTimelyService;

    @ApiOperation("根据oid查询计价规则")
    @GetMapping
    public ResultMessage<QuoteTimely> getAllQuotes(String oId) {
        return new ResultMessage<>(quoteTimelyService.findAllByOId(oId));
    }

    @ApiOperation("添加计价规则")
    @PostMapping
    public ResultMessage<Object> createQuote(@RequestBody QuoteTimely quoteTimely) throws URISyntaxException {
        return new ResultMessage<>(quoteTimelyService.save(quoteTimely));
    }

    @ApiOperation("修改计价规则")
    @PutMapping
    public ResultMessage<Object> updateQuote(@RequestBody QuoteTimely quoteTimely) {
        return new ResultMessage<>(quoteTimelyService.update(quoteTimely));
    }

    @ApiOperation("删除计价规则")
    @DeleteMapping
    public ResultMessage<Object> deleteQuote(@RequestBody LinkedHashMap data) {
        List<String> ids = Arrays.asList(((String) data.get("ids")).split(","));
        quoteTimelyService.delete(ids);
        return new ResultMessage<>();
    }

    @ApiOperation("计算")
    @PostMapping("/calCharges")
    public ResultMessage<QuoteTimely> calCharges(@RequestBody QuoteVo quoteVo) {
        return new ResultMessage<>(quoteTimelyService.calCharges(quoteVo));
    }

}
