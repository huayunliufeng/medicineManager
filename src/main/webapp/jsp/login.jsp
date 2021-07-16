<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html locale="true">
  <head>
    <title>用户登入</title>
	<style type="text/css">
		<!--
		body{
			margin: 0px;
			font-size: 12px;
			background-color: #4C8C1C;
		}
		.tb1{
			position: relative;
			top: -355px;
			left: 280px;
		}
		.it{
			background-color: #E1FFC1;
			height: 20px;
			width: 150px;
		}
		-->
	</style>
	  <script type="text/javascript">
		  function checkUserNameValue(value) {
			  if (value === "") {
				  document.getElementById("loginnameError").innerHTML = "用户名不能为空";
			  } else {
				  document.getElementById("loginnameError").innerHTML = "";
			  }
		  }

		  function checkUserPasswordValue(value) {
			  if (value === "") {
				  document.getElementById("loginpassError").innerHTML = "密码不能为空";
			  } else {
				  document.getElementById("loginpassError").innerHTML = "";
			  }
		  }
	  </script>
	<script language="javaScript">
		if(self != top){
			alert("");
			top.location = self.location;
		}
	</script>
  </head>
  <body>
  <table border="0" width="990" height="600" align="center" cellpadding="0" cellspacing="0">
      	
      	<tr>
          <td colspan="2" align="left" valign="top">
         		<img src="${pageContext.request.contextPath}/static/images/login_zh.jpg" border="0" usemap="#Map">
         		<form action = "${pageContext.request.contextPath}/userLogin" method="get">
		    	<table border="0" class="tb1" style="margin-left: 80px">
			      		 <tr>
			          		<td colspan="2" align="center">
			          			   &nbsp;
			          		</td>
			          	</tr>
			        <tr>
			          <td align="right">用户名：</td>
			          <td><input type=="text"  name="username"  id="username"  onblur="checkUserNameValue(this.value)"/></td>
						<td height="20">&nbsp;</td>
						<td>
							<span id="loginnameError" class="error"></span>
						</td>
			        </tr>

			        <tr>
			          <td align="right">密&nbsp;&nbsp;&nbsp;码：</td>
			          <td><input type="password"  name="password" id="password" onblur="checkUserPasswordValue(this.value)"/></td>
						<td height="20">&nbsp;</td>
						<td>
							<span id="loginpassError" class="error"></span>
						</td>
			        </tr>

			        <tr>
			          <td colspan="2" align="center" height="30">
			         	 <input type="submit" value="登入"/>
			         	 <input type="reset" value="复原"/>
			          </td>
			        </tr>
			      </table>
		    </form>
          </td>
        </tr>
  </table>
  
<map name="Map"><area shape="rect" coords="265,140,323,154" href="<html:rewrite page="/language.do?lan=zh"/>">
<area shape="rect" coords="335,138,406,153" href="<html:rewrite page="/language.do?lan=en"/>">
</map></body>
</html>

