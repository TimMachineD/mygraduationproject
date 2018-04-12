<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>мЬиоилЁг</title>
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<link rel="stylesheet" type="text/css" href="css/product.css">
  </head>
  
  <body>
    <jsp:include page="head.jsp"></jsp:include>
    <div class="category">
		
	</div>
	<div class="categorySecond">
		<ul>
			<s:iterator var="cs" value="#session.csList">
			 	<li>
			 		<a href="index_index.action">
			 			<s:property value="#cs.csname"/>
			 		</a>
			 	</li>
			</s:iterator>
		</ul>
	</div>	
	
  </body>
</html>
