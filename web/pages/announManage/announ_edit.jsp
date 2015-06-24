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
<title>编辑公告</title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
<script type="text/javascript" src="<%=path%>/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=path%>/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.MultiFile.js"></script>

<script type="text/javascript">
		$(function(){
			$("input:file").MultiFile({
				 accept: 'doc|pdf|docx|txt|html|htm|jpg|jpeg|gif|bmp|rar|xlsx|xls',
				 max: 5,
				 STRING: {
				     remove: '删除',
				     selected: 'Selecionado: $file',
				     denied: '不支持该类型文件上传, $ext!',
				     duplicate: '该文件已经选择:\n$file!'
				 }
            });
    	});
    	
    	
	</script>
</head>
<body>
<div id="container">
  <jsp:include page="../../header.jsp" ></jsp:include>
  <!--  此处显示 id "maincontent" 的内容-->
  <div id="maincontent" class="h645">
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
        <td width="88%" valign="top"  style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc" bordercolor="#f4f3f1"  >
<form id="announcement" name="announcement" action="UpdateAnnouncement" method="post" enctype="multipart/form-data">
		<div class="midbox">
		<div class="ggzs_wz">
		<input type="hidden" name="announId" value="<s:property value="%{announcement.announId}"/>"/> 
		<div>
		<p style="float:left" >公告名称 ：
		<input type="text" name="announTitle" id="text_fabu" value="<s:property value="%{announcement.announTitle}"/>" style="width: 300px;" datatype="*"
												nullmsg="请输入公告名称" />
												
		</p>
		<p style="float:left;" >
		<span class="Validform_checktip" id="checkSpan">
												
		</span>
		</p>
		</div>
											
	    
		
		<!--  <p style="text-align:center"><b>“重庆大学大学生科研训练计划（SRTP）”项目的通知</b></p>-->
		<div >
		<p style="float:left">内容简介：
		<!--  <p>各学院：</p>-->
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="announContent" id="myEditor" datatype="*"
												nullmsg="请输入内容简介"><s:property value="%{announcement.announContent}"/></textarea>
           </p>
           <p style="float:left;  padding-top: 170px" >
		<span class="Validform_checktip" id="checkSpan">
												
		</span>
		</p>
           </div>
           <script type="text/javascript">
               var editor = new UE.ui.Editor();
               editor.render("myEditor");
           </script>
		<p style="clear:left">附件：
		 <s:iterator value="attachments" id="attachment"><a href="downLoadAttachment?attachementId=<s:property value="attaId" />"><s:property value="fileName" /></a>&nbsp;&nbsp;</s:iterator>
		</p>
		&nbsp;&nbsp;&nbsp;&nbsp;<input type="file" name="files" /><label style="color: red;">* 如需修改附件请重新上传所有附件</label>(支持doc|pdf|docx|txt|html|htm|jpg|jpeg|gif|bmp|rar|xlsx|xls格式，最大附件数：5)
</div>

		<div class="xia_anniu" style="margin-left:30px">
		<ul>
		<li>
		<input name="submit" type="image" value=" " src="images/mima_anniu1.gif"  alt="保存"/>
		</li>
		<li><a href="javascript:document.announcement.reset();"><img src="images/mima_anniu2.gif" alt="取消" /></a></li>
		</ul>
		</div>
		</div>
		</form>
		</td>
          
        
		
	
	</tr>
	</table>
  </div>
  <jsp:include page="../../footer.jsp"></jsp:include>
</div>
</body>
<script src="<%=path%>/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="<%=path%>/js/Validform_v5.3.2_min.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/js/annoument.js"></script>
		<script type="text/javascript">
	$(function() {
		$('#announcement').Validform({
			tiptype : 2
		});
	});
	
	
	</script>
</html>
