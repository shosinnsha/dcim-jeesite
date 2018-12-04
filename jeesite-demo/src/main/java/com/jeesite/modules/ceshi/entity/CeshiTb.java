/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.ceshi.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * ceshi_tbEntity
 * @author navider
 * @version 2018-11-14
 */
@Table(name="ceshi_tb", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="name", attrName="name", label="name", queryType=QueryType.LIKE),
		@Column(name="password", attrName="password", label="password"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class CeshiTb extends DataEntity<CeshiTb> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String password;		// password
	
	public CeshiTb() {
		this(null);
	}

	public CeshiTb(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="name长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=64, message="password长度不能超过 64 个字符")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}