<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>

    <script>
        $(function () {

        });

        let sub = (medCount) => {
            let sellCount = $("input[name='sellCount']");
            if (sellCount.val() <= 0 || parseInt(medCount) < parseInt(sellCount.val())) {
                sellCount.focus();
                alert("数量填写错误！！！");
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
            <td class="td_title1">·当前位置：购买药品&gt;&gt; 选购药品
            </td>
        </tr>
        <tr>
            <td bgcolor="#FFFFFF" height="50">
                <br>
                <form action="${pageContext.request.contextPath}/sell/buyMed" method="post" id="form">
                    <table border="0" align="center" width="500">
                        <tr>
                            <td align="right">药品名称：</td>
                            <td align="left">
                                <input type="hidden" name="medid" value="${medicine.id}"/>
                                <input type="text" name="sellName" value="${medicine.name}" readonly/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">价格：</td>
                            <td align="left"><input type="text" name="sellPrice" value="${medicine.price}" readonly/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">数量：</td>
                            <td align="left"><input type="number" min="1" name="sellCount"/><font
                                    color="red">目前：${medicine.medCount}</font></td>
                        </tr>
                        <tr>
                            <td align="right">出厂地址：</td>
                            <td align="left"><input type="text" name="factoryAdd" value="${medicine.factoryAdd}"
                                                    disabled/></td>
                        </tr>
                        <tr>
                            <td align="center" colspan="2"><input type="button" onclick="sub('${medicine.medCount}')"
                                                                  value="结帐"/></td>
                        </tr>
                    </table>
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
