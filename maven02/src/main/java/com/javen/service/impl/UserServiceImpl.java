package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.dao.UserDao;
import com.javen.model.User;
import com.javen.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return this.userDao.selectAll();
	}

	public int deleteByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return this.userDao.deleteByPrimaryKey(id);
	}

	public int insert(User user) {
		// TODO Auto-generated method stub
		return this.userDao.insert(user);
	}

	public int updateByPrimaryKey(User user) {
		// TODO Auto-generated method stub
		return this.userDao.updateByPrimaryKey(user);
	}
	

	

}
