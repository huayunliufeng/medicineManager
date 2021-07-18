<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE>
<html>
  <head>
    <title></title>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/bootstrap.min.css">
      <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
    <script>
      $(function () {
        let medNoSelect = $("input[name='medNo']");
        medNoSelect.blur(function () {
          let medNo = medNoSelect.val();
          $.get({
            url: "/req/requireCheckMedNo",  //请求的url，后台的servlet
            async: true,  //指定是否是异步请求
            data: {"medNo": medNo}, //请求的数据
            dataType: 'text',  //返回的数据类型
            contentType: 'application/json;charset=utf-8',
            cache: false,  //是否缓存
            success: function (data) { //回调函数，把data渲染到页面中
              if(data === "YES"){
                $("#medNoErrMsg").text("该编号需要已存在！");
                medNoSelect.focus();
              }else if(data === "ERROR"){
                $("#medNoErrMsg").text("有错误！");
                medNoSelect.focus();
              }else{
                $("#medNoErrMsg").text("");
              }
            }
          });
        });
      })
    </script>
  </head>
  <body>
  <div class="div1">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"	align="center">
			<tr>
				<td class="td_title1">·当前位置：进货/需求管理	&gt;&gt; 添加进货</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
    <form action="${pageContext.request.contextPath}/req/addReq" method="post" enctype="multipart/form-data">
      <table border="0" align="center" width="500">
        <tr>
          <td align="right">药品编码：</td>
          <td align="left"><input type="text" name="medNo" value="${medNo}" /><span id="medNoErrMsg"></span></td>
        </tr>
        <tr>
          <td align="right">药品名称：</td>
          <td align="left"><input type="text" name="medName"/></td>
        </tr>
        <tr>
          <td align="right">价格：</td>
          <td align="left"><input type="number" min="0" step="0.1" name="medPrice" />	元</td>
        </tr>
        <tr>
          <td align="right">数量 ：</td>
          <td align="left"><input type="number" min="1" name="reqCount"/></td>
        </tr>
        <tr>
          <td align="right">所属类别：</td>
          <td align="left">
          	<select name="categoryId" id="categoryId">
                <option value="0">---请选择-</option>
                <c:forEach items="${categorys}" var="$category">
                    <option value="${$category.id}">${$category.name}</option>
                </c:forEach>
          	</select>
          </td>
        </tr>
        <tr>
          <td align="right">图片：</td>
          <td align="left"><input type="file"  accept="image/jepg,image/png" name="photoPath"/></td>
        </tr>
        <tr>
          <td align="right">出厂地址：</td>
          <td align="left"><input type="text" name="factoryAdd"/></td>
        </tr>
        <tr>
          <td align="right">描述：</td>
          <td align="left"><input type="text" name="description"/></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit" value="提交"></td>
        </tr>
      </table>
    </form>
    </td>
			</tr>
		</table>
	</div>
  </body>
</html>
