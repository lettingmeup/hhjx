package com.hhjx.mage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhjx.mage.bo.IndexBlockBO;
import com.hhjx.mage.bo.IndexBlockListBO;

import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.service.IndexBlockService;


@Controller
@RequestMapping("index")
public class IndexBlockController {
	@Autowired
	private IndexBlockService indexBlockService;
	
	@RequestMapping(value="getIndexBlock.do")
	@ResponseBody
	public IndexBlockListBO getIndexBlock() {
		IndexBlockListBO result = indexBlockService.getIndexBlock();
		return result;
	}
	@RequestMapping(value="updateIndexBlock.do")
	@ResponseBody
	public ResultData updateIndexBlock(@RequestBody IndexBlockBO reqBO) {
		ResultData result = indexBlockService.updateIndexBlock(reqBO);
		return result;
	}
}
