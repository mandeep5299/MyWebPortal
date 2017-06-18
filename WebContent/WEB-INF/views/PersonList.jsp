<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Person</title>
</head>
<body>

	<h3>Person List:</h3>
	<table border =1>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>DOB</th>
			<th>Gender</th>
			<th>Phone</th>
			<th>Country</th>
			<th>Email</th>
		</tr>

		<c:forEach var="person" items="${personList}">
			<tr>
				<td>${person.personId}</td>
				<td>${person.firstName} ${person.lastName}</td>
				<td>${person.dateOfBirth}</td>
				<td>${person.gender}</td>
				<td>${person.phone}</td>
				<td>${person.country}</td>
				<td>${person.email}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>