<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Qingcheng</title>
<link rel="stylesheet" href="../sources/css/mystyle.css" />
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="../sources/js/jquery.js"></script>
</head>
<body class="body_bg">
	<div class="whole">
		<div class="title">Please Enter Your New Password</div>
		<form id="form1" action="" method="post" class="form_box">
			<div class="input_tit">Your Account</div>
			<div class="input_box">
				<input class="input_self" type="text" name="account" id="id"  value="${user.userName }"/>
			</div>
			<div class='blank_30'></div>
			<div class="input_tit">New Password</div>
			<div class="input_box">
				<input class="input_self" type="text" name="password" id="password" value="${user.password }"/>
			</div>
			<div class="input_tit">Confirm Your New Password</div>
			<div class="input_box">
				<input class="input_self" type="text" name="againPassword" id="againPassword" value="${user.age }"/>
			</div>
			<div class="finish_box">
				<input class="finish_btn" type="button" id="finish" name="finish" value="Finish"/>
			</div>
		</form>
	</div>
</body>

<script>


</script>
</html>