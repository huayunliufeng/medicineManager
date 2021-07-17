<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE>
<html>
<head>
    <title>医药管理系统</title>
</head>
<frameset rows="180,*" cols="*" framespacing="0" frameborder="no"
          border="0">
    <frame src="${pageContext.request.contextPath}/jsp/top.jsp" name="top" scrolling="NO">
    <frameset rows="*" cols="223,*" framespacing="0" frameborder="no"
              border="0">
        <frame src="${pageContext.request.contextPath}/jsp/left.jsp" name="left">
        <frame src="${pageContext.request.contextPath}/med/findMed?resPage=baseData/med_list" name="main">
    </frameset>
</frameset>
<noframes>
    <body>
    </body>
</noframes>

</html>
