package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.Organization;
import cn.huaruan.ud24.query.mapper.OrganizationMapper;
import cn.huaruan.ud24.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationDao extends OrganizationMapper {
    List<Organization> countSames(@Param("idNot") String idNot, @Param("parentId") String parentId,
                                  @Param("code") String code, @Param("levelNot") Integer levelNot);

    List<OrgWithRegion> findChildrenById(@Param("id") String id);

    List<OrgWithRegion> findParentById(@Param("id") String id);

    OrgWithRegion findByPoint(Point point, Integer level);

    OrgWithRegion findById(String id);

    long updatePolygonById(String id, Polygon polygon);

    List<OrgWithRegion> findBroAndParentById(String id);

    List<OrgSimpleVo> findBroById(String id);

    List<OrgSimpleVo> findChildrenSiteById(String id);

    List<OrgSimpleVo> findAllFrance();

    List<OrganizationWithQuoteNode> findQuoteByOid(FindQuoteParam findQuoteParam);

    List<FinStmtNode> findFinStmt(FindStmtParam findStmtParam);

    List<OrgStmtNode> findOrgStmt(FindStmtParam findStmtParam);

}