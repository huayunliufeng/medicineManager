<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/bootstrap.min.css">
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>

    <script>
        let sub = () => {
            let begin = $("input[name='begin']");
            let end = $("input[name='end']");
            let pattern = /[0-9]{4}-[0-9]{2}-[0-9]{2}/;
            if (!pattern.test(begin.val()) || !pattern.test(end.val())) {
                begin.focus();
                alert("格式：yyyy-MM-dd");
            }


            let bs = new Date(begin.val()).getTime();
            let es = new Date(end.val()).getTime();
            if(es<bs){
                begin.focus();
                alert("begin must gt end!!!");
            }
            else {
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
            <td class="td_title1">·当前位置：销售管理&gt;&gt;日期查询
            </td>
        </tr>
        <tr>
            <td bgcolor="#FFFFFF" height="50">
                <br>
                <form name="queryForm" action="${pageContext.request.contextPath}/sell/findSellByData" method="get" id="form">
                    <input type="hidden" name="queryPage" value="sell_list"/>
                    <table border="0" align="center" width="500">
                        <tr>
                            <td align="right">开始日期：</td>
                            <td align="left">
                                <input name="begin" type="date"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">结束日期：</td>
                            <td align="left">
                                <input name="end" type="date"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="button" onclick="sub()" value="查询">
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
