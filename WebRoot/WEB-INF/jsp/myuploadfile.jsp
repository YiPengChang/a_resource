<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'myuploadfile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  <body>
  			 <a href="${pageContext.request.contextPath }/index.jsp">首页</a><br>
  	
  <br>
    <table border="1"  >
    	<tr>
    		<td>
    			文件名
    		</td>
    		<td>
    			上传人
    		</td>
    		<td>
    			上传时间
    		</td>
    		<td>
    			描述
    		</td>
    		<td>
    			下载
    		</td>
    		<td>
    			删除
    		</td>
    	</tr>
    <c:forEach var="str" items="${requestScope.list}">
    	
    	<tr>
    		<td>
    		<c:out value="${str.realname }"></c:out>
    			
    		</td>
    		<td>
    		<c:out value="${str.username }"></c:out>
    			
    		</td>
    		<td>
    		<c:out value="${str.uptime }"></c:out>
    			
    		</td>
    		<td>
    		<c:out value="${str.description}"></c:out>
    			
    		</td>
    		<td>
    			<a href="${pageContext.request.contextPath }/struts/download?id=${str.id}">下载</a>
    		</td>
    		<td>
    			<a href="${pageContext.request.contextPath }/struts/delete_myuploadfile?id=${str.id}">删除</a>
    		</td>
    	</tr>
    
    
    </c:forEach>
    
    
    </table>
    
  </body>
</html>
