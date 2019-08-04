package com.hhjx.mage.service;

import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.bo.TelentBO;
import com.hhjx.mage.bo.TelentListBO;

public interface TelentService {
	TelentListBO getTelent();
	ResultData updateTelent(TelentBO reqBO);
}
