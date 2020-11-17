package com.javen.service;

import java.util.List;

import com.javen.model.HCar;
import com.javen.model.HCare;
import com.javen.model.Login;
import com.javen.model.HUser;



public interface HUserService {
	
	
	 public HUser selectById(int id);

	 
	 public int updateById(HUser user);


	 
}
