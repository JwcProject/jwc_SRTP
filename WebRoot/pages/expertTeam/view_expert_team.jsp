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
		<div class="sblb"><s:property value="jqYear+'年，第'+qici+'期'" />
					专家教师</div>
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
      <li>
       <s:hidden id="expLibId" name="expLibId" value="%{expLibId}"></s:hidden>
      </li>
</ul>
</table>
		</div>
		
		<div id="declaraList" class="xia_list" style="margin-top: 25px;">
		 
 <table width="88%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="left" >
                                                                                                   
                      <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                        <td style="padding-left:10px" bgcolor="#FFFFFF" width="14%" class="NoNewline">|教师编号</td>
                        <td bgcolor="#FFFFFF" width="10%"> |教师名称 </td>
                        <td bgcolor="#FFFFFF" width="10%"> |性别</td>
						<td bgcolor="#FFFFFF" width="10%"> |职称</td>
						<td bgcolor="#FFFFFF" width="10%"> |学院 </td> 
						<td bgcolor="#FFFFFF" width="10%"> |邮箱</td>
						<td bgcolor="#FFFFFF" width="10%"> |电话号码 </td>                     
						 </tr>
					<s:iterator value="expertTeachers" id="expertTeachers" status="stuts"> 
					<s:if test="#stuts.odd == true">
					  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
    				</s:if>
    				<!--判断记号是否为偶数 -->
   					<s:else>
      				  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
    				</s:else>
                      <!--  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">-->
                        <td style="padding-left:10px" class="NoNewline"><s:property
									value="#expertTeachers.TTeacher.teaCode" />
								
						</td>
                        <td ><s:property value="#expertTeachers.TTeacher.teaName" />&nbsp;&nbsp; </td>
                        
                        <td>
								<s:if test="#expertTeachers.TTeacher.teaSex=='01'">
											男
								</s:if>
								<s:elseif test="#expertTeachers.TTeacher.teaSex=='02'">
						         			女
						        </s:elseif>
								<s:else>
						         			未知
						        </s:else>
						</td>
                        
						<td>
								<s:property value="#expertTeachers.TTeacher.teaTitle" />
							</td>
							<td>
								<s:property value="#expertTeachers.TTeacher.TUnit.unitName" />
							</td>
							<td>
								<s:property value="#expertTeachers.TTeacher.teaEmail" />
							</td>
							<td>
								<s:property value="#expertTeachers.TTeacher.teaTele" />
							</td>
						                 
					  </tr>
					</s:iterator>	   
						
	                                                                                   
                       
                </table>
               
               
                </div>
		<div class="xia_x">
		<!--  <ul>
		<li><a href="#" ><img src="images/gonggaoweihu_icon5.gif" alt="首页" /></a></li>
		<li><a href="#" ><img src="images/gonggaoweihu_icon6.gif" alt="首页" /></a></li>
		<li><a href="#" ><img src="images/gonggaoweihu_icon7.gif" alt="首页" /></a></li>
		<li><a href="#" ><img src="images/gonggaoweihu_icon8.gif" alt="首页" /></a></li>
		<li><a href="#" ><img src="images/gonggaoweihu_icon9.gif" alt="首页" /></a></li>
		<li><a href="#" ><img src="images/gonggaoweihu_icon10.gif" alt="首页" /></a></li>
		<li><a href="#" ><img src="images/gonggaoweihu_icon11.gif" alt="首页" /></a></li>
		<li><a href="#" ><img src="images/gonggaoweihu_icon12.gif" alt="首页" /></a></li>
		<li><a href="#" ><img src="images/gonggaoweihu_icon13.gif" alt="首页" /></a></li>
		
		</ul>
		-->
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
<script type="text/javascript" src="<%=path%>/js/declaration.js"></script>
<script type="text/javascript" language="javascript">

 // var n = document.getElementById('pages').value;
      // var n = document.getElementsByTagName('s:hidden').value;
     //   alert(n);
        $(document).ready(function() {
            var page = $("#pages")[0].value;
            var totalPage = $("#totalPages")[0].value;
            //var expLibId = $("#expLibId")[0].value;
            //alert(expLibId);
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
     
      var expLibId = $("#expLibId")[0].value;
      
	  location="ViewExpTea?page="+pageclickednumber+"expLibId="+expLibId;
	}
 
       
    </script>
</body>
</html>
