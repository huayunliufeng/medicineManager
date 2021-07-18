<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="pg" uri="http://wanggang.cn/common/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/bootstrap.min.css">
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>

    <script>
        let delMed = (id) => {
            if (confirm("确认删除吗？")) {
                location.href = "${pageContext.request.contextPath}/med/delMed/" + id;
            }
        };
    </script>
</head>
<body>
<div class="div1">

    <table width="100%" cellpadding="0" cellspacing="0" border="0"
           align="center">
        <tr>
            <td class="td_title1">·当前位置：医药管理&gt;&gt; 查看药品&gt;&gt; 所有药品</td>
        </tr>
        <tr>
            <td bgcolor="#FFFFFF" height="50">
                <br>
                <table border="1" align="center" width="700" cellpadding="1" cellspacing="1" bgcolor="#036500"
                       bordercolor="#FFFFF">
                    <tr bgcolor="#FFFFFF">
                        <td colspan="9" align="center">
                            <table border="0" width="100%">
                                <tr>
                                    <td align="left">
                                        <form action='${pageContext.request.contextPath}/med/fuQue' method="get"
                                              class="blur_form">
                                            <input type="hidden" name="queryPage" value="med_list"/>
                                            模糊查询：<input name="keyWord" type="text" placeholder="按名称或出厂地址" size="20"/>
                                            <input type="submit" value="查询"/>
                                        </form>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr bgcolor="#FFFFFF">
                        <td class="tb_tl">药品ID</td>
                        <td class="tb_tl">药品编码</td>
                        <td class="tb_tl">药品名称</td>
                        <td class="tb_tl">单价</td>
                        <td class="tb_tl">库存数量</td>
                        <td class="tb_tl">出厂地址</td>
                        <td class="tb_tl">操作</td>
                    </tr>
                    <c:forEach items="${page.rows}" var="medicine">
                        <tr bgcolor="#FFFFFF">
                            <td>${medicine.id}</td>
                            <td>${medicine.medNo}</td>
                            <td>${medicine.name}</td>
                            <td>${medicine.price}元</td>
                            <td>${medicine.medCount}</td>
                            <td>${medicine.factoryAdd}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/med/findOneMed/${medicine.id}/?resPage=baseData/med_update">修改</a>&nbsp;
                                <a href="javascript:delMed('${medicine.id}')">删除</a></td>
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
