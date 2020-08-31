package cn.huaruan.ud24.query.entity;

import cn.huaruan.ud24.application.query.PageParam;
import lombok.Data;

@Data
public class GetTimelyNo{

    private String userId;

    private Integer type;

    private Integer pageNo;
    private Integer pageSize;
}
