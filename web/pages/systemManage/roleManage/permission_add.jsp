<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加权限</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/Pager.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/js/themes/icon.css" rel="stylesheet" type="text/css" />
	

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
		<s:form name="inforForm" id="userForm" method="post" >
		<div class="midbox">
		<div class="midbox_gg">
		<div class="sblb">分配权限</div>
	    </div>
		<div class="ggzs_wz">
		
		<table align="left" style="margin-left:30px">
		<tr >
		  <td align="right" style="font-size: 18px">角色名：</td>
		  <td align="left" style="font-size: 16px;color:rgb(89,89,89)">
		 	<s:hidden name="role.roleId" value="%{role.roleId}"></s:hidden>
		 	<s:property value="role.roleName" />
		  </td>
		</tr >
		<tr >
		  <td align="right" style="font-size: 18px, width: 300px;">角色介绍：</td>
		  <td align="left" style="font-size: 16px;color:rgb(89,89,89)">
		  	<s:property value="role.roleIntroduction" />
		  </td>
		</tr>
		<!-- <tr >
		  <td align="right"><ul id="pertt"></ul></td>
		</tr> -->
		</table>
		
		<br><br><br>
		<div ><ul id="pertt"></ul></div>
		
		</div>
		<div class="xia_anniu" style="margin-left:30px;margin-top:30px">
		<ul>
		<li><a  href="javascript:void(0);" onclick="setPerms()"><img src="<%=path%>/images/mima_anniu1.gif" alt="提交"/></a></li>
		<li><a href="#" target="_blank"><img src="<%=path%>/images/mima_anniu2.gif" alt="取消" /></a></li>
		
		</ul>
		</div>
		</div>
		</s:form>
		</td>
	
	</tr>
	</table>
  </div>
   <jsp:include page="../../../footer.jsp" ></jsp:include>
</div> 

<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
<script src="<%=path%>/js/Validform_v5.3.2_min.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script src="<%=path%>/js/system.js" type="text/javascript"></script>
<script type="text/javascript">
//var tree;
$(function() {
	$('#pertt').tree({
	    url:'GetRolePermissons?id=${role.roleId}',
	    checkbox:true
	});
});

function setPerms(){
	var listPermissionIds = "";
	var checkedNodes = $('#pertt').tree('getChecked', 'checked');
	for(var i in checkedNodes){
		listPermissionIds += "&listPermissionIds="+checkedNodes[i].id;
	}
	/* var indeterminateNodes = $('#pertt').tree('getChecked', 'indeterminate');
	for(var i in indeterminateNodes){
		listPermissionIds += "&listPermissionIds="+indeterminateNodes[i].id;
	} */
	with (document.getElementById("userForm")) {
        method = "post";
        action = "AssignPermission?id=${role.roleId}"+listPermissionIds;
        submit();
    }
}
</script>
  </body>
</html>
