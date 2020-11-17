package com.javen.dao;

import java.util.List;

import com.javen.model.Car;


public interface CarDao {
   

	List<Car> selectAll();

	int insert(Car car);


	int deleteByPrimaryKey(int id);

	int updateByPrimaryKey(Car car);


}