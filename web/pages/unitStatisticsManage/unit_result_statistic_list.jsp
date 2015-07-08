<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

		<div id="container">
			<!--  此处显示 id "maincontent" 的内容-->
			<div id="maincontent" class="h645">
				<s:form action="" method="post" name="queyForm" id="queyForm"
					theme="simple">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
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
														<s:hidden id="pages" name="page" value="%{page}"></s:hidden>
														<s:hidden id="totalPages" name="totalPage"
															value="%{totalPage}"></s:hidden>
														</p>
													</td>
													<td>
													<a href="<%=path%>/UnitStatistic/UnitLineChart" target="_blank">查看统计图</a>
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
												<td bgcolor="#FFFFFF" width="8%">
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
												<td bgcolor="#FFFFFF" width="8%">
												    |操作
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
													&nbsp;<s:property value="#resultDistribut.jqName" />
												</td>
												<td>
													&nbsp;<s:property value="#resultDistribut.decSum" />
												</td>
												<td>
													&nbsp;<s:property value="#resultDistribut.proSum" />
												</td>
												<td>
													&nbsp;<s:property value="#resultDistribut.bestSum" />
												</td>
												<td>
													&nbsp;<s:property value="#resultDistribut.badSum" />
												</td>
												<td>
													&nbsp;<s:property value="#resultDistribut.endSum" />
												</td>
												<td>
													&nbsp;<s:property value="#resultDistribut.delaySum" />
												</td>
												<td>
													&nbsp;<s:property value="#resultDistribut.proRate" />
												</td>
												<td>
													&nbsp;<s:property value="#resultDistribut.bestRate" />
												</td>
												<td>
													&nbsp;<s:property value="#resultDistribut.endRate" />
												</td>
												<td>
													&nbsp;<s:property value="#resultDistribut.delayRate" />
												</td>
												<td>
												<s:a href="UnitScoreStatistic?jqId=%{#resultDistribut.jqId}" target="_blank"><img src="<%=path%>/images/shenbiaoliebiao_icon1.gif" alt="查看" /></s:a>
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
		</div>
		<script type="text/javascript" language="javascript">

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
	 
	  location="UnitResultDistribut";
	}
 
function ViewFig(jqId, jqName)
{
	document.queyForm.action="<%=basePath%>UnitStatistic/UnitScoreStatistic?jqId="+jqId+ "&jqName=" +jqName;
	document.queyForm.target="_blank";
	document.queyForm.submit();
	document.queyForm.target="_self";
}
function query()
{
    $("#pages")[0].value = 1;
	document.queyForm.action="<%=basePath%>Statistic/SchoolResultDistribut";
		document.queyForm.submit();
	}

	
</script>
