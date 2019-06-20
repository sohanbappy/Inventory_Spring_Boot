<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html xmlns:th="http://thymeleaf.org" >

<%@ include file="include/header.jsp"%>
<%@ include file="include/sidebar.jsp"%>


<body>
	
	<br>

<a href="#" class="btn btn-success">All Category Pdf</a>
	
	
	<a href="/addCat" class="btn btn-warning">Add Category</a>
	
	<form action="/searchCat" method="post">
		<input type="text"  name="name" placeholder="enter name" required />
		<input type="submit" class="btn btn-success" value="Search">
	</form>

	<h3 >${user}'s Category List</h3>



<table class="table table-striped table-bordered table-hover table-dark" id="catTable">
 <thead style="background-color: black; color:white; font-size: 18px; font-weight: bold;">
  <tr>
    <th>ID</th>
    <th>Category Name</th>
    <th>Organization</th>
    <th>Created Date</th>
    <th colspan="2">Action</th>
  </tr>
</thead>

	<tbody>
	<c:forEach items="${catList}" var="cat" >
		<tr>
			<td>${cat.id}</td>
			<td> ${cat.name}</td>
			<td>${cat.org_id}</td>
			<td>${cat.creation_date}</td>
			<td><a href="/deleteCat/${cat.id}">Delete</a></td>
			<td><a href="/updateCat/${cat.id}">Update</a></td>
		</tr>
	</c:forEach>
	</tbody>

</table>


	
</body>


<%@ include file="include/footer.jsp"%>