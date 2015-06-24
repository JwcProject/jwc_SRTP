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
		<title>结果审核</title>
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

	</head>

	<body>

		<div id="main" class="wrapper clearfix">
			<p style="text-align:center;">
			<span style="font-family:Arial;font-size:14px;font-weight:bold;font-style:normal;text-decoration:none;color:#000000;">XX学院学生SRTP项目申报审核结果</span>
			</p>
			
				<div id="query" class="doubleselect">
				<s:form action="QueryResultAudit" method="post" name="queyForm" theme="simple">
					<div class="con">
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
								评审结果:
								<select name="checkState" id="checkState">
									<option value="05">
										已通过
									</option>
									<option value="04">
										未通过
									</option>
									<option value="03">
										待审核
									</option>
								</select>
							</td>
							<td>
								<input type="submit" value="查询" />
								<input type="reset" value="重置" />
							</td>
						</tr>
					</table>
				</div>
				</s:form>
			</div>
			
			<s:form action="" theme="simple">
				<div class="con-box">
					<div class="con">
						<table cellpadding="0" cellspacing="0" class="info-table"
							width="100%">
							<thead>
								<tr>
									<td width="20" align="center">
										<input type="checkbox" name="ALL" id="ALL" checked="checked"
											style="display:none"/>
									</td>
									<td width="50" align="center">
										项目编号
									</td>
									<td width="100" align="center">
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
										评审结果
									</td>
									<td width="65" align="center">
										评审意见
									</td>
								</tr>
							</thead>
							<s:iterator value="declarations" id="declarations">
								<tr onMouseOver="this.style.backgroundColor='#D0E9ED'"
									onMouseOut="this.style.backgroundColor=''">
									<td width="20" align="center">
										<input type="checkbox" name="checkProjects" checked="checked" style="display:none"
										value='<s:property value="%{declarations.declarId}"/>' />
									</td>
									<td align="center">
										<s:property value="#declarations.proSerial" />
									</td>
									<td align="center">
										<s:property value="#declarations.proName" />
										&nbsp;
									</td>
									<td align="center">
										<s:property
											value="#declarations.TStudentByLeaderCode.studentName" />
									</td>
									<td align="center">
										<s:property
											value="#declarations.TStudentByLeaderCode.studentNumber" />
									</td>
									<td align="center">
										<s:property
											value="#declarations.TStudentByLeaderCode.TProfession.professionName" />
									</td>
									<td align="center">
										<s:property value="#declarations.declTime" />
									</td>
									<td align="center">
										<s:if test="#declarations.checkState=='05'">
											评审通过
								  		</s:if>
										<s:elseif test="#declarations.checkState=='04'">
						         			评审没有通过
						          		</s:elseif>
										<s:elseif test="#declarations.checkState=='03'">
						         			未评审
						          		</s:elseif>
									</td>
									<td align="center">
										<s:property value="#declarations.reviewOpinion" />
									</td>
								</tr>
							</s:iterator>
							<tr>
								<s:url id="firstPage" action="UnitResultAudit">
									<s:param name="page" value="1"></s:param>
								</s:url>
								<s:url id="url_pre" action="UnitResultAudit">
									<s:param name="page" value="page-1"></s:param>
								</s:url>
								<s:url id="url_next" action="UnitResultAudit">
									<s:param name="page" value="page+1"></s:param>
								</s:url>
								<s:url id="lastPage" action="UnitResultAudit">
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
							<tr>
								<td><input type="button" value="提交审核" onClick=""/>
								</td>
								<td><input type="button" value="取消" onClick=""/>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</s:form>
		</div>
	</body>
</html>
