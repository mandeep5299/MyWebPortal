<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	<form:form name='HomeForm' id='HomeForm' action='processHomeForm.htm'
		method="post">
		<h4>Welcome: ${loginDetails.getUsername()}</h4>
		<table>
			<tr>
				<td><input type="submit" name='addPerson' id='addPerson'
					value="Add Person"></td>
			</tr>
			<tr>
				<td><input type="submit" name='listPerson' id='listPerson'
					value="List Person"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>