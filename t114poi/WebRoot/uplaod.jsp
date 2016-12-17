<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'uplaod.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>	
  	<form action="${pageContext.request.contextPath}/upload/uploadAction" method="post" enctype="multipart/form-data" > 
  		<input type="file" name="myfile"/><br/>
  		<input type="file" name="myfile"/><br/>
  		<input type="submit" value="上传"/>
  	</form>
  </body>
</html>
