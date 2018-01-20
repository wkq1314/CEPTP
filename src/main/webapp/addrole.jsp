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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link
	href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/htmleaf-demo.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/build.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"> 添加角色</a>
		</div>
		
	</div>
	</nav>
	<div style="margin-left: 10%;">
	<form id="form1" action="<c:url value='/role/addRole'/>" method="post">
		<div class="row">
			<div class="form-group">
				<label class="col-sm-2 control-label">角色名</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="role_name" value=""
						style="width: 200px">
					<input type="hidden" id="newPrivilegeList" name="newPrivilegeList" value="" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<fieldset>
					<legend>权限分配 </legend>
					<c:forEach items="${privilegeList }" var="privilege" varStatus="status">
					<div class="checkbox checkbox-info">
						<input id="${status.index }" name="pcheck" class="styled" type="checkbox" value="${privilege.privilege_id }"> <label
							for="${status.index }"> ${privilege.privilege_name } </label>
					</div>
					</c:forEach>
					<div style="text-align: center">
				<button type="submit" class="btn btn-success" onclick="addRole();">添加角色</button>
			</div>
				</fieldset>
			</div>
			
		</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	function addRole(){
		//获得所有的权限选框
		var checkBoxStr = document.getElementsByName("pcheck");
		var result = ""
		for( var i = 0;i<checkBoxStr.length;i++){
			if(checkBoxStr[i].checked == true){
				result += checkBoxStr[i].value;
				result+=",";
			}
		}
		result = result.substring(0,result.lastIndexOf(","));
		$("#newPrivilegeList").val(result);
		$("#form1").submit();
	}
</script>
</html>