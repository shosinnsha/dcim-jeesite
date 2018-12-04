/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.ceshi.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ceshi.entity.CeshiTb;
import com.jeesite.modules.ceshi.service.CeshiTbService;

/**
 * ceshi_tbController
 * @author navider
 * @version 2018-11-14
 */
@Controller
@RequestMapping(value = "${adminPath}/ceshi/ceshiTb")
public class CeshiTbController extends BaseController {

	@Autowired
	private CeshiTbService ceshiTbService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public CeshiTb get(String id, boolean isNewRecord) {
		return ceshiTbService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("ceshi:ceshiTb:view")
	@RequestMapping(value = {"list", ""})
	public String list(CeshiTb ceshiTb, Model model) {
		model.addAttribute("ceshiTb", ceshiTb);
		return "modules/ceshi/ceshiTbList";
	}
	
	
	/**
	 * 试一下新主页能不能用 
	 * 
	 */
	@RequiresPermissions("ceshi:ceshiTb:view")
	@RequestMapping(value = {"index"})
	public String list1(CeshiTb ceshiTb, Model model) {
		model.addAttribute("ceshiTb", ceshiTb);
		return "modules/ceshi/ceshiTbIndex";
	}
	
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("ceshi:ceshiTb:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CeshiTb> listData(CeshiTb ceshiTb, HttpServletRequest request, HttpServletResponse response) {
		ceshiTb.setPage(new Page<>(request, response));
		Page<CeshiTb> page = ceshiTbService.findPage(ceshiTb); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("ceshi:ceshiTb:view")
	@RequestMapping(value = "form")
	public String form(CeshiTb ceshiTb, Model model) {
		model.addAttribute("ceshiTb", ceshiTb);
		return "modules/ceshi/ceshiTbForm";
	}

	/**
	 * 保存ceshi_tb
	 */
	@RequiresPermissions("ceshi:ceshiTb:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CeshiTb ceshiTb) {
		ceshiTbService.save(ceshiTb);
		return renderResult(Global.TRUE, text("保存ceshi_tb成功！"));
	}
	
	/**
	 * 删除ceshi_tb
	 */
	@RequiresPermissions("ceshi:ceshiTb:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CeshiTb ceshiTb) {
		ceshiTbService.delete(ceshiTb);
		return renderResult(Global.TRUE, text("删除ceshi_tb成功！"));
	}
	
}