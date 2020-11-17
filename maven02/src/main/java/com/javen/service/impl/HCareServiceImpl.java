package com.javen.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.dao.HCareDao;
import com.javen.model.HCare;
import com.javen.service.HCareService;

@Service
public class HCareServiceImpl implements HCareService{

	@Resource
	private HCareDao hcareDao;

	public HCare selectById(int id) {
		// TODO Auto-generated method stub
		return hcareDao.selectById(id);
	}

	public int insert(HCare care) {
		// TODO Auto-generated method stub
		return hcareDao.insert(care);
	}

	public int updateById(HCare care) {
		// TODO Auto-generated method stub
		return hcareDao.updateById(care);
	}


	
	
}
