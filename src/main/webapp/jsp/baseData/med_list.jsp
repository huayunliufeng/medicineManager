<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/styles.css">
  </head>
  <body>
  <div class="div1">

		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">·当前位置：医药管理&gt;&gt; 查看药品&gt;&gt; 所有药品</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
      <table border="1" align="center" width="700" cellpadding="1" cellspacing="1" bgcolor="#036500" bordercolor="#FFFFF">
        <tr bgcolor="#FFFFFF">
          <td colspan="9" align="center">
          		<table border="0" width="100%">
          			<tr>
          				<td align="left">     
                        <form  action='med_list.jsp' method="post" onsubmit="return blurQuery();" class="blur_form">
          						<input type="hidden" name="command" value="blurQuery"/>
          						模糊查询：<input name="keyWord" type="text" size="20" value="按名称或出厂地址"/>
          						<input type="submit" value="查询"/>
          				</form>
          				</td>
          			</tr>
          		</table>
          </td>
        </tr>
        <tr bgcolor="#FFFFFF" >
          <td class="tb_tl">药品ID</td>
          <td class="tb_tl">药品编码</td>
          <td class="tb_tl">药品名称</td>
          <td class="tb_tl">单价</td>
          <td class="tb_tl">库存数量</td>
          <td class="tb_tl">出厂地址</td>
          <td class="tb_tl">操作</td>
        </tr>        		
	        	<tr bgcolor="#FFFFFF">
	        			<td>xxxxxxxxxxxxx</td>
	        			<td>0001</td>
	        			<td>牛黄解毒丸</td>
	        			<td>123.56元</td>
	        			<td>232</td>
	        			<td>上海市徐汇区</td>
	        			<td><a href="med_update.html">修改</a>&nbsp; <a href="med_list">删除</a> </td>
                	</tr>
	        	<tr bgcolor="#FFFFFF">		        
		          <td colspan="9" align="right">
		          	<table border="0" width="100%">
		          		<tr>		          			
		          			<td align="right">
							 <a href="">首页</a>&nbsp;<a href="">上页</a>&nbsp;<a href="">下页</a>&nbsp;<a href="">末页</a>&nbsp;
		          			</td>
		          		</tr>
		          	</table>
			      </td>
			    </tr> 
      </table><br>
      </td>
			</tr>
		</table>
	</div>
  </body>
</html>
