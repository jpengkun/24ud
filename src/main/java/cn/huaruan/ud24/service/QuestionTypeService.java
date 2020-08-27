package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.EntityUtils;
import cn.huaruan.ud24.query.dao.QuestionTypeDao;
import cn.huaruan.ud24.query.entity.QuestionType;
import cn.huaruan.ud24.query.entity.QuestionTypeExample;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Throwable.class)
@AllArgsConstructor
public class QuestionTypeService {

    private final QuestionTypeDao typeDao;

    /**
     * 添加
     * @param questionType
     * @return
     */
    public long addType(QuestionType questionType){
        AppAsserts.notNull(questionType,"问题件类型不能为空");
        AppAsserts.notNull(questionType.getTypeContent(),"类型内容不能为空");
        return typeDao.insert(questionType);
    }

    /**
     * 查找所有
     * @return
     */
    public List<QuestionType> findQuestion(){
        return typeDao.selectByExample(null);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    public long deleteType(List<Integer> ids){
        AppAsserts.notNull(ids,"id不能为空");
        QuestionTypeExample questionTypeExample = new QuestionTypeExample();
        questionTypeExample.createCriteria().andIdIn(ids);
        return typeDao.deleteByExample(questionTypeExample);
    }

    /**
     * 修改
     * @param questionType
     * @return
     */
    public long updateType(QuestionType questionType){
        AppAsserts.notNull(questionType,"问题件类型不能为空");
        AppAsserts.notNull(questionType.getTypeContent(),"类型内容不能为空");
        AppAsserts.notNull(questionType.getId(),"类型id不能为空");
        if (EntityUtils.needToUpdate(questionType,QuestionType.class)){
            return typeDao.updateByPrimaryKeySelective(questionType);
        }
        return 0;
    }

    /**
     * 查找一个
     * @param id
     * @return
     */
    public QuestionType findOne(Integer id){
        AppAsserts.notNull(id,"id不能为空");
        return typeDao.selectByPrimaryKey(id);
    }
}
