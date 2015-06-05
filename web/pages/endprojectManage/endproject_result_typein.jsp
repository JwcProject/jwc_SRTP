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
<title>成绩录入</title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/Pager.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    
</head>
<body>
<div id="container">
  <jsp:include page="../../header.jsp" ></jsp:include>
  <!--  此处显示 id "maincontent" 的内容-->
  <div id="maincontent" class="h645">
 
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
	  
        <!--  左边区域-->
        
		 <jsp:include page="../../teacher_left.jsp"></jsp:include>
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
		
		<li>
		<p>项目名称:
		<s:textfield name="proNaproperty.projectNameme" id="proName" style="width:88px;height:14px" /> 
		</p>
		</li>
		
<li>
		<p>专业:
			<s:select list="professions" name="property.professionId" headerKey=""
									headerValue="所有" listKey="professionName"
									listValue="professionName"></s:select>
</p>
</li>
<li>
		<p>学号:
		<s:textfield  name="property.studentNumber" id="studentNumebr" style="width:88px;height:14px"/> 
</p>
</li>
<li>
		
		<p>状态:
		   <s:select list='#{"03":"结题中","04":"教务处审核"}' name="property.endprojectState" id="checkState" onchange="IsShowButton()"></s:select>
			
        </p>
<p>
       <s:hidden id="pages" name="page" value="%{page}"></s:hidden>
       <s:hidden id="totalPages" name="totalPage" value="%{totalPage}"></s:hidden>
</p>
</ul>
		</div>
		</s:form>
		<div class="xia_right_sq" style="left: 1005px">
		<img src="images/gonggaoweihu_icon1.gif" alt="查询" onclick="query();"/></div>
		
		<s:form action="" theme="simple" id="resultTypeIn">
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
						<td bgcolor="#FFFFFF" width="9%"> |期数 </td>
						<td bgcolor="#FFFFFF" width="9%"> |结题状态 </td>
						<td bgcolor="#FFFFFF" width="9%"> |成绩 </td>
						<td bgcolor="#FFFFFF" width="15%"> |结题评语 </td>                     
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
						 <td ><s:property value="#endProjects.TJieqi.jqYear+'年，第'+#endProjects.TJieqi.qici+'期'" /> </td>
						 <td>
						 	<s:hidden id="projectStates" name="projectStates" value="%{#endProjects.endprojectState}"></s:hidden>
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
						<td bgcolor="#eef7ff" >
							<s:if test="%{#endProjects.endprojectState=='03'}">
								<s:if test="#endProjects.endprojectComment !=null">
									<s:a href="preUnitTeaAddEndProCom?endprojectId=%{#endProjects.endprojectId}"  >
										<img src="images/edit.gif" alt="编辑" />
									</s:a>
								</s:if>
								<s:else>
									<s:a href="preUnitTeaAddEndProCom?endprojectId=%{#endProjects.endprojectId}" >
										<img src="images/tianjia.gif" alt="添加" />
									</s:a>
								</s:else>
							</s:if>
							<s:else>
								<s:a href="EndProjectDetail?endprojectId=%{#endProjects.endprojectId}" ><img src="<%=path%>/images/shenbiaoliebiao_icon1.gif" alt="查看" /></s:a>
							</s:else>
						</td>                    
					 </tr>
				</s:iterator>        
						        
		
	           </table>
	          
	           </div>
	           </s:form>
		<div class="xia_x_jg">
		<div id="buttons">
			<ul>
				<li><a  onclick="audit('01');"><img src="images/you.png" alt="优秀" /></a></li>
				<li><a  onclick="audit('02');"><img src="images/liang.png" alt="良好" /></a></li>
				<li><a  onclick="audit('03');"><img src="images/zhong.png" alt="中等" /></a></li>
				<li><a  onclick="audit('04');"><img src="images/jige.png" alt="及格" /></a></li>
				<li><a  onclick="audit('05');"><img src="images/bujige.png" alt="不及格" /></a></li>
			</ul>
		</div>
		
		<div id="msg" style="display:none">
			<ul>
				<li style="color:red">温馨提示：【教务处审核】状态下的项目不能录入成绩，请选择【结题中】的项目录入</li>
			</ul>
		</div>
		
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
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
<script type="text/javascript" src="<%=path%>/js/endproject.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>  
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" language="javascript">
  $(document).ready(function() {
	  		IsShowButton();
            var page = $("#pages")[0].value;
            var totalPage = $("#totalPages")[0].value;
            $("#pager").pager({ pagenumber: page, pagecount: totalPage, buttonClickCallback: PageClick });
        });

        PageClick = function(pageclickednumber) {
            var totalPage = $("#totalPages")[0].value;
            $("#pager").pager({ pagenumber: pageclickednumber, pagecount: totalPage, buttonClickCallback: PageClick });
            changePage(pageclickednumber);
        };

function IsShowButton()
{
	var tmpState = $("#checkState").val();
	if('03' == tmpState)
	{
		document.getElementById('buttons').style.display = "";
		document.getElementById('msg').style.display = "none";
	}
	else if('04' == tmpState)
	{
		document.getElementById('buttons').style.display = "none";
		document.getElementById('msg').style.display = "";
	}
}
function changePage(pageclickednumber){
      
	/*
     var checkState = $("#checkState")[0].value;
	 var proName = $("#proName")[0].value;
	 //var proSerial = $("#proSerial")[0].value;
	  var studentNumebr = $("#studentNumebr")[0].value;

     var r = document.getElementsByName("profession")[0];
	 var t = document.getElementsByName("jqYear")[0]; 
	 var s = document.getElementsByName("jqQici")[0];
     var jqYear=t.options[t.selectedIndex].value;
     var jqQici=s.options[t.selectedIndex].value;
     var profession=r.options[t.selectedIndex].value;
     location="QueryEndProScoreTypeIn?page="+pageclickednumber+"&checkState="+checkState+"&proName="+proName+"&studentNumebr="+studentNumebr+"&profession="+profession+"&jqYear="+jqYear+"&jqQici="+jqQici;
     */
    
    $("#pages").val(pageclickednumber);
	document.queyForm.action="<%=basePath%>QueryEndProScoreTypeIn";
	document.queyForm.submit();
}
 
function query()
{
    $("#pages")[0].value = 1;
	document.queyForm.action="<%=basePath%>QueryEndProScoreTypeIn";
	document.queyForm.submit();
}   

function audit(state)
{
	var isChecked = false;
	var isValide  = true;
	var cbx=document.getElementsByName("checkProjects");
	var states=document.getElementsByName("projectStates");
	var i = 0;
	for(i=0; i < cbx.length; ++i)
	{
		if(cbx[i].checked == true)
		{
			isChecked = true;
			if(states[i] != '03')
			{
				isValide = false;
				break;
			}
		}
	}
	
	if(isChecked)
	{
		if(isValide)
		{
		    var dataForm = $('#resultTypeIn').serialize() + "&checkState=" + state;
			jQuery.ajax({
				url : 'EndProScoreTypeIn',
				data : dataForm,
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				type : "POST",
				success : function(r) {
					document.queyForm.action="<%=basePath%>QueryEndProScoreTypeIn";
					document.queyForm.submit();
				}
			});
		}
		else
		{
			i += 1;
			$.messager.alert('提示', '选择的第 '+ i +' 个项目不能录入成绩，请选择【结题中】的项目', 'warning');
		}
	}
	else
	{
		$.messager.alert('提示', '请至少选择一个项目', 'warning');
	}
}
	
/*	function seeForm(){
		location = "PreEndProScoreAudit";
	}*/
	//添加评审意见
	function addOpinion(id){
	    alert(id);
		location="DeclRevieOpinion?id="+id;
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
