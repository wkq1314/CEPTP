<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Login and Registration Form with HTML5 and CSS3" />
<meta name="keywords"
	content="html5, css3, form, switch, animation, :target, pseudo-class" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style3.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animate-custom.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animate-custom.css" />
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<header>
		<h1>
			欢迎使用 <span>教学管理系统</span>
		</h1>
		</header>
		<section>
		<div id="container_demo">
			<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
			<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
				id="tologin"></a>
			<div id="wrapper">
				<div id="login" class="animate form">
					<form action="${pageContext.request.contextPath}/user/checkIdentity" method="post">
						<h1>Log in</h1>
						<p>
							<label for="userid" class="uid" data-icon="u"> 用户名 </label> <input
								id="userid" name="userid" required="required" type="text"
								placeholder="myusername or mymail@mail.com" />
						</p>
						<p>
							<label for="password" class="youpasswd" data-icon="p"> 密码
							</label> <input id="password" name="password" required="required"
								type="password" placeholder="eg. X8df!90EO" />
						</p>
						<div class="form-group">
							<select class="form-control" name="usercategory">
								<option selected="selected" value="0">学生</option>
								<option value="1">教师</option>
							</select>
						</div>
						<p class="login button" style="text-align: center;">
							<button type="submit" class="btn btn-primary">登录（login）</button>

							<!-- Indicates a successful or positive action -->
							<button type="button" class="btn btn-success">取消(cancel)</button>
						</p>
					</form>
				</div>
			</div>
		</div>
		</section>
	</div>
</body>
</html>