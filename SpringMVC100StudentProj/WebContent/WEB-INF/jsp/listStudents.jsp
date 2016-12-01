<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>Current List of Students:</h3>
		
		<c:if test="${listStudents ne null}">
			<table border="1">
				<tr>
					<th>Student Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Update</th>
					<th>Date of Joining</th>
					
				</tr>
				<c:forEach items="${listStudents}" var="student">
				
					<tr>
					<th>${student.studentId}</th>
<%-- 						<th><a href="${'studentDetails.html?id='}${student.studentId}">${student.studentId}</a></th> --%>
						<th>${student.firstName}</th>
						<th>${student.lastName}</th>
						<th><a href="${'studentDetails.html?id='}${student.studentId}">Update</a></th>
						<th>${student.dtJoin}</th>
						</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>