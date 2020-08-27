package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.EntityUtils;
import cn.huaruan.ud24.application.common.TimeUtils;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.application.query.QueryUtils;
import cn.huaruan.ud24.query.dao.BillDao;
import cn.huaruan.ud24.query.dao.TodaysCourierDao;
import cn.huaruan.ud24.query.entity.TodaysCourier;
import cn.huaruan.ud24.query.entity.TodaysCourierExample;
import cn.huaruan.ud24.vo.FindCourierParam;
import cn.huaruan.ud24.vo.TiCourierWithScore;
import cn.huaruan.ud24.vo.ToCourierWithScore;
import cn.huaruan.ud24.vo.TodaysCourierWithOrganization;
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
public class TodaysCourierService {

    private final TodaysCourierDao courierDao;

    private final BCryptPasswordEncoder passwordEncoder;

    private final CourierEvaluateService evaluateService;

    private final BillDao billDao;


    /**
     * 条件查询
     * @param findCourierParam
     * @return
     */
    public Page<TodaysCourierWithOrganization> findCourierWithSubCourier(FindCourierParam findCourierParam) {
        long total = courierDao.countCourier(findCourierParam);
        List<TodaysCourierWithOrganization> couriers = courierDao.findCourierWithSubCourier(findCourierParam);
        return new Page<>(total,couriers);
    }

    /**
     * 条件查询不分页
     * @param findCourierParam
     * @return
     */
    public List<TodaysCourierWithOrganization> findAll(FindCourierParam findCourierParam) {
        return courierDao.findAll(findCourierParam);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public TodaysCourier getCourierByKey(String id) {
        AppAsserts.notNull(id,"id不能为空");
        TodaysCourier todaysCourier = courierDao.selectByPrimaryKey(id);
        ToCourierWithScore courier = new ToCourierWithScore();
        AppAsserts.notNull(todaysCourier,"快递员不存在");
        QueryUtils.copyProperties(todaysCourier,courier);
        courier.setScore(evaluateService.getAvgScore(id));
        courier.setIncome(billDao.countIncome(id, TimeUtils.getStartToday(), TimeUtils.setEndDay(new DateTime())));
        return courier;
    }

    /**
     * 修改快递员
     * @param courier
     * @return
     */
    public long updateCourier(TodaysCourier courier) {
        AppAsserts.notNull(courier,"修改信息不能为空");
        AppAsserts.notNull(courier.getId(),"快递员id不能为空");
        TodaysCourierExample courierExample = new TodaysCourierExample();
        courierExample.createCriteria().andPhoneEqualTo(courier.getPhone()).andIdNotEqualTo(courier.getId());
        AppAsserts.yes(courierDao.countByExample(courierExample) < 1,
                "手机号重复！");
        if (StringUtils.hasText(courier.getPassword())){
            // 给密码加密
            String encodedPassword = passwordEncoder.encode(courier.getPassword().trim());
            courier.setPassword(encodedPassword);
        }
        if (EntityUtils.needToUpdate(courier, TodaysCourier.class)){
            return courierDao.updateByPrimaryKeySelective(courier);
        }
        return 0;
    }

    /**
     * 忘记密码
     * @param courier
     * @return
     */
    public long forget(TodaysCourier courier) {
        AppAsserts.notNull(courier.getPhone(),"手机号不能为空");
        TodaysCourierExample courierExample = new TodaysCourierExample();
        courierExample.createCriteria().andPhoneEqualTo(courier.getPhone());
        AppAsserts.yes(courierDao.countByExample(courierExample) > 0,
                "手机号不存在！");
        AppAsserts.notNull(courier.getPassword(),"密码不能为空");
        String encodedPassword = passwordEncoder.encode(courier.getPassword().trim());
        List<TodaysCourier> todaysCouriers = courierDao.selectByExample(courierExample);
        String id = todaysCouriers.get(0).getId();
        courier.setId(id);
        courier.setPassword(encodedPassword);
        if (EntityUtils.needToUpdate(courier, TodaysCourier.class)){
            return courierDao.updateByPrimaryKeySelective(courier);
        }
        return 0;
    }

    /**
     * 添加快递员
     * @param courier
     * @return
     */
    public String addCourier(TodaysCourier courier) {
        AppAsserts.notNull(courier,"快递员信息不能为空");
        AppAsserts.notNull(courier.getPhone(),"快递员手机号不能为空");
        AppAsserts.notNull(courier.getOid(),"快递员所属网点不能为空");
        TodaysCourierExample courierExample = new TodaysCourierExample();
        courierExample.createCriteria().andPhoneEqualTo(courier.getPhone());
        AppAsserts.yes(courierDao.countByExample(courierExample) < 1,
                "手机号重复！");
        courier.setState(1);
        courier.setCreateTime(new Date());
        if (courier.getPassword()!=null){
            String encodedPassword = passwordEncoder.encode(courier.getPassword().trim());
            courier.setPassword(encodedPassword);
        }else {
            String encodedPassword = passwordEncoder.encode("666666".trim());
            courier.setPassword(encodedPassword);
        }
        courier.setId(UUIDUtil.get());
        courier.setMoney(new BigDecimal(0));
        courierDao.insertSelective(courier);
        return courier.getId();
    }

    /**
     * 删除快递员
     * @param ids
     * @return
     */
    public long delete(List<String> ids) {
        AppAsserts.notEmpty(ids,"删除选项id不能为空");
        TodaysCourierExample courierExample = new TodaysCourierExample();
        courierExample.createCriteria().andIdentityIn(ids);
        long result = courierDao.deleteByExample(courierExample);
        for (String id : ids) {
            evaluateService.deleteEvaluateByCourierId(id);
        }
        return result;
    }

    //todo 根据坐标派单
}
