package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.QuoteCalculateUtil;
import cn.huaruan.ud24.application.common.TreeUtils;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.query.dao.FinanceTodayDao;
import cn.huaruan.ud24.query.dao.OrganizationDao;
import cn.huaruan.ud24.query.dao.TodaysCourierDao;
import cn.huaruan.ud24.query.entity.FinanceToday;
import cn.huaruan.ud24.query.entity.TodaysCourier;
import cn.huaruan.ud24.vo.FinanceVo;
import cn.huaruan.ud24.vo.FindFinacne;
import cn.huaruan.ud24.vo.OrganizationWithFinanceNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class FinanceTodayService {

    private final FinanceTodayDao financeTodayDao;
    private final TodaysCourierDao todaysCourierDao;


    public void addFinanceToday(FinanceToday financeToday) {
        AppAsserts.notNull(financeToday.getOId(), "组织结构id不能为空");
        financeToday.setTodayId(UUIDUtil.get());
        financeTodayDao.insert(financeToday);
    }

    public FinanceToday findByOId(String oId) {
        AppAsserts.notNull(oId, "组织结构id不能为空");
        return financeTodayDao.findByOId(oId);
    }

    public void updateFinanceToday(FinanceToday financeToday) {
        AppAsserts.notNull(financeToday.getOId(), "组织结构id不能为空");
        financeTodayDao.updateFinanceToday(financeToday);
    }

    public List<OrganizationWithFinanceNode> findAll(FindFinacne findFinacne){
        List<OrganizationWithFinanceNode> financeByOid = financeTodayDao.findFinanceByOid(findFinacne);
        return TreeUtils.toTree(financeByOid,
                ArrayList::new,
                OrganizationWithFinanceNode::getOrgId,
                OrganizationWithFinanceNode::getOrgPid,
                OrganizationWithFinanceNode::getChildren,
                OrganizationWithFinanceNode::setChildren);
    }



    public FinanceToday calFinance(FinanceVo financeVo) {
        TodaysCourier todaysCourier = todaysCourierDao.selectByPrimaryKey(financeVo.getCid());
        FinanceToday byOId = financeTodayDao.findByOId(todaysCourier.getOid());
        return QuoteCalculateUtil.calculate(byOId, financeVo.getAmount());
    }

}
