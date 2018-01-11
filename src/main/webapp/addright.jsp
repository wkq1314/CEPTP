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
	href="${path }bootstrap/css/bootstrap.min.css" />
<link
	href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${path }css/htmleaf-demo.css">
<link rel="stylesheet" type="text/css" href="${path }css/build.css">
<script type="text/javascript" src="${path }js/jquery-3.2.1.js"></script>
<title>添加权限</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"> 修改角色</a>
		</div>
	</div>
	</nav>
	<div style="margin-left: 10%;">
	<form id="form1" action="<c:url value='/role/editRoleInfo'/>" method="post">
		<div class="row">
			<div class="form-group">
				<label class="col-sm-2 control-label">角色名</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="role_name" value="${role_name }"
						style="width: 200px">
					<input type="hidden" name="role_id" value="${role_id }" />
					<input type="hidden" id="newPrivilegeList" name="newPrivilegeList" value="" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<fieldset>
					<legend>权限分配 </legend>
					<c:forEach items="${pPrivilegeList }" var="parentPrivilege" varStatus="status">
					<div class="checkbox checkbox-info">
						<input id="${status.index }" name="pcheck" class="styled" type="checkbox" value="${parentPrivilege.privilege_id }"> <label
							for="${status.index }"> ${parentPrivilege.privilege_name } </label>
					</div>
					</c:forEach>
					<div style="text-align: center">
				<button type="submit" class="btn btn-success" onclick="editRole();">修改角色</button>
			</div>
				</fieldset>
			</div>
			
		</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		//获得所有的权限选框
		var checkBoxStr = document.getElementsByName("pcheck");
		//获得当前角色的所有权限
		var chPrivilegeList = Array();
		chPrivilegeList= "${chPrivilegeList}".replace('[','').replace(']','').split(', '); 
		//alert(chPrivilegeList);
		//比较权限与选框名，相同就使选中
		for( var i = 0;i<checkBoxStr.length;i++){
			for( var j = 0;j<chPrivilegeList.length;j++){
				//alert("xuank"+checkBoxStr[i].value);
				//alert("quanj"+chPrivilegeList[j]);
				if(checkBoxStr[i].value == chPrivilegeList[j]){
					//alert(i+","+j)
					checkBoxStr[i].checked = true;
					break;
				}
			}
		}
	});
	function editRole(){
		//获得所有的权限选框
		var checkBoxStr = document.getElementsByName("pcheck");
		var result = ""
		for( var i = 0;i<checkBoxStr.length;i++){
			if(checkBoxStr[i].checked == true){
				result += checkBoxStr[i].value;
				if(i != checkBoxStr.length-1){
					result+=",";
				}
			}
		}
		$("#newPrivilegeList").val(result);
		$("#form1").submit();
	}
</script>
</html>