package com.hhjx.mage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhjx.mage.bo.ImgBO;
import com.hhjx.mage.bo.TeamMateBO;
import com.hhjx.mage.bo.TeamMateListBO;
import com.hhjx.mage.service.TeamMateService;

@Controller
@RequestMapping("team")
public class TeamMateController {
	@Autowired
	private TeamMateService teamMateService;
	
	@RequestMapping(value="getTeamMate.do")
	@ResponseBody
	public TeamMateListBO getTeamMate(@RequestBody TeamMateBO reqBO) {
		TeamMateListBO result = teamMateService.getMate(reqBO);
		return result;
	}
	
	@RequestMapping(value="getTeamImg.do")
	@ResponseBody
	public ImgBO getTeamImg() {
		ImgBO result = teamMateService.getTeamImg();
		return result;
	}
}
