package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.dao.AllDao;
import com.javen.model.All;
import com.javen.service.AllService;

@Service("allService")
public class AllImpl implements AllService{

	@Resource
	private AllDao allDao;

	public List<All> selectAll() {
		// TODO Auto-generated method stub
		return this.allDao.selectAll();
	}
	
	
	
}
