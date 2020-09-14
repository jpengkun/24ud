package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.EntityUtils;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.dao.CourierEvaluateDao;
import cn.huaruan.ud24.query.entity.*;
import cn.huaruan.ud24.vo.FindEvaluateAboutCourierParam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class CourierEvaluateService {

    private final CourierEvaluateDao evaluateDao;

    /**
     * 添加评论
     * @param courierEvaluate
     * @return
     */
    public long addCourierEvaluate(CourierEvaluate courierEvaluate){
        AppAsserts.notNull(courierEvaluate,"评价信息不能为空");
        AppAsserts.notNull(courierEvaluate.getCourierId(),"快递员Id不能为空");
        AppAsserts.notNull(courierEvaluate.getScore(),"快递员得分不能为空");
        AppAsserts.notNull(courierEvaluate.getWbId(),"运单id不能为空");
        return evaluateDao.insertSelective(courierEvaluate);
    }

    /**
     * 根据快递员id查询并分页
     * @param courierParam
     * @return
     */
    public Page<CourierEvaluate> findCourierEvaluateByCourierId(FindEvaluateAboutCourierParam courierParam){
        //AppAsserts.notNull(courierParam.getCourierId(),"快递员Id不能为空");
        long total = evaluateDao.countEvaluate(courierParam);
        List<CourierEvaluate> evaluates = evaluateDao.findCourierEvaluateByCourierId(courierParam);
        if (evaluates!=null){
            for (CourierEvaluate evaluate : evaluates) {
                String name = evaluateDao.findById(evaluate.getCourierId());
                evaluate.setCourierName(name);
                Double earnings = evaluateDao.findByIdEarnings(evaluate.getWbId());
                evaluate.setRiderGains(earnings);
            }
        }
        return new Page<>(total,evaluates);
    }

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    public long deleteEvaluate(Integer id){
        AppAsserts.notNull(id,"id不能为空");
        return evaluateDao.deleteByPrimaryKey(id);
    }

    /**
     * 根据当日达快递员id删除评价
     * @param courier
     * @return
     */
    public long deleteEvaluateByCourierId(String courier){
        CourierEvaluateExample evaluateExample = new CourierEvaluateExample();
        evaluateExample.createCriteria().andCourierIdEqualTo(courier);
        return evaluateDao.deleteByExample(evaluateExample);
    }

    /**
     * 根据即时达快递员id删除评价
     * @param courier
     * @return
     */
    public long deleteEvaluateByTimelyId(String courier){
        CourierEvaluateExample evaluateExample = new CourierEvaluateExample();
        evaluateExample.createCriteria().andTimelyIdEqualTo(courier);
        return evaluateDao.deleteByExample(evaluateExample);
    }
    /**
     * 修改评价
     * @param courierEvaluate
     * @return
     */
    public long update(CourierEvaluate courierEvaluate){
        AppAsserts.notNull(courierEvaluate,"评论信息不能为空");
        AppAsserts.notNull(courierEvaluate.getId(),"主键不能为空");
        AppAsserts.notNull(courierEvaluate.getScore(),"快递员得分不能为空");
        if (EntityUtils.needToUpdate(courierEvaluate,CourierEvaluate.class)){
            return evaluateDao.updateByPrimaryKeySelective(courierEvaluate);
        }
        return 0;
    }

    /**
     * 计算快递员的平均得分
     * @param courierId
     */
    public BigDecimal getAvgScore(String courierId){
        CourierEvaluateExample evaluateExample = new CourierEvaluateExample();
        evaluateExample.createCriteria().andCourierIdEqualTo(courierId);
        List<CourierEvaluate> evaluates = evaluateDao.selectByExample(evaluateExample);
        CourierEvaluate defaultEvaluate = new CourierEvaluate();
        defaultEvaluate.setScore(new BigDecimal(5));
        evaluates.add(defaultEvaluate);
        BigDecimal total = evaluates.stream().map(evaluate -> evaluate.getScore()).reduce((a, b) -> a.add(b)).get();
        return total.divide(new BigDecimal(evaluates.size()),1,BigDecimal.ROUND_HALF_UP);
    }

    public void updateRules(TimelyGains timelyGains) {
        AppAsserts.notNull(timelyGains.getCourierId(),"骑手ID不能为空");
        AppAsserts.notNull(timelyGains.getRule(),"收益规则");
        evaluateDao.updateRules(timelyGains);
    }

    public void addRules(TimelyGains timelyGains) {
        AppAsserts.notNull(timelyGains.getWbId(),"运单ID不能为空");
        AppAsserts.notNull(timelyGains.getRule(),"收益规则");
        TimelyWaybill timelyWaybill = evaluateDao.findByIdWbId(timelyGains.getWbId());
        Double rule = timelyGains.getRule();
        BigDecimal amount = timelyWaybill.getAmount();
        double v = amount.doubleValue();
        timelyGains.setRiderGains(v*rule);
        CourierEvaluate courierEvaluate = evaluateDao.findByWbIdCourierEvaluate(timelyGains.getWbId());
        timelyGains.setId(UUIDUtil.get());
        timelyGains.setCourierId(courierEvaluate.getCourierId());
        evaluateDao.addRules(timelyGains);
    }
}
