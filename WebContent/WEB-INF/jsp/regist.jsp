<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>网上书店</title>
	<script type="text/javascript" src="dwr/engine.js"></script>
	<script type="text/javascript" src="dwr/util.js"></script>
	<script type="text/javascript" src="dwr/interface/UserDAOAjax.js"></script>
	<script type="text/javascript">
    function show(boolean)
    {
     	 if(boolean){
       	 	alert("用户已经存在!");
     	 }
	}
    function validate(){
    	var name=document.all.name.value;
      	if(name == ""){
      		alert("用户名不能为空！");
      		return;
      }
      UserDAOAjax.exitUser(name,show);
    }
  </script>
	</head>
	<body>
		<!--导入head.jsp-->
		<jsp:include page="head.jsp"></jsp:include>
		<div class=content>
				<div class=register>
					<div class=info_bk1>
					<div class=tt>用户注册</div>
						<div align="center">
							<form action="register.action" method="post" name="form1">
							用&nbsp;户&nbsp;名:<input type="text" id="name" name="user.username" size=20 
							onblur="validate()" />
							<br>
							密&nbsp;&nbsp;&nbsp;&nbsp;码:
							<input type="password" name="user.password" size=20>
							<br>
							性&nbsp;&nbsp;&nbsp;&nbsp;别:
							<input type="text" name="user.sex" size=20 />
							<br>
							年&nbsp;&nbsp;&nbsp;&nbsp;龄:
							<input type="text" name="user.age" size=20 />
							<br>
							<input type="submit" value="注册">
							</Form>
						</div>
					</div>
			</div>
		</div>
		<jsp:include page="foot.jsp"></jsp:include>
	</body>
</html>
