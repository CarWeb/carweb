package com.javen.service;

import java.util.List;

import com.javen.model.HCar;
import com.javen.model.Login;



public interface HCarService {
	
	
	 public List<HCar> selectById(int user);
	
	 public int insert(HCar car);
	
	 
}
