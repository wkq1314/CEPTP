<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表</title>
<link rel="stylesheet" type="text/css" href="css/nav.css">
<link rel="stylesheet" type="text/css" href="font/iconfont.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/nav.js"></script>
</head>
<body>
	<div class="nav">
		<div class="nav-top">
			<div id="mini"
				style="border-bottom: 1px solid rgba(255, 255, 255, .1)"></div>
		</div>
		<ul>
			<li class="nav-item"><a href="javascript:;"><i
					class="my-icon nav-icon icon_1"></i><span>角色/权限设置</span><i
					class="my-icon nav-more"></i></a>
				<ul>
					<li><a target="right" href="${pageContext.request.contextPath}/role/toRolePage"><span>添加角色</span></a></li>
					<li><a target="right" href="adduser.jsp"><span>添加用户</span></a></li>
					<li><a target="right" href="addright.jsp"><span>权限分配</span></a></li>
					<li><a href="javascript:;"><span>权限修改</span></a></li>
				</ul></li>
			<li class="nav-item"><a href="javascript:;"><i
					class="my-icon nav-icon icon_2"></i><span>文章管理</span><i
					class="my-icon nav-more"></i></a>
				<ul>
					<li><a href="javascript:;"><span>站内新闻</span></a></li>
					<li><a href="javascript:;"><span>站内公告</span></a></li>
					<li><a href="javascript:;"><span>登录日志</span></a></li>
				</ul></li>
			<li class="nav-item"><a href="javascript:;"><i
					class="my-icon nav-icon icon_3"></i><span>订单管理</span><i
					class="my-icon nav-more"></i></a>
				<ul>
					<li><a href="javascript:;"><span>订单列表</span></a></li>
					<li><a href="javascript:;"><span>打个酱油</span></a></li>
					<li><a href="javascript:;"><span>也打酱油</span></a></li>
				</ul></li>
		</ul>
	</div>
</body>
</html>