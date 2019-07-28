package com.hhjx.mage.service;

import com.hhjx.mage.bo.AboutDeployerBO;
import com.hhjx.mage.bo.AboutDeployerListBO;
import com.hhjx.mage.bo.AboutImpBO;
import com.hhjx.mage.bo.AboutScollList;

public interface AboutService {
	AboutImpBO getAboutMeData();
	AboutScollList getScoll();
	AboutDeployerListBO getDeplo(AboutDeployerBO reqBO);
}
