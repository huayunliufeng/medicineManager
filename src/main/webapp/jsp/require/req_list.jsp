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
        let delMed = (id)=>{
            if(confirm("确认删除吗？")){
                location.href = "${pageContext.request.contextPath}/req/delReq/"+id;
            }
        };
    </script>
</head>
<body>
<div class="div1">
    <table width="100%" cellpadding="0" cellspacing="0" border="0"
           align="center">
        <tr>
            <td class="td_title1">・当前位置：进货/需求管理 &gt;&gt; 查看进货</td>
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
                                        <form action="${pageContext.request.contextPath}/req/reqFuQue" method="Get" class="blur_form">
                                            <input type="hidden" name="queryPage" value="req_list"/>
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
                        <td class="tb_tl">价格</td>
                        <td class="tb_tl">库存数量</td>
                        <td class="tb_tl">出厂地址</td>
                        <td class="tb_tl">操作</td>
                    </tr>
                    <c:forEach items="${page.rows}" var="requires">
                        <tr bgcolor="#FFFFFF">
                            <td>${requires.id}</td>
                            <td>${requires.medNo}</td>
                            <td>${requires.medName}</td>
                            <td>${requires.medPrice}元</td>
                            <td>${requires.reqCount}</td>
                            <td>${requires.factoryAdd}</td>
                            <td><a href="${pageContext.request.contextPath}/req/findOneReq/${requires.id}/?resPage=require/req_update_list">修改</a>&nbsp;
                                <a href="javascript:delMed('${requires.id}')">删除</a></td>
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

