package com.hhjx.mage.service;

import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.bo.SystemCliBO;
import com.hhjx.mage.bo.SystemCliListBO;
import com.hhjx.mage.bo.SystemFaBO;
import com.hhjx.mage.bo.SystemFaListBO;

public interface SystemFaService {
	
	SystemFaListBO getFaData();
	SystemCliListBO getCliData(SystemCliBO reqBO);
	ResultData deleteFaById(int id);
	ResultData insertFaData(SystemFaBO reqBO);
	ResultData deleteCli(int id);
	ResultData addCli(SystemCliBO reqBO);
}
