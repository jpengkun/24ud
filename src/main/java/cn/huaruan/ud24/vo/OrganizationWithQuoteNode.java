package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.QuoteTimely;
import cn.huaruan.ud24.query.entity.QuoteToday;
import lombok.Data;

import java.util.List;

@Data
public class OrganizationWithQuoteNode {

    private String orgId;

    private String orgPid;

    private String orgName;

    private String orgCity;

    private QuoteTimely timely;

    private QuoteToday todays;

    private List<OrganizationWithQuoteNode> children;
}
