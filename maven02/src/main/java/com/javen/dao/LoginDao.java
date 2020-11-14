package com.javen.dao;

import java.util.List;

import com.javen.model.Login;

public interface LoginDao {
	
	
	/*
	 * int deleteByPrimaryKey(Integer id);
	 * 
	 * Login selectByPrimaryKey(Integer id);
	 * 
	 * int updateByPrimaryKeySelective(Login record);
	 * 
	 * int updateByPrimaryKey(Login record);
	 */
	Login selectByName(String acc);
	
	List<Login> selectAll();

	int insert(Login login);

	int updateByAcc(Login login);
	
}