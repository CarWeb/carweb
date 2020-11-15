package com.javen.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.javen.model.Login;
import com.javen.service.LoginService;

@Controller 
@RequestMapping("/login") 
public class LoginController {  
	
	@Resource  
	private LoginService loginService;
	
	@ResponseBody
    @RequestMapping(value="/showtable", method=RequestMethod.GET,produces = "text/json;charset=utf-8")  
    public String showtable(HttpServletRequest request) throws Exception{
    	request.setCharacterEncoding("utf-8");
    	List<Login> list = loginService.selectAll();
    	String json = JSON.toJSONString(list);
    	System.out.println(json);
		return json;
    }
    
    @ResponseBody
    @RequestMapping(value="/selectByName", method=RequestMethod.GET,produces = "text/json;charset=utf-8")  
    public String selectByName(HttpServletRequest request) throws Exception{
    	request.setCharacterEncoding("utf-8");
    	String  acc = request.getParameter("acc");
    	String  pwd = request.getParameter("pwd");
    	if(acc == ""||acc.equals("")||acc.length()==0) {
    		System.out.println("账号输入为空");
    		return null;
    	}
    	else if(pwd == ""||pwd.equals("")||pwd.length()==0) {
    		System.out.println("密码输入为空");
    		return null;
    	}
    	else {
    		System.out.println("用户请求登录..  账号: "+acc+" 密码: "+pwd+"");
        	Login login = loginService.selectByName(acc);
        	String json = JSON.toJSONString(login);
        	System.out.println(json);
        	if(acc.length() == 0||pwd.length() == 0) {
        		return "0";
        	}else{
        		return json;
        	}
		}
    	
    }
    @ResponseBody
    @RequestMapping(value="/ChangePwdByName", method=RequestMethod.GET,produces = "text/json;charset=utf-8")  
    public String ChangePwdByName(HttpServletRequest request) throws Exception{
    	request.setCharacterEncoding("utf-8");
    	String  acc = request.getParameter("acc");
    	Login login = loginService.selectByName(acc);
    	String json = JSON.toJSONString(login);
    	return json;
    }
    @ResponseBody
    @RequestMapping(value="/SignUpByName", method=RequestMethod.GET,produces = "text/json;charset=utf-8")  
    public String SignUpByName(HttpServletRequest request) throws Exception{
    	request.setCharacterEncoding("utf-8");
    	String  acc = request.getParameter("acc");
    	Login login = loginService.selectByName(acc);
    	String json = JSON.toJSONString(login);
    	return json;
    }
    @ResponseBody
    @RequestMapping(value="/loginCode", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String loginCode(HttpServletRequest request) throws Exception{
    	request.setCharacterEncoding("utf-8");
    	String  codeString = request.getParameter("code");
    	Integer code = Integer.valueOf(codeString);
    	if(code == 1) {
    		System.out.println("登录成功!");
    	}else if(code == 0) {
    		System.out.println("密码错误..登录失败!");
    	}else {
			System.out.println("error");
		}
		return null;
    }
    @ResponseBody
    @RequestMapping(value="/selectAll", method=RequestMethod.GET,produces = "text/json;charset=utf-8")  
    public String selectAll(HttpServletRequest request) throws Exception{
    	request.setCharacterEncoding("utf-8");
    	List<Login> list = loginService.selectAll();
    	String json = JSON.toJSONString(list);
    	System.out.println(json);
		return json;
    }
    @ResponseBody
    @RequestMapping(value="/insert", method=RequestMethod.GET,produces = "text/json;charset=utf-8")  
    public String insert(HttpServletRequest request) throws Exception{
    	request.setCharacterEncoding("utf-8");
    	String acc = request.getParameter("acc");
    	String pwd = request.getParameter("pwd");
    	String telString = request.getParameter("tel");
    	Long tel = Long.valueOf(telString);
    	Login login = new Login();
    	login.setAcc(acc);
    	login.setPwd(pwd);
    	login.setTel(tel);
    	login.setAdmin(0);
    	loginService.insert(login);
    	System.out.println("用户请求注册: acc:"+acc+" pwd:"+pwd+" tel:"+tel+"");
    	return null;
    }
    @ResponseBody
    @RequestMapping(value="/insertCode", method=RequestMethod.GET,produces = "text/json;charset=utf-8")  
    public String insertCode(HttpServletRequest request) throws Exception{
    	request.setCharacterEncoding("utf-8");
    	String  codeString = request.getParameter("code");
    	Integer code = Integer.valueOf(codeString);
    	if(code == 1) {
    		System.out.println("注册成功!");
    	}else {
			System.out.println("注册失败!");
		}
    	String  acc = request.getParameter("acc");
    	Login login = loginService.selectByName(acc);
    	String json = JSON.toJSONString(login);
    	return json;
    }
    @ResponseBody
    @RequestMapping(value="/UpdateByAcc", method=RequestMethod.GET,produces = "text/json;charset=utf-8")  
    public String UpdateByAcc(HttpServletRequest request) throws Exception{
    	request.setCharacterEncoding("utf-8");
    	String  acc = request.getParameter("acc");
    	String  pwd = request.getParameter("password");
    	Login login = new Login();
    	login.setAcc(acc);
    	login.setPwd(pwd);
    	loginService.updateByAcc(login);
    	return null;
    }
    @ResponseBody
    @RequestMapping(value="/UpdateByAccCode", method=RequestMethod.GET,produces = "text/json;charset=utf-8")  
    public String UpdateByAccCode(HttpServletRequest request) throws Exception{
    	request.setCharacterEncoding("utf-8");
    	String codeString = request.getParameter("code");
    	Integer code = Integer.valueOf(codeString);
    	if(code == 1) {
    		System.out.println("修改密码成功!");
    	}
    	else {
    		System.out.println("修改密码失败!");
    	}
    	return null;
    }
}  











