package com.hhjx.mage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhjx.mage.bo.AboutImpBO;
import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.bo.TelentBO;
import com.hhjx.mage.bo.TelentListBO;
import com.hhjx.mage.service.TelentService;

@Controller
@RequestMapping("telent")
public class TelentController {
	@Autowired
	private TelentService telentService;
	
	@RequestMapping(value="getTelent.do")
	@ResponseBody
	public TelentListBO getTelent() {
		TelentListBO result = telentService.getTelent();
		return result;
	}
	@RequestMapping(value="updateTelent.do")
	@ResponseBody
	public ResultData updateTelent(@RequestBody TelentBO reqBO) {
		ResultData result = telentService.updateTelent(reqBO);
		return result;
	}

}
