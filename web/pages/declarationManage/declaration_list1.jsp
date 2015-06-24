<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>我的申报</title>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<link href="<%=path%>/style/site.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/style/sexybutton.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div id="main" class="wrapper clearfix">
			<div class="con-box">
				<div class="con">
					<table cellpadding="0" cellspacing="0" class="info-table" width="100%">
						<thead>
						    <tr>
							<td width="50" align="center">项目名称</td>
						    <td width="50" align="center">所在学院</td>
							<td width="100"  align="center">申请人</td>
							<td width="65" align="center">指导老师</td>
							<td width="65" align="center">申报日期</td>
							<td width="65" align="center">申报状态</td>
							<td width="65" align="center">操作</td>
							</tr>
						</thead>
						<s:iterator value="listDeclaration" id="listDeclaration">
							<tr onMouseOver="this.style.backgroundColor='#D0E9ED'" onMouseOut="this.style.backgroundColor=''">
							<td align="center">
							    <s:property value="#listDeclaration.proName" />
							</td>
							<td align="center">
								<s:property value="#listDeclaration.TUnit.unitName" />
							</td>
							<td align="center">
								<s:property value="#listDeclaration.TStudentByLeaderCode.studentName" />
							</td>
							<td align="center">
								<s:property value="#listDeclaration.TTeacherByTeacher1Code.teaName" />
							</td>
							<td align="center">
								<s:property value="#listDeclaration.declTime" />
							</td>
							<td>
								<s:if test="#listDeclaration.checkState=='03'">待审核</s:if> 
						        <s:elseif test="#listDeclaration.checkState=='05'">审核已通过</s:elseif>
						        <s:elseif test="#listDeclaration.checkState=='04'">审核未通过</s:elseif>	
						        <s:else> 错误代码</s:else>
							</td>
							<td align="center">
								<s:a href="ViewDeclaration?id=%{#listDeclaration.declarId}" >查看</s:a>
								<s:a href="PreUpdateDeclaration?id=%{#listDeclaration.declarId}" >变更</s:a>
								<s:a href="DeleteDeclaration?id=%{#listDeclaration.declarId}" >删除</s:a>
							</td>
							</tr>
						</s:iterator>
							<tr>
								<s:url id="firstPage" action="ListDeclaration">
									<s:param name="page" value="1"></s:param>
								</s:url>
								<s:url id="url_pre" action="ListDeclaration">
									<s:param name="page" value="page-1"></s:param>
								</s:url>
								<s:url id="url_next" action="ListDeclaration">
									<s:param name="page" value="page+1"></s:param>
								</s:url>
								<s:url id="lastPage" action="ListDeclaration">
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
					</div>
				</div>
		</div>
	</body>
</html>
