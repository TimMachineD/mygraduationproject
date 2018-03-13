<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>网上书店</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
	<div class=head>
		<div class=head_left>
			<a href="#"><img hspace=11 src="images/JD_logo.jpg" vspace=5>
			</a>
		</div>
		<div class=head_right>
			<div class=head_right_nei>
				<div class=head_top>
					<div class=head_buy>
						<strong> <a href="#"> <IMG
								height=15 src="images/buy01.jpg" width=16>购物车
						</a>| <a href="#" style="margin-right: 20px;">个人中心</a> <s:if
								test="#session.user==null">
								<a href="login.jsp"> <span>登录</span></a>
							</s:if> | <s:else>
								<a href="logout.action"> <span>注销</span>
								</a>
							</s:else> <a href="${ pageContext.request.contextPath }/user_registPage.action" target=_top> <span>注册</span>
						</a>
					</div>
					</strong>
				</div>
				<div class=head_middle>
					<form action="searchBook.action" method="post">
						<input type="text" class="searchtext" name="name" size="40" /> 
						<input type="button" class="searchbtn" value="搜一搜" name="submit"/>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
