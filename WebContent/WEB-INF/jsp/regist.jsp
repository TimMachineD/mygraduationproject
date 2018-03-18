<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>注册页</title>
	<link rel="stylesheet" type="text/css" href="css/regist.css">
<script type="text/javascript">
	function checkForm() {
		// 校验用户名:
		// 获得用户名文本框的值:
		var username = document.getElementById("username").value;
		if (username == null || username == '') {
			alert("用户名不能为空!");
			return false;
		}
		// 校验密码:
		// 获得密码框的值:
		var password = document.getElementById("password").value;
		if (password == null || password == '') {
			alert("密码不能为空!");
			return false;
		}
	}
	//校验密码是否一致
	function checkRep(){
		var password = document.getElementById("password").value;
		//校验确认密码
		var repassword = document.getElementById("repassword").value;
		if(repassword!=password){
			document.getElementById("span3").innerHTML = "<font color='red'> 两次密码输入不一致！</font>";
		}
	}
	function createXmlHttp() {
		var xmlHttp;
		try { // Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try {// Internet Explorer
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}

		return xmlHttp;
	}

	function checkUsername() {
		// 获得文件框值:
		var username = document.getElementById("username").value;
		// 1.创建异步交互对象
		var xhr = createXmlHttp();
		// 2.设置监听
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					if (username == null || username == '') {

						document.getElementById("span1").innerHTML = "";
					} else {
						document.getElementById("span1").innerHTML = xhr.responseText;
					}
				}
				onbu
			}
		}
		//3.打开连接
		xhr.open("GET",
				"${pageContext.request.contextPath}/user_findByName.action?time="
						+ new Date().getTime() + "&username=" + username, true);
		//4.发送
		xhr.send(null);
	}
</script>
</head>
	<body>
		<!--导入head.jsp-->
		<jsp:include page="head.jsp"></jsp:include>
				<form class="registerForm" id="registerForm" action="${ pageContext.request.contextPath }/user_regist.action"  method="post" novalidate="novalidate" onsubmit="return checkForm();">
					<table>
						<tr>
							<td>用户名:
							<td><input type="text" id="username" name="username" class="text" maxlength="20" onblur="checkUsername()"/>
							<span id="span1"></span></tr>
						<tr>
							<td>密码:<td><input type="password" id="password" name="password" class="text" maxlength="20" autocomplete="off" style="width:173px"/><s:fielderror fieldName="password"/>
						<tr>
							<td>确认密码:
							<td><input id="repassword" type="password" name="repassword" class="text" maxlength="20" autocomplete="off" onblur="checkRep()" style="width:173px"/><span id="span3"></span>
						<tr>
							<td>邮箱:<td><input type="text" id="email" name="email" class="text" maxlength="200"><s:fielderror fieldName="email"/>
						<tr>
							<td>姓名:<td><input type="text" name="name" class="text" maxlength="200"/><s:fielderror fieldName="name"/>
						<tr>
							<td>电话:<td><input type="text" name="phone" class="text" /><s:fielderror fieldName="addr"/>
						<tr>
							<td>地址:<td><input type="text" name="addr" class="text" maxlength="200"/><s:fielderror fieldName="phone"/>
						<tr>
							<td><input type="submit" value="注册">
					</table>
				</form>
		<jsp:include page="foot.jsp"></jsp:include>
	</body>
</html>
