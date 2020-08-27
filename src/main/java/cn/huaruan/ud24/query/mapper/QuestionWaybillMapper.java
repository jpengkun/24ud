package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.QuestionWaybill;
import cn.huaruan.ud24.query.entity.QuestionWaybillExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-05 19:53:05
*/
@Mapper
public interface QuestionWaybillMapper {
    long countByExample(QuestionWaybillExample example);

    int deleteByExample(QuestionWaybillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuestionWaybill record);

    int insertSelective(QuestionWaybill record);

    List<QuestionWaybill> selectByExample(QuestionWaybillExample example);

    QuestionWaybill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QuestionWaybill record, @Param("example") QuestionWaybillExample example);

    int updateByExample(@Param("record") QuestionWaybill record, @Param("example") QuestionWaybillExample example);

    int updateByPrimaryKeySelective(QuestionWaybill record);

    int updateByPrimaryKey(QuestionWaybill record);
}