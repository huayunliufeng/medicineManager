<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="pg" uri="http://wanggang.cn/common/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
  <head>
    <title></title>	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
	  <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
	  <script type="text/javascript">
		  function checkUserNameValue(value) {
			  if (value === "") {
				  document.getElementById("loginnameError").innerHTML = "数量不能为空";
			  } else {
				  document.getElementById("loginnameError").innerHTML = "";
			  }
		  }
	  </script>
  </head>
  <body>

  <div class="div1">
	  <table width="100%" cellpadding="0" cellspacing="0" border="0"
			 align="center">
		  <tr>
			  <td class="td_title1">当前位置·:医药管理&gt;&gt; 查看库存</td>
		  </tr>
		  <tr>
			  <td bgcolor="#FFFFFF" height="100" valign="top">
				  <br>
				  <form action="${pageContext.request.contextPath}/med/findInventory" method="get">
					  <input type="hidden" name="queryPage" value="med_list_nopaging" />
					  <table border="0" align="center" width="450">
						  <tr>
							  <td align="center">
								  库存数量：
								  <select name="type" id="type">
									  <option value="0">=</option>
									  <option value="1">&gt;</option>
									  <option value="-1">&lt;</option>
								  </select>
								  <input type="text" name="medCount" id="medCount" size="5" onblur="checkUserNameValue(this.value)"/>
								  <input type="submit" id="medCountError"  value="查询" />
							  </td>
							  <td>
								  <span id="loginnameError" class="error"></span>
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
