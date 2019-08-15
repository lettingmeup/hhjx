package com.hhjx.mage.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hhjx.mage.bo.ImgBO;
import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.bo.TeamMateBO;
import com.hhjx.mage.bo.TeamMateListBO;
import com.hhjx.mage.service.TeamMateService;

@Controller
@RequestMapping("team")
public class TeamMateController {
	@Autowired
	private TeamMateService teamMateService;
	public static String path = "/usr/local/tomcat/apache-tomcat-9.0.22/webapps/imgs/";
	public static String url="http://www.hhjxedu.com/imgs/";
	@RequestMapping(value="teamImg.do")
	@ResponseBody
	public ResultData teamImg(@RequestParam("file") MultipartFile file) {
		ResultData result = null;
		if (file.isEmpty()) {
			result = new ResultData();
			result.setBackDesc("上传失败，请选择文件");
			result.setBackCode("9999");
            return result;
        }
		
		String fileName = file.getOriginalFilename();
       
        String filePath = path;
        try {
            File dest = new File(filePath+fileName);
            file.transferTo(dest);
            ImgBO bo = new ImgBO();
            bo.setId(1);
            bo.setImg(url+fileName);
            result = teamMateService.updateImg(bo);
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        	result = new ResultData();
        	result.setBackDesc("上传失败");
			result.setBackCode("9999");
            return result;
        }
		return result;
    
	}
	
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
	
	@RequestMapping(value="delMate.do")
	@ResponseBody
	public ResultData delMate(@RequestBody TeamMateBO reqBO) {
		ResultData result = teamMateService.delMate(reqBO);
		return result;
	}
	
	@RequestMapping(value="addMate.do")
	@ResponseBody
	public ResultData addMate(@RequestBody TeamMateBO reqBO) {
		ResultData result = teamMateService.addMate(reqBO);
		return result;
	}
	
	@RequestMapping(value="getAll.do")
	@ResponseBody
	public TeamMateListBO getAll() {
		TeamMateListBO result = teamMateService.getAllMate();
		return result;
	}
}
