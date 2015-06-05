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

		<title>审核公告</title>
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
								<font color="blue">${announcementModel.announTitle}</font>
							</caption>
							<tr>
								<td align="center" width="10%">
									发布时间：
								</td>
								<td align="left" width="15%">
									<s:property value="announcementModel.publishTime" />
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									发布人：
								</td>
								<td align="left" width="15%">
									<s:property value="announcementModel.publisherName" />
								</td>
							</tr>
							<tr>
								<td align="center">
									内容简介：
								</td>
								<td align="left" width="15%">
									<s:property value="announcementModel.announContent" />
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									附件：
								</td>
								<td align="left" width="15%">
									<s:property value="" />
								</td>
							</tr>
							
							<tr align="center">
							    <td colspan="2">
									<s:a  href="UnpassedAnnouncement?announId=%{announcementModel.announId}">审核不通过</s:a>
								</td>
								<td colspan="2">
									<s:a  href="PassedAnnouncement?announId=%{announcementModel.announId}">审核通过</s:a>
								</td>
								<td colspan="2">
									<s:a href="ViewAnnouncement?announId=%{announcementModel.announId}" >查看</s:a>
								</td>
								<td colspan="2">
									<s:a href="EditAnnouncement?announId=%{announcementModel.announId}" >编辑</s:a>
								</td>
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
