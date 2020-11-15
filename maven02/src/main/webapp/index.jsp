<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>qcbyCarCare-Please Login</title>
		<link rel="stylesheet" href="sources/css/mystyle.css" />
		<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
		<script src="sources/js/jquery.js"></script>
	</head>
	<body class="body_bg">
		<div id="All">
			<div class="signupdiv">
				<input class="signup" type="button"  value="SignUp" onclick="SignUpCheck()"/>
			</div>
			<div id="main">	
				<div class="whole">	
					<div class="title">Please Login</div>
					<form id="form1" action="/maven02/login/idus" method="get" class="form_box">
						<div class="input_tit">Your Account</div>
						<div class="input_box">
							<input class="input_self" type="text" name="username" id="acc"  value="" />
						</div>
						<div class="blank_30"></div>
						<div class="input_tit">Password</div>
						<div class="input_box">
							<input class="input_self" type="password" name="password" id="pwd"  value="" />
						</div>
						<div class="finish_box" id="return">
							<input class="finish_btn" type="submit" value="Login" onclick="LoginByAcc()"/>
						</div>				
					</form>
				</div>
				<!-- <input class="finish_btn" type="button" value="Login" onclick="showtable()"/>
				<table id="cardata"></table> -->
				<!-- <div class="adminlogindiv">
					<input class="adminlogin" type="button" value="Administrator Login" onclick="adminlogin()"/>
				</div> -->
			</div>
		</div>
	</body>
	<script>
			
			/* function showtable(){
				$.ajax({
					type: "get", 
					url: "http://localhost:8080/maven02/login/showtable",   
					//data: data,
					cache: false,
					async : false, 
					success: function (data,textStatus, jqXHR){
						var html ='<tr><th>2</th><th>2</th><th>2</th><th>22</th><th>2</th>';
			        	for(var i=0;i<data.length;i++){
			        		console.info(data[i]);
			        		html +='<tr>';
			        		html +='<td>'+data[i].id+'</td>';
			        		html +='<td>'+data[i].acc+'</td>';
			        		html +='<td>'+data[i].pwd+'</td>';
			        		html +='<td>'+data[i].tel+'</td>';
			        		html +='<td>'+data[i].admin+'</td>';
			        		
				        	html+='</tr>';
				        	$("#cardata").empty().append(html);
						}
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) { 
						console.info("error");
					}
				});
			} */
			function LoginByAcc(){
				var data = {
						"acc":$("#acc").val(),
						"pwd":$("#pwd").val()
				};
				$.ajax({
					type: "get", 
					url: "http://localhost:8080/maven02/login/selectByName",   
					data: data, 
					cache: false,
					async : false, 
					success: function (data,textStatus, jqXHR){
						
						if(data == 0){
							var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
							html += 'Error! Account or PassWord is empty';
							html += '</div>';
							$("#return").empty().append(html);
							setTimeout("loginbutton()",999);
						}else{
							var pwd = $("#pwd").val();
							var password = data.pwd;
							if(pwd == password){
							/////////////////////////登录成功/////////////////////////////////////////
								$.ajax({
									type: "get", 
									url: "http://localhost:8080/maven02/login/loginCode", 
									data: {"code" : 1},
									cache: false,
									async : false,
									success: function (data,textStatus, jqXHR){},
									error:function (XMLHttpRequest, textStatus, errorThrown){}
								});	
								if(data.admin == 1){
									var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
									html += 'Success! Admin Login! loading...';
									html += '</div>';
									$("#return").empty().append(html);
									setTimeout("ToAdminlogin("+data.id+")",999);//管理员跳后台
								}
								else if(data.admin == 0){
									var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
									html += 'Success! User Login! loading...';
									html += '</div>';
									$("#return").empty().append(html);
									setTimeout("ToUserlogin("+data.id+")",999);//管理员跳后台
								}
								else{
									alert("error");
								}
							/////////////////////////登录成功///////////////////////////////////////////////////
							}
							else if(pwd.length == 0){
								var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
								html += 'Error! Password is Empty!';
								html += '</div>';
								$("#return").empty().append(html);
								setTimeout("loginbutton()",999);
							}
							else{
								$.ajax({
									type: "get", 
									url: "http://localhost:8080/maven02/login/loginCode", 
									data: {"code" : 0}, 
									cache: false,
									async : false,
									success: function (data,textStatus, jqXHR){},
									error:function (XMLHttpRequest, textStatus, errorThrown){}
								});
								var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
								html += 'Error! Password Error !';
								html += '</div>';
								$("#return").empty().append(html);
								setTimeout("cPwdbutton()",999);
							}
						}
						
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) { 
						console.info("error");
					}
				});
			}
			function login(){
				var html = '<div class="signupdiv">';
				html += '<input class="signup" type="button"  value="SignUp" onclick="SignUpCheck()"/>';
				html += '</div>';
				html += '<div id="main">	';
				html += '<div class="whole">';
				html += '<div class="title">Please Login</div>';
				html += '<form id="form1" action="/maven02/login/selectByName" method="get" class="form_box">';
				html += '<div class="input_tit">Your Account</div>';
				html += '<div class="input_box">';
				html += '<input class="input_self" type="text" name="username" id="acc"  value="" />';
				html += '</div>';
				html += '<div class="blank_30"></div>';
				html += '<div class="input_tit">Password</div>';
				html += '<div class="input_box">';
				html += '<input class="input_self" type="password" name="password" id="pwd" value="" />';
				html += '</div>';
				html += '<div class="finish_box" id="return">';
				html += '<input class="finish_btn" type="submit" value="Login" onclick="LoginByAcc()"/>';
				html += '</div>';
				html += '</form>';
				html += '</div>';
				html += '<div style="width:30%;margin-left:35%;">';
				html += '<input class="adminlogin" type="button" value="Forget Password?" onclick="ChangePwd()"/>';
				html += '</div>';
				html += '</div>';
				$("#All").empty().append(html);
			}
			function SignUpTologin(){
				var html = '<div class="signupdiv">';
				html += '<input class="signup" type="button"  value="SignUp" onclick="SignUpCheck()"/>';
				html += '</div>';
				html += '<div id="main">	';
				html += '<div class="whole">';
				html += '<div class="title">Please Login</div>';
				html += '<form id="form1" action="/maven02/login/selectByName" method="get" class="form_box">';
				html += '<div class="input_tit">Your Account</div>';
				html += '<div class="input_box">';
				html += '<input class="input_self" type="text" name="username" id="acc"  value="" />';
				html += '</div>';
				html += '<div class="blank_30"></div>';
				html += '<div class="input_tit">Password</div>';
				html += '<div class="input_box">';
				html += '<input class="input_self" type="password" name="password" id="pwd" value="" />';
				html += '</div>';
				html += '<div class="finish_box" id="return">';
				html += '<input class="finish_btn" type="submit" value="Login" onclick="LoginByAcc()"/>';
				html += '</div>';
				html += '</form>';
				html += '</div>';
				/* html += '<div style="width:30%;margin-left:35%;">';
				html += '<input class="adminlogin" type="button" value="Forget Password?" onclick="ChangePwd()"/>';
				html += '</div>'; */
				html += '</div>';
				$("#All").empty().append(html);
			}
			function loginbutton(){
				var html = '<div class="finish_box" id="return" style="width:100%;margin-left:0;">';
				html += '<input class="finish_btn" type="submit" value="Login" onclick="LoginByAcc()"/>';
				html += '</div>';
				$("#return").empty().append(html);
			}
			function signUpbutton(){
				var html = '<div class="finish_box" id="return" style="width:100%;margin-left:0;">';
				html += '<input class="finish_btn" type="button" value="SignUp" onclick="SignUp()"/>';
				html += '</div>';
				$("#return").empty().append(html);
			}
			function ChangePwdUpbutton(){
				var html = '<div class="finish_box" id="return" style="width:100%;margin-left:0;">';
				html += '<input class="finish_btn" type="button" value="Change" onclick="UpdatePwd()"/>';
				html += '</div>';
				$("#return").empty().append(html);
			}
			function cPwdbutton(){
					var html = '<div class="signupdiv">';
					html += '<input class="signup" type="button"  value="SignUp" onclick="SignUp()"/>';
					html += '</div>';
					html += '<div id="main">	';
					html += '<div class="whole">';
					html += '<div class="title">Please Login</div>';
					html += '<form id="form1" action="/maven02/login/selectByName" method="get" class="form_box">';
					html += '<div class="input_tit">Your Account</div>';
					html += '<div class="input_box">';
					html += '<input class="input_self" type="text" name="username" id="acc"  value="" />';
					html += '</div>';
					html += '<div class="blank_30"></div>';
					html += '<div class="input_tit">Password</div>';
					html += '<div class="input_box" >';
					html += '<input class="input_self" type="password" name="password" id="pwd"  value="" />';
					html += '</div>';
					html += '<div class="finish_box" id="return">';
					html += '<input class="finish_btn" type="button" value="Login" onclick="LoginByAcc()"/>';
					html += '</div>';
					html += '</form>';
					html += '</div>';
					html += '<div style="width:30%;margin-left:35%;">';
					html += '<input class="adminlogin" type="button" value="Forget Password?" onclick="ChangePwd()"/>';
					html += '</div>';
					html += '</div>';
					$("#All").empty().append(html);
			}
			function ChangePwd(){
					var html = '<div class="signupdiv">';
					html += '<input class="signup" type="button"  value="SignUp" onclick="login()"/>';
					html += '</div>';
					html += '<div id="main">	';
					html += '<div class="whole">';
					html += '<div>';
					html += '<input class="adminlogin" type="button" value="Back to Login" onclick="login()"/>';
					html += '</div>';
					html += '<div class="title">Change Password</div>';
					html += '<form id="form1" action="/maven02/login/selectByName" method="get" class="form_box">';
					html += '<div class="input_tit">Your Account</div>';
					html += '<div class="input_box">';
					html += '<input class="input_self" type="text" name="username" id="cacc"  value="" />';
					html += '</div>';
					html += '<div class="blank_30"></div>';
					html += '<div class="input_tit">Password</div>';
					html += '<div class="input_box">';
					html += '<input class="input_self" type="password" name="password" id="cpwd" value="" />';
					html += '</div>';
					html += '<div class="input_tit">Conform Password</div>';
					html += '<div class="input_box">';
					html += '<input class="input_self" type="password" name="confpwd" id="cpassword" value="" />';
					html += '</div>';
					html += '<div class="input_tit">Your Tel</div>';
					html += '<div class="input_box">';
					html += '<input class="input_self" type="password" name="tel" id="ctel" value="" />';
					html += '</div>';
					html += '<div class="finish_box" id="return">';
					html += '<input class="finish_btn" type="button" value="Change" onclick="UpdatePwd()"/>';
					html += '</div>';
					html += '</form>';
					html += '</div>';
					html += '</div>';
					$("#All").empty().append(html);
			}
			function UpdatePwd(){
				var acc = $("#cacc").val();
				var tel = $("#ctel").val();
				var pwd = $("#cpwd").val();
				var password = $("#cpassword").val();
				var data = {
						"acc":$("#cacc").val()
				};
				$.ajax({
					type: "get", 
					url: "http://localhost:8080/maven02/login/ChangePwdByName",   
					data: data, 
					cache: false,
					async : false, 
					success: function (data,textStatus, jqXHR){
						if(tel == data.tel){
							var data = {
								"acc":acc,
								"password":password
							};
							$.ajax({
								type: "get", 
								url: "http://localhost:8080/maven02/login/UpdateByAcc",   
								data: data, 
								cache: false,
								async : false, 
								success: function (data,textStatus, jqXHR){
									$.ajax({
										type: "get", 
										url: "http://localhost:8080/maven02/login/UpdateByAccCode",   
										data: {"code":1}, 
										cache: false,
										async : false, 
										success: function (data,textStatus, jqXHR){},
										error:function (XMLHttpRequest, textStatus, errorThrown) {}
									});
									var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
									html += 'Success! Password Chanaged! Logining..';
									html += '</div>';
									$("#return").empty().append(html);
									setTimeout("SignUpTologin()",999);
								},
								error:function (XMLHttpRequest, textStatus, errorThrown) { 
									console.info("error");
								}
							});
						}
						else if(acc.length<=5){
							var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
							html += 'Error! Account is Error<br/>';
							html += "tip: Account'length is 5 at least!";
							html += '</div>';
							$("#return").empty().append(html);
							setTimeout("ChangePwdUpbutton()",999);
						}
						else if(tel.length!=11){
							var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
							html += 'Error! TelNumber is Error<br/>';
							html += "tip: Account'length must to be 11 !";
							html += '</div>';
							$("#return").empty().append(html);
							setTimeout("ChangePwdUpbutton()",999);
						}
						else if(pwd.length<=5){
							var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
							html += 'Error! Password is Error<br/>';
							html += "tip: Password'length is 5 at least!";
							html += '</div>';
							$("#return").empty().append(html);
							setTimeout("ChangePwdUpbutton()",999);
						}
						else if(pwd != password){
							var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
							html += 'Error! ConfromPassword is not same as Password';
							html += '</div>';
							$("#return").empty().append(html);
							setTimeout("ChangePwdUpbutton()",999);
						}
						else if(tel != data.tel){
							var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
							html += 'Error! Error TelNumber';
							html += '</div>';
							$("#return").empty().append(html);
							setTimeout("ChangePwdUpbutton()",999);
						}
						else {
							var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
							html += 'Error! ';
							html += '</div>';
							$("#return").empty().append(html);
							setTimeout("ChangePwdUpbutton()",999);
						}
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) { 
						console.info("error");
					}
				});
			}
			function SignUpCheck(){
				var html = '<div class="signupdiv">';
				html += '<input class="signup" type="button"  value="Login" onclick="SignUpTologin()"/>';
				html += '</div>';
				html += '<div id="main">	';
				html += '<div class="whole">';
				html += '<div class="title">SignUp</div>';
				html += '<form id="form1" action="/maven02/login/selectByName" method="get" class="form_box">';
				html += '<div class="input_tit">Your Account</div>';
				html += '<div class="input_box">';
				html += '<input class="input_self" type="text" name="username" id="acc"  value="" />';
				html += '</div>';
				html += '<div class="blank_30"></div>';
				html += '<div class="input_tit">Password</div>';
				html += '<div class="input_box" >';
				html += '<input class="input_self" type="password" name="password" id="pwd"  value="" />';
				html += '</div>';
				html += '<div class="input_tit">Conform Password</div>';
				html += '<div class="input_box" >';
				html += '<input class="input_self" type="password" name="conformPassword" id="password"  value="" />';
				html += '</div>';
				html += '<div class="input_tit">Your Tel</div>';
				html += '<div class="input_box" >';
				html += '<input class="input_self" type=""text"" name="Tel" id="tel"  value="" />';
				html += '</div>';
				html += '<div class="finish_box" id="return">';
				html += '<input class="finish_btn" type="button" value="SignUp" onclick="SignUp()"/>';
				html += '</div>';
				html += '</form>';
				html += '</div>';
				html += '</div>';
				$("#All").empty().append(html);
			}
			function SignUp(){
				var acc = $("#acc").val();
				var pwd = $("#pwd").val();
				var password = $("#password").val();
				var tel = $("#tel").val();
				$.ajax({
					type: "get", 
					url: "http://localhost:8080/maven02/login/selectAll",   
					//data: data, 
					cache: false,
					async : false, 
					success: function (data,textStatus, jqXHR){
						if(acc.length<=5){
							var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
							html += 'Error! Account is Error<br/>';
							html += "tip: Account'length is 5 at least!";
							html += '</div>';
							$("#return").empty().append(html);
							setTimeout("signUpbutton()",999);
						}
						else if(pwd.length<=5){
							var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
							html += 'Error! Password is Error<br/>';
							html += "tip: Password'length is 5 at least!";
							html += '</div>';
							$("#return").empty().append(html);
							setTimeout("signUpbutton()",999);
						}
						else if(password!=pwd){
							var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
							html += 'Error! ConformPassword is not same as Password!';
							html += '</div>';
							$("#return").empty().append(html);
							setTimeout("signUpbutton()",999);
						}
						else if(tel.length!=11){
							var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
							html += 'Error! TelNumber is Error<br/>';
							html += "tip: Password'length must to be 11!";
							html += '</div>';
							$("#return").empty().append(html);
							setTimeout("signUpbutton()",999);
						}
						else{
							for(var i=0; i<data.length; i++){
								if(data[i].acc == acc){
									var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
									html += 'Error! Account had been Signed Up!';
									html += '</div>';
									$("#return").empty().append(html);
									setTimeout("signUpbutton()",999);
									return;
								}
								else if(data[i].tel == tel){
									var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
									html += 'Error! TelNumber had been Signed Up!';
									html += '</div>';
									$("#return").empty().append(html);
									setTimeout("signUpbutton()",999);
									return;
								}
								else{
									var data = {
											"acc":$("#acc").val(),
											"pwd":$("#pwd").val(),
											"tel":$("#tel").val(),
									};
									$.ajax({
										type: "get", 
										url: "http://localhost:8080/maven02/login/insert",   
										data: data, 
										cache: false,
										async : false, 
										success: function (data,textStatus, jqXHR){
											$.ajax({
												type: "get", 
												url: "http://localhost:8080/maven02/login/insertCode",
												data: {"acc":$("#acc").val(),"code" : 1}, 
												cache: false,
												async : false,
												success: function (data,textStatus, jqXHR){
													$.ajax({
														type: "get", 
														url: "http://localhost:8080/maven02/login/SignUpByName",
														data: {"acc":$("#acc").val()}, 
														cache: false,
														async : false,
														success: function (data,textStatus, jqXHR){
															var html = '<div style="font-size:18px;text-align:center;color:#66a3ff;">';
															html += 'Success! Signed Up! Logining..';
															html += '</div>';
															$("#return").empty().append(html);
															setTimeout("ToUserlogin("+data.id+")",999);
														},
														error:function (XMLHttpRequest, textStatus, errorThrown){}
													});
												},
												error:function (XMLHttpRequest, textStatus, errorThrown){}
											});
											
										},
										error:function (XMLHttpRequest, textStatus, errorThrown) { 
											console.info("error");
										}
									});
								}
							}
						}
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) { 
						console.info("error");
					}
				});
			}
			function ToUserlogin(id){
				window.location.href="/maven02/html/back.html#?id="+id+"";
			}
			function ToAdminlogin(id){
				window.location.href="/maven02/html/back.html#?id="+id+"";
			}
			console.info("@witter--YangWenchang");
			/* 
			 * @witter
			 * 杨文畅 
			 */
	</script>
</html>
