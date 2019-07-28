package com.hhjx.mage.controller;

import com.hhjx.mage.bo.ContacBO;
import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.service.ContacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("contact")
public class ContacController {
    public static String path="E:\\asiainfo\\";
    @Autowired
    private ContacService contacService;
    @RequestMapping(value="getContacImgList.do")
    @ResponseBody
    public ContacBO getIndexImg() {
        ContacBO result = contacService.selectAll();
        return result;
    }
    //修改QQ图片
    @RequestMapping(value="getQQ.do")
    @ResponseBody
    public ResultData getQQ(@RequestParam("file") MultipartFile file) {
        ResultData result = null;
        if (file.isEmpty()) {
            result = new ResultData();
            result.setBackDesc("上传失败，请选择文件");
            result.setBackCode("9999");
            return result;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss:SSS");//设置日期格式
        String fileName = file.getOriginalFilename();
        String data = df.format(new Date());
        String filePath = path;
        try {
            File dest = new File(filePath+fileName);
            file.transferTo(dest);
            ContacBO reqBO = new ContacBO();
            reqBO.setQq("http://www.hhjxedu.com/imgs/"+fileName);
            result = contacService.updateImg(reqBO);
        } catch (IOException e) {
            e.printStackTrace();
            result = new ResultData();
            result.setBackDesc("上传失败");
            result.setBackCode("9999");
            return result;
        }
        return result;
    }
    //修改微信图片
    @RequestMapping(value="getWechat.do")
    @ResponseBody
    public ResultData getWechat(@RequestParam("file") MultipartFile file) {
        ResultData result = null;
        if (file.isEmpty()) {
            result = new ResultData();
            result.setBackDesc("上传失败，请选择文件");
            result.setBackCode("9999");
            return result;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss:SSS");//设置日期格式
        String fileName = file.getOriginalFilename();
        String data = df.format(new Date());
        String filePath = path;
        try {
            File dest = new File(filePath+fileName);
            file.transferTo(dest);
            ContacBO reqBO = new ContacBO();
            reqBO.setWechat("http://www.hhjxedu.com/imgs/"+fileName);
            result = contacService.updateImg(reqBO);
        } catch (IOException e) {
            e.printStackTrace();
            result = new ResultData();
            result.setBackDesc("上传失败");
            result.setBackCode("9999");
            return result;
        }
        return result;
    }

    @RequestMapping(value="getBackground.do")
    @ResponseBody
    public ResultData getBackground(@RequestParam("file") MultipartFile file) {
        ResultData result = null;
        if (file.isEmpty()) {
            result = new ResultData();
            result.setBackDesc("上传失败，请选择文件");
            result.setBackCode("9999");
            return result;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss:SSS");//设置日期格式
        String fileName = file.getOriginalFilename();
        String data = df.format(new Date());
        String filePath = path;
        try {
            File dest = new File(filePath+fileName);
            file.transferTo(dest);
            ContacBO reqBO = new ContacBO();
            reqBO.setBackground("http://www.hhjxedu.com/imgs/"+fileName);
            result = contacService.updateImg(reqBO);
        } catch (IOException e) {
            e.printStackTrace();
            result = new ResultData();
            result.setBackDesc("上传失败");
            result.setBackCode("9999");
            return result;
        }
        return result;
    }

}
