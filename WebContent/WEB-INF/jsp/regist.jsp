<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>注册页</title>
	<link rel="stylesheet" type="text/css" href="css/regist.css">
	</head>
	<body>
		<!--导入head.jsp-->
		<jsp:include page="head.jsp"></jsp:include>
				<form id="registerForm" action="${ pageContext.request.contextPath }/user_regist.action"  method="post" novalidate="novalidate" onsubmit="return checkForm();">
					<table>
						<tr>
							<td>用户名：<td><input type="text" id="username" name="username" class="text" maxlength="20" onblur="checkUsername()"/></tr>
						<tr>
							<td>密码：    <td><input type="password" id="password" name="password" class="text" maxlength="20" autocomplete="off"/>
						<tr>
							<td>确认密码:<td><input id="repassword" type="password" name="repassword" class="text" maxlength="20" autocomplete="off"/>
						<tr>
							<td>邮箱：<td><input type="text" id="email" name="email" class="text" maxlength="200">
						<tr>
							<td>姓名:<td><input type="text" name="name" class="text" maxlength="200"/>
						<tr>
							<td>电话:<td><input type="text" name="phone" class="text" />
						<tr>
							<td>地址:<td><input type="text" name="addr" class="text" maxlength="200"/>
						<tr>
							<td><input type="submit" class="submit" value="注册">
					</table>
				</form>
		<jsp:include page="foot.jsp"></jsp:include>
	</body>
</html>
