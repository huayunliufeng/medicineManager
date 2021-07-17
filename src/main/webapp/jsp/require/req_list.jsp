<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE>
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
                                        <form action="req_list.jsp" method="post" class="blur_form">
                                            模糊查询：<input name="keyWord" type="text" size="20"/>
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
                        <td class="tb_tl">数量</td>
                        <td class="tb_tl">库存数量</td>
                        <td class="tb_tl">出厂地址</td>
                        <td class="tb_tl">操作</td>
                    </tr>
                    <tr bgcolor="#FFFFFF">
                        <td>1</td>
                        <td>0002</td>
                        <td>牛黄解毒丸</td>
                        <td>50元</td>
                        <td>10</td>
                        <td>20</td>
                        <td>北京同仁堂</td>
                        <td><a href="req_update.jsp">修改</a>&nbsp;<a href="req_list.jsp">删除</a></td>
                    </tr>
                </table>
                <br>
            </td>
        </tr>
    </table>
</div>
</body>
</html>

