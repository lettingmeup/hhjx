package com.hhjx.mage.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhjx.mage.bo.AboutDeployerBO;
import com.hhjx.mage.bo.AboutDeployerListBO;
import com.hhjx.mage.bo.AboutImpBO;
import com.hhjx.mage.bo.AboutScollBO;
import com.hhjx.mage.bo.AboutScollList;
import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.service.AboutService;


@Controller
@RequestMapping("aboutMe")
public class AboutMeController {
	@Autowired
	private AboutService aboutService;
	@RequestMapping(value="getAboutMeData.do")
	@ResponseBody
	public AboutImpBO getAboutMeData() {
		AboutImpBO result = aboutService.getAboutMeData();
		return result;
	}
	  
	@RequestMapping(value="getAboutScoll.do")
	@ResponseBody
	public AboutScollList getAboutScoll() {
		AboutScollList result = aboutService.getScoll();
		return result;
	}
	
	@RequestMapping(value="getAboutDep.do")
	@ResponseBody
	public AboutDeployerListBO getAboutDep(@RequestBody AboutDeployerBO reqBO) {
		AboutDeployerListBO result = aboutService.getDeplo(reqBO);
		return result;
	}
	
	@RequestMapping(value="delete.do")
	@ResponseBody
	public ResultData delete(@RequestBody AboutScollBO reqBO) {
		ResultData result = aboutService.delete(reqBO.getId());
		return result;
	}
	
	@RequestMapping(value="insert.do")
	@ResponseBody
	public ResultData insert(@RequestBody AboutScollBO reqBO) {
		ResultData result = aboutService.insert(reqBO);
		return result;
	}
	
	@RequestMapping(value="update.do")
	@ResponseBody
	public ResultData update(@RequestBody AboutImpBO reqBO) {
		ResultData result = aboutService.update(reqBO);
		return result;
	}
	
	@RequestMapping(value="updateDep.do")
	@ResponseBody
	public ResultData updateDep(@RequestBody AboutDeployerBO reqBO) {
		ResultData result = aboutService.updateDep(reqBO);
		return result;
	}
	
	
}
	


