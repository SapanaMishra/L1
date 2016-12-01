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
		<h1>Update student Details</h1>
		<form:form modelAttribute="student" action="updateStudent.html" method="post">
			<div>
				<label for=studentId>Student Id</label>
				<div>
					<form:input path="studentId" id="studentId" required="true" placeholder="Student Id" readonly="true"/>
				</div>
			</div>
			<div>
				<label for="fname">First Name</label>
				<div>
					<form:input path="firstName" id="fname" required="true" placeholder="First Name" readonly="true"/>
				</div>
			</div>
			<div>
				<label for="lname">Last Name</label>
				<div>
					<form:input path="lastName" id="lname" required="true" placeholder="Last Name" />
					 <form:errors path="lastName" cssStyle="color:red"/> 
				</div>
			</div>
			
				<div>
					<button type="submit">Update</button>
				</div>
				</form:form>
			
	</body>
</html>