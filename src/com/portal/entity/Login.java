package com.portal.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Login")
public class Login  {

	private String personId;
	private String username;
	private String password;
	
	@Id
	@Column(name="PersonId", nullable = false, length = 20)
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	@Column(name="username", nullable = false, length = 20)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="password", nullable = false, length = 20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
