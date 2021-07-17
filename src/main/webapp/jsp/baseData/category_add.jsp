<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="pg" uri="http://wanggang.cn/common/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/bootstrap.min.css">
	<script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(function () {
			let categoryNoSelect = $("input[name='name']");
			categoryNoSelect.blur(function () {
				let name = categoryNoSelect.val();
				$.get({
					url: "/cate/checkCategoryName",  //请求的url，后台的servlet
					async: true,  //指定是否是异步请求
					data: {"name": name}, //请求的数据
					dataType: 'text',  //返回的数据类型
					contentType: 'application/json;charset=utf-8',
					cache: false,  //是否缓存
					success: function (data) { //回调函数，把data渲染到页面中
						if(data === "YES"){
							$("#nameErrMsg").text("该名称已存在！");
							categoryNoSelect.focus();
						}else if(data === "ERROR"){
							$("#nameErrMsg").text("有错误！");
							categoryNoSelect.focus();
						}else{
							$("#nameErrMsg").text("");
						}
					}
				});
			});
		})
	</script>
</head>
<body>
<div class="div1">
	<table width="100%" cellpadding="0" cellspacing="0" border="0"
		   align="center">
		<tr>
			<td class="td_title1">·当前位置：类别管理&gt;&gt;添加类别</td>
		</tr>
		<tr>
			<td bgcolor="#FFFFFF" height="50">
				<br>
				<form action="${pageContext.request.contextPath}/cate/addCategory" method="post">
					<table border="0" align="center" width="500">
						<tr>
							<td align="right">类别名称：</td>
							<td align="left">
								<input type="text" name="name"/>&nbsp;&nbsp;
								<span id="nameErrMsg"></span>
							</td>
							</td>
						</tr>
						<tr>
							<td align="right" >类别描述：
							</td>
							<td align="left">
								<input type="text" name="description"/>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="submit" value="提交"/>
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</div>
</body>
</html>
