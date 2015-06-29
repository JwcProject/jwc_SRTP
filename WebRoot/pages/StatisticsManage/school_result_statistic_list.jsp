<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>全校成绩分布列表</title>
		<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/css/Pager.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet" type="text/css" />
		<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
		<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>

	</head>
	<body>
		<div id="container">
			<jsp:include page="../../header.jsp"></jsp:include>
			<!--  此处显示 id "maincontent" 的内容-->
			<div id="maincontent" class="h645">
				<s:form action="" method="post" name="queyForm" id="queyForm"
					theme="simple">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>

							<!--  左边区域-->
							<s:if test="null!=#session.user">
								<s:if test="%{#session.user.userType == '00'}">
									<jsp:include page="../../dean_leader_left.jsp"></jsp:include>
								</s:if>
								<s:elseif test="%{#session.user.userType == '01'}">
									<jsp:include page="../../dean_left.jsp"></jsp:include>
								</s:elseif>
								<s:elseif test="%{#session.user.userType == '02'}">
									<jsp:include page="../../teacher_leader_left.jsp"></jsp:include>
								</s:elseif>
								<s:elseif test="%{#session.user.userType == '03'}">
									<jsp:include page="../../teacher_left.jsp"></jsp:include>
								</s:elseif>
								<s:elseif test="%{#session.user.userType == '04'}">
									<jsp:include page="../../reviewTeacher_left.jsp"></jsp:include>
								</s:elseif>
								<s:elseif test="%{#session.user.userType == '05'}">
									<jsp:include page="../../commonTeacher_left.jsp"></jsp:include>
								</s:elseif>
								<s:elseif test="%{#session.user.userType == '06'}">
									<jsp:include page="../../student_left.jsp"></jsp:include>
								</s:elseif>
								<s:elseif test="%{#session.user.userType == '07'}">
									<jsp:include page="../../student_member_left.jsp"></jsp:include>
								</s:elseif>
								<s:elseif test="%{#session.user.userType == '08'}">
									<jsp:include page="../../student_leader_left.jsp"></jsp:include>
								</s:elseif>
							</s:if>
							<s:else>
								<jsp:forward page="../../login.jsp"></jsp:forward>
							</s:else>

							<!--中间区域-->
							<td width="88%" valign="top"
								style="padding-top: 10px; padding-left: 5px;"
								style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
								<div class="midbox">
									<div class="midbox_gg">
										<div class="sblb">
											&nbsp; SRTP指标分布统计
										</div>
									</div>
									
										<div class="xia_left">
											<table>
												<tr>
													<td>
														<p>
															学院:
															<s:textfield name="college" id="college"></s:textfield>
														</p>
														<p>
														<s:hidden id="pages" name="page" value="%{page}"></s:hidden>
														<s:hidden id="totalPages" name="totalPage"
															value="%{totalPage}"></s:hidden>
													</p>
													</td>
													<td>
														<div class="douselect">
															<p>
																期次:
																<s:doubleselect name="jqYear" list="jieQiYears"
																	listKey="yearKey" listValue="yearValue" headerKey="" headerValue="所有"
																	doubleList="qicis.get(top.yearKey)" doubleName="jqQici"
																	doubleListKey="jqId" doubleListValue="qici" doubleHeaderKey="" doubleHeaderValue="所有"
																	cssClass="select_sq" theme="simple" />
															</p>
														</div>
													</td>
													<td>
														<div class="xia_right_sq" style="margin-left: -170px">
															<img src="<%=path%>/images/gonggaoweihu_icon1.gif" alt="查询"
																onclick="query();" />
															<a href="javascript:resetValue();"><img
																	src="<%=path%>/images/reset.png" alt="重置" "/> </a>
															
															<input type="button" value="按期次查看" onclick="Figview()"/>
															<input type="button" value="按学院查看" onclick="CollegeView()"/>
														</div>
													</td>
												</tr>
											</table>
										</div>
									
									<div id="declaraList" class="xia_list"
										style="margin-left: 15px;">
										<table width="99%" border="0" cellspacing="0" cellpadding="0"
											style="border-bottom: 1px solid #dcdcdc; border-left: 1px solid #dcdcdc; border-right: 1px solid #dcdcdc;"
											align="left">

											<tr
												style="line-height: 30px; border-bottom: 1px solid #dcdcdc;">
												<td style="padding-left: 10px" bgcolor="#FFFFFF" width="10%"
													class="NoNewline">
													|学院名称
												</td>
												<td bgcolor="#FFFFFF" width="10%">
													|届期
												</td>
												<td bgcolor="#FFFFFF" width="8%">
													|申报数
												</td>
												<td bgcolor="#FFFFFF" width="8%">
													|立项数
												</td>
												<td bgcolor="#FFFFFF" width="8%">
													|优秀数
												</td>
												<td bgcolor="#FFFFFF" width="10%">
													|不及格数
												</td>
												<td bgcolor="#FFFFFF" width="8%">
													|结题数
												</td>
												<td bgcolor="#FFFFFF" width="8%">
													|延期数
												</td>
												<td bgcolor="#FFFFFF" width="8%">
													|立项率
												</td>
												<td bgcolor="#FFFFFF" width="8%">
													|优秀率
												</td>
												<td bgcolor="#FFFFFF" width="8%">
													|结题率
												</td>
												<td bgcolor="#FFFFFF" width="8%">
													|延期率
												</td>
											</tr>
											<s:iterator value="resultDistribut" id="resultDistribut"
												status="stuts">
												<s:if test="#stuts.odd == true">
													<tr
														style="line-height: 30px; border-bottom: 1px solid #dcdcdc; background-color: #eef7ff">
												</s:if>
												<!--判断记号是否为偶数 -->
												<s:else>
													<tr
														style="line-height: 30px; border-bottom: 1px solid #dcdcdc; background-color: #ffffff">
												</s:else>
												<!--  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">-->
												<td style="padding-left: 10px" class="NoNewline">
													<s:property value="#resultDistribut.unitName" />
												</td>
												<td>
													<s:property value="#resultDistribut.jqName" />
												</td>
												<td>
													<s:property value="#resultDistribut.decSum" />
												</td>
												<td>
													<s:property value="#resultDistribut.proSum" />
												</td>
												<td>
													<s:property value="#resultDistribut.bestSum" />
												</td>
												<td>
													<s:property value="#resultDistribut.badSum" />
												</td>
												<td>
													<s:property value="#resultDistribut.endSum" />
												</td>
												<td>
													<s:property value="#resultDistribut.delaySum" />
												</td>
												<td>
													<s:property value="#resultDistribut.proRate" />
												</td>
												<td>
													<s:property value="#resultDistribut.bestRate" />
												</td>
												<td>
													<s:property value="#resultDistribut.endRate" />
												</td>
												<td>
													<s:property value="#resultDistribut.delayRate" />
												</td>
												</tr>
											</s:iterator>



										</table>
									</div>
									<div class="xia_x">
										<div id="pager">
										</div>
									</div>
								</div>
							</td>




						</tr>
					</table>
				</s:form>
			</div>
			<div class="footer">
				<div class="footer_L fl">
					SRTP协作平台 v1.0
				</div>
				<div class="footer_R fr">
					UI Design：ISSE
				</div>
			</div>
		</div>
		
		<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.pager.js" ></script>
		<script src="<%=path%>/js/statistics.js" type="text/javascript"></script>
		<script type="text/javascript" language="javascript">

 // var n = document.getElementById('pages').value;
      // var n = document.getElementsByTagName('s:hidden').value;
     //   alert(n);
        $(document).ready(function() {
            var page = $("#pages")[0].value;
            var totalPage = $("#totalPages")[0].value;
            //alert(page);
            //alert(totalPage);
            $("#pager").pager({ pagenumber: page, pagecount: totalPage, buttonClickCallback: PageClick });
        });

        PageClick = function(pageclickednumber) {
            var totalPage = $("#totalPages")[0].value;
            $("#pager").pager({ pagenumber: pageclickednumber, pagecount: totalPage, buttonClickCallback: PageClick });
            changePage(pageclickednumber);
        };


function changePage(pageclickednumber){
	 var college = $("#college")[0].value;

	 var t = document.getElementsByName("jqYear")[0]; 
	 var s = document.getElementsByName("jqQici")[0];
     var jqYear=t.options[t.selectedIndex].value;
     var jqQici=s.options[s.selectedIndex].value;
	 location="SchoolResultDistribut?page="+pageclickednumber+"&college="+college+"&jqYear="+jqYear+"&jqQici="+jqQici;
}
 
function query()
{
    $("#pages")[0].value = 1;
	document.queyForm.action="<%=basePath%>Statistic/SchoolResultDistribut";
	document.queyForm.submit();
}

function Figview()
{
	var t = document.getElementsByName("jqYear")[0]; 
	var jqYear=t.options[t.selectedIndex].value;
	var s = document.getElementsByName("jqQici")[0];
	if(-1 == s.selectedIndex)
	{
		$.messager.alert('提示','请选择一个届期查看图表','warning');
        return;
	}
	else
	{
		var jqQici=s.options[s.selectedIndex].value;
	
		if(null == jqQici || '' == jqQici)
		{
			$.messager.alert('提示','请选择一个届期查看图表','warning');
	        return;
		}
		else
		{
			document.queyForm.action="<%=path%>/Statistic/CollegeResultDistribut";
			document.queyForm.target="_blank";
			document.queyForm.submit();
			document.queyForm.target="_self";
			
		}
	}
}


function CollegeView()
{
	var college = $("#college").val();
	if(college != null && college != '')
	{
		var param = {"college":college};
        $.post('IsCollegeNameHadValue', param, function(res){
        	var obj = JSON.parse(res);
        	if(obj.result == 'false')
        	{
        		$.messager.alert('提示','只能查看一个学院的统计数据，请重新输入','warning');
        		return;
        	}
        	else if(obj.result == 'noValue')
        	{
        		$.messager.alert('提示','您输入的学院不存在!请重新输入有效的学院名称','warning');
        		return;
        	}
        	else if(obj.result == 'error')
        	{
        	   $.messager.alert('提示','对不起，数据查询有误，请稍后重试查询或与管理员联系','warning');
        		return;
        	}
        	else if(obj.result == 'true')
        	{
        		document.queyForm.action="<%=path%>/Statistic/JiciResultDistribut";
				document.queyForm.target="_blank";
				document.queyForm.submit();
				document.queyForm.target="_self";
        		return;
        	}
        });
	}
	else
	{
		$.messager.alert('提示','请输入学院名称，才能查看','warning');
        return;
	}
	
	
}



function resetValue() 
{
		
	$("#college").val("");
	var t = document.getElementsByName("jqYear")[0]; 
	t.options[t.selectedIndex].value = "";
	t.options[t.selectedIndex].selected = "selected";
	var s = document.getElementsByName("jqQici")[0];
	s.options[t.selectedIndex].value= "";
	s.options[s.selectedIndex].selected = "selected";
	//alert(s.options[t.selectedIndex].value);
}
</script>
	</body>
</html>
