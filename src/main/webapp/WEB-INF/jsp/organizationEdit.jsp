<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/header.jsp"%>
<%@ include file="include/sidebar.jsp"%>
<body>

 <div class="container">
    <div class="row">
      <div class="col-sm-4">
	<h3>Edit Organization Page</h3>
	
	
	   <form onsubmit="return validateInfo();" action="/updateOrganization" method="post" >
	
		<label>Organization ID: </label>
		<input id="name" type=text" name="name" class="form-control" value="${org.id}" readonly/>
	
	
		<label>Organization Name: </label>
		<input id="name" type=text" name="name" class="form-control" value="${org.name}" />
		<label id="error"  style="color:red;visibility: hidden;">Invalid Name</label>
		<br>
		
		<label>Organization Phone: </label>
		<input id="phone" type=text" name="phone" class="form-control" value="${org.phone}"/>
		<label id="error1"  style="color:red;visibility: hidden;">Invalid Phone</label>
		<br>
		
		<label>Address: </label>
		<textarea name="address" rows="" cols="" placeholder="enter address" class="form-control" required="">"${org.address}"</textarea>
		<br>
		
		<label>Username: </label>
		<input id="uname" type=text" name="uname" class="form-control" value="${org.uname}" />
		<label id="error2"  style="color:red;visibility: hidden;">Invalid Username</label>
		<br>
		
		<label>Password: </label>
		<input id="password" type=password" name="password" class="form-control" value="${org.pass}" />
		<label id="error3"  style="color:red;visibility: hidden;">Invalid Password</label>
		<br>
		
		<input id="agree1"  type="checkbox" name="t_c" value="agree" /> Agree With Terms and Conditions <br>
		<br>
		<input type="submit" class="btn btn-success"  value="Update Organization" />
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
			else if(pass==""){
				document.getElementById("error3").style.visibility="visible";
				document.getElementById("pass").style.border = "solid 1px red";
				document.getElementById("pass").focus();
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