package com.hhjx.mage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhjx.mage.bo.NewsAndHonorBO;
import com.hhjx.mage.bo.NewsAndHonorListBO;
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

}
