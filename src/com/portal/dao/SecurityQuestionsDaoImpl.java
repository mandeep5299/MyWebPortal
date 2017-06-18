package com.portal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.entity.SecurityQuestions;

@Repository("securityQuestionsDaoImpl")
public class SecurityQuestionsDaoImpl implements SecurityQuestionsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SecurityQuestions> getAllSecurityQuestionsList() {
		List<SecurityQuestions> securityQuestionsList = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			String getSecurityQuestionsListQuery = "FROM SecurityQuestions";
			securityQuestionsList = session.createQuery(getSecurityQuestionsListQuery).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return securityQuestionsList;
	}

}
