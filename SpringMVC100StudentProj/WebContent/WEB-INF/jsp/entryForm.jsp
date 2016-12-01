<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<div>


		<h1>Student Entry Form</h1>



		<form:form modelAttribute="student" action="admitNewStudent.html" method="post">
			<div>
				<label for=studentId>Student Id</label>
				<div>
					<form:input path="studentId" id="studentId" required="true" placeholder="Student Id" />
				</div>
			</div>
			<div>
				<label for="fname">First Name</label>
				<div>
					<form:input path="firstName" id="fname" required="true" placeholder="First Name" />
				</div>
			</div>
			<div>
				<label for="lname">Last Name</label>
				<div>
					<form:input path="lastName" id="lname" required="true" placeholder="Last Name" />
				</div>
			</div>
			
				<div>
					<button type="submit">Add</button>
				</div>
				</form:form>
			</div>
		
		<!-- alert logic -->
<%-- 		<c:if test="${param.message ne null}"> --%>
<!-- 			<div> -->
<%-- 				${param.message} --%>
<!-- 			</div> -->
<%-- 		</c:if> --%>
		
<!-- 		<h3>Current List of Students:</h3> -->
<%-- 		<c:if test="${list ne null}"> --%>
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<th>Student Id</th> -->
<!-- 					<th>First Name</th> -->
<!-- 					<th>Last Name</th> -->
					
<!-- 				</tr> -->
<%-- 				<c:forEach items="${list}" var="student"> --%>
<!-- 					<tr> -->
<%-- 						<th>${student.studentId}</th> --%>
<%-- 						<th>${student.firstName}</th> --%>
<%-- 						<th>${student.lastName}</th> --%>
						
<!-- 					</tr> -->
<%-- 				</c:forEach> --%>
<!-- 			</table> -->
<%-- 		</c:if> --%>
<!-- 	</div> -->
</body>
</html>