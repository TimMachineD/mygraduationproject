<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>网上商城</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<style>
/* 下拉按钮样式 */
.dropbtn {
	
	border: none;
	cursor: pointer;
}

/* 容器 <div> - 需要定位下拉内容 */
.dropdown {
	position: relative;
	display: inline-block;
}

/* 下拉内容 (默认隐藏) */
.dropdown-content {
	display: none;
	background-color: #f9f9f9;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
}

/* 下拉菜单的链接 */
.dropdown-content a {
	text-align:center;
	text-decoration: none;
	display: block;
}

/* 鼠标移上去后修改下拉菜单链接颜色 */
.dropdown-content a:hover {
	background-color: #f1f1f1
}

/* 在鼠标移上去后显示下拉菜单 */
.dropdown:hover .dropdown-content {
	display: block;
}

/* 当下拉内容显示后修改下拉按钮的背景颜色 */
</style>
</head>
<body>
	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="${pageContext.request.contextPath}/index_test.action">
					<img hspace=11 src="images/JD_logo.jpg" vspace=5>
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<form action="searchBook.action" method="post">
					<input type="text" class="searchtext" name="name" size="30" /> <input
						type="button" class="searchbtn" value="搜一搜" name="submit" />
				</form>
			</div>
		</div>
		<div class="span10 last">
			<div class="topNav">
				<s:if test="#session.existUser==null">
					<div class="topNav01">
						<a href="${ pageContext.request.contextPath }/cart_myCart.action">
							<IMG height=15 src="images/buy01.jpg" width=16>购物车
						</a>| <a href="#">未知用户</a>
					</div>
					<div class="topNav02">
						<a
							href="${ pageContext.request.contextPath }/user_loginPage.action">
							<span>登录</span>
						</a> | <a
							href="${ pageContext.request.contextPath }/user_registPage.action"
							target=_top> <span>注册</span>
						</a>
					</div>

				</s:if>
				<s:else>
					<div class="topNav01">
						<a href="${ pageContext.request.contextPath }/cart_myCart.action">
							<IMG height=15 src="images/buy01.jpg" width=16>购物车
						</a>|
						<div class="dropdown">
							<button class="dropbtn">下拉菜单</button>
							<div class="dropdown-content">
								<a href="#">个人信息</a> 
								<a href="${ pageContext.request.contextPath }/order_findByUid.action?page=1">我的订单</a>
							</div>
						</div>
					</div>
					<div class="topNav02">
						<s:property value="#session.existUser.name" />
						| <a href="${ pageContext.request.contextPath }/user_quit.action">
							<span>注销</span>
						</a>
					</div>
				</s:else>

			</div>
		</div>
	</div>
</body>
</html>
