package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.TreeUtils;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.query.dao.OrganizationDao;
import cn.huaruan.ud24.query.dao.QuoteTodayDao;
import cn.huaruan.ud24.query.entity.QuoteToday;
import cn.huaruan.ud24.query.entity.QuoteTodayExample;
import cn.huaruan.ud24.vo.FindQuoteParam;
import cn.huaruan.ud24.vo.OrgWithRegion;
import cn.huaruan.ud24.vo.OrganizationWithQuoteNode;
import cn.huaruan.ud24.vo.QuoteVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class QuoteTodayService {


    private final int WEIGHT_METHOD_CEIL = 2;
    private final OrganizationDao organizationDao;


    private final QuoteTodayDao quoteTodayDao;


    public QuoteToday findAllByOId(String oId) {
        return quoteTodayDao.findByOId(oId);
    }

    public List<OrganizationWithQuoteNode> findAll(FindQuoteParam findQuoteParam) {
        List<OrganizationWithQuoteNode> quoteByOid = organizationDao.findQuoteByOid(findQuoteParam);
        return TreeUtils.toTree(quoteByOid,
                ArrayList::new,
                OrganizationWithQuoteNode::getOrgId,
                OrganizationWithQuoteNode::getOrgPid,
                OrganizationWithQuoteNode::getChildren,
                OrganizationWithQuoteNode::setChildren);
    }

    public Object save(QuoteToday quoteToday) {
        AppAsserts.no(quoteToday.getFirstWeight().compareTo(quoteToday.getTopWeight()) == 1 || quoteToday.getFirstWeight().compareTo(quoteToday.getTopWeight()) == 0, "首重不能大于等于封顶重量");
        AppAsserts.no(quoteToday.getTopWeight().equals(0), "封顶重量不能为0");
        AppAsserts.no(quoteToday.getBasePrice().equals(0), "基础运费不能为0");
        AppAsserts.no(quoteToday.getAdditionalWeight().equals(0), "重量附加费不能为0");
        QuoteToday allByOId = quoteTodayDao.findByOId(quoteToday.getOId());
        AppAsserts.no(allByOId != null, "已存在不能继续添加");
        quoteToday.setId(UUIDUtil.get());
        quoteToday.setCreateTime(new Date());
        return quoteTodayDao.insert(quoteToday);
    }

    public int update(QuoteToday quoteToday) {
        AppAsserts.notNull(quoteToday.getId(), "id不能为空");
        return quoteTodayDao.updateByPrimaryKeySelective(quoteToday);
    }

    public QuoteToday findByArea(FindQuoteParam findQuoteParam) {
        OrgWithRegion byPoint = organizationDao.findByPoint(findQuoteParam.getPoint(), 4);
        if (byPoint != null) {
            String orgId = byPoint.getId();
            return findAllByOId(orgId);
        }
        return null;
    }

    public void delete(List<String> ids) {
        QuoteTodayExample quoteTodayExample = new QuoteTodayExample();
        quoteTodayExample.createCriteria().andIdIn(ids);
        quoteTodayDao.deleteByExample(quoteTodayExample);
    }


    public QuoteToday calCharges(QuoteVo quoteVo) {
        QuoteToday quoteToday = null;
        NumberFormat nf = NumberFormat.getNumberInstance();
        BigDecimal baseAmount;
        BigDecimal weightAmount;
        nf.setMaximumFractionDigits(2);
        String oid = quoteVo.getOid();
        OrgWithRegion byPoint = organizationDao.findByPoint(quoteVo.getPoint(), 4);
        AppAsserts.notNull(byPoint, "当前区域服务未开通，如有疑问请联系客服！");
        QuoteToday calQuote = quoteTodayDao.findCalQuoteToday(byPoint.getId());
        AppAsserts.notNull(calQuote, "本地区无计价规则,如有疑问请联系客服");
        AppAsserts.no(quoteVo.getWeight().compareTo(calQuote.getTopWeight()) == 1,
                "货物超过最大重量:" + calQuote.getTopWeight() + "kg");
        if (calQuote != null) {
            quoteToday = calQuote;
        }
        if (calQuote.getWeightMethod() == WEIGHT_METHOD_CEIL) {
            quoteToday.setWeight(quoteVo.getWeight().setScale(0, BigDecimal.ROUND_UP));
        }
        baseAmount = quoteToday.getBasePrice();
        quoteToday.setBaseAmount(baseAmount);
        weightAmount = QuoteToday.calWeightAmount(quoteVo.getWeight(), quoteToday).setScale(2, BigDecimal.ROUND_HALF_UP);
        quoteToday.setWeightAmount(weightAmount);
        quoteToday.setTotalAmount(baseAmount.add(weightAmount));
        return quoteToday;
    }


}
