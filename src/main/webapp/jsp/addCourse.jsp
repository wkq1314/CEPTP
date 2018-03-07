<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>添加课程</title>
		
		<link href="${pageContext.request.contextPath}/css/fourthpage.css" type="text/css" rel="stylesheet">
		<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
		<script  type="text/javascript" >
			function AddMoreRow(){
					var oRow = event.srcElement.parentNode.parentNode;
					var oTable = oRow.parentNode.parentNode;
					var rowCount = oTable.rows.length;
					oNewRow = oTable.insertRow(rowCount);
					oNewRow.insertCell(0).innerHTML = "<input type='text' class='form-control' name='course_lable'style='width:223px;margin-bottom:3px;' />";
				}
	
		</script>
	</head>
	  
	
	<body>
     <header class="head1" style="height: 43px;width: 1089px;margin-bottom: 20px;margin: 0 auto;" >
        <div class="title container">
            <div class="flphoto">
            	
                <img class="" src="${pageContext.request.contextPath}/img/logo.jpg">
            </div>
            <h5 class="fl">我的班课</h5>
            <a class="fr exit" href="">
                <div class="fr light">
                    	退出
                </div>
            </a>
            <div class="title-menu fr">
                <ul class="fr">
                    <li class="fr">
                        <img src="" alt="" class="fl glyphicon glyphicon-user">
                        <h6>黄浩然</h6>
                    </li>
                    <li class="fr line">
                        <img src="" alt="" class="fl glyphicon glyphicon-pencil">
                        <h6>我的题库</h6>
                    </li>
                    <li class="fr line">
                        <img src="" alt="" class="fl glyphicon glyphicon-cog">
                        <h6>库管理</h6>
                    </li>
                    <li class="fr line">
                        <img src="" alt="" class="fl glyphicon glyphicon-gift">
                        <h6>课程包</h6>
                    </li>
                    <li class="fr line">
                        <img src="" alt="" class="fl glyphicon glyphicon-book">
                        <h6>任务中心</h6>
                    </li>
                   
                </ul>
            </div>
        </div>
    </header>
		<form action="<c:url value='/course/addCourse'/>">
		<div class="detail">
			<span style="font-family: '微软雅黑''">学校*</span><br />
			<input type="text" class="form-control" name="school" /><br />
			<span>课程名*</span><br />
			<input type="text" class="form-control" name="course_name" /><br />
			<table style="margin-bottom:20px;">
				<tr>
					<td><input class="btn btn-info" type="button" value="添加标签" onclick="AddMoreRow()"><br /></td>
				</tr>
			</table>
			<span>课程简介</span><br />
			<textarea class="form-control" rows="3" name="course_notes"></textarea>
			<span>适用专业</span><br />
			<input type="text" class="form-control" name="application_pro" /><br />
			<span>添加课程图片</span><br />
			<div class="clphoto">
				<label for="file" class="filephoto">+</label>
				<input type="file" id="file" style="display:none;" name="course_img">
			</div>
			<div class="sub">
				<button type="submit" class="btn btn-default" style="margin-right: 200px">提交</button>
				<button type="button" class="btn btn-default">取消</button>
				
			</div>
		</div>
		</form>
	</body>
</html>
