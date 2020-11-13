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
				<input class="input_self" type="text" name="id" id="userName" />
			</div>
			<div class="finish_box">
				<input class="finish_btn" type="button" id="finish" name="finish" value="Finish" onclick="get()"/>
			</div>
		</form>
	</div>
</body>

<script>
function get(){
	var data = {
        	"sadasdas":$("#userName").val()
        };
	var url = "http://localhost:8080/maven02/login/selectById";
	 $.ajax({
	        type: "get", //指定提交的类型 get对应 doGet()方法，post--->doPost()犯法
	        url: url,    //传输地址的URL
	        data: data, //data代表我们的数据  key -value类型的数据
	       
	        async : false, //success和error代表是否返回成功，既后台给前台传输数据是否成功
	        success: function (data)
	        {
	        	console.log(data);
	        },
	        error:function (XMLHttpRequest, textStatus, errorThrown) { 
	            alert(typeof(errorThrown));
	        }
	     });
	}
</script>
</html>