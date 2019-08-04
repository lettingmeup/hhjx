package com.hhjx.mage.service;

import com.hhjx.mage.bo.AboutDeployerBO;
import com.hhjx.mage.bo.AboutDeployerListBO;
import com.hhjx.mage.bo.AboutImpBO;
import com.hhjx.mage.bo.AboutScollBO;
import com.hhjx.mage.bo.AboutScollList;
import com.hhjx.mage.bo.ResultData;

public interface AboutService {
	AboutImpBO getAboutMeData();
	AboutScollList getScoll();
	AboutDeployerListBO getDeplo(AboutDeployerBO reqBO);
	ResultData delete(int id);
	ResultData insert(AboutScollBO reqBO);
	ResultData update(AboutImpBO reqBO);
	ResultData updateDep(AboutDeployerBO reqBO);
}
