<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html xmlns:th="http://thymeleaf.org" >

<%@ include file="include/header.jsp"%>
<%@ include file="include/sidebar.jsp"%>


<body>
	
	<br>

<a href="#" class="btn btn-success">All Item Pdf</a>
	
	
	<a href="/addItem" class="btn btn-warning">Add Item</a>
	
	<form action="/searchItem" method="post">
		<input type="text"  name="name" placeholder="enter name" required />
		<input type="submit" class="btn btn-success" value="Search">
	</form>

	<h3 >Item List</h3>



<table class="table table-striped table-bordered table-hover table-dark" id="catTable">
 <thead style="background-color: black; color:white; font-size: 18px; font-weight: bold;">
  <tr>
    <th>ID</th>
    <th>Item Name</th>
    <th>Category</th>
    <th>Quantity</th>
    <th>Price</th>
    <th>Created Date</th>
    <th colspan="2">Action</th>
  </tr>
</thead>

	<tbody>
	<c:forEach items="${itemList}" var="item" >
		<tr>
			<td>${item.id}</td>
			<td> ${item.name}</td>
			<td>${item.cat_id}</td>
			<td>${item.quantity}</td>
			<td>${item.price}</td>
			<td>${item.creation_date}</td>
			<td><a href="/deleteItem/${item.id}">Delete</a></td>
			<td><a href="/updateItem/${item.id}">Update</a></td>
		</tr>
	</c:forEach>
	</tbody>

</table>


	
</body>


<%@ include file="include/footer.jsp"%>