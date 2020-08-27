package cn.huaruan.ud24.vo;

import lombok.Data;

import java.util.List;

@Data
public class OrgStmtNode {

    private String orgId;

    private String orgPid;

    private String orgName;

    private Integer level;

    private List<CourierStmt> courierList;

    private List<OrgStmtNode> children;

}
