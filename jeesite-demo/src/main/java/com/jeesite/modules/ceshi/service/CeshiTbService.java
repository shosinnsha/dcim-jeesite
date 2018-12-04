/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.ceshi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ceshi.entity.CeshiTb;
import com.jeesite.modules.ceshi.dao.CeshiTbDao;

/**
 * ceshi_tbService
 * @author navider
 * @version 2018-11-14
 */
@Service
@Transactional(readOnly=true)
public class CeshiTbService extends CrudService<CeshiTbDao, CeshiTb> {
	
	/**
	 * 获取单条数据
	 * @param ceshiTb
	 * @return
	 */
	@Override
	public CeshiTb get(CeshiTb ceshiTb) {
		return super.get(ceshiTb);
	}
	
	/**
	 * 查询分页数据
	 * @param ceshiTb 查询条件
	 * @param ceshiTb.page 分页对象
	 * @return
	 */
	@Override
	public Page<CeshiTb> findPage(CeshiTb ceshiTb) {
		return super.findPage(ceshiTb);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param ceshiTb
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CeshiTb ceshiTb) {
		super.save(ceshiTb);
	}
	
	/**
	 * 更新状态
	 * @param ceshiTb
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CeshiTb ceshiTb) {
		super.updateStatus(ceshiTb);
	}
	
	/**
	 * 删除数据
	 * @param ceshiTb
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CeshiTb ceshiTb) {
		super.delete(ceshiTb);
	}
	
}