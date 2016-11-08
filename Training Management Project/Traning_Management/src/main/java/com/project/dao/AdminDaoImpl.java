package com.project.dao;

import com.project.model.Admin;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;


public class AdminDaoImpl implements AdminDao
{
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	public boolean addAdmin(Admin admin) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(admin);
		tx.commit();
		session.close();

		return false;
	}

	public Admin getAdminById(long id) throws Exception {
		session = sessionFactory.openSession();
		Admin admin = (Admin) session.load(Admin.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return admin;
	}

	@SuppressWarnings("unchecked")
	public List<Admin> getAdminList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Admin> adminList = session.createCriteria(Admin.class)
				.list();
		tx.commit();
		session.close();
		return adminList;
	}

	public boolean deleteAdmin(long id)throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Admin.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

	public Admin adminAuthentication(String uname, String pass) throws Exception {
		session = sessionFactory.openSession();
		String hql = "FROM admin a WHERE a.admin_email_id ="+uname+"a.admin_password ="+pass;
		Query query = session.createQuery(hql);
		List results = query.list();
		Admin admin = null;
		if(results.isEmpty())
		{
			admin=(Admin) results.get(0);	
		}
		return admin;
	}

}
