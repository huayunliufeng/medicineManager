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

    </script>
</head>
<body>

<div class="div1">
    <table width="100%" cellpadding="0" cellspacing="0" border="0"
           align="center">
        <tr>
            <td class="td_title1">·当前位置：销售管理&gt;&gt;销售明细
            </td>
        </tr>
        <tr>
            <td bgcolor="#FFFFFF" height="50">
                <br>
                <table border="1" align="center" width="700" cellpadding="1" cellspacing="1" bgcolor="#036500"
                       bordercolor="#FFFFF">
                    <tr bgcolor="#FFFFFF">
                        <td colspan="8" align="center">
                            <table border="0" width="100%">
                                <tr>
                                    <td align="left">
                                        <form name="queryForm" action="${pageContext.request.contextPath}/sell/fuQue" method="get" class="blur_form">
                                            <input type="hidden" name="queryPage" value="sell_list"/>
                                            模糊查询：<input name="keyWord" type="text" size="20" placeholder="按名称"/>
                                            <input type="submit" value="查询"/>
                                        </form>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr bgcolor="#FFFFFF">
                        <td class="tb_tl">销售编号</td>
                        <td class="tb_tl">药品名称</td>
                        <td class="tb_tl">价格</td>
                        <td class="tb_tl">数量</td>
                        <td class="tb_tl">金额</td>
                        <td class="tb_tl">销售时间</td>
                        <td class="tb_tl">操作员</td>
                    </tr>
                    <c:forEach items="${page.rows}" var="sellDetail">
                        <tr bgcolor="#FFFFFF">
                            <td>${sellDetail.id}</td>
                            <td><a href="${pageContext.request.contextPath}/sell/findMedDet/${sellDetail.id}">${sellDetail.sellName}</a></td>
                            <td>${sellDetail.sellPrice}</td>
                            <td>${sellDetail.sellCount}</td>
                            <td>${sellDetail.total}</td>
                            <td>${sellDetail.sellTime}</td>
                            <td>${sellDetail.username}</td>
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
