package com.javen.dao;



import java.util.List;

import com.javen.model.HCar;
import com.javen.model.HCare;
import com.javen.model.Login;


public interface HCareDao {
	
	HCare selectById(int id);
	
	int insert(HCare care);
	
	int updateById(HCare care);
	
}
