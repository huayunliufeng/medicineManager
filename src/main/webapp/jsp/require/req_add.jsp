<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE>
<html xmlns:bean="http://java.sun.com/jsf/core">
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
    <script>
        let sub = ()=>{
            let medNoSelect = $("input[name='medNo']");
            medNoSelect.blur(function () {
                let medNo = medNoSelect.val();
                $.get({
                    url: "/med/checkMedNo",  //请求的url，后台的servlet
                    async: true,  //指定是否是异步请求
                    data: {"medNo": medNo}, //请求的数据
                    dataType: 'text',  //返回的数据类型
                    contentType: 'application/json;charset=utf-8',
                    cache: false,  //是否缓存
                    success: function (data) { //回调函数，把data渲染到页面中
                        if(data === "YES"){
                            $("#medNoErrMsg").text("该编号已存在！");
                            medNoSelect.focus();
                        }else if(data === "ERROR"){
                            $("#medNoErrMsg").text("编号格式错误：^[A-Za-z]\\w+！");
                            medNoSelect.focus();
                        }else{
                            $("#medNoErrMsg").text("");
                            $("#form").submit();
                        }

                    }
                });

            });
        };



    </script>

</head>
<body>
<div class="div1">
    <table width="100%" cellpadding="0" cellspacing="0" border="0" align="center">
        <tr>
            <td class="td_title1">·<bean:message key="system.current.place"/>当前位置：进货/需求管理&gt;&gt;添加进货</td>
        </tr>
        <tr>
            <td bgcolor="#FFFFFF" height="50">
                <br>
                <form action="${pageContext.request.contextPath}/med/getSave" method="post" id="form">
                    <table border="0" align="center" width="300">
                        <tr>
                            <td align="right">药品编码：</td>
                            <td align="left"><input type="text" name="medNo"/><span id="medNoErrMsg"></span></td>
                            <td align="left"><input type="button" onclick="sub()" value="提交"/></td>
                        </tr>
                    </table>
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
