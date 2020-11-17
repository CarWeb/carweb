package com.javen.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.javan.util.ObjtoLayJson;
import com.javen.model.HCar;
import com.javen.model.HCare;
import com.javen.model.Login;
import com.javen.model.HUser;
import com.javen.service.HCarService;
import com.javen.service.HUserService;

@Controller  
@RequestMapping("/Huser") 
public class HUserController {  
	
	private static Logger log=LoggerFactory.getLogger(HUserController.class);
	
	@Resource  
	private HUserService huserService;     
   
    @ResponseBody
    @RequestMapping(value="/hupdate", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String hupdate(HttpServletRequest request) {
    	String idString = request.getParameter("id");
    	String tel = request.getParameter("tel");
    	String acc = request.getParameter("acc");
    	Integer idInteger = Integer.valueOf(idString);
    	Integer htel = Integer.valueOf(tel);
//    	System.out.println(idString);
//    	System.out.println(tel);
//    	System.out.println(acc);
    	HUser huser = new HUser();
    	huser.setId(idInteger);
    	huser.setTel(htel);
    	huser.setAcc(acc);
    	huserService.updateById(huser);
    	String data = "{\"data\":\"返回成功\"}"; 
        return data; 
    }   
}  









