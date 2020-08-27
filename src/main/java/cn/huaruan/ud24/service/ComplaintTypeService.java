package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.query.dao.ComplaintTypeDao;
import cn.huaruan.ud24.query.entity.ComplaintType;
import cn.huaruan.ud24.query.entity.ComplaintTypeExample;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("all")
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class ComplaintTypeService {

    private final ComplaintTypeDao complaintTypeDao;


    public List<ComplaintType> findComplaintTypeList(ComplaintType complaintType) {
        return complaintTypeDao.findComplaintType(complaintType);
    }

    public void addComplaintType(ComplaintType complaintType) {
        AppAsserts.notNull(complaintType.getTypeName(), "投诉类型名称不能为空");
        ComplaintTypeExample nameExample = new ComplaintTypeExample();
        nameExample.createCriteria().andTypeNameEqualTo(complaintType.getTypeName());
        AppAsserts.no(complaintTypeDao.countByExample(nameExample) > 0, "投诉类型名称已重复");
        complaintType.setTypeId(UUIDUtil.get());
        complaintTypeDao.insert(complaintType);
    }

    public void updateComplaintType(ComplaintType complaintType) {
        List<ComplaintType> complaintTypeList = complaintTypeDao.findAll();
        ComplaintType complaintTypes = complaintTypeDao.selectByPrimaryKey(complaintType.getTypeId());
        if(complaintTypes.getTypeName().equals(complaintType.getTypeName())){
            complaintTypeDao.updateByPrimaryKeySelective(complaintType);
            return;
        }
        for (int i = 0; i < complaintTypeList.size(); i++) {
            if(complaintType.getTypeName().equals(complaintTypeList.get(i).getTypeName())){
                AppAsserts.no(true,"投诉类型名称已重复");
            }
        }
        complaintTypeDao.updateByPrimaryKeySelective(complaintType);
    }

    public void deleteComplaintTypeList(List<String> complaintTypeIds) {
        AppAsserts.notNull(complaintTypeIds, "id不能为空");
        ComplaintTypeExample complaintTypeExample = new ComplaintTypeExample();
        complaintTypeExample.createCriteria().andTypeIdIn(complaintTypeIds);
        complaintTypeDao.deleteByExample(complaintTypeExample);
    }


}
