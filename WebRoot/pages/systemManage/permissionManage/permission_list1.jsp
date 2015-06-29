<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>权限管理</title>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<link href="<%=path%>/style/site.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/style/sexybutton.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<div id="main" class="wrapper clearfix">
		    <form action="searchPermission" method="post">
		        <table width="100%">
		           <tr>
		              <td>权限名称:<input type="text" name="permission.permissionName" value="${permission.permissionName}"/></td>
		              <td align="center">权限状态:<input type="radio" name="permission.permissionState" value="01"/>激活
		                                           <input type="radio" name="permission.permissionState" value="02"/>关闭</td>
					  <td>权限层级:<input type="text" name="permission.permissionLevel" value="${permission.permissionLevel}"/></td>
					  <td><input type="submit" value="查询"/><input type="reset" value="重置"/></td>
		           </tr>		           
		        </table>
		    </form>
			<s:form action="QueryPermission" theme="simple">
				<div class="con-box">
					<div class="con">
					<a class="sexybutton" style="vertical-align: middle;" href="PreAddPermission"><span><span><em
													class="add">添加</em> </span> </span> </a>
						<table cellpadding="0" cellspacing="0" class="info-table"
							width="100%">
							<thead>
							  <tr>
								<td width="50" align="center">权限名</td>
								<td width="100"  align="center">权限描述</td>
								<td width="65" align="center">权限状态</td>
								<td width="65" align="center">权限层级</td>
								<td width="65" align="center">权限URL</td>
								<td width="65" align="center">父权限</td>
							  </tr>
							</thead>
							<s:iterator value="listPermissions" id="listPermissions">
							  <tr onMouseOver="this.style.backgroundColor='#D0E9ED'" onMouseOut="this.style.backgroundColor=''">
								<td align="center">
									<s:property value="#listPermissions.permissionName" />
								</td>
								<td align="center">
									 <s:if test="%{#listPermissions.permissionIntroduction.length()>10}">
								              <s:property value="%{#listPermissions.permissionIntroduction.substring(0,10)+'...'}" escape="#onlineList.frmTitle"/>
								          </s:if> 
								          <s:else>
								           <s:property value="#listPermissions.permissionIntroduction"/>&nbsp;
								          </s:else>
								</td>
								<td align="center">
									<s:property value="#listPermissions.permissionState" />
								</td>
								<td align="center">
									<s:property value="#listPermissions.permissionLevel" />
								</td>
								<td align="center">
									<s:property value="#listPermissions.permissionUrl" />
								</td>
								<td align="center">
									<s:property value="#listPermissions.permissionFatherid" />
								</td>
								<td align="center">
									<s:a href="ViewPermission?id=%{#listPermissions.permissionId}" target="_blank">查看</s:a>
									<s:a href="PreUpdatePermission?id=%{#listPermissions.permissionId}" target="_blank">编辑</s:a>
									<s:a href="DeletePermission?id=%{#listPermissions.permissionId}" target="_blank">删除</s:a>
								</td>
							  </tr>
							</s:iterator>
							<tr>
								<s:url id="firstPage" action="ListPermission">
									<s:param name="page" value="1"></s:param>
								</s:url>
								<s:url id="url_pre" action="ListPermission">
									<s:param name="page" value="page-1"></s:param>
								</s:url>
								<s:url id="url_next" action="ListPermission">
									<s:param name="page" value="page+1"></s:param>
								</s:url>
								<s:url id="lastPage" action="ListPermission">
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
			</s:form>
		</div>
	</body>
</html>
