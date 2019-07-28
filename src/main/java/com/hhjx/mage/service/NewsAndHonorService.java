package com.hhjx.mage.service;

import com.hhjx.mage.bo.NewsAndHonorListBO;

public interface NewsAndHonorService {
	
	NewsAndHonorListBO getList(String status);
	NewsAndHonorListBO getNewsByTitle(String title);
	
}
