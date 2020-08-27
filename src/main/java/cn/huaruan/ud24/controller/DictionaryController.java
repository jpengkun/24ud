package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.query.entity.Dictionary;
import cn.huaruan.ud24.service.DictionaryService;
import cn.huaruan.ud24.vo.DictionaryNode;
import cn.huaruan.ud24.security.AuthorityCodes;
import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.vo.FindDictionaryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据字典控制器。
 *
 * @author outas*/
@RestController
@RequestMapping("/dictionary")
@AllArgsConstructor
@Api(tags = "数据字典")
public class DictionaryController {

    private final DictionaryService dictionaryService;


    @ApiOperation("新增字典项")
    @PostMapping
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.DICTIONARY_ADD + "')")
    public ResultMessage<?> addDictionary(@RequestBody Dictionary dictionary) {
        dictionaryService.insert(dictionary);
        return new ResultMessage<>();
    }

    @ApiOperation("更新字典项")
    @PutMapping
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.DICTIONARY_UPDATE + "')")
    public ResultMessage<?> updateDictionary(@RequestBody Dictionary dictionary) {
        dictionaryService.update(dictionary);
        return new ResultMessage<>();
    }

    @ApiOperation("删除字典项")
    @DeleteMapping("/{dictionaryId}")
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.DICTIONARY_DELETE + "')")
    public ResultMessage<?> deleteDictionary(@PathVariable String dictionaryId) {
        dictionaryService.delete(dictionaryId);
        return new ResultMessage<>();
    }

    @ApiOperation("查询字典项及子项")
    @GetMapping("/findWithSubDictionary")
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.DICTIONARY_MANAGE + "')")
    public ResultMessage<Page<DictionaryNode>> findWithSubDictionary(FindDictionaryParam findDictionaryParam) {
        return new ResultMessage<>(dictionaryService.findWithSubDictionary(findDictionaryParam));
    }

    @ApiOperation("根据根字典值查询字典树")
    @PostMapping("/trees")
    public ResultMessage<List<DictionaryNode>> findDictionaryTrees(@RequestBody String[] rootValues) {
        return new ResultMessage<>(dictionaryService.finAsTrees(rootValues));
    }

}
