<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pg" uri="http://wanggang.cn/common/" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/bootstrap.min.css">
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>

    <script>
        let del = (id) => {
            if (confirm("确认删除吗？")) {
                location.href = "${pageContext.request.contextPath}/sell/delSell/" + id;
            }
        };
    </script>
</head>
<body>

<div class="div1">
    <table width="100%" cellpadding="0" cellspacing="0" border="0"
           align="center">
        <tr>
            <td class="td_title1">·当前位置：购买药品&gt;&gt; 已购买药品</td>
        </tr>
        <tr>
            <td bgcolor="#FFFFFF" height="50">
                <br>
                <table border="1" align="center" width="600" cellpadding="1" cellspacing="1" bgcolor="#036500"
                       bordercolor="#FFFFF">
                    <tr bgcolor="#FFFFFF">
                        <td class="tb_tl">药品名称</td>
                        <td class="tb_tl">价格</td>
                        <td class="tb_tl">数量</td>
                        <td class="tb_tl">金额</td>
                        <td class="tb_tl">操作</td>
                    </tr>

                    <c:forEach items="${page.rows}" var="sellDetail">
                        <tr bgcolor="#FFFFFF">
                            <td>${sellDetail.sellName}</td>
                            <td>${sellDetail.sellPrice}</td>
                            <td>${sellDetail.sellCount}</td>
                            <td>${sellDetail.total}</td>
                            <td><a href="javascript:del('${sellDetail.id}')">删除</a></td>
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
