<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Web Portal</title>
</head>
<body>
<form:form name="loginform" id="loginform" action="Home.htm" method="post" commandName="loginData">
<table>
 <TR>
 	<td>User Name: </td>
 	<td><input type='text' name='username' id='username'></td>
 </TR>
 <TR>
 	<td>Password: </td>
 	<td><input type="password" name='password' id='password'></td>
 </TR>
 <TR>
 	<TD><input type="submit" name='submit' >
 	</TD>
 </TR>
 </table>
</form:form>
</body>
</html>