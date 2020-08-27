package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.VipAddress;
import cn.huaruan.ud24.query.mapper.VipAddressMapper;
import cn.huaruan.ud24.vo.FindVipAddressParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VipAddressDao extends VipAddressMapper {

    long countAddress(FindVipAddressParam addressParam);

    List<VipAddress> findVipAddressWithParam(FindVipAddressParam addressParam);
}
