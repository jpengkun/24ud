package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.common.EntityUtils;
import cn.huaruan.ud24.application.common.TimeUtils;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.application.query.QueryUtils;
import cn.huaruan.ud24.query.dao.BillDao;
import cn.huaruan.ud24.query.dao.TimelyCourierDao;
import cn.huaruan.ud24.query.entity.*;
import cn.huaruan.ud24.vo.*;
import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class TimelyCourierService {

    private final TimelyCourierDao timelyCourierDao;

    private final BCryptPasswordEncoder passwordEncoder;

    private final CourierEvaluateService evaluateService;

    private final BillDao billDao;

    /**
     * 添加即时达快递员
     *
     * @param timelyCourier
     * @return
     */
    public ResultMessage<String> addTimelyArrive(TimelyCourier timelyCourier) {
        AppAsserts.notNull(timelyCourier, "快递员信息不能为空");
        AppAsserts.notNull(timelyCourier.getPhone(), "快递员手机号不能为空");
        AppAsserts.notNull(timelyCourier.getSmallShopName(),"快递员所负责的小超不能为空");
        AppAsserts.notNull(timelyCourier.getCap(),"接单上限不能为空");
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
        if (firstOne!=null){
            AppAsserts.no(2 == firstOne.getState(), "快递员已认证，请直接登陆！");
            if (1 == firstOne.getState()) {
                return new ResultMessage<>(firstOne.getId()).message("快递员已注册但未认证");
            }
        }
        timelyCourier.setState(1);
        timelyCourier.setCreateTime(new Date());
        if (StringUtils.hasText(timelyCourier.getPassword())) {
            String encodedPassword = passwordEncoder.encode(timelyCourier.getPassword().trim());
            timelyCourier.setPassword(encodedPassword);
        } else {
            String encodedPassword = passwordEncoder.encode("123456".trim());
            timelyCourier.setPassword(encodedPassword);
        }
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
        courier.setScore(evaluateService.getAvgScore(id));
        //计算出当天收益
        courier.setIncome(billDao.countIncome(id, TimeUtils.getStartToday(), TimeUtils.setEndDay(new DateTime())));
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

    public TimelyCourier findByPhone(String phone) {
        AppAsserts.hasText(phone, "快递员手机号不能为空");
        return timelyCourierDao.selectByPhone(phone);
    }
}
