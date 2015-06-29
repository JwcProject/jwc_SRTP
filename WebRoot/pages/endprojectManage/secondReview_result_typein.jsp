<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>二次评审成绩录入</title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet"
			type="text/css" />
<link href="<%=path%>/js/themes/icon.css" rel="stylesheet" type="text/css" />
<style type="text/css">
   .qicis br{
      display: none;
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
		<jsp:include page="../../dean_leader_left.jsp"></jsp:include>	   
        <!--中间区域-->
        <td width="88%" valign="top"  style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc" bordercolor="#f4f3f1"  >
		<div class="midbox" style="height: auto;">
		<div class="midbox_gg">
		<div class="sblb">二次评审成绩录入</div>
	    </div>
	    <s:form action="" name="searchEndProjectForm" id="searchEndProjectForm" method="post">
		<div class="xia_left">
		<ul>
		<li>
		<p class="qicis">年度、期次
			<s:doubleselect name="properties.year" list="allYears"
									listKey="yearKey" listValue="yearValue"
									doubleList="qicis.get(top.yearKey)" doubleName="properties.jieqiId"
									doubleListKey="jqId" doubleListValue="qici" 
									cssClass="select_sq" theme="simple"/>
</p>
</li>
<li>
		<p>学院<s:select cssClass="select_sq" list="colleges" listKey="unitId" listValue="unitName" name="properties.unitId" theme="simple" cssStyle="width:100px;">
		</s:select>
</p>
</li>
<li>
		<p>申报人学号
		<s:textfield name="properties.studentNumber" cssStyle="width: 80px;" theme="simple"/> 
</p>
</li>
<li>
		<p>项目名称
		<s:textfield name="properties.projectName" cssStyle="width: 80px;" theme="simple"/> 
</p>
</li>
<li>
		
		<p>成绩			
			<s:select list='#{"0":"请选择--","01":"优秀","02":"良好","03":"中等","04":"及格","05":"不及格"}'
		  name="properties.endprojectScore" id="properties.endprojectScore" theme="simple"></s:select>
</p></li>
</ul>
		</div>
		
		<div class="xia_right_sq" style="left: 1005px">
		<a href="javascript:void(0);" onclick="searchEndprojects();"><img src="<%=path%>/images/gonggaoweihu_icon1.gif" alt="查询" /></a></div>
		</s:form>
		<div class="xia_list" style="height:300px;">
 <table id="endProjects" width="100%"  border="0" cellspacing="0" cellpadding="0" align="left" >
                      		   
                </table></div> 
        <div class="xia_x_jg" style="margin-top: 10px;">
		<ul>
		<li>成绩录入：</li>
		<li><a  onclick="audit('01');"><img src="images/you.png" alt="优秀" /></a></li>
		<li><a  onclick="audit('02');"><img src="images/liang.png" alt="良好" /></a></li>
		<li><a  onclick="audit('03');"><img src="images/zhong.png" alt="中等" /></a></li>
		<li><a  onclick="audit('04');"><img src="images/jige.png" alt="及格" /></a></li>
		<li><a  onclick="audit('05');"><img src="images/bujige.png" alt="不及格" /></a></li>
		</ul>
		</div>              		
		<div class="xia_list" style="height:300px;margin-top: 10px;">
		   <table id="typeIned"></table>
		</div>
		
		</div>
		</td>
   
	</tr>
	</table>
  </div>
  <jsp:include page="../../footer.jsp"></jsp:include>
</div>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path%>/js/endproject.js"></script>
<script type="text/javascript">
   var jieqi;
   $(document).ready(function() {
       jieqi = $(":input[name='properties.jieqiId']").val();
       
       //$("#Left_menu .menu_body:eq(3)").show();
       endProjectDatagrid = $('#endProjects').datagrid({
		url : 'listSecReviewResultEndPro?typeIned=false',
		title:'二次评审成绩未录入',
		pagination : true,
		pageSize : 10,
		pageList :[10,20,30],
		fit : true,
		fitColumns : true,
		nowarp : false,
		idField : 'endprojectId',
		loadFilter: function(data){
		   if (data.endProjectForDispatch){
		      console.info(data);
			  var r = "{rows:" + JSON.stringify(data.endProjectForDispatch) + ",total:"+data.totalNumber+"}";
			  return eval('(' + r + ')');
		   } else {
			  return data;
		   }
	    },
	    queryParams:{
		   'properties.jieqiId': jieqi
		},
		columns : [ [{
			title : '结题ID',
			field : 'endprojectId',
			width : 60,
			sortable : true,
			checkbox:true
		},{
			title : '项目编号',
			field : 'projectNumber',
			width : 100
		},{
			title : '项目名称',
			field : 'projectName',
			width : 100
		},{
			title : '申报人',
			field : 'studentName',
			width : 100
		},{
			title : '学号',
			field : 'studentNunber',
			width : 100
		},{
			title : '所属学院',
			field : 'unitName',
			width : 100
		},{
			title : '专业',
			field : 'professionName',
			width : 100
		},{
			title : '结题时间',
			field : 'unitTypeinTime',
			width : 100
		},{
			title : '期次',
			field : 'year',
			width : 100,
			formatter : function(value, rowData, rowIndex) {
				return rowData.year+'第'+rowData.qici+'期';
			}
		},{
			title : '成绩',
			field : 'endprojectScore',
			width : 100,
			formatter : function(value, rowData, rowIndex) {
				if(value == '01') return '优秀';
				else if(value == '02') return '良好'; 
				else if(value == '03') return '中等'; 
				else if(value == '04') return '及格'; 
				else if(value == '05') return '不及格'; 
			}
		}] ]
	   });
	   searchEndProjectForm = $('#searchEndProjectForm').form();
	   serializeObject = function(form) {
		var o = {};
		$.each(form.serializeArray(), function(index) {
			if (o[this['name']]) {
				o[this['name']] = o[this['name']] + "," + this['value'];
			} else {
				o[this['name']] = this['value'];
			}
		});
		return o;
	   };
	   typeInedDatagrid = $('#typeIned').datagrid({
		url : 'listSecReviewResultEndPro?typeIned=true',
		title:'二次评审成绩已录入',
		pagination : true,
		pageSize : 10,
		pageList :[10,20,30],
		fit : true,
		fitColumns : true,
		nowarp : false,
		idField : 'endprojectId',
		loadFilter: function(data){
		   if (data.endProjectForDispatch){
		      console.info(data);
			  var r = "{rows:" + JSON.stringify(data.endProjectForDispatch) + ",total:"+data.totalNumber+"}";
			  return eval('(' + r + ')');
		   } else {
			  return data;
		   }
	    },
	    queryParams:{
		   'properties.jieqiId': jieqi
		},
		columns : [ [{
			title : '结题ID',
			field : 'endprojectId',
			width : 60,
			sortable : true,
			checkbox:true
		},{
			title : '项目编号',
			field : 'projectNumber',
			width : 100
		},{
			title : '项目名称',
			field : 'projectName',
			width : 100
		},{
			title : '申报人',
			field : 'studentName',
			width : 100
		},{
			title : '学号',
			field : 'studentNunber',
			width : 100
		},{
			title : '所属学院',
			field : 'unitName',
			width : 100
		},{
			title : '专业',
			field : 'professionName',
			width : 100
		},{
			title : '结题时间',
			field : 'unitTypeinTime',
			width : 100
		},{
			title : '期次',
			field : 'year',
			width : 100,
			formatter : function(value, rowData, rowIndex) {
				return rowData.year+'第'+rowData.qici+'期';
			}
		},{
			title : '成绩',
			field : 'endprojectScore',
			width : 100,
			formatter : function(value, rowData, rowIndex) {
				if(value == '01') return '优秀';
				else if(value == '02') return '良好'; 
				else if(value == '03') return '中等'; 
				else if(value == '04') return '及格'; 
				else if(value == '05') return '不及格'; 
			}
		},{
			title : '二次评审成绩',
			field : 'lastScore',
			width : 100,
			formatter : function(value, rowData, rowIndex) {
				if(value == '01') return '优秀';
				else if(value == '02') return '良好'; 
				else if(value == '03') return '中等'; 
				else if(value == '04') return '及格'; 
				else if(value == '05') return '不及格'; 
			}
		}] ]
	   });
	   searchEndprojects = function(){
	     jieqi = $(":input[name='properties.jieqiId']").val();
		 endProjectDatagrid.datagrid('load',serializeObject(searchEndProjectForm));
		 typeInedDatagrid.datagrid('load',{'properties.jieqiId': jieqi});
	   };
   });
   function audit(score){
       var rows = endProjectDatagrid.datagrid('getSelections');
       if(rows.length > 0){
			$.messager.confirm('请确认','您确定要录入成绩吗？录入后不能修改！', function(b){
			if(b){
				var ids = [];				
				for(var i= 0; i<rows.length;i++){
					ids.push(rows[i].endprojectId);
				}
				$.ajax({
					url : 'secondReviewResultTypeIn',
					data : {
						ids : ids.join(','),
						lastScore:score
					},
					dataType : 'json',
					success : function(r){
						endProjectDatagrid.datagrid('load');
						endProjectDatagrid.datagrid('unselectAll');
						typeInedDatagrid.datagrid('load');
						typeInedDatagrid.datagrid('unselectAll');
					    $.messager.show({
							title:'提示',
							msg : '成绩录入成功！'
						});
					}
				 });
			   }
			   });
		}else{
			$.messager.alert('提示','请选择需要成绩录入的结题','warning');
		}
   }
   
      
</script>
</body>
</html>
