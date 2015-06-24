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
		<title>专家团队</title>
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
</script>
<style type="text/css">
.u122 {
    color: #000000;
    font-family: 'Arial';
    font-size: 13px;
    font-style: normal;
    font-weight: normal;
    height: 25px;
    left: 962px;
    position: absolute;
    text-align: center;
    text-decoration: none;
    top: 30px;
    width: 61px;
}
</style>
	</head>

	<body>

		<div id="main" class="wrapper clearfix">
			<form action="PreCreateExpert">
			<p style="text-align: center;">
				<span
					style="font-family: Arial; font-size: 14px; font-weight: bold; font-style: normal; text-decoration: none; color: #000000;">专家团队</span>
			</p>
			<input id="u122" class="u122" type="submit" value="添加" style="cursor: pointer;"/>
			</form>
				<s:form action="CreateExpFromHistory" method="post" name="addExpert">
				<table width="100%">
					<thead>
						<tr>
							<td>
								期次
							</td>
							<td>
								创建人
							</td>
							<td>
								创建日期
							</td>
							<td>
								是否分派
							</td>
							<td>
								操作
							</td>
						</tr>
					</thead>
					<s:iterator value="expertLibs" id="expertLibs">
						<tr>
							<td ><s:property
									value="#expertLibs.TJieqi.jqYear+'年,第'" />
								<s:property
									value="#expertLibs.TJieqi.qici+'期'" />
							</td>
							<td>
								<s:property
									value="#expertLibs.TTeacher.teaName" />
							</td>
							<td>
								<s:property
									value="#expertLibs.creatOn" />
							</td>
							<td>
								<s:if test="#expertLibs.isAssigned=='01'">
											已分派
								</s:if> 
						        <s:else>
						         			未分派
						        </s:else>
							</td>
							<td>
									<s:a href="ViewExpTea?expLibId=%{#expertLibs.libId}" >查看</s:a>
									<s:a href="PreUpdateExpTea?expLibId=%{#expertLibs.libId}" >编辑</s:a>
									<s:a href="DeleteExpertLib?expLibId=%{#expertLibs.libId}" >删除</s:a>
									<s:if test="#expertLibs.isAssigned=='N '">
											<s:a href="PreAssignExpert" >分派</s:a>
								    </s:if> 
							</td>
						</tr>
					</s:iterator>
				</table>
				<table cellpadding="0" cellspacing="0" class="info-table"
					width="100%">
					<tr>
						<s:url id="firstPage" action="ListUnitExperTeam">
							<s:param name="page" value="1"></s:param>
						</s:url>
						<s:url id="url_pre" action="ListUnitExperTeam">
							<s:param name="page" value="page-1"></s:param>
						</s:url>
						<s:url id="url_next" action="ListUnitExperTeam">
							<s:param name="page" value="page+1"></s:param>
						</s:url>
						<s:url id="lastPage" action="ListUnitExperTeam">
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
