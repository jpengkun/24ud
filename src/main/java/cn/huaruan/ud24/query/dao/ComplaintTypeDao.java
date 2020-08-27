package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.ComplaintType;
import cn.huaruan.ud24.query.mapper.ComplaintTypeMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintTypeDao extends ComplaintTypeMapper {

    List<ComplaintType> findComplaintType(ComplaintType complaintType);
    List<ComplaintType> findAll();
}
