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

		<title>查看用户</title>
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
								<font color="blue">查看用户</font>
							</caption>
							<tr>
								<td align="center" width="10%">
									登录名
								</td>
								<td align="left" width="15%">
									<s:property value="user.userId" />
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									昵称
								</td>
								<td align="left" width="15%">
									<s:property value="user.userName" />
								</td>
							</tr>
							<tr>
								<td align="center">
									用户类型
								</td>
								<td>
								<s:if test="user.userType=='01'">
											教师
								  </s:if> 
						          <s:elseif test="user.userType=='02'">
						         			 学生
						          </s:elseif>	
									<s:elseif test="user.userType=='03'">
						         			 管理员
						          </s:elseif>
						          <s:else>
						         			 错误代码
						          </s:else>
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									登录状态
								</td>
								<td align="left" width="15%">
									<s:property value="user.userState" />
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									用户简介
								</td>
								<td align="left" width="15%">
									<s:property value="user.userIntroduction" />
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
