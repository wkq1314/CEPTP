<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加角色</title>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css" />
<link
	href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
<link rel="stylesheet" type="text/css" href="css/build.css">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<title>添加权限</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"> 添加用户</a>
		</div>
	</div>
	</nav>
	<div style="margin-left: 10%;">
		<div class="row">
			<div class="form-group">
				<label class="col-sm-2 control-label">角色名</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="id" value="张三"
						readonly="readonly" style="width: 200px">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<fieldset>
					<legend>权限分配 </legend>
					<div class="checkbox">
						<input id="checkbox1" class="styled" type="checkbox"> <label
							for="checkbox1"> Default </label>
					</div>
					<div class="checkbox checkbox-primary">
						<input id="checkbox2" class="styled" type="checkbox" checked>
						<label for="checkbox2"> Primary </label>
					</div>
					<div class="checkbox checkbox-success">
						<input id="checkbox3" class="styled" type="checkbox"> <label
							for="checkbox3"> Success </label>
					</div>
					<div class="checkbox checkbox-info">
						<input id="checkbox4" class="styled" type="checkbox"> <label
							for="checkbox4"> Info </label>
					</div>
					<div class="checkbox checkbox-warning">
						<input id="checkbox5" type="checkbox" class="styled" checked>
						<label for="checkbox5"> Warning </label>
					</div>
				</fieldset>
			</div>

		</div>
	</div>
</body>
</html>