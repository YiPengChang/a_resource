<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="${pageContext.request.contextPath }/bootstrap2.3.2/css/bootstrap.min.css" rel="stylesheet" />
    <title></title>
    <link href="${pageContext.request.contextPath }/styles/Common.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/styles/Index2.css" rel="stylesheet" />
</head>
<body>

    <div class="container-fluid">
        <div class="row-fluid">
        <a href="${pageContext.request.contextPath }/index.jsp">首页</a><br>
        <form action="${pageContext.request.contextPath }/struts/find_like" method="post">
  		<input name="str" type="text" value="${str }">
  		<input type="submit" value="搜索">
  	</form>
            <h4>数据列表</h4>
            <div class="add"><a class="btn btn-success" onclick="openadd();">新增</a></div>
            <div class="w">
                <div class="span12">
                    <table class="table table-condensed table-bordered table-hover tab">
                        <thead>
                            <tr>
                                <th>文件名</th>
                                <th>上传人</th>
                                <th>上传时间</th>
                                <th>描述</th>
                                <th>操作</th>
                            </tr>
                            <c:forEach var="str" items="${requestScope.list}">
                            <tr>
                                <th><c:out value="${str.realname }"></c:out></th>
                                <th><c:out value="${str.username }"></c:out></th>
                                <th><c:out value="${str.uptime }"></c:out></th>
                                <th><c:out value="${str.description}"></c:out></th>
                                <th><a style="color: red;" href="${pageContext.request.contextPath }/struts/download?id=${str.id}">下载</a>；<a style="color: red;" href="${pageContext.request.contextPath }/struts/my_baocun?id=${str.id}">保存到我的云盘</a>；<a style="color: red;" href="${pageContext.request.contextPath }/struts/delete_download?id=${str.id}">删除</a></th>
                            </tr>
                             </c:forEach>
                        </thead>
                        <tbody id="tbody"></tbody>
                    </table>
                    <div id="page" class="tr"></div>
                </div>
            </div>


            <div id="addModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">添加成绩</h3>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="control-group">
                            <label class="control-label" for="userName">姓名</label>
                            <div class="controls">
                                <input type="text" id="userName" placeholder="姓名">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="Chinese">语文</label>
                            <div class="controls">
                                <input type="text" id="Chinese" placeholder="语文">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="Math">数学</label>
                            <div class="controls">
                                <input type="text" id="Math" placeholder="数学">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="English">英语</label>
                            <div class="controls">
                                <input type="text" id="English" placeholder="英语">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
                    <button class="btn btn-primary" id="add" onclick="add();">保存</button>
                    <button class="btn btn-primary" id="edt" onclick="edt();">保存</button>
                </div>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap2.3.2/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/layer-v2.3/layer/layer.js"></script>
    <script src="${pageContext.request.contextPath }/laypage-v1.3/laypage/laypage.js"></script>
    <script src="${pageContext.request.contextPath }/scripts/Index2.js"></script>
</body>
</html>
