package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.Aaa;
import cn.huaruan.ud24.query.entity.AaaExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AaaMapper {
    long countByExample(AaaExample example);

    int deleteByExample(AaaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Aaa record);

    int insertSelective(Aaa record);

    List<Aaa> selectByExample(AaaExample example);

    Aaa selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Aaa record, @Param("example") AaaExample example);

    int updateByExample(@Param("record") Aaa record, @Param("example") AaaExample example);

    int updateByPrimaryKeySelective(Aaa record);

    int updateByPrimaryKey(Aaa record);
}