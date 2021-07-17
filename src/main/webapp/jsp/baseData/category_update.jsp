<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="pg" uri="http://wanggang.cn/common/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/bootstrap.min.css">
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

<div class="div1">
    <table width="100%" cellpadding="0" cellspacing="0" border="0"
           align="center">
        <tr>
            <td class="td_title1">·当前位置：医药管理&gt;&gt; 更新类别</td>
        </tr>
        <tr>
            <td bgcolor="#FFFFFF" height="50">
                <br>
                <form action="${pageContext.request.contextPath}/cate/updateCategory" method="post" id="form">
                    <table border="0" align="center" width="450">
                        <input type="hidden" name="id" value="${category.id}">
                        <tr>
                            <td align="right">药品名称：</td>
                            <td align="left"><input type="text" name="name"  value="${category.name}"/></td>
                        </tr>
                        <tr>
                            <td align="right">描述：</td>
                            <td align="left"><input name="description" type="text" value="${category.description}"/>
                            </td>
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
