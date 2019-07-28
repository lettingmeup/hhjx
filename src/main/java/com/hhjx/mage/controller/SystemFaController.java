package com.hhjx.mage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhjx.mage.bo.SystemCliBO;
import com.hhjx.mage.bo.SystemCliListBO;
import com.hhjx.mage.bo.SystemFaListBO;
import com.hhjx.mage.service.SystemFaService;

@Controller
@RequestMapping("system")
public class SystemFaController {
	@Autowired
	private SystemFaService systemFaService;
	@RequestMapping(value="getFaData.do")
	@ResponseBody
	public SystemFaListBO getFaData() {
		SystemFaListBO result = systemFaService.getFaData();
		return result;
	}
	
	@RequestMapping(value="getCliData.do")
	@ResponseBody
	public SystemCliListBO getCliData(@RequestBody SystemCliBO reqBO) {
		SystemCliListBO result = systemFaService.getCliData(reqBO);
		return result;
	}
}
