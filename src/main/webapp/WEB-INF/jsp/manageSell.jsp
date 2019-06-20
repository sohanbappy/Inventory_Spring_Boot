<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html xmlns:th="http://thymeleaf.org" >

<%@ include file="include/header.jsp"%>
<%@ include file="include/sidebar.jsp"%>


<body>
	
	<br>

<a href="#" class="btn btn-success">All Sell Pdf</a>
	
	
	<a href="/addSell" class="btn btn-warning">Add Sell</a>
	
	<form action="/searchSell" method="post">
		<input type="text"  name="inv_no" placeholder="enter invoice no. " required />
		<input type="submit" class="btn btn-success" value="Search Invoice">
	</form>

	<h3 >Sell List</h3>



<table class="table table-striped table-bordered table-hover table-dark" id="catTable">
 <thead style="background-color: black; color:white; font-size: 18px; font-weight: bold;">
  <tr>
    <th>ID</th>
    <th>Invoice No</th>
    <th>Name</th>
    <th>Item</th>
    <th>Quantity</th>
    <th>Sub Total</th>
    <th>Created Date</th>
    <th colspan="2">Action</th>
  </tr>
</thead>

	<tbody>
	<c:forEach items="${sellList}" var="sell" >
		<tr>
			<td>${sell.id}</td>
			<td> ${sell.inv_no}</td>
			<td>${sell.name}</td>
			<td>${sell.item_id}</td>
			<td>${sell.quantity}</td>
			<td>${sell.sub_total}</td>
			<td>${sell.creation_date}</td>
			<td><a href="/deleteSell/${sell.id}">Delete</a></td>
			<td><a href="/updateSell/${sell.id}">Update</a></td>
		</tr>
	</c:forEach>
	</tbody>

</table>


	
</body>


<%@ include file="include/footer.jsp"%>