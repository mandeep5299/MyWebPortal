package com.portal.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.entity.PersonSecurityQuestionMapping;

@Repository("personSecurityMappingDaoImpl")
public class PersonSecurityMappingDaoImpl implements PersonSecurityMappingDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addPersonSecurityMapping(PersonSecurityQuestionMapping personSecurityQuestionMapping) {
		boolean isPersonSecurityQuestionMappingSuccess = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(personSecurityQuestionMapping);
		} catch (Exception e) {
			e.printStackTrace();
			isPersonSecurityQuestionMappingSuccess = false;
		} finally {
			transaction.commit();
			session.close();
		}
		return isPersonSecurityQuestionMappingSuccess;
	}

}
