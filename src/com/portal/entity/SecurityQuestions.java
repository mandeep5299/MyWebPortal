package com.portal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="SecurityQuestions")
@SequenceGenerator(name="securityQuestionId", initialValue=1, allocationSize=100)
public class SecurityQuestions {
	
	private int securityQuestionId;
	private String question;

	@Id
	@Column(name = "securityQuestionId")
	public int getSecurityQuestionId() {
		return securityQuestionId;
	}
	public void setSecurityQuestionId(int securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}
	@Column(name = "question")
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	

	
	
	
	
	
}
