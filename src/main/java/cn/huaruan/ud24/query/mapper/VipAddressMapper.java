package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.VipAddress;
import cn.huaruan.ud24.query.entity.VipAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-09 19:54:10
*/
@Mapper
public interface VipAddressMapper {
    long countByExample(VipAddressExample example);

    int deleteByExample(VipAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VipAddress record);

    int insertSelective(VipAddress record);

    List<VipAddress> selectByExample(VipAddressExample example);

    VipAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VipAddress record, @Param("example") VipAddressExample example);

    int updateByExample(@Param("record") VipAddress record, @Param("example") VipAddressExample example);

    int updateByPrimaryKeySelective(VipAddress record);

    int updateByPrimaryKey(VipAddress record);
}