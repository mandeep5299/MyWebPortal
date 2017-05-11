package com.portal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="personId", initialValue=1, allocationSize=100)
@Table(name="Person")
public class Person {

	private int personId;
	private Login login;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private String country;
	private long phone;
	private String email;
	
	
	@Id
	@Column(name = "personId", nullable =  false, length = 15)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "personId")
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	@OneToOne
	@JoinColumn(name = "loginId")
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	@Column(name= "firstName", nullable =  false, length = 15)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name= "lastName", nullable =  false, length = 15)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name= "dateOfBirth", nullable =  false, length = 10)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Column(name = "gender", nullable =  false, length = 6)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "country", nullable =  false, length = 25)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Column(name = "phone", nullable =  false, length = 10)
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Column(name = "email", nullable =  false, length = 25)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
