package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.StationUser;
import cn.huaruan.ud24.query.entity.StationUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-02 10:12:29
*/
@Mapper
public interface StationUserMapper {
    long countByExample(StationUserExample example);

    int deleteByExample(StationUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(StationUser record);

    int insertSelective(StationUser record);

    List<StationUser> selectByExample(StationUserExample example);

    StationUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StationUser record, @Param("example") StationUserExample example);

    int updateByExample(@Param("record") StationUser record, @Param("example") StationUserExample example);

    int updateByPrimaryKeySelective(StationUser record);

    int updateByPrimaryKey(StationUser record);
}