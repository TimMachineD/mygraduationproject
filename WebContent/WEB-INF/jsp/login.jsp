<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�����̳�</title>
	<link rel="stylesheet" type="text/css" href="css/index.css">
  </head>
  
  <body>
    <jsp:include page="headtest.jsp"></jsp:include>
    <div class="container index">
		<div class="span24">
			<div id="maintable" class="maintable clearfix">
				<div align="center">
						<form action="${pageContext.request.contextPath}/user_login.action" method="post" name="login">
							<table>
								<tr>
									<td colspan="2" align="center">�û���¼</td>
								<tr height="23">
									<td colspan="2" align="center"><s:actionerror /></td>
								<tr>
									<td>�û���:<td><input type="text" name="username" size=20 id="username" style="width:182px;">
								<tr>
									<td>����:<td><input type="password" name="password" size=21 id="password">
								<tr>
									<td><input type="submit" value="��¼">
							</table>
						</form>
					</div>
			</div>
			</div>
			</div>
    	
	<jsp:include page="foot.jsp"></jsp:include>
  </body>
</html>
