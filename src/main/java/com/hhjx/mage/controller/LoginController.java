package com.hhjx.mage.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.bo.User;
import com.hhjx.mage.util.Aes;


@RestController
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(value="login")
	@ResponseBody
	public ResultData login(@RequestBody User a,HttpServletResponse response) {
		ResultData result = null;
		try {
			String name = a.getName();
			String pass = a.getPass();
			if(!"admin".equals(name)) {
				result = new ResultData();
				result.setBackCode("9999");
				result.setBackDesc("用户名错误");
				return result;
			}
			if(!"A123456".equals(pass)) {
				result = new ResultData();
				result.setBackCode("9999");
				result.setBackDesc("密码错误");
				return result;
			}
			String token = name+"+==+"+pass+"=++=";
			String to = Aes.aesEncrypt(token,"abcdefgabcdefg12");
			Cookie cookie = new Cookie("_objc-9889",to);
		    cookie.setPath("/");
		    cookie.setMaxAge(15*24*60*60*1000);
		    response.addCookie(cookie);
		    result = new ResultData();
			result.setBackCode("0000");
			result.setBackDesc("登陆成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new ResultData();
			result.setBackCode("9999");
			result.setBackDesc("网络异常");
			return result;
		}
		return result;
	}
	
	@RequestMapping(value="getlogin")
	@ResponseBody
	public ResultData getLoginInfo(HttpServletResponse response,HttpServletRequest request) {
		ResultData result = new ResultData();
		Cookie[] cookies = request.getCookies();
        
	    if (cookies != null && cookies.length >0) {
	        for (Cookie cookie : cookies) {
	        	if("_objc-9889".equals(cookie.getName())) {
	        		try {
						String detail = Aes.aesDecrypt(cookie.getValue(),"abcdefgabcdefg12");
						String name = detail.substring(0, detail.indexOf("+==+"));
						String pass = detail.substring(detail.indexOf("+==+")+4, detail.indexOf("=++="));
						if("admin".equals(name)&&"A123456".equals(pass)) {
							result.setBackCode("0000");
							result.setBackDesc("登陆成功");
						}else {
							result.setBackCode("9999");
							result.setBackDesc("用户名或密码错误");
							return result;
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						result.setBackCode("9999");
						result.setBackDesc("网络错误");
						return result;
					}
	        	}
	            
	        }
	    }else {
	    	result.setBackCode("9999");
			result.setBackDesc("用户未登陆");
			return result;
	    }
		return result;
	}
	
}
