package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.EntityUtils;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.dao.StationUserDao;
import cn.huaruan.ud24.query.entity.StationUser;
import cn.huaruan.ud24.query.entity.StationUserExample;
import cn.huaruan.ud24.vo.FindStationUserParam;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Throwable.class)
@AllArgsConstructor
public class StationUserService {

    private final StationUserDao stationUserDao;

    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * 添加账号
     * @param stationUser
     * @return
     */
    public String addStationUser(StationUser stationUser){
        AppAsserts.notNull(stationUser,"站点账号不能为空");
        AppAsserts.notNull(stationUser.getOid(),"所属网点id不能为空");
        AppAsserts.notNull(stationUser.getOrgName(),"所属网点名称不能为空");
        AppAsserts.notNull(stationUser.getPhone(),"手机号不能为空");
        StationUserExample userExample = new StationUserExample();
        userExample.createCriteria().andPhoneEqualTo(stationUser.getPhone());
        AppAsserts.yes(stationUserDao.countByExample(userExample)<1,"手机号重复");
        if (StringUtils.hasText(stationUser.getPassword())){
            String encodedPassword = passwordEncoder.encode(stationUser.getPassword().trim());
            stationUser.setPassword(encodedPassword);
        } else {
            String encodedPassword = passwordEncoder.encode("666666".trim());
            stationUser.setPassword(encodedPassword);
        }
        stationUser.setCreateTime(new Date());
        stationUser.setId(UUIDUtil.get());
        stationUserDao.insert(stationUser);
        return stationUser.getId();
    }

    /**
     * 修改
     * @param stationUser
     * @return
     */
    public long updateStationUser(StationUser stationUser){
        AppAsserts.notNull(stationUser,"站点账号不能为空");
        AppAsserts.notNull(stationUser.getId(),"账号id不能为空");
        AppAsserts.notNull(stationUser.getOid(),"所属网点id不能为空");
        AppAsserts.notNull(stationUser.getOrgName(),"所属网点名称不能为空");
        AppAsserts.notNull(stationUser.getPhone(),"手机号不能为空");
        StationUserExample userExample = new StationUserExample();
        userExample.createCriteria().andPhoneEqualTo(stationUser.getPhone()).andPhoneNotEqualTo(stationUser.getPhone());
        AppAsserts.yes(stationUserDao.countByExample(userExample)<1,"手机号重复");
        if (StringUtils.hasText(stationUser.getPassword())) {
            String encodedPassword = passwordEncoder.encode(stationUser.getPassword().trim());
            stationUser.setPassword(encodedPassword);
        }
        if (EntityUtils.needToUpdate(stationUser,StationUser.class)){
            return stationUserDao.updateByPrimaryKeySelective(stationUser);
        }
        return 0;
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    public long deleteStationUserByIds(List<String> ids){
        AppAsserts.notEmpty(ids,"id不能为空");
        StationUserExample userExample = new StationUserExample();
        userExample.createCriteria().andIdIn(ids);
        return stationUserDao.deleteByExample(userExample);
    }

    /**
     * 条件查询
     * @param findStationUserParam
     * @return
     */
    public Page<StationUser> findStationUserByParam(FindStationUserParam findStationUserParam){
        long total = stationUserDao.countStation(findStationUserParam);
        List<StationUser> stationUsers = stationUserDao.findStationWithSub(findStationUserParam);
        return new Page<>(total,stationUsers);
    }

    /**
     * 查找单个
     * @param id
     * @return
     */
    public StationUser findStationUserById(String id){
        AppAsserts.notNull(id,"id不能为空");
        return stationUserDao.selectByPrimaryKey(id);
    }
}
