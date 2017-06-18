<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Person</title>
</head>
<body>
	<form:form name="personForm" id="personForm" action="addPerson.htm"
		modelAttribute="personData" method="POST">
		<table>
			<tr>
				<td>First Name: <form:input path="firstName" />
				<td>Last Name:<form:input path="lastName" /></td>
			</tr>
			<tr>
				<td align="left"><form:errors path="firstName"
						class='mandatoryFields' /></td>
				<td align="left"><form:errors path="lastName"
						class='mandatoryFields' /></td>
			</tr>
			<tr>
				<td>User name:<form:input type="text" path="login.username" />
				<td>Password:<form:input type="password" path="login.password" />
				</td>
			</tr>
			<tr>
				<td>Date Of Birth: <form:input type="text" path="dateOfBirth" />
			</tr>
			<tr>

				<td align="left"><form:errors path="dateOfBirth"
						class='mandatoryFields' /></td>
			</tr>
			<tr>
				<td>Gender: <form:select path="gender">
						<form:option value="Male">Male</form:option>
						<form:option value="Female">Female</form:option>
						<form:option value="Others">Others</form:option>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Country:<form:input type="text" path="country" />
				</td>
				<td>Phone:<form:input type="text" path="phone" />
				</td>
			</tr>
			<tr>
				<td align="left"><form:errors path="country"
						class='mandatoryFields' /></td>
				<td align="left"><form:errors path="phone"
						class='mandatoryFields' /></td>
			</tr>
			<tr>
				<td>Email:<form:input type="text" path="email" />
				</td>
			</tr>
			<tr>
				<td align="left"><form:errors path="email"
						class='mandatoryFields' /></td>
			</tr>
			<tr>
				<td>Security Question: <form:select
						path="personSecurityQuestionMapping[0].securityQuestions.securityQuestionId">
						<c:forEach var="obj" items="${securityQuestionsList}">
							<option id="${obj.securityQuestionId}"
								value="${obj.securityQuestionId}">${obj.question}</option>
						</c:forEach>
					</form:select>
				</td>
				<td>Answer: <form:input
						path="personSecurityQuestionMapping[0].answerToQuestion" />
				</td>
			</tr>
			<tr>
				<td>Security Question: <form:select
						path="personSecurityQuestionMapping[1].securityQuestions.securityQuestionId">
						<c:forEach var="obj" items="${securityQuestionsList}">
							<option id="${obj.securityQuestionId}"
								value="${obj.securityQuestionId}">${obj.question}</option>
						</c:forEach>
					</form:select>
				</td>
				<td>Answer: <form:input
						path="personSecurityQuestionMapping[1].answerToQuestion" />
				</td>
			</tr>
			<tr>
				<td><input type="submit" name='addPerson' id='addPerson'
					value='Save Person'></td>
			</tr>
		</table>
	</form:form>
</body>
</html>