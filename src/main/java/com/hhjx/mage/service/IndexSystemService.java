package com.hhjx.mage.service;

import com.hhjx.mage.bo.IndexSystemBO;
import com.hhjx.mage.bo.IndexSystemListBO;
import com.hhjx.mage.bo.ResultData;

public interface IndexSystemService {
	IndexSystemListBO getIndexSystem();
	ResultData updateIndexSystem(IndexSystemBO reqBO);
}
