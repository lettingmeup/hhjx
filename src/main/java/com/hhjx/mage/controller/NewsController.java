package com.hhjx.mage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhjx.mage.bo.NewsAndHonorBO;
import com.hhjx.mage.bo.NewsAndHonorListBO;
import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.service.NewsAndHonorService;

@Controller
@RequestMapping("news")
public class NewsController {
	@Autowired
	private NewsAndHonorService newsAndHonorService;
	
	@RequestMapping(value="getNewsTitle.do")
	@ResponseBody
	public NewsAndHonorListBO getNewsTitle(@RequestBody NewsAndHonorBO reqBO) {
		NewsAndHonorListBO result = newsAndHonorService.getList(reqBO.getStatus());
				return result;
	}
	
	@RequestMapping(value="getNewsByTitle.do")
	@ResponseBody
	public NewsAndHonorListBO getNewsByTitle(@RequestBody NewsAndHonorBO reqBO) {
		NewsAndHonorListBO result = newsAndHonorService.getNewsByTitle(reqBO.getTitle());
				return result;
	}
	
	@RequestMapping(value="delete.do")
	@ResponseBody
	public ResultData delete(@RequestBody NewsAndHonorBO reqBO) {
		ResultData result = newsAndHonorService.delete(reqBO.getTitle());
				return result;
	}
	
	@RequestMapping(value="insert.do")
	@ResponseBody
	public ResultData insert(@RequestBody List<NewsAndHonorBO> reqBO) {
		ResultData result = newsAndHonorService.insertList(reqBO);
				return result;
	}

}
