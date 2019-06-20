<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html xmlns:th="http://thymeleaf.org" >

<%@ include file="include/header.jsp"%>
<%@ include file="include/sidebar.jsp"%>


<body>
	
	<br>
	
	<h3>${msg}</h3>

<a href="#" class="btn btn-success">All Organization Pdf</a>
	
	
	<a href="/addOrganization" class="btn btn-warning">Add Organization</a>
	
	<form action="/searchOrganization" method="post">
		<input type="text"  name="name" placeholder="enter name" required />
		<input type="submit" class="btn btn-success value="Search">
	</form>

	<h3 >Organization List</h3>



<table class="table table-striped table-bordered table-hover table-dark" id="catTable">
 <thead style="background-color: black; color:white; font-size: 18px; font-weight: bold;">
  <tr>
  <th>Sl.</th>
    <th>Org. ID</th>
    <th>Organization Name</th>
    <th>Phone</th>
    <th>Address</th>
    <th>Uname</th>
    <th>Password</th>
    <th>Created Date</th>
    <th colspan="2">Action</th>
  </tr>
</thead>
	<% int i=0; %>
	<tbody>
	<c:forEach items="${orgList}" var="org" >
		<tr>
		<td><%=++i%></td>
			<td>${org.id}</td>
			<td> ${org.name}</td>
			<td>${org.phone}</td>
			<td>${org.address}</td>
			<td>${org.uname}</td>
			<td>${org.pass}</td>
			<td>${org.creation_date}</td>
			<td><a href="/deleteOrganization/${org.id}">Delete</a></td>
			<td><a href="/updateOrganization/${org.id}">Update</a></td>
		</tr>
	</c:forEach>
	</tbody>

</table>


	
</body>


<%@ include file="include/footer.jsp"%>