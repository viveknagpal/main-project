package com.project.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.model.Employee;

public class EmployeeDaoImpl 
{
	@Autowired
	SessionFactory sessionFactory;	
	Session session = null;
	Transaction tx = null;

	public boolean addEmployee(Employee employee) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();
		return false;
	}

	public Employee getEmployeeById(long id) throws Exception {
		session = sessionFactory.openSession();
		Employee employee = (Employee) session.load(Employee.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return employee;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Employee> employeeList = session.createCriteria(Employee.class)
				.list();
		tx.commit();
		session.close();
		return employeeList;
	}

	public boolean deleteEmployee(long id)throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Employee.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
