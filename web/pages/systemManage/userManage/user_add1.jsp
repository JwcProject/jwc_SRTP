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
			<s:form action="AddUser" theme="simple">

				<div class="con-box">
					<div class="con">
						<table cellpadding="0" cellspacing="0" class="info-table"
							width="100%">
							<caption>
								<font color="blue">添加用户</font>
							</caption>
							<tr>
								<td align="center" width="10%">
									登录名称
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:textfield name="user.userId"></s:textfield>
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									昵称
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:textfield name="user.userName"></s:textfield>
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									密码
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:password name="user.userPassword" id="pwd1" />
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									确认密码
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:password name="userPassword" id="pwd2" />
								</td>
							</tr>
							<tr>
								<td align="center">
									用户类型
									<font color="red">*</font>
								</td>
								<td>
									<s:radio name="user.userType"
										list="#{'01':'教师','02':'学生','03':'管理员'}"></s:radio>

								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									用户简介
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:textarea name="user.userIntroduction" cols="80" rows="10"></s:textarea>
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
