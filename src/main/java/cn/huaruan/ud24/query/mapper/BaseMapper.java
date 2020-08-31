/**  
 * File Name:BaseMapper.java  
 * Copyright (c) 2020, http://www.cspos.com All Rights Reserved.  
 *  
*/

package cn.huaruan.ud24.query.mapper;



import cn.huaruan.ud24.query.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: BaseMapper <br/>  
 * Description: 公共接口增删改查 <br/>  
 * date: 2020年3月4日 下午12:44:02 <br/>  
 *  
 * @author haiming.huang  
 *
 * @param <ID>
 * @param <Example>
 * @param <T>
 */
public interface BaseMapper<ID extends Serializable, Example extends BaseEntity<?>, T extends BaseEntity<?>> {

    /**
     * 根据主键删除
     */
    int deleteByPrimaryKey(ID id);

    /**
     * 插入数据，不判空
     */
    int insert(T record);

    /**
     * 插入数据，判空
     */
    int insertSelective(T record);

    /**
     * 分页查询
     */
    List<T> query(Example example);

    /**
     * 根据主键查询
     */
    T selectByPrimaryKey(ID id);


    /**
     * 根据主键查询，判空
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 根据主键查询，不判空
     */
    int updateByPrimaryKey(T record);

}
