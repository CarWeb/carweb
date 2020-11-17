package com.javen.dao;



import java.util.List;

import com.javen.model.HCar;
import com.javen.model.HCare;
import com.javen.model.Login;
import com.javen.model.HUser;


public interface HUserDao {
	
	HUser selectById(int id);
	
	int updateById(HUser user);
	
}
