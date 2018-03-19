<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>网上商城</title>
	<link rel="stylesheet" type="text/css" href="css/index.css">
  </head>
  
  <body>
    <jsp:include page="head.jsp"></jsp:include>
    <div class="menu">
		<ul>
			<li><a href="index.action">首页</a> |</li>
			<s:iterator var="c" value="#session.cList">
			<li>
			<!-- <a href="product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"> -->
			<s:property value="#c.cname"/></a> |</li>
			</s:iterator>

		</ul>
	</div>	
    
	<jsp:include page="foot.jsp"></jsp:include>
  </body>
</html>
