package com.javen.dao;



import java.util.List;

import com.javen.model.HCar;
import com.javen.model.Login;


public interface HCarDao {
	
	 List<HCar> selectById(int user);
	
	int insert(HCar car);
	
}
