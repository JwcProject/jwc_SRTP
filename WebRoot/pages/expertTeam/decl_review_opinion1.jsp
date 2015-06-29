<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>评审意见</title>
    <link href="<%=path%>/style/declaration_style.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet"
			type="text/css" />
	<link href="<%=path%>/js/themes/icon.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
	    function save(){
	    	if ($('#reviewOpinion').form('validate')){
	    	    $('#reviewOpinion').submit();  
	    	}  
	    }
	</script>
	</head>
<body>
<h1> 评审意见</h1>
<div id="content">
    <table>
        <tr>
	       <td class="td_left">项目名称：</td>
		   <td class="td_right"><s:property value="declaration.proName" /></td>
	    </tr>
		<tr>
	       <td class="td_left">项目开展所在实验室：</td>
		   <td class="td_right">
		       <s:if test="declaration.labLevel=='01'">校级实验室</s:if> 
			   <s:elseif test="declaration.labLevel=='02'">院级实验室</s:elseif>
			   <s:elseif test="declaration.labLevel=='03'">其他实验室</s:elseif>	
			   <s:else> 错误代码</s:else>
		   </td>
	    </tr>
		<tr>
	       <td class="td_left">实验室名称：</td>
		   <td class="td_right"><s:property value="declaration.labName" /></td>
	    </tr>
		<tr>
	       <td class="td_left">项目组人数：</td>
		   <td class="td_right"><s:property value="declaration.memberAmount" /></td>
	    </tr>
		<tr>
	       <td class="td_left">项目实施时间：</td>
		   <td class="td_right">		      
		        <s:property value="declaration.startOn" />&nbsp至
				<s:property value="declaration.endOn" />
		   </td>
	    </tr>
		<tr>
	       <td class="td_left">项目所需经费：</td>
		   <td class="td_right"><s:property value="declaration.proFund" />&nbsp元</td>
	    </tr>
		<tr>
	       <td class="td_left">项目类型：</td>
		   <td class="td_right">
			   <s:if test="declaration.proType=='01'">基础研究类</s:if> 
			   <s:elseif test="declaration.proType=='02'">工程类</s:elseif>
			   <s:else> 错误代码</s:else>
		   </td>
	    </tr>
    </table>
	<hr/>
	<div style="height:200px">
	    <p id="group_info">项目组成员（含申请项目成员信息）</p>
		<table id="user_list">
		   <thead>
		     <td>学生姓名</td>
		     <td>学号</td>
		     <td>学院</td>
		     <td>联系电话</td>
		     <td>邮箱</td>
		   </thead>
		   <s:if test="%{declaration.TStudentByLeaderCode != null}">
		     <tr>
		       <td><s:property value="declaration.TStudentByLeaderCode.studentName" /></td>
		       <td><s:property value="declaration.TStudentByLeaderCode.studentNumber" /></td>
		       <td><s:property value="declaration.TStudentByLeaderCode.TUnit.unitName" /></td>
		       <td><s:property value="declaration.TStudentByLeaderCode.studentTelphone" /></td>
		       <td><s:property value="declaration.TStudentByLeaderCode.studentEmail" /></td>
		     </tr>
		   </s:if>
		   <s:if test="%{declaration.TStudentByMember1Code != null}">
		     <tr>
		       <td><s:property value="declaration.TStudentByMember1Code.studentName" /></td>
		       <td><s:property value="declaration.TStudentByMember1Code.studentNumber" /></td>
		       <td><s:property value="declaration.TStudentByMember1Code.TUnit.unitName" /></td>
		       <td><s:property value="declaration.TStudentByMember1Code.studentTelphone" /></td>
		       <td><s:property value="declaration.TStudentByMember1Code.studentEmail" /></td>
		     </tr>
		   </s:if>
		   <s:if test="%{declaration.TStudentByMember2Code != null}">
		     <tr>
		       <td><s:property value="declaration.TStudentByMember2Code.studentName" /></td>
		       <td><s:property value="declaration.TStudentByMember2Code.studentNumber" /></td>
		       <td><s:property value="declaration.TStudentByMember2Code.TUnit.unitName" /></td>
		       <td><s:property value="declaration.TStudentByMember2Code.studentTelphone" /></td>
		       <td><s:property value="declaration.TStudentByMember2Code.studentEmail" /></td>
		     </tr>
		   </s:if>
		</table>
	</div>
	
	<div style="height:200px">
	    <p id="group_info">指导教师：</p>
		<table id="user_list">
		   <thead>
		     <td>姓名</td>
		     <td>职称</td>
		     <td>学院</td>
		     <td>联系电话</td>
		     <td>邮箱</td>
		   </thead>
		   <s:if test="%{declaration.TTeacherByTeacher1Code != null}">
		     <tr>
		       <td><s:property value="declaration.TTeacherByTeacher1Code.teaName" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher1Code.teaCode" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher1Code.TUnit.unitName" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher1Code.teaTele" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher1Code.teaEmail" /></td>
		     </tr>
		   </s:if>
		   <s:if test="%{declaration.TTeacherByTeacher2Code != null}">
		     <tr>
		       <td><s:property value="declaration.TTeacherByTeacher2Code.teaName" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher2Code.teaCode" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher2Code.TUnit.unitName" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher2Code.teaTele" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher2Code.teaEmail" /></td>
		     </tr>
		   </s:if>
		</table>
	</div>
	<div style="text-align:left">
	   <p id="group_info">项目简介:</p>
	   <textarea rows="8" cols="50" class="project_info" readonly="readonly"><s:property value="declaration.proIntro" /></textarea>
	   </p>
	</div>
	<hr/>
	<div style="text-align:left">
	   <p id="group_info">创新点：</p>
	   <textarea rows="8" cols="50" class="project_info" readonly="readonly"><s:property value="declaration.innoPoint" /></textarea>   
	</div>
	<div style="text-align:left">
	   <p id="group_info">预期提交成果：</p>
	   <textarea rows="8" cols="50"  class="project_info" readonly="readonly"><s:property value="declaration.expResult" /></textarea>
	</div>
	<div>
	   <p id="group_info">相关附件:<a href="downLoadAttachment?declarationId=<s:property value="declaration.declarId" />">查看附件</a></p>
	</div>
	<br/>

	<hr/>
	<form id="reviewOpinion" action="ReviewOpinion" method="post" onsubmit="javascript:return true;">
	<div style="text-align:left">
	  <p id="group_info">评审意见：</p>
   	  <s:hidden name="declarId" value="%{declaration.declarId}"></s:hidden>
	   <textarea rows="8" cols="50" name="opinion"  class="project_info"><s:property value="declaration.reviewOpinion" /></textarea>   
	</div>
	<div>
		<input type="button" value="保存" onclick="save();"/>			
	</div>
	</form>
</div>
</body>
</html>
