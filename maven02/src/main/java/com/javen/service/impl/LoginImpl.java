package com.javen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javen.dao.LoginDao;
import com.javen.model.Login;
import com.javen.service.ILoginService;

@Service("iLoginService")
public class LoginImpl implements ILoginService{

	@Autowired
	private LoginDao loginDao;
	@Override
	public Login selectById(Integer id) {
		// TODO Auto-generated method stub
		return this.loginDao.selectById(id);
	}
	@Override
	public List<Login> selectAll() {
		// TODO Auto-generated method stub
		return this.loginDao.selectAll();
	}
	@Override
	public Login selectByName(String user_name) {
		// TODO Auto-generated method stub
		return this.loginDao.selectByName(user_name);
	}
	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return this.loginDao.deleteById(id);
	}
	@Override
	public int deleteByName(String user_name) {
		// TODO Auto-generated method stub
		return this.loginDao.deleteByName(user_name);
	}
	@Override
	public int insert(Login login) {
		// TODO Auto-generated method stub
		return this.loginDao.insert(login);
	}
	@Override
	public int update(Login login) {
		// TODO Auto-generated method stub
		return this.loginDao.update(login);
	}

}
