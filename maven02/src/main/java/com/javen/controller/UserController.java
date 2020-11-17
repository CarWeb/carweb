package com.javen.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javan.util.ObjtoLayJson;
import com.javen.service.UserService;

@Controller
@RequestMapping("/user") 
public class UserController {  
	
	@Resource  
	private UserService userService;     
 
    @RequestMapping(value="/test", method=RequestMethod.GET)  
    public String test(HttpServletRequest request,Model model){  
        return "back"; 
    }    
   
    @ResponseBody
    @RequestMapping(value="/selectAll", method=RequestMethod.GET,produces = "text/json;charset=utf-8")  
    public String selectAll(HttpServletRequest request) throws Exception{  	
    	request.setCharacterEncoding("utf-8");    	
    	List<com.javen.model.User> users = userService.selectAll();
       	String[] colums = {"id","acc","pwd","tel","admin"};
    	String data = ObjtoLayJson.ListtoJson(users, colums);
    	System.out.println(data);
        return data;
    }
    @ResponseBody
    @RequestMapping(value="/deleteByPrimaryKey", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String deleteByPrimaryKey(HttpServletRequest request) {
    	String  idString = request.getParameter("id");
    	Integer idInteger = Integer.valueOf(idString);
    	System.out.println("id");
    	userService.deleteByPrimaryKey(idInteger);
    	String data = "{\"data\":\"删除成功\"}";
    	System.out.println(data);
        return data; 
    }
    @ResponseBody
    @RequestMapping(value="/insert", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String insert(HttpServletRequest request) {
    	
    	String accString = request.getParameter("acc");
    	String pwdString = request.getParameter("pwd");
    	String telString = request.getParameter("tel");
    	String adminString = request.getParameter("admin");
    	Long TelLong = Long.valueOf(telString);
    	Integer AdminInteger = Integer.valueOf(adminString);
    	com.javen.model.User user = new com.javen.model.User();
    	user.setPwd(pwdString);
       	user.setAcc(accString);
       	user.setTel(TelLong); //这里报错需要转换类型
    	user.setAdmin(AdminInteger); //zhe ye yi yang
    	userService.insert(user);
       	String data = "{\"data\":\"成功了\"}";
       	System.out.println(data);
        return data; 
    }
    @ResponseBody
    @RequestMapping(value="/update", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String update(HttpServletRequest request) {
    	//閹绘帒鍙嗛弫鐗堝祦鎼达拷
    	String idString = request.getParameter("id");
    	String accString = request.getParameter("acc");
    	String pwdString = request.getParameter("pwd");
    	String telString = request.getParameter("tel");
    	String adminString = request.getParameter("admin");
    	Integer idInteger = Integer.valueOf(idString);
    	Long TelLong = Long.valueOf(telString);
    	Integer AdminInteger = Integer.valueOf(adminString);
    	System.out.println(idString+accString);
    	com.javen.model.User user = new com.javen.model.User();
    	user.setId(idInteger);
    	user.setPwd(pwdString);
       	user.setAcc(accString);
       	user.setTel(TelLong); //这里报错需要转换类型
    	user.setAdmin(AdminInteger);
      	userService.updateByPrimaryKey(user);
    	String data = "{\"data\":\"更新成功\"}";
    	System.out.println(data);
        return data; 
    }
}  









