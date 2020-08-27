package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.QuestionWaybill;
import cn.huaruan.ud24.query.mapper.QuestionWaybillMapper;
import cn.huaruan.ud24.vo.FindQuestionWaybillParam;
import cn.huaruan.ud24.vo.QuestionWithType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionWaybillDao extends QuestionWaybillMapper {

    long contQuestion(FindQuestionWaybillParam findQuestionWaybillParam);

    List<QuestionWithType> findWithSubQuestion(FindQuestionWaybillParam waybillParam);

}
