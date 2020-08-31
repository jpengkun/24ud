package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName ComplaintPageUtil
 * @Description TODO
 * @Author zdf82
 * @Date 2020/8/31 20:53
 **/
@Data
@ApiModel("申诉分页参数工具类")
public class ComplaintPageUtil {

    private Integer pageNo;

    private Integer pageSize;

    @ApiModelProperty("投诉发起人的电话")
    private String tel;
}
