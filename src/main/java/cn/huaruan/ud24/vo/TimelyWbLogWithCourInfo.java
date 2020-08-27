package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.TimelyWbLog;
import lombok.Data;

@Data
public class TimelyWbLogWithCourInfo extends TimelyWbLog {

    private String userName;

    private String orgName;

    private String courierName;

    private String courierPhone;
}
