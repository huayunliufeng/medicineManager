<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
            <td class="td_title1">·当前位置：系统管理&gt;&gt;添加管理员</td>
        </tr>
        <tr>
            <td bgcolor="#FFFFFF" height="50">
                <br>
                <form action="user_list.html" method="post">
                    <input type="hidden" name="command" value="userAdd" />
                    <table border="0" align="center" width="450">
                        <tr>
                            <td align="right">用户名：</td>
                            <td align="left"><input type="text" name=""/></td>
                        </tr>
                        <tr>
                            <td align="right">密码 ：</td>
                            <td align="left"><input type="text" name=""/></td>
                        </tr>
                        <tr>
                            <td align="right">确认密码：</td>
                            <td align="left"><input type="text" name=""/></td>
                        </tr>
                        <tr>
                            <td align="center" colspan="2">
                                <input type="submit" value="提交 "/>
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