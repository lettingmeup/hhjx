package com.hhjx.mage.service;

import java.util.List;

import com.hhjx.mage.bo.NewsAndHonorBO;
import com.hhjx.mage.bo.NewsAndHonorListBO;
import com.hhjx.mage.bo.ResultData;

public interface NewsAndHonorService {
	ResultData delete(String title);
	NewsAndHonorListBO getList(String status);
	NewsAndHonorListBO getNewsByTitle(String title);
	ResultData insertList(List<NewsAndHonorBO> list);
}
