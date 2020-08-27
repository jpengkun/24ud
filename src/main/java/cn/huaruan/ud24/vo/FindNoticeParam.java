package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
public class FindNoticeParam extends PageParam {

    @ApiModelProperty(value = "id" )
    private String id;
    @ApiModelProperty(value = "标题" )
    private String title;
    @ApiModelProperty(value = "类型" )
    private String type;
    @ApiModelProperty(value = "状态" )
    private Integer state;
    @ApiModelProperty(value = "创建时间开始" )
    private Date createTimeStart;
    @ApiModelProperty(value = "创建时间结束" )
    private Date createTimeEnd;
    @ApiModelProperty(value = "公告类型(1.app公告  2.后台管理公告)")
    private Integer category;

}
