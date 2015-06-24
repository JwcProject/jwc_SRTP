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

		<title>添加用户</title>
		<link href="<%=path%>/style/home.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/style/jquery.jgrowl.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=path%>/style/global.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=path%>/style/site.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<div id="main" class="wrapper clearfix">
			<s:form action="AddRole" theme="simple">

				<div class="con-box">
					<div class="con">
						<table cellpadding="0" cellspacing="0" class="info-table"
							width="100%">
							<caption>
								<font color="blue">添加角色</font>
							</caption>
							<tr>
								<td align="center" width="10%">
									角色名
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:textfield name="role.roleName"></s:textfield>
								</td>
							</tr>
							<tr>
								<td align="center">
									角色状态
									<font color="red">*</font>
								</td>
								<td>
									<s:radio name="role.roleState"
										list="#{'01':'激活','02':'未激活'}"></s:radio>
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									角色简介
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:textarea name="role.roleIntroduction" cols="80" rows="10"></s:textarea>
								</td>
							</tr>

							<tr align="center">
								<td colspan="2">
									<s:submit value="保存"></s:submit>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</s:form>
		</div>
	</body>
</html>
