<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/bootstrap.min.css">
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
    <script>
        $(function () {
            let username = $("input[name='username']");
            username.blur(function () {
                $.get({
                    url: "/user/getUser",
                    async: true,
                    data: {"username": username.val()},
                    dataType: "text",
                    contentType: "application/json;charset=utf-8",
                    cache: false,
                    success: function (data) {
                        if (data === "ERROR") {
                            username.focus();
                            $("#err").text("用户名格式错误！^[A-Za-z]\\w+");
                        } else if (data === "YES") {
                            username.focus();
                            $("#err").text("该用户已存在！");
                        }else {
                            $("#err").text("");
                        }
                    }

                });
            });

        });

        let sub = () => {
            let password = $("input[name='password']");
            let conPass = $("input[name='conPass']");
            if (password.val() !== conPass.val()) {
                password.focus();
                alert("两次输入的密码不同！请检查");
                return;
            }
            if (password.val() === '' || conPass.val() === '') {
                password.focus();
                alert("未输入密码！");
            } else {
                $("#form").submit();
            }
        };
    </script>

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
                <form action="${pageContext.request.contextPath}/user/addUser" method="post" id="form">
                    <table border="0" align="center" width="450">
                        <tr>
                            <td align="right">用户名：</td>
                            <td align="left"><input type="text" name="username"/><span id="err">&nbsp;&nbsp;</span></td>
                        </tr>
                        <tr>
                            <td align="right">密码 ：</td>
                            <td align="left"><input type="password" name="password"/></td>
                        </tr>
                        <tr>
                            <td align="right">确认密码：</td>
                            <td align="left"><input type="password" name="conPass"/></td>
                        </tr>
                        <tr>
                            <td align="center" colspan="2">
                                <input type="button" onclick="sub()" value="提交 "/>
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