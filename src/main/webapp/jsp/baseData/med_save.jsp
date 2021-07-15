<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
	<link rel="stylesheet" type="text/css" href="../../../staticpage/images/styles.css">
  </head>
  <body>
  <div class="div1">
	<table width="100%" cellpadding="0" cellspacing="0" border="0"
		align="center">
		<tr>
			<td class="td_title1">·当前位置：医药管理&gt;&gt; 添加药品</td>
		</tr>

		<tr>
			<td bgcolor="#FFFFFF" height="50">
					<br>
    <form action="${pageContext.request.contextPath}" method="post"  enctype="multipart/form-data" >
      <table border="0" align="center" width="450">
        <tr>
          <td align="right">药品编码：</td>
          <td align="left"><input type="text" name="medNo"/></td>
        </tr>
        <tr>
          <td align="right">药品名称：</td>
          <td align="left"><input type="text" name="name"/></td>
        </tr>
        <tr>
          <td align="right">价格：</td>
          <td align="left"><input type="text" name="price"/></td>
        </tr>
        <tr>
          <td align="right">库存数量：</td>
          <td align="left"><input type="text" name="medCount"/></td>
        </tr>
        <tr>
          <td align="right">所属类别：</td>
          <td align="left">
          	<select name="categoryId" id="categoryId">
                <option value="0">--请选择--</option>
                <c:forEach items="${categorys}" var="$category">
                    <option value="${$category.id}">${$category.name}</option>
                </c:forEach>


          	</select>
          </td>
        </tr>
        <tr>
          <td align="right">图片：</td>
          <td align="left">
          	<input type="file" accept="image/jpeg,png" name="photoPath"/>
          </td>
        </tr>
        <tr>
          <td align="right">出厂地址：</td>
          <td align="left"><input type="text" name="factoryAdd"/></td>
        </tr>
        <tr>
          <td align="right">描述：</td>
          <td align="left"><input type="text" name="description"/></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit" value="提交"/></td>
        </tr>
      </table>
    </form>
    </td>
	</tr>
	</table>
	</div>
  </body>
</html>
