package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.QuoteCalculateUtil;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.query.dao.FinanceTimelyDao;
import cn.huaruan.ud24.query.dao.TimelyCourierDao;
import cn.huaruan.ud24.query.entity.FinanceTimely;
import cn.huaruan.ud24.query.entity.TimelyCourier;
import cn.huaruan.ud24.vo.FinanceVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class FinanceTimelyService {

    private final FinanceTimelyDao financeTimelyDao;
    private final TimelyCourierDao timelyCourierDao;



    public void addFinanceTimely(FinanceTimely financeTimely){
        AppAsserts.notNull(financeTimely.getOId(),"组织结构id不能为空");
        financeTimely.setTimelyId(UUIDUtil.get());
        financeTimelyDao.insert(financeTimely);
    }

    public FinanceTimely findByOId(String oId){
        AppAsserts.notNull(oId,"组织结构id不能为空");
        return financeTimelyDao.findByOId(oId);
    }

    public void updateFinanceTimely(FinanceTimely financeTimely){
        AppAsserts.notNull(financeTimely.getOId(),"组织结构id不能为空");
        financeTimelyDao.updateFinanceTimely(financeTimely);
    }


    public FinanceTimely calFinance(FinanceVo financeVo) {
        TimelyCourier timelyCourier = timelyCourierDao.selectByPrimaryKey(financeVo.getCid());
        FinanceTimely byOId = financeTimelyDao.findByOId(timelyCourier.getFranchiseeId());
        return QuoteCalculateUtil.calculate(byOId, financeVo.getAmount());
    }

}
