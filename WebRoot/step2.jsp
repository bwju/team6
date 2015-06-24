<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:useBean id="uploadFile1" scope="page" class="src.UploadFile1" />
<% uploadFile1.upload(request,pageContext);%>
<!DOCTYPE>
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>上传结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <style type="text/css">
<!--
.style1 {font-size: x-large}
-->
    </style>
  </head>
<body>
<span class="style1"><%=uploadFile1.getFilenames() %> <br>
	  <a href="Http://www.baidu.com">点击我查看上传文件分析流程图</a>
      <%
      System.out.println(uploadFile1.getFilenames());
      //response.sendRedirect("./rootSiteView.jsp"); %>
</span>
  </body>
</html>
