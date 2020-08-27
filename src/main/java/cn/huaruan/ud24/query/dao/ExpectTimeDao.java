package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.mapper.ExpectTimeMapper;
import cn.huaruan.ud24.vo.ExpectTimeWithOrganization;
import cn.huaruan.ud24.vo.FindExpectTimeParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpectTimeDao extends ExpectTimeMapper {

    long countExpectTime(FindExpectTimeParam expectTimeParam);

    List<ExpectTimeWithOrganization> findExpectTime(FindExpectTimeParam expectTimeParam);
}
