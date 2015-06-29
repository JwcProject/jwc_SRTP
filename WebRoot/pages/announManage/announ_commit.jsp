<%@page import="com.isse.model.TUser"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>公告管理-发布公告</title>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
		<script type="text/javascript" src="<%=path%>/ueditor/ueditor.config.js"></script>
        <script type="text/javascript" src="<%=path%>/ueditor/ueditor.all.js"></script>
        <link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
        <!--这个js是用来控制页面中出现png图片能兼容浏览区-->
        <script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
        <link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
        <style type="text/css">
           .mutiFile br{
              display: none;
           }
        </style>
		<script type="text/javascript">
        function save()
		{
		   //alert("save");
		   //var isValid = $('#announcement').form('validate');
		   //alert(isValid);
		   if($('#text_fabu').val() == ""){
		      $('#text_fabu').focus();
		   }else{
		      document.announcement.action = "<%=basePath%>SaveAnnouncement";
			  document.announcement.submit();
		   } 
		}

		function commit()
		{
		    
		    //var isValid = $('#announcement').form('validate');
		    //alert(isValid);
		    if($('#text_fabu').val() == ""){
		       $('#text_fabu').focus();
		    }else{
		    //alert("commit");
		       document.announcement.action = "<%=basePath%>CommitAnnouncement";
			   document.announcement.submit();
		    }	
		}
		</script>
	</head>
<body>
<div id="container">
  <jsp:include page="../../header.jsp" ></jsp:include>
  <!--  此处显示 id "maincontent" 的内容-->
  <div id="maincontent" class="h645">
    <form id="announcement" name="announcement" action="" method="post" enctype="multipart/form-data">
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
		<div class="midbox">
		<div class="midbox_gg">
		<div class="ggwh">发布公告</div>
	    </div>
		<div class="xia_gg">
		<p>公告名称:
		<input type="text" name="announcement.announTitle" id="text_fabu" datatype="*2-200" sucmsg="验证通过" nullmsg="请输入公告名称" errormsg="请输入2-200个任意字符"/> 
		
		</p>

		</div>
		
		<div class="xia_gg" style="position: relative;top:-10px;">
			<p>内容简介:
			 <textarea name="announcement.announContent" id="myEditor" datatype="*2-4000" sucmsg="验证通过" nullmsg="请输入公告内容" errormsg="请输入2-4000个任意字符">输入您的公告内容......</textarea>
             <script type="text/javascript">
               var editor = new UE.ui.Editor();
               editor.render("myEditor");
             </script>  
             <div class="Validform_checktip" ></div>
		</p>
		
		
        <div class="">
		    <div class="mutFile" style="position:relative;float: left;">
			   <p>上传附件:
		          <input type="file" name="files"/>
		       </p>
		       <div class="xia_gg_right"><a href="javascript:void(0)"><img src="<%=path%>/images/fabugonggao_wjj.gif" alt="上传文件" /></a>（支持doc|pdf|docx|txt|html|htm|jpg|jpeg|gif|bmp|rar|xlsx|xls格式，最大附件数：5）</div>
		    </div>
		</div>

		<div class="xia_anniu">
		<ul>
		<li><a href="javascript:void(0);" onclick="commit();"><img src="<%=path%>/images/gonggaofabu_anniu1.gif" alt="发布" /></a></li>
		<li><a href="javascript:void(0);" onclick="save();"><img src="<%=path%>/images/save.png" alt="保存" /></a></li>
		
		</ul>
		</div>
		</div>
		</td>
          
        
		
	
	</tr>
	</table>
	</form>
  </div>
<jsp:include page="../../footer.jsp"></jsp:include>
</div>
    
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
    <script type="text/javascript" src="<%=path%>/js/Validform_v5.3.2_min.js"></script>
    <script type="text/javascript" src="js/annoument.js"></script>
    <script type="text/javascript">
        $(function(){
             $("#announcement").Validform({
                  tiptype:4
             });
        });
        
       
   </script>
</body>
</html>
