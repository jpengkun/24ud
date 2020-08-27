package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.VipUser;
import cn.huaruan.ud24.query.mapper.VipUserMapper;
import cn.huaruan.ud24.vo.FindVipUserParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VipUserDao extends VipUserMapper {

    long countVipUser(FindVipUserParam userParam);

    List<VipUser> findVipUserWithParam(FindVipUserParam userParam);
}
