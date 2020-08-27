package cn.huaruan.ud24.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author outas
 */
@Data
public class DictionaryNode {

    @ApiModelProperty(value = "字典id" )
    private String dictionaryId;

    @ApiModelProperty(value = "父id" )
    private String parentId;

    @ApiModelProperty(value = "根id" )
    private String rootId;

    @ApiModelProperty(value = "字典名" )
    private String name;

    @ApiModelProperty(value = "字典值" )
    private String value;

    @ApiModelProperty(value = "子项" )
    private List<DictionaryNode> children;

}
