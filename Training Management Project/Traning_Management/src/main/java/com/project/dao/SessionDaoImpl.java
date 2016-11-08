package com.project.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.model.TMSSession;

public class SessionDaoImpl implements SessionDao
{
	@Autowired
	SessionFactory sessionFactory;	
	Session hibsession = null;
	Transaction tx = null;

	public boolean addSession(TMSSession tmsSession) throws Exception {

		hibsession = sessionFactory.openSession();
		tx = hibsession.beginTransaction();
		hibsession.save(tmsSession);
		tx.commit();
		hibsession.close();

		return false;
	}

	public TMSSession getSessionById(long id) throws Exception {
		hibsession = sessionFactory.openSession();
		TMSSession tmsSession = (TMSSession) hibsession.load(TMSSession.class,
				new Long(id));
		tx = hibsession.getTransaction();
		hibsession.beginTransaction();
		tx.commit();
		return tmsSession;
	}

	@SuppressWarnings("unchecked")
	public List<TMSSession> getSessionList() throws Exception {
		hibsession = sessionFactory.openSession();
		tx = hibsession.beginTransaction();
		List<TMSSession> tmsSessionList = hibsession.createCriteria(TMSSession.class)
				.list();
		tx.commit();
		hibsession.close();
		return tmsSessionList;
	}

	public boolean deleteSession(long id)throws Exception {
		hibsession = sessionFactory.openSession();
		Object o = hibsession.load(TMSSession.class, id);
		tx = hibsession.getTransaction();
		hibsession.beginTransaction();
		hibsession.delete(o);
		tx.commit();
		return false;
	}

}
