<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>分派评审专家</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<link href="<%=path%>/style/site.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/style/sexybutton.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=path%>/style/jquery.datepick.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=path%>/js/themes/icon.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript"></script>

		<script language="JavaScript">
	function save() {
		destList = window.document.getElementById("proForm").destList;
		var expertString = "";
		for ( var i = 0; i < destList.length; i++) {
			if (i == destList.length - 1) {
				expertString += destList.options[i].text;
			} else {
				expertString += destList.options[i].text + ",";
			}
		}
		var dataForm = $('#proForm').serialize() + "&experts=" + expertString;

		alert("aaa");
		jQuery.ajax({
			url : 'AssignExpert',
			data : dataForm,
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			type : "POST",
			success : function(r) {
				alert("dd");
				location="index.jsp";
			}
		});
		return false;
	};
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
		if (sortitems)
			SortD(tbox);
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
		if (sortitems)
			SortD(tbox);
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
	function check() {
		var all = document.getElementById("ALL");
		if (all.checked == true) {
			checkAll();
		} else {
			uncheckAll();
		}
	}
	function checkAll() {
		var code_Values = document.getElementsByTagName("input");
		for ( var i = 0; i < code_Values.length; i++) {
			if (code_Values[i].type == "checkbox") {
				code_Values[i].checked = true;
			}
		}
	}
	function uncheckAll() {
		var code_Values = document.getElementsByTagName("input");
		for ( var i = 0; i < code_Values.length; i++) {
			if (code_Values[i].type == "checkbox") {
				code_Values[i].checked = false;
			}
		}
	}
</script>
		<style type="text/css">
.doubleselect br {
	display: none;
}
</style>
	</head>

	<body>
		<div id="main" class="wrapper clearfix">
			<p style="text-align: center;">
				<span
					style="font-family: Arial; font-size: 14px; font-weight: bold; font-style: normal; text-decoration: none; color: #000000;">分派专家</span>
			</p>
			<div id="query" class="doubleselect">
				<s:form action="QueryDeclaAssignExp" theme="simple" method="post" name="queyForm">
					<table width="100%">
						<tr>
							<td>请选择年份和期次:
								<s:doubleselect name="jqYear" list="jieQiYears"
									listKey="yearKey" listValue="yearValue"
									doubleList="qicis.get(top.yearKey)" doubleName="qici"
									doubleListKey="jqId" doubleListValue="qici" />
							</td>
							<td>
								项目编号:
								<input type="text" name="proSerial" />
							</td>
							<td>
								项目名称:
								<input type="text" name="proName" />
							</td>
							<td>
								专业:
								<s:select list="professions" name="profession" headerKey=""
									headerValue="所有" listKey="professionName"
									listValue="professionName"></s:select>
							</td>
							</tr>
							<tr>
							<td>
								学号:
								<input type="text" name="studentNumber" />
							</td>
							<td>
								分派状态:
								<select name="checkState" id="checkState">
									<option value="03">
										已分派
									</option>
									<option value="02">
										待分派
									</option>
								</select>
							</td>
							<td>
								<input type="submit" value="查询" />
							</td>
						</tr>
					</table>
				</s:form>
				<s:form action="" name="proForm" id="proForm" theme="simple">
					<table width="100%">
						<thead>
							<tr>
								<td width="20" align="center">
									<input type="checkbox" name="ALL" id="ALL" onClick="check()"
										value="on "/>
								</td>
								<td width="65" align="center">
									项目 编号
								</td>
								<td width="65" align="center">
									项目名称
								</td>
								<td width="65" align="center">
									申报人
								</td>
								<td width="65" align="center">
									学号
								</td>
								<td width="65" align="center">
									专业
								</td>
								<td width="65" align="center">
									申请日期
								</td>
								<td width="65" align="center">
									分派状态
								</td>
							</tr>
						</thead>
						<s:iterator value="declarations" id="declarations">
							<tr>
								<td width="20" align="center">
									<input type="checkbox" name="checkProjects"
										value='<s:property value="%{#declarations.declarId}"/>' />
								</td>
								<td width="65" align="center">
									<s:property value="#declarations.proSerial" />
								</td>
								<td width="65" align="center">
									<s:property value="#declarations.proName" />
								</td>
								<td width="65" align="center">
									<s:property
										value="#declarations.TStudentByLeaderCode.studentName" />
								</td>
								<td width="65" align="center">
									<s:property
										value="#declarations.TStudentByLeaderCode.studentNumber" />
								</td>
								<td width="65" align="center">
									<s:property
										value="#declarations.TStudentByLeaderCode.TProfession.professionName" />
								</td>
								<td width="65" align="center">
									<s:property value="#declarations.declTime" />
								</td>
								<td width="65" align="center">
									<s:if test="#declarations.checkState=='03'">
											已分派
								  		</s:if>
									<s:elseif test="#declarations.checkState=='02'">
						         			待分派
						          		</s:elseif>
								</td>
							</tr>
						</s:iterator>
						<tr>
							<s:url id="firstPage" action="PreAssignExpert">
								<s:param name="page" value="1"></s:param>
							</s:url>
							<s:url id="url_pre" action="PreAssignExpert">
								<s:param name="page" value="page-1"></s:param>
							</s:url>
							<s:url id="url_next" action="PreAssignExpert">
								<s:param name="page" value="page+1"></s:param>
							</s:url>
							<s:url id="lastPage" action="PreAssignExpert">
								<s:param name="page" value="totalPage"></s:param>
							</s:url>
							<table>
								<tr>
									<td>
										共有
										<s:property value="totalNumber" />
										个记录
										<s:if test="page != 1">
											<s:a href="%{firstPage}" label="首页">
													首页
												</s:a>
										</s:if>
										<s:else>
											<s:label>

											</s:label>
										</s:else>

										&nbsp;
										<s:if test="page != 1">
											<s:a href="%{url_pre}" label="上一页">
													上一页
												</s:a>
										</s:if>
										<s:else>
											<s:label>

											</s:label>
										</s:else>
										&nbsp;
										<s:if test="page != totalPage">
											<s:a href="%{url_next}" label="下一页">
													下一页
												</s:a>
										</s:if>
										<s:else>
											<s:label>

											</s:label>
										</s:else>
										&nbsp;
										<s:if test="page != totalPage">
											<s:a href="%{lastPage}" label="尾页">
													尾页
												</s:a>
										</s:if>
										<s:else>
											<s:label>

											</s:label>
										</s:else>

										&nbsp; 共
										<s:property value="totalPage" />
										页 这是第
										<s:property value="page" />
										页
									</td>
								</tr>
							</table>
						</tr>
					</table>




					<table bgcolor="#FFFFCC" width="100%">
						<thead>
							<tr>
								<td align="left">
									专家团队：
								</td>
								<td align="center">
								</td>
								<td align="left">
									专家分派：
								</td>
							</tr>
						</thead>
						<tr>
							<td bgcolor="#FFFFCC">
								<select name="srcList" style="width: 400px" multiple
									ondblclick="move(this.form.srcList,this.form.destList)">
									<s:iterator value="expertTeachers" id="expertTeachers">
										<option>
											<s:property value="#expertTeachers.TTeacher.teaName+'--'" />
											<s:property value="#expertTeachers.TTeacher.teaCode+'--'" />
											<s:property value="#expertTeachers.TTeacher.teaTitle" />
										</option>
									</s:iterator>
								</select>
							</td>
							<td>
								<table>
									<tr>
										<td>
											<input type="button" value="   >   "
												onclick="move(this.form.srcList,this.form.destList)"
												name="B1">
										</td>
									</tr>
									<tr>
										<td>
											<input type="button" value="   <   " 
												onClick="move(this.form.destList,this.form.srcList)"
												name="B2">
										</td>
									</tr>
									<tr>
										<td>

											<input type="button" value="   >>   "
												onclick="moveall(this.form.srcList,this.form.destList)"
												name="B3">
										</td>
									</tr>
									<tr>
										<td>
											<input type="button" value="   <<   "
												
												onclick="moveall(this.form.destList,this.form.srcList)"
												name="B4">
										</td>
									</tr>

								</table>
							</td>
							<td bgcolor="#FFFFCC">
								<select name="destList" style="width: 400px" multiple
									ondblclick="move(this.form.destList,this.form.srcList)">
								</select>
							</td>
						</tr>
					</table>
					<span><input type="button" value="分派" onclick="save()">
						<input type="button" value=取消"> </span>
				</s:form>
			</div>
		</div>
	</body>
</html>
