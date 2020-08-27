package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.ComplaintLogs;
import cn.huaruan.ud24.query.entity.ComplaintLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-11-27 10:07:17
*/
@Mapper
public interface ComplaintLogsMapper {
    long countByExample(ComplaintLogsExample example);

    int deleteByExample(ComplaintLogsExample example);

    int deleteByPrimaryKey(String logId);

    int insert(ComplaintLogs record);

    int insertSelective(ComplaintLogs record);

    List<ComplaintLogs> selectByExample(ComplaintLogsExample example);

    ComplaintLogs selectByPrimaryKey(String logId);

    int updateByExampleSelective(@Param("record") ComplaintLogs record, @Param("example") ComplaintLogsExample example);

    int updateByExample(@Param("record") ComplaintLogs record, @Param("example") ComplaintLogsExample example);

    int updateByPrimaryKeySelective(ComplaintLogs record);

    int updateByPrimaryKey(ComplaintLogs record);
}