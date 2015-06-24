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
<title>添加权限  </title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/style/home.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/style/jquery.jgrowl.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/style/global.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet" type="text/css"/>
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->

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
		<s:form action="AddPermission" name="inforForm" id="userForm" method="post" theme="simple" >
		<div class="midbox">
		<div class="midbox_gg">
		<div class="sblb">添加权限</div>
	    </div>
		<div class="ggzs_wz">
		
		<table align="left" style="margin-left:30px">
		<tr >
		  <td align="right" style="font-size: 18px">权限名:</td>
		  <td align="left">
		  <s:textfield name="permission.permissionName" id="text_fabu" cssStyle="width: 300px; font-size: 18px" datatype="*"
												nullmsg="请输入权限名" />
		  </td>
		  <td>
		     <span class="Validform_checktip" id="checkSpan" ></span>
		  </td>
		</tr >
		
		<tr >
		   <td align="right" style="font-size: 18px">权限状态:</td>
		   <td align="left">
		   <s:radio name="permission.permissionState" cssStyle="font-size:18px" list="#{'01':'已分配','02':'未激活'}" ></s:radio>
		   </td>
		   <td>
		     <span class="Validform_checktip" id="checkSpan" ></span>
		  </td>
		</tr>
		
		<tr >
		  <td align="right" style="font-size: 18px">权限URL:</td>
		  <td align="left">
		  <s:textfield name="permission.permissionUrl" id="text_fabu" cssStyle="width: 300px; font-size: 18px" datatype="*"
												nullmsg="请输入权限URL" />
		  </td>
		  <td>
		     <span class="Validform_checktip" id="checkSpan" ></span>
		  </td>
		</tr >
		
		<tr >
		  <td align="right" style="font-size: 18px">权限层级:</td>
		  <td align="left">
		   <s:select list='#{"0 ":"0","1 ":"1","2 ":"2"}'
		  name="permission.permissionName" id="select" cssStyle="width:300px;height:30px;font-size: 18px;color:rgb(89,89,89)"></s:select>
		  </td>
		  
		</tr >
		
		<tr >
		  <td align="right" style="font-size: 18px">父权限：</td>
		  <td align="left">
		  <input id="permissionFatherid" value="${permission.permissionFatherid}" name="permission.permissionFatherid" style="width: 300px; font-size: 18px" datatype="*"
												nullmsg="请选择父权限" />
		  </td>
		  <td>
		     <span class="Validform_checktip" id="checkSpan" ></span>
		  </td>
		</tr >
		
		<tr >
			<td align="right" style="font-size: 18px">权限描述:</td>
			<td align="left" >
				<s:textarea name="permission.permissionIntroduction" cssStyle="width: 300px;resize:none;margin-left:10px;overflow-y:scroll" datatype="*"
												nullmsg="请输入权限描述" />
			</td>
			 <td>
		     <span class="Validform_checktip" id="checkSpan" ></span>
		  </td>
		</tr>
		</table>
		
</div>
		<div class="xia_anniu" style="margin-left:130px;margin-top:300px">
		<ul>
		<li><input type="image" name="submit" src="<%=path%>/images/mima_anniu1.gif" alt="提交" /></li>
		<!-- <li><a href="javascript:document.inforForm.reset();"><img src="images/mima_anniu2.gif" alt="取消" /></a></li> -->
		<li><input type="reset" value="" style="background:url(<%=path%>/images/mima_anniu2.gif); border:0px; width:103px; height:26px; " /></li>
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
<script src="<%=path%>/js/Validform_v5.3.2_min.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script src="<%=path%>/js/system.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8">




		
	$(function() {
		$('#userForm').Validform({
			tiptype : 2
		});
	});
	
	
	$(function() {
		        $('#permissionFatherid').combotree({   
                     url: 'findFatherPermsTree?curFatherPermsId=${permission.permissionFatherid}',                       
                     loadFilter: function(data){   
                         if (data.fathPermsTree){   
                            return data.fathPermsTree;   
                         } else {   
                            return data;   
                         }                      
                     },          
                     checkbox:true,
                     lines:true    
                }); 
		    });
		    
	
</script>
</body>

</html>
