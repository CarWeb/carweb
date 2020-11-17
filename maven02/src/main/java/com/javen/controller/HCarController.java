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
import com.javen.model.Login;
import com.javen.service.HCarService;

@Controller  
@RequestMapping("/Hcar") 
public class HCarController {  
	
	private static Logger log=LoggerFactory.getLogger(HCarController.class);
	
	@Resource  
	private HCarService hcarService;     
    
    // /user/test?id=1
    @RequestMapping(value="/user", method=RequestMethod.GET)  
    public String user(HttpServletRequest request,Model model){  
        return "Hlogin"; 
    }
    

    @ResponseBody
    @RequestMapping(value="/selectById", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String selectById(HttpServletRequest request) throws Exception{  
    	String  idString = request.getParameter("id");
    	Integer userid = Integer.valueOf(idString);
    	List<HCar> car = hcarService.selectById(userid);
    	JSONObject jsonObject = new JSONObject();
      	String jString =jsonObject.toJSONString(car);
      	System.out.println(jString);
        return jString; 
        
        
    }
        
    
    @ResponseBody
    @RequestMapping(value="/insert", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String insert(HttpServletRequest request) {
    	String  idString = request.getParameter("id");
    	Integer id = Integer.valueOf(idString);
    	String model = request.getParameter("model");
    	String displacement = request.getParameter("displacement");
    	String produceYear = request.getParameter("produceYear");
    	Double hdisplacement = Double.valueOf(displacement);
    	Integer hproduceYear = Integer.valueOf(produceYear);
//    	System.out.println(id);
//    	System.out.println(model);
//    	System.out.println(displacement);
//    	System.out.println(produceYear);
//    	System.out.println(buyDate);
    	HCar hcar = new HCar();
    	hcar.setUser(id);
    	hcar.setDisplacement(hdisplacement);
    	hcar.setModel(model);
    	hcar.setProduceYear(hproduceYear);
    	
    	hcarService.insert(hcar);
    	String data = "{\"data\":\"成功了\\"}"; 
        return data; 
    }
}  









