package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.dao.HCarDao;
import com.javen.model.HCar;
import com.javen.model.Login;
import com.javen.service.HCarService;

@Service
public class HCarServiceImpl implements HCarService{

	@Resource
	private HCarDao hcarDao;

	public  List<HCar> selectById(int user) {
		// TODO Auto-generated method stub
		return hcarDao.selectById(user);
	}

	public int insert(HCar car) {
		// TODO Auto-generated method stub
		return hcarDao.insert(car);
	}
	
}
