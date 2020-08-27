package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author outas
 */
@Data
public class FindDictionaryParam extends PageParam {

    @ApiModelProperty(value = "字典名" )
    private String name;

    @ApiModelProperty(value = "字典值" )
    private String value;

}
