<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE>
<html>
  <head>
    <title></title>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/bootstrap.min.css">
      <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
  </head>
  <body>
  <div class="div1">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">·当前位置：进货/需求管理	&gt;&gt; 更新需求</td>
			</tr>
			<tr>

				<td bgcolor="#FFFFFF" height="50">
					<br>
    <form action="${pageContext.request.contextPath}/req/updateReqCount" method="post">
    	<input type="hidden" name="id" value="${requires.id}" />
      <table border="0" align="center" width="500">
        <tr>
          <td align="right">药品编码：</td>
          <td align="left"><input type="text" name="medNo"  value="${requires.medNo}" readonly/></td>
        </tr>
        <tr>
          <td align="right">药品名称：</td>
          <td align="left"><input type="text" name="medName" value="${requires.medName}" disabled/></td>
        </tr>
        <tr>
          <td align="right">价格：</td>
          <td align="left"><input type="text" name="medPrice" value="${requires.medPrice}" disabled/>元</td>
        </tr>
        <tr>
          <td align="right">需求数量:</td>
          <td align="left">
              <input type="text" name="reqCount"/>
                	<font color="red">
                    目前数量:${requires.reqCount}
          	        </font>
          </td>
        </tr>
        <tr>
          <td align="right">出厂地址：</td>
          <td align="left"><input type="text" name="factoryAdd" value="${requires.factoryAdd}" disabled/></td>
        </tr>
        <tr>
          <td align="right">描述：</td>
          <td align="left"><input type="text" name="description" value="${requires.description}" disabled/></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit" value="提交"/></td>
        </tr>
      </table>
    </form>
    </td>
			</tr>
		</table>
	</div>
  </body>
</html>