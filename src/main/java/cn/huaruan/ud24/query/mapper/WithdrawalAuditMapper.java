package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.WithdrawalAudit;
import cn.huaruan.ud24.query.entity.WithdrawalAuditExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-08 00:50:53
*/
@Mapper
public interface WithdrawalAuditMapper {
    long countByExample(WithdrawalAuditExample example);

    int deleteByExample(WithdrawalAuditExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WithdrawalAudit record);

    int insertSelective(WithdrawalAudit record);

    List<WithdrawalAudit> selectByExample(WithdrawalAuditExample example);

    WithdrawalAudit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WithdrawalAudit record, @Param("example") WithdrawalAuditExample example);

    int updateByExample(@Param("record") WithdrawalAudit record, @Param("example") WithdrawalAuditExample example);

    int updateByPrimaryKeySelective(WithdrawalAudit record);

    int updateByPrimaryKey(WithdrawalAudit record);
}