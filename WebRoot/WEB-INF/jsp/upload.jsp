<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'upload.jsp' starting page</title>
    

  </head>
  <script type="text/javascript">
  		function add(){
  			var files = document.getElementById("files");
  			
  			var input = document.createElement("input");
  			input.type='file';
  			input.name='file';
  			
  			var but = document.createElement("input");
  			but.type='button';
  			but.value='删除';
  			but.onclick=function dele(){
  				this.parentNode.parentNode.removeChild(this.parentNode);
  			}
  			
  			var d2 = document.createElement("div");
  			d2.appendChild(input);
  			d2.appendChild(but);
  			files.appendChild(d2);
  			
  		
  		}
  
  
  
  </script>
  <body style="text-align: center;">
  <a href="${pageContext.request.contextPath }/index.jsp">首页</a><br>
  <form action="${pageContext.request.contextPath }/struts/upload_execute" enctype="multipart/form-data" method="post">
   	<table  >
   		
   		
   		
   		
   		<tr>
   			<td>描述：</td>
   			<td>
   				<textarea rows="3" cols="30" name="description"></textarea><s:fielderror fieldName="description"></s:fielderror>(可以不填，如果要填，长度需要15)
   			</td>
   		</tr>
   	
   	
   		<tr>
   			<td>上传文件：</td>
   			<td><input value="添加文件" type="button" onclick="add()"><s:fielderror  fieldName="file"></s:fielderror></td>
   		</tr>
   		
   		<tr>
   			<td></td>
   			<td>
	   			<div id="files">
	   			
	   			</div>
   			</td>
   		</tr>
   		<tr>
   			<td></td>
   			<td>
	   			<input type="submit" value="上传">
   			</td>
   		</tr>
   		
   		
   	
   	</table>
   	</form>
  </body>
</html>
