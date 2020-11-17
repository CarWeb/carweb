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
import com.javen.model.All;
import com.javen.service.AllService;

@Controller
@RequestMapping("/all") 
public class AllController {

	@Resource  
	private AllService allService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)  
    public String all(HttpServletRequest request,Model model){
        return "All"; 
	}
	
	
	@ResponseBody
    @RequestMapping(value="/selectAll", method=RequestMethod.GET,produces = "text/json;charset=utf-8")  
    public String selectAll(HttpServletRequest request) throws Exception{  	
    	request.setCharacterEncoding("utf-8");    	
    	List<All> all = allService.selectAll();
       	String[] colums = {"id","acc","pwd","tel","admin","model","displacement","produceYear","user","mileage","caretimes","car","caredate"};
    	String data = ObjtoLayJson.ListtoJson(all, colums);
    	System.out.println(data);
        return data;
    }
	
}
