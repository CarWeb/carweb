package com.javen.service;

import java.util.List;

import com.javen.model.Car;



public interface CarService {
	 public int updateByPrimaryKey(Car car);
	 public int deleteByPrimaryKey(int id);
	 public List<Car> selectAll();
	 public int insert(Car car);
}
