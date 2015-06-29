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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的结题评审</title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/Pager.css" rel="stylesheet" type="text/css" />
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
<script src="<%=path%>/js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="<%=path%>/js/jquery.pager.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>

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
      
     var studentNums = $("#studentNums")[0].value;
	 var proName = $("#proName")[0].value;
	 var compEval = $("#compEval")[0].value;

	 var r = document.getElementsByName("profession")[0];      
	 var t = document.getElementsByName("jqYear")[0]; 
	 var s = document.getElementsByName("jqQici")[0];
	 var profession =  r.options[t.selectedIndex].value;
     var jqYear=t.options[t.selectedIndex].value;
     var jqQici=s.options[t.selectedIndex].value;
	 location="FindInMyew?page="+pageclickednumber+"&studentNums="+studentNums+"&proName="+proName+"&compEval="+compEval+"&jqYear="+jqYear+"&jqQici="+jqQici+"&profession="+profession;
	 
	}
 
function query()
{
    $("#pages")[0].value = 1;
	document.queyForm.action="<%=basePath%>FindIyReview";
	document.queyForm.submit();
}       
      
       
    </script>

</head>
<body>
<div id="container">
  <jsp:include page="../../header.jsp" ></jsp:include>
  <!--  此处显示 id "maincontent" 的内容-->
  <div id="maincontent" class="h645">
  <s:form action="" method="post" name="queyForm"
					theme="simple">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
	  
        <!--  左边区域-->
		 <jsp:include page="../../reviewTeacher_left.jsp"></jsp:include>
        <!--中间区域-->
        <td width="88%" valign="top"  style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc" bordercolor="#f4f3f1"  >
		<div class="midbox">
		<div class="midbox_gg">
		<div class="sblb">我的评审列表</div>
	    </div>
		<div class="xia_left">
		<table>
		<ul>
		<!--  
		<li>
		<p>年度
			<select name="select_sq" id="select_sq" class="select_sq">
			<option>请选择------</option>
			<option>2013年</option>
			</select>
		</p>
		</li>
		
		<li>
		<p>期数
			<select name="select_sq" id="select_sq" class="select_sq">
			<option>请选择------</option>
			<option>第一期</option>
			</select>
		</p>
		</li>
		-->
		
		<li>
		<div class="douselect">
		<p>期次:
		<s:doubleselect name="jqYear" list="jieQiYears"
									listKey="yearKey" listValue="yearValue"
									doubleList="qicis.get(top.yearKey)" doubleName="jqQici"
									doubleListKey="jqId" doubleListValue="qici" 
									cssClass="select_sq" theme="simple"/>
		</p>
		</div>
		</li>
		
		
		
		
		<li>
		<p>项目名称:
		<s:textfield name="proName" id="proName" style="width:88px;height:14px" /> 
		</p>
		</li>
		
		
		
		<li>
		<p>专业:
			<!--
			<select name="select_sq" id="select_sq" class="select_sq">
			<option>请选择------</option>
			<option>软件工程</option>
			</select>
			-->
			<s:select list="professions" name="profession" headerKey=""
									headerValue="所有" listKey="professionName"
									listValue="professionName"></s:select>
		</p>
		</li>
		
		<li>
		<p>学号:
		<s:textfield name="studentNums" id="studentNums" style="width:88px;height:14px"/> 
		</p>
		</li>
		
		<li>		
		<p>网评结果:
		 <s:select list='#{"00":"所有","01":"不建议结题","02":"建议结题"}'
		  name="compEval" id="compEval" ></s:select>

       </p>
      </li>
      <li>
       <s:hidden id="pages" name="page" value="%{page}"></s:hidden>
      </li>
      <li>
       <s:hidden id="totalPages" name="totalPage" value="%{totalPage}"></s:hidden>
      </li>
</ul>
</table>
		</div>
		
		<div class="xia_right_sq" style="margin-left: -85px">
		<img src="images/gonggaoweihu_icon1.gif" alt="查询" onclick="query();"/></div>
		
		<div id="endproejctList" class="xia_list">
 <table width="96%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="left" >
                                                                                                   
                      <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                        <td style="padding-left:10px" bgcolor="#FFFFFF" width="14%" class="NoNewline">|项目编号</td>
                        <td bgcolor="#FFFFFF" width="14%"> |项目名称 </td>
                        <td bgcolor="#FFFFFF" width="9%"> |组长 </td>
						<td bgcolor="#FFFFFF" width="9%"> |学号 </td>
						<td bgcolor="#FFFFFF" width="9%"> |专业 </td>
						<td bgcolor="#FFFFFF" width="9%"> |申请日期 </td>
						<td bgcolor="#FFFFFF" width="9%"> |网评结果 </td>
						<td bgcolor="#FFFFFF" width="9%"> |评审结果 </td>
						<td bgcolor="#FFFFFF" width="15%"> |操作 </td>                     
						 </tr>
					<s:iterator value="endProjectComments" id="endProjectComments" status="stuts"> 
					<s:if test="#stuts.odd =endProjectComments= true">
					  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
    				</s:if>
    				<!--判断记号是否为偶数 -->
   					<s:else>
      				  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
    				</s:else>
                      <!--  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">-->
                        <td style="padding-left:10px" class="NoNewline"><s:property value="#endProjectComments.TEndProjectExport.TEndProject.endprojectNumber" /></td>
                        <td title="<s:property value='#endProjectComments.TEndProjectExport.TEndProject.endprojectName' />">
                        <s:if test="%{#endProjectComments.TEndProjectExport.TEndProject.endprojectName.length()>20}">
    				    	<s:property value="%{#endProjectComments.TEndProjectExport.TEndProject.endprojectName.substring(0,20)+'...'}" escape="#onlineList.frmTitle"/>
    				    </s:if>
    				    <s:else>
    				    	<s:property value="#endProjectComments.TEndProjectExport.TEndProject.endprojectName" />
    				    </s:else>
                        </td>
                        <td ><s:property value="#endProjectComments.TEndProjectExport.TEndProject.TProject.TStudentByProjectLeader.studentName" /> </td>
						<td ><s:property value="#endProjectComments.TEndProjectExport.TEndProject.TProject.TStudentByProjectLeader.studentNumber" /> </td>
						<td ><s:property value="#endProjectComments.TEndProjectExport.TEndProject.TProject.TStudentByProjectLeader.TProfession.professionName" /> </td>
						<td >
						<s:if test="null==#endProjectComments.TEndProjectExport.TEndProject.submitTime||#endProjectComments.TEndProjectExport.TEndProject.submitTime.isEmpty()">  
						    
						</s:if>
						<s:else>
						    <s:text name="global.format.date">
							<s:param value="#endProjectComments.TEndProjectExport.TEndProject.submitTime"/>
							</s:text>
						</s:else>
						</td>
						<td >&nbsp;
						
						<s:if test="#endProjectComments.endprojectcommentContent=='02'">
											建议结题
								  		</s:if>
										<s:elseif test="#endProjectComments.endprojectcommentContent=='01'">
						         			不建议结题
						          		</s:elseif>
					 </td>
					 <td >
						<s:if test="#endProjectComments.TEndProjectExport.TEndProject.endprojectState=='04'">
											已结题
								  		</s:if>
										<s:elseif test="#endProjectComments.TEndProjectExport.TEndProject.endprojectState=='02'">
						         			未通过
						          		</s:elseif>
										<s:elseif test="#endProjectComments.TEndProjectExport.TEndProject.endprojectState=='03'">
						         			结题中
						          		</s:elseif>
										<s:elseif test="#endProjectComments.TEndProjectExport.TEndProject.endprojectState=='01'">
						         			结题已提交
						          		</s:elseif>
						</td>
						<td bgcolor="#eef7ff">
						<s:a href="FindEndProComById?endProjectCommentsId=%{#endProjectComments.TEndProjectExport.TEndProject.endprojectId}" 
						     ><img src="images/online.png" alt="网评" /></s:a>
						</td>                    
					  </tr>
					</s:iterator>	   
						
	                                                                                   
                       
                </table></div>
		<div class="xia_x">

		<div id="pager" >
		</div>
		</div>
		</div>
		</td>
          
        
		
	
	</tr>
	</table>
	</s:form>
  </div>
<jsp:include page="../../footer.jsp"></jsp:include>
</div>
<script type="text/javascript" src="<%=path%>/js/endproject.js"></script>
</body>
</html>
