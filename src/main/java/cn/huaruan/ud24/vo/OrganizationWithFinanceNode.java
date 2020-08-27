package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.FinanceTimely;
import cn.huaruan.ud24.query.entity.FinanceToday;
import lombok.Data;

import java.util.List;

@Data
public class OrganizationWithFinanceNode {

    private String orgId;

    private String orgPid;

    private String orgName;

    private String orgCity;

    private FinanceTimely timely;

    private FinanceToday todays;

    private List<OrganizationWithFinanceNode> children;
}
