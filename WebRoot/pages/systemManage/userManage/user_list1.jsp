<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户管理</title>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<link href="<%=path%>/style/site.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/style/sexybutton.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<div id="main" class="wrapper clearfix">
				<div class="con-box">
					<div class="con">
					<form action="QueryUser"  method="post">
					    <table>
					          <tr>
								<td width="50" align="center">登录名</td>
								<td><s:textfield  name="userId" value="%{userId}"/></td>
								<td width="100"  align="center">昵称</td>
								<td><s:textfield  name="userName" value="%{userName}"/></td>
								<td width="65" align="center">用户类型</td>
								<td><s:select name="userType"
										list="#{'00':'不限','01':'教师','02':'学生','03':'管理员'}" headerKey="00" ></s:select></td>
								<td width="65" align="center">登录状态</td>
								<td><s:select name="userState"
										list="#{'00':'不限','NN':'离线','YY':'在线'}" headerKey="00"  ></s:select></td>
								<td width="65" align="center"> <input type="submit" value="查询"/></td>
							  </tr>
						</table>
						</form>
					<a class="sexybutton" style="vertical-align: middle;" href="PreAddUser"><span><span><em
													class="add">添加</em> </span> </span> </a>
						<table cellpadding="0" cellspacing="0" class="info-table"
							width="100%">
							<thead>
							  <tr>
							  	<td width="50" align="center">登录名</td>
								<td width="50" align="center">昵称</td>
								<td width="100"  align="center">用户简介</td>
								<td width="65" align="center">用户类型</td>
								<td width="65" align="center">登录状态</td>
								<td width="65" align="center">操作</td>
							  </tr>
							</thead>
							<s:iterator value="listUsers" id="listUsers">
							  <tr onMouseOver="this.style.backgroundColor='#D0E9ED'" onMouseOut="this.style.backgroundColor=''">
								<td align="center">
									<s:property value="#listUsers.userId" />
								</td>
								<td align="center">
									<s:property value="#listUsers.userName" />
								</td>
								<td align="center">
									 <s:if test="%{#listUsers.userIntroduction.length()>10}">
								              <s:property value="%{#listUsers.userIntroduction.substring(0,10)+'...'}" escape="#onlineList.frmTitle"/>
								          </s:if> 
								          <s:else>
								           <s:property value="#listUsers.userIntroduction"/>&nbsp;
								          </s:else>
								</td>
								<td align="center">
									<s:if test="%{#listUsers.userType== '01'}">
											教师
								    </s:if> 
								    <s:elseif test="%{#listUsers.userType== '02'}">
								           	学生
								    </s:elseif >
								    <s:elseif test="%{#listUsers.userType== '03'}">
								           	管理员
								    </s:elseif>
								    <s:else>
								           	其他
								    </s:else>
									
								</td>
								<td align="center">
									<s:if test="%{#listUsers.userState == 'NN'}">
											离线
								    </s:if> 
								    <s:elseif test="%{#listUsers.userState == 'YY'}">
								           	在线
								    </s:elseif>
								    <s:else >
								           	异常登录
								    </s:else>
								</td>
								<td align="center">
									<s:a href="ViewUser?id=%{#listUsers.userId}" target="_blank">查看</s:a>
									<s:a href="PreUpdateUser?id=%{#listUsers.userId}" target="_blank">编辑</s:a>
									<s:a href="DeleteUser?id=%{#listUsers.userId}" >删除</s:a>
								</td>
							  </tr>
							</s:iterator>
							<tr>
								<s:url id="firstPage" action="ListUser">
									<s:param name="page" value="1"></s:param>
								</s:url>
								<s:url id="url_pre" action="ListUser">
									<s:param name="page" value="page-1"></s:param>
								</s:url>
								<s:url id="url_next" action="ListUser">
									<s:param name="page" value="page+1"></s:param>
								</s:url>
								<s:url id="lastPage" action="ListUser">
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
