package com.hhjx.mage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhjx.mage.bo.IndexDataBO;
import com.hhjx.mage.bo.IndexSystemBO;
import com.hhjx.mage.bo.IndexSystemListBO;
import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.service.IndexSystemService;

@Controller
@RequestMapping("index")
public class IndexSystemController {
	@Autowired
	private IndexSystemService indexSystemService;
	
	@RequestMapping(value="getIndexSystem.do")
	@ResponseBody
	public IndexSystemListBO getIndexSystem() {
		IndexSystemListBO result = indexSystemService.getIndexSystem();
		return result;
	}
	
	@RequestMapping(value="updateSystem.do")
	@ResponseBody
	public ResultData updateSystem(@RequestBody IndexSystemBO reqBO) {
		ResultData result = indexSystemService.updateIndexSystem(reqBO);
		return result;
	}
}
