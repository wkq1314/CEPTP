<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
    <%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("path", basePath);  
%>  
=======
    
    <%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
	request.setAttribute("path", basePath);  
	%>  
>>>>>>> 5758bae13a5815efc56d1373c389809fefa51c9c
 <span style="font-family:KaiTi_GB2312;font-size:18px;"><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>    
      <head>    
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
        <title>freamsetindex</title>    
          
    <frameset rows="15%,85%">  
<<<<<<< HEAD
      <frame noresize="noresize" name="top" src="${path }top.jsp" /><!-- 拥有15%的高度 -->  
=======
      <frame noresize="noresize" name="top" src="${pageContext.request.contextPath}/top.jsp" /><!-- 拥有15%的高度 -->  
>>>>>>> 5758bae13a5815efc56d1373c389809fefa51c9c
        <frameset cols="15%,85%"><!--拥有80%的高度-->  
            <frame noresize="noresize" name="left" src="${path }left.jsp"><!--拥有25%的宽度-->  
            <frame noresize="noresize" name="right" src=""><!--拥有75%的宽度-->  
        </frameset>  
    </frameset>  
      
    </html>  </span>
