package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.query.dao.OrganizationDao;
import cn.huaruan.ud24.query.dao.QuoteTimelyDao;
import cn.huaruan.ud24.query.entity.QuoteTimely;
import cn.huaruan.ud24.query.entity.QuoteTimelyExample;
import cn.huaruan.ud24.vo.FindQuoteParam;
import cn.huaruan.ud24.vo.OrgWithRegion;
import cn.huaruan.ud24.vo.QuoteVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class QuoteTimelyService {


    private final int WEIGHT_METHOD_CEIL = 2;

    private final OrganizationDao organizationDao;
    private final QuoteTimelyDao quoteTimelyDao;


    //根据oid查询计价规则
    public QuoteTimely findAllByOId(String oId) {
        return quoteTimelyDao.findQuoteTimely(oId);
    }

    //保存计价规则
    public Object save(QuoteTimely quoteTimely) {
        AppAsserts.no(quoteTimely.getFirstWeight().compareTo(quoteTimely.getTopWeight()) == 1 || quoteTimely.getFirstWeight().compareTo(quoteTimely.getTopWeight()) == 0,"首重不能大于等于封顶重量");
        AppAsserts.no(quoteTimely.getTopWeight().equals(0),"封顶重量不能为0");
        AppAsserts.no(quoteTimely.getBasePrice().equals(0),"基础运费不能为0");
        AppAsserts.no(quoteTimely.getAdditionalWeight().equals(0),"重量附加费不能为0");
        quoteTimely.setId(UUIDUtil.get());
        quoteTimely.setCreateTime(new Date());
        /*QuoteTimely allByOId = findAllByOId(quoteTimely.getOId());
        AppAsserts.yes(allByOId!=null,"已存在不能继续添加");*/
        return quoteTimelyDao.insert(quoteTimely);
    }

    public int update(QuoteTimely quoteTimely){
        AppAsserts.notNull(quoteTimely.getId(),"id不能为空");
        return quoteTimelyDao.updateByPrimaryKeySelective(quoteTimely);
    }

    //根据oid查询经纬度判断是否已存在计价规则
    public QuoteTimely findByArea(FindQuoteParam findQuoteParam) {
        OrgWithRegion byPoint = organizationDao.findByPoint(findQuoteParam.getPoint(), 4);
        if(byPoint!=null){
            String orgId = byPoint.getId();
            return findAllByOId(orgId);
        }
        return null;
    }

    //删除计价规则
    public void delete(List<String> ids) {
        QuoteTimelyExample quoteTimelyExample = new QuoteTimelyExample();
        quoteTimelyExample.createCriteria().andIdIn(ids);
        quoteTimelyDao.deleteByExample(quoteTimelyExample);
    }

    //
    public QuoteTimely calCharges(QuoteVo quoteVo) {
        QuoteTimely quoteTimely = null;
        BigDecimal baseAmount;
        BigDecimal weightAmount;
        OrgWithRegion byPoint = organizationDao.findByPoint(quoteVo.getPoint(), 4);
        AppAsserts.notNull(byPoint,"当前区域服务未开通，如有疑问请联系客服！");
        QuoteTimely calQuoteTimely = quoteTimelyDao.findCalQuoteTimely(byPoint.getId());
        AppAsserts.notNull(calQuoteTimely,"本地区无计价规则,如有疑问请联系客服！");
        if(quoteVo.getWeight().compareTo(calQuoteTimely.getTopWeight())==1){
            AppAsserts.no(true,"货物超过最大重量:" + calQuoteTimely.getTopWeight() + "kg");
        }
        if (calQuoteTimely != null) {
            quoteTimely = calQuoteTimely;
        }
        if (calQuoteTimely.getWeightMethod() == WEIGHT_METHOD_CEIL) {
            quoteTimely.setWeight(quoteVo.getWeight().setScale(0, BigDecimal.ROUND_UP));
        }
        quoteTimely.setWeightAmount(quoteTimely.calWeightAmount(quoteVo.getWeight(), quoteTimely));
        baseAmount = QuoteTimely.calBaseAmount(quoteVo.getDistance(), quoteTimely).setScale(2,BigDecimal.ROUND_HALF_UP);
        quoteTimely.setBaseAmount(baseAmount);
        weightAmount = QuoteTimely.calWeightAmount(quoteVo.getWeight(), quoteTimely).setScale(2,BigDecimal.ROUND_HALF_UP);
        quoteTimely.setWeightAmount(weightAmount);
        quoteTimely.setTotalAmount(baseAmount.add(weightAmount).add(calQuoteTimely.getBasePrice()));
        return quoteTimely;
    }


}
