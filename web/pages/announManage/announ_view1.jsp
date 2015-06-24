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

		<title>查看公告</title>
	</head>

	<body>
    <div id="main">
        <div style="display: inline">
           <p><label style="color: red">公告名称：</label>${announcementModel.announTitle}</p>
           <p align="right">发布人：<s:property value="announcementModel.publisherName" /></p>
           <p align="right">发布时间：<s:date name="announcementModel.publishTime" format="yyyy-MM-dd hh:mm:ss"/></p>
        </div>
        <hr/>
        <div>
	       <label style="color: red;">内容简介：</label>
	       <p>
	          <s:property value="announcementModel.announContent" escape="false"/>
	       </p>
	    </div>
	    <div>
	       <label style="color: red;">相关附件：</label>
	       <p>
	          <s:iterator value="attachments" id="attachment"><a href="downLoadAttachment?attachementId=<s:property value="attaId" />"><s:property value="fileName" /></a>&nbsp;&nbsp;</s:iterator>
	       </p>
	       <button  onclick="history.back(-1)">返回</button>
	    </div>
    </div>
	</body>
</html>
