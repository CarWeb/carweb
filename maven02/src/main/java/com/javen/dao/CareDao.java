package com.javen.dao;

import java.util.List;

import com.javen.model.Care;

public interface CareDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Care care);




	List<Care> selectAll();

   
    int updateByPrimaryKey(Care care);
}