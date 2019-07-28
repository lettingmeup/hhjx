package com.hhjx.mage.service;

import com.hhjx.mage.bo.SystemCliBO;
import com.hhjx.mage.bo.SystemCliListBO;
import com.hhjx.mage.bo.SystemFaListBO;

public interface SystemFaService {
	
	SystemFaListBO getFaData();
	SystemCliListBO getCliData(SystemCliBO reqBO);
}
