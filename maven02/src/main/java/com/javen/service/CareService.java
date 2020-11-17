package com.javen.service;

import java.util.List;

import com.javen.model.Care;




public interface CareService {
	 public int updateByPrimaryKey(Care care);
	 public int deleteByPrimaryKey(int id);
	 public List<Care> selectAll();
	 public int insert(Care care);
}
