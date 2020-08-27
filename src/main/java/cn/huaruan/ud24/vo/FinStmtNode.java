package cn.huaruan.ud24.vo;

import lombok.Data;

import java.util.List;

@Data
public class FinStmtNode {

    private String orgId;
    private String pid;
    private Integer level;
    private String orgName;
    private long timelyCount;
    private double timelyTotal;
    private long todaysCount;
    private double todaysTotal;
    private List<FinStmtNode> children;
}
