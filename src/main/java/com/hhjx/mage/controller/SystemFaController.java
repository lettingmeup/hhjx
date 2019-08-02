package com.hhjx.mage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.bo.SystemCliBO;
import com.hhjx.mage.bo.SystemCliListBO;
import com.hhjx.mage.bo.SystemFaBO;
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
	
	@RequestMapping(value="deleteFaById.do")
	@ResponseBody
	public ResultData deleteFaById(@RequestBody SystemFaBO reqBO) {
		ResultData result = systemFaService.deleteFaById(reqBO.getId());
		return result;
	}
	@RequestMapping(value="insertfaData.do")
	@ResponseBody
	public ResultData insertfaData(@RequestBody SystemFaBO reqBO) {
		ResultData result = systemFaService.insertFaData(reqBO);
		return result;
	}
	@RequestMapping(value="deleteCli.do")
	@ResponseBody
	public ResultData deleteCli(@RequestBody SystemCliBO reqBO) {
		ResultData result = systemFaService.deleteCli(reqBO.getId());
		return result;
	}
	@RequestMapping(value="addCli.do")
	@ResponseBody
	public ResultData addCli(@RequestBody SystemCliBO reqBO) {
		ResultData result = systemFaService.addCli(reqBO);
		return result;
	}
}
