<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="pg" uri="http://wanggang.cn/common/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>	
	<link rel="stylesheet" type="text/css" href="../images/styles.css">	
  </head>
  <body>

    <div class="div1">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">��ǰλ�á�:ҽҩ����&gt;&gt; �鿴���</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="100" valign="top">
					<br>
       <form action="med_list_nopaging.html" method="post">
    	<input type="hidden" name="command" value="QueryMedCount" />
      <table border="0" align="center" width="450">
        <tr>
          <td align="center">
          	���������
          	<select name="type">
				<option value="0">=</option>
				<option value="1">&gt;</option>
				<option value="-1">&lt;</option>
			</select>
			<input type="text" name="count" size="5" />
			<input type="submit" value="��ѯ"/>
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
