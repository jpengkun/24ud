package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.query.entity.Organization;
import cn.huaruan.ud24.service.OrganizationService;
import cn.huaruan.ud24.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 组织架构控制器
 *
 * @author outas
 */
@RestController
@RequestMapping("/organization")
@AllArgsConstructor
@Api(tags = "组织架构")
public class OrganizationController {

    private final OrganizationService organizationService;


    @ApiOperation("新增网点（不包含区域）")
    @PostMapping
    public ResultMessage<?> add(@RequestBody Organization organization) {
        organizationService.insert(organization);
        return new ResultMessage<>();
    }

    @ApiOperation("更新网点（不能更新区域）")
    @PutMapping
    public ResultMessage<?> update(@RequestBody OrgWithRegion orgWithRegion) {
        organizationService.update(orgWithRegion);
        return new ResultMessage<>();
    }

    @ApiOperation("更新网点的区域")
    @PutMapping("/polygon/{id}")
    public ResultMessage<?> updatePolygon(@PathVariable String id, @RequestBody Polygon polygon) {
        organizationService.updatePolygon(id, polygon);
        return new ResultMessage<>();
    }

    @ApiOperation("删除网点")
    @DeleteMapping("/{organizationId}")
    public ResultMessage<?> delete(@PathVariable String organizationId) {
        organizationService.delete(organizationId);
        return new ResultMessage<>();
    }

    @ApiOperation("根据根id获取树状结构的组织架构")
    @GetMapping("/trees")
    public ResultMessage<List<OrgWithRegionNode>> findTreeByIds(String id) {
        return new ResultMessage<>(organizationService.findTreeByIds(id));
    }

    @ApiOperation("根据根id获取组织架构")
    @GetMapping
    public ResultMessage<List<OrgWithRegion>> findAllByIds(String id) {
        return new ResultMessage<>(organizationService.findAllById(id));
    }

    @ApiOperation("根据id查询兄弟和父级")
    @GetMapping("/bro&parent")
    public ResultMessage<List<OrgWithRegionNode>> findBroAndParentById(String id) {
        return new ResultMessage<>(organizationService.findBroAndParentById(id));
    }

    @ApiOperation("根据id查询兄弟")
    @GetMapping("/bro")
    public ResultMessage<List<OrgSimpleVo>> findBroById(String id) {
        return new ResultMessage<>(organizationService.findBroById(id));
    }

    @ApiOperation("根据id该网点下所有站点")
    @GetMapping("/children/site")
    public ResultMessage<List<OrgSimpleVo>> findChildrenSiteById(String id) {
        return new ResultMessage<>(organizationService.findChildrenSiteById(id));
    }

    @ApiOperation("根据网点id和时间范围查询财务报表")
    @GetMapping("/statement/finance")
    public ResultMessage<List<FinStmtNode>> findFinStmt(FindStmtParam findStmtParam) {
        return new ResultMessage<>(organizationService.findFinStmt(findStmtParam));
    }

    @ApiOperation("平台数据")
    @GetMapping("/statement/platform")
    public ResultMessage<List<OrgStmtNode>> findPlatformStmt(FindStmtParam findStmtParam) {
        return new ResultMessage<>(organizationService.findPlatformStmt(findStmtParam));
    }

    @ApiOperation("网点报表")
    @GetMapping("/statement/site")
    public ResultMessage<List<OrgStmtNode>> findOrgStmt(FindStmtParam findStmtParam) {
        return new ResultMessage<>(organizationService.findSiteStmt(findStmtParam));
    }

//    @ApiOperation("根据网点id和时间范围查询网点报表")
//    @GetMapping("/statement/courier")
//    public ResultMessage<List<OrgStmtNode>> findCourierStmt(FindStmtParam findStmtParam) {
////        return new ResultMessage<>(organizationService.findOrgStmt(findStmtParam));
//        return null;
//    }

    @ApiOperation("查询总部和所有加盟商")
    @GetMapping("/franchisee")
    public ResultMessage<List<OrgSimpleVo>> findAllFrance() {
        return new ResultMessage<>(organizationService.findAllFrance());
    }

    @ApiOperation("根据坐标和level查询网点")
    @GetMapping("/point")
    public ResultMessage<OrgWithRegion> findByPointAndLevel(Double x, Double y, Integer level) {
        return new ResultMessage<>(organizationService.findByPointAndLevel(new Point(x, y), level));
    }

}
