package com.portal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.entity.Person;

@Repository("personDaoImpl")
public class PersonDaoImpl implements PersonDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addPerson(Person person) {
		boolean success = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(person);
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		} finally {
			transaction.commit();
			session.close();
		}
		return success;
	}

	@Override
	public List<Person> getPersonList() {

		List<Person> perosonList = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			String getPersonListQuery = "FROM Person";
			perosonList = session.createQuery(getPersonListQuery).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return perosonList;
	}

}
