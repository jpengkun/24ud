package cn.huaruan.ud24.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class IdCardUpload {

    @ApiModelProperty("类型:1正面 2反面")
    private Integer type;

    @ApiModelProperty("快递员手机号")
    private String tel;

    @ApiModelProperty("文件")
    private MultipartFile file;
}
