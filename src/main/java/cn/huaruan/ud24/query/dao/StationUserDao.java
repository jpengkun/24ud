package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.StationUser;
import cn.huaruan.ud24.query.mapper.StationUserMapper;
import cn.huaruan.ud24.vo.FindStationUserParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationUserDao extends StationUserMapper {

    long countStation(FindStationUserParam userParam);

    List<StationUser> findStationWithSub(FindStationUserParam userParam);
}
