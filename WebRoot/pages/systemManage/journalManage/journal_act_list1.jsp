<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户行为管理</title>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<link href="<%=path%>/style/site.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/style/sexybutton.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/style/jquery.datepick.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/js/themes/icon.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
	</head>

	<body>

		<div id="main" class="wrapper clearfix">			
				<div class="con-box">
					<div class="con">
					    <form action="ListSelectedJournalAct"  method="post">
					    <table>
					          <tr>
								<td width="50" align="center">用户id </td>
								<td><input type="text" name="userId"/></td>
								<td width="100"  align="center">操作类型</td>
								<td>
								<select name="journalactType" id="journalactType" >
								                    <option value="">-请选择-</option>
													<option value="增">增加</option>
													<option value="删">删除</option>
													<option value="改">修改</option>
													<option value="查">查询</option>
								</select>
								</td>
								<td width="65" align="center">操作描述</td>
								<td><input type="text" name="journalactIntroduction"/></td>
								<td width="65" align="center">操作时间</td>
								<td><input class="easyui-datebox"  name="time" style="width:150px"/></td>
	
								<td width="65" align="center"> <input type="submit" value="查询"/></td>
							  </tr>
						</table>
						</form>
						<table cellpadding="0" cellspacing="0" class="info-table"
							width="100%">
							<thead>
							  <tr>
								<td width="50" align="center">用户id</td>
								<td width="100"  align="center">用户名</td>
								<td width="65" align="center">登录ip</td>
								<td width="65" align="center">登录时间</td>
								<td width="65" align="center">退出时间</td>
							  </tr>
							</thead>
							<s:iterator value="listJournalActs" id="listJournalActs">
							  <tr onMouseOver="this.style.backgroundColor='#D0E9ED'" onMouseOut="this.style.backgroundColor=''">
								<td align="center">
									<s:property value="#listJournalActs.userId" />
								</td>
								<td align="center">
								    <s:property value="#listJournalActs.TJournal.userName"/>
								</td>
								<td align="center">
									<s:property value="#listJournalActs.TJournal.journalLoginip" />
								</td>
								<td align="center">
									<s:property value="#listJournalActs.TJournal.journalLogintime" />
								</td>
								<td align="center">
									<s:property value="#listJournalActs.TJournal.journalQuitime" />
								</td>
							  </tr>
							</s:iterator>
							<tr>
								<s:url id="firstPage" action="ListJournalAct">
									<s:param name="page" value="1"></s:param>
								</s:url>
								<s:url id="url_pre" action="ListJournalAct">
									<s:param name="page" value="page-1"></s:param>
								</s:url>
								<s:url id="url_next" action="ListJournalAct">
									<s:param name="page" value="page+1"></s:param>
								</s:url>
								<s:url id="lastPage" action="ListJournalAct">
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
