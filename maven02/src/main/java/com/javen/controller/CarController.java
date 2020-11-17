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
import com.javen.model.Car;
import com.javen.service.CarService;


@Controller
@RequestMapping("/car") 
public class CarController {  

	@Resource  
	private CarService carService;     
 
	@RequestMapping(value="/admin", method=RequestMethod.GET)  
    public String admin(HttpServletRequest request,Model model){
        return "back"; 
	}
   
    @ResponseBody
    @RequestMapping(value="/selectAll", method=RequestMethod.GET,produces = "text/json;charset=utf-8")  
    public String selectAll(HttpServletRequest request) throws Exception{  	
    	request.setCharacterEncoding("utf-8");    	
    	List<Car> cars = carService.selectAll();
       	String[] colums = {"id","model","displacement","produceYear","user"};
    	String data = ObjtoLayJson.ListtoJson(cars, colums);
    	System.out.println(data);
        return data;
    }
    @ResponseBody
    @RequestMapping(value="/insert", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String insert(HttpServletRequest request) {
       	String modelString = request.getParameter("model");
       	String displacementString = request.getParameter("displacement");
    	String produceYearString = request.getParameter("produceYear");
    	//String userString = request.getParameter("user");
       	Double  DisplacementDouble=Double.valueOf(displacementString);
    	Integer ProduceYearInteger = Integer.valueOf(produceYearString);
    	//Integer UserInteger = Integer.valueOf(userString);
    	com.javen.model.Car car = new com.javen.model.Car();
    	car.setModel(modelString);
       	car.setDisplacement(DisplacementDouble); 
       	car.setProduceYear(ProduceYearInteger); 
      
   		carService.insert(car);
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
    	carService.deleteByPrimaryKey(idInteger);
    	String data = "{\"data\":\"删除成功\"}";
    	System.out.println(data);
        return data; 
    }
    @ResponseBody
    @RequestMapping(value="/update", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String update(HttpServletRequest request) {
    	String idString = request.getParameter("id");
    	String modelString = request.getParameter("model");
       	String displacementString = request.getParameter("displacement");
    	String produceYearString = request.getParameter("produceYear");
    	//String userString = request.getParameter("user");
    	Integer idInteger = Integer.valueOf(idString);
    	Double  DisplacementDouble=Double.valueOf(displacementString);
    	Integer ProduceYearInteger = Integer.valueOf(produceYearString);
    	//Integer UserInteger = Integer.valueOf(userString);
    	com.javen.model.Car car = new com.javen.model.Car();
    	car.setId(idInteger);
    	car.setModel(modelString);
       	car.setDisplacement(DisplacementDouble); 
       	car.setProduceYear(ProduceYearInteger); 
       	
   		carService.updateByPrimaryKey(car);
    	String data = "{\"data\":\"更新成功\"}";
    	System.out.println(data);
        return data; 
}  

}







