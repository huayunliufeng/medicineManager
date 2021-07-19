<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
    <script>
        $(function () {
            let password = $("input[name='password']");
            password.blur(function () {
                $.post({
                    url: "/user/getPass",
                    data: {"password": password.val(), "id":${user.id}},
                    dataType: "text",
                    success: function (data) {
                        if (data === "NO") {
                            password.focus();
                            $("#err").text("原密码错误！");
                        }else{
                            $("#err").text("");
                        }
                    }

                });
            });

        });

        let sub = () => {
            let conNewPass = $("input[name='conNewPass']");
            let newPass = $("input[name='newPass']");
            if (conNewPass.val() !== newPass.val()) {
                newPass.focus();
                alert("两次输入的密码不同！请检查");
            }
            if (conNewPass.val() === '' || newPass.val() === '') {
                newPass.focus();
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
            <td class="td_title1">·当前位置：系统管理&gt;&gt; 修改密码</td>
        </tr>
        <tr>

            <td bgcolor="#FFFFFF" height="50">
                <br>
                <form action="${pageContext.request.contextPath}/user/updateUser" method="post" id="form">
                    <input type="hidden" name="id" value="${user.id}">
                    <table border="0" align="center" width="450">
                        <tr>
                            <td align="right">原密码：</td>
                            <td align="left"><input type="password" name="password"/><span id="err"></span></td>
                        </tr>
                        <tr>
                            <td align="right">密码 ：</td>
                            <td align="left"><input type="password" name="newPass"/></td>
                        </tr>
                        <tr>
                            <td align="right">确认密码：</td>
                            <td align="left"><input type="password" name="conNewPass"/></td>
                        </tr>
                        <tr>
                            <td align="center" colspan="2"><input type="button" onclick="sub()" value="提交"/></td>
                        </tr>
                    </table>
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
