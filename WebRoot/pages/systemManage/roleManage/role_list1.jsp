<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>角色管理</title>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<link href="<%=path%>/style/site.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/style/sexybutton.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<div id="main" class="wrapper clearfix">
			<%-- <s:form theme="simple" action="QueryRole"> --%>
				<div class="con-box">
					<div class="con">
					<a class="sexybutton" style="vertical-align: middle;" href="PreAddRole"><span><span><em
													class="add">添加</em> </span> </span> </a>
						<s:form theme="simple" action="QueryRole">
						<table>
					          <tr>
								<td><s:textfield name="keyword"></s:textfield></td>
								<td width="65" align="center"> <input type="submit" value="查询" /></td>
							  </tr>
						</table>
						</s:form>
						<table cellpadding="0" cellspacing="0" class="info-table"
							width="100%">
							<thead>
							  <tr>
							  	<td style="display:none">角色ID</td>
								<td width="50" align="center">角色名</td>
								<td width="50"  align="center">角色状态</td>
								<td width="100" align="center">角色介绍</td>
								<td width="100" align="center">操作</td>
							  </tr>
							</thead>
							<s:iterator value="listRoles" id="listRoles">
							  <tr onMouseOver="this.style.backgroundColor='#D0E9ED'" onMouseOut="this.style.backgroundColor=''">
								<td style="display:none">
								    <s:property value="#listRoles.roleId" />
								</td>
								<td align="center">
								    <s:property value="#listRoles.roleName" />
								</td>
								<td align="center">
								    <s:property value="#listRoles.roleState" />
								</td>
								<td align="center">
									<s:if test="%{#listRoles.roleIntroduction.length()>10}">
								    	<s:property value="%{#listRoles.roleIntroduction.substring(0,10)+'...'}" escape="#onlineList.frmTitle"/>
								    </s:if> 
								    <s:else>
								    	<s:property value="#listRoles.roleIntroduction"/>&nbsp;
								    </s:else>
								</td>
								<td align="center">
									<s:a href="ViewRole?id=%{#listRoles.roleId}" target="_self">查看</s:a>
									<s:a href="PreUpdateRole?id=%{#listRoles.roleId}" target="_blank">编辑</s:a>
									<s:a href="DeleteRole?id=%{#listRoles.roleId}" target="_blank">删除</s:a>
									<s:a href="PreAssignPermission?id=%{#listRoles.roleId}" target="_blank">权限添加</s:a>
								</td>
							  </tr>
							</s:iterator>
							<tr>
								<s:url id="firstPage" action="ListRole">
									<s:param name="page" value="1"></s:param>
								</s:url>
								<s:url id="url_pre" action="ListRole">
									<s:param name="page" value="page-1"></s:param>
								</s:url>
								<s:url id="url_next" action="ListRole">
									<s:param name="page" value="page+1"></s:param>
								</s:url>
								<s:url id="lastPage" action="ListRole">
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
			<%-- </s:form> --%>
		</div>
	</body>
</html>
