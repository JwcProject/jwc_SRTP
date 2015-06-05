<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>创建专家团队</title>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/js/themes/icon.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
.doubleselect br {
	display: none;
}
</style>
		<script language="JavaScript">
	   </script>
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
						<td width="88%" valign="top"
							style="padding-top: 10px; padding-left: 5px;"
							style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
							<div class="midbox" style="height: 750px; margin-bottom: 10px;">
								<s:form action="CreateExpert" method="post"
									name="preCreateExpert" id="jiaoshi">
									<div class="midbox_gg">
										<div class="zjtd">
											创建专家团队
										</div>
									</div>

									<div class="xia_left">
										<ul>
											<li>
												<p class="doubleselect">
													请选择年份和期次：
													<s:doubleselect label="请选择年份和期次" name="year"
														list="allYears" listKey="yearKey" listValue="yearValue"
														doubleList="qicis.get(top.yearKey)" doubleName="qici"
														doubleListKey="jqId" doubleListValue="qici" theme="simple"
														onchange="change();" />
												</p>
											</li>
										</ul>
									</div>

									<%--<div class="xia_right_sq">
										<a href="javascript:void(0);" onclick="listHistoryExp()"><img
												src="images/zhuanjia_anniu3.png" alt="历史专家库" />
										</a>
									</div>

									--%>
									<div class="xia_zhuanjia_cj"
										style="left: 40px; padding-top: 10px; height: 600px;">
										<table id="datagrid"></table>
									</div>
								</s:form>
								<%--<div class="zj_tjjs_cj">
									<s:form theme="simple" id="addTeacher" action="AddTeacher">
										<table width="90%" height="200px" align="left" border="0"
											cellspacing="0" cellpadding="0"
											style="padding-left: 35px; padding-top: 10px">
											<tr>
												<td width="45%" align="left">
													<p>
														教师姓名：

														<input type="text" name="teacherName" id="jsxm"
															datatype="*" sucmsg="验证通过" nullmsg="请输入姓名"
															errormsg="请正确输入" />
													</p>
												</td>
												<td width="45%">
													<p>
														教职工号：
														<input type="text" name="teacherCode" id="jsgh"
															datatype="*" sucmsg="验证通过" nullmsg="请输入教职工号"
															errormsg="请正确输入" onblur="checkTeacher()"/>

													</p>
												</td>
											</tr>

											<tr>
												<td width="45%">
													<p>
														邮箱：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="text" name="teacherEmail" id="yx"
															datatype="e" sucmsg="验证通过" nullmsg="请输入邮箱"
															errormsg="请正确输入" />

													</p>
												</td>
												<td width="45%" align="left">
													<p>
														职称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<select name="teacherTitle" id="teacherTitle">
															<option value="教授">
																教授
															</option>
															<option value="副教授">
																副教授
															</option>
															<option value="讲师">
																讲师
															</option>
															<option value="助教">
																助教
															</option>
														</select>
													</p>

												</td>
											</tr>
											<tr>
												<td width="45%">
													<p>
														年龄：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="text" name="teacherAge" id="nl"
															datatype="n1-3" sucmsg="验证通过" nullmsg="请输入年龄"
															errormsg="请正确输入" />

													</p>
												</td>
												<td width="45%">
													<p>
														性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<s:radio name="teacherSex" list="#{'01':'男','02':'女'}"
															listKey="key" listValue="value" value="'01'"
															theme="simple"></s:radio>
													</p>
												</td>
											</tr>
											<tr>
												<td width="45%">
													<p>
														电话号码：
														<input type="text" name="teacherTele" id="dhhm"
															datatype="phone" sucmsg="验证通过" nullmsg="请输入电话号码"
															errormsg="错误电话号码" />

													</p>
												</td>
												<td width="45%">
													<p>
														简介：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="text" name="teacherIntro" id="jj"
															datatype="*" sucmsg="验证通过" nullmsg="请输入简介"
															errormsg="请正确输入" />

													</p>
												</td>
												
											</tr>
											<tr>
												<td>
													<p>
														备注：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="text" name="teacherRemark" id="bz"
															datatype="*" sucmsg="验证通过" nullmsg="请输入备注"
															errormsg="请正确输入" />

													</p>
												</td>
												<td>
													<p>
														<a href="javascript:void(0);" onclick="addTea()"><img
																src="images/zhuanjia_anniu4.gif" alt="添加" />
														</a><span id="msgdemo"></span>
													</p>
												</td>
											</tr>

										</table>
									</s:form>
								</div>

								--%>
								<%--<div class="xia_anniu_zj">
									<ul>
										<li>
											<a href="javascript:void(0);" onclick="save()"><img
													src="images/zhuanjia_anniu5.png" alt="创建" />
											</a>
										</li>
										<li>
											<a href="javascript:void(0);"><img
													src="images/zhuanjia_anniu6.png" alt="取消" />
											</a>
										</li>

									</ul>
								</div>
							--%>
							</div>
						</td>




					</tr>
				</table>
			</div>
			<jsp:include page="../../footer.jsp"></jsp:include>
			<div id="teacherDlg" class="easyui-dialog"
				style="width: 700px; height: 400px; padding: 10px 40px; top: 250px"
				closed="true" buttons="#tdlg-buttons"
				data-options="iconCls:'icon-save',resizable:true,modal:true">
				<br />
				输入教师姓名:
				<input type="text" id="teacherName" class="easyui-validatebox"
					data-options="required:true" />
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-ok" onclick="searchTeacher()">查询</a>
				<table id="teacherSearcheDatagrid"></table>
			</div>
			<div id="tdlg-buttons">
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-ok" onclick="addExpertTeacher()">添加</a>
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-cancel"
					onclick="javascript:$('#teacherDlg').dialog('close')">取消</a>
			</div>
		</div>
		<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
		<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>  
		<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="<%=path%>/js/Validform_v5.3.2_min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/endproject.js"></script>

		<script type="text/javascript">
		function checkTeacher() {
			var teachCode = $('#jsgh').val();
			if (null != teachCode && '' != teachCode) {
				$.post('checkHasTeacher', {
					"teacherCode" : teachCode
				}, function(data) {
					var obj = JSON.parse(data);
					if (obj.result == 'yes') {
						$.messager.alert('提示', '您输入的教师工号已经存在，请重新输入', 'error');
						$('#jsgh').val('');
						$('#jsgh').focus();
						return;
					}
				});
			}
		}
       var addTeacherForm;
       $(function(){
             addTeacherForm = $("#addTeacher").Validform({
                tiptype:4,
                datatype:{
          			"phone":function(gets,obj,curform,regxp){
          				return /^(13|15|18)\d{9}$/i.test(gets) || /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(gets);
          			}	
          		},
          		callback : function(data) {
    				var name = window.document.getElementsByName("teacherName")[0].value;
    				var code = window.document.getElementsByName("teacherCode")[0].value;
    				var title = window.document.getElementsByName("teacherTitle")[0].value;
    				var destList = window.document.getElementById("jiaoshi").destList;
    				var len = destList.length;
      				destList.options[len] = new Option(name+"--"+code+"--"+title);  
    				alert("添加成功");
    			}
             });
       var jieqi = $(":input[name='qici']").val();      
       userDatagrid = $('#datagrid').datagrid({
		url : 'listExpertTeachers',
		title:'评审专家',
		pagination : true,
		pageSize : 10,
		pageList :[10,20,30],
		fit : true,
		fitColumns : true,
		nowarp : false,
		idField : 'expertTeacherId',
		queryParams:{
		   jieQiId : jieqi
		},
		loadFilter: function(data){
		   if (data.expertTeachers){
		      console.info(data);
			  var r = "{rows:" + JSON.stringify(data.expertTeachers) + ",total:"+data.totalNumber+"}";
			  return eval('(' + r + ')');
		   } else {
			return data;
		   }
	    },
		columns : [ [{
			title : '专家教师ID',
			field : 'expertTeacherId',
			width : 60,
			sortable : true,
			checkbox:true
		},{
			title : '教师姓名',
			field : 'teaName',
			width : 100
		},{
			title : '教师工号',
			field : 'teaCode',
			width : 100
		},{
			title : '所属单位',
			field : 'unitName',
			width : 100
		},{
			title : '职称',
			field : 'teaTitle',
			width : 100
		},{
			title : '届期',
			field : 'year',
			width : 100,
			formatter: function(value,row,index){
				if (row.qici){
					return row.year+"年第"+row.qici+"期";
				} else {
					return value;
				}
			}
		}] ],
		toolbar :[{
			text : '增加',
			iconCls : 'icon-add',
			handler : function(){
			   $('#teacherDlg').dialog('open').dialog('setTitle', '增加评审专家');		   	  
			}
		},'-',{
			text : '删除',
			iconCls : 'icon-remove',
			handler : function(){
				var rows = userDatagrid.datagrid('getSelections');
				if(rows.length > 0){
					$.messager.confirm('请确认','您确定要删除当前所有选择的评审专家吗', function(b){
						if(b){
							var ids = [];
							for(var i= 0; i<rows.length;i++){
								ids.push(rows[i].expertTeacherId);
							}
							$.ajax({
								url : 'deleteExpertTeacher',
								data : {
									ids : ids.join(',')
								},
								dataType : 'json',
								success : function(r){
									userDatagrid.datagrid('load');
				                    userDatagrid.datagrid('unselectAll');
									$.messager.show({
										title:'提示',
										msg : '删除成功！'
								    });
								}
							});	                         
						}
					});
				}else{
					$.messager.alert('提示','请选择要删除的评审专家','warning');
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
			loadFilter : function(data) {
				if (data) {
					var r = "{rows:" + JSON.stringify(data) + "}";
					return eval('(' + r + ')');
				} else {
					return data;
				}
			},
			columns : [ [ {
				title : '教师ID',
				field : 'teaId',
				width : 60,
				sortable : true,
				checkbox : true
			}, {
				title : '姓名',
				field : 'teaName',
				width : 100
			}, {
				title : '教师工号',
				field : 'teaCode',
				width : 100
			}, {
				title : '职称',
				field : 'teaTitle',
				width : 100
			}, {
				title : '学院',
				field : 'TUnit',
				width : 100,
				formatter : function(value, row, index) {
					if (row.TUnit) {
						return row.TUnit.unitName;
					} else {
						return value;
					}
				}
			}, {
				title : '联系电话',
				field : 'teaTele',
				width : 180
			}, {
				title : '邮箱',
				field : 'teaEmail',
				width : 180
			} ] ]
		});
		$("select[name='qici']").change(function() {
			change();
		});
	});
	function addTea() {
		addTeacherForm.ajaxPost();
		return false;
	}
	function searchTeacher() {
		var par = $('#teacherName').val();
		$('#teacherSearcheDatagrid').datagrid('reload', {
			teacherName : par
		});
		$('#teacherSearcheDatagrid').datagrid('unselectAll');
	}
	function add() {
		var rows = teacherSearcheDatagrid.datagrid('getSelections');
		var param ;
		for ( var i = 0; i < rows.length; i++) {
			
			if(i != rows.length-1)
			{
				param += rows[i].teaCode +",";
			}
			else
			{
				param += rows[i].teaCode;
			}
		}	
		$.ajax({
			url : 'addExpertTeacher',
			data : {
				jieQiId : $(":input[name='qici']").val(),
				teaCode : param
			},
			dataType : 'json',
			success : function(r) {
				userDatagrid.datagrid('load');
				userDatagrid.datagrid('unselectAll');
				$.messager.show({
					title : '提示',
					msg : '添加' + JSON.stringify(r) + '成功！'
				});
			}
		});
		
	}
	function addExpertTeacher() {
		var jieqiId = $(":input[name='qici']").val();
		var rows = teacherSearcheDatagrid.datagrid('getSelections');
		var param = "";
		for ( var i = 0; i < rows.length; i++) {
			
			if(i != rows.length-1)
			{
				param += rows[i].teaCode +",";
			}
			else
			{
				param += rows[i].teaCode;
			}
		}	
		$.ajax({
			url : 'addExpertTeacher',
			data : {
				jieQiId : jieqiId,
				teaCode : param
			},
			dataType : 'json',
			success : function(r) {
				userDatagrid.datagrid('load');
				userDatagrid.datagrid('unselectAll');
				$.messager.show({
					title : '提示',
					msg : '添加专家库成功！'
				});
			}
		});
	}
	function change() {
		var queryParams = $('#datagrid').datagrid('options').queryParams;
		var jieqi = $(":input[name='qici']").val();
		queryParams.jieQiId = jieqi;
		$('#datagrid').datagrid('reload');
	}
</script>
	</body>
</html>
