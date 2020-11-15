package com.javen.dao;

import java.util.List;

import com.javen.model.Login;

public interface LoginDao {
	
	Login selectByName(String acc);
	
	List<Login> selectAll();

	int insert(Login login);

	int updateByAcc(Login login);
	
}