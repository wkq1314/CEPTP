<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>

<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/regist.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" /> 

<script type="text/javascript">

function _hyz() {
	/*
	 * 1. 获取<img>元素
	 * 2. 重新设置它的src
	 * 3. 使用毫秒来添加参数
	 */
	$("#imgVerifyCode").attr("src", "${pageContext.request.contextPath}/user/verifyCode?a=" + new Date().getTime());
}
/*
 * face校验
 */
function validateFile(ele){
    // 返回 KB，保留小数点后两位
    //alert((ele.files[0].size/(1024*1024)).toFixed(2));
    var file = ele.value;
     id  = "file";
    if(!/.(gif|jpg|jpeg|png|GIF|JPG|bmp)$/.test(file)){
    	$("#" + id + "Error").text("图片类型必须是.gif,jpeg,jpg,png,bmp中的一种！");
		showError($("#" + id + "Error"));
         return false;
          
    }else{
             
        //alert((ele.files[0].size).toFixed(2));
        //返回Byte(B),保留小数点后两位
       if(((ele.files[0].size).toFixed(2))>=(1024*1024)){
    	$("#" + id + "Error").text("请上传小于1M的图片！");
   		showError($("#" + id + "Error"));
        return false;
        }
    }
}
</script>
</head>
<body>
<img src="${pageContext.request.contextPath}/img/background.jpg" style="width:100%;height:1003px; -webkit-filter: blur(5px);filter: blur(5px);"/>  

<div id="divMain" style="position: absolute;top:88px">
  <div class="huanchong"></div>
  <div style="height: 100px;width: 186px;position: absolute;left:98px;top:-66px;">
  	<h3 style="font-family: 微软雅黑;font-size: 50px;color: #fff;font-weight: bold;">Sign up</h3>
  </div>
  <div id="divBody">
<form action="<c:url value='/user/userSignUP'/>" method="post" id="registForm" enctype="multipart/form-data">
    <table id="tableForm">
      <tr>
        <td class="tdText" style="color: #000">用户名*：</td>
        <td class="tdInput">
          <input class="inputClass form-control" type="text" name="user_id" id="loginname" value="${form.loginname }"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="loginnameError">${errors.loginname }</label>
        </td>
      </tr>
      <tr>
        <td class="tdText" style="color: #000">姓名*：</td>
        <td class="tdInput">
          <input class="inputClass form-control" type="text" name="user_name" id="username" value="${form.loginname }"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="usernameError">${errors.username }</label>
        </td>
      </tr>
      <tr>
        <td class="tdText" style="color: #000">登录密码*：</td>
        <td>
          <input class="inputClass form-control" type="password" name="password" id="loginpass" value="${form.loginpass }"/>
        </td>
        <td>
          <label class="errorClass" id="loginpassError">${errors.loginpass }</label>
        </td>
      </tr>
      <tr>
        <td class="tdText" style="color: #000">确认密码*：</td>
        <td>
          <input class="inputClass form-control" type="password" name="reloginpass" id="reloginpass" value="${form.reloginpass }"/>
        </td>
        <td>
          <label class="errorClass" id="reloginpassError">${errors.reloginpass}</label>
        </td>
      </tr>
      <tr>
        <td class="tdText" style="color: #000">班级：</td>
        <td class="tdInput">
          <input class="inputClass form-control" type="text" name="class_name" id="classname" value="${form.loginname }"/>
        </td>
        <td class="tdError">
        </td>
      </tr>
      <tr>
        <td class="tdText" style="color: #000">职称：</td>
        <td class="tdInput">
          <input class="inputClass form-control" type="text" name="professional_title" id="pt" value="${form.loginname }"/>
        </td>
        <td class="tdError">
        </td>
      </tr>
      
      <tr>
        <td class="tdText" style="color: #000">专业：</td>
        <td class="tdInput">
          <input class="inputClass form-control" type="text" name="pro" id="pro" value="${form.loginname }"/>
        </td>
        <td class="tdError">
        </td>
      </tr>
      <tr>
        <td class="tdText" style="color: #000">手机号*：</td>
        <td class="tdInput">
          <input class="inputClass form-control" type="text" name="mobile" id="mb" value="${form.loginname }"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="mbError">${errors.mb }</label>
        </td>
      </tr>
     
      <tr>
        <td class="tdText" style="color: #000">简介：</td>
        <td class="tdInput">
          <textarea class="inputClass form-control" rows="3" name="detail" id="cn"></textarea>
        </td>
        <td class="tdError">
        </td>
      </tr>
      
      <tr>
      	<td class="tdText" style="color: #000"</td>
        <td>
        	<span>添加头像：</span></br>
          <div class="clphoto">
				<label for="file" class="filephoto">+</label>
				<input type="file" id="file" class="ph" style="display:none;" name="face" onchange="javascript:validateFile(this);">
			</div>
        </td>
      	<td>
      		<label class="errorClass" id="fileError" style="position: relative;left: -157px;top: 23px;">${errors.face }</label>
      	</td>
			
	</tr>
      <tr>
        <td class="tdText" style="color: #000">验证码*：</td>
        <td>
          <input class="inputClass form-control" type="text" name="verifyCode" id="verifyCode" value="${form.verifyCode }"/>
        </td>
        <td>
          <label class="errorClass" id="verifyCodeError">${errors.verifyCode}</label>
        </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <div id="divVerifyCode"><img id="imgVerifyCode" src="<c:url value='/user/verifyCode'/>"/></div>
        </td>
        <td>
          <label ><a href="javascript:_hyz()"style="color: #fff">换一张</a></label>
        </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10"style="position: relative;left: 27px;top:53px">
					      <button type="submit" class="btn btn-default" >提交注册</button>
    </div>
    	</div>
        </td>
        <td>
          <label></label>
        </td>
      </tr>
    </table>
</form>    
  </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/regist.js"></script>
</html>