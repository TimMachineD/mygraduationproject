<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>网上书店</title>
	<link rel="stylesheet" type="text/css" href="css/bookstore.css">
</head>
  
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="content">
		<div class="left">
			<div class=list_box>
				<div class=list_bk>
					<s:action name="browseCatalog" executeResult="true"></s:action>
				</div>
			</div>
		</div>
		<div class=right>
			<div class=right_box>
				<s:iterator value="#request['books']" id="book">
				<table width="600" border="0">
					<tr>
						<td width=200 align="center">
						<img src="/bookstore/images/<s:property value="#book.picture"/>" width="100">
						<td valign="top" width=400>
							<table>
								<tr>
									<td>书名：<s:property value="#book.bookname"/><br>
								<tr>
									<td>价格：<s:property value="#book.price"/>元
									<form action="addToCart" method="post">
										数量:<input type="text" name="quantity" value="0" size="4">
										<input type="hidden" value="<s:property value="#book.bookid"/>" name="bookid">
										<input type="image" name="submit" src="/bookstore/images/buy.gif">
									</form>
							</table>
					
				</table>
				</s:iterator>
				<s:set name="pager" value="#request.pager"></s:set>
				<s:if test="#pager.hasFirst">
					<a href="browseBookPaging.action?currentPage=1">首页</a>
				</s:if>
				<s:if test="pager.hasPrevious">
					<a href="browseBookPaging?currentPage=<s:property value="#pager.currentPage-1"/>">上一页</a>
				</s:if>
				<s:if test="pager.hasNext">
					<a href="browseBookPaging?currentPage=<s:property value="#pager.currentPage+1"/>">下一页</a>
				</s:if>
				<s:if test="pager.hasLast">
					<a href="browseBookPaging?currentPage=<s:property value="#pager.totalPage"/>">尾页</a>
				</s:if>
				<br>
				当前第<s:property value="#pager.currentPage"/>页，总共<s:property value="#pager.totalPage"/>页
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>