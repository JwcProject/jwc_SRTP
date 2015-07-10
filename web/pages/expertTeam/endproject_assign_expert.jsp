﻿<%@ page import="com.opensymphony.xwork2.util.ValueStack" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div id="container">

  <div id="maincontent" class="h645">
	  <table class="table-striped table-bordered table-hover">
			  <h3 class="class="header smaller lighter blue">&nbsp;<s:property value="%{#session.unit.unitName}" />学生SRTP项目结题列表</div>
      <tr>
	  
        <!--中间区域-->
        <td width="88%" valign="top"  style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc" bordercolor="#f4f3f1"  >
		<div class="midbox">

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
		<s:textfield name="proSerial" id="proSerial"/>
		</p>
		</li>
		
		--><li>
		<p>项目名称:
		<s:textfield name="property.projectName" id="proName"/>
		</p>
		</li>
		
<li>
		<p>专业:
			<s:select list="professions" name="property.professionId" headerKey=""
									headerValue="所有" listKey="professionId"
									listValue="professionName"></s:select>
</p>
</li>
<li>
		<p>学号:
		<s:textfield  name="property.studentNumber" id="studentNumebr"/>
</p>
</li>
<li>
		
		<p>审核状态:
		   <s:select list='#{"":"所有","01":"未分派","03":"已分派"}' name="property.endprojectState" id="properties.endprojectState"></s:select>
			
        </p>
<p>
       <s:hidden id="pages" name="page" value="%{page}"></s:hidden>
       <s:hidden id="totalPages" name="totalPage" value="%{totalPage}"></s:hidden>
</p>
</ul>
		</div>
		</s:form>
		<div class="xia_right_sq" style="left: 1005px">
		<img src="<%=path%>/images/gonggaoweihu_icon1.gif" alt="查询" onclick="query();"/></div>
		
		<s:form action="" theme="simple" name="preAssignEndProExp" id="preAssignEndProExp" >
		<div class="xia_list" style="height:200px">
			<table class="table table-striped table-bordered table-hover">
                      <tr>
                        <td>
							<input type="checkbox" name="ALL" id="ALL" onClick="check()"
								value="on"/>&nbsp;&nbsp;项目编号
						</td>
                        <td>项目名称 </td>
                        <td> 申报人 </td>
						<td> 学号 </td>
						<td> 专业 </td>
						<td> 申请日期 </td>
						<td> 分派状态</td>
						                   
						 </tr>
				<s:iterator value="endProjects" id="endProjects" status="stuts">
					<%
						ValueStack vs= (ValueStack) request.getAttribute("struts.valueStack");
						out.println(vs);
					%>
					<s:if test="#stuts.odd == true">
					  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
    				</s:if>
    				<!--判断记号是否为偶数 -->
   					<s:else>
      				  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
    				</s:else>
                        <td style="padding-left:10px" class="NoNewline">
                        <input type="checkbox" name="checkProjects" id="checkProjects" value='<s:property value="#endProjects.endProjectId"/>'/>
                        <label for="music"><s:property value="#endProjects.endProjectNumber" /></label>
                        </td>
                        <td title="<s:property value='#endProjects.TProject.projectName'/>">
                         <s:if test="%{#endProjects.TProject.projectName.length()>15}">
                        	<s:property value="#endProjects.TProject.projectName.substring(0,15)+'...'"/>
                         </s:if>
                         <s:else>
                         	<s:property value="#endProjects.TProject.projectName"/>
                         </s:else>
                        </td>
						<td ><s:property value="#endProjects.TProject.TStudentByProjectLeader.studentName" /> </td>
						<td ><s:property value="#endProjects.TProject.TStudentByProjectLeader.studentNumber" /> </td>
						<td ><s:property value="#endProjects.TProject.TStudentByProjectLeader.TProfession.professionName" /> </td>
						<td >
						<s:if test="null==#endProjects.submitTime||#endProjects.submitTime.isEmpty()">  
						    
						</s:if>
						<s:else>
							<s:date name="#endProjects.submitTime" format="yyyy-MM-dd" />
							<%--<s:text name="global.format.date">
                            <s:param value="#endProjects.schoolTypeinTime"/>
                            </s:text>--%>
						</s:else>
						</td>
						<td >
						<s:if test="#endProjects.endProjectState=='01'">
											未分派
								  		</s:if>
										<s:else>
						         			已分派
						          		</s:else>
						</td>
					 </tr>
				</s:iterator>        
						        
		
	           </table>
	          
	           </div>
	          
	<!-- 	<div class="xia_x_jg"></div> -->
	 <div id="pager" style="padding-left: 600px;position: relative;">
		</div>
			<div class="widget-box">
				<div class="widget-header widget-header-flat">
					<div class="widget-title">分配专家</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<div class="row">
							<div class="col-md-5">
								<p>专家团队</p>

								<p><select name="srcList" multiple style="width: 330px;height: 150px;"
										   ondblclick="move(this.form.srcList,this.form.destList);">
									<s:iterator value="expertTeachers" id="expertTeachers">
										<option>
											<s:property value="#expertTeachers.TTeacher.teaName+'--'"/>
											<s:property value="#expertTeachers.TTeacher.teaCode+'--'"/>
											<s:property value="#expertTeachers.TTeacher.teaTitle"/>
										</option>
									</s:iterator>
								</select>
								</p>
							</div>
							<div class="col-md-2">
								<ul style="margin-top: 50px;">
									<li>
										<a href="javascript:void(0);"
										   onclick="move(getElementsByName('preAssignEndProExp')[0].srcList,getElementsByName('preAssignEndProExp')[0].destList)"
										   name="B1">
											<img src="images/cjzj_anniu1.gif" alt="右" height="26" width="80"/></a>
									</li>
									<li>
										<a href="javascript:void(0);"
										   onclick="move(getElementsByName('preAssignEndProExp')[0].destList,getElementsByName('preAssignEndProExp')[0].srcList)"
										   name="B2">
											<img src="images/cjzj_anniu2.gif" alt="左" height="26" width="80"/></a>
									</li>
									<li>
										<a href="javascript:void(0);"
										   onclick="moveall(getElementsByName('preAssignEndProExp')[0].srcList,getElementsByName('preAssignEndProExp')[0].destList)"
										   name="B3">
											<img src="images/zhuanjia_anniu1.gif" alt="右" height="26" width="80"/></a>
									</li>
									<li>
										<a href="javascript:void(0);"
										   onclick="moveall(getElementsByName('preAssignEndProExp')[0].destList,getElementsByName('preAssignEndProExp')[0].srcList)"
										   name="B4">
											<img src="images/zhuanjia_anniu2.gif" alt="左" height="26" width="80"/></a>
									</li>
								</ul>
							</div>
							<div class="col-md-5">
								<p>专家分派</p>
								<p>
									<select name="destList" style="width: 330px;height:150px;" multiple
											ondblclick="move(this.form.destList,this.form.srcList);">

									</select>
								</p>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		</s:form> 
		<div class="xia_anniu_zj" style="margin-top: 0px">
		<ul>
		<li><a href="javascript:void(0);" onclick="save()"><img src="images/fenpai.png" alt="分派" /></a></li>
		<li><a href="javascript:document.preAssignEndProExp.reset();" ><img src="images/quxiao.png"  alt="取消" /></a></li>
		
		</ul>
		</div>
		
		</div>
		</td>
	</tr>
	</table>
	
  </div>
</div>

<script src="<%=path%>/js/jquery.pager.js" type="text/javascript"/>
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
        }


function changePage(pageclickednumber){
      
     var checkState = $("#checkState")[0].value;
	 var proName = $("#proName")[0].value;
	 var proSerial = $("#proSerial")[0].value;
	  var studentNumebr = $("#studentNumebr")[0].value;

     var r = document.getElementsByName("profession")[0];
	 var t = document.getElementsByName("jqYear")[0]; 
	 var s = document.getElementsByName("jqQici")[0];
     var jqYear=t.options[t.selectedIndex].value;
     var jqQici=s.options[t.selectedIndex].value;
     var profession=r.options[t.selectedIndex].value;
	sendGetAndSetAjax("QueryAssignEndProExpert?page="+pageclickednumber+"&checkState="+checkState+"&proName="+proName+"&proSerial="+proSerial+"&studentNumebr="+studentNumebr+"&profession="+profession+"&jqYear="+jqYear+"&jqQici="+jqQici);
	
	}
 
function query()
{
    $("#pages")[0].value = 1;
	document.queyForm.action="<%=basePath%>QueryAssignEndProExpert";
	postFormAndSetAjax($(document.queyForm));
}

function save() {
		destList = window.document.getElementById("preAssignEndProExp").destList;
		var expertString = "";
		for ( var i = 0; i < destList.length; i++) {
			if (i == destList.length - 1) {
				expertString += destList.options[i].text;
			} else {
				expertString += destList.options[i].text + ",";
			}
		}
		var dataForm = $('#preAssignEndProExp').serialize() + "&experts=" + expertString;
		jQuery.ajax({
			url : 'AssignEndProExpert',
			data : dataForm,
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			type : "POST",
			success : function(r) {
				sendGetAndSetAjax("<%=path%>/PreAssignEndProExpert");
			}
		});
		return false;
	};
	
	function move(fbox, tbox) {
		for ( var i = 0; i < fbox.options.length; i++) {
			if (fbox.options[i].selected && fbox.options[i].value != "") {
				var no = new Option();
				no.value = fbox.options[i].value;
				no.text = fbox.options[i].text;
				tbox.options[tbox.options.length] = no;
				fbox.options[i].value = "";
				fbox.options[i].text = "";
			}
		}
		BumpUp(fbox);

	}

	function moveall(fbox, tbox) {
		for ( var i = 0; i < fbox.options.length; i++) {
			if (fbox.options[i].value != "") {
				var no = new Option();
				no.value = fbox.options[i].value;
				no.text = fbox.options[i].text;
				tbox.options[tbox.options.length] = no;
				fbox.options[i].value = "";
				fbox.options[i].text = "";
			}
		}
		BumpUp(fbox);
		if (sortitems)
			SortD(tbox);
	}

	function BumpUp(box) {
		for ( var i = 0; i < box.options.length; i++) {
			if (box.options[i].value == "") {
				for ( var j = i; j < box.options.length - 1; j++) {
					box.options[j].value = box.options[j + 1].value;
					box.options[j].text = box.options[j + 1].text;
				}
				var ln = i;
				break;
			}
		}
		if (ln < box.options.length) {
			box.options.length -= 1;
			BumpUp(box);
		}
	}

	function SortD(box) {
		var temp_opts = new Array();
		var temp = new Object();
		for ( var i = 0; i < box.options.length; i++) {
			temp_opts[i] = box.options[i];
		}

		for ( var x = 0; x < temp_opts.length - 1; x++) {
			for ( var y = (x + 1); y < temp_opts.length; y++) {
				if (temp_opts[x].text > temp_opts[y].text) {
					temp = temp_opts[x].text;
					temp_opts[x].text = temp_opts[y].text;
					temp_opts[y].text = temp;
					temp = temp_opts[x].value;
					temp_opts[x].value = temp_opts[y].value;
					temp_opts[y].value = temp;
				}
			}
		}

		for ( var i = 0; i < box.options.length; i++) {
			box.options[i].value = temp_opts[i].value;
			box.options[i].text = temp_opts[i].text;
		}
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