package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.dao.ComplaintDao;
import cn.huaruan.ud24.query.dao.TimelyWaybillDao;
import cn.huaruan.ud24.query.dao.TimelyWbLogDao;
import cn.huaruan.ud24.query.entity.*;
import cn.huaruan.ud24.vo.ComplaintVo;
import cn.huaruan.ud24.vo.FindComplaintParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class ComplaintService {

    private final ComplaintDao complaintDao;

    private final TimelyWaybillDao timelyWaybillDao;

    private final TimelyWbLogDao timelyWbLogDao;

    private final ComplaintLogsService complaintLogsService;


    public Page<Complaint> findComplaint(FindComplaintParam findComplaintParam){
        return new Page<>(complaintDao.countComplaint(findComplaintParam),
                complaintDao.findComplaint(findComplaintParam));
    }

    public void addComplaint(Complaint complaint){
        AppAsserts.notNull(complaint.getDetail(),"投诉详情不能为空");
        AppAsserts.notNull(complaint.getType(),"类别不能为空");
        AppAsserts.notNull(complaint.getTel(),"电话不能为空");
        complaint.setId(UUIDUtil.get());
        complaint.setCreateTime(new Date());
        complaint.setState(1);
        complaintDao.insert(complaint);
    }

    public void updateComplaint(ComplaintVo complaintVo){
        complaintLogsService.addComplaintLogs(complaintVo.getComplaintLogs());
        complaintDao.updateByPrimaryKeySelective(complaintVo.getComplaint());
    }

    public void deleteComplaintList(List<String> complaintIds){
        AppAsserts.notNull(complaintIds,"id不能为空");
        ComplaintExample complaintExample = new ComplaintExample();
        complaintExample.createCriteria().andIdIn(complaintIds);
        complaintDao.deleteByExample(complaintExample);
    }


    public void addPinSingle(Complaint complaint) {
        AppAsserts.notNull(complaint.getDetail(),"投诉详情不能为空");
        AppAsserts.notNull(complaint.getTel(),"电话不能为空");
        AppAsserts.notNull(complaint.getDestroyCause(),"销单原因不能为空");
        AppAsserts.notNull(complaint.getWaybillId(),"运单id不能为空");
        complaint.setId(UUIDUtil.get());
        complaint.setTimelyWbLogState(10);
        complaint.setCreateTime(new Date());
        timelyWbLogDao.updateTimelyWbLogAndState(complaint.getTimelyWbLogState(),complaint.getWaybillId());
        complaintDao.insert(complaint);
    }

    public List<ComplaintWayBill> findByPhoneAll(ComplaintPageUtil complaintPageUtil) {
        PageHelper.startPage(complaintPageUtil.getPageNo(),complaintPageUtil.getPageSize());
        List<ComplaintWayBill> list  = new ArrayList<>();
        ComplaintWayBill complaintWayBill = new ComplaintWayBill();
        AppAsserts.notNull(complaintPageUtil.getTel(),"电话不能为空");
        List<Complaint> byPhoneAll = complaintDao.findByPhoneAll(complaintPageUtil.getTel());
        for (Complaint complaint : byPhoneAll) {
            TimelyWaybill timelyWaybill = timelyWaybillDao.findByTmNo(complaint.getWaybillId());
            complaintWayBill.setComplaint(complaint);
            complaintWayBill.setTimelyWaybill(timelyWaybill);
            list.add(complaintWayBill);
        }
        PageInfo<ComplaintWayBill> objectPageInfo = new PageInfo<>(list);
        return objectPageInfo.getList();
    }

}
