<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'my.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    	<a href="${pageContext.request.contextPath }/index.jsp">首页</a><br>
    	<a href="${pageContext.request.contextPath }/struts/my_myuploadfile">我上传的资源</a>
    	<a href="${pageContext.request.contextPath }/struts/my_myyunpan">我的云盘</a><br>
    	
  </body>
</html>
