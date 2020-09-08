<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registered Users List</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">
</head>
<body>
	<h1>Registered Users List</h1>
	<table width="100%" class="userList">
		<tr style="background-color: lightgrey; text-align: left;">
			<th>First Name</th>
			<th>Last Name</th>
			<th>Address1</th>
			<th>Address2</th>
			<th>City</th>
			<th>State</th>
			<th>Zip</th>
			<th>Country</th>
			<th>Date</th>
		</tr>
		<c:if test="${empty list}">
			<tr>
				<td colspan="9">No users exist.</td>
			</tr>
		</c:if>
		<c:forEach var="person" varStatus="loopStatus" items="${list}">
			<tr class="${loopStatus.index % 2 == 0 ? 'even' : 'odd'}">
				<td>${person.firstname}</td>
				<td>${person.lastname}</td>
				<td>${person.address1}</td>
				<td>${person.address2}</td>
				<td>${person.city}</td>
				<td>${person.state}</td>
				<td>${person.zip}</td>
				<td>${person.country}</td>
				<td>${person.createdon}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="registerUser">Add New User</a>
</body>
</html>