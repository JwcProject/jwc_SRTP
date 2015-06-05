﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>结果审核</title>
		<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/css/Pager.css" rel="stylesheet" type="text/css" />
		<!--这个js是用来控制页面中出现png图片能兼容浏览区-->


	</head>
	<body>
		<div id="container">
			<jsp:include page="../../header.jsp"></jsp:include>
			<!--  此处显示 id "maincontent" 的内容-->
			<div id="maincontent" class="h645">

				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>

						<!--  左边区域-->
						<jsp:include page="../../teacher_leader_left.jsp"></jsp:include>

						<!--中间区域-->
						<td width="88%" valign="top"
							style="padding-top: 10px; padding-left: 5px;"
							style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
							<div class="midbox">
								<div class="midbox_gg">
									<div class="sblb">
										&nbsp;
										<s:property value="%{tunit.unitName}" />
										SRTP项目申报列表
									</div>
								</div>
								<s:form action="" method="post" name="queyForm" id="queyForm" theme="simple">
									<div class="xia_left">
										<table>
											<tr>
												<td>
													<div class="douselect">
													<p>
														期次:
														<s:doubleselect name="jqYear" list="jieQiYears"
															listKey="yearKey" listValue="yearValue"
															doubleList="qicis.get(top.yearKey)" doubleName="jqQici"
															doubleListKey="jqId" doubleListValue="qici"
															cssClass="select_sq" theme="simple" />
													</p>
													</div>
												</td>
												<td>
													<p>
													项目编号:
													<s:textfield name="proSerial" id="proSerial"
														style="width:88px;height:14px" />
													</p>
												</td>
												<td>
													<p>
													项目名称:
													<s:textfield name="proName" id="proName"
														style="width:88px;height:14px" />
													</p>
												</td>
												<td>
													<p>
													专业:
													<s:select list="professions" name="profession" headerKey=""
														headerValue="所有" listKey="professionName"
														listValue="professionName"></s:select>
													</p>
												</td>
												<td>
													<p>
													学号:
													<s:textfield name="studentNumber" id="studentNumber"
														style="width:88px;height:14px"></s:textfield>

													</p>
												</td>
												<td>
													<p>
													审核状态:
													<s:select
														list='#{"00":"所有","03":"待审核","05":"已通过","04":"未通过"}'
														name="checkState" id="checkState"></s:select>

													</p>
												</td>
												<td>
													<p>
													<s:hidden id="pages" name="page" value="%{page}"></s:hidden>
													<s:hidden id="totalPages" name="totalPage"
														value="%{totalPage}"></s:hidden>
													</p>
												</td>
												<td>
													<div class="xia_right_sq" style="left:935px">
														<a href="#" onclick="query();"><img
																src="images/gonggaoweihu_icon1.gif" alt="查询" /> </a>
														<a href="javascript:document.queyForm.reset();"><img
																src="images/reset.png" alt="重置" "/> </a>
													</div>
												</td>
											</tr>
										</table>
									</div>
								</s:form>
								<s:form action="" theme="simple" id="proForm">
									<div class="xia_list">

										<table width="97%" border="0" cellspacing="0" cellpadding="0"
											style="border-bottom: 1px solid #dcdcdc; border-left: 1px solid #dcdcdc; border-right: 1px solid #dcdcdc;"
											align="left">

											<tr
												style="line-height: 30px; border-bottom: 1px solid #dcdcdc;">
												<td style="padding-left: 10px" bgcolor="#FFFFFF" width="12%"
													class="NoNewline">
													<input type="checkbox" name="ALL" id="ALL"
														onClick="check()" value="on " />
													<label for="music">
														|项目编号
													</label>
												</td>
												<td bgcolor="#FFFFFF" width="24%">
													|项目名称
												</td>
												<td bgcolor="#FFFFFF" width="7%">
													|申报人
												</td>
												<td bgcolor="#FFFFFF" width="7%">
													|学号
												</td>
												<td bgcolor="#FFFFFF" width="7%">
													|专业
												</td>
												<td bgcolor="#FFFFFF" width="7%">
													|申请日期
												</td>
												<td bgcolor="#FFFFFF" width="7%">
													|评审结果
												</td>
												<td bgcolor="#FFFFFF" width="18%">
													|评审意见
												</td>
												<td bgcolor="#FFFFFF" width="7%"> |操作</td>
											</tr>
											<s:iterator value="declarations" id="declarations"
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
												<td style="padding-left: 10px" class="NoNewline">
													<input type="checkbox" name="checkProjects" id="music"
														value='<s:property value="%{#declarations.declarId}"/>' />
													<label for="music">
														<s:property value="#declarations.proSerial" />
													</label>
												</td>
												<td title="<s:property value='#declarations.proName' />">
													 <s:if test="%{#declarations.proName.length()>20}">
														<s:property value="%{#declarations.proName.substring(0,20)+'...'}" escape="#onlineList.frmTitle"/>
													</s:if>
													<s:else>
														<s:property value="#declarations.proName" />
													</s:else>
												</td>
												<td>
													<s:property
														value="#declarations.TStudentByLeaderCode.studentName" />
												</td>
												<td>
													<s:property
														value="#declarations.TStudentByLeaderCode.studentNumber" />
												</td>
												<td>
													<s:property
														value="#declarations.TStudentByLeaderCode.TProfession.professionName" />
												</td>
												<td>
													<s:if
														test="null==#declarations.declTime||#declarations.declTime.isEmpty()">

													</s:if>
													<s:else>
														<s:text name="global.format.date">
															<s:param value="#declarations.declTime" />
														</s:text>
													</s:else>
												</td>
												<td>
													<s:if test="#declarations.checkState=='05'">
											已通过
								  		</s:if>
													<s:elseif test="#declarations.checkState=='04'">
						         			未通过
						          		</s:elseif>
													<s:elseif test="#declarations.checkState=='03'">
						         			待审核
						          		</s:elseif>
												</td>
												<td>
													<s:property value="#declarations.reviewOpinion" />
												</td>
												<td  >
													<s:a href="ViewDeclaration?id=%{#declarations.declarId}"  >
														<img src="images/mid5.jpg" alt="查看" />
													</s:a>
												</td>
												</tr>
											</s:iterator>
										</table>

									</div>
								</s:form>
								<div class="xia_x_jg">

									<ul>
										<li>
											<a  onclick="audit();"><img
													src="images/tjsh.gif" alt="提交 审核" /> </a>
										</li>
										<li style="color: blue">
											点击按钮，将申报结果提交至教务处，学院不能再做修改
										</li>
									</ul>


								</div>
								<div id="pager"
									style="padding-left: 600px; position: relative; top: -65px;">
								</div>
							</div>
						</td>




					</tr>
				</table>

			</div>
			<jsp:include page="../../footer.jsp"></jsp:include>
		</div>
	</body>
	<script src="<%=path%>/js/jquery.pager.js" type="text/javascript"></script>
	<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
	<script type="text/javascript" src="<%=path%>/js/declaration.js"></script>
	<script type="text/javascript" language="javascript">
  $(document).ready(function() {
            var page = $("#pages")[0].value;
            var totalPage = $("#totalPages")[0].value;
            $("#pager").pager({ pagenumber: page, pagecount: totalPage, buttonClickCallback: PageClick });
        });

        PageClick = function(pageclickednumber) {
            var totalPage = $("#totalPages")[0].value;
            $("#pager").pager({ pagenumber: pageclickednumber, pagecount: totalPage, buttonClickCallback: PageClick });
            changePage(pageclickednumber);
        }


function changePage(pageclickednumber){
  /*
	 var checkState = $("#checkState")[0].value;
	 var proName = $("#proName")[0].value;
	 var proSerial = $("#proSerial")[0].value;
     var studentNumber = $("#studentNumber")[0].value;
     
     var r = document.getElementsByName("profession")[0]; 
	 var t = document.getElementsByName("jqYear")[0]; 
	 var s = document.getElementsByName("jqQici")[0];
     var jqYear=t.options[t.selectedIndex].value;
     var jqQici=s.options[t.selectedIndex].value;
	 var profession=r.options[t.selectedIndex].value;
	  location="QueryResultAudit?page="+pageclickednumber+"&checkState="+checkState+"&proName="+proName+"&proSerial="+proSerial+"&studentNumber="+studentNumber+"&profession="+profession+"&jqYear="+jqYear+"&jqQici="+jqQici;
	 */
	 location = "QueryResultAudit?"+$('#queyForm').serialize();
	}
 
function query()
{
    $("#pages")[0].value = 1;
	document.queyForm.action="<%=basePath%>QueryResultAudit";
		document.queyForm.submit();
}

	function audit() {
		 alert("dd");
		var dataForm = $('#proForm').serialize();

		jQuery.ajax({
			url : 'UnitAudit',
			data : dataForm,
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			type : "POST",
			success : function(r) {
				//需要修改为其他地址
				//alert("kdkdk");
				/*
				var page = $("#pages")[0].value;
				var checkState = $("#checkState")[0].value;
			    var proName = $("#proName")[0].value;
			    var proSerial = $("#proSerial")[0].value;
		        var studentNumber = $("#studentNumber")[0].value;
		     
		        var r = document.getElementsByName("profession")[0]; 
			    var t = document.getElementsByName("jqYear")[0]; 
			    var s = document.getElementsByName("jqQici")[0];
		        var jqYear=t.options[t.selectedIndex].value;
		        var jqQici=s.options[t.selectedIndex].value;
			    var profession=r.options[t.selectedIndex].value;
				location = "QueryResultAudit?page=" + page
						+ "&checkState=" + checkState + "&proName=" + proName + "&proSerial=" + proSerial + "&studentNumber=" + studentNumber
						+ "&profession=" + profession + "&jqYear=" + jqYear
						+ "&jqQici=" + jqQici;*/
				location = "QueryResultAudit?"+$('#queyForm').serialize();
				
				
			}
		});
	}

	function check() {
		var all = document.getElementById("ALL");
		if (all.checked == true) {
			checkAll();
		} else {
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
</html>
