package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.dao.HCarDao;
import com.javen.dao.HCareDao;
import com.javen.dao.HUserDao;
import com.javen.model.HCar;
import com.javen.model.HCare;
import com.javen.model.Login;
import com.javen.model.HUser;
import com.javen.service.HCarService;
import com.javen.service.HCareService;
import com.javen.service.HUserService;

@Service
public class HUserServiceImpl implements HUserService{

	@Resource
	private HUserDao huserDao;

	public HUser selectById(int id) {
		// TODO Auto-generated method stub
		return huserDao.selectById(id);
	}

	public int updateById(HUser care) {
		// TODO Auto-generated method stub
		return huserDao.updateById(care);
	}


	
	
}
