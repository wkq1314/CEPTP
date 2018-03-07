<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>加入课程</title>
		<link href="${pageContext.request.contextPath}/css/fourthpage.css" type="text/css" rel="stylesheet">
		<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
		
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
		<form action="<c:url value='/course/joinCourse'/>">
		<div class="detail">
			<input type="hidden" name="course_id" value="${course_id }">
			<span style="font-family: '微软雅黑''">输入邀请码：*</span><br />
			<input type="text" class="form-control" name="invitation_code" /><br />
			
			<div class="sub">
				<button type="submit" class="btn btn-default" style="margin-right: 200px">提交</button>
				<button type="button" class="btn btn-default">取消</button>
				
			</div>
		</div>
		</form>
	</body>
</html>
