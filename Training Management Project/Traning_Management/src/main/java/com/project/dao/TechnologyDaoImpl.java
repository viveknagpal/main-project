package com.project.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.model.Technology;

public class TechnologyDaoImpl implements TechnologyDao
{
	@Autowired
	SessionFactory sessionFactory;	
	Session session = null;
	Transaction tx = null;

	public boolean addTechnology(Technology technology) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(technology);
		tx.commit();
		session.close();

		return false;
	}

	public Technology getTechnologyById(long id) throws Exception {
		session = sessionFactory.openSession();
		Technology technology = (Technology) session.load(Technology.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return technology;
	}

	@SuppressWarnings("unchecked")
	public List<Technology> getTechnologyList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Technology> technologyList = session.createCriteria(Technology.class)
				.list();
		tx.commit();
		session.close();
		return technologyList;
	}

	public boolean deleteTechnology(long id)throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Technology.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}
}
