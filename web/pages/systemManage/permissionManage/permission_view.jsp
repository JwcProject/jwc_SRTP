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
<title>查看权限</title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
</head>
<body>
<div id="container">
  
<jsp:include page="../../../header.jsp" ></jsp:include>
  <!--  此处显示 id "maincontent" 的内容-->
  <div id="maincontent" class="h645">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
	  
        <!--  左边区域-->
         <jsp:include page="../../../dean_left.jsp" ></jsp:include>
		  
        <!--中间区域-->
        <td width="88%" valign="top"  style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc" bordercolor="#f4f3f1"  >
		<div class="midbox">
		<div class="midbox_gg">
		<div class="sblb">权限基本信息</div>
	    </div>
		<div class="ggzs_wz">
		<p>权限名：<s:property value="permission.permissionName" /></p>
		<p>权限状态：
          <s:if test="permission.permissionState=='01'">激活</s:if> 
		  <s:elseif test="permission.permissionState=='02'">关闭</s:elseif>	
		  <s:else>错误代码</s:else>
        </p>
        <p>权限URL：<s:property value="permission.permissionUrl" /></p>
        <p>权限层级：<s:property value="permission.permissionLevel" /></p>
        <p>父权限：<s:property value="permission.permissionFatherid" /></p>
		<p>权限描述：<s:property value="permission.permissionIntroduction" /></p>
		
		
		
		
		<!--  
		<table width="60%" border="0" cellspacing="0" cellpadding="0" style="font-size:14px; border-top:1px solid #dcdcdc; border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="center" >
		<tr style="border-bottom: 1px solid #dcdcdc">
		  <td align="center">登录名：</td>
		  <td align="left"><s:property value="user.userId" /></td>
		</tr >
		<tr style="border-bottom: 1px solid #dcdcdc">
		  <td align="center">昵称：</td>
		  <td align="left"><s:property value="user.userName" /></td>
		</tr>
		<tr style="border-bottom: 1px solid #dcdcdc">
		   <td align="center">用户类型</td>
		   <td align="left">
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
		<tr style="border-bottom: 1px solid #dcdcdc">
			<td align="center"  >登录状态</td>
		    <td align="left" width="60%">
				<s:property value="user.userState" />
			</td>
		</tr>
		<tr style="border-bottom: 1px solid #dcdcdc">
			<td align="center" >用户简介</td>
			<td align="left" width="60%">
				<s:property value="user.userIntroduction" />
			</td>
		</tr>
		</table>
		-->
</div>
		<div class="xia_anniu" style="margin-left:30px">
		<ul>
		<li><a href="#" onclick="window.opener=null;window.close(this);"><img src="<%=path%>/images/close.png" alt="关闭" /></a></li>
		
		</ul>
		</div>
		</div>
		</td>
          
        
		
	
	</tr>
	</table>
  </div>
   <jsp:include page="../../../footer.jsp" ></jsp:include>
</div>
<script src="<%=path%>/js/system.js" type="text/javascript"></script>
</body>
</html>
