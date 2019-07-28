package com.hhjx.mage.service;

import com.hhjx.mage.bo.TeamMateBO;
import com.hhjx.mage.bo.TeamMateListBO;

public interface TeamMateService {
	TeamMateListBO getMate(TeamMateBO reqBO);
}
