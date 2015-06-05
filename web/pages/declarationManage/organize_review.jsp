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
		<title>组织评审</title>
		<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />

		<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
		<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
		

		<script type="text/javascript"></script>
		<script type="text/javascript">
/*	function save() {
	alert("aa");
	    var oDiv = document.getElementById('midbox');
	    var aInput = oDiv.getElementsByTagName('input');
	   // var aInput = $('#text_fabu');
	    alert(aInput.size());
	    var aSpan = $('#checkSpan');
	    for(var i=0;i<aSpan.size();i++)
	    {
	    	if (null!=aSpan[i].value && !aSpan[i].value.equal(""))
	    	{	    	
	    	aInput[i].focus();
	    	alert("a");
	    	return;
	    	}
	    }
	
	   if(true)
	   {
	   //alert("a");
	   return;
	   }
	   
		jQuery.ajax({
			url : 'SendEmails',
			data : $('#emailForm').serialize(),
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			type : "POST",
			success : function(r) {
				//需要修改为其他地址
				location = "index.jsp";
			}
		});
	}
*/
	/**$(function()
	{
		 $('#emailForm').Validform({
	   		tiptype:2
	     });
	});**/
</script>


		<style type="text/css">
/*.doubleselect br {
	display: none;
}
*/

.div2 br {
display: none}

#div1 {
	/*position: absolute;
	left: 600px;
	top: 100px;
	*/
	float: left;
}
</style>


	</head>
	<body>
		<div id="container">
			<jsp:include page="../../header.jsp" ></jsp:include>
			<!--  此处显示 id "maincontent" 的内容-->
			<div id="maincontent" class="h645">
				<s:form action="SendEmails" method="post" name="queyForm" id="emailForm">
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
		   		<jsp:forward  page="../../login.jsp"></jsp:forward>
		   </s:else>
 							<!--中间区域-->
							
							<td width="88%" valign="top"
								style="padding-top: 10px; padding-left: 5px;"
								style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
								<div class="midbox" id="midbox">

									<div class="midbox_gg">
										<div class="zzps">
											组织评审
										</div>
									</div>

									 <table style="font-size: 16px">
									  <tr style="height:30px"></tr>
                                   <tr>
                                   	 <td style="width:100px" align="right">
                                   	 	邮件主题:
                                   	 </td>
                                     <td>
                                        <input type="text" name="emailTitle" id="text_fabu" datatype="*"
												nullmsg="请输入邮件主题" />
                                     </td>
                                     <td>
                                     	
											<span class="Validform_checktip" id="checkSpan">
												
											</span>
									    
                                     </td>
                                   </tr>
                                    <tr style="height:15px"></tr>
								   <tr>
								   	 <td align="right">
								   	 	收件人:
								   	 </td>
								   	 <td>
								   	 	<p>
											<div class="douselect" style="margin-left:10px">
													<s:doubleselect label="请选择年份和期次" name="jqYear"
														list="jieQiYears" listKey="yearKey" listValue="yearValue"
														doubleList="qicis.get(top.yearKey)" doubleName="jieqiId"
														doubleListKey="jqId" doubleListValue="qici"
														cssClass="select_sq" theme="simple" />
												</div>
									    </p>
								   	 </td>
								   </tr>
								    <tr style="height:15px"></tr>
								   <tr>
								   	 <td align="right">
								   		 邮件内容:
								   	 </td>
								   	 <td>
								   	 	<textarea name="emailContent" id="textfield12"  
											style="overflow-y:scroll;width:513px;height:250px;resize:none;margin-left:10px;background-color:#ffffff" datatype="*" nullmsg="请输入邮件内容"></textarea>
								   	 </td>
								   	 <td>
								   	 	
											<span class="Validform_checktip" id="checkSpan">
												
											</span>
									    
								   	 </td>
								   	 
								   </tr>
								   <tr style="height:15px"></tr>
								   <tr>
								   	 <td align="right">
								   	   发送邮箱:
								   	 </td>
								   	 <td>
								   	 	<input type="text" name="senderEmail" id="text_fabu" datatype="e"
												nullmsg="请输入邮箱" errormsg="请输入 正确的邮箱地址"/>
								   	 </td>
								   	 <td>
								   	 	
											<span class="Validform_checktip" id="checkSpan">
												
											</span>
									    
								   	 </td>
								   </tr>
									
								
                                    <tr style="height:15px"></tr>
                                    
                                    <tr>
                                      <td align="right">
                                      	邮箱密码:
                                      </td>
                                      <td>
                                      	<input type="password" name="senderPassword" id="text_fabu" datatype="*"
											nullmsg="请输入邮箱密码"/>
                                      </td>
                                      <td>
                                      	
											<span class="Validform_checktip" id="checkSpan">
												
											</span>
									   
                                      </td>
                                    </tr>
									
                            </table>
                                   <br />
                                   <br />
                                   
									<div class="xia_anniu">
										<ul>
											<li>
												<input name="submit" type="image" value=" " src="images/pinshen_biao2.gif" />
											</li>
											<li>
												<a href="javascript:document.queyForm.reset();" ><img
														src="images/pinshen_biao3.gif" alt="取消" />
												</a>
											</li>
										</ul>
									</div>


								</div>
							</td>

						</tr>
					</table>
				</s:form>
			</div>
			<jsp:include page="../../footer.jsp"></jsp:include>
		</div>
		<script src="<%=path%>/js/jquery-1.9.1.min.js" type="text/javascript"></script>
		<script src="<%=path%>/js/Validform_v5.3.2_min.js" type="text/javascript"></script>
        <script type="text/javascript" src="<%=path%>/js/declaration.js"></script>
		<script type="text/javascript">
	$(function() {
		$('#emailForm').Validform({
			tiptype : 2
		});
	});
	
	
</script>
	</body>
</html>
