package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.dao.CarDao;

import com.javen.model.Car;

import com.javen.service.CarService;



@Service
public class CarServiceImpl implements CarService{
	@Resource
	private CarDao carDao;
	
	public List<Car> selectAll() {
		// TODO Auto-generated method stub
		return this.carDao.selectAll();
	}

	public int insert(Car car) {
		// TODO Auto-generated method stub
		return this.carDao.insert(car);
	}

	public int deleteByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return this.carDao.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKey(Car car) {
		// TODO Auto-generated method stub
		return this.carDao.updateByPrimaryKey(car);
	}

	

	

}
