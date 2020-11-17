package com.javen.service;

import java.util.List;

import com.javen.model.User;

public interface UserService {
	
	 public int deleteByPrimaryKey(int id);
	 public List<User> selectAll();
	 public int insert(User user);
	 public int updateByPrimaryKey(User user);
}
