<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="pg" uri="http://wanggang.cn/common/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
  <head>
    <title></title>	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
  </head>
  <body>

    <div class="div1">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">当前位置・:医药管理&gt;&gt; 查看库存</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="100" valign="top">
					<br>
       <form action="med_list_nopaging.html" method="post">
    	<input type="hidden" name="command" value="QueryMedCount" />
      <table border="0" align="center" width="450">
        <tr>
          <td align="center">
			  库存数量：
          	<select name="type">
				<option value="0">=</option>
				<option value="1">&gt;</option>
				<option value="-1">&lt;</option>
			</select>
			<input type="text" name="count" size="5" />
			<input type="submit" value="查询"/>
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
