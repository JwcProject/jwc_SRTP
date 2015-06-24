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
<title>角色管理</title>
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
		<div class="sblb">系统角色列表</div>
	    </div>
		<div class="xia_left">
		<table>
		<ul>
		
		
		<li>
		
		<p>关键字:
		<s:textfield name="keyword" id="keyword" style="width:86px;height:14px"/>
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
		
		<div class="xia_right_sq" style="left:195px">
		<img src="<%=path%>/images/gonggaoweihu_icon1.gif" alt="查询" onclick="query();"/>
		<a href="javascript:document.queyForm.reset();" ><img src="<%=path%>/images/reset.png" alt="重置" "/></a>
	    <a href="PreAddRole" target="_blank" style="margin-left: 560px"><img src="<%=path%>/images/zhuanjia_anniu4.gif" alt="添加 " /></a>
            
		</div>
		
		<div id="declaraList" class="xia_list" >
 <table width="88%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="left" >
                                                                                                   
                      <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                        <td style="padding-left:10px" bgcolor="#FFFFFF" width="14%" class="NoNewline">|角色ID</td>
                        <td bgcolor="#FFFFFF" width="14%"> |角色名 </td>
                        <td bgcolor="#FFFFFF" width="15%"> |角色状态 </td>
						<td bgcolor="#FFFFFF" width="9%"> |角色介绍 </td>
						<td bgcolor="#FFFFFF" width="32%"> |操作 </td>                     
						 </tr>
					<s:iterator value="listRoles" id="listRoles" status="stuts"> 
					<s:if test="#stuts.odd == true">
					  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
    				</s:if>
    				<!--判断记号是否为偶数 -->
   					<s:else>
      				  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
    				</s:else>
                      <!--  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">-->
                        <td style="padding-left:10px" class="NoNewline"><s:property value="#listRoles.roleId" /></td>
                        <td ><s:property value="#listRoles.roleName" />&nbsp; </td>
                        <td >
                        <s:if test="#listRoles.roleState==01">激活</s:if>
                        <s:elseif test="#listRoles.roleState==02">未激活</s:elseif>
                        <s:else>错误代码</s:else>
                        
                        </td>
						<td >
						<s:if test="%{#listRoles.roleIntroduction.length()>10}">
								    	<s:property value="%{#listRoles.roleIntroduction.substring(0,10)+'...'}" escape="#onlineList.frmTitle"/>
								    </s:if> 
								    <s:else>
								    	<s:property value="#listRoles.roleIntroduction"/>&nbsp;
								    </s:else>
						 </td>
						
						
						<td >
						<s:a href="ViewRole?id=%{#listRoles.roleId}" target="_blank"><img src="<%=path%>/images/shenbiaoliebiao_icon1.gif" alt="查看" /></s:a>
				        <s:a href="PreUpdateRole?id=%{#listRoles.roleId}" target="_blank"><img src="<%=path%>/images/gonggaoweihu_icon3.gif" alt="编辑" /></s:a>
						<s:a href="DeleteRole?id=%{#listRoles.roleId}" ><img src="<%=path%>/images/gonggaoweihu_icon4.gif" alt="删除" /></s:a>
						<s:a href="PreAssignPermission?id=%{#listRoles.roleId}" target="_blank"><img src="<%=path%>/images/permission_icon.png" alt="权限添加" /></s:a>
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

 // var n = document.getElementById('pages').value;
      // var n = document.getElementsByTagName('s:hidden').value;
     //   alert(n);
     
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
     //var keyword = $("#keyword")[0].value;
	 location="ListRole?page="+pageclickednumber;    //+"&keyword="+keyword;
	}

function query()
{
    $("#pages")[0].value = 1;
	document.queyForm.action="<%=basePath%>QueryRole";
	document.queyForm.submit();
}   


       
    </script>
</body>
</html>
