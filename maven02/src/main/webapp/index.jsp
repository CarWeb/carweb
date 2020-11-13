<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="sources/css/mystyle.css" />
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="sources/js/jquery.js"></script>
</head>
<body class="body_bg">
	<div class="whole">
		<div class="title">登录</div>
		<form id="form1" action="/maven02/carlogin/selectByNameValue"  method="get" class="form_box">
			<div class="input_box">
				<input class="input_self" type="text" id="acc" placeholder="用户名" />
			</div>
			<div class="input_box">
				<input class="input_self" type="text" id="pwd" placeholder="密码" />
			</div>
			<div class="finish_box" id="finish_box">
				<input class="finish_btn" type="button" id="finish" onclick="selectByName()" value="登录" />
				
			</div>
		</form>
	</div>
</body>
	<script>
		function selectByName(){
			var data = {
				"acc":$("#acc").val()
		    };	  
			$.ajax({
				type: "get",
				url: "http://localhost:8080/maven02/carlogin/selectByNameValue",
				data: data,
				cache: false, 
				async : false,
				success: function (data,textStatus, jqXHR){
					console.info(data);
				},
				error:function (XMLHttpRequest, textStatus, errorThrown) { 
					console.log("error");
				}
			});
		}
	</script>
</html>