<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html><head>
<title>xxx</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style2.0.css">
<style type="text/css">
	ul li{font-size: 30px;color:#2ec0f6;}
	.tyg-div{z-index:-1000;float:left;position:absolute;left:5%;top:20%;}
	.tyg-p{
		font-size: 14px;
	    font-family: 'microsoft yahei';
	    position: absolute;
	    top: 135px;
	    left: 60px;
	}
	.tyg-div-denglv{
		z-index:1000;float:right;position:absolute;right:3%;top:10%;
	}
	.tyg-div-form{
		background-color: #23305a;
		width:300px;
		height:auto;
		margin:120px auto 0 auto;
		color:#2ec0f6;
	}
	.tyg-div-form form {padding:10px;}
	.tyg-div-form form input[type="text"]{
		width: 270px;
	    height: 30px;
	    margin: 25px 10px 0px 0px;
	}
	a{
		color:red;
	}
	.tyg-div-form form button {
	    cursor: pointer;
	    width: 270px;
	    height: 44px;
	    margin-top: 25px;
	    padding: 0;
	    background: #2ec0f6;
	    -moz-border-radius: 6px;
	    -webkit-border-radius: 6px;
	    border-radius: 6px;
	    border: 1px solid #2ec0f6;
	    -moz-box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    -webkit-box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
	    font-size: 14px;
	    font-weight: 700;
	    color: #fff;
	    text-shadow: 0 1px 2px rgba(0,0,0,.1);
	    -o-transition: all .2s;
	    -moz-transition: all .2s;
	    -webkit-transition: all .2s;
	    -ms-transition: all .2s;
}
</style>
<body>
<div class="tyg-div">
	<ul>
    	<li>让</li>
    	<li><div style="margin-left:20px;">数</div></li>
    	<li><div style="margin-left:40px;">据</div></li>
    	<li><div style="margin-left:60px;">改</div></li>
    	<li><div style="margin-left:80px;">变</div></li>
    	<li><div style="margin-left:100px;">生</div></li>
    	<li><div style="margin-left:120px;">活</div></li>
    </ul>
</div> 
<div id="contPar" class="contPar">
	<div id="page1"  style="z-index:1;">
		<div class="title0">校内小型资源共享网</div>
		<div class="title1"><c:if test="${sessionScope.user==null}">
       						请您先<a href="${pageContext.request.contextPath }/loginUI.jsp">登录</a>或者<a href="${pageContext.request.contextPath }/adduserUI.jsp">注册</a>
       					</c:if>
       					<c:if test="${sessionScope.user!=null}">
       						欢迎您：<a href="${pageContext.request.contextPath }/struts/my_UI">${sessionScope.user.nickname}</a>,&nbsp&nbsp&nbsp&nbsp&nbsp<a href="${pageContext.request.contextPath }/struts/login_tuichulogin">退出登录</a>
       					</c:if><br/>
       					<a  href="${pageContext.request.contextPath }/struts/upload_getUI">上传资源</a>
       					<a  href="${pageContext.request.contextPath }/struts/find_getAll">下载资源</a>
       	</div>
		<div class="imgGroug">
			<ul>
				<img alt="" class="img0 png" src="${pageContext.request.contextPath }/img/page1_0.png">
				<img alt="" class="img1 png" src="${pageContext.request.contextPath }/img/page1_1.png">
				<img alt="" class="img2 png" src="${pageContext.request.contextPath }/img/page1_2.png">
			</ul>
		</div>
		<img alt="" class="img3 png" src="./img/page1_3.jpg">
	</div>
</div>



<script type="text/javascript" src="./js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="./js/com.js"></script>
<!--[if IE 6]>
<script language="javascript" type="text/javascript" src="./script/ie6_png.js"></script>
<script language="javascript" type="text/javascript">
DD_belatedPNG.fix(".png");
</script>
<![endif]-->
<div style="text-align:center;">
<p>æ¥æº:<a href="http://www.mycodes.net/" target="_blank">æºç ä¹å®¶</a></p>
</div>


</body>
</html>