<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>我的申报</title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/Pager.css" rel="stylesheet" type="text/css" />
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
<script src="<%=path%>/js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="<%=path%>/js/jquery.pager.js" type="text/javascript"></script>
<script src="<%=path%>/js/iepngfix_tilebg.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
  
  </script>
    
</head>
<body>
<div id="container">
 <jsp:include page="../../header.jsp" ></jsp:include>
  <!--  此处显示 id "maincontent" 的内容-->
  <div id="maincontent" class="h645">
 
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
		<div class="sblb">个人项目申报列表</div>
	    </div>
	   
		
		<s:form action="" theme="simple" id="proForm">
		<div class="xia_list" style="margin-top: 35px">
		
 <table width="96%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="left" >
                                                                                                   
                      <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                        
                        <td bgcolor="#FFFFFF" width="20%"> |项目名称 </td>
                        <td bgcolor="#FFFFFF" width="6%"> |所在学院 </td>
                        <td bgcolor="#FFFFFF" width="6%"> |申报人 </td>
						<td bgcolor="#FFFFFF" width="6%"> |指导老师 </td>
						<td bgcolor="#FFFFFF" width="6%"> |申报日期 </td>
						<td bgcolor="#FFFFFF" width="6%"> |评审结果 </td>
						<td bgcolor="#FFFFFF" width="26%"> |操作</td>                     
						 </tr>
				<s:iterator value="listDeclaration" id="listDeclaration" status="stuts"> 
					<s:if test="#stuts.odd == true">
					  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
    				</s:if>
    				<!--判断记号是否为偶数 -->
   					<s:else>
      				  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
    				</s:else>
                        <td style="padding-left:10px" title="<s:property value='#listDeclaration.proName' />">
                        <s:if test="%{#listDeclaration.proName.length()>20}">
    				    	<s:property value="%{#listDeclaration.proName.substring(0,20)+'...'}" escape="#onlineList.frmTitle"/>
    				    </s:if>
    				    <s:else>
    				    <s:property value="#listDeclaration.proName" />
    				    </s:else>
                        </td>
                        <td ><s:property value="#listDeclaration.TUnit.unitName" />&nbsp; </td>
                        <td ><s:property value="#listDeclaration.TStudentByLeaderCode.studentName" /> </td>
						<td ><s:property value="#listDeclaration.TTeacherByTeacher1Code.teaName" /> </td>
						<td >
						<s:if test="null==#listDeclaration.declTime||#listDeclaration.declTime.isEmpty()">  
						    
						</s:if>
						<s:else>
						    <s:text name="global.format.date">
							<s:param value="#listDeclaration.declTime"/>
							</s:text>
						</s:else>
						</td>
						<td >
						<s:if test="#listDeclaration.reviewResult=='03'">
											已通过
								  		</s:if>
										<s:elseif test="#listDeclaration.reviewResult=='02'">
						         			未通过
						          		</s:elseif>
										<s:elseif test="#listDeclaration.reviewResult=='01'">
						         			待审核
						          		</s:elseif>
						</td>
						<td bgcolor="#eef7ff" >
						
						<s:a href="ViewDeclaration?id=%{#listDeclaration.declarId}">
						<img src="images/shenbiaoliebiao_icon1.gif" alt="查看" />
						</s:a>
						<s:if test="%{#listDeclaration.checkState==01}">
						<s:a href="PreUpdateDeclaration?id=%{#listDeclaration.declarId}">
						<img src="images/gonggaoweihu_icon3.gif" alt="编辑" />
						</s:a>
						<s:a href="DeleteDeclaration?id=%{#listDeclaration.declarId}">
						<img src="images/gonggaoweihu_icon4.gif" alt="删除" />
						</s:a>
						<s:a href="CommitSavedDeclaration?id=%{#listDeclaration.declarId}">
						<img src="images/tj.gif" alt="提交" />
						</s:a>
						</s:if>
						</td>                    
					 </tr>
				</s:iterator>        
						        
		
	           </table>
	          
	           </div>
	           </s:form>
		
		 
		</div>
		</td>
          
        
		
	
	</tr>
	</table>
	
  </div>
  <jsp:include page="../../footer.jsp"></jsp:include>
</div>
<script src="<%=path%>/js/declaration.js" type="text/javascript"></script>

</body>
</html>
