package com.project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.dao.DataDao;
import com.project.model.Trainertester;

public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;	
	
	public boolean addEntity(Trainertester trainer) throws Exception {
		return dataDao.addEntity(trainer);
	}
	
	public Trainertester getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}
	
	public List<Trainertester> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}

}
