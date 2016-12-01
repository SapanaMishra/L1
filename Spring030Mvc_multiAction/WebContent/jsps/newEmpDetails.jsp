<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<c:url var="insertEmp" value="postNewEmpDetails.obj" />
		<h1>Capgemini</h1>
		<h3>Joining new Employee</h3>
		
		<form:form method="post" modelAttribute="newEmp" action="${insertEmp}">
		  Enter Id:<form:input path="empNo"/><br>
		  Enter Name:<form:input path="empNm"/>
		                  <form:errors path="empNm" cssStyle="color:red"/>  
		  <br/>
		  Enter Salary:<form:input path="empSal"/><br/>
<!-- 		  Gender: -->
<%-- 		  <form:radiobutton path="gender" value="M" label="M" /> --%>
<%-- 		  <form:radiobutton path="gender" value="F" label="F" /><br/> --%>
<%-- 		  Enter eMail:<form:input path="email"/> --%>
<%-- 		              <form:errors path="email" cssStyle="color:red"/> --%>
<!-- 		  <br/> -->
<!-- 		  Select Skills: -->
<%-- 		  <form:checkboxes items="${skillList}" path="skillSet"/> --%>
<!-- 		  <br/> -->
		  
<!-- 		  Select Your City: -->
<%-- 		  <form:select path="city">  --%>
<%-- 			<form:option value="" label="Please Select"/> --%>
<%-- 			<form:options items="${cityList}" /> --%>
<%-- 		  </form:select> --%>
<!-- 		  <br/> -->
		  <input type="submit" value="Register"/>
	</form:form>


		
	</body>
</html>