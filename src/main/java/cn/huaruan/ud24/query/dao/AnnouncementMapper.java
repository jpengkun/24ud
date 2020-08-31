/**
 * File Name:AnnouncementMapper
 * Package Name:com.huaruan.woho.mapper.dao
 * Date:2020-06-02
 * Copyright (c) 2019, http://www.cspos.com All Rights Reserved.
 *
 */
package cn.huaruan.ud24.query.dao;



import cn.huaruan.ud24.query.entity.Announcement;
import cn.huaruan.ud24.query.mapper.BaseMapper;

import java.util.List;

public interface AnnouncementMapper extends BaseMapper<String, Announcement, Announcement> {

    List<Announcement> queryByIds(List<String> list);

    Integer queryCount(String userId);

    void updataeStatus(String userId);
}