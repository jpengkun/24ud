package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.service.InvoiceService;
import cn.huaruan.ud24.vo.FindInvoiceParam;
import cn.huaruan.ud24.vo.InvoiceWithItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("/invoice")
@Api(tags = "发票")
public class InvoiceController {

    private final InvoiceService service;

    @PostMapping
    @ApiOperation("开发票")
    public ResultMessage<HashMap> creatInvoice(@RequestBody InvoiceWithItem invoiceWithItem) throws Exception {
        return new ResultMessage(service.save(invoiceWithItem));
    }

    @GetMapping
    public ResultMessage<Page<InvoiceWithItem>> getFinanceById(FindInvoiceParam findInvoiceParam) {
        return new ResultMessage<>(service.findByOpenIdPaged(findInvoiceParam));
    }
}
