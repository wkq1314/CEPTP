<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<title>初始化页面</title>
<style>
::-ms-browse, [type='file'] {
	padding: .4em;
	line-height: 24px;
	border: 1px solid #a0b3d6;
	background: #f0f3f9;
	color: #34538b;
}

::-webkit-file-upload-button {
	padding: .4em;
	line-height: 30px;
	border: 1px solid #a0b3d6;
	background: #f0f3f9;
	color: #34538b;
}
</style>
</head>
<body>
	<div class="form-group">
		<label for="inputEmail3" class="col-sm-2 control-label"><button
				type="button" class="btn btn-success">导入教师信息</button> </label>
		<div class="col-sm-10">
			<input type="file" />
		</div>
	</div>
	<div class="form-group">
		<label for="inputEmail3" class="col-sm-2 control-label"><button
				type="button" class="btn btn-success">导入学生信息</button> </label>
		<div class="col-sm-10">
			<input type="file" />
		</div>
	</div>
</body>
</html>
