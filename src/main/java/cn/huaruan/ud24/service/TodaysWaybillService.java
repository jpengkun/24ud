package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.common.AmapUtils;
import cn.huaruan.ud24.application.common.EntityUtils;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.application.query.QueryUtils;
import cn.huaruan.ud24.application.socket.MessageWebSocket;
import cn.huaruan.ud24.constant.OrganizationLevel;
import cn.huaruan.ud24.constant.ResultStatus;
import cn.huaruan.ud24.constant.TodaysWaybillState;
import cn.huaruan.ud24.query.dao.*;
import cn.huaruan.ud24.query.entity.*;
import cn.huaruan.ud24.vo.*;
import lombok.AllArgsConstructor;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 当日达运单服务类
 *
 * @author outas
 */

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class TodaysWaybillService {

    private final TodaysWaybillDao waybillDao;

    private final TodaysWbLogDao logDao;

    private final OrganizationDao organizationDao;

    private final QuestionWaybillDao questionWaybillDao;

    private final TodaysCourierDao courierDao;

    private final UserDao userDao;

    private final SequenceDao sequenceDao;

    private final MessageWebSocket messageWebSocket;

    /**
     * 分页条件查询所有即时达运单
     *
     * @param findWaybillParam
     * @return
     */
    public Page<TodaysWbWithLogs> getAllByParamPaged(FindWaybillParam findWaybillParam) {

        if (findWaybillParam != null) {
            String wbNo = findWaybillParam.getWbNo();

            //如果使用逗号隔开，则改为批量查询模式
            if (StringUtils.hasText(wbNo) && wbNo.contains(",")) {
                List<String> wbNoList = Arrays.asList(wbNo.split(","));
                findWaybillParam.setWbNoList(wbNoList);
                findWaybillParam.setWbNo(null);
            }
        }

        long count = waybillDao.countTodaysWaybill(findWaybillParam);
        List<TodaysWbWithLogs> waybillList = waybillDao.findTodaysWaybillWithLogs(findWaybillParam);

        return new Page<>(count, waybillList);
    }

    public TodaysWbWithLogs insert(TodaysWaybillVo waybill) {
        AppAsserts.notNull(waybill, "运单对象不能为空！");
        AppAsserts.hasText(waybill.getSender(), "寄件人姓名不能为空！");
        AppAsserts.hasText(waybill.getSenderPhone(), "寄件人电话不能为空！");
        AppAsserts.hasText(waybill.getSenderAddress(), "寄件人详细地址不能为空！");
        AppAsserts.hasText(waybill.getReceiver(), "收件人姓名不能为空！");
        AppAsserts.hasText(waybill.getReceiverPhone(), "收件人电话不能为空！");
        AppAsserts.hasText(waybill.getReceiverAddress(), "收件人详细地址不能为空！");
        //AppAsserts.notNull(waybill.getSourceType(), "运单来源不能为空！");
        AppAsserts.notNull(waybill.getGoodsWeight(), "货物重量不能为空！");
//      AppAsserts.notNull(waybill.getSenderLocation(), "寄件人位置坐标获取失败！请检查详细地址是否正确！");
//      AppAsserts.notNull(waybill.getReceiverLocation(), "收件人位置坐标获取失败！请检查详细地址是否正确！");


        if (waybill.getSenderLocation() == null) {
            List<Point> senderAddressPoints = AmapUtils.getLocation(waybill.getSenderAddress());
            waybill.setSenderLocation(QueryUtils.getFirstOne(senderAddressPoints));
        }

        if (waybill.getSenderLocation() == null) {
            List<Point> receiverAddressPoints = AmapUtils.getLocation(waybill.getReceiverAddress());
            waybill.setReceiverLocation(QueryUtils.getFirstOne(receiverAddressPoints));
        }

        String thirdPartNo = waybill.getThirdPartNo();
        if (StringUtils.hasText(thirdPartNo)) {
            TodaysWaybillExample example = new TodaysWaybillExample();
            example.createCriteria().andThirdPartNoEqualTo(thirdPartNo);
            AppAsserts.no(waybillDao.countByExample(example) > 0,
                    "三方单号:" + thirdPartNo + "已存在！");
        }

        String tdNo = waybill.getTdNo();
        if (StringUtils.hasText(tdNo)) {
            TodaysWbWithLogs byNo = waybillDao.findByNo(tdNo);
            AppAsserts.no(byNo != null, "运单号重复！");
            waybill.setTdNo(tdNo);
        } else {
            waybill.setTdNo("24" + AmapUtils.getCityCodeByPoint(waybill.getSenderLocation()) + String.format("%07d", sequenceDao.nextVal("TD")));
        }
        // 根据下单人位置和目的地位置获取所在网点的id
        OrgWithRegion startSite = organizationDao.findByPoint(waybill.getSenderLocation(), OrganizationLevel.SITE.getLevel());
        OrgWithRegion destSite = organizationDao.findByPoint(waybill.getReceiverLocation(), OrganizationLevel.SITE.getLevel());
        AppAsserts.notNull(startSite, "当前区域服务未开通，如有疑问请联系客服！");
        AppAsserts.notNull(destSite, "目的地区域服务未开通，如有疑问请联系客服！");
        waybill.setStartOrgId(startSite.getId());
        waybill.setDestOrgId(destSite.getId());

        StringBuilder destCode = new StringBuilder();
        organizationDao.findParentById(destSite.getId()).forEach(org -> {
            if (org.getLevel() > 1) {
                destCode.append("-").append(org.getCode());
            }
        });
        String id = UUIDUtil.get();
        waybill.setId(id);
        waybill.setDestCode(destCode.toString().substring(1));
        waybill.setPayStatus(false);
        Date date = new Date();
        waybill.setCreateTime(date);
        waybill.setUpdateTime(date);
        waybill.setConfirm(false);
        waybillDao.insertWithLocation(waybill);
        return findById(id);
    }

    /**
     * 下单
     *
     * @param waybill
     * @return
     */
    public TodaysWbWithLogs insertWithLog(TodaysWaybillVo waybill) {
        TodaysWbWithLogs insert = insert(waybill);
        insertOrderLog(waybill);
        return insert;
    }

    public TodaysWbWithLogs insertWithLog4Woho(TodaysWaybillVo waybill) {
        waybill.setPayStatus(true);
        waybill.setSourceType(1);
        TodaysWbWithLogs insert = insert(waybill);
        insertOrderLog(waybill);
        return insert;
    }

    public void insertOrderLog(TodaysWaybillVo waybill) {
        TodaysWbLogVo log = new TodaysWbLogVo();
        log.setWbId(waybill.getId());
        log.setOrgId(waybill.getStartOrgId());
        log.setState(TodaysWaybillState.WAITING_PICK.getState());
        if (StringUtils.hasText(waybill.getCourierId())) {
            log.setCourierId(waybill.getCourierId());
        } else {
            log.setDetail("下单成功！");
            //获取起点站的网点和其父级网点
            List<String> orgIdList = organizationDao.findParentById(log.getOrgId())
                    .stream()
                    .map(OrgWithRegion::getId)
                    .collect(Collectors.toList());

            //获取起点站的网点和父级网点所有的后台管理帐号id
            UserExample userExample = new UserExample();
            userExample.createCriteria().andOrgIdIn(orgIdList);
            List<String> userIdList = userDao.selectByExample(userExample)
                    .stream()
                    .map(User::getUserId)
                    .collect(Collectors.toList());
            //给所有指定的用户推送一条消息
            MessageWithUserIds message = new MessageWithUserIds();
            message.setType(1);
            message.setTitle("您有一条未指派快递员的新订单,请及时处理!");
            message.setWaybillId(waybill.getId());
            message.setUserIds(userIdList);
            messageWebSocket.send(message);
        }
        insertLog(log);
    }

    public TodaysWbWithLogs vipPreOrder(TodaysWaybillVo waybill) {
        if (waybill.getPayType() == null) {
            waybill.setPayType(1);
        }
        if (waybill.getSourceType() == null) {
            waybill.setSourceType(3);
        }
        waybill.setState(TodaysWaybillState.PRE_ORDER.getState());
        insert(waybill);

        TodaysWbLogVo log = new TodaysWbLogVo();
        log.setWbId(waybill.getId());
        log.setOrgId(waybill.getStartOrgId());
        log.setState(TodaysWaybillState.PRE_ORDER.getState());

        return waybillDao.findById(waybill.getId());
    }

    public void vipSendOrder(List<String> ids) {
        AppAsserts.notEmpty(ids, "运单号列表不能为空！");
        List<TodaysWbWithLogs> wbWithLogs = waybillDao.findByIdIn(ids);

        AppAsserts.notNull(wbWithLogs, "请选择正确的运单号！");
        List<TodaysWaybillVo> waybillVos = QueryUtils.copyCollection(wbWithLogs, TodaysWaybillVo.class);

        waybillVos.forEach(waybill -> {
            TodaysWbLogVo log = new TodaysWbLogVo();
            log.setId(UUIDUtil.get());
            log.setWbId(waybill.getId());
            log.setWbNo(waybill.getTdNo());
            log.setOrgId(waybill.getStartOrgId());
            log.setDetail("打印发货成功，等待快递员上门揽收");
            log.setState(TodaysWaybillState.WAITING_PACKAGE.getState());
            insertLog(log);
        });
    }

    public void update(TodaysWaybillVo waybill) {
        AppAsserts.notNull(waybill, "运单对象不能为空！");
        AppAsserts.hasText(waybill.getId(), "运单id不能为空！");

        if (EntityUtils.needToUpdate(waybill, TodaysWaybillVo.class)) {
            waybill.setUpdateTime(new Date());
            waybillDao.updateWithLocationById(waybill);
        }
    }

    public void delete(String id) {
        AppAsserts.hasText(id, "运单id不能为空！");
        waybillDao.deleteByPrimaryKey(id);
        TodaysWbLogExample example = new TodaysWbLogExample();
        example.createCriteria().andWbIdEqualTo(id);
        logDao.deleteByExample(example);
    }

    public void deleteByIdIn(List<String> ids) {
        AppAsserts.notEmpty(ids, "运单id数组不能为空！");
        ids.forEach(this::delete);
    }

    public void insertLog(TodaysWbLogVo log) {
        AppAsserts.notNull(log.getState(), "状态不能为空！");
        AppAsserts.hasText(log.getWbId() + log.getWbNo(), "运单id/运单号不能为空！");
        AppAsserts.hasText(log.getOrgId(), "当前网点id不能为空！");

        //兼容id和运单号 扫描，如果两个字段都传，则使用id
        TodaysWbWithLogs waybill;
        if (StringUtils.hasText(log.getWbId())) {
            waybill = waybillDao.findById(log.getWbId());
        } else {
            waybill = waybillDao.findByNo(log.getWbNo());
        }
        AppAsserts.notNull(waybill, "运单不存在，请确认运单号！");

        log.setWbId(waybill.getId());

        StringBuilder detail = new StringBuilder();

        TodaysWaybillState state = TodaysWaybillState.getByValue(log.getState());
        AppAsserts.no(state == null, "运单状态异常！");
        TodaysCourier todaysCourier;

        //获取当前运单最后操作的记录信息
        TodaysWbLogWithCourInfo lastLogs = QueryUtils.getLastOne(waybill.getLogs());
        //获取当前运单所在的网点信息
        Organization currentOrg = organizationDao.selectByPrimaryKey(log.getOrgId());
        Organization nextOrg;
        switch (state) {
            //预下单
            case PRE_ORDER:
                detail.append("预下单订单生成成功！");
                break;
            // 待取件
            case WAITING_PICK:
//                checkState(TodaysWaybillState.WAITING_PICK,
//                        lastLogs == null ? 1 : lastLogs.getState());
                if (lastLogs == null) {
                    detail.append("下单成功！");
                }
                if (StringUtils.hasText(log.getCourierId())) {
                    todaysCourier = courierDao.selectByPrimaryKey(log.getCourierId());
                    detail.append("等待快递员[").append(todaysCourier.getName())
                            .append("](电话:").append(todaysCourier.getPhone()).append(")上门取件！");
                }
//                AppAsserts.hasText(log.getCourierId(), "待取件状态时，取件快递员id不能为空");
                break;
            // 待入库
            case WAITING_PACKAGE:
                if (log.getDetail() != null && log.getDetail().length() == 0) {
                    checkState(TodaysWaybillState.WAITING_PICK, lastLogs.getState());
                    detail.append("取件成功！");
                } else {
                    detail.append(log.getDetail());
                }
                break;
            // 已入库
            case WAITING_TRANSPORT:
                AppAsserts.no(log.getState().equals(lastLogs.getState()), "请勿重复扫描");
                // 判断入库的网点是否正确
                if (StringUtils.hasText(lastLogs.getNextSiteId())) {
                    AppAsserts.yes(log.getOrgId().equals(lastLogs.getNextSiteId()),
                            "入库站点应为转运站点[" + lastLogs.getNextSiteName() + "]，请选择正确的入库站点");
                    checkState(TodaysWaybillState.TRANSPORTING, lastLogs.getState());
                    detail.append("[").append(currentOrg.getName()).append("]已揽收。");
                } else {
                    AppAsserts.yes(waybill.getStartOrgId().equals(log.getOrgId()),
                            "入库站点应为起始站点[" + waybill.getStartOrgName() + "]，请选择正确的入库站点");
                    checkState(TodaysWaybillState.WAITING_PACKAGE, lastLogs.getState());
                    detail.append("[").append(waybill.getStartOrgName()).append("]已揽收。");
                }
                // 如果起始网点id和目标网点id相等，则无需转运，将其状态改为待派送
                if (waybill.getStartOrgId().equals(waybill.getDestOrgId())) {
                    log.setState(TodaysWaybillState.WAITING_DISPATCH.getState());
                }
                break;
            // 运输中 4
            case TRANSPORTING:
                AppAsserts.no(log.getState().equals(lastLogs.getState()), "请勿重复扫描");
                AppAsserts.notNull(log.getNextSiteId(), "下一站id不能为空！");
                //获取当前运单下一站网点信息
                nextOrg = organizationDao.selectByPrimaryKey(log.getNextSiteId());
                detail.append("快件离开[").append(lastLogs.getOrgName())
                        .append("]已发往[").append(nextOrg.getName()).append("]");
                break;
            // 待出库 5
            case WAITING_DISPATCH:
                AppAsserts.no(log.getState().equals(lastLogs.getState()), "请勿重复扫描");
                if (StringUtils.hasText(lastLogs.getNextSiteId())) {
                    AppAsserts.yes(lastLogs.getNextSiteId().equals(log.getOrgId()),
                            "入库站点应为中转站点[" + lastLogs.getNextSiteName() + "]，请选择正确的入库站点");
                    if (!lastLogs.getNextSiteId().equals(waybill.getDestOrgId())) {
                        log.setState(TodaysWaybillState.WAITING_TRANSPORT.getState());
                    }
                }
                detail.append("快件已经到达[").append(currentOrg.getName()).append("]");
                break;
            // 派送中 6
            case DELIVERING:
                AppAsserts.hasText(log.getCourierId(), "派件人id不能为空！");
                todaysCourier = courierDao.selectByPrimaryKey(log.getCourierId());
                detail.append("[").append(currentOrg.getName()).append("]快递员[")
                        .append(todaysCourier.getName())
                        .append("](电话:").append(todaysCourier.getPhone())
                        .append("]正在为您派件，请保持电话畅通，并耐心等待！");
                break;
            // 已签收
            case SIGNED:
                checkState(TodaysWaybillState.DELIVERING, lastLogs.getState());
                AppAsserts.notNull(log.getDetail(), "签收类型(detail)不能为空！");
                detail.append("已签收！签收人是[").append(log.getDetail()).append("]");
                if (StringUtils.hasText(log.getRemarks())) {
                    detail.append("备注：").append(log.getRemarks());
                }
                detail.append(" 感谢使用二四优递同城配送，期待再次为您服务！");
                break;
            // 异常件 0
            case ABNORMAL:
                AppAsserts.notNull(log.getRemarks(), "remarks(异常描述)不能为空！");
                AppAsserts.notNull(log.getAbnormalType(), "异常类型不能为空！");
                detail.append("快件异常[").append(log.getAbnormalType()).append("]：").append(log.getRemarks());
                QuestionWaybill questionWaybill = new QuestionWaybill();
                questionWaybill.setWaybillId(log.getWbId());
                questionWaybill.setType(0);
                questionWaybill.setQuestionStatus(0);
                questionWaybill.setQuestionDetails(log.getRemarks());
                questionWaybill.setQuestionType(log.getAbnormalType());
                questionWaybill.setCreatTime(new Date());
                if (StringUtils.hasText(log.getImg())) {
                    String[] img = log.getImg().split(",");
                    questionWaybill.setImg1(img[0]);
                    questionWaybill.setImg2(img[1]);
                    questionWaybill.setImg3(img[2]);
                    questionWaybill.setImg4(img[3]);
                }
                questionWaybillDao.insert(questionWaybill);
                break;
            // 取消
            case CANCEL:
                checkState(TodaysWaybillState.WAITING_PICK, lastLogs.getState());
                detail.append("取消成功");
                break;
            // 其他
            default:
                detail.append(log.getDetail());
                break;
        }
        Date now = new Date();
        waybillDao.updateStateById(log.getWbId(), log.getState(), now);

        log.setId(UUIDUtil.get());
        log.setDetail(detail.toString());
        log.setCreateTime(now);
        logDao.insert(log);
    }

    public Page<TodaysWbWithLogs> findByCidAndState(FindWbByCidAndState findWbByCidAndState) {
        AppAsserts.hasText(findWbByCidAndState.getCourierId(), "快递员id不能为空！");
        AppAsserts.notNull(findWbByCidAndState.getState(), "要查询的运单状态不能为空！");

        long count = waybillDao.countByCourierIdAndState(findWbByCidAndState);
        List<TodaysWbWithLogs> timelyWbWithLogs = waybillDao.findByCourierIdAndState(findWbByCidAndState);
        return new Page<>(count, timelyWbWithLogs);
    }

    private void checkState(TodaysWaybillState stateEnum, Integer state) {
        AppAsserts.yes(stateEnum.getState() <= state,
                new ResultMessage(ResultStatus.FAILURE)
                        .message("该运单当前状态为" +
                                TodaysWaybillState.getByValue(state).getDesc() +
                                "，不支持本次操作")
                        .failure());
    }

    public TodaysWbWithLogs findById(String id) {
        AppAsserts.hasText(id, "运单id不能为空！");
        return waybillDao.findById(id);
    }

    public TodaysWbWithLogs findByNo(String no) {
        AppAsserts.hasText(no, "运单编号不能为空！");
        return waybillDao.findByNo(no);
    }

    public Page<TodaysWbWithLogs> findByOpenId(FindWbByOpenId findWbByOpenId) {
        AppAsserts.hasText(findWbByOpenId.getOpenId(), "openId不能为空！");
        long count = waybillDao.countByOpenId(findWbByOpenId);
        List<TodaysWbWithLogs> waybill = waybillDao.findByOpenId(findWbByOpenId);
        return new Page<>(count, waybill);
    }

    public List<TodaysWaybill> findByIdIn(List<String> ids) {
        AppAsserts.notNull(ids, "id列表不能为空！");
        TodaysWaybillExample example = new TodaysWaybillExample();
        example.createCriteria().andIdIn(ids);
        List<TodaysWaybill> todaysWaybills = waybillDao.selectByExample(example);
        AppAsserts.notNull(todaysWaybills, "运单号不存在！");
        return todaysWaybills;
    }

    public void pay(String id) {
        if (StringUtils.hasText(id)) {
            waybillDao.payById(id);
        }
    }

    public void importWaybill(List<TodaysWaybillVo> waybillList) {
        AppAsserts.notEmpty(waybillList, "导入的数据不能为空！");
        TodaysWaybillVo firstOne = QueryUtils.getFirstOne(waybillList);
        AppAsserts.hasText(firstOne.getTdNo(), "运单编号不能为空！");
        AppAsserts.hasText(firstOne.getStartOrgId(), "当前登录帐号网点id不能为空！");
        AppAsserts.hasText(firstOne.getDestOrgId(), "目的网点不能为空！");
        AppAsserts.hasText(firstOne.getReceiverAddress(), "收货人地址不能为空！");
        AppAsserts.hasText(firstOne.getUserId(), "操作人id不能为空！");
        AppAsserts.notNull(firstOne.getPayType(), "付款方式不能为空！");

        StringBuilder destCode = new StringBuilder();
        organizationDao.findParentById(firstOne.getDestOrgId()).forEach(org -> {
            if (org.getLevel() > 1) {
                destCode.append("-").append(org.getCode());
            }
        });
        String dc = destCode.toString().substring(1);
        int state = TodaysWaybillState.WAITING_PACKAGE.getState();
        String orgId = firstOne.getStartOrgId();
        waybillList.forEach(waybill -> {
            if (waybill.getAmount() == null) {
                waybill.setAmount(new BigDecimal(0));
            }
            if (waybill.getGoodsWeight() == null) {
                waybill.setGoodsWeight(new BigDecimal(0));
            }
            String wbId = UUIDUtil.get();
            waybill.setId(wbId);
            waybill.setDestCode(dc);
            waybill.setPayStatus(true);
            waybill.setState(state);
            waybill.setSourceType(3);
            waybill.setConfirm(true);
            waybill.setCreateTime(new Date());
            //导入的运单默认就是最后一站，可以直接派送，所以将起点和终点网点设置为同一个
            waybill.setStartOrgId(waybill.getDestOrgId());
            waybillDao.insert(waybill);

            TodaysWbLog log = new TodaysWbLog();
            log.setId(UUIDUtil.get());
            log.setWbId(wbId);
            log.setUserId(waybill.getUserId());
            log.setOrgId(orgId);
            log.setDetail("导入成功！");
            log.setState(state);
            log.setCreateTime(new Date());
            logDao.insert(log);
        });
    }

    public ImportResult importPreOrder4Vip(List<TodaysWaybillVo> waybillList) {
        AppAsserts.notEmpty(waybillList, "导入的数据不能为空！");
        int total = waybillList.size();

        // 获取导入运单的所有收/寄件人地址
        List<String> senderAddressList = waybillList.stream().map(TodaysWaybillVo::getSenderAddress).collect(Collectors.toList());
        List<String> receiverAddressList = waybillList.stream().map(TodaysWaybillVo::getReceiverAddress).collect(Collectors.toList());

        // 将所有收/寄件人地址批量转换为经纬度坐标
        List<Point> senderAddressPoints = AmapUtils.batchGetLocations(senderAddressList);
        List<Point> receiverAddressPoints = AmapUtils.batchGetLocations(receiverAddressList);
        List<ImportFailedWbMsg> failedWbMsg = new ArrayList<>();
        for (int i = 0; i < waybillList.size(); i++) {
            try {
                TodaysWaybillVo waybill = waybillList.get(i);
                waybill.setSenderLocation(senderAddressPoints != null ? senderAddressPoints.get(i) : null);
                waybill.setReceiverLocation(receiverAddressPoints != null ? receiverAddressPoints.get(i) : null);
                vipPreOrder(waybillList.get(i));
            } catch (Exception e) {
                e.printStackTrace();
                total -= 1;
                ImportFailedWbMsg importFailedWbMsg = new ImportFailedWbMsg();
                importFailedWbMsg.setIndex(i + 2);
                importFailedWbMsg.setMessage(e.getMessage());
                failedWbMsg.add(importFailedWbMsg);
            }
        }
        ImportResult importResult = new ImportResult();
        importResult.setSuccessCount(total);
        importResult.setFailedWbMsgList(failedWbMsg);
        return importResult;
    }

    /**
     * 大V端根据条件查询
     *
     * @param findWaybillParam 条件
     * @return 一页运单
     */
    public Page<TodaysWbWithLogs> find4Vip(FindWaybill4VipParam findWaybillParam) {

        //AppAsserts.notNull(findWaybillParam.getState(), "状态不能为空");
        //AppAsserts.notNull(findWaybillParam.getType(), "用户类型不能为空");
        /*if (findWaybillParam.getType() == 1) {
            AppAsserts.hasText(findWaybillParam.getVipUserId(), "当类型为1时，用户id不能为空");
        }*/
        long count = waybillDao.countWaybill4Vip(findWaybillParam);
        List<TodaysWbWithLogs> waybills = waybillDao.findWaybill4Vip(findWaybillParam);

        return new Page<>(count, waybills);
    }

}
