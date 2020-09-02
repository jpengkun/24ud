package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.common.EntityUtils;
import cn.huaruan.ud24.application.common.TimeUtils;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.application.query.QueryUtils;
import cn.huaruan.ud24.constant.ResultStatus;
import cn.huaruan.ud24.query.dao.BillDao;
import cn.huaruan.ud24.query.dao.CourierEvaluateDao;
import cn.huaruan.ud24.query.dao.TimelyCourierDao;
import cn.huaruan.ud24.query.dao.TimelyWbLogDao;
import cn.huaruan.ud24.query.dao.TimelyWaybillDao;
import cn.huaruan.ud24.query.entity.*;
import cn.huaruan.ud24.query.mapper.TimelyWaybillMapper;
import cn.huaruan.ud24.vo.*;
import cn.hutool.core.date.DateTime;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class TimelyCourierService {

    private final TimelyCourierDao timelyCourierDao;

    private final BCryptPasswordEncoder passwordEncoder;

    private final CourierEvaluateService evaluateService;

    private final BillDao billDao;

    @Autowired
    private TimelyWaybillMapper timelyWaybillMapper;

    @Autowired
    private CourierEvaluateDao courierEvaluateDao;

    @Autowired
    private TimelyWbLogDao timelyWbLogDao;



    /**
     * 添加即时达快递员
     *
     * @param timelyCourier
     * @return
     */
    public ResultMessage<String> addTimelyArrive(TimelyCourier timelyCourier) {
        AppAsserts.notNull(timelyCourier, "快递员信息不能为空");
        AppAsserts.notNull(timelyCourier.getPhone(), "快递员手机号不能为空");
        AppAsserts.notNull(timelyCourier.getSmallShopName(), "快递员所负责的小超不能为空");
        AppAsserts.notNull(timelyCourier.getSmallShopId(), "快递员所负责的小超id不能为空");
        AppAsserts.notNull(timelyCourier.getCap(), "接单上限不能为空");
        AppAsserts.notNull(timelyCourier.getPassword(), "密码不能为空");
        TimelyCourierExample courierExample = new TimelyCourierExample();

        //TODO 根据手机号查询快递员

        //TODO 判断快递员是否已存在

        //TODO if 存在
        //TODO     快递员是否已认证通过
        //TODO     已认证   返回已认证
        //TODO     未认证   返回该快递员ID
        //TODO if 不存在
        courierExample.createCriteria().andPhoneEqualTo(timelyCourier.getPhone());
        List<TimelyCourier> courier = timelyCourierDao.selectByExample(courierExample);
        TimelyCourier firstOne = QueryUtils.getFirstOne(courier);
        if (firstOne != null) {
            AppAsserts.no(2 == firstOne.getState(), "快递员已认证，请直接登陆！");
            if (1 == firstOne.getState()) {
                return new ResultMessage<>(firstOne.getId()).message("快递员已注册但未认证");
            }
        }
        timelyCourier.setState(1);
        timelyCourier.setCreateTime(new Date());
        String encodedPassword = passwordEncoder.encode(timelyCourier.getPassword().trim());
        timelyCourier.setPassword(encodedPassword);
        timelyCourier.setId(UUIDUtil.get());
        timelyCourier.setDeposit(new BigDecimal(0));
        timelyCourier.setMoney(new BigDecimal(0));
        timelyCourierDao.insertSelective(timelyCourier);
        return new ResultMessage<>(timelyCourier.getId()).message("注册成功");
    }

    /**
     * 删除快递员
     *
     * @param ids
     * @return
     */
    public long delete(List<String> ids) {
        AppAsserts.notEmpty(ids, "删除选项id不能为空");
        TimelyCourierExample courierExample = new TimelyCourierExample();
        courierExample.createCriteria().andIdIn(ids);
        long result = timelyCourierDao.deleteByExample(courierExample);
        for (String id : ids) {
            evaluateService.deleteEvaluateByTimelyId(id);
        }
        return result;
    }

    /**
     * 修改快递员
     *
     * @param timelyCourier
     * @return
     */
    public long updateCourier(TimelyCourier timelyCourier) {
        AppAsserts.notNull(timelyCourier, "快递员信息不能为空");
        AppAsserts.notNull(timelyCourier.getPhone(), "快递员手机号不能为空");
        TimelyCourierExample courierExample = new TimelyCourierExample();
        courierExample.createCriteria().andPhoneEqualTo(timelyCourier.getPhone()).andIdNotEqualTo(timelyCourier.getId());
        AppAsserts.yes(timelyCourierDao.countByExample(courierExample) < 1,
                "手机号重复！");
        if (timelyCourier.getPassword() != null) {
            String encodedPassword = passwordEncoder.encode(timelyCourier.getPassword().trim());
            timelyCourier.setPassword(encodedPassword);
        }
        if (EntityUtils.needToUpdate(timelyCourier, TimelyCourier.class)) {
            return timelyCourierDao.updateByPrimaryKeySelective(timelyCourier);
        }
        return 0;
    }

    /**
     * 交押金
     *
     * @param id
     */
    public void deposit(String id) {
        TimelyCourier timelyCourier = timelyCourierDao.selectByPrimaryKey(id);
        timelyCourier.setDeposit(new BigDecimal(200));
        timelyCourierDao.updateByPrimaryKeySelective(timelyCourier);
        Bill bill = new Bill();
        bill.setType(1);
        bill.setMoney(timelyCourier.getDeposit());
        bill.setCourierId(timelyCourier.getId());
        bill.setGenre(1);
        bill.setCreateTime(new Date());
        billDao.insert(bill);
    }


    /**
     * 批量通过申请
     *
     * @param updateCourierStateVo
     * @return
     */
    public long updateCourierState(UpdateCourierStateVo updateCourierStateVo) {
        AppAsserts.notNull(updateCourierStateVo, "修改信息不能为空");
        AppAsserts.notEmpty(updateCourierStateVo.getIds(), "id不能为空");
        AppAsserts.notNull(updateCourierStateVo.getState(), "状态不能为空");
        return timelyCourierDao.updateCourierStateByIds(updateCourierStateVo);
    }

    /**
     * 条件查询
     *
     * @param findCourierParam
     * @return
     */
    public Page<TimelyCourier> findCourierWithSubCourier(FindTimelyCourierParam findCourierParam) {
        long total = timelyCourierDao.countTimely(findCourierParam);
        List<TimelyCourier> couriers = timelyCourierDao.findWithSubTimelyArrive(findCourierParam);
        return new Page<>(total, couriers);
    }


    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public TimelyCourier getCourierByKey(String id) {
        AppAsserts.notNull(id, "id不能为空");
        TimelyCourier timelyCourier = timelyCourierDao.selectByPrimaryKey(id);
        TiCourierWithScore courier = new TiCourierWithScore();
        AppAsserts.notNull(timelyCourier, "快递员不存在");
        QueryUtils.copyProperties(timelyCourier, courier);
        //courier.setScore(evaluateService.getAvgScore(id));
        //计算出当天收益
        //courier.setIncome(billDao.countIncome(id, TimeUtils.getStartToday(), TimeUtils.setEndDay(new DateTime())));
        return courier;
    }

    /**
     * 忘记密码
     *
     * @param courier
     * @return
     */
    public long forget(TimelyCourier courier) {
        AppAsserts.notNull(courier.getPhone(), "手机号不能为空");
        TimelyCourierExample courierExample = new TimelyCourierExample();
        courierExample.createCriteria().andPhoneEqualTo(courier.getPhone());
        AppAsserts.yes(timelyCourierDao.countByExample(courierExample) > 0,
                "手机号重复！");
        AppAsserts.notNull(courier.getPassword(), "密码不能为空");
        String encodedPassword = passwordEncoder.encode(courier.getPassword().trim());
        List<TimelyCourier> timelyCouriers = timelyCourierDao.selectByExample(courierExample);
        String id = timelyCouriers.get(0).getId();
        courier.setId(id);
        courier.setPassword(encodedPassword);
        if (EntityUtils.needToUpdate(courier, TimelyCourier.class)) {
            return timelyCourierDao.updateByPrimaryKeySelective(courier);
        }
        return 0;
    }

    public TimelyCourier findById(String courierId) {
        AppAsserts.hasText(courierId, "快递员id不能为空");
        return timelyCourierDao.selectByPrimaryKey(courierId);
    }

    public void isOpen(String userId) {
        TimelyCourier timelyCourier = timelyCourierDao.selectByPrimaryKey(userId);
        if (timelyCourier.getIsOpen() == 0) {
            timelyCourier.setIsOpen(1);
            timelyCourierDao.updateByPrimaryKey(timelyCourier);
        } else {
            timelyCourier.setIsOpen(0);
            timelyCourierDao.updateByPrimaryKey(timelyCourier);
        }
    }

    public IncomeInfo income(String userId) {
        //查询该骑手今日收入、评分、总订单
        IncomeInfo incomeInfo = timelyWaybillMapper.queryByRiderId(userId);
        if (null == incomeInfo.getIncome()){
            incomeInfo.setIncome(BigDecimal.valueOf(0.0));
        }
        Double evaluate = courierEvaluateDao.findAvgEvaluateByCourierId(userId);
        if (null == evaluate){
            incomeInfo.setGrade(5.0);
        }else {
            incomeInfo.setGrade(evaluate);
        }
        //是否开启
        TimelyCourier timelyCourier = timelyCourierDao.selectByPrimaryKey(userId);
        incomeInfo.setIsOpen(timelyCourier.getIsOpen());
        return incomeInfo;
    }

    public List<TimelyWbInfo> getNo(GetTimelyNo getTimelyNo) {
        PageHelper.startPage(getTimelyNo.getPageNo(), getTimelyNo.getPageSize());
        ArrayList<TimelyWbInfo> timelyWbInfos = new ArrayList<>();
        //运单编号集合
        List<TimelyWbLog> strings = timelyCourierDao.queryByCourierId(getTimelyNo.getUserId(), getTimelyNo.getType());
        for (TimelyWbLog timelyWbLog : strings) {
            TimelyWaybill timelyWaybill = timelyWaybillMapper.queryByTmNo(timelyWbLog.getWbId());
            TimelyWbInfo info = new TimelyWbInfo();
            info.setReceiver(timelyWaybill.getReceiver());
            info.setReceiverAddress(timelyWaybill.getReceiverAddress());
            info.setReceiverPhone(timelyWaybill.getReceiverPhone());
            info.setSender(timelyWaybill.getSender());
            info.setSenderAddress(timelyWaybill.getSenderAddress());
            info.setSenderPhone(timelyWaybill.getSenderPhone());
            info.setAmount(timelyWaybill.getAmount());
            info.setCreateTime(timelyWaybill.getCreateTime());
            info.setWbId(timelyWaybill.getId());
            Date createTime = timelyWbLog.getCreateTime();
            Date closedTime = timelyWbLog.getClosedTime();
            Long time = closedTime.getTime();
            Long time1 = createTime.getTime();
            Long times = time-time1;
            info.setTotalTime(times);
            timelyWbInfos.add(info);
        }
        PageInfo<TimelyWbInfo> infoPageInfo = new PageInfo<>(timelyWbInfos);
        return infoPageInfo.getList();
    }

    public TimelyCourier findByPhone(String phone) {
        AppAsserts.hasText(phone, "快递员手机号不能为空");
        return timelyCourierDao.selectByPhone(phone);
    }

    /**
     * 查询小超归属哪些骑手负责
     * @param shopName
     */
    public List<String> queryRidersByShopName(String shopName) {
        List<String> couriers = timelyCourierDao.queryRidersByShopName(shopName);
        return couriers;
    }

    /**
     * 符合接单条件的骑手
     */
    public TimelyCourier queryConformRiders(String shopName) {
        //开启接单且空闲中的骑手
        List<TimelyCourier> timelyCouriers = timelyCourierDao.queryConformRiders(shopName);
        //是否超过上限
        Iterator<TimelyCourier> iterator = timelyCouriers.iterator();
        while (iterator.hasNext()){
            TimelyCourier timelyCourier = iterator.next();
            Integer cap = timelyCourier.getCap();
            Integer capCount = timelyCourierDao.queryCapCount(timelyCourier.getId());
            if (capCount >= cap){
                iterator.remove();
            }
        }

        if (null != timelyCouriers && timelyCouriers.size() > 0) {
            TimelyCourier timelyCourier = timelyCouriers.get(0);
            return timelyCourier;
        }else {
            return null;
        }
    }
}
