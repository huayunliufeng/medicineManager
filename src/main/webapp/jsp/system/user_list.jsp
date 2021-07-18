<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pg" uri="http://wanggang.cn/common/" %>
<!DOCTYPE>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/bootstrap.min.css">
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
    <script>
        let del = (id)=>{

            if(confirm("确认删除？")){
                location.href = "${pageContext.request.contextPath}/user/delUser/"+id;
            }
        };
    </script>
</head>
<body>
<div class="div1">
    <table width="100%" cellpadding="0" cellspacing="0" border="0"
           align="center">
        <tr>
            <td class="td_title1">·当前位置：系统管理&gt;&gt; 查看所有管理员&gt;&gt;所有用户
            </td>
        </tr>
        <tr>

            <td bgcolor="#FFFFFF" height="50">
                <br>
                <table border="1" align="center" width="500" cellpadding="1" cellspacing="1" bgcolor="#036500"
                       bordercolor="#FFFFF">
                    <tr bgcolor="#FFFFFF">
                        <td class="tb_tl">ID</td>
                        <td class="tb_tl">用户名</td>
                        <td class="tb_tl">创建时间</td>
                        <td class="tb_tl">操作</td>
                    </tr>
                    <c:forEach items="${page.rows}" var="user">
                        <tr bgcolor="#FFFFFF">
                            <td>${user.id}</td>
                            <td> ${user.username}</td>
                            <td>${user.createTime}</td>
                            <td><a href="javascript:del('${user.id}')">删除</a></td>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td align="right">
                            <div class="col-md-12 text-right">
                                <pg:page url="${url}"/>
                            </div>
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
