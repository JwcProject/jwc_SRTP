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
<title>教务处项目列表</title>
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
  <s:form action="" method="post" name="queyForm" id="queyForm"
					theme="simple">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
	  
        <!--  左边区域-->
          <s:if test="null!=#session.user">
          	<s:if test="%{#session.user.userRole == '00'}">
		  		<jsp:include page="../../dean_leader_left.jsp"></jsp:include>
		  	</s:if>
		  	<s:elseif test="%{#session.user.userRole == '01'}">
		    	<jsp:include page="../../dean_left.jsp"></jsp:include>
		    </s:elseif>
		    <s:elseif test="%{#session.user.userRole == '02'}">
		    	<jsp:include page="../../teacher_leader_left.jsp"></jsp:include>
		    </s:elseif>
		    <s:elseif test="%{#session.user.userRole == '03'}">
		   		<jsp:include page="../../teacher_left.jsp"></jsp:include>
		    </s:elseif>
		    <s:elseif test="%{#session.user.userRole == '04'}">
		    	<jsp:include page="../../reviewTeacher_left.jsp"></jsp:include>
		    </s:elseif>
		    <s:elseif test="%{#session.user.userRole == '05'}">
		   		<jsp:include page="../../commonTeacher_left.jsp"></jsp:include>
		    </s:elseif>
		     <s:elseif test="%{#session.user.userRole == '06'}">
		   		<jsp:include page="../../student_left.jsp"></jsp:include>
		    </s:elseif>
		    <s:elseif test="%{#session.user.userRole == '07'}">
		    	<jsp:include page="../../student_member_left.jsp"></jsp:include>
		    </s:elseif>
		    <s:elseif test="%{#session.user.userRole == '08'}">
		   		<jsp:include page="../../student_leader_left.jsp"></jsp:include>
		    </s:elseif>
		   </s:if>
		   <s:else>
		   		<jsp:forward  page="../../login.jsp"></jsp:forward>
		   </s:else>

        <!--中间区域-->
        <td width="88%" valign="top"  style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc" bordercolor="#f4f3f1"  >
		<div class="midbox">
		<div class="midbox_gg">
		<div class="sblb">&nbsp;<s:property value="%{#session.unit.unitName}" />SRTP项目列表</div>
	    </div>
									<div class="xia_left">
										<table>
											<tr style="margin-left: -19px">
<td>
													<div class="douselect">
														<p>
															期次:
															<s:doubleselect name="jqYear" list="jieQiYears"
																id="jqYear" listKey="yearKey" listValue="yearValue"
																doubleList="qicis.get(top.yearKey)" doubleName="jqQici"
																doubleListKey="jqId" doubleListValue="qici"
																cssClass="select_sq" theme="simple" />
														</p>
													</div>
												</td>

												<td>
													<p>
														项目名称:
														<s:textfield name="projectName" id="projectName"
															style="width:98px;height:14px" />
													</p>
												</td>

												<td>
													<p>
														学院名称:
														<s:textfield name="unitName" id="unitName"
															style="width:98px;height:14px" />
													</p>
												</td>

												<td>
													<p>
														学号:
														<s:textfield name="studentNums" id="studentNums"
															style="width:98px;height:14px" />
													</p>
												</td>

												
												<td>
													<s:hidden id="pages" name="page" value="%{page}"></s:hidden>

													<s:hidden id="totalPages" name="totalPage" value="%{totalPage}"></s:hidden>
												</td>


												<td>
													<div class="xia_right_sq" style="left: 900px">
														<img src="<%=path%>/images/gonggaoweihu_icon1.gif" alt="查询"
															onclick="query();" />
														<a onclick="resetValue();" ><img src="<%=path%>/images/reset.png" alt="重置" "/></a>
													</div>
												</td>

												
											</tr>
										</table>
									</div>
									<div id="declaraList" class="xia_list" style="margin-left: 15px;">
 <table width="99%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="left" >
                                                                                                   
                      <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                        <td style="padding-left:10px" bgcolor="#FFFFFF" width="10%" class="NoNewline">|项目编号</td>
                        <td bgcolor="#FFFFFF" width="20%"> |项目名称 </td>
                        <td bgcolor="#FFFFFF" width="8%"> |申报人 </td>
						<td bgcolor="#FFFFFF" width="8%"> |学号 </td>
						<td bgcolor="#FFFFFF" width="8%"> |学院 </td>
						
						<td bgcolor="#FFFFFF" width="11%"> |操作 </td>                     
						 </tr>
					<s:iterator value="projectList" id="projectList" status="stuts"> 
					<s:if test="#stuts.odd == true">
					  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
    				</s:if>
    				<!--判断记号是否为偶数 -->
   					<s:else>
      				  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
    				</s:else>
                      <!--  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">-->
                        <td style="padding-left:10px" class="NoNewline"><s:property value="#projectList.projectNumber" /></td>
                        <td >
                        <s:if test="%{#projectList.projectName.length()>20}">
    				    	<s:property value="%{#projectList.projectName.substring(0,20)+'...'}" escape="#onlineList.frmTitle"/>
    				    </s:if>
    				    <s:else>
    				    <s:property value="#projectList.projectName" />
    				    </s:else>
                        </td>
                        <td ><s:property value="#projectList.TStudentByProjectLeader.studentName" /> </td>
						<td ><s:property value="#projectList.TStudentByProjectLeader.studentNumber" /> </td>
						<td ><s:property value="#projectList.TUnit.unitName" /> </td>
						
						<td >
						<s:a href="ViewDeclaration?id=%{#projectList.TDeclaration.declarId}" 
						     ><img src="images/shenbiaoliebiao_icon1.gif" alt="查看" /></s:a>
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
   <jsp:include page="../../footer.jsp" ></jsp:include>
</div>
<script src="<%=path%>/js/jquery.pager.js" type="text/javascript"></script>
<script src="<%=path%>/js/project.js" type="text/javascript"></script>
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
    
	  location="FindSchoolProject?"+$('#queyForm').serialize();
	}
 
function query()
{
    $("#pages")[0].value = 1;
	document.queyForm.action="<%=basePath%>FindSchoolProject";
	document.queyForm.submit();
}       
      
       
       function resetValue(){
     // alert(0);
      var inputs = document.queyForm.getElementsByTagName('input');
      for(var i in inputs){
          inputs[i].value="";
      }  
     
      
      }
  
    </script>
</body>
</html>
