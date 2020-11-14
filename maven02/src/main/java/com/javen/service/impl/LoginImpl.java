package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.dao.LoginDao;
import com.javen.model.Login;
import com.javen.service.LoginService;

@Service("loginService")
public class LoginImpl implements LoginService{

	@Resource
	private LoginDao loginDao;

	public Login selectByName(String acc) {
		
		return this.loginDao.selectByName(acc);
	}

	public List<Login> selectAll() {
		// TODO Auto-generated method stub
		return this.loginDao.selectAll();
	}

	public int insert(Login login) {
		// TODO Auto-generated method stub
		return this.loginDao.insert(login);
	}

	public int updateByAcc(Login login) {
		// TODO Auto-generated method stub
		return this.loginDao.updateByAcc(login);
	}
	
	
}
