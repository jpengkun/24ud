package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.common.EntityUtils;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.application.query.QueryUtils;
import cn.huaruan.ud24.constant.*;
import cn.huaruan.ud24.query.dao.*;
import cn.huaruan.ud24.query.entity.*;
import cn.huaruan.ud24.vo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 即时达运单服务类
 *
 * @author outas
 */

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class TimelyWaybillService {

    private final TimelyWaybillDao waybillDao;

    private final TimelyWbLogDao logDao;

    private final TimelyCourierDao courierDao;

    private final OrganizationDao organizationDao;

    private final QuestionWaybillDao questionWaybillDao;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 分页条件查询所有即时达运单
     *
     * @param findWaybillParam
     * @return
     */
    public Page<TimelyWbWithLogs> getAllByParamPaged(FindWaybillParam findWaybillParam) {

        long count = waybillDao.countTimelyWaybill(findWaybillParam);
        List<TimelyWbWithLogs> waybillList = waybillDao.findTimelyWaybillWithLogs(findWaybillParam);

        return new Page<>(count, waybillList);
    }

    public TimelyWbWithLogs insert(TimelyWaybillVo waybill) {
        AppAsserts.notNull(waybill, "运单对象不能为空！");
        AppAsserts.hasText(waybill.getSender(), "寄件人姓名不能为空！");
        AppAsserts.hasText(waybill.getSenderPhone(), "寄件人电话不能为空！");
        AppAsserts.hasText(waybill.getSenderAddress(), "寄件人详细地址不能为空！");
        //AppAsserts.notNull(waybill.getSenderLocation(), "下单人位置不能为空！");
        AppAsserts.hasText(waybill.getReceiver(), "收件人姓名不能为空！");
        AppAsserts.hasText(waybill.getReceiverPhone(), "收件人电话不能为空！");
        AppAsserts.hasText(waybill.getReceiverAddress(), "收件人详细地址不能为空！");
        //AppAsserts.notNull(waybill.getReceiverLocation(), "收件人位置不能为空！");
        AppAsserts.notNull(waybill.getGoodsWeight(), "货物重量不能为空！");

        OrgWithRegion organization = organizationDao.findByPoint(waybill.getSenderLocation(), OrganizationLevel.SITE.getLevel());
        AppAsserts.notNull(organization, "当前区域服务未开通，如有疑问请联系客服！");

        String id = UUIDUtil.get();
        waybill.setId(id);
        waybill.setOrgId(organization.getId());
        waybill.setTmNo("24" + LocalDateTime.now(ZoneOffset.of("+8")).format(DateTimeFormatter.ofPattern("yyyyMMddhhmmssSS")));
        //将生成的运单插入woho订单中
        waybill.setCreateTime(new Date());
        waybill.setConfirm(false);
        waybill.setPayStatus(false);
        waybillDao.insertWithLocation(waybill);

        TimelyWbLogVo log = new TimelyWbLogVo();
        log.setWbId(id);
        log.setCourierId(waybill.getRiderId());
        if (waybill.getType() == 1){
            log.setState(4);
        }else {
            log.setState(TimelyWaybillState.WAITING_ORDER.getState());
        }
        insertLog(log);

        return findById(id);
    }

    public void update(TimelyWaybillVo waybill) {
        AppAsserts.notNull(waybill, "运单对象不能为空！");
        AppAsserts.hasText(waybill.getId(), "运单id不能为空！");

        if (EntityUtils.needToUpdate(waybill, TimelyWaybillVo.class)) {
            waybillDao.updateWithLocationById(waybill);
        }
    }

    public void delete(String id) {
        AppAsserts.hasText(id, "运单id不能为空！");
        waybillDao.deleteByPrimaryKey(id);
    }

    public void insertLog(TimelyWbLogVo log) {
        AppAsserts.notNull(log.getState(), "状态不能为空！");
        AppAsserts.hasText(log.getWbId() + log.getWbNo(), "运单id/运单号不能为空！");
        //兼容id和运单号 扫描，如果两个字段都传，则使用id
        TimelyWbWithLogs waybill;
        if (StringUtils.hasText(log.getWbId())) {
            waybill = waybillDao.findById(log.getWbId());
        } else {
            waybill = waybillDao.findByNo(log.getWbNo());
            log.setWbId(waybill.getId());
        }
        StringBuilder detail = new StringBuilder();
        TimelyCourier timelyCourier;
        TimelyWaybillState state = TimelyWaybillState.getByValue(log.getState());
        TimelyWbLogWithCourInfo lastLogs = QueryUtils.getLastOne(waybill.getLogs());

        switch (state) {
            // 待接单
            case WAITING_ORDER:
                detail.append("下单成功，等待附近快递员接单！");
                break;
            // 待取件
            case WAITING_PICK:
                AppAsserts.notNull(log.getCourierId(), "快递员id不能为空！");
                timelyCourier = courierDao.selectByPrimaryKey(log.getCourierId());
                detail.append("快递员[").append(timelyCourier.getName()).append("](电话：")
                        .append(timelyCourier.getPhone()).append(")已接单，等待上门取件。");
                break;
            // 已取件
            case PICKED:
                detail.append("取件成功！等待派送。");
                break;
            // 派送中
            case DELIVERING:
                detail.append("开始派送！");
                break;
            // 等待签收
            case WAITING_SIGN:
                detail.append("快件已到达目的地，等待签收！");
                break;
            // 已签收
            case SIGNED:
                AppAsserts.notNull(log.getRemarks(), "remarks(签收类型)不能为空！");
                detail.append("已签收！签收人是[").append(log.getRemarks()).append("]")
                        .append("感谢使用二四优递同城配送，期待再次为您服务！");
                break;
            // 转单
            case NEGOTIATION:
                AppAsserts.notNull(log.getCourierId(), "转给的快递员id不能为空");
                timelyCourier = courierDao.selectByPrimaryKey(log.getCourierId());
                detail.append("快件已转交给[").append(timelyCourier.getName()).append("](电话：")
                        .append(timelyCourier.getPhone()).append(")，为您派送");
                break;
            // 取消
            case CANCEL:
                checkState(TimelyWaybillState.WAITING_ORDER, lastLogs.getState());
                detail.append("取消成功");
                break;
            // 异常件
            case ABNORMAL:
                AppAsserts.notNull(log.getRemarks(), "remarks(异常描述)不能为空！");
                AppAsserts.notNull(log.getAbnormalType(), "异常类型不能为空！");
                detail.append("快件异常[").append(log.getAbnormalType()).append("]：").append(log.getRemarks());
                QuestionWaybill questionWaybill = new QuestionWaybill();
                questionWaybill.setWaybillId(log.getWbNo());
                questionWaybill.setType(0);
                questionWaybill.setQuestionStatus(0);
                questionWaybill.setQuestionDetails(log.getRemarks());
                questionWaybill.setQuestionType(log.getAbnormalType());
                questionWaybill.setCreatTime(new Date());
                if (StringUtils.hasText(log.getImg())){
                    String[] img = log.getImg().split(",");
                    questionWaybill.setImg1(img[0]);
                    questionWaybill.setImg2(img[1]);
                    questionWaybill.setImg3(img[2]);
                    questionWaybill.setImg4(img[3]);
                }
                questionWaybillDao.insert(questionWaybill);
                break;
            // 其他
            default:
                break;
        }
        waybillDao.updateStateById(log.getWbId(),log.getState(),new Date());

        log.setId(UUIDUtil.get());
        log.setDetail(detail.toString());
        log.setCreateTime(new Date());
        logDao.insert(log);
    }

    /**
     * 根据当前位置分页查找半径x米之内的订单（用于即时达听单功能）
     *
     * @param circleVo 点、半径
     * @return 一页订单
     */
    public Page<TimelyWbWithLogs> findWithinRadius(CircleVo circleVo) {
        long count = waybillDao.countByCircleVo(circleVo);
        List<TimelyWbWithLogs> timelyWbWithLogs = waybillDao.findByCircleVo(circleVo);
        return new Page<>(count, timelyWbWithLogs);
    }

    public Page<TimelyWbWithLogs> findByCidAndState(FindWbByCidAndState findWbByCidAndState) {
        AppAsserts.hasText(findWbByCidAndState.getCourierId(), "快递员id不能为空！");
        AppAsserts.notNull(findWbByCidAndState.getState(), "要查询的运单状态不能为空！");

        long count = waybillDao.countByCourierIdAndState(findWbByCidAndState);
        List<TimelyWbWithLogs> timelyWbWithLogs = waybillDao.findByCourierIdAndState(findWbByCidAndState);
        return new Page<>(count, timelyWbWithLogs);
    }

    public TimelyWbWithLogs findById(String id) {
        AppAsserts.hasText(id, "运单id不能为空！");
        return waybillDao.findById(id);
    }

    public TimelyWbWithLogs findByNo(String no) {
        AppAsserts.hasText(no, "运单编号不能为空！");
        return waybillDao.findByNo(no);
    }


    public Page<TimelyWbWithLogs> findByOpenId(FindWbByOpenId findWbByOpenId) {
        AppAsserts.hasText(findWbByOpenId.getOpenId(), "openId不能为空！");
        long count = waybillDao.countByOpenId(findWbByOpenId);
        List<TimelyWbWithLogs> waybill = waybillDao.findByOpenId(findWbByOpenId);
        return new Page<>(count, waybill);
    }

    private void checkState(TimelyWaybillState stateEnum, Integer state) {
        AppAsserts.yes(stateEnum.getState() <= state,
                new ResultMessage(ResultStatus.FAILURE)
                        .message("该运单当前状态为" +
                                TodaysWaybillState.getByValue(state).getDesc() +
                                "，不支持本次操作")
                        .failure());
    }

    public void pay(String id) {
        if (StringUtils.hasText(id)){
            waybillDao.payById(id);
        }
    }

    /**
     * 历史接单
     * @param timelyUtil
     * @return
     */
    public List<TimelyWaybill> getOrderHistory(TimelyUtil timelyUtil) {
        PageHelper.startPage(timelyUtil.getPageNo(),timelyUtil.getPageSize());
        BigDecimal bigDecimal = new BigDecimal("0.00");
        timelyUtil.setState(6);
        List<TimelyWbLog> orderHistoryRiderId = logDao.getOrderHistoryRiderId(timelyUtil);
        List<TimelyWaybill> timelyWaybills = new ArrayList<>();
        Integer integer = 0;
        for (TimelyWbLog timelyWbLog : orderHistoryRiderId) {
            timelyUtil.setWbId(timelyWbLog.getWbId());
            integer += waybillDao.countTimelyWaybills(timelyUtil);
            TimelyWaybill waybill1 = waybillDao.getOrderHistoryRiderId(timelyUtil);
            if (waybill1!=null){
                Date createTime = timelyWbLog.getCreateTime();
                Date closedTime = timelyWbLog.getClosedTime();
                long time = createTime.getTime();
                long time1 = closedTime.getTime();
                Long times = time1 - time;
                waybill1.setTotalTime(times);
                timelyWaybills.add(waybill1);
            }
        }
        PageInfo<TimelyWaybill> objectPageInfo = new PageInfo<>(timelyWaybills);
        if (timelyWaybills.size()>0){
            for (TimelyWaybill timelyWaybill : timelyWaybills) {
                bigDecimal = bigDecimal.add(timelyWaybill.getAmount());
            }
            for (TimelyWaybill timelyWaybill : timelyWaybills) {
                timelyWaybill.setTotal(integer);
                timelyWaybill.setTotalAmount(bigDecimal);
            }
        }
        return objectPageInfo.getList();
    }




    public void signFor(String wbId, String userId) {
            waybillDao.signFor(UUIDUtil.get(),wbId,userId);
        TimelyWbWithLogs tb = waybillDao.findById(wbId);
        //确认送达后根据运单号修改小超订单状态完成
        restTemplate.getForObject("http://39.100.129.155:8899/woho/myOrder/sendOk/"+tb.getTmNo(),String.class);
    }


}
