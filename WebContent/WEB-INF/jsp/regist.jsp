<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>�������</title>
	<script type="text/javascript" src="dwr/engine.js"></script>
	<script type="text/javascript" src="dwr/util.js"></script>
	<script type="text/javascript" src="dwr/interface/UserDAOAjax.js"></script>
	<script type="text/javascript">
    function show(boolean)
    {
     	 if(boolean){
       	 	alert("�û��Ѿ�����!");
     	 }
	}
    function validate(){
    	var name=document.all.name.value;
      	if(name == ""){
      		alert("�û�������Ϊ�գ�");
      		return;
      }
      UserDAOAjax.exitUser(name,show);
    }
  </script>
	</head>
	<body>
		<!--����head.jsp-->
		<jsp:include page="head.jsp"></jsp:include>
		<div class=content>
				<div class=register>
					<div class=info_bk1>
					<div class=tt>�û�ע��</div>
						<div align="center">
							<form action="register.action" method="post" name="form1">
							��&nbsp;��&nbsp;��:<input type="text" id="name" name="user.username" size=20 
							onblur="validate()" />
							<br>
							��&nbsp;&nbsp;&nbsp;&nbsp;��:
							<input type="password" name="user.password" size=20>
							<br>
							��&nbsp;&nbsp;&nbsp;&nbsp;��:
							<input type="text" name="user.sex" size=20 />
							<br>
							��&nbsp;&nbsp;&nbsp;&nbsp;��:
							<input type="text" name="user.age" size=20 />
							<br>
							<input type="submit" value="ע��">
							</Form>
						</div>
					</div>
			</div>
		</div>
		<jsp:include page="foot.jsp"></jsp:include>
	</body>
</html>
