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

	  <table class="table table-striped table-bordered table-hover">
		<h3 class="header smaller lighter blue">个人项目结题列表</h3>
      <tr>

        <!--中间区域-->
        <td width="88%" valign="top"  style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc" bordercolor="#f4f3f1"  >
		<div class="midbox">
		<s:form action="" theme="simple" id="proForm">
		<div class="xia_list" style="margin-top: 35px">

			<table class="table table-striped table-bordered table-hover">
                      <tr>
						<td>项目编号</td>
                        <td> 项目名称 </td>
                        <td> 期次 </td>
                        <td> 负责人 </td>
						<td> 所属学院 </td>
						<td> 结题时间 </td>
						<td> 结题状态 </td>
						<td> 成绩 </td>
						<td> 可得学分 </td>
						<td> 操作 </td>
						 </tr>
				<s:iterator value="endProjects" id="endProjects" status="stuts"> 
					<s:if test="#stuts.odd == true">
					  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
    				</s:if>
    				<!--判断记号是否为偶数 -->
   					<s:else>
      				  <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
    				</s:else>
                        <td style="padding-left:10px" class="NoNewline"><s:property value="#endProjects.endprojectNumber" /></td>
                        <td title="<s:property value='#endProjects.endprojectName' />">
                        <s:if test="%{#endProjects.endprojectName.length()>20}">
    				    	<s:property value="%{#endProjects.endprojectName.substring(0,20)+'...'}" escape="#onlineList.frmTitle"/>
    				    </s:if>
    				    <s:else>
    				    	<s:property value="#endProjects.endprojectName" />
    				    </s:else>
                        <td ><s:property value="#endProjects.TJieqi.jqYear+'年，第'+#endProjects.TJieqi.qici+'期'" /> </td>
						<td ><s:property value="#endProjects.TProject.TStudentByProjectLeader.studentName" /> </td>
						<td ><s:property value="#endProjects.TProject.TStudentByProjectLeader.TUnit.unitName" /> </td>
						<td >
						<s:if test="null==#endProjects.schoolTypeinTime||#endProjects.schoolTypeinTime.isEmpty()">  
						    
						</s:if>
						<s:else>
						    <s:text name="global.format.date">
							<s:param value="#endProjects.schoolTypeinTime"/>
							</s:text>
						</s:else>
						</td>
						<td >
							<s:if test="#endProjects.endprojectState=='01'">
								结题已提交
					  		</s:if>
							<s:elseif test="#endProjects.endprojectState=='02'">
			         			 申请未通过
			          		</s:elseif>
			          		<s:elseif test="#endProjects.endprojectState=='03'">
			         			 结题中
			          		</s:elseif>
			          		<s:elseif test="#endProjects.endprojectState=='04'">
			         			 结题中
			          		</s:elseif>
			          		<s:elseif test="#endProjects.endprojectState=='05'">
			         			 参加二次答辩
			          		</s:elseif>
			          		<s:elseif test="#endProjects.endprojectState=='06'">
			         			已结题
			          		</s:elseif>
						</td>
						<td > 
							<s:if test="#endProjects.lastScore !=null">
											<s:property value="#endProjects.lastScore" />
										</s:if>
										<s:else>
											<s:property value="#endProjects.endprojectScore" />
										</s:else>
						</td>
						<td ><s:property value="#endProjects.endprojectCredit" /> </td>
						<td bgcolor="#eef7ff" >
								<s:a href="EndProjectDetail?endprojectId=%{#endProjects.endprojectId}"  >
									<img src="images/shenbiaoliebiao_icon1.gif" alt="查看" />
								</s:a>
						</td>                    
					 </tr>
				</s:iterator>        
						        
		
	           </table>
	          
	           </div>
	           </s:form>
		
		 
		</div>
		</td>
          
        
		
	
	</tr>
	</table>
	
  </div>
</div>
<script type="text/javascript" src="<%=path%>/js/endproject.js"></script>
