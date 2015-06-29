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
<title>个人申报列表</title>
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
          	<s:if test="%{#session.user.userType == '00'}">
		  		<jsp:include page="../../dean_leader_left.jsp"></jsp:include>
		  	</s:if>
		  	<s:elseif test="%{#session.user.userType == '01'}">
		    	<jsp:include page="../../dean_left.jsp"></jsp:include>
		    </s:elseif>
		    <s:elseif test="%{#session.user.userType == '02'}">
		    	<jsp:include page="../../teacher_leader_left.jsp"></jsp:include>
		    </s:elseif>
		    <s:elseif test="%{#session.user.userType == '03'}">
		   		<jsp:include page="../../teacher_left.jsp"></jsp:include>
		    </s:elseif>
		    <s:elseif test="%{#session.user.userType == '04'}">
		    	<jsp:include page="../../reviewTeacher_left.jsp"></jsp:include>
		    </s:elseif>
		    <s:elseif test="%{#session.user.userType == '05'}">
		   		<jsp:include page="../../commonTeacher_left.jsp"></jsp:include>
		    </s:elseif>
		     <s:elseif test="%{#session.user.userType == '06'}">
		   		<jsp:include page="../../student_left.jsp"></jsp:include>
		    </s:elseif>
		    <s:elseif test="%{#session.user.userType == '07'}">
		    	<jsp:include page="../../student_member_left.jsp"></jsp:include>
		    </s:elseif>
		    <s:elseif test="%{#session.user.userType == '08'}">
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
		<div class="sblb">&nbsp;<s:property value="%{#session.unit.unitName}" />SRTP项目申报列表</div>
	    </div>
									<div class="xia_left">
										<table>
											<tr style="margin-left: -19px">


												

												<td>
													<p>
														项目名称:
														<s:textfield name="proName" id="proName"
															style="width:74px;height:14px" />
													</p>
												</td>

												

												<td>
													<p>
														学号:
														<s:textfield name="studentNums" id="studentNums"
															style="width:70px;height:14px" />
													</p>
												</td>

												
												<td>
													<s:hidden id="pages" name="page" value="%{page}"></s:hidden>

													<s:hidden id="totalPages" name="totalPage"
														value="%{totalPage}"></s:hidden>
												</td>


												<td>
													<div class="xia_right_sq" style="left: 970px">
														<img src="images/gonggaoweihu_icon1.gif" alt="查询"
															onclick="query();" />
														<a onclick="resetValue();" ><img src="images/reset.png" alt="重置" "/></a>
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
						<td bgcolor="#FFFFFF" width="8%"> |专业 </td>
						<td bgcolor="#FFFFFF" width="8%"> |申请日期 </td>
						
						<td bgcolor="#FFFFFF" width="11%"> |操作 </td>                     
						 </tr>
					<s:iterator value="declarations" id="declarations" status="stuts"> 
					<s:if test="#stuts.odd == true">
					  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
    				</s:if>
    				<!--判断记号是否为偶数 -->
   					<s:else>
      				  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
    				</s:else>
                      <!--  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">-->
                        <td style="padding-left:10px" class="NoNewline"><s:property value="#declarations.proSerial" /></td>
                        <td title="<s:property value='#declarations.proName' />">
                        <s:if test="%{#declarations.proName.length()>20}">
    				    	<s:property value="%{#declarations.proName.substring(0,20)+'...'}" escape="#onlineList.frmTitle"/>
    				    </s:if>
    				    <s:else>
    				    <s:property value="#declarations.proName" />
    				    </s:else>
                        </td>
                        <td ><s:property value="#declarations.TStudentByLeaderCode.studentName" /> </td>
						<td ><s:property value="#declarations.TStudentByLeaderCode.studentNumber" /> </td>
						<td ><s:property value="#declarations.TStudentByLeaderCode.TProfession.professionName" /> </td>
						<td >
						<s:if test="null==#declarations.declTime||#declarations.declTime.isEmpty()">  
						    
						</s:if>
						<s:else>
						    <s:text name="global.format.date">
							<s:param value="#declarations.declTime"/>
							</s:text>
						</s:else>
						</td>
						
						<td >
						<s:a href="ViewDeclaration?id=%{#declarations.declarId}" 
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
	 

     
	  location="FindTeaPersonalDeclaration?"+$('#queyForm').serialize();
	}
 
function query()
{
    $("#pages")[0].value = 1;
	document.queyForm.action="<%=basePath%>FindTeaPersonalDeclaration";
	document.queyForm.submit();
}       
      
       
       function resetValue(){
     // alert(0);
      var inputs = document.queyForm.getElementsByTagName('input');
      for(var i in inputs){
          inputs[i].value="";
      }  
      $("#checkState")[0].value = "ALL";
      var r = document.getElementsByName("profession")[0];
      r.options[t.selectedIndex].value = "所有";
      }
  
    </script>
</body>
</html>
