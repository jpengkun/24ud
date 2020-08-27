package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.EntityUtils;
import cn.huaruan.ud24.application.common.TimeUtils;
import cn.huaruan.ud24.application.common.TreeUtils;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.dao.ExpectTimeDao;
import cn.huaruan.ud24.query.entity.ExpectTime;
import cn.huaruan.ud24.query.entity.ExpectTimeExample;
import cn.huaruan.ud24.vo.ExpectTimeWithOrganization;
import cn.huaruan.ud24.vo.FindExpectTimeParam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Throwable.class)
@AllArgsConstructor
public class ExpectTimeService {

    private final ExpectTimeDao expectTimeDao;

    /**
     * 添加
     * @param expectTime
     * @return
     */
    public long addExpectTime(ExpectTime expectTime){
        AppAsserts.notNull(expectTime,"班车不能为空");
        AppAsserts.notNull(expectTime.getOid(),"所属网点不能为空");
        return expectTimeDao.insert(expectTime);
    }

    /**
     * 根据id删除
     * @param ids
     * @return
     */
    public long deleteExpect(List<Integer> ids){
        AppAsserts.notEmpty(ids,"id不能为空");
        ExpectTimeExample expectTimeExample = new ExpectTimeExample();
        expectTimeExample.createCriteria().andIdIn(ids);
        return expectTimeDao.deleteByExample(expectTimeExample);
    }

    /**
     * 修改
     * @param expectTime
     * @return
     */
    public long updateExpect(ExpectTime expectTime){
        AppAsserts.notNull(expectTime,"班车不能为空");
        AppAsserts.notNull(expectTime.getOid(),"所属网点不能为空");
        AppAsserts.notNull(expectTime.getId(),"id不能为空");
        if (EntityUtils.needToUpdate(expectTime,ExpectTime.class)){
            return expectTimeDao.updateByPrimaryKey(expectTime);
        }
        return 0;
    }

    /**
     * 根据网点查找班车时间，如果没有则返回默认时间
     * @param timeParam
     * @return
     */
    public Page<ExpectTimeWithOrganization> findExpectTimeByOid(FindExpectTimeParam timeParam){
        long total = expectTimeDao.countExpectTime(timeParam);
        List<ExpectTimeWithOrganization> expectTimeList = expectTimeDao.findExpectTime(timeParam);
        if (expectTimeList.size()<1) {
            ExpectTime e1 = new ExpectTime();
            e1.setStartTime("8:00");
            e1.setEndTime("11:00");
            ExpectTime e2 = new ExpectTime();
            e2.setStartTime("13:00");
            e2.setEndTime("16:00");
            ExpectTime e3 = new ExpectTime();
            e3.setStartTime("18:00");
            e3.setEndTime("21:00");
            List<ExpectTime> expectTimes = new ArrayList<>();
            expectTimes.add(e1);
            expectTimes.add(e2);
            expectTimes.add(e3);
            ExpectTimeWithOrganization ex = new ExpectTimeWithOrganization();
            ex.setTimes(expectTimes);
            ex.setOid("0");
            ex.setPid("0");
            ex.setName("总部");
            expectTimeList.add(ex);
            return new Page<>(total,expectTimeList);
        }
        List<ExpectTimeWithOrganization> organizationList = TreeUtils.toTree(expectTimeList,
                ArrayList::new,
                ExpectTimeWithOrganization::getOid,
                ExpectTimeWithOrganization::getPid,
                ExpectTimeWithOrganization::getChildren,
                ExpectTimeWithOrganization::setChildren);
        return new Page<>(total,organizationList);
    }
}
