package com.portal.dao;

import java.util.List;

import com.portal.entity.Person;

public interface PersonDao {

	public boolean addPerson(Person person);
	public List<Person> getPersonList();
}
