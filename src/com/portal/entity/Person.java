package com.portal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="personId", initialValue=1, allocationSize=100)
@Table(name="Person")
public class Person {

	private int personId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String country;
	private int phone;
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Column(name = "gender", nullable =  false, length = 6)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "country", nullable =  false, length = 15)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Column(name = "phone", nullable =  false, length = 10)
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
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
