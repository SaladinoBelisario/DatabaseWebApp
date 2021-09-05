<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>

	<!-- Reference to our stylesheet -->
	<link 	type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM- custom relationship management</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<input type="button" value="Add customer"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				<!-- Customers loop adding -->
				<c:forEach var="tempCustomer" items="${customers}">
					<!--construct a Customer Update link-->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					<!--construct a Customer Delete link-->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>

						<td>
							<!--update link-->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>









