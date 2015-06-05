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
<title>结题成绩审核</title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/Pager.css" rel="stylesheet" type="text/css" />
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->

    
</head>
<body>
<div id="container">
 <jsp:include page="../../header.jsp" ></jsp:include>
  <!--  此处显示 id "maincontent" 的内容-->
  <div id="maincontent" class="h645">
 
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
	  
        <!--  左边区域-->
       
		  <jsp:include page="../../teacher_leader_left.jsp"></jsp:include>
		  
        <!--中间区域-->
        <td width="88%" valign="top"  style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc" bordercolor="#f4f3f1"  >
		<div class="midbox">
		<div class="midbox_gg">
		<div class="sblb"><s:property value="%{#session.unit.unitName}" />SRTP项目结题列表</div>
	    </div>
	     <s:form action="" method="post" name="queyForm" theme="simple">
		<div class="xia_left">
		<ul>
		
				<li>
		<div class="douselect">
		<p>期次:
		<s:doubleselect name="property.year" list="jieQiYears"
									listKey="yearKey" listValue="yearValue"
									doubleList="qicis.get(top.yearKey)" doubleName="property.jieqiId"
									doubleListKey="jqId" doubleListValue="qici" 
									cssClass="select_sq" theme="simple"/>
		</p>
		</div>
		</li>
		
		<!--<li>
		<p>项目编号:
		<s:textfield name="proSerial" id="proSerial" style="width:88px;height:14px"/> 
		</p>
		</li>
		
		--><li>
		<p>项目名称:
		<s:textfield name="proNaproperty.projectNameme" id="proName" style="width:88px;height:14px" /> 
		</p>
		</li>
		
<li>
		<p>专业:
			<s:select list="professions" name="property.professionId" headerKey=""
									headerValue="所有" listKey="professionName" id="professionId"
									listValue="professionName"></s:select>
</p>
</li>
<li>
		<p>学号:
		<s:textfield  name="property.studentNumber" id="studentNumebr" style="width:88px;height:14px"/> 
</p>
</li>
<li>

<li>
		
		<p>审核状态:
		   <s:select list='#{"03":"结题中","04":"教务处审核"}' name="property.endprojectState" id="checkState"></s:select>
			
</p>
        </li>
        <li>
<p>
       <s:hidden id="pages" name="page" value="%{page}"></s:hidden>
       <s:hidden id="totalPages" name="totalPage" value="%{totalPage}"></s:hidden>
</p>
</li>
</ul>
		</div>
		</s:form>
		<div class="xia_right_sq">
		<img src="images/gonggaoweihu_icon1.gif" alt="查询" onclick="query();"/></div>
		
		<s:form action="" theme="simple" id="proForm">
		<div class="xia_list">
		
 <table width="97%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="left" >
                                                                                                   
                      <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                        <td style="padding-left:10px" bgcolor="#FFFFFF" width="14%" class="NoNewline"><input type="checkbox" name="ALL" id="ALL" onClick="check()"
											value="on "/><label for="music">|项目编号</label> 
</td>
                        <td bgcolor="#FFFFFF" width="18%"> |项目名称 </td>
                        <td bgcolor="#FFFFFF" width="9%"> |组长 </td>
						<td bgcolor="#FFFFFF" width="9%"> |学号 </td>
						<td bgcolor="#FFFFFF" width="9%"> |专业 </td>
						<td bgcolor="#FFFFFF" width="9%"> |结题日期 </td>
						<td bgcolor="#FFFFFF" width="9%"> |结题状态 </td>
						<td bgcolor="#FFFFFF" width="9%"> |成绩</td>
						<td bgcolor="#FFFFFF" width="18%"> |结题评语 </td>                     
						 </tr>
				<s:iterator value="endProjects" id="endProjects" status="stuts"> 
					<s:if test="#stuts.odd == true">
					  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
    				</s:if>
    				<!--判断记号是否为偶数 -->
   					<s:else>
      				  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
    				</s:else>
                        <td style="padding-left:10px" class="NoNewline">
                        <input type="checkbox" name="checkProjects" id="checkProjects" value='<s:property value="#endProjects.endprojectId"/>'/>
                        <label for="music"><s:property value="#endProjects.endprojectNumber" /></label> 
                        </td>
                        <td title="<s:property value='#endProjects.endprojectName' />">
							<s:if test="%{#endProjects.endprojectName.length()>15}">
    				    	<s:property value="%{#endProjects.endprojectName.substring(0,15)+'...'}" escape="#onlineList.frmTitle"/>
    				    </s:if>
    				    <s:else>
    				    	<s:property value="#endProjects.endprojectName" />
    				    </s:else>
						 </td>
						<td ><s:property value="#endProjects.TProject.TStudentByProjectLeader.studentName" /> </td>
						<td ><s:property value="#endProjects.TProject.TStudentByProjectLeader.studentNumber" /> </td>
						<td ><s:property value="#endProjects.TProject.TStudentByProjectLeader.TProfession.professionName" /> </td>
						<td >
						<s:if test="null==#endProjects.submitTime||#endProjects.submitTime.isEmpty()">  
						    
						</s:if>
						<s:else>
						    <s:text name="global.format.date">
							<s:param value="#endProjects.submitTime"/>
							</s:text>
						</s:else>
						</td>
						 <td>
							<s:if test="%{#endProjects.endprojectState=='01'}">未处理</s:if>
							<s:elseif test="%{#endProjects.endprojectState=='02'}">未通过</s:elseif>
							<s:elseif test="%{#endProjects.endprojectState=='03'}">结题中</s:elseif>
							<s:elseif test="%{#endProjects.endprojectState=='04'}">教务处审核</s:elseif>
							<s:elseif test="%{#endProjects.endprojectState=='05'}">二次答辩</s:elseif>
							<s:elseif test="%{#endProjects.endprojectState=='06'}">已结题</s:elseif>
						 </td>
						<td>
							<s:if test="%{#endProjects.endprojectScore=='01'}">优秀</s:if>
							<s:elseif test="%{#endProjects.endprojectScore=='02'}">良好</s:elseif>
							<s:elseif test="%{#endProjects.endprojectScore=='03'}">中等</s:elseif>
							<s:elseif test="%{#endProjects.endprojectScore=='04'}">及格</s:elseif>
							<s:elseif test="%{#endProjects.endprojectScore=='05'}">不及格</s:elseif>
						</td>
						 
						<td title="<s:property value='#endProjects.endprojectComment' /> ">
							 <s:if test="%{#endProjects.endprojectComment.length()>15}">
	                        	<s:property value="#endProjects.endprojectComment.substring(0,15)+'...'"/>
	                         </s:if>
	                         <s:else>
	                         	<s:property value="#endProjects.endprojectComment"/>
	                         </s:else>
						</td>                
					 </tr>
				</s:iterator>        
						        
		
	           </table>
	          
	           </div>
	           </s:form>
		<div class="xia_x_jg">
		
		<ul>
		<li><a  onclick="audit();"><img src="<%=path%>/images/jieguo_anniu1.gif" alt="提交 审核" /></a></li>
		<%--<li><a ><img src="<%=path%>/images/jieguo_anniu4.gif" alt="取消" /></a></li>
		--%>
		<li style="color:red">&nbsp;&nbsp;注：点击提交审核，学院将不能对结题成绩做任何修改</li>	
		</ul>
		 
		
		</div>
		 <div id="pager" style="padding-left: 600px;position: relative;top:-65px;">		
		</div>
		</div>
		</td>
          
        
		
	
	</tr>
	</table>
	
  </div>
<jsp:include page="../../footer.jsp"></jsp:include>
</div>
</body>
<script type="text/javascript" src="<%=path%>/js/jquery.pager.js" ></script>
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
<script type="text/javascript" src="<%=path%>/js/endproject.js"></script>
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
        };


function changePage(pageclickednumber){
  
	/*
	 var checkState = $("#checkState")[0].value;
	 var proName = $("#proName")[0].value;
	 var proSerial = $("#proSerial")[0].value;
     var proSerial = $("#studentNumber")[0].value;
    // var proSerial = $("#proSerial")[0].value;
     
     var r = document.getElementsByName("jqYear")[0]; 
	 var t = document.getElementsByName("jqYear")[0]; 
	 var s = document.getElementsByName("jqQici")[0];
     var jqYear=t.options[t.selectedIndex].value;
     var jqQici=s.options[t.selectedIndex].value;
	 var profession=r.options[t.selectedIndex].value;
	  location="QueryEndProScoreCheck?page="+pageclickednumber+"&checkState="+checkState+"&proName="+proName+"&proSerial="+proSerial+"&studentNumber="+studentNumber+"&profession="+profession+"&jqYear="+jqYear+"&jqQici="+jqQici;
	*/ 
	 $("#pages").val(pageclickednumber);
	 document.queyForm.action="<%=basePath%>QueryEndProScoreCheck";
	 document.queyForm.submit();
}
 
function query()
{
    $("#pages").val(1);
	document.queyForm.action="<%=basePath%>QueryEndProScoreCheck";
	document.queyForm.submit();
}   

function audit(){
       // alert(state);
	 //   var dataForm = $('#proForm').serialize();
	     
		jQuery.ajax({
			url : 'EndprojectUnitCheck',
			data : $('#proForm').serialize(),
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			type : "POST",
			success : function(r) {
			//需要修改为其他地址
			/*
			    var page = $("#pages")[0].value;
			    var checkState = $("#checkState")[0].value;
			    var proName = $("#proName")[0].value;
	            var college = $("#college")[0].value;
	            var t = document.getElementsByName("jqYear")[0]; 
	            var s = document.getElementsByName("jqQici")[0];
                var jqYear=t.options[t.selectedIndex].value;
                var jqQici=s.options[t.selectedIndex].value;
				location="PreEndProScoreAudit?page="+page+"&checkState="+checkState+"&proName="+proName+"&college="+college+"&jqYear="+jqYear+"&jqQici="+jqQici;
			*/
			
			document.queyForm.action="<%=basePath%>QueryEndProScoreCheck";
			document.queyForm.submit();
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
</html>
