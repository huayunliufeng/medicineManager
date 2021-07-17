<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE>
<html>

	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
	</head>
	<body>
		<table width="100%" border="0" align="center" cellspacing="0"
			cellpadding="0" height="140">
			<tr>
				<td colspan="2">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						height="140" background="${pageContext.request.contextPath}/static/images/top2.jpg">
						<tr>
							<td height="140" valign="top" width="556"><img src="${pageContext.request.contextPath}/static/images/top1.jpg" width="556" height="140" border="0"></td>
							<td width="100%"></td>
							<td width="245" height="140" valign="top"><img src="${pageContext.request.contextPath}/static/images/top3.jpg" width="245" height="140" border="0"
									usemap="#Map"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td background="${pageContext.request.contextPath}/static/images/top_bg1.jpg" width="" height="40" class="wel">
					${user.username}
					，欢迎登录医药管理系统！
				</td>
				<td background="${pageContext.request.contextPath}/static/images/top_bg1.jpg" width="60" align="center">
					<a href="${pageContext.request.contextPath}/login" target="_top" class="exit">
						退出系统
					</a>
				</td>
			</tr>
		</table>

		
	</body>
</html>
