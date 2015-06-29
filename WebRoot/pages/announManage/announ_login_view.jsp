<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看公告</title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
</head>
<body>
<div id="container">
  <jsp:include page="../../header.jsp" ></jsp:include>
  <!--  此处显示 id "maincontent" 的内容-->
  <div id="maincontent" class="h645">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
	  
        <!--  左边区域-->
         
		  
        <!--中间区域-->
        <td width="88%" valign="top"  style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc" bordercolor="#f4f3f1"  >
		<div class="midbox">
		<div class="midbox_gg">
		<div class="sblb">公告展示</div>
	    </div>
		<div class="ggzs_wz">
		<p style="text-align:center"><b>${announcementModel.announTitle}</b></p>
		 <!--  <p style="text-align:center"><b>“重庆大学大学生科研训练计划（SRTP）”项目的通知</b></p>-->
		<p>发布时间：<s:date name="announcementModel.publishTime" format="yyyy年MM月dd日"/></p>
		<p>发布人：<s:property value="announcementModel.publisherName" /></p>
		<p>内容简介：</p>
		<!--  <p>各学院：</p>-->
		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="announcementModel.announContent" escape="false"/></p>
		<p>附件：
		 <s:iterator value="attachments" id="attachment"><a href="downLoadAttachment?attachementId=<s:property value="attaId" />"><s:property value="fileName" /></a>&nbsp;&nbsp;</s:iterator>
		</p>
</div>
		<div class="xia_anniu">
		<ul>
		<li><a href="#" onclick="window.opener=null;window.close(this);"><img src="images/fabugonggao_anniu2.gif" alt="返回" /></a></li>
		
		</ul>
		</div>
		</div>
		</td>
          
        
		
	
	</tr>
	</table>
  </div>
  <jsp:include page="../../footer.jsp"></jsp:include>
</div>
<script type="text/javascript" src="<%=path%>/js/annoument.js"></script>
</body>
</html>
