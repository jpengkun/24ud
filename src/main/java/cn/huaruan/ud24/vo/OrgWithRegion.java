package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.Organization;
import lombok.Data;
import org.springframework.data.geo.Polygon;

/**
 * @author outas
 */
@Data
public class OrgWithRegion extends Organization {
    Polygon region;
}
