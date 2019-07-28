package com.hhjx.mage.service;

import com.hhjx.mage.bo.IndexBlockBO;
import com.hhjx.mage.bo.IndexBlockListBO;
import com.hhjx.mage.bo.ResultData;

public interface IndexBlockService {
	IndexBlockListBO getIndexBlock();
	ResultData updateIndexBlock(IndexBlockBO reqBO);
}
