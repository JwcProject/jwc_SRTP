<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
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

									<div class="xia_zhuanjia_cj"
										style="left: 40px; padding-top: 10px; height: 600px;">
										<table id="datagrid"></table>
									</div>
								</s:form>
							</div>
						</td>




					</tr>
				</table>
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
		<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>

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
