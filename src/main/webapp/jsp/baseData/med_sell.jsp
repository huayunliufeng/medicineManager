<%@ taglib prefix="pg" uri="http://wanggang.cn/common/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE>
<html>
  <head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
	  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/bootstrap.min.css">
	  <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>

	  <script>

	  </script>
  </head>
  <body>

  <div class="div1">
	<table width="100%" cellpadding="0" cellspacing="0" border="0"	align="center">
		<tr>
			<td class="td_title1">·当前位置：购买药品&gt;&gt;选购药品	</td>
		</tr>
		<tr>
		   <td bgcolor="#FFFFFF" height="50">
					<br>
       <table border="1" align="center" width="600" cellpadding="1" cellspacing="1" bgcolor="#036500" bordercolor="#FFFFF">
        <tr bgcolor="#FFFFFF">
          <td colspan="7" align="center">
          		<table border="0" width="100%">
          			<tr>
          				<td align="left">
							<form action='${pageContext.request.contextPath}/med/fuQue' method="get" class="blur_form">
								<input type="hidden" name="queryPage" value="med_sell"/>
								模糊查询：<input name="keyWord" type="text" placeholder="按名称或出厂地址" size="20"/>
								<input type="submit" value="查询"/>
							</form>
          				</td>
          			</tr>
          		</table>
          </td>
        </tr>
        <tr bgcolor="#FFFFFF" >
          <td class="tb_tl">药品ID</td>
          <td class="tb_tl">药品名称</td>
          <td class="tb_tl">价格</td>
          <td class="tb_tl">库存数量</td>
          <td class="tb_tl">出厂地址</td>
          <td class="tb_tl">操作</td>
        </tr>
		   <c:forEach items="${page.rows}" var="medicine">
			   <tr bgcolor="#FFFFFF" >
				   <td>${medicine.id}</td>
				   <td>${medicine.name}</td>
				   <td>${medicine.price}元</td>
				   <td>${medicine.medCount}</td>
				   <td>${medicine.factoryAdd}</td>
				   <td>
					   <a href="${pageContext.request.contextPath}/med/findOneMed/${medicine.id}/?resPage=sell/sell_add">购买</a>
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
