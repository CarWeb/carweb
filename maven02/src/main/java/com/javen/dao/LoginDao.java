package com.javen.dao;

import java.util.List;

import com.javen.model.Login;

public interface LoginDao {

    int insert(Login login);

    int insertSelective(Login login);

    Login selectById(Integer id);
    
    Login selectByName(String user_name);

	int deleteById(Integer id);
	
	int deleteByName(String user_name);//delete不论是什么值都要以int类型返回
	
    int updateByPrimaryKeySelective(Login login);

    int update(Login login);

	List<Login> selectAll();
	
	
}