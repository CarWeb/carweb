package com.javen.service;

import java.util.List;

import com.javen.model.HCar;
import com.javen.model.HCare;
import com.javen.model.Login;



public interface HCareService {
	
	
	 public HCare selectById(int id);
	
	 public int insert(HCare care);
	 
	 public int updateById(HCare care);
	 
}
