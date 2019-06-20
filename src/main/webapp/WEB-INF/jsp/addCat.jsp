<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/header.jsp"%>
<%@ include file="include/sidebar.jsp"%>
<body>

 <div class="container">
    <div class="row">
      <div class="col-sm-4">

	<h3>Add Category Page</h3>
	
	<form onsubmit="return validateInfo();" action="/addCat" method="post" >
	
		<label>Category Name: </label>
		<input id="name" type=text" name="cat_name" class="form-control" />
		<label id="error"  style="color:red;visibility: hidden;">Invalid Name</label>
		<br>
		
		
		<label>Organization ID: </label>
		<select name="org_id" class="form-control" required >
		<c:forEach items="${orgList}" var="org" >
     		<option value="${org.id}">${org.name}</option>
	    </c:forEach>
		</select>
		<br>
		
		<input type="submit" class="btn btn-success"  value="ADD Category" />
	</form>
	
	</div>
	</div>
	</div>
	<script>
		function validateInfo(){
			
			var name = document.getElementById("name").value;
			
		
			if(name==""){
				document.getElementById("error").style.visibility="visible";
				document.getElementById("name").style.border = "solid 1px red";
				document.getElementById("name").focus();
				return false;
			}else if(name.trim().length <=2 ){
				alert('Name must be at least 3 letters!!!');
				return false;
			}
			else if(name.trim().length >20 ){
				alert('Name can be maximum 20 letters!!!');
				return false;
			}
			else{
				return true;
			}
			
			
		}
	
	</script>
</body>
<%@ include file="include/footer.jsp"%>