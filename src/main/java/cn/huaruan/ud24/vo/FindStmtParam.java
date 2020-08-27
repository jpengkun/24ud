package cn.huaruan.ud24.vo;

import lombok.Data;

import java.util.Date;

@Data
public class FindStmtParam {
    private String orgId;
    private Date createTimeStart;
    private Date createTimeEnd;
}
