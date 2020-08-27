package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.Complaint;
import cn.huaruan.ud24.query.mapper.ComplaintMapper;
import cn.huaruan.ud24.vo.FindComplaintParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintDao extends ComplaintMapper {

    List<Complaint> findComplaint(FindComplaintParam findComplaintParam);

    long countComplaint(FindComplaintParam findComplaintParam);

}
