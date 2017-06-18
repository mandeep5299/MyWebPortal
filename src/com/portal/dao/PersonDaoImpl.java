package com.portal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.entity.Login;
import com.portal.entity.Person;
import com.portal.entity.PersonSecurityQuestionMapping;
import com.portal.entity.SecurityQuestions;

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

	@Override
	public List<Object> getPersonAllDataList() {

		List<Object> personAllDataList = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			String getPersonAllDataListQuery = "Select person.personId, person.firstName, person.lastName, person.dateOfBirth, person.gender, "
					+ " person.country, person.phone, person.email, login.loginid, login.username, login.password, securityQuestions.securityQuestionId, securityQuestions.question, "
					+ " personSecurityQuestionMapping.sqMappingId, personSecurityQuestionMapping.answerToQuestion"
					+ " FROM Person person, Login login, PersonSecurityQuestionMapping personSecurityQuestionMapping, SecurityQuestions securityQuestions "
					+ " where person.loginid = login.loginid and person.personid = personSecurityQuestionMapping.personid "
					+ " and personSecurityQuestionMapping.securityQuestionId = securityQuestions.securityQuestionId order by person.personId";
			personAllDataList = session.createSQLQuery(getPersonAllDataListQuery)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return personAllDataList;
	}
}
