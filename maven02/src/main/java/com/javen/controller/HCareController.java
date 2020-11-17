package com.javen.controller;


import java.sql.Date;
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
import com.javen.service.HCarService;
import com.javen.service.HCareService;

@Controller  
@RequestMapping("/Hcare") 
public class HCareController {  
	
	private static Logger log=LoggerFactory.getLogger(HCareController.class);
	
	@Resource  
	private HCareService hcareService;     
       
	@ResponseBody
    @RequestMapping(value="/selectById", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String selectById(HttpServletRequest request) throws Exception{  
    	String  idString = request.getParameter("id");
    	Integer userid = Integer.valueOf(idString);
    	//List<HCar> car = hcareService.selectById(userid);
    	JSONObject jsonObject = new JSONObject();
      	//String jString =jsonObject.toJSONString(car);
      	//System.out.println(jString);
        return null; 
        
        
    }
	
    @ResponseBody
    @RequestMapping(value="/update", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String update(HttpServletRequest request) {
    	String idString = request.getParameter("id");
    	String mileage = request.getParameter("mileage");
    	String careDate = request.getParameter("careDate");
    	Date hcareDate = Date.valueOf(careDate);
    	Integer idInteger = Integer.valueOf(idString);
    	Integer careTimesInteger = Integer.valueOf(mileage);
    	HCare hcare = new HCare();
    	Integer careTimes = hcare.getCareTimes();
    	careTimes++;
    	hcare.setId(idInteger);
    	hcare.setMileage(careTimesInteger);
    	hcare.setCareTimes(careTimes);
    	hcare.setCareDate(hcareDate);
    	hcareService.updateById(hcare);
    	String data = "{\"data\":\"成功了\\"}"; 
        return data; 
    }   
  
}  









