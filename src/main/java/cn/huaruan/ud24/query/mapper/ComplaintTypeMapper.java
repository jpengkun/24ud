package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.ComplaintType;
import cn.huaruan.ud24.query.entity.ComplaintTypeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-03 16:07:20
*/
@Mapper
public interface ComplaintTypeMapper {
    long countByExample(ComplaintTypeExample example);

    int deleteByExample(ComplaintTypeExample example);

    int deleteByPrimaryKey(String typeId);

    int insert(ComplaintType record);

    int insertSelective(ComplaintType record);

    List<ComplaintType> selectByExample(ComplaintTypeExample example);

    ComplaintType selectByPrimaryKey(String typeId);

    int updateByExampleSelective(@Param("record") ComplaintType record, @Param("example") ComplaintTypeExample example);

    int updateByExample(@Param("record") ComplaintType record, @Param("example") ComplaintTypeExample example);

    int updateByPrimaryKeySelective(ComplaintType record);

    int updateByPrimaryKey(ComplaintType record);
}