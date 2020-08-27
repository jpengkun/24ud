package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.EntityUtils;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.dao.QuestionWaybillDao;
import cn.huaruan.ud24.query.entity.QuestionWaybill;
import cn.huaruan.ud24.query.entity.QuestionWaybillExample;
import cn.huaruan.ud24.vo.FindQuestionWaybillParam;
import cn.huaruan.ud24.vo.QuestionWithType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class QuestionWaybillService {

    private final QuestionWaybillDao waybillDao;

    /**
     * 添加
     * @param waybill
     */
    public long addQuestion(QuestionWaybill waybill){
        AppAsserts.notNull(waybill,"问题件详情不能为空");
        AppAsserts.notNull(waybill.getWaybillId(),"问题件id不能为空");
        AppAsserts.notNull(waybill.getType(),"问题件问题类型不能为空");
        waybill.setQuestionStatus(0);
        waybill.setCreatTime(new Date());
        return waybillDao.insert(waybill);
    }

    /**
     * 根据id删除
     * @param ids
     * @return
     */
    public long deleteQuestion(List<Integer> ids){
        AppAsserts.notEmpty(ids,"id不能为空");
        QuestionWaybillExample waybillExample = new QuestionWaybillExample();
        waybillExample.createCriteria().andIdIn(ids);
        return waybillDao.deleteByExample(waybillExample);
    }

    /**
     * 修改
     * @param waybill
     * @return
     */
    public long updateQuestion(QuestionWaybill waybill){
        AppAsserts.notNull(waybill,"问题件详情不能为空");
        AppAsserts.notNull(waybill.getId(),"问题件id不能为空");
        AppAsserts.notNull(waybill.getWaybillId(),"问题件id不能为空");
        AppAsserts.notNull(waybill.getQuestionType(),"问题件问题类型不能为空");
        AppAsserts.notNull(waybill.getType(),"问题件所属类型不能为空");
        if (EntityUtils.needToUpdate(waybill,QuestionWaybill.class)){
            return waybillDao.updateByPrimaryKeySelective(waybill);
        }
        return 0;
    }

    /**
     * 查找单个
     * @param id
     * @return
     */
    public QuestionWaybill findOne(Integer id){
        AppAsserts.notNull(id,"问题件id不能为空");
        return waybillDao.selectByPrimaryKey(id);
    }

    /**
     * 条件查询
     * @param findQuestionWaybillParam
     * @return
     */
    public Page<QuestionWithType> finQuestion(FindQuestionWaybillParam findQuestionWaybillParam){
        long total = waybillDao.contQuestion(findQuestionWaybillParam);
        List<QuestionWithType> questionWithTypes = waybillDao.findWithSubQuestion(findQuestionWaybillParam);
        return new Page<>(total,questionWithTypes);
    }
}
