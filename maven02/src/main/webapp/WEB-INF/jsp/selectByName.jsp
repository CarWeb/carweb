<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="../sources/css/mystyle.css" />
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="../sources/js/jquery.js"></script>
</head>
<body class="body_bg">
	<div class="whole">
		<div class="title">SelectByName</div>
		<form id="form1" action="/maven02/login/selectByNameValue"  method="get" class="form_box">
			<div class="input_tit">Your Name</div>
			<div class="input_box">
				<input class="input_self" type="text" name="user_name" id="user_name" />
			</div>	
			<div class="finish_box" id="finish_box">
				<input class="finish_btn" type="button" id="finish" onclick="selectByName()" value="selectByName" />
				<a href = "/maven02/login/idus?x=index">
					<input class="finish_btn" type="button" id="finish" name="finish" value="back" />
				</a>
			</div>
		</form>
	</div>
</body>
	<script>
		function selectByName(){
			var data = {
				"user_name":$("#user_name").val()
		    };
			var url = "http://localhost:8080/maven02/login/selectByNameValue";		  
			$.ajax({
				type: "get", //指定提交的类型 get对应 doGet()方法，post--->doPost()犯法
				url: url,    //传输地址的URL
				data: data, //data代表我们的数据  key -value类型的数据
				cache: false, 
				async : false, //success和error代表是否返回成功，既后台给前台传输数据是否成功
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