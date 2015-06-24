<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>查看申报</title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>
<style type="text/css">
  .Left_z{
    height: 1010px;
  }
</style>
</head>
<body>
<div id="container">
 
  <jsp:include page="../../header.jsp"></jsp:include>
  <!--  此处显示 id "maincontent" 的内容-->
  <div id="maincontent" class="h645" style="height: auto;">
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

        <td width="88%" valign="top"  style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc" bordercolor="#f4f3f1"  style="display:block;height: auto;" >
		<div class="midbox" style="height: auto;">
		<div class="midbox_gg">
		<div class="xmsb">项目申报表</div>
	    </div>
		<div class="xmsb_shang" style="height:inherit;">
		
		<div class="xia_gg">
		

<table>
		<tr>
		<td align="right">项目名称：</td>
		<td>
		<s:property value="declaration.proName" />
		</td>
	    </tr>
		
		<tr>
		<td align="right">项目所属学院：</td>
		<td>
		<s:property value="declaration.TUnit.unitName" />
		</td>
	    </tr>
		
		<tr>
		<td align="right">项目开展所在实验室：</td>
		<td>
         <s:if test="declaration.labLevel=='01'">校级实验室</s:if> 
		 <s:elseif test="declaration.labLevel=='02'">院级实验室</s:elseif>
		 <s:elseif test="declaration.labLevel=='03'">其他实验室</s:elseif>	
		 <s:else> 错误代码</s:else>
        </td>
       </tr>
       
       <tr>
         <td align="right">实验室名称：</td>
         <td>
         <s:property value="declaration.labName" />
         </td>
       </tr>
      <tr>
         <td align="right">项目组人数：</td>
         <td>
         <s:property value="declaration.memberAmount" />人
	     </td>
	  </tr>
      
      <tr>
         <td align="right">项目实施时间：</td>
         <td>
         <s:date  name="declaration.startOn" format="yyyy-MM-dd"/>&nbsp至
				<s:date name="declaration.endOn" format="yyyy-MM-dd"/>
      	 </td>
      </tr>
      
      <tr>
		<td align="right">项目所需经费：</td>
		<td>
		<s:property value="declaration.proFund" />&nbsp;&nbsp;元
      </td>
      </tr>

	  <tr>
         <td align="right">项目类型：</td>  
         <td>
	        <s:if test="declaration.proType=='01'">基础研究类</s:if> 
			<s:elseif test="declaration.proType=='02'">工程类</s:elseif>
			<s:else> 错误代码</s:else>
		</td>

     </tr>
</table>

</div>
<div class="lb_biaoge">
<div class="sblb_biaoge" style="margin-left:35px">
<p id="xmcy">项目组成员（含申请项目成员信息）：


 <table width="100%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="left" >
                                                                                                   
                      <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                        <td style="padding-left:10px" bgcolor="#FFFFFF" width="6%" class="NoNewline">|姓名</td>
                        <td bgcolor="#FFFFFF" width="8%"> |学号 </td>
                        <td bgcolor="#FFFFFF" width="10%"> |学院 </td>
						<td bgcolor="#FFFFFF" width="10%"> |联系电话 </td>
						<td bgcolor="#FFFFFF" width="10%"> |邮箱</td>
						 </tr>
			<s:if test="%{declaration.TStudentByLeaderCode != null}">
		     <tr style="line-height:30px; border-bottom:1px solid #dcdcdc; background-color: #eef7ff">
		       <td>&nbsp;<s:property value="declaration.TStudentByLeaderCode.studentName" /></td>
		       <td><s:property value="declaration.TStudentByLeaderCode.studentNumber" /></td>
		       <td><s:property value="declaration.TStudentByLeaderCode.TUnit.unitName" /></td>
		       <td><s:property value="declaration.TStudentByLeaderCode.studentTelphone" /></td>
		       <td><s:property value="declaration.TStudentByLeaderCode.studentEmail" /></td>
		     </tr>
		   </s:if>
		   <s:if test="%{declaration.TStudentByMember1Code != null}">
		     <tr style="line-height:30px; border-bottom:1px solid #dcdcdc; background-color: #FFFFFF">
		       <td>&nbsp;<s:property value="declaration.TStudentByMember1Code.studentName" /></td>
		       <td><s:property value="declaration.TStudentByMember1Code.studentNumber" /></td>
		       <td><s:property value="declaration.TStudentByMember1Code.TUnit.unitName" /></td>
		       <td><s:property value="declaration.TStudentByMember1Code.studentTelphone" /></td>
		       <td><s:property value="declaration.TStudentByMember1Code.studentEmail" /></td>
		     </tr>
		   </s:if>
		   <s:if test="%{declaration.TStudentByMember2Code != null}">
		     <tr style="line-height:30px; border-bottom:1px solid #dcdcdc; background-color: #eef7ff">
		       <td>&nbsp;<s:property value="declaration.TStudentByMember2Code.studentName" /></td>
		       <td><s:property value="declaration.TStudentByMember2Code.studentNumber" /></td>
		       <td><s:property value="declaration.TStudentByMember2Code.TUnit.unitName" /></td>
		       <td><s:property value="declaration.TStudentByMember2Code.studentTelphone" /></td>
		       <td><s:property value="declaration.TStudentByMember2Code.studentEmail" /></td>
		     </tr>
		   </s:if>
						   
                </table>
				</div>
				
				
				<div class="sblb_biaoge2">
<p id="xmcy2">指导教师：


 <table width="100%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="left" >
                                                                                                   
                      <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                        <td style="padding-left:10px" bgcolor="#FFFFFF" width="6%" class="NoNewline">|姓名</td>
                        <td bgcolor="#FFFFFF" width="8%"> |职称 </td>
                        <td bgcolor="#FFFFFF" width="9%"> |学院 </td>
						<td bgcolor="#FFFFFF" width="10%"> |联系电话 </td>
						<td bgcolor="#FFFFFF" width="10%"> |邮箱</td>
						 </tr>
						 
			<s:if test="%{declaration.TTeacherByTeacher1Code != null}">
		     <tr style="line-height:30px; border-bottom:1px solid #dcdcdc; background-color: #eef7ff">
		       <td>&nbsp;<s:property value="declaration.TTeacherByTeacher1Code.teaName" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher1Code.teaCode" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher1Code.TUnit.unitName" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher1Code.teaTele" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher1Code.teaEmail" /></td>
		     </tr>
		   </s:if>
		   <s:if test="%{declaration.TTeacherByTeacher2Code != null}">
		     <tr style="line-height:30px; border-bottom:1px solid #dcdcdc; background-color: #FFFFFF">
		       <td>&nbsp;<s:property value="declaration.TTeacherByTeacher2Code.teaName" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher2Code.teaCode" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher2Code.TUnit.unitName" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher2Code.teaTele" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher2Code.teaEmail" /></td>
		     </tr>
		   </s:if>
						  
                </table>
				</div>
				</div>
				
<div class="xmjj_wbk">
<h4>
<label for="name">项目简介：</label>
</h4>
<div style="overflow-y:auto;width:699px;height:90px;">
                &nbsp;&nbsp;<s:property value="declaration.proIntro" />
              </div>


</div>
<div class="xmjj_wbk">
<h4>
<label for="name">项目附件：</label>
</h4>
<p><s:iterator value="attachments" id="attachment"><a style="color:blue" href="downLoadAttachment?attachementId=<s:property value="attaId" />"><s:property value="fileName" /></a>&nbsp;&nbsp;</s:iterator></p>
</div>

		
		<dl class="artTabs" style="width:700px;margin-left: 35px"> 
              <dt id="tabs"><a href="#tabContent1" class="select">研究内容</a> <a href="#tabContent2">立项意义</a> <a href="#tabContent3">研究方案</a> <a href="#tabContent4">创新点</a> <a href="#tabContent5">具备的研究条件</a> <a href="#tabContent6">进度安排</a> <a href="#tabContent7">预期研究目标</a><a href="#tabContent8">预期提交成果</a></dt> 
              <dd id="tabContent1" style="display:block">
              <div style="overflow-y:scroll;width:699px;height:90px;">
                &nbsp;&nbsp;<s:property value="declaration.resContent" />
              </div>
               </dd> 
              <dd id="tabContent2" style="display:none">
              <div style="overflow-y:scroll;width:699px;height:90px;">
                &nbsp;&nbsp;<s:property value="declaration.proAdv" />
               </div>
                </dd> 
              <dd id="tabContent3" style="display:none">
              <div style="overflow-y:scroll;width:699px;height:90px;">
                &nbsp;&nbsp;<s:property value="declaration.resProgram" />
                </div>
                </dd> 
              <dd id="tabContent4" style="display:none">
              <div style="overflow-y:scroll;width:699px;height:90px;">
                &nbsp;&nbsp;<s:property value="declaration.innoPoint" />
                </div>
                </dd> 
              <dd id="tabContent5" style="display:none">
              <div style="overflow-y:scroll;width:699px;height:90px;">
                &nbsp;&nbsp;<s:property value="declaration.resCondition" />
                </div>
                </dd>
              <dd id="tabContent6" style="display:none">
              <div style="overflow-y:scroll;width:699px;height:90px;">
                &nbsp;&nbsp;<s:property value="declaration.proPlan" />
                </div>
                </dd>
              <dd id="tabContent7" style="display:none">
              <div style="overflow-y:scroll;width:699px;height:90px;">
                &nbsp;&nbsp;<s:property value="declaration.expTarget" />
                </div>
                </dd>
              <dd id="tabContent8" style="display:none">
              <div style="overflow-y:scroll;width:699px;height:90px;">
                &nbsp;&nbsp;<s:property value="declaration.expResult" />
                </div>
                </dd>
          </dl> 
		
<div class="sblb_biaoge" style="margin-left:35px">
<p id="xmcy">项目成员分工：
</p>
 <table width="100%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="left" >
                                                                                                   
                      <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                        <td style="padding-left:10px" bgcolor="#FFFFFF" width="6%" class="NoNewline">|姓名</td>
						<td bgcolor="#FFFFFF" width="10%"> |项目分工 </td>
						
						 </tr>
			
			
		<s:iterator value="listTDeclJob" id="listTDeclJob" status="stuts">
		   <s:if test="#stuts.odd == true">
					  	<tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
    				  </s:if>
    				  <!--判断记号是否为偶数 -->
   					  <s:else>
      				 	<tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
    				  </s:else>   
		       <td>&nbsp;<s:property value="TStudent.studentName" /></td>
		       <td><s:property value="jobContent" /></td>
		     </tr>
		  
		 </s:iterator>				   
                </table>
				</div>
		
<div class="sblb_biaoge2">
<p id="xmcy">经费预算：
</p>
 <table width="100%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="left" >
                                                                                                   
                      <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                        <td bgcolor="#FFFFFF" width="8%"> |序号 </td>
                        <td bgcolor="#FFFFFF" width="10%"> |开支内容 </td>
						<td bgcolor="#FFFFFF" width="10%"> |金额(单位：元) </td>
						
						 </tr>
			
			
		<s:iterator value="listTDeclFund" id="listTDeclFund" status="stuts">
		   <s:if test="#stuts.odd == true">
					  	<tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
    				  </s:if>
    				  <!--判断记号是否为偶数 -->
   					  <s:else>
      				 	<tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
    				  </s:else>   
		       <td>&nbsp<s:property value="serialNum" /></td>
		       <td><s:property value="fundContent" /></td>
		       <td><s:property value="amount" /></td>
		     </tr>
		  
		 </s:iterator>				   
                </table>
				</div>
		<div style="clear:both"></div>
		
		</div>
	  </div>
		</td>
          
        
		
	
	</tr>
	</table>
  </div>
  <jsp:include page="../../footer.jsp"></jsp:include>
</div>
<script type="text/javascript" src="<%=path%>/js/declaration.js"></script>
<script type="text/javascript">
var artTabs = function (bar, config) {
	var gid = function (id) {return document.getElementById(id)};
	
	config = config || {};
	var bar = typeof bar === 'string' ? gid(bar) : bar,
		className = config.className || 'select',
		callback = config.callback || function () {},
		isMouseover = config.isMouseover,
		
		buttons = bar.getElementsByTagName('a'),
		selectButton = buttons[
			config.index ||
			function () {
				var ret = 0;
				for (i = 0; i < buttons.length; i++) {
					if (buttons[i].className === className) ret = i;
				};
				return ret;
			}()
		],
		showContent = gid(selectButton.href.split('#')[1]),
		fn = function (event) {
			event = event || window.event;
			var target = event.target || event.srcElement;
			
			if (target.nodeName.toLowerCase() === 'a') {
				showContent.style.display = 'none';
				showContent = gid(target.href.split('#')[1]);
				showContent.style.display = 'block';
				selectButton.className = '';
				selectButton = target;
				target.className = className;
				target.focus();
				callback(selectButton, showContent);
				return false;
			};
		};
 
	if (isMouseover) bar.onmouseover = fn;
	bar.onclick = fn;// click事件至少能保证手持设备可以使用
};
 
// 给jQuery添加插件
jQuery.fn.artTabs = function (config) {
	return this.each(function () {
		artTabs(this, config);
	});
};
 
 
// 演示代码
jQuery('.artTabs > dt').artTabs();



</script>
</body>
</html>
