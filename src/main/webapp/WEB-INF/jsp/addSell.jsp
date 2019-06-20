<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/header.jsp"%>
<%@ include file="include/sidebar.jsp"%>
<body>

 <div class="container">
    <div class="row">
      <div class="col-sm-4">

	<h3>Sell Page</h3>
	
	<form  action="/addSell" method="post" >
	
	
		<label> Invoice No: </label>
		<input id="inv_no" type=text" name="inv_no" class="form-control" />
		<label id="error"  style="color:red;visibility: hidden;">Invalid Invoice</label>
		<br>
	
		<label> Customer Name: </label>
		<input id="name" type=text" name="name" class="form-control" />
		<label id="error1"  style="color:red;visibility: hidden;">Invalid Name</label>
		<br>
		
		<label>Item: </label>
		<select name="item_id" class="" required >
		<c:forEach items="${itemList}" var="item" >
     		<option value="${item.id}">${item.name}</option>
	    </c:forEach>
		</select>
		<br>
		
		<label>Quantity: </label>
		<input id="quantity" type=text" name="quantity" class="" />
		<label id="error2"  style="color:red;visibility: hidden;">Invalid Quantity</label>
		<br>
	
		
		<input type="submit" class="btn btn-success"  value="ADD Sell" />
	</form>
	
	  </div>
	 </div>
	</div>
	<script>
$(document).ready(function(){
   
    $("#addMore").click(function(){
     
       $(".more").append('
    		   <label>Item: </label>
    			<select name="item_id" class="" required >
    			<c:forEach items="${itemList}" var="item" >
    	     		<option value="${item.id}">${item.name}</option>
    		    </c:forEach>
    			</select>
    			<br>
    			
    			<label>Quantity: </label>
    			<input id="quantity" type=text" name="quantity" class="" />
    			<label id="error2"  style="color:red;visibility: hidden;">Invalid Quantity</label>
    			<br>
    		   
    		   '); 


    });
 
});
</script>
	
	
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