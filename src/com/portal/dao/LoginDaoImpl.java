package com.portal.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.entity.Login;

@Repository("loginDaoImpl")
public class LoginDaoImpl implements LoginDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean validateUser(Login loginEntity) {
		// TODO Auto-generated method stub
		boolean isValidUser = false;
		Session session = sessionFactory.openSession();
		String loginQuery = "FROM Login where username=:uname and password=:pwd";
		Query query =  session.createQuery(loginQuery);
		query.setParameter("uname", loginEntity.getUsername());
		query.setParameter("pwd", loginEntity.getPassword());
		List listResult = query.list();
		if(listResult.size() > 0){
			isValidUser = true;
		}
		return isValidUser;
	}

}
