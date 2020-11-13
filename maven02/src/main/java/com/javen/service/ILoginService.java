package com.javen.service;

import java.util.List;

import com.javen.model.Login;

public interface ILoginService {

	public Login selectById(Integer id);

	public List<Login> selectAll();

	public Login selectByName(String user_name);

	public int deleteById(Integer id);

	public int deleteByName(String user_name);

	public int insert(Login login);

	public int update(Login login);

}
