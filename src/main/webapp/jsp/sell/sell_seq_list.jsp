<%@ page language="java" pageEncoding="utf-8"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <title><bean:message key="system.category.sell.sep"/></title>


	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../../../staticpage/images/styles.css">
  </head>
  <body>
  <div class="div1">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">
					·<bean:message key="system.current.place"/>：
					<bean:message key="system.category.sell"/>
					&gt;&gt; <bean:message key="system.category.sell.sep"/>
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
      <table border="1" align="center" width="700" cellpadding="1" cellspacing="1" bgcolor="#036500" bordercolor="#FFFFF">
        <tr bgcolor="#FFFFFF">
          <td class="tb_tl"><bean:message key="sell.seq" /></td>
          <td class="tb_tl"><bean:message key="medicine.name" /></td>
          <td class="tb_tl"><bean:message key="system.count" /></td>
          <td class="tb_tl"><bean:message key="sell.money" /></td>
          <td class="tb_tl"><bean:message key="system.operate" /></td>
        </tr>
        <logic:present name="list" scope="request">
        	<logic:notEmpty name="list" scope="request">
	        	<logic:iterate id="ele" name="list" scope="request" indexId="index">
	        		<tr bgcolor="#FFFFFF">
	        			<td>${index+1}</td>
	        			<td>
	        				<html:link href="sell.do?command=findByMedId" paramId="id" paramName="ele" paramProperty="medId">
	        				<bean:write name="ele" property="name"/>
	        				</html:link>
	        			</td>
	        			<td><bean:write name="ele" property="totalCount"/></td>
	        			<td><bean:write name="ele" property="totalPrice" format="###,###.##"/>
	        					<bean:message key="system.money"/>
						</td>
	        			<td>
	        				<html:link href="../require/require.do?command=update" paramId="id" paramName="ele" paramProperty="medId">进货</html:link>
	        				<html:link href="../baseData/med.do?command=view" paramId="id" paramName="ele" paramProperty="medId">查看药品</html:link>
	        			</td>
	        		</tr>
	        	</logic:iterate>
        	</logic:notEmpty>
        	<logic:empty name="list" scope="request">
        	<tr bgcolor="#FFFFFF">
	          <td colspan="5" align="center">
				<bean:message key="system.message.null"/>
			  </td>
	        </tr>
        	</logic:empty>
        </logic:present>
        <logic:notPresent name="list" scope="request">
        	<tr bgcolor="#FFFFFF">
	          <td colspan="4" align="center">
				<bean:message key="system.message.null"/>
			  </td>
	        </tr>
	    </logic:notPresent>
      </table>
      <br>
       </td>
			</tr>
		</table>
	</div>
  </body>
</html:html>
