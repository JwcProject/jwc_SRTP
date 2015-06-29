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
		<title>查看专家团队教师</title>
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
		<script type="text/javascript">
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
	</head>

	<body>

		<div id="main" class="wrapper clearfix">
		<p style="text-align: center;">
				<span
					style="font-family: Arial; font-size: 14px; font-weight: bold; font-style: normal; text-decoration: none; color: #000000;">
					<s:property value="jqYear+'年，第'+qici+'期'" />
					专家教师</span>
			</p>
			<s:form action="" method="post" name="addExpert" theme="simple">
				<table width="100%">
					<thead>
						<tr>
							<td>
								教师 编号
							</td>
							<td>
								教师名称
							</td>
							<td>
								性别
							</td>
							<td>
								职称
							</td>
							<td>
								学院
							</td>
							<td>
								邮箱
							</td>
							<td>
								电话号码
							</td>
						</tr>
					</thead>
					<s:iterator value="expertTeachers" id="expertTeachers">
						<tr>
							<td>
								<s:property value="#expertTeachers.TTeacher.teaCode" />
							</td>
							<td>
								<s:property value="#expertTeachers.TTeacher.teaName" />
							</td>
							<td>
								<s:if test="#expertTeachers.TTeacher.teaSex=='01'">
											男
								</s:if>
								<s:elseif test="#expertTeachers.TTeacher.teaSex=='02'">
						         			女
						        </s:elseif>
								<s:else>
						         			未知
						        </s:else>
							</td>
							<td>
								<s:property value="#expertTeachers.TTeacher.teaTitle" />
							</td>
							<td>
								<s:property value="#expertTeachers.TTeacher.TUnit.unitName" />
							</td>
							<td>
								<s:property value="#expertTeachers.TTeacher.teaEmail" />
							</td>
							<td>
								<s:property value="#expertTeachers.TTeacher.teaTele" />
							</td>
						</tr>
					</s:iterator>
				</table>
				<table cellpadding="0" cellspacing="0" class="info-table"
					width="100%">
					<tr>
						<s:url id="firstPage" action="ViewExpTea">
							<s:param name="page" value="1"></s:param>
						</s:url>
						<s:url id="url_pre" action="ViewExpTea">
							<s:param name="page" value="page-1"></s:param>
						</s:url>
						<s:url id="url_next" action="ViewExpTea">
							<s:param name="page" value="page+1"></s:param>
						</s:url>
						<s:url id="lastPage" action="ViewExpTea">
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
			</s:form>
		</div>
	</body>
</html>
