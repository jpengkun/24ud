package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.EntityUtils;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.dao.VipUserDao;
import cn.huaruan.ud24.query.entity.VipUser;
import cn.huaruan.ud24.query.entity.VipUserExample;
import cn.huaruan.ud24.vo.FindVipUserParam;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class VipUserService {

    private final VipUserDao userDao;

    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * 添加
     * @param vipUser
     * @return
     */
    public String add(VipUser vipUser){
        AppAsserts.notNull(vipUser,"vip用户不能为空");
        AppAsserts.notNull(vipUser.getType(),"用户身份不能为空");
        AppAsserts.notNull(vipUser.getUserName(),"用户名不能为空");
        VipUserExample userExample = new VipUserExample();
        userExample.createCriteria().andUserNameEqualTo(vipUser.getUserName());
        AppAsserts.yes(userDao.countByExample(userExample) < 1,
                "用户名已被使用！");
        String encodedPassword = passwordEncoder.encode(vipUser.getPassword().trim());
        vipUser.setPassword(encodedPassword);
        vipUser.setVUserId(UUIDUtil.get());
        vipUser.setCreatetime(new Date());
        vipUser.setState(1);
        userDao.insert(vipUser);
        return vipUser.getVUserId();
    }

    /**
     * 删除
     * @param ids
     */
    public void deleteUser(List<String> ids){
        AppAsserts.notEmpty(ids,"id不能为空");
        VipUserExample userExample = new VipUserExample();
        userExample.createCriteria().andVUserIdIn(ids);
        userDao.deleteByExample(userExample);
    }

    /**
     * 改
     * @param vipUser
     * @return
     */
    public long updateUser(VipUser vipUser) {
        AppAsserts.notNull(vipUser,"地址信息不能为空");
        AppAsserts.notNull(vipUser.getVUserId(), "ID不能为空！");
        if (StringUtils.hasText(vipUser.getPassword())){
            // 给密码加密
            String encodedPassword = passwordEncoder.encode(vipUser.getPassword().trim());
            vipUser.setPassword(encodedPassword);
        }
        if (EntityUtils.needToUpdate(vipUser, VipUser.class)){
            return userDao.updateByPrimaryKeySelective(vipUser);
        }
        return 0;
    }

    /**
     * 查
     * @param vipUserParam
     * @return
     */
    public Page<VipUser> findUser(FindVipUserParam vipUserParam){
        long total = userDao.countVipUser(vipUserParam);
        List<VipUser> users = userDao.findVipUserWithParam(vipUserParam);
        return new Page<>(total,users);
    }

    /**
     * 单
     * @param id
     * @return
     */
    public VipUser findOne(String id){
        AppAsserts.notNull(id,"id不能为空");
        return userDao.selectByPrimaryKey(id);
    }
}
