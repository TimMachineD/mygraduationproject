<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>мЬиоилЁг</title>
	<link rel="stylesheet" type="text/css" href="css/index.css">
  </head>
  
  <body>
    <jsp:include page="headtest.jsp"></jsp:include>
    <div class="category">
		
	</div>
	<div class="categorySecond">
		<ul>
			<s:iterator var="cs" value="#session.csList">
			 	<li>
			 		<a href="${ pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="#cs.csid"/>&page=1">
			 		<s:property value="#cs.csname"/></a>
			 	</li>
			</s:iterator>
		</ul>	
	</div>
	 <jsp:include page="foot.jsp"></jsp:include>
  </body>
</html>
