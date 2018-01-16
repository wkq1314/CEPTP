<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("path", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>绑定用户</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"> 绑定用户</a>
		</div>
	</div>
	</nav>
	<form id="form1" action="<c:url value='/role/bindUserForRole'/>" method="post">
		<input type="hidden" name="userIdStrs"  id="teacherIdList" value=""/>
		<input type="hidden" name="role_id"  id="role_id" value="${role_id }"/>
		<table class="table table-striped  bandTable" id="viewTabs">
			<thead>
				<tr>
					<th></th>
					<th>姓名</th>
					<th>工号</th>
					<th>性别</th>
					<th>学院</th>
					<th>系部</th>
					<th>专业</th>
					<th>是否离职</th>
					<th>联系电话</th>
				</tr>
				<c:forEach items="${teacherList }" var="teacher" varStatus="status">
					<tr>
						<td align="left"><input value="${teacher.staff_id }"
							type="checkbox" name="teacheck" "/></td>
						<td><input type="text" class="form-control" name="user_name"
							value="${teacher.staff_name }"></td>
						<td><input type="text" class="form-control" name="user_id"
							value="${teacher.staff_id }"></td>
						<td><input type="text" class="form-control"
							name="user_gender" value="${teacher.sex }"></td>
						<td><input type="text" class="form-control"
							name="user_college" value="${teacher.college_id }"></td>
						<td><input type="text" class="form-control" name="user_dept"
							value="${teacher.dept_id }"></td>
						<td><input type="text" class="form-control" name="user_pro"
							value="${teacher.pro_id }"></td>
						<td><input type="text" class="form-control"
							name="user_dimission" value="${teacher.is_dimission }"></td>
						<td><input type="text" class="form-control" name="user_phone"
							value="${teacher.mobile }"></td>
					</tr>
				</c:forEach>
			</thead>
		</table>
		<div style="text-align: center">
			<button type="button" class="btn btn-success" onclick="addUser();">绑定用户</button>
		</div>
	</form>
</body>
<script type="text/javascript">
	function addUser() {
		//获得所有的权限选框
		var checkBoxStr = document.getElementsByName("teacheck");
			//alert(checkBoxStr.length);
			var result = "";
			for (var i = 0; i < checkBoxStr.length; i++) {
				if (checkBoxStr[i].checked == true) {
					result += checkBoxStr[i].value;
					//alert("i "+i);
					result += ",";
				}
			}
			if(result!=""){
				//alert(result);
				result = result.substring(0,result.lastIndexOf(","));
				//alert(result);
				$("#teacherIdList").val(result);
				$("#form1").submit();
			}
			
		else{
			alert("请选择教师员工");
		}
	}
</script>
</html>