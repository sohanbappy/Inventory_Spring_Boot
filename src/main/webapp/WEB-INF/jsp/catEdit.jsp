<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/header.jsp"%>
<%@ include file="include/sidebar.jsp"%>
<body>

 <div class="container">
    <div class="row">
      <div class="col-sm-4">
      
	<h3>Edit Category Page</h3>
	
	<form action="/updateCat" method="post">
	    <label>Category ID: </label><input type=text" name="id" value="${cat.id}" class="form-control" readonly />
		<label>Category Name: </label><input type=text" name="cat_name" value="${cat.name}" class="form-control" required />
		<label>Organization ID: </label><input type=text" name="org_id" value="${cat.org_id}" class="form-control" required />
		<br>
		<input type="submit" class="btn btn-success"  value="Update Category" />
	</form>
	
</div>
</div>
</div>
	
</body>
<%@ include file="include/footer.jsp"%>