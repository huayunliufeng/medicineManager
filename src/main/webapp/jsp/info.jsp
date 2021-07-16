<%--
  Created by IntelliJ IDEA.
  User: 华韵流风
  Date: 2021/7/15
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息</title>
    <style>
        * {
            margin: auto;
            text-align: center;
        }

        #time {
            color: red;
        }
        h3,p {
            width: 100%;
        }

    </style>
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
    <script>

        $(function () {
            let time = 3;
            setInterval(function () {
                $("#time").text(time);
                time--;
                if (time <= 0) {
                    parent.location.reload();
                }
            }, 1000);
        });

    </script>
</head>
<body>
<h3>${info}</h3>
<p>页面将在&nbsp;&nbsp;<span id="time">3</span>&nbsp;&nbsp;秒中之后关闭……</p>
</body>
</html>
