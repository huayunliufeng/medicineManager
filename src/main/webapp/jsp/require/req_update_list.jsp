<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
    <script>
        $(function () {

            let price = $("input[name='price']");
            let medCount = $("input[name='medCount']");
            price.blur(function () {
                if(price.val()<0){
                    $("#err").text("价格不能为负数！");
                    price.focus();
                }else {
                    $("#err").text("");
                }
            });
            medCount.blur(function () {
                if(medCount.val()<0){
                    $("#err").text("库存不能为负数！");
                    medCount.focus();
                }else {
                    $("#err").text("");
                }
            });

        });

        let sub = ()=>{
            let medCount = $("input[name='medCount']");
            if(medCount.val() === ''){
                medCount.focus();
                alert("请填入库存数量！");
            }else{
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
            <td class="td_title1">·当前位置：医药管理&gt;&gt; 更新药品</td>
        </tr>
        <tr>
            <td bgcolor="#FFFFFF" height="50">
                <br>
                <form action="${pageContext.request.contextPath}/req/updateReq" method="post" id="form">
                    <table border="0" align="center" width="450">
                        <input type="hidden" name="id" value="${requires.id}">
                        <tr>
                            <td align="right">药品编码：</td>
                            <td align="left"><input type="text" name="medNo"  value="${requires.medNo} " readonly/></td>
                        </tr>
                        <tr>
                            <td align="right">药品名称：</td>
                            <td align="left"><input type="text" name="medName" value="${requires.medName}" readonly/></td>
                        </tr>
                        <tr>
                            <td align="right">价格：</td>
                            <td align="left"><input type="number" min="0" step="0.1" name="medPrice"
                                                    value="${requires.medPrice}"/><span id="err"></span></td>
                        </tr>
                        <tr>
                            <td align="right">库存数量：</td>
                            <td align="left">
                                <input type="number" min="0" name="reqCount"/>
                                <font color="red">目前：${requires.reqCount}</font>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">出厂地址：</td>
                            <td align="left"><input type="text" name="factoryAdd" value="${requires.factoryAdd}"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">描述：</td>
                            <td align="left"><input name="description" type="text" value="${requires.description}"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><input type="button" onclick="sub()" value="提交"/></td>
                        </tr>
                    </table>
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
