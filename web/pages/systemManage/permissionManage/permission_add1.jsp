<%@ page language="java" pageEncoding="utf-8"%>
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

		<title>添加权限</title>
		<link href="<%=path%>/style/home.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/style/jquery.jgrowl.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=path%>/style/global.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=path%>/style/site.css" rel="stylesheet" type="text/css"/>
		<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet" type="text/css"/>
		<link href="<%=path%>/js/themes/icon.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
		<SCRIPT type="text/javascript" charset="utf-8">
		    $(function() {
		        $('#permissionFatherid').combotree({   
                     url: 'findFatherPermsTree?curFatherPermsId=${permission.permissionFatherid}',                       
                     loadFilter: function(data){   
                         if (data.fathPermsTree){   
                            return data.fathPermsTree;   
                         } else {   
                            return data;   
                         }                      
                     },          
                     checkbox:true,
                     lines:true    
                }); 
		    });
		</SCRIPT>
	</head>

	<body>
		<div id="main" class="wrapper clearfix">
			<s:form action="AddPermission" theme="simple">

				<div class="con-box">
					<div class="con">
						<table cellpadding="0" cellspacing="0" class="info-table"
							width="100%">
							<caption>
								<font color="blue">添加权限</font>
							</caption>
							<tr>
								<td align="center" width="10%">
									权限名
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:textfield name="permission.permissionName"></s:textfield>
								</td>
							</tr>
							<tr>
								<td align="center">
									权限状态
									<font color="red">*</font>
								</td>
								<td>
									<s:radio name="permission.permissionState"
										list="#{'01':'已分配','02':'未分配'}" value="'01'"></s:radio>
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									权限Url
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:textfield name="permission.permissionUrl" id="permissionUrl" />
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									权限层级
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:select  name="permission.permissionLevel" list="#{'0':'0','1':'1','2':'2'}" id="permissionLevel" ></s:select>
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									父权限
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<input  style="width:180px;" id="permissionFatherid" value="${permission.permissionFatherid}" name="permission.permissionFatherid"/>
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									权限描述
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:textarea name="permission.permissionIntroduction" cols="80"
										rows="10"></s:textarea>
								</td>
							</tr>

							<tr align="center">
								<td colspan="2">
									<s:submit value="保存"></s:submit>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</s:form>
		</div>
	</body>
</html>
