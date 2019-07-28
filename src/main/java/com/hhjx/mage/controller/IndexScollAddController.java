package com.hhjx.mage.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hhjx.mage.bo.IndexDataBO;
import com.hhjx.mage.bo.IndexImgListReqBo;
import com.hhjx.mage.bo.IndexScollBO;
import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.service.IndexService;

@Controller
@RequestMapping("index")
public class IndexScollAddController {
	public static String path = "D:\\SogouInput\\Desktop\\JAY\\";
@Autowired
private IndexService indexService;
      
	@RequestMapping(value="getIndexData.do")
	@ResponseBody
	public IndexDataBO getIndexData() {
		IndexDataBO result = indexService.getIndexData();
		return result;
	}

     @RequestMapping(value="updateIndexData.do")
     @ResponseBody
     public ResultData updateIndexData(@RequestBody IndexDataBO reqBO){
    	 ResultData result = indexService.update(reqBO);
		return result;
    	 
     }

	@RequestMapping(value="getIndexImgList.do")
	@ResponseBody
	public IndexImgListReqBo getIndexImg() {
		IndexImgListReqBo result = indexService.getIndexImg();
		return result;
	}
	
	@RequestMapping(value="getInput.do")
	@ResponseBody
	public ResultData getInput(@RequestParam("file") MultipartFile file) {
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
            IndexScollBO reqBO = new IndexScollBO();
            reqBO.setSrc("http://49.232.53.207/imgs/"+fileName);
            result = indexService.addImg(reqBO);
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        	result = new ResultData();
        	result.setBackDesc("上传失败");
			result.setBackCode("9999");
            return result;
        }
		return result;
    
	}
	@RequestMapping(value="deleteImg.do")
	@ResponseBody
	public ResultData delete(@RequestBody IndexScollBO reqBO) {
		ResultData result = indexService.deldte(reqBO);
		return result;
		
	}
}
