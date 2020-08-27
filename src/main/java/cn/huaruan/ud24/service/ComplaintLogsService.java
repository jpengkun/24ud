package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.query.dao.ComplaintLogsDao;
import cn.huaruan.ud24.query.entity.ComplaintLogs;
import cn.huaruan.ud24.query.entity.ComplaintLogsExample;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class ComplaintLogsService {

    private final ComplaintLogsDao complaintLogsDao;


    public List<ComplaintLogs> findById(String complaintId){
        AppAsserts.notNull(complaintId,"投诉id不能为空");
        ComplaintLogsExample complaintLogsExample = new ComplaintLogsExample();
        complaintLogsExample.createCriteria().andComplaintIdEqualTo(complaintId);
        return complaintLogsDao.selectByExample(complaintLogsExample);
    }

    public void addComplaintLogs(ComplaintLogs complaintLogs){
        AppAsserts.notNull(complaintLogs.getComplaintId(),"投诉id不能为空");
        complaintLogs.setLogId(UUIDUtil.get());
        complaintLogs.setLogTime(new Date());
        complaintLogsDao.insert(complaintLogs);
    }




}
