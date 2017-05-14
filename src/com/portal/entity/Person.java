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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@SequenceGenerator(name="personId", initialValue=1, allocationSize=100)
@Table(name="Person")
public class Person {

	private int personId;
	private Login login;
	@NotEmpty(message = "Please enter first name.")
	private String firstName;
	@NotEmpty (message = "Please enter last name.")
	private String lastName;
	@NotNull(message= "Please enter date of birth.")
	@DateTimeFormat( pattern = "dd/MM/YY")
	private Date dateOfBirth;
	@NotEmpty(message = "Please select gender.")
	private String gender;
	@NotEmpty(message = "Please enter country." )
	private String country;
	@NotNull(message = "Please enter phone." )
	private Integer phone;
	@NotEmpty( message = "Please enter valid email id.")
	@Email
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
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
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
