<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Person</title>
</head>
<body>
		<h3>Person List:</h3>
		<table border=1>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>DOB</th>
				<th>Gender</th>
				<th>Phone</th>
				<th>Country</th>
				<th>Email</th>
				<th>User name</th>
				<th>Password</th>
				<th>Security Question1</th>
				<th>Answer</th>
			</tr>

			<c:forEach var="personAllData" items="${personAllDataList}">
				<tr>
					<td><a id="showPerson" href="person.htm/${personAllData.personId}">${personAllData.personId}</a></td>
					<td>${personAllData.firstName}${personAllData.lastName}</td>
					<td>${personAllData.dateOfBirth}</td>
					<td>${personAllData.gender}</td>
					<td>${personAllData.phone}</td>
					<td>${personAllData.country}</td>
					<td>${personAllData.email}</td>
					<td>${personAllData.username}</td>
					<td>${personAllData.password}</td>
					<td>${personAllData.question}</td>
					<td>${personAllData.answerToQuestion}</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>