<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Person</title>
</head>
<body>
	<form:form name='personForm' id='personForm' action="addPerson.htm"
		commandName="personData" method="post">
		<table>
			<tr>
				<td>First Name:<input type="text" name="firstName"
					id="firstName" /></td>
				<td>Last Name:<input type="text" name="lastName" id="lastName" /></td>
			</tr>
			<tr>
				<td align="left"><form:errors path="firstName" class = 'mandatoryFields'/></td>
				<td align="left"><form:errors path="lastName" class = 'mandatoryFields'/></td>
			</tr>
			<tr>
				<td>User name:<input type="text" name="login.username"
					id="login.username" /></td>
				<td>Password:<input type="password" name="login.password"
					id="login.password" /></td>
			</tr>
			<tr>
				<td>Date Of Birth:<input type="text" name="dateOfBirth"
					id="dateOfBirth" /></td>
			</tr>
			<tr>
				<td align="left"><form:errors path="dateOfBirth" class = 'mandatoryFields'/></td>
			</tr>
			<tr>
				<td>Gender: <select name="gender" id="gender">
						<option id='Male' value="Male">Male</option>
						<option id='Female' value="Female">Female</option>
						<option id='Others' value="Others">Others</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Country:<input type="text" name="country" id="country" /></td>
				<td>Phone:<input type="text" name="phone" id="phone" /></td>
			</tr>
			<tr>
				<td align="left"><form:errors path="country" class = 'mandatoryFields'/></td>
				<td align="left"><form:errors path="phone" class = 'mandatoryFields'/></td>
			</tr>
			<tr>
				<td>Email:<input type="text" name="email" id="email" /></td>
			</tr>
			<tr>
				<td align="left"><form:errors path="email" class = 'mandatoryFields'/></td>
			</tr>
			<tr>
				<td><input type="submit" name='addPerson' id='addPerson'
					value='Save Person'></td>
			</tr>
		</table>
	</form:form>
</body>
</html>