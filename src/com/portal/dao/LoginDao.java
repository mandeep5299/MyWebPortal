package com.portal.dao;

import com.portal.entity.Login;

public interface LoginDao {
	public boolean validateUser(Login loginEntity);
	public boolean addUserLogin(Login loginEntity);
}
