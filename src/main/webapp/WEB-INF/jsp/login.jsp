<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/header.jsp"%>


  <style>
    body{

    background-image: url("images/loginbg.jpg") !important;
    background-repeat: no-repeat !important;
    background-size: 100% !important;
    height: 80%;
    }
  </style>

<body>
<div class="login-box">
  <div class="login-logo">
    <a href="#"><b style="color: black;">Inventory Management System</b></a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">Sign in to start your session</p>

<form action="/login" method="post">
      <div class="form-group has-feedback">
        <input type="text" name="username" class="form-control" maxlength="12" placeholder="username plz" required="">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="password" class="form-control" maxlength="20" placeholder="Password" required="">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
   
      <div class="form-group ">
       <select class="form-control" name="type" required>
       	 <option selected disabled >--select---</option>
       	 <option value="Admin">Admin</option>
       	 <option value="Organization">Organization</option>
       </select>
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" name="submit" class="btn btn-primary btn-block btn-flat" onclick="return confirm('Want to logged in??');">Sign In</button>
        </div>
        <!-- /.col -->
      </div>
    </form>


  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="asset/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="asset/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="asset/plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' /* optional */
    });
  });
</script>
</body>
