/**  
 * Project Name:cs-pos-common
 * File Name:Page.java  
 * Package Name:com.cspos.common.mapper.common  
 * Copyright (c) 2020, http://www.cspos.com All Rights Reserved.  
 *  
*/  
  
package cn.huaruan.ud24.query.entity;

import cn.huaruan.ud24.constant.CollectionUtil;
import cn.huaruan.ud24.constant.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * ClassName: Page <br/>  
 * Description: 通用.  <br/>  
 * date: 2020年3月4日 下午12:42:10 <br/>  
 *  
 * @author haiming.huang  
 *
 */
@ApiModel("分页公共类")
public class PageHai implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("当前页")
	private Integer pageNo = 1;
	
	@ApiModelProperty("每页条数")
	private Integer pageSize = 10;
	
	@ApiModelProperty("排序字段  多个用逗号隔开 如：  name,email")
	private String sort;
	
	@ApiModelProperty("排序类型 和keySort属性一一对应 如： asc,desc")
	private String order;
	
	@ApiModelProperty("生成排序sql")
	private String orderSql;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@JsonIgnore
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	@JsonIgnore
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@JsonIgnore
	public String getOrderSql() {
		String orderSql = "";
		List<String> keySortList = CollectionUtil.string2List(StringUtil.field2Column(sort));
		List<String> orderList = CollectionUtil.string2List(order);
		if(CollectionUtil.isEmpty(orderList) || CollectionUtil.isEmpty(keySortList)){
			return orderSql;
		}
		int keySortListSize = keySortList.size();
		for(int i = 0; i < keySortListSize; i++) {
			String column = keySortList.get(i);
			if(keySortList.get(i).contains(".")) {
				column = keySortList.get(i).substring(keySortList.get(i).lastIndexOf('.') + 1);
			}
			orderSql += column  + " " + orderList.get(i) + "," ;
		}
		return  StringUtil.removeLast(orderSql);
	}

	public void setOrderSql(String orderSql) {
		this.orderSql = orderSql;
	}
	
}
  
