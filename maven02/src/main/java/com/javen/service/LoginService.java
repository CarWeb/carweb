package com.javen.service;

import java.util.List;

import com.javen.model.Login;

public interface LoginService {

	Login selectByName(String acc);

	List<Login> selectAll();

	int insert(Login login);

	int updateByAcc(Login login);

}
