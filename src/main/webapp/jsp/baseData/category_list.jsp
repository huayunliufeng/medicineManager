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

	<script>
		let delMed = (id)=>{
			if(confirm("确认删除吗？")){
				location.href = "${pageContext.request.contextPath}/cate/deleteCategory/"+id;
			}
		};
	</script>
</head>
<body>
<div class="div1">
	<table width="100%" cellpadding="0" cellspacing="0" border="0"
		   align="center">
		<tr>
			<td class="td_title1">·当前位置：类别管理&gt;&gt;查看类别&gt;&gt;所有类别</td>
		</tr>
		<tr>
			<td bgcolor="#FFFFFF" height="50">
				<br>
				<table border="1" align="center" width="700" cellpadding="1" cellspacing="1" bgcolor="#036500" bordercolor="#FFFFF">
					<tr bgcolor="#FFFFFF">
						<td class="tb_tl">类别编号</td>
						<td class="tb_tl">类别名称</td>
						<td class="tb_tl">类别描述</td>
						<td class="tb_tl">创建时间</td>
						<td class="tb_tl">操作</td>
					</tr>
					<c:forEach items="${page.rows}" var="category">
					<tr bgcolor="#FFFFFF">
						<td>
							${category.id}
						</td>
						<td>
							${category.name}
						</td>
						<td>
							${category.description}
						</td>
						<td width="300px">
							${category.createTime}
						</td>
						<td width="100px">
<%--							<a href="category_add.jsp">修改</a>&nbsp;--%>
							<a href="${pageContext.request.contextPath}/cate/findOneCategory/${category.id}/?resPage=baseData/category_update">修改</a>&nbsp;
							<a href="javascript:delMed('${category.id}')">删除</a>
						</td>
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
