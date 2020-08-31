/**
 * File Name:UserJpushRelMapper
 * Package Name:com.huaruan.woho.mapper.dao
 * Date:2020-05-15
 * Copyright (c) 2019, http://www.cspos.com All Rights Reserved.
 *
 */
package cn.huaruan.ud24.query.dao;


import cn.huaruan.ud24.query.entity.UserJpushRel;
import cn.huaruan.ud24.query.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserJpushRelMapper extends BaseMapper<String, UserJpushRel, UserJpushRel> {

    int uptateByUserIdJpushId(UserJpushRel userJpushRel);

    List<UserJpushRel> findByUserId(@Param("userId") String userId);

    int uptateJpushIdByUserId(UserJpushRel userJpushRel);

    UserJpushRel exists(@Param("userId") String userId);

    List<UserJpushRel> selectRegistrationId(@Param("type") Integer type);


    List<UserJpushRel> selectRegistrationIdByUserId(String userId);

    String selectUserId(String registraionId);
}