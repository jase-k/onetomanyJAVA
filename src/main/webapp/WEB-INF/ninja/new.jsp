<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New Ninja</h1>
<form:form action="/new_ninja" method="post" modelAttribute="ninja">
	<p>
		<form:select path="dojo">
			<form:options items="${dojos }" itemValue="id" itemLabel="name" />
		</form:select> 
	</p>
    <p>
        <form:label path="first_name">First Name</form:label>
        <form:errors path="first_name"/>
        <form:input path="first_name"/>
    </p>
     <p>
        <form:label path="last_name">Last Name</form:label>
        <form:errors path="last_name"/>
        <form:input path="last_name"/>
    </p>
     <p>
        <form:label path="age">Age</form:label>
        <form:errors path="age"/>
        <form:input path="age"/>
    </p>
    <input class="btn btn-primary" type="submit" value="Create"/>
</form:form>   
</body>
</html>