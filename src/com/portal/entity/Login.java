package com.portal.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="loginId", initialValue=1, allocationSize=100)
@Table(name="Login")
public class Login  {

	private int loginId;
	private String username;
	private String password;
	
	
	@Id
	@Column(name="loginId", nullable = false, length = 20)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "loginId")
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
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
