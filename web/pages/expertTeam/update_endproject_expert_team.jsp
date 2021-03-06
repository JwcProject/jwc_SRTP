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
		<title>编辑专家团队</title>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		
		<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
		<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>

		
		<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
.doubleselect br {
	display: none;
}
</style>
		<script language="JavaScript">
	
	function listHistoryExp() {
		location = "ListEndProHistoryExpert";
	}

	function move(fbox, tbox) {
		for ( var i = 0; i < fbox.options.length; i++) {
			if (fbox.options[i].selected && fbox.options[i].value != "") {
				var no = new Option();
				no.value = fbox.options[i].value;
				no.text = fbox.options[i].text;
				tbox.options[tbox.options.length] = no;
				fbox.options[i].value = "";
				fbox.options[i].text = "";
			}
		}
		BumpUp(fbox);
		/*
		if (sortitems)
			SortD(tbox);
		*/
	}

	function moveall(fbox, tbox) {
		for ( var i = 0; i < fbox.options.length; i++) {
			if (fbox.options[i].value != "") {
				var no = new Option();
				no.value = fbox.options[i].value;
				no.text = fbox.options[i].text;
				tbox.options[tbox.options.length] = no;
				fbox.options[i].value = "";
				fbox.options[i].text = "";
			}
		}
		BumpUp(fbox);
		/*
		if (sortitems)
			SortD(tbox);
		*/
	}

	function BumpUp(box) {
		for ( var i = 0; i < box.options.length; i++) {
			if (box.options[i].value == "") {
				for ( var j = i; j < box.options.length - 1; j++) {
					box.options[j].value = box.options[j + 1].value;
					box.options[j].text = box.options[j + 1].text;
				}
				var ln = i;
				break;
			}
		}
		if (ln < box.options.length) {
			box.options.length -= 1;
			BumpUp(box);
		}
	}

	function SortD(box) {
		var temp_opts = new Array();
		var temp = new Object();
		for ( var i = 0; i < box.options.length; i++) {
			temp_opts[i] = box.options[i];
		}

		for ( var x = 0; x < temp_opts.length - 1; x++) {
			for ( var y = (x + 1); y < temp_opts.length; y++) {
				if (temp_opts[x].text > temp_opts[y].text) {
					temp = temp_opts[x].text;
					temp_opts[x].text = temp_opts[y].text;
					temp_opts[y].text = temp;
					temp = temp_opts[x].value;
					temp_opts[x].value = temp_opts[y].value;
					temp_opts[y].value = temp;
				}
			}
		}

		for ( var i = 0; i < box.options.length; i++) {
			box.options[i].value = temp_opts[i].value;
			box.options[i].text = temp_opts[i].text;
		}
	}
</script>
	</head>
	<body>
		<div id="container">


			<jsp:include page="../../header.jsp"></jsp:include>
			<!--  此处显示 id "maincontent" 的内容-->
			<div id="maincontent" class="h645">

				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>

						<!--  左边区域-->


						<jsp:include page="../../teacher_left.jsp"></jsp:include>
						<!--中间区域-->
						<td width="88%" valign="top"
							style="padding-top: 10px; padding-left: 5px;"
							style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
							<div class="midbox">
								<s:form action="" method="post" name="preCreateExpert"
									id="jiaoshi">
									<div class="midbox_gg">
										<div class="zjtd">
											编辑专家团队
										</div>
									</div>

									<div class="xia_left">
										<ul>
											<li>
												<p>
													年份：
													<s:property
														value="%{tExpertLib.TJieqi.jqYear}" />
												</p>
												<p>
													期次: 第
													<s:property
														value="%{tExpertLib.TJieqi.qici}" />
													期
													<s:hidden name="expLibId" id="expLibId"
														value="%{tExpertLib.libId}" />
												</p>
											</li>

										</ul>
									</div>

									<div class="xia_right_sq">
										<a href="javascript:void(0);" onclick="listHistoryExp()"><img
												src="<%=path%>/images/zhuanjia_anniu3.png" alt="历史专家库" />
										</a>
									</div>

									<div class="xia_zhuanjia_cj">
										<div class="xia_zj">
											<p>
												学院教师
											</p>
											<p>
												<select name="srcList" multiple
													style="width: 330px; height: 150px;"
													ondblclick="move(this.form.srcList,this.form.destList);">
													<s:iterator value="teachers" id="teachers">
														<option>
															<s:property value="#teachers.teaName+'--'" />
															<s:property value="#teachers.teaCode+'--'" />
															<s:property value="#teachers.teaTitle" />
														</option>
													</s:iterator>
												</select>
											</p>
										</div>

										<div class="xia_zj_mid_cj">
											<ul>
												<li>
													<a href="javascript:void(0);"
														onclick="move(getElementsByName('preCreateExpert')[0].srcList,getElementsByName('preCreateExpert')[0].destList)"
														name="B1"> <img src="<%=path%>/images/cjzj_anniu1.gif"
															alt="右" height="26" width="80" />
													</a>
												</li>
												<li>
													<a href="javascript:void(0);"
														onclick="move(getElementsByName('preCreateExpert')[0].destList,getElementsByName('preCreateExpert')[0].srcList)"
														name="B2"> <img src="<%=path%>/images/cjzj_anniu2.gif"
															alt="左" height="26" width="80" />
													</a>
												</li>
												<li>
													<a href="javascript:void(0);"
														onclick="moveall(getElementsByName('preCreateExpert')[0].srcList,getElementsByName('preCreateExpert')[0].destList)"
														name="B3"> <img
															src="<%=path%>/images/zhuanjia_anniu1.gif" alt="右"
															height="26" width="80" />
													</a>
												</li>
												<li>
													<a href="javascript:void(0);"
														onclick="moveall(getElementsByName('preCreateExpert')[0].destList,getElementsByName('preCreateExpert')[0].srcList)"
														name="B4"> <img
															src="<%=path%>/images/zhuanjia_anniu2.gif" alt="左"
															height="26" width="80" />
													</a>
												</li>
											</ul>
										</div>
										<div class="xia_zj2">
											<p>
												评审专家
												<select name="destList" style="width: 330px; height: 150px;"
													multiple
													ondblclick="move(this.form.destList,this.form.srcList);">
													<s:iterator value="expertTeachers" id="expertTeachers">
														<option>
															<s:property value="#expertTeachers.TTeacher.teaName+'--'" />
															<s:property value="#expertTeachers.TTeacher.teaCode+'--'" />
															<s:property value="#expertTeachers.TTeacher.teaTitle" />
														</option>
													</s:iterator>
												</select>
											</p>
										</div>
									</div>
								</s:form>
								<div class="zj_tjjs_cj">
									<s:form theme="simple" id="addTeacher">
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
														<input type="text" name="teacherRemark" id="pj"  />

													</p>
												</td>
												<td>
													<p>
														<a href="javascript:void(0);" onclick="addTea()"><img
																src="<%=path%>/images/tianjia.gif" alt="添加" />
														</a>
													</p>
												</td>
											</tr>

										</table>
									</s:form>
								</div>

								<div class="xia_anniu_zj">
									<ul>
										<li>
											<a href="javascript:void(0);" onclick="save()"><img
													src="<%=path%>/images/save1.png" width="103" height="25"
													alt="保存" />
											</a>
										</li>
										<li>
											<a href="javascript:void(0);" onclick="moveall(getElementsByName('preCreateExpert')[0].destList,getElementsByName('preCreateExpert')[0].srcList)"><img
													src="<%=path%>/images/zhuanjia_anniu6.gif" width="103"
													height="25" alt="取消" />
											</a>
										</li>

									</ul>
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
		<script type="text/javascript" src="<%=path%>/js/Validform_v5.3.2_min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/endproject.js"></script>
		<script type="text/javascript">
		
		function save() {
			destList = window.document.getElementById("jiaoshi").destList;
			var expertString = "";
			for ( var i = 0; i < destList.length; i++) {
				if (i == destList.length - 1) {
					expertString += destList.options[i].text;
				} else {
					expertString += destList.options[i].text + ",";
				}
			}
			var dataForm = $('#jiaoshi').serialize() + "&experts=" + expertString;
			jQuery.ajax({
				url : 'UpdateEndProExpTea',
				data : dataForm,
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				type : "POST",
				success : function() {
					showMsg();
					var expLibId = $("#expLibId")[0].value;
					setTimeout("location = 'PreUpdateEndProExpTea?expLibId='"+expLibId, 5000);
					
				}
			});
			return false;
		};
		
		function showMsg() {
			$.messager.show({
				title : '提示消息',
				msg : '专家教师添加成功!',
				timeout : 5000,
				showType : 'slide'
			});
		}
		
		function showSuccess() {
			$.messager.show({
				title : '提示消息',
				msg : '教师信息添加成功!',
				timeout : 5000,
				showType : 'slide'
			});
		}
		function showError() {
			$.messager.show({
				title : '提示消息',
				msg : '教师信息添加失败,请重新添加!',
				timeout : 5000,
				showType : 'slide'
			});
		}
		
		function addTea() {
			$('#addTeacher')
					.form(
							'submit',
							{
								url : 'AddTeacher',
								success : function(result) {
									var obj = JSON.parse(result);
									if (obj.result == 'yes') {
										showSuccess();
										var name = window.document
												.getElementsByName("teacherName")[0].value;
										var code = window.document
												.getElementsByName("teacherCode")[0].value;
										var title = window.document
												.getElementsByName("teacherTitle")[0].value;
										var destList = window.document
												.getElementById("jiaoshi").destList;
										var len = destList.length;
										destList.options[len] = new Option(name
												+ "--" + code + "--" + title);
										document.getElementById("addTeacher")
												.reset();
									} else {
										showError();
									}
								}
							});
		}

		function checkTeacher() {
			var teachCode = $('#jsgh').val();
			if (null != teachCode && '' != teachCode) {

				$.post('checkHasTeacher', {"teacherCode" : teachCode}, function(data) {
					if (data.result == 'yes') {
						$.messager.alert('提示', '您输入的教师工号已经存在，请重新输入', 'error');
						$('#jsgh').val('');
						$('#jsgh').focus();
						return;
					}
				});
			}
		}
	$(function() {
		$("#addTeacher")
				.Validform(
						{
							tiptype : 3,
							datatype : {
								"phone" : function(gets, obj, curform, regxp) {
									/*参数gets是获取到的表单元素值，
									  obj为当前表单元素，
									  curform为当前验证的表单，
									  regxp为内置的一些正则表达式的引用。*/
									return /^(13|15|18)\d{9}$/i.test(gets)
											|| /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i
													.test(gets);
								}
							}
						});
	});
</script>
	</body>
</html>
