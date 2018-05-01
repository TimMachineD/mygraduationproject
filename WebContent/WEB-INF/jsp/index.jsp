<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>网上商城</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>

<body>
	<jsp:include page="headtest.jsp"></jsp:include>
	<div class="container index">
		<div class="span24">
			<div id="maintable" class="maintable clearfix">
				<div class="category">
				<ul>
					<s:iterator var="c" value="#session.cList">
						<li><a
							href="${pageContext.request.contextPath}/index_showSecCategory.action?cid=<s:property value="#c.cid"/>">
								<s:property value="#c.cname" />
						</a></li>
					</s:iterator>
				</ul>
			</div>
			</div>
			
		</div>
		<div class="span24">
			<div id="newProduct" class="newProduct clearfix">
				<div class="title">
					<strong>最新商品</strong> <a target="_blank"></a>
				</div>
				<ul class="tab">
					<li class="current"><a href="./蔬菜分类.htm?tagIds=2"
						target="_blank"></a></li>
					<li><a target="_blank"></a></li>
					<li><a target="_blank"></a></li>
				</ul>
				<!-- 					<div class="newProductAd">
									<img src="image/q.jpg" width="260" height="343" alt="最新商品" title="最新商品">
						</div>
						 -->
				<ul class="tabContent" style="display: block;">
					<s:iterator var="p" value="nList">
					<li><a href="product_findByPid.action?pid=<s:property value="#p.pid" />" target="_blank"><img src="<s:property value="#p.image" />"
							style="display: block;" /></a>
					</li>
					</s:iterator>
				</ul>
		</div>
	</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
