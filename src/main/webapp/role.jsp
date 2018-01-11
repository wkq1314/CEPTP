<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("path", basePath);  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加角色</title>
<link rel="stylesheet" type="/text/css"
	href="${path }/bootstrap/css/bootstrap.min.css" />


</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"> 添加用户</a>
		</div>
	</div>
	</nav>
	<table class="table table-striped  bandTable" id="viewTabs">
		<thead>
			<tr>
				<th>角色名称</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${roleList }" var="role" varStatus="status">
			<tr>
				<td><input type="text" class="form-control" name="role_name"
					value="${role.role_name}">
					</td>
				<td><input type="text" class="form-control" name="role_create"
					value="${role.create_user}"></td>
				<td><input type="text" class="form-control"
					name="role_createTime" value="${role.create_time }"></td>
				<td><a class="btn btn-default" href="<c:url value='/role/toUpdateRole?role_id=${role.role_id }&role_name=${role.role_name }&parent_role_id=${role.parent_role_id }'/>"
					 >修改权限</a> <a class="btn btn-default"
					href="toupdateEmployee">添加用户</a></td>
				<td></td>
			</tr>
	</c:forEach>
		</table>
			<div style="text-align: center">
				<a href="<c:url value='/role/toAddRole' />"><button type="button" class="btn btn-success" >添加角色</button></a>
			</div>
</body>
<script type="text/javascript" src="${path }/js/jquery-3.2.1.js"></script>
</html>