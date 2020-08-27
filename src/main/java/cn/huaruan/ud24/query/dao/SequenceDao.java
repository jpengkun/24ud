package cn.huaruan.ud24.query.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface SequenceDao {

    Integer nextVal(String name);
}
