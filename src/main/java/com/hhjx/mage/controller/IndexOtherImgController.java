package com.hhjx.mage.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hhjx.mage.bo.IndexDataBO;
import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.service.IndexService;

@Controller
@RequestMapping("index")
public class IndexOtherImgController {
	public static String path = "D:\\SogouInput\\Desktop\\JAY\\";

	@RequestMapping(value="sideImg.do")
	@ResponseBody
	public ResultData sideImg(@RequestParam("file") MultipartFile file) {
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
            if(dest.exists()) {
            	result = new ResultData();
            	result.setBackDesc("上传失败,文件已存在");
    			result.setBackCode("9999");
    			return result;
            }
            file.transferTo(dest);
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        	result = new ResultData();
        	result.setBackDesc("上传失败");
			result.setBackCode("9999");
            return result;
        }
        result = new ResultData();
        result.setBackDesc("上传成功");
		result.setBackCode("0000");
		return result;
    
	}
	@RequestMapping(value="newsBacImg.do")
	@ResponseBody
	public ResultData newsBacImg(@RequestParam("file") MultipartFile file) {
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
            if(dest.exists()) {
            	result = new ResultData();
            	result.setBackDesc("上传失败,文件已存在");
    			result.setBackCode("9999");
    			return result;
            }
            file.transferTo(dest);
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        	result = new ResultData();
        	result.setBackDesc("上传失败");
			result.setBackCode("9999");
            return result;
        }
        result = new ResultData();
        result.setBackDesc("上传成功");
		result.setBackCode("0000");
		return result;
    
	}
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
            if(dest.exists()) {
            	result = new ResultData();
            	result.setBackDesc("上传失败,文件已存在");
    			result.setBackCode("9999");
    			return result;
            }
            file.transferTo(dest);
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        	result = new ResultData();
        	result.setBackDesc("上传失败");
			result.setBackCode("9999");
            return result;
        }
        result = new ResultData();
        result.setBackDesc("上传成功");
		result.setBackCode("0000");
		return result;
    
	}
	@RequestMapping(value="p6Img.do")
	@ResponseBody
	public ResultData p6Img(@RequestParam("file") MultipartFile file) {
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
            if(dest.exists()) {
            	result = new ResultData();
            	result.setBackDesc("上传失败,文件已存在");
    			result.setBackCode("9999");
    			return result;
            }
            file.transferTo(dest);
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        	result = new ResultData();
        	result.setBackDesc("上传失败");
			result.setBackCode("9999");
            return result;
        }
        result = new ResultData();
        result.setBackDesc("上传成功");
		result.setBackCode("0000");
		return result;
    
	}
	
}
