package com.javen.dao;



import java.util.List;

import com.javen.model.User;


public interface UserDao {
	
	public UserDao selectByPrimaryKey(int id);

	List<User> selectAll();

	int deleteByPrimaryKey(int id);

	int updateByPrimaryKey(User user);

	int insert(User user);
}
