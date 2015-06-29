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
		<script type="text/javascript" charset="utf-8">
	
</script>
		<style type="text/css">
.u103 {
	color: #000000;
	font-family: 'Arial';
	font-size: 13px;
	font-style: normal;
	font-weight: normal;
	height: 25px;
	left: 937px;
	position: absolute;
	text-align: center;
	text-decoration: none;
	top: 65px;
	width: 100px;
}
</style>
		<script language="JavaScript">
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
			url : 'UpdateExpTeacher',
			data : dataForm,
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			type : "POST",
			success : function(){
				location="PreUpdateExpTea";
			}
		});
		return false;
	};

	function addTea(){
		
  		jQuery.ajax({
			url : 'AddTeacher',//没有写
			data : $('#addTeacher').serialize(),
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			type : "POST",
			success : function(r) {
				var name = window.document.getElementById("teacherName").value;
				var code = window.document.getElementById("teacherCode").value;
				var title = window.document.getElementById("teacherTitle").value;
				var destList = window.document.getElementById("jiaoshi").destList;
				var len = destList.length;
  				destList.options[len] = new Option(name+"--"+code+"--"+title);  
				alert("添加成功");
			}
		}); 
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
</script>
	</head>

	<body>
		<div id="main" class="wrapper clearfix">
			<p style="text-align:center;">
				<span style="font-family:Arial;font-size:14px;font-weight:bold;font-style:normal;text-decoration:none;color:#000000;">编辑专家团队</span>
			</p>
			<div id="query">
				<s:form action="CreateExpert" method="post" name="preCreateExpert"
					id="jiaoshi">
					<table width="100%">
						<tr>
							<td>年份：<s:property value="%{expertTeachers[0].TExpertLib.TJieqi.jqYear}" />
							</td>
							<td>
								期次：<s:property value="%{expertTeachers[0].TExpertLib.TJieqi.qici}" />
								<s:hidden name="expLibId" value="%{expertTeachers[0].TExpertLib.libId}" />
							</td>
						</tr>
					</table>


					<table bgcolor="#FFFFCC" width="100%">
						<thead>
							<tr>
								<td align="left">
									学院教师：
								</td>
								<td align="center">
								</td>
								<td align="left">
									评审专家：
								</td>
							</tr>
						</thead>
						<tr>
							<td bgcolor="#FFFFCC">
								<select name="srcList" style="width: 400px" multiple
									ondblclick="move(this.form.srcList,this.form.destList);">
									<s:iterator value="teachers" id="teachers">
										<option>
											<s:property value="#teachers.teaName+'--'" />
											<s:property value="#teachers.teaCode+'--'" />
											<s:property value="#teachers.teaTitle" />
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
											<input type="button"
												value="   <   " 
												
												
												
												onclick="move(this.form.destList,this.form.srcList)"
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
											<input type="button"
												value="   <<   " 
												
												
												
												onclick="moveall(this.form.destList,this.form.srcList)"
												name="B4">
										</td>
									</tr>

								</table>
							</td>
							<td bgcolor="#FFFFCC">
								<select name="destList" style="width: 400px" multiple
									ondblclick="move(this.form.destList,this.form.srcList);">
									<s:iterator value="expertTeachers" id="expertTeachers">
										<option>
											<s:property value="#expertTeachers.TTeacher.teaName+'--'" />
											<s:property value="#expertTeachers.TTeacher.teaCode+'--'" />
											<s:property value="#expertTeachers.TTeacher.teaTitle" />
										</option>
									</s:iterator>
								</select>
							</td>
						</tr>
					</table>
				</s:form>
				<s:form theme="simple" id="addTeacher">
					<div class="con">
						<table class="info-table" cellpadding="0" cellspacing="0
							width="100%">
							<tr>
								<td align="center">
									教师姓名：
								</td>
								<td>
									<s:textfield name="teacherName" id="teacherName" style="width:100%"></s:textfield>
								</td>
								<td align="center">
									教职工号：
								</td>
								<td>
									<s:textfield name="teacherCode" id="teacherCode" style="width:100%"></s:textfield>
								</td>
							</tr>
							<tr>
								<td align="center">
									邮箱：
								</td>
								<td>
									<s:textfield name="teacherEmail" style="width:100%"></s:textfield>
								</td>
								<td align="center">
									职称：
								</td>
								<td>
									<select name="teacherTitle" id="teacherTitle">
										<option value="教授">教授</option>
										<option value="副教授">副教授</option>
										<option value="讲师">讲师</option>
										<option value="助教">助教</option>
									</select>
								</td>
							</tr>
							<tr>
								<td align="center">
									年龄：
								</td>
								<td>
									<s:textfield name="teacherAge" style="width:100%"></s:textfield>
								</td>
								<td align="center">
									性别：
								</td>
								<td>
									<s:radio name="teacherSex" list="#{'01':'男','02':'女'}"></s:radio>
								</td>
							</tr>
							<tr>
								<td align="center">
									简介：
								</td>
								<td>
									<s:textarea name="teacherIntro" style="width:100%"></s:textarea>
								</td>
								<td align="center">
									评价：
								</td>
								<td>
									<s:textarea name="teacherRemark" style="width:100%"></s:textarea>
								</td>
							</tr>
							<tr>
								<td align="center">
									电话号码：
								</td>
								<td>
									<s:textfield name="teacherTele" style="width:100%"></s:textfield>
								</td>
								<td align="center"><input type="button" value="添加" onclick="addTea()"/></td>
							</tr>
						</table>
					</div>
				</s:form>
				<div>
					<span><input type="button" value="保存" onclick="save()" /> <input
							type="button" value="取消" /> </span>
				</div>
			</div>
		</div>
	</body>
</html>
