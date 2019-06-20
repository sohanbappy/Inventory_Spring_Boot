<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/header.jsp"%>
<%@ include file="include/sidebar.jsp"%>

<body>

 <div class="container">
    <div class="row">
      <div class="col-sm-4">
      
	<h3>Edit Sell Page</h3>
	
	   <form  action="/updateSell" method="post" >
	
		<label>Sell ID: </label> 
		<input id="id" type=text" name="id" value="${sell.id}"  class="form-control" readonly="" />
		<br>
	
	
		<label> Invoice No: </label>
		<input id="inv_no" type=text" name="inv_no" value="${sell.inv_no}"  class="form-control" />
		<label id="error"  style="color:red;visibility: hidden;">Invalid Invoice</label>
		<br>
	
	
		<label> Customer Name: </label>
		<input id="name" type=text" name="name" value="${sell.name}"  class="form-control" />
		<label id="error1"  style="color:red;visibility: hidden;">Invalid Name</label>
		<br>
		
		
		<label>Item: </label>
		<select name="item_id" class="form-control" value="${sell.item_id}"  required >
		<c:forEach items="${itemList}" var="item" >
     		<c:choose>
            <c:when test="${sell.item_id eq item.id}">
                <option value="${item.id}" selected="true">${item.name}</option>
            </c:when>
            <c:otherwise>
                <option value="${item.id}">${item.name}</option>
            </c:otherwise>
        </c:choose> 
	    </c:forEach>
		</select>
		<br>
		
		<label>Quantity: </label>
		<input id="quantity" type=text" name="quantity" value="${sell.quantity}"  class="form-control" />
		<label id="error2"  style="color:red;visibility: hidden;">Invalid Quantity</label>
		<br>
		
		<input type="submit" class="btn btn-success"  value="Update Sell" />
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