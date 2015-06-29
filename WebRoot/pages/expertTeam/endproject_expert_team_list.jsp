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
<title>专家团队</title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/Pager.css" rel="stylesheet" type="text/css" />
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>

</head>
<body>
<div id="container">
  <jsp:include page="../../header.jsp" ></jsp:include>
  <!--  此处显示 id "maincontent" 的内容-->
  <div id="maincontent" class="h645">
  <s:form action="" method="post" name="queyForm"
					theme="simple">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
	  
        <!--  左边区域-->
        
		<jsp:include page="../../teacher_left.jsp"></jsp:include>
        <!--中间区域-->
        <td width="88%" valign="top"  style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc" bordercolor="#f4f3f1"  >
		<div class="midbox">
		<div class="midbox_gg">
		<div class="sblb">&nbsp;<s:property value="%{#session.unit.unitName}" />专家团队列表</div>
	    </div>
		<div class="xia_left">
		<table>
	<ul>
      <li>
       <s:hidden id="pages" name="page" value="%{page}"></s:hidden>
      </li>
      <li>
       <s:hidden id="totalPages" name="totalPage" value="%{totalPage}"></s:hidden>
      </li>
</ul>
</table>
		</div>
		
		<div id="declaraList" class="xia_list" style="margin-top: 25px;">
		 <div style="margin-left: 840px;margin-bottom: 20px">
                <s:a href="PreCreateEndProExpertTeam" ><img src="images/zhuanjia_anniu5.png" alt="创建" /></s:a>
                </div>
 <table width="88%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="left" >
                                                                                                   
                      <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                        <td style="padding-left:10px" bgcolor="#FFFFFF" width="14%" class="NoNewline">|期次</td>
                        <td bgcolor="#FFFFFF" width="10%"> |创建人 </td>
                        <td bgcolor="#FFFFFF" width="10%"> |创建日期</td>
						<td bgcolor="#FFFFFF" width="10%"> |是否分派</td>
						<td bgcolor="#FFFFFF" width="40%"> |操作 </td>                     
						 </tr>
					<s:iterator value="expertLibs" id="expertLibs" status="stuts"> 
					<s:if test="#stuts.odd == true">
					  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
    				</s:if>
    				<!--判断记号是否为偶数 -->
   					<s:else>
      				  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
    				</s:else>
                      <!--  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">-->
                        <td style="padding-left:10px" class="NoNewline"><s:property
									value="#expertLibs.TJieqi.jqYear+'年,第'" />
								<s:property
									value="#expertLibs.TJieqi.qici+'期'" />
						</td>
                        <td ><s:property value="#expertLibs.TTeacher.teaName" />&nbsp;&nbsp; </td>
                        <td >
						<s:if test="null==#expertLibs.creatOn||#expertLibs.creatOn.isEmpty()">  
						    
						</s:if>
						<s:else>
						    &nbsp;<s:text name="global.format.date">
							<s:param value="#expertLibs.creatOn"/>
							</s:text>
						</s:else>
						</td>
						<td ><s:if test="#expertLibs.isAssigned=='01'">
											&nbsp;已分派
								</s:if> 
						        <s:else>
						         			&nbsp;未分派
						        </s:else> 
						 </td>						
						
						<td>
						<s:a href="ViewEndExpTea?expLibId=%{#expertLibs.libId}" >
							<img src="images/shenbiaoliebiao_icon1.gif" alt="查看" />
						</s:a>
						
						<s:a href="PreUpdateEndProExpTea?expLibId=%{#expertLibs.libId}" >
							<img src="images/gonggaoweihu_icon3.gif" alt="编辑" />
						</s:a>
						<s:a href="DeleteExpertLib?expLibId=%{#expertLibs.libId}" >
							<img src="images/gonggaoweihu_icon4.gif" alt="删除" />
						</s:a>
						<s:if test="#expertLibs.isAssigned=='N '">
						<s:a href="PreAssignExpert" >
						<img src="images/assign.png" alt="分派" /></s:a>
						</s:if> 
						</td> 
						                 
					  </tr>
					</s:iterator>	   
						
	                                                                                   
                       
                </table>
               
               
                </div>
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
	<jsp:include page="../../footer.jsp"></jsp:include>
</div>
<script src="<%=path%>/js/jquery.pager.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/js/endproject.js"></script>
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
     
	  location="ListUnitExperTeam?page="+pageclickednumber;
	}
 
  
      
       
    </script>
</body>
</html>
