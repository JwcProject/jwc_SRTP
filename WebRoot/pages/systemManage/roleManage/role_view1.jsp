<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>查看角色</title>
		<link href="<%=path%>/style/home.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/style/jquery.jgrowl.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=path%>/style/global.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=path%>/style/site.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<div id="main" class="wrapper clearfix">
			<s:form action="" theme="simple">

				<div class="con-box">
					<div class="con">
						<table cellpadding="0" cellspacing="0" class="info-table"
							width="100%">
							<caption>
								<font color="blue">查看角色</font>
							</caption>
							<tr>
								<td align="center" width="10%">
									角色名
								</td>
								<td align="left" width="15%">
									<s:property value="role.roleName" />
								</td>
							</tr>
							<tr>
								<td align="center">
									角色状态
								</td>
								<td>
								<s:if test="role.roleState=='01'">
											激活
								  </s:if> 
						          <s:elseif test="role.roleState=='02'">
						         			 未激活
						          </s:elseif>
						          <s:else>
						         			 错误代码
						          </s:else>
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									角色简介
								</td>
								<td align="left" width="15%">
									<s:property value="role.roleIntroduction" />
								</td>
							</tr>
							
							<tr align="center">
								<td colspan="2">
									<button  onclick="history.back(-1)">返回</button>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</s:form>
		</div>
	</body>
</html>
