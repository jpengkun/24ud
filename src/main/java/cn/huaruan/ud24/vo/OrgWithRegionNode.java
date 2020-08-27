package cn.huaruan.ud24.vo;

import lombok.Data;

import java.util.List;

/**
 * @author outas
 */
@Data
public class OrgWithRegionNode extends OrgWithRegion {
    List<OrgWithRegionNode> children;
}
