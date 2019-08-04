package com.hhjx.mage.service;

import com.hhjx.mage.bo.ImgBO;
import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.bo.TeamMateBO;
import com.hhjx.mage.bo.TeamMateListBO;

public interface TeamMateService {
	TeamMateListBO getMate(TeamMateBO reqBO);
	ImgBO getTeamImg();
	ResultData delMate(TeamMateBO reqBO);
	ResultData addMate(TeamMateBO reqBO);
	ResultData updateImg(ImgBO reqBO);
	TeamMateListBO getAllMate();
}
