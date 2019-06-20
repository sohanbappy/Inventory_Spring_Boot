<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/header.jsp"%>
<%@ include file="include/sidebar.jsp"%>

<body>

 <div class="container">
    <div class="row">
      <div class="col-sm-4">
      
	<h3>Edit Item Page</h3>
	
	   <form  action="/updateItem" method="post" >
	
		<label>Item ID: </label> 
		<input id="id" type=text" name="id" value="${item.id}"  class="form-control" readonly="" />
		<br>
	
	
		<label>Item Name: </label>
		<input id="name" type=text" name="name" class="form-control" value="${item.name}" />
		<label id="error"  style="color:red;visibility: hidden;">Invalid Name</label>
		<br>
		
		
		<label>Category: </label>
		<input id="cat_id" type=text" name="cat_id" class="form-control" value="${item.cat_id}" readonly/>
		
		
		<label>Quantity: </label>
		<input id="quantity" type=text" name="quantity" class="form-control" value="${item.quantity}" />
		<label id="error1"  style="color:red;visibility: hidden;">Invalid Quantity</label>
		<br>
		
		<label>Price: </label>
		<input id="price" type=text" name="price" class="form-control" value="${item.price}" />
		<label id="error2"  style="color:red;visibility: hidden;">Invalid Price</label>
		<br>
		
		<input type="submit" class="btn btn-success"  value="Update Item" />
	</form>
	
	  </div>
	 </div>
	</div>
	
	<script>
		function validateInfo(){
			
			var name = document.getElementById("name").value;
			var phone = document.getElementById("phone").value;
			var uname = document.getElementById("uname").value;
			var pass = document.getElementById("password").value;
			var condition = document.getElementById("agree").checked;
		
			if(name==""){
				document.getElementById("error").style.visibility="visible";
				document.getElementById("name").style.border = "solid 1px red";
				document.getElementById("name").focus();
				return false;
			}
			else if(phone==""){
				document.getElementById("error1").style.visibility="visible";
				document.getElementById("phone").style.border = "solid 1px red";
				document.getElementById("phone").focus();
				return false;
			}
			else if(uname==""){
				document.getElementById("error2").style.visibility="visible";
				document.getElementById("uname").style.border = "solid 1px red";
				document.getElementById("uname").focus();
				return false;
			}
			
			else if(name.trim().length <=3 || name.trim().length >20){
				alert('Name must be at least 4 and maximum 20 letters!!!');
				return false;
			}
			else if(phone.trim().length <11 || phone.trim().length >11){
				alert('Phone must be 11 letters!!!');
				return false;
			}
			else if(uname.trim().length <8 || uname.trim().length >12){
				alert('Username must be at least 8 and maximum 12 letters!!!');
				return false;
			}
			else if(pass.trim().length <5 || pass.trim().length >8){
				alert('Password must be at least 5 and maximum 8 letters!!!');
				return false;
			}
			
			else if(condition==""){
				alert('You must accept terms and conditions!!');
				return false;
				
			}else{
				return true;
			}
			
			
		}
	
	</script>


</body>
<%@ include file="include/footer.jsp"%>