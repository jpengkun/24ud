package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import lombok.Data;

@Data
public class FindWbByOpenId extends PageParam {

    private String openId;

    private Integer payStatus;

    private Integer state;
}
