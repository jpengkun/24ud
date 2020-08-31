package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.entity.Complaint;
import cn.huaruan.ud24.query.mapper.ComplaintMapper;
import cn.huaruan.ud24.vo.FindComplaintParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintDao extends ComplaintMapper {

    List<Complaint> findComplaint(FindComplaintParam findComplaintParam);

    long countComplaint(FindComplaintParam findComplaintParam);

    List<Complaint> findByPhoneAll(@Param("tel") String tel);
}
