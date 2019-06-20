<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/header.jsp"%>


<body>

	<h4>${msg}</h4>

	<c:forEach items="${catList}" var="cat" >
		<p>Category ID = ${cat.id} </p>
		<p>Category Name = ${cat.name} </p>
		<p>Category Owner = ${cat.org_id} </p>
	</c:forEach>
	

	<a href="/login">Login</a>
	<a href="/">Home</a>
</body>
</html>