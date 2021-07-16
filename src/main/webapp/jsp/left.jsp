<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<script type="text/javascript">
			var m = "";
			function menu(num){
				sub = eval("sub_"+num+".style");
				if(m !== sub){
					if(m !== ""){
						m.display = "none";
					}
					sub.display='block';
					m = sub;
				}else{
					sub.display = "none";
					m = "";
				}
			}
		</script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
	    <style type="text/css">
<!--
.m1 {
	font-size: 12px;
	font-weight: bold;
	margin-left: 60px;
	text-align: center;
	vertical-align: sub;
}
.sub1 {
	margin-left: 40px;
}
-->
        </style>
</head>
  <body>
    <table border="0" width="200" height="100%" align="right" cellSpacing="0" cellPadding="0" bgcolor="#E0FBC4">
    	<!-- 药品管理 -->
    	<tr>
			<td onClick="menu(0)" height="33" background="${pageContext.request.contextPath}/static/images/m1.jpg">
				<font class="m1">医药管理</font>
			</td>
		</tr>
		<tr bgcolor="#E0FBC4">
			<td id="sub_0" style="display: none;">
				<table width="80%" align="center">
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="${pageContext.request.contextPath}/toCate" target="main" class="sub1">添加药品</a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="${pageContext.request.contextPath}/med/findMed?resPage=baseData/med_list" target="main" class="sub1">查看药品							</a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="${pageContext.request.contextPath}/jsp/baseData/med_query.jsp" target="main" class="sub1">高级查询</a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="${pageContext.request.contextPath}/jsp/baseData/med_count.jsp" target="main" class="sub1">查看库存</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
    	<!-- 类别管理 -->
    	<tr>
			<td onClick="menu(1)" height="33" background="${pageContext.request.contextPath}/static/images/m1.jpg">
				<font class="m1">
					类别管理
				</font>
			</td>
		</tr>
		<tr bgcolor="#E0FBC4">
			<td id="sub_1" style="display: none">
				<table width="80%" align="center">
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="${pageContext.request.contextPath}/jsp/baseData/category_add.html" target="main" class="sub1">添加类别</a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="${pageContext.request.contextPath}/jsp/baseData/category_list.html" target="main" class="sub1">查看类别</a>
						</td>
					</tr>					
				</table>
			</td>
		</tr>
		<!-- 购买药品 -->
    	<tr>
			<td onClick="menu(2)" height="33" background="${pageContext.request.contextPath}/static/images/m1.jpg">
				<font class="m1">
				购买药品
				</font>
			</td>
		</tr>
		<tr bgcolor="#E0FBC4">
			<td id="sub_2" style="display: none">
				<table width="80%" align="center">
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="${pageContext.request.contextPath}/med/findMed?resPage=baseData/med_sell" target="main" class="sub1">选购药品</a>
						</td>
					</tr>					
				</table>
			</td>
		</tr>
		<!-- 销售管理 -->
    	<tr>
			<td onClick="menu(3)" height="33" background="${pageContext.request.contextPath}/static/images/m1.jpg">
				<font class="m1">
				销售管理
				</font>
			</td>
		</tr>
		<tr bgcolor="#E0FBC4">
			<td id="sub_3" style="display: none">
				<table width="80%" align="center">
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="${pageContext.request.contextPath}/jsp/sell/sell_list.html" target="main" class="sub1">查看明细</a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="${pageContext.request.contextPath}/jsp/sell/sell_query.html" target="main" class="sub1">日期查询</a>
						</td>
					</tr>					
				</table>
			</td>
		</tr>
		
	<!-- 系统管理 -->
    	<tr>
			<td onClick="menu(5)" height="33" background="${pageContext.request.contextPath}/static/images/m1.jpg">
				<font class="m1">
				系统管理
				</font>
			</td>
		</tr>
		<tr bgcolor="#E0FBC4">
			<td id="sub_5" style="display: none">
				<table width="80%" align="center">
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="${pageContext.request.contextPath}/jsp/system/user_add.html" target="main" class="sub1">添加管理员</a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="${pageContext.request.contextPath}/jsp/system/user_list.html" target="main" class="sub1">查看所有管理员</a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="${pageContext.request.contextPath}/jsp/system/user_password.html" target="main" class="sub1">修改密码</a>
						</td>
					</tr>					
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="${pageContext.request.contextPath}/jsp/login.html" target="_top" class="sub1">退出系统</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="100%"></td>
		</tr>
	</table>
  </body>
</html>
