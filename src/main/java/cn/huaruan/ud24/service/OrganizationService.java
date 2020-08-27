package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.EntityUtils;
import cn.huaruan.ud24.application.common.TreeUtils;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.QueryUtils;
import cn.huaruan.ud24.constant.OrganizationLevel;
import cn.huaruan.ud24.query.dao.*;
import cn.huaruan.ud24.query.entity.Organization;
import cn.huaruan.ud24.query.entity.OrganizationExample;
import cn.huaruan.ud24.vo.*;
import lombok.AllArgsConstructor;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 组织架构服务
 *
 * @author outas
 **/
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class OrganizationService {

    private final OrganizationDao organizationDao;
    private final TimelyWaybillDao timelyWaybillDao;
    private final TodaysWaybillDao todaysWaybillDao;
    private final TimelyCourierDao timelyCourierDao;
    private final TodaysCourierDao todaysCourierDao;

    /**
     * 根据根id数组查询所有组织结构
     *
     * @return 树状组织架构
     */
    public List<OrgWithRegionNode> findTreeByIds(String id) {
        List<OrgWithRegion> allByRootIds = findAllById(id);
        List<OrgWithRegionNode> orgWithRegionNodes = QueryUtils.copyCollection(allByRootIds, OrgWithRegionNode.class);
        List<OrgWithRegionNode> organizationTree = TreeUtils.toTree(orgWithRegionNodes,
                ArrayList::new,
                OrgWithRegionNode::getId,
                OrgWithRegionNode::getParentId,
                OrgWithRegionNode::getChildren,
                OrgWithRegionNode::setChildren);
        return organizationTree;
    }

    /**
     * 根据根id数组查询所有组织结构
     *
     * @return 组织架构列表
     */
    public List<OrgWithRegion> findAllById(String id) {
        return organizationDao.findChildrenById(id);
    }

    /**
     * 新增一个带有区域的组织
     *
     * @param organization 对象
     */
    public void insert(Organization organization) {
        AppAsserts.notNull(organization, "组织不能为空！");
        AppAsserts.hasText(organization.getName(), "区域名不能为空！");
        AppAsserts.notNull(organization.getLevel(), "区域级别不能为空！");

        Integer regionLevel = OrganizationLevel.REGION.getLevel();
        if (!regionLevel.equals(organization.getLevel())) {
            AppAsserts.hasText(organization.getCode(), "区域代码不能为空！");

        }
        OrganizationExample example = new OrganizationExample();

        String uuid = UUIDUtil.get();

        // 处理父和根的关系
        if (StringUtils.hasText(organization.getParentId())) {
            example.clear();
            example.createCriteria().andIdEqualTo(organization.getParentId());
            Organization parent = QueryUtils.getMaxOne(organizationDao.selectByExample(example));
            AppAsserts.notNull(parent, "父项不存在！");
        }

        // 相同位置下的区域代码不能重复
        List<Organization> organizations = organizationDao.countSames(null,
                organization.getParentId(), organization.getCode(), regionLevel);

        // 相同位置下已使用的区域代码
        List<String> existCodes = organizationDao.countSames(null,
                organization.getParentId(), null, regionLevel)
                .stream().map(Organization::getCode).collect(Collectors.toList());

        AppAsserts.no(organizations.size() > 0,
                "相同父级下区域代码不能重复！已使用的有：" + existCodes.toString());

        organization.setId(uuid);
        organization.setCreateTime(new Date());
        organizationDao.insertSelective(organization);

    }

    /**
     * 根据id更新
     *
     * @param orgWithRegion 对象
     */
    public void update(OrgWithRegion orgWithRegion) {
        AppAsserts.notNull(orgWithRegion, "项不能为空！");
        AppAsserts.notNull(orgWithRegion.getId(), "id不能为空！");

        Integer regionLevel = OrganizationLevel.REGION.getLevel();

        // 相同位置下的区域代码不能重复
        List<Organization> organizations = organizationDao.countSames(orgWithRegion.getId(),
                orgWithRegion.getParentId(), orgWithRegion.getCode(), regionLevel);

        // 相同位置下已使用的区域代码
        List<String> existCodes = organizationDao.countSames(null,
                orgWithRegion.getParentId(), null, regionLevel)
                .stream().map(Organization::getCode).collect(Collectors.toList());
        AppAsserts.no(organizations.size() > 0,
                "相同父级下区域代码不能重复！已使用的有：" + existCodes.toString());

        // 不能修改parentId,level
        orgWithRegion.setParentId(null);
        orgWithRegion.setLevel(null);
        // 判断传入的参数是否需要进行更新操作
        if (EntityUtils.needToUpdate(orgWithRegion, Organization.class)) {
            organizationDao.updateByPrimaryKeySelective(orgWithRegion);
        }
    }

    public void updatePolygon(String id, Polygon polygon) {
        if (polygon != null) {
            List<Point> points = polygon.getPoints();
            AppAsserts.yes(QueryUtils.getFirstOne(points)
                            .equals(QueryUtils.getLastOne(points)),
                    "区域必须为闭合点的集合！");
            organizationDao.updatePolygonById(id, polygon);
        }
        // 检验是否修改成功，如果坐标集合不为封闭图形则sql执行后会用null覆盖原数据
        // TODO org.springframework.data.geo.polygon 没有校验数据合法性，
        //  杂乱的点集合同样可以创建polygon成功，修复之前暂时使用如下判断
        OrgWithRegion org = organizationDao.findById(id);
        AppAsserts.no(org.getRegion() == null,
                "修改区域失败，且原区域信息丢失，请重试！");
    }

    /**
     * 根据id删除一条项
     *
     * @param organizationId 要删除的id
     */
    public void delete(String organizationId) {
        AppAsserts.notNull(organizationId, "id不能为空！");
        AppAsserts.notNull(organizationDao.selectByPrimaryKey(organizationId),
                "该组织架构不存在或已删除！");

        OrganizationExample example = new OrganizationExample();
        example.createCriteria().andParentIdEqualTo(organizationId);

        // 如果该项下存在子项
        AppAsserts.yes(organizationDao.countByExample(example) < 1,
                "请先删除该的所有子项！");
        organizationDao.deleteByPrimaryKey(organizationId);
    }


    /**
     * 根据id查询兄弟和父级
     *
     * @param id id
     * @return 树状结构的网点
     */
    public List<OrgWithRegionNode> findBroAndParentById(String id) {
        AppAsserts.hasText(id, "id不能为空");
        List<OrgWithRegion> broAndParentById = organizationDao.findBroAndParentById(id);
        List<OrgWithRegionNode> orgWithRegionNodes = QueryUtils.copyCollection(broAndParentById, OrgWithRegionNode.class);
        List<OrgWithRegionNode> organizationTree = TreeUtils.toTree(orgWithRegionNodes,
                ArrayList::new,
                OrgWithRegionNode::getId,
                OrgWithRegionNode::getParentId,
                OrgWithRegionNode::getChildren,
                OrgWithRegionNode::setChildren);
        return organizationTree;
    }

    public List<FinStmtNode> findFinStmt(FindStmtParam findStmtParam) {
        AppAsserts.hasText(findStmtParam.getOrgId(), "网点id不能为空");
        List<FinStmtNode> finStmtNodes = organizationDao.findFinStmt(findStmtParam);
        List<FinStmtNode> finStmtTree = TreeUtils.toTree(finStmtNodes,
                ArrayList::new,
                FinStmtNode::getOrgId,
                FinStmtNode::getPid,
                FinStmtNode::getChildren,
                FinStmtNode::setChildren);
        return finStmtTree;
    }

    /**
     * 根据id查询兄弟
     *
     * @param id id
     * @return 网点列表
     */
    public List<OrgSimpleVo> findBroById(String id) {
        AppAsserts.hasText(id, "id不能为空");
        List<OrgSimpleVo> bro = organizationDao.findBroById(id);
        return bro;
    }

    /**
     * 根据id查询下面所有的站点
     *
     * @param id id
     * @return 网点列表
     */
    public List<OrgSimpleVo> findChildrenSiteById(String id) {
        AppAsserts.hasText(id, "id不能为空");
        List<OrgSimpleVo> siteList = organizationDao.findChildrenSiteById(id);
        return siteList;
    }

    public List<OrgSimpleVo> findAllFrance() {
        List<OrgSimpleVo> siteList = organizationDao.findAllFrance();
        return siteList;
    }

    public OrgWithRegion findByPointAndLevel(Point point, Integer level) {
        return organizationDao.findByPoint(point, level);
    }


    private List<OrgStmtNode> findOrgStmt(FindStmtParam findStmtParam) {
        AppAsserts.notNull(findStmtParam, "查询参数对象不能为空！");
        AppAsserts.hasText(findStmtParam.getOrgId(), "网点id不能为空！");
        List<OrgStmtNode> stmtList = organizationDao.findOrgStmt(findStmtParam);
        // TODO 向上递归计算
        if (stmtList != null) {
            stmtList.forEach(stmt -> {
                if (stmt.getLevel() == 4) {
                    List<CourierStmt> courierList = stmt.getCourierList();
                    if (courierList != null) {
                        courierList.forEach(courier -> {
                            List<String> toPick = todaysWaybillDao.find4Stmt(1, courier.getCourierId(), findStmtParam.getCreateTimeStart(), findStmtParam.getCreateTimeEnd());
                            List<String> toDeliver = todaysWaybillDao.find4Stmt(6, courier.getCourierId(), findStmtParam.getCreateTimeStart(), findStmtParam.getCreateTimeEnd());
                            List<String> todo = new ArrayList<>();
                            todo.addAll(toPick);
                            todo.addAll(toDeliver);
                            List<String> done = todaysWaybillDao.find4Stmt(7, courier.getCourierId(), findStmtParam.getCreateTimeStart(), findStmtParam.getCreateTimeEnd());
                            List<String> cancel = todaysWaybillDao.find4Stmt(10, courier.getCourierId(), findStmtParam.getCreateTimeStart(), findStmtParam.getCreateTimeEnd());
                            List<String> abnormal = todaysWaybillDao.find4Stmt(99, courier.getCourierId(), findStmtParam.getCreateTimeStart(), findStmtParam.getCreateTimeEnd());
                            courier.setTodo(todo);
                            courier.setDone(done);
                            courier.setAbnormal(abnormal);
                            courier.setCancel(cancel);
                        });
                    }
                }
            });
        }
        return stmtList;
    }

    public List<OrgStmtNode> findPlatformStmt(FindStmtParam findStmtParam) {
        return TreeUtils.toTree(findOrgStmt(findStmtParam),
                ArrayList::new,
                OrgStmtNode::getOrgId,
                OrgStmtNode::getOrgPid,
                OrgStmtNode::getChildren,
                OrgStmtNode::setChildren);
    }
    public List<OrgStmtNode> findSiteStmt(FindStmtParam findStmtParam) {
        return findOrgStmt(findStmtParam).stream().filter(stmt -> stmt.getLevel() == 4).collect(Collectors.toList());
    }

}
