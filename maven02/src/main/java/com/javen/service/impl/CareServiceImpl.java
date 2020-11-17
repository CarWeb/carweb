package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.dao.CareDao;

import com.javen.model.Care;


import com.javen.service.CareService;



@Service
public class CareServiceImpl implements CareService{
	@Resource
	private CareDao careDao;


	public int updateByPrimaryKey(Care care) {
		// TODO Auto-generated method stub
		return this.careDao.updateByPrimaryKey(care);
	}

	public int deleteByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		 return this.careDao.deleteByPrimaryKey(id);
	}

	public List<Care> selectAll() {
		// TODO Auto-generated method stub
		return this.careDao.selectAll();
	}

	public int insert(Care care) {
		// TODO Auto-generated method stub
		return this.careDao.insert(care);
	}
	


	

	

}
