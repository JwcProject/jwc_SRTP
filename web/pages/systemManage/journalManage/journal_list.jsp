﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<title>日志列表</title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/Pager.css" rel="stylesheet" type="text/css" />

<link href="<%=path%>/style/jquery.datepick.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/js/themes/icon.css" rel="stylesheet" type="text/css" />
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->


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
        <td width="90%" valign="top"  style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc" bordercolor="#f4f3f1"  >
		<div class="midbox">
		<div class="midbox_gg">
		<div class="sblb">系统日志列表</div>
	    </div>
		<div class="xia_left">
		
		<ul>
		
		
		<li>
		<p>登录名:
		<s:textfield name="userId" id="userId" style="width:84px;height:12px"/>
		</p>
		</li>
		
		<li>
		<p>昵称:
		<s:textfield name="userName" id="userName" style="width:84px;height:12px"/>
		</p>
		</li>
		
		<li>
		<p>登录IP:
		<s:textfield name="journalLoginip" id="journalLoginip" style="width:84px;height:12px"/>
		</p>
		</li>
		
		<li>
		<p>登录时间:
		<s:textfield cssClass="easyui-datebox" name="journalLogintime" id="journalLogintime" cssStyle="width:103px" />
		</p>
		</li>
		
		<li>
		<p>退出时间:
		<s:textfield cssClass="easyui-datebox" name="journalQuitime" id="journalQuitime" cssStyle="width:103px"/>
		</p>
		</li>
		
		
		
		
      <li>
       <s:hidden id="pages" name="page" value="%{page}"></s:hidden>
      </li>
      <li>
       <s:hidden id="totalPages" name="totalPage" value="%{totalPage}"></s:hidden>
      </li>
</ul>

		</div>
		
		<div class="xia_right_sq">
		<img src="<%=path%>/images/gonggaoweihu_icon1.gif" alt="查询" onclick="query();" style="margin-left:-38px"/>
		<a href="javascript:document.queyForm.reset();" ><img src="<%=path%>/images/reset.png" alt="重置" "/></a>
		<a href="ListJournalAct" target="_blank" style="margin-left:5px" ><img src="<%=path%>/images/journalDetail.png" alt="日志明细 " /></a>
            
		</div>
		
		<div id="declaraList" class="xia_list" >
 <table width="92%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="left" >
                                                                                                   
                      <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                        <td style="padding-left:10px" bgcolor="#FFFFFF" width="14%" class="NoNewline">|用户登录名</td>
                        <td bgcolor="#FFFFFF" width="14%"> |用户昵称 </td>
                        <td bgcolor="#FFFFFF" width="14%"> |登录IP </td>
						<td bgcolor="#FFFFFF" width="15%"> |登录时间 </td>
						<td bgcolor="#FFFFFF" width="15%"> |退出时间 </td>                     
						 </tr>
					<s:iterator value="listJournals" id="listJournals" status="stuts"> 
					<s:if test="#stuts.odd == true">
					  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
    				</s:if>
    				<!--判断记号是否为偶数 -->
   					<s:else>
      				  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
    				</s:else>
                      <!--  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">-->
                        <td style="padding-left:10px" class="NoNewline"><s:property value="#listJournals.TUser.userId" /></td>
                        <td ><s:property value="#listJournals.userName" />&nbsp; </td>
                        <td ><s:property value="#listJournals.journalLoginip" />&nbsp;</td>
						<td >
						 <s:if test="null==#listJournals.journalLogintime||#listJournals.journalLogintime.isEmpty()">  
						    
						</s:if>
						<s:else>
						    <s:text name="global.format.datetim">
							<s:param value="#listJournals.journalLogintime"/>
							</s:text>
						</s:else>
						</td>
						<td >
						 <s:if test="null==#listJournals.journalQuitime||#listJournals.journalQuitime.isEmpty()">  
						    
						</s:if>
						<s:else>
						    <s:text name="global.format.datetim">
							<s:param value="#listJournals.journalQuitime"/>
							</s:text>
						</s:else>
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
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
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
     var userId = $("#userId")[0].value;
     var userName = $("#userName")[0].value;
     var journalLoginip = $("#journalLoginip")[0].value;
     var journalLogintime = $("#journalLogintime")[0].value;
     var journalQuitime = $("#journalQuitime")[0].value;
	  location="ListSelectedJournal?page="+pageclickednumber+"&userId="+userId+"&userName="+userName+"&journalLoginip="+journalLoginip+"&journalLogintime="+journalLogintime+"&journalQuitime="+journalQuitime;
	}

function query()
{
    $("#pages")[0].value = 1;
	document.queyForm.action="<%=basePath%>ListSelectedJournal";
	document.queyForm.submit();
}       
       
      
    </script>
</body>

</html>
