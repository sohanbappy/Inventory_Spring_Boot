<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ include file="include/header.jsp"%>


<body>

	<h4>Welcome ${user}</h4>
	
	<a href="/addCat">Add Category</a>
	
	<form action="/searchCat" method="post">
		<input type="text"  name="name" placeholder="enter name" required />
		<input type="submit" value="Search">
	</form>
	
	
	<h5><b>Category List</b></h5>
	
   
	
	<c:forEach items="${catList}" var="cat" >
     	<p>==============================================================</p>
		<p>Category ID = ${cat.id} </p>
		<p>Category Name = ${cat.name} </p>
		<p>Category Ord_ID = ${cat.org_id} </p>
		<p>Category Created = ${cat.creation_date} </p>
		
	<!-- /${variable}  is used for path variable
		 ?${variable}  is used for request object  -->
		
		<a href="/deleteCat/${cat.id}">Delete</a>
		<a href="/updateCat/${cat.id}">Update</a>
		<p>==============================================================</p>
	</c:forEach>
	
	

</body>
</html>