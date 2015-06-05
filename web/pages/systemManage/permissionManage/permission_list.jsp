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
<title>权限管理</title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/Pager.css" rel="stylesheet" type="text/css" />
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>

</head>
<body>
<div id="container">
  <jsp:include page="../../../header.jsp" ></jsp:include>
  <!--  此处显示 id "maincontent" 的内容-->
  <div id="maincontent" class="h645">
  <s:form action="" method="post" name="queyForm"
					theme="simple">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
	  
        
		<jsp:include page="../../../dean_left.jsp"></jsp:include>
        <!--中间区域-->
        <td width="88%" valign="top"  style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc" bordercolor="#f4f3f1"  >
		<div class="midbox">
		<div class="midbox_gg">
		<div class="sblb">系统权限列表</div>
	    </div>
		<div class="xia_left">
		<table>
		<ul>
		
		
		<li>
		<p>权限名称:
		<s:textfield name="permission.permissionName" id="permissionName" style="width:86px;height:14px"/>
		</p>
		</li>
		
		<li>
		<p>权限状态:
		 <input type="radio" name="permission.permissionState" value="01"/>激活
		<input type="radio" name="permission.permissionState" value="02"/>关闭
		<!-- <s:select name="permission.permissionState" id="permissionState" list="#{'00':'不限','01':'激活','02':'关闭'}"  ></s:select>-->
		</p>
		</li>
		
		<li>
		<p>权限层级:
		<s:textfield name="permission.permissionLevel" id="permissionLevel" style="width:86px;height:14px"/>
		</p>
		</li>
		
		
		
		
      <li>
       <s:hidden id="pages" name="page" value="%{page}"></s:hidden>
      </li>
      <li>
       <s:hidden id="totalPages" name="totalPage" value="%{totalPage}"></s:hidden>
      </li>
</ul>
</table>
		</div>
		
		<div class="xia_right_sq" style="left:595px">
		<img src="<%=path%>/images/gonggaoweihu_icon1.gif" alt="查询" onclick="query();"/>
		<a href="javascript:document.queyForm.reset();" ><img src="<%=path%>/images/reset.png" alt="重置" "/></a>
		<a href="PreAddPermission" target="_blank" style="margin-left: 170px"><img src="<%=path%>/images/zhuanjia_anniu4.gif" alt="添加 " /></a>
            
		</div>
		
		<div id="declaraList" class="xia_list" >
 <table width="88%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="left" >
                                                                                                   
                      <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                        <td style="padding-left:10px" bgcolor="#FFFFFF" width="9%" class="NoNewline">|权限名</td>
                        <td bgcolor="#FFFFFF" width="16%"> |权限描述 </td>
                        <td bgcolor="#FFFFFF" width="8%"> |权限状态</td>
						<td bgcolor="#FFFFFF" width="8%"> |权限层级</td>
						<td bgcolor="#FFFFFF" width="9%"> |权限URL </td> 
						<td bgcolor="#FFFFFF" width="24%"> |父权限 </td> 
						<td bgcolor="#FFFFFF" width="30%"> |操作</td>                    
						 </tr>
					<s:iterator value="listPermissions" id="listPermissions" status="stuts"> 
					<s:if test="#stuts.odd == true">
					  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
    				</s:if>
    				<!--判断记号是否为偶数 -->
   					<s:else>
      				  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
    				</s:else>
                      <!--  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">-->
                        <td style="padding-left:10px" class="NoNewline"><s:property value="#listPermissions.permissionName" /></td>
                        <td >
                            <s:if test="%{#listPermissions.permissionIntroduction.length()>10}">
								              <s:property value="%{#listPermissions.permissionIntroduction.substring(0,10)+'...'}" escape="#onlineList.frmTitle"/>
								          </s:if> 
								          <s:else>
								           <s:property value="#listPermissions.permissionIntroduction"/>&nbsp;
								          </s:else>
                        </td>
                        <td >
                          <s:if test="%{#listPermissions.permissionState=='01'}">激活</s:if>
                          <s:elseif test="%{#listPermissions.permissionState=='02'}">关闭</s:elseif>
                          <s:else>错误代码</s:else>
                        </td>
						<td >
							<s:property value="#listPermissions.permissionLevel"/>&nbsp;
						 </td>
						<td >
							<s:property value="#listPermissions.permissionUrl" />
						</td>
						<td >
							<s:property value="#listPermissions.permissionFatherid" />
						</td>
						
						<td >
						<s:a href="ViewPermission?id=%{#listPermissions.permissionId}" target="_blank"><img src="<%=path%>/images/shenbiaoliebiao_icon1.gif" alt="查看" /></s:a>
				        <s:a href="PreUpdatePermission?id=%{#listPermissions.permissionId}" target="_blank"><img src="<%=path%>/images/gonggaoweihu_icon3.gif" alt="编辑" /></s:a>
						<s:a href="DeletePermission?id=%{#listPermissions.permissionId}" ><img src="<%=path%>/images/gonggaoweihu_icon4.gif" alt="删除" /></s:a>
						</td>                    
					  </tr>
					</s:iterator>	   
						
	                                                                                   
                       
                </table></div>
                
		<div class="xia_x">
		
		<div id="pager" >
		</div>
		</div>
		</div>
		</td>
          
        
		
	
	</tr>
	</table>
	</s:form>
  </div>
   <jsp:include page="../../../footer.jsp" ></jsp:include>
</div>
<script src="<%=path%>/js/jquery.pager.js" type="text/javascript"></script>
<script src="<%=path%>/js/system.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">

 
        $(document).ready(function() {
            var page = $("#pages")[0].value;
            var totalPage = $("#totalPages")[0].value;
            //alert(page);
            //alert(totalPage);
            $("#pager").pager({ pagenumber: page, pagecount: totalPage, buttonClickCallback: PageClick });
        });

        PageClick = function(pageclickednumber) {
            var totalPage = $("#totalPages")[0].value;
            $("#pager").pager({ pagenumber: pageclickednumber, pagecount: totalPage, buttonClickCallback: PageClick });
            changePage(pageclickednumber);
        };


function changePage(pageclickednumber){
     var permissionName = $("#permissionName")[0].value;
     var permissionLevel = $("#permissionLevel")[0].value;
     var zt = document.getElementsByName("permission.permissionState");
     for(var i=0;i<zt.length;i++){
	   var permissionState = zt[i].value;
	}
	 //var permissionState = $("#permissionState")[0].value;
	  location="searchPermission?page="+pageclickednumber+"&permissionName="+permissionName+"&permissionLevel="+permissionLevel+"&permissionState="+permissionState;
	}
 
function query()
{
    $("#pages")[0].value = 1;
	document.queyForm.action="<%=basePath%>searchPermission";
	document.queyForm.submit();
}       
      
    
    </script>
</body>
</html>
