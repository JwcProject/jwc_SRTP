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
		<title>教务处申报列表</title>
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
		<link href="css/Pager.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" charset="utf-8"></script>
		
	

		<style type="text/css">
.doubleselect br {
	display: none;
}
</style>
<script type="text/javascript">

        
	function audit(state){
	    var dataForm = $('#proForm').serialize() + "&checkState=" + state;
		jQuery.ajax({
			url : "SchoolCheck",
			data : dataForm,
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			type : "POST",
			success : function(r) {
				/////写什么？
				location="index.jsp";
			}
		});
	}
	function check(){
		var all = document.getElementById("ALL");
		if(all.checked==true){
			checkAll();	
		}
		else{
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
					style="font-family: Arial; font-size: 14px; font-weight: bold; font-style: normal; text-decoration: none; color: #000000;">SRTP项目申报列表</span>
			</p>
			<div id="query" class="doubleselect">
				<s:form action="FindSchoolDeclaration" method="post" name="queyForm"
					theme="simple">
					<table width="100%">
						<tr>
							<td>
								请选择年份和期次：
								<!--  label="请选择年份和期次"-->
								<s:doubleselect name="jqYear" list="jieQiYears"
									listKey="yearKey" listValue="yearValue"
									doubleList="qicis.get(top.yearKey)" doubleName="jqQici"
									doubleListKey="jqId" doubleListValue="qici" />
							</td>
							<td>
								项目名称:
								<input type="text" name="proName" />
							</td>
							<td>
								所属学院:
								<input type="text" name="college" />
							</td>
							<td>
								评审结果:
								<select name="checkState" id="checkState">
								    <option value="05">
										待审核
									</option>
									<option value="">
										所有
									</option>
									<option value="07">
										已通过
									</option>
									<option value="06">
										未通过
									</option>
									
								</select>
							</td>
							<td>
								<input type="submit" value="查询" />
								<input type="reset" value="重置" />
							</td>
						</tr>
					</table>
				</s:form>
			</div>
			<s:form action="" theme="simple" id="proForm">
				<div class="con-box">
					<div class="con">
						<table cellpadding="0" cellspacing="0" class="info-table"
							width="100%">
							<thead>
								<tr>
									<td width="20" align="center">
										<input type="checkbox" name="ALL" id="ALL" onClick="check()"
											value=on "/>
									</td>
									<td width="100" align="center">
										项目名称
									</td>
									<td width="65" align="center">
										申报人
									</td>
									<td width="65" align="center">
										期次
									</td>
									<td width="65" align="center">
										学院
									</td>
									<td width="65" align="center">
										评审结果
									</td>
									<td width="65" align="center">
										操作
									</td>
								</tr>
							</thead>
							<s:iterator value="declarations" id="declarations">
								<tr onMouseOver="this.style.backgroundColor='#D0E9ED'"
									onMouseOut="this.style.backgroundColor=''">
									<td width="20" align="center">
										<input type="checkbox" name="checkProjects"
										value='<s:property value="%{#declarations.declarId}"/>' />
									</td>
									<td align="center">
										<s:property value="#declarations.proName" />
										&nbsp;
									</td>
									<td align="center">
										<s:property
											value="#declarations.TStudentByLeaderCode.studentName" />
									</td>
									<td align="center">期次
										<s:property
											value="#declarations.TStudentByLeaderCode.studentNumber" />
									</td>
									<td align="center">学院
										<s:property
											value="#declarations.TStudentByLeaderCode.TProfession.professionName" />
									</td>
									<td align="center">
										<s:if test="#declarations.checkState=='07'">
											已通过
								  		</s:if>
										<s:elseif test="#declarations.checkState=='06'">
						         			未通过
						          		</s:elseif>
										<s:elseif test="#declarations.checkState=='05'">
						         			待审核
						          		</s:elseif>
									</td>
									<td align="center">
										<s:a href="ViewDeclaration?id=%{#declarations.declarId}"
											>查看</s:a>
										<!--
										<s:a href="DeleteDeclaration?id=%{#declarations.declarId}"
											>删除</s:a>
										-->
									</td>
								</tr>
							</s:iterator>
							<tr>
								<s:url id="firstPage" action="FindSchoolDeclaration">
									<s:param name="page" value="1"></s:param>
								</s:url>
								<s:url id="url_pre" action="FindSchoolDeclaration">
									<s:param name="page" value="page-1"></s:param>
								</s:url>
								<s:url id="url_next" action="FindSchoolDeclaration">
									<s:param name="page" value="page+1"></s:param>
								</s:url>
								<s:url id="lastPage" action="FindSchoolDeclaration">
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
									<tr>
								<td><input type="button" value="审核通过" onClick="audit('yes')"/>
								</td>
								<td><input type="button" value="审核不通过" onClick="audit('no')"/>
								</td>
								<td><input type="button" value="取消" onClick=""/>
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
