<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="pg" uri="http://wanggang.cn/common/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/bootstrap.min.css">
	<script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="div1">
	<table width="100%" cellpadding="0" cellspacing="0" border="0" align="center">
		<tr>
			<td class="td_title1">·当前位置：医药管理&gt;&gt; 查看药品&gt;&gt; 所有药品</td>
		</tr>
		<tr>
			<td bgcolor="#FFFFFF" height="50">
				<br>
				<table border="1" align="center" width="700" cellpadding="1" cellspacing="1" bgcolor="#036500" bordercolor="#FFFFF">
					<tr bgcolor="#FFFFFF" >
						<td class="tb_tl">药品ID</td>
						<td class="tb_tl">药品编码</td>
						<td class="tb_tl">药品名称</td>
						<td class="tb_tl">单价</td>
						<td class="tb_tl">库存数量</td>
						<td class="tb_tl">出厂地址</td>
					</tr>
					<c:forEach items="${page.rows}" var="medicine">
					<tr bgcolor="#FFFFFF">
						<td>${medicine.id}</td>
						<td>${medicine.medNo}</td>
						<td>${medicine.name}</td>
						<td>${medicine.price}元</td>
						<td>${medicine.medCount}</td>
						<td>${medicine.factoryAdd}</td>
					</tr>
					</c:forEach>
					<tr bgcolor="#FFFFFF">
						<table border="0" width="100%">
							<tr>
								<td align="right">
									<div class="col-md-12 text-right">
										<pg:page url="${url}"/>
									</div>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<br>
			</td>
		</tr>
	</table>
</div>
</body>
</html>