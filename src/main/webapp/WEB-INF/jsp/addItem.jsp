<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/header.jsp"%>
<%@ include file="include/sidebar.jsp"%>
<body>

 <div class="container">
    <div class="row">
      <div class="col-sm-4">

	<h3>Add Item Page</h3>
	
	<form  action="/addItem" method="post" >
	
		<label>Item Name: </label>
		<input id="name" type=text" name="name" class="form-control" />
		<label id="error"  style="color:red;visibility: hidden;">Invalid Name</label>
		<br>
		
		
		<label>Category: </label>
		<select name="cat_id" class="form-control" required >
		<c:forEach items="${catList}" var="cat" >
     		<option value="${cat.id}">${cat.name}</option>
	    </c:forEach>
		</select>
		<br>
		
		<label>Quantity: </label>
		<input id="quantity" type=text" name="quantity" class="form-control" />
		<label id="error1"  style="color:red;visibility: hidden;">Invalid Quantity</label>
		<br>
		
		<label>Item Price: </label>
		<input id="price" type=text" name="price" class="form-control" />
		<label id="error2"  style="color:red;visibility: hidden;">Invalid Price</label>
		<br>
		
		
		
		<input type="submit" class="btn btn-success"  value="ADD Item" />
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