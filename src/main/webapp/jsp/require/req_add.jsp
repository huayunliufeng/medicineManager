<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE>
<html xmlns:bean="http://java.sun.com/jsf/core">
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/bootstrap.min.css">
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>


    <script>

        //给方法取个名字
        let sub = ()=>{
            let categoryNoSelect = $("input[name='medNo']");
            let medNo = categoryNoSelect.val();
            $.get({
                url: "/req/requireCheckMedNo",  //请求的url，后台的servlet
                async: true,  //指定是否是异步请求
                data: {"medNo": medNo}, //请求的数据
                dataType: 'text',  //返回的数据类型
                contentType: 'application/json;charset=utf-8',
                cache: false,  //是否缓存
                success: function (data) { //回调函数，把data渲染到页面中
                     if(data === "ERROR"){
                        alert("格式错误！");
                        categoryNoSelect.focus();
                    }else if(data === "NO"){
                         alert("该药品不存在！");
                         categoryNoSelect.focus();
                     }else{
                         location.href = "${pageContext.request.contextPath}/req/iflu?medNo="+medNo;
                     }
                }
            });
        };


        //或者是
        function sub1(){
            //明白？
        }

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
                <form action="${pageContext.request.contextPath}/req/findReqByMedNo" method="post" id="form">
                    <input type="hidden" name="resPage" value="req_update"/>
                    <table border="0" align="center" width="300">
                        <tr>
                            <td align="right">药品编码：</td>
                            <td align="left"><input type="text" name="medNo" id="medNo"/>
                                </td>
                            <td align="right"><input type="button" onclick="sub()" value="提交"/></td>
                        </tr>

                    </table>
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
