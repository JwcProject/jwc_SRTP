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

    <title>编辑申报</title>
    <link href="<%=path%>/style/declaration_style.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet"
			type="text/css" />
	<link href="<%=path%>/js/themes/icon.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.MultiFile.js"></script>
	<script type="text/javascript">   
    /**$(function(){ 
        $("input[name='a']").change(function() {
		   if($('#otherLib').attr('checked')==false){
		       $('#otherLibRef').hide();
		   }else{
		      $('#otherLibRef').show(); 
		   }
        }); 
    });**/ 
$.extend($.fn.validatebox.defaults.rules, {
	number : {// 验证是否为小数或整数
		validator : function(value) {
			return /^(\d{1,3}(,\d\d\d)*(\.\d{1,3}(,\d\d\d)*)?|\d+(\.\d+))?$/i.test(value);
		},
		message : '请输入数字，并保证格式正确'
	}

});	
var studentNums=[];
$(function(){
    studentNums.push('<s:property value="declaration.TStudentByLeaderCode.studentNumber" />');
    studentNums.push('<s:property value="declaration.TStudentByMember1Code.studentNumber" />');
    studentNums.push('<s:property value="declaration.TStudentByMember2Code.studentNumber" />');
	userDatagrid = $('#datagrid').datagrid({
		url :'',
		fit : true,
		fitColumns : true,
		nowarp : false,
		idField : 'studentId',
		loadFilter: function(data){
		   if (data.students){
		      console.info(data.students);
			  var r = "{rows:" + JSON.stringify(data.students) + "}";
			  return eval('(' + r + ')');
		   } else {
			  return data;
		   }
	    },
		columns : [ [{
			title : '学生ID',
			field : 'studentId',
			width : 60,
			sortable : true,
			checkbox:true
		},{
			title : '学生姓名',
			field : 'studentName',
			width : 100
		},{
			title : '学号',
			field : 'studentNumber',
			width : 100
		},{
			title : '学院',
			field : 'TUnit',
			width : 100,
			formatter: function(value,row,index){
				if (row.TUnit){
					return row.TUnit.unitName;
				} else {
					return value;
				}
			}
		},{
			title : '联系电话',
			field : 'studentTelphone',
			width : 180
		},{
			title : '邮箱',
			field : 'studentEmail',
			width : 180
		}] ],
		toolbar :[{
			text : '增加',
			iconCls : 'icon-add',
			handler : function(){
			   if($('#datagrid').datagrid('getRows').length>=3){
			       $.messager.alert('提示','项目成员只允许3人以内，您可删除再添加进行替换','warning');
			   }else{			       
			       $('#userDlg').dialog('open').dialog('setTitle', '增加成员');	
			   }			   	  
			}
		},'-',{
			text : '删除',
			iconCls : 'icon-remove',
			handler : function(){
				var rows = userDatagrid.datagrid('getSelections');
				if(rows.length > 0){
					$.messager.confirm('请确认','您确定要删除当前所有选择的成员吗', function(b){
						if(b){
							for(var i= 0; i<rows.length;i++){
								studentNums.splice($.inArray(rows[i].studentNumber,studentNums),1);
								//alert(studentNums.length);
								var index = $('#datagrid').datagrid('getRowIndex',rows[i]);
								$('#datagrid').datagrid('deleteRow',index);
							}                            
						}
					});
				}else{
					$.messager.alert('提示','请选择要删除的成员','warning');
				}
			}
		},'-']
	});
	teacherDatagrid = $('#teacherDatagrid').datagrid({
		url :'',
		fit : true,
		fitColumns : true,
		nowarp : false,
		idField : 'teaId',
		columns : [ [{
			title : '教师ID',
			field : 'teaId',
			width : 60,
			sortable : true,
			checkbox:true
		},{ 
			title : '姓名',
			field : 'teaName',
			width : 100
		},{
			title : '职称',
			field : 'teaTitle',
			width : 100
		},{
			title : '学院',
			field : 'TUnit',
			width : 100,
			formatter: function(value,row,index){
				if (row.TUnit){
					return row.TUnit.unitName;
				} else {
					return value;
				}
			}
		},{
			title : '联系电话',
			field : 'teaTele',
			width : 180
		},{
			title : '邮箱',
			field : 'teaEmail',
			width : 180
		}] ],
		toolbar :[{
			text : '增加',
			iconCls : 'icon-add',
			handler : function(){
			   $('#teacherDlg').dialog('open').dialog('setTitle', '增加指导教师');		  
			}
		},'-',{
			text : '删除',
			iconCls : 'icon-remove',
			handler : function(){
				var rows = teacherDatagrid.datagrid('getSelections');
				if(rows.length > 0){
					$.messager.confirm('请确认','您确定要删除当前所有选择的指导老师吗', function(b){
						if(b){
							for(var i= 0; i<rows.length;i++){
								var index = $('#teacherDatagrid').datagrid('getRowIndex',rows[i]);
								$('#teacherDatagrid').datagrid('deleteRow',index);
							} 
						}
					});
				}else{
					$.messager.alert('提示','请选择要删除的成员','warning');
				}
			}
		},'-']
	});
	teacherSearcheDatagrid = $('#teacherSearcheDatagrid').datagrid({
		url :'<%=path%>/findTeachersByName',
		fit : true,
		fitColumns : true,
		nowarp : false,
		idField : 'teaId',
		loadFilter: function(data){
		   if (data.teachers){
		      console.info(data.teachers);
			  var r = "{rows:" + JSON.stringify(data.teachers) + "}";
			  return eval('(' + r + ')');
		   } else {
			return data;
		   }
	    },
		columns : [ [{
			title : '教师ID',
			field : 'teaId',
			width : 60,
			sortable : true,
			checkbox:true
		},{
			title : '姓名',
			field : 'teaName',
			width : 100
		},{
			title : '职称',
			field : 'teaTitle',
			width : 100
		},{
			title : '学院',
			field : 'TUnit',
			width : 100,
			formatter: function(value,row,index){
				if (row.TUnit){
					return row.TUnit.unitName;
				} else {
					return value;
				}
			}
		},{
			title : '联系电话',
			field : 'teaTele',
			width : 180
		},{
			title : '邮箱',
			field : 'teaEmail',
			width : 180
		}] ]
	});
	workDatagrid = $('#workDatagrid').datagrid({
		url :'',
		fit : true,
		fitColumns : true,
		nowarp : false,
		idField : 'studentId',
		columns : [ [{
			title : '学生ID',
			field : 'studentId',
			width : 20,
			hidden:true
		},{
			title : '学生姓名',
			field : 'studentName',
			width : 50			
		},{
			title : '项目分工',
			field : 'studentWork',
			width : 80,
			editor : {
				type : 'validatebox',
				options : {
					required : true
				}
			}
		}] ]
	});
	fundDatagrid = $('#fundDatagrid').datagrid({
		url :'',
		fit : true,
		fitColumns : true,
		nowarp : false,
		idField : 'id',
		columns : [ [{
			title : '序号',
			field : 'id',
			width : 20,
			editor : {
				type : 'validatebox',
				options : {
					required : true
				}
			}
		},{
			title : '开支内容',
			field : 'fundName',
			width : 50,
			editor : {
				type : 'validatebox',
				options : {
					required : true
				}
			}			
		},{
			title : '金额（单位:元）',
			field : 'fundMoney',
			width : 80,
			editor : {
				type : 'validatebox',
				options : {
					required : true
				}
			}
		}] ],
		toolbar :[{
			text : '增加',
			iconCls : 'icon-add',
			handler : function(){
			    $('#fundDatagrid').datagrid('endEdit',0);
			  	$('#fundDatagrid').datagrid('insertRow',{index:0,row:{}});
		        fundDatagrid.datagrid('beginEdit',0);	  
			}
		    },'-',{
			text : '删除',
			iconCls : 'icon-remove',
			handler : function(){
				var rows = fundDatagrid.datagrid('getSelections');
				for(var i= 0; i<rows.length;i++){
					var index = $('#fundDatagrid').datagrid('getRowIndex',rows[i]);
					$('#fundDatagrid').datagrid('deleteRow',index);
				} 
			}
		},'-']
	});
	});
function addUser(){
   var length = studentNums.push($('#studentId').val());
   var par = studentNums.join(",");
   var url = '<%=path%>/findStudentsByNumber';
   //alert(studentNums.length);
   //$('#datagrid').datagrid('reload',{url:url,studentNums:par});
   $('#datagrid').datagrid({url:url, queryParams:{studentNums:par}});   
   $('#userDlg').dialog('close');
}
function searchTeacher(){
    var par = $('#teacherName').val();
    //var queryParams = $('#teacherSearcheDatagrid').datagrid('options').queryParams; 
    //queryParams.teacherName = par;
    //console.info($('#teacherSearcheDatagrid').datagrid('options').queryParams); 
    $('#teacherSearcheDatagrid').datagrid('reload',{teacherName:par});
    $('#teacherSearcheDatagrid').datagrid('unselectAll');
}
function addTeacher(){
    var rows = teacherSearcheDatagrid.datagrid('getSelections');
    console.info(rows);
    for(var i= 0; i<rows.length;i++){
		$('#teacherDatagrid').datagrid('insertRow',{
		    index: 0,
		    row : rows[i]
		});
	}  
    $('#teacherDlg').dialog('close');
}
function addWork(){
    var len = workDatagrid.datagrid('getRows').length;
    for(var it = 0;it < len; it++){
        workDatagrid.datagrid('deleteRow',0);
    }
    var rows = userDatagrid.datagrid('getRows');
    for(var i= 0; i<rows.length;i++){
		$('#workDatagrid').datagrid('insertRow',{
		    index: 0,
		    row : rows[i]
		});
		workDatagrid.datagrid('beginEdit',0);
	} 
}
function UpdateDeclaration(){
   var projectFund = [];
   var groupWork = [];
   var groupCodes = "";
   var teacherCodes = "";
   var fundRows = fundDatagrid.datagrid('getRows');
   for(var i= 0; i<fundRows.length;i++){
       $('#fundDatagrid').datagrid('endEdit',i);
       projectFund.push(fundRows[i].id+":"+fundRows[i].fundName+":"+fundRows[i].fundMoney);
   }
   var workRows = workDatagrid.datagrid('getRows');
   for(var i= 0; i<workRows.length;i++){
       $('#workDatagrid').datagrid('endEdit',i);
       groupWork.push(workRows[i].studentId+":"+workRows[i].studentWork);
   }
   var groupRows = userDatagrid.datagrid('getRows');
   for(var i= 0; i<groupRows.length;i++){
       if(i==0){
           groupCodes += groupRows[i].studentId;
       }else{
           groupCodes += "," + groupRows[i].studentId;
       }
   }
   var teacherRows = teacherDatagrid.datagrid('getRows');
   for(var i= 0; i<teacherRows.length;i++){
       if(i==0){
           teacherCodes += teacherRows[i].teaId;
       }else{
           teacherCodes += "," + teacherRows[i].teaId;
       }
   }
   $('#groupCodes').val(groupCodes);
   $('#teacherCodes').val(teacherCodes);
   $('#groupWork').val(groupWork.join(','));
   $('#projectFund').val(projectFund.join(','));
   //$.messager.progress(); // display the progress bar
   if ($('#declarationForm').form('validate')){  
	   $('#declarationForm').submit();  
   } 
}
</script>
	</head>
<body>
<h1>编辑项目申报</h1>
<div id="content">
    <form id="declarationForm" name="declarationForm" action="UpdateDeclaration" method="post" enctype="multipart/form-data">
    <table>
        <tr>
	       <td class="td_left">项目名称：</td>
		   <td class="td_right">
		   <input type="text" value="<s:property value="declaration.proName" />" name="declaration.proName"
								class="easyui-validatebox" data-options="required:true,validType:'length[1,50]'"/></td>
	    </tr>
		<tr>
	       <td class="td_left">项目开展所在实验室：</td>
		   <td class="td_right">
		       <input type="radio"  name="declaration.labLevel" value="01" <s:if test="declaration.labLevel=='01'">checked</s:if>>校级实验室
			   <input type="radio"  name="declaration.labLevel" value="02" <s:if test="declaration.labLevel=='02'">checked</s:if>>院级实验室
			   <input type="radio"  name="declaration.labLevel" value="03" <s:if test="declaration.labLevel=='03'">checked</s:if>>其他实验室
		   </td>
	    </tr>
		<tr>
	       <td class="td_left">实验室名称：</td>
		   <td class="td_right">
		       <input type="text" value="<s:property value="declaration.labName" />" name="declaration.labName"
								class="easyui-validatebox" data-options="required:true,validType:'length[1,50]'"/>
		   </td>
	    </tr>
		<tr>
	       <td class="td_left">项目组人数：</td>
		   <td class="td_right">
		        <input type="text" name="declaration.memberAmount" value="<s:property value="declaration.memberAmount" />" 
								class="easyui-validatebox"  data-options="required:true,validType:'number'" />		     
		   </td>
	    </tr>
		<tr>
	       <td class="td_left">项目实施时间：</td>
		   <td class="td_right">		      
		        <input name="declaration.startOn" style="height:25px;" type="text" value="<s:date  name="declaration.startOn" format="yyyy-MM-dd"/>"
								class="easyui-datebox" required="required" editable="false"/>&nbsp至
				<input name="declaration.endOn" style="height:25px;" type="text" value="<s:date  name="declaration.endOn" format="yyyy-MM-dd"/>"
								class="easyui-datebox" required="required" editable="false"/>
		   </td>
	    </tr>
		<tr>
	       <td class="td_left">项目所需经费：</td>
		   <td class="td_right"><input type="text" name="declaration.proFund" value="<s:property value="declaration.proFund" />"
								class="easyui-validatebox"  data-options="required:true,validType:'number'" />&nbsp元</td>
	    </tr>
		<tr>
	       <td class="td_left">项目类型：</td>
		   <td class="td_right">
			  <input class="easyui-combobox" style="height:25px;" value="${declaration.proType}" editable="false" required="required" name="declaration.proType" id="declaration.proType"
								data-options="valueField: 'label',textField: 'value',data: [{
			                                    label: '02',
			                                    value: '工程类'
		                                        },{
			                                    label: '01',
			                                    value: '基础研究类'}]" />
		   </td>
	    </tr>
    </table>
	<hr/>
	<div style="height:200px">
	    <p id="group_info">项目组成员（含申请项目成员信息）</p>
		<table id="datagrid">
		<s:if test="%{declaration.TStudentByLeaderCode != null}">
		     <tr>
		       <td><s:property value="declaration.TStudentByLeaderCode.studentId" /></td>
		       <td><s:property value="declaration.TStudentByLeaderCode.studentName" /></td>
		       <td><s:property value="declaration.TStudentByLeaderCode.studentNumber" /></td>
		       <td><s:property value="declaration.TStudentByLeaderCode.TUnit.unitName" /></td>
		       <td><s:property value="declaration.TStudentByLeaderCode.studentTelphone" /></td>
		       <td><s:property value="declaration.TStudentByLeaderCode.studentEmail" /></td>
		     </tr>
		   </s:if>
		   <s:if test="%{declaration.TStudentByMember1Code != null}">
		     <tr>
		       <td><s:property value="declaration.TStudentByMember1Code.studentId" /></td>
		       <td><s:property value="declaration.TStudentByMember1Code.studentName" /></td>
		       <td><s:property value="declaration.TStudentByMember1Code.studentNumber" /></td>
		       <td><s:property value="declaration.TStudentByMember1Code.TUnit.unitName" /></td>
		       <td><s:property value="declaration.TStudentByMember1Code.studentTelphone" /></td>
		       <td><s:property value="declaration.TStudentByMember1Code.studentEmail" /></td>
		     </tr>
		   </s:if>
		   <s:if test="%{declaration.TStudentByMember2Code != null}">
		     <tr>
		       <td><s:property value="declaration.TStudentByMember2Code.studentId" /></td>
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
		<table id="teacherDatagrid">
		<s:if test="%{declaration.TTeacherByTeacher1Code != null}">
		     <tr>
		       <td><s:property value="declaration.TTeacherByTeacher1Code.teaId" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher1Code.teaName" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher1Code.teaCode" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher1Code.TUnit.unitName" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher1Code.teaTele" /></td>
		       <td><s:property value="declaration.TTeacherByTeacher1Code.teaEmail" /></td>
		     </tr>
		   </s:if>
		   <s:if test="%{declaration.TTeacherByTeacher2Code != null}">
		     <tr>
		       <td><s:property value="declaration.TTeacherByTeacher2Code.teaId" /></td>
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
	   <textarea rows="8" cols="50" name="declaration.proIntro" 
	   class="project_info"><s:property value="declaration.proIntro" /></textarea>
	</div>
	<br/>
	<div>
	   <p id="group_info">相关附件:<s:iterator  value="attachments" id="attachment"><a href="downLoadAttachment?attachementId=<s:property value="attaId" />"><s:property value="fileName" /></a>&nbsp;&nbsp;</s:iterator></p>
	   <p id="group_info">修改附件(如需修改，请将所有附件重新上传):<input type="file" name="files" />(只支持doc|docx格式)</p>
	</div>
	<hr/>
	<div style="text-align:left">
	   <p id="group_info">研究内容（300字以上）:</p>
	   <textarea rows="8" cols="50"   name="declaration.resContent" 
	   class="project_info"><s:property value="declaration.resContent" /></textarea>
	</div>
	<div style="text-align:left">
	   <p id="group_info">立项意义（含国内外研究现状300字以上）：</p>
	   <textarea rows="8" cols="50"   name="declaration.proAdv" 
	   class="project_info"><s:property value="declaration.proAdv" /></textarea>
	</div>
	<div style="text-align:left">
	   <p id="group_info">研究路线（或研究方案）：</p>
	   <textarea rows="8" cols="50"   name="declaration.resProgram" 
	   class="project_info"><s:property value="declaration.resProgram" /></textarea>
	</div>
	<div style="text-align:left">
	   <p id="group_info">创新点：</p>
	   <textarea rows="8" cols="50"   name="declaration.innoPoint" 
	   class="project_info"><s:property value="declaration.innoPoint" /></textarea>
	</div>
	<div style="text-align:left">
	   <p id="group_info">具备的研究条件：</p>
	   <textarea rows="8" cols="50"   name="declaration.resCondition" 
	   class="project_info"><s:property value="declaration.resCondition" /></textarea>
	</div>
	<div style="text-align:left">
	   <p id="group_info">进度安排：</p>
	   <textarea rows="8" cols="50"   name="declaration.proPlan" 
	   class="project_info"><s:property value="declaration.proPlan" /></textarea>
	</div>
	<div style="text-align:left">
	   <p id="group_info">预期研究目标：</p>
	   <textarea rows="8" cols="50"   name="declaration.expTarget" 
	   class="project_info"><s:property value="declaration.expTarget" /></textarea>
	</div>
	<div style="text-align:left">
	   <p id="group_info">预期提交成果：</p>
	   <textarea rows="8" cols="50"   name="declaration.expResult" 
	   class="project_info"><s:property value="declaration.expResult" /></textarea>
	</div>
	<hr/>
	<div style="height:200px">
	    <p id="group_info">项目成员分工：<input type="button" onclick="addWork();" value="添加成员分工" /></p>
	    <table id="workDatagrid">
	    <s:iterator value="listTDeclJob" id="listTDeclJob">
			<tr onMouseOver="this.style.backgroundColor='#D0E9ED'" onMouseOut="this.style.backgroundColor=''">
			<td></td>
			<td align="left">
				<s:property value="TStudent.studentName" />
			</td>
			<td align="left"><s:property value="jobContent" /></td>
			   </tr>
		</s:iterator>
		</table>
	</div>
	<div style="height:200px">
	    <p id="group_info">经费预算：</p>
		<table id="fundDatagrid">
		<s:iterator value="listTDeclFund" id="listTDeclFund">
				<tr>
				<td align="left">
					<s:property value="serialNum"/>
				</td>
				<td align="left">
					<s:property value="fundContent"/>
				</td>
				<td align="left">
					<s:property value="amount"/>
				</td>
			    </tr>
		    </s:iterator>
		</table>
	</div>
	<br/>
	<br/>
	<div>
	   <input type="button" onclick="UpdateDeclaration();" value="保存修改"/>
	</div>
	<hr />
	<input type="hidden" id="declaration.declarId" name="declaration.declarId" value="<s:property value="declaration.declarId" />"/> 
	<input type="hidden" id="groupCodes" name="groupCodes"/> 
	<input type="hidden" id="teacherCodes" name="teacherCodes"/> 
	<input type="hidden" id="groupWork" name="groupWork"/> 
	<input type="hidden" id="projectFund" name="projectFund"/> 
	</form>
</div>
<div id="userDlg" class="easyui-dialog"
		style="width: 400px; height: 150px; padding: 10px 40px;top:300px" closed="true"
		buttons="#dlg-buttons" data-options="iconCls:'icon-save',resizable:true,modal:true">
		输入学生学号:<input type="text" id="studentId" class="easyui-validatebox"  data-options="required:true,validType:'number'" />
    </div>
    <div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="addUser()">添加</a> <a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#userDlg').dialog('close')">取消</a>
    </div>
<div id="teacherDlg" class="easyui-dialog"
		style="width: 700px; height: 400px; padding: 10px 40px;top:250px" closed="true"
		buttons="#tdlg-buttons" data-options="iconCls:'icon-save',resizable:true,modal:true">
		<br/>
		输入教师姓名:<input type="text" id="teacherName" class="easyui-validatebox"  data-options="required:true" /><a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="searchTeacher()">查询</a>
		<table id="teacherSearcheDatagrid"></table>
    </div>
    <div id="tdlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="addTeacher()">添加</a> <a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#teacherDlg').dialog('close')">取消</a>
    </div>
    <script type="text/javascript">
			$(function(){
					$("input:file").MultiFile({
				      accept: 'doc|docx',
				      max: 5,
				      STRING: {
				          remove: '删除',
				          selected: 'Selecionado: $file',
				          denied: '不支持该类型文件上传, $ext!',
				          duplicate: '该文件已经选择:\n$file!'
				      }
    				});
    			});
		</script>
</body>
</html>
