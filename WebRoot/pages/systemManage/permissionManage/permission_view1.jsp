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

		<title>查看权限</title>
		<link href="<%=path%>/style/home.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/style/jquery.jgrowl.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=path%>/style/global.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=path%>/style/site.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<div id="main" class="wrapper clearfix">
			<s:form theme="simple">

				<div class="con-box">
					<div class="con">
						<table cellpadding="0" cellspacing="0" class="info-table"
							width="100%">
							<caption>
								<font color="blue">查看权限</font>
							</caption>
								<tr>
								<td align="center" width="10%">
									权限名
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:textfield name="permission.permissionName" value="%{permission.permissionName}"></s:textfield>
								</td>
							</tr>
							<tr>
								<td align="center">
									权限状态
									<font color="red">*</font>
								</td>
								<td>
									<s:radio name="permission.permissionState" value="%{permission.permissionState}"
										list="#{'01':'激活','02':'关闭'}"></s:radio>

								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									权限Url
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:textfield name="permission.permissionUrl" value="%{permission.permissionUrl}" id="permissionUrl" />
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									权限层级
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:textfield name="permission.permissionLevel" value="%{permission.permissionLevel}" id="permissionLevel" />
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									父权限
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:textfield name="permission.permissionFatherid" value="%{permission.permissionFatherid}" id="permissionFatherid" />
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									权限描述
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:textarea name="permission.permissionIntroduction"  value="%{permission.permissionIntroduction}" cols="80" rows="10"></s:textarea>
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
