package com.javen.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.javan.util.ObjtoLayJson;
import com.javen.model.Care;
import com.javen.service.CareService;


@Controller  //
@RequestMapping("/care") 
public class CareController {  
	
	@Resource  
	private CareService careService;     
 
    @ResponseBody
    @RequestMapping(value="/selectAll", method=RequestMethod.GET,produces = "text/json;charset=utf-8")  
    public String selectAll(HttpServletRequest request) throws Exception{  	
    	request.setCharacterEncoding("utf-8");    	
    	List<Care> cares = careService.selectAll();
       	String[] colums = {"id","mileage","caretimes","car","caredate"};
    	String data = ObjtoLayJson.ListtoJson(cares, colums);
    	System.out.println(data);
    	
        return data;
    }
    @ResponseBody
    @RequestMapping(value="/insert", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String insert(HttpServletRequest request) {
       	String mileageString = request.getParameter("mileage");
       	String caretimesString = request.getParameter("caretimes");
    	String carString = request.getParameter("car");
    	String caredateString = request.getParameter("caredate");
       
    	Integer MileageInteger = Integer.valueOf(mileageString);
    	Integer CaretimesInteger = Integer.valueOf(caretimesString);
    	Integer CarInteger = Integer.valueOf(carString);
    	Integer CaredateInteger = Integer.valueOf(caredateString);
    	com.javen.model.Care care = new com.javen.model.Care();
    	care.setMileage(MileageInteger);
       	care.setCaretimes(CaretimesInteger); 
       	care.setCar(CarInteger); 
       	care.setCaredate(CaredateInteger); 
   		careService.insert(care);
       	String data = "{\"data\":\"成功了\"}";
       	System.out.println(data);
        return data; 
    }
    @ResponseBody
    @RequestMapping(value="/deleteByPrimaryKey", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String deleteByPrimaryKey(HttpServletRequest request) {
    	String  idString = request.getParameter("id");
    	Integer idInteger = Integer.valueOf(idString);
    	System.out.println("id");
    	careService.deleteByPrimaryKey(idInteger);
    	String data = "{\"data\":\"删除成功\"}";
    	System.out.println(data);
        return data; 
    }
    @ResponseBody
    @RequestMapping(value="/update", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String update(HttpServletRequest request) {
    	String idString = request.getParameter("id");
    	String mileageString = request.getParameter("mileage");
       	String caretimesString = request.getParameter("caretimes");
    	String carString = request.getParameter("car");
    	String caredateString = request.getParameter("caredate");
       	Integer idInteger = Integer.valueOf(idString);
    	Integer MileageInteger = Integer.valueOf(mileageString);
    	Integer CaretimesInteger = Integer.valueOf(caretimesString);
    	Integer CarInteger = Integer.valueOf(carString);
    	Integer CaredateInteger = Integer.valueOf(caredateString);
    	com.javen.model.Care care = new com.javen.model.Care();
    	care.setId(idInteger);
    	care.setMileage(MileageInteger);
       	care.setCaretimes(CaretimesInteger); 
       	care.setCar(CarInteger); 
       	care.setCaredate(CaredateInteger); 
   		
   		careService.updateByPrimaryKey(care);
    	String data = "{\"data\":\"更新成功\"}";
    	System.out.println(data);
        return data; 
}  
}







