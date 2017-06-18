package com.portal.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="sqMappingId", initialValue=1, allocationSize=100)
@Table(name = "PersonSecurityQuestionMapping")
public class PersonSecurityQuestionMapping {

	private int sqMappingId;
	private Person person;
	private SecurityQuestions securityQuestions;
	private String answerToQuestion;
	
	@Id
	@Column(name="sqMappingId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sqMappingId")
	public int getSqMappingId() {
		return sqMappingId;
	}
	public void setSqMappingId(int sqMappingId) {
		this.sqMappingId = sqMappingId;
	}
	@Column(name = "answerToQuestion")
	public String getAnswerToQuestion() {
		return answerToQuestion;
	}
	public void setAnswerToQuestion(String answerToQuestion) {
		this.answerToQuestion = answerToQuestion;
	}
	@ManyToOne(targetEntity=Person.class)
    @JoinColumn(name="personId")
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@ManyToOne(targetEntity=SecurityQuestions.class)
	@JoinColumn(name="securityQuestionId")
	public SecurityQuestions getSecurityQuestions() {
		return securityQuestions;
	}
	public void setSecurityQuestions(SecurityQuestions securityQuestions) {
		this.securityQuestions = securityQuestions;
	}
	
}
