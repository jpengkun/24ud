package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.common.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

/**
 * 文件相关接口
 *
 * @author outas
 */
@RestController
@RequestMapping("/file")
@Api(tags = "文件相关")
public class FileController {

    @ApiOperation("上传文件")
    @PostMapping
    public ResultMessage<?> uploadWarehouseFile(String id, MultipartFile file) {
        return new ResultMessage<>(FileUtils.upload2Url(id, file));
    }

    @ApiOperation("批量上传文件")
    @PostMapping("/all")
    public ResultMessage<?> uploadWarehouseFileAll(String id, List<MultipartFile> files) {
        List<String> pathList = FileUtils.uploadAll(id, files);
        return new ResultMessage<>(pathList);
    }

    @ApiOperation("文件删除")
    @DeleteMapping
    public ResultMessage<?> deleteFile(@RequestBody HashMap<String, String> map) {
        FileUtils.delete(map.get("path"));
        return new ResultMessage<>();
    }

    @ApiOperation("批量文件删除")
    @DeleteMapping("/all")
    public ResultMessage<?> deleteAllFile(@RequestBody List<String> pathList) {
        FileUtils.deleteAll(pathList);
        return new ResultMessage<>();
    }
}
