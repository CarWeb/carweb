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
		<div class="title">DeleteById</div>
		<form id="form1" action="/maven02/login/deleteByIdValue"  method="get" class="form_box">
			<div class="input_tit">Your ID</div>
			<div class="input_box">
				<input class="input_self" type="text" name="id" id="id" />
			</div>	
			<div class="finish_box" id="finish_box">
				<input class="finish_btn" type="button" id="finish" onclick="DeleteById()" value="DeleteById" />
				<a href = "/maven02/login/idus?x=index">
					<input class="finish_btn" type="button" id="finish" name="finish" value="back" />
				</a>
			</div>
		</form>
	</div>
</body>
	<script>
		function DeleteById(){
			var data = {
				"id":$("#id").val()
		    };
			var url = "http://localhost:8080/maven02/login/deleteByIdValue";		  
			$.ajax({
				type: "get", //指定提交的类型 get对应 doGet()方法，post--->doPost()犯法
				url: url,    //传输地址的URL
				data: data, //data代表我们的数据  key -value类型的数据
				cache: false, 
				async : false, //success和error代表是否返回成功，既后台给前台传输数据是否成功
				success: function (data,textStatus, jqXHR){
					var id = $("#id").val()
					console.info("根据id: "+id+" 删除成功!");
				},
				error:function (XMLHttpRequest, textStatus, errorThrown) { 
					console.log("error");
				}
			});
		}
	</script>
</html>