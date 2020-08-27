package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.VipUser;
import cn.huaruan.ud24.query.entity.VipUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-09 19:54:10
*/
@Mapper
public interface VipUserMapper {
    long countByExample(VipUserExample example);

    int deleteByExample(VipUserExample example);

    int deleteByPrimaryKey(String vUserId);

    int insert(VipUser record);

    int insertSelective(VipUser record);

    List<VipUser> selectByExample(VipUserExample example);

    VipUser selectByPrimaryKey(String vUserId);

    int updateByExampleSelective(@Param("record") VipUser record, @Param("example") VipUserExample example);

    int updateByExample(@Param("record") VipUser record, @Param("example") VipUserExample example);

    int updateByPrimaryKeySelective(VipUser record);

    int updateByPrimaryKey(VipUser record);
}