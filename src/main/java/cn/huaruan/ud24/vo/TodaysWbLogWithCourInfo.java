package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.TodaysWbLog;
import lombok.Data;

@Data
public class TodaysWbLogWithCourInfo extends TodaysWbLog {

    private String userName;

    private String orgName;

    private String nextSiteName;

    private String courierName;

    private String courierPhone;
}
