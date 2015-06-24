<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
    <title>登录</title>
    
	<link href="<%=path%>/css/css2.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
    <script src="<%=path%>/js/iepng.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
           var url = "<%=path%>/listDeanRecentAnnouncement";
           $.ajax({
    		url : url,
    		success : function(r) {
    			if (r) {				   				
					var announcements = r;
					var annountceHtml = "";
					for(var i in announcements){
					   var time = announcements[i].publishTime.substring(0,10);
					   annountceHtml += "<li><a title=\""+announcements[i].announTitle+"\" href=\"ViewLoginAnnouncement?announId="+announcements[i].announId+"\" target=\"_blank\">&gt;"+announcements[i].announTitle+"&nbsp;&nbsp;"+time+"</a></li>";
					}
					$('#announcements').html(annountceHtml);
    			}
    		}
    		
    	  });	
        });
    </script>
  </head>
  
  <body>
    <div class="content">
		  <div class="logo">
		  <h1><a href="#" target="_blank" title="重庆大学SRTP协助平台"><img src="<%=path%>/images/login/logo.png" alt="重庆大学SRTP协助平台" /></a></h1>
		  </div>
	
		<div class="denglu">
		<div class="zuo">
		   <h1>通知公告</h1>
		  
		     <ul id="announcements">
		        
		     </ul>
		</div>
		<form action="userLogin" id="loginForm" method="post">
		<div class="you">
				<div class="kuang1"></div>
                <div class="kuang2">
				     <label for="name">用户名：</label>
				     <input style="width: 140px;" type="text" value="${userId}" name="userId" id="userId" class="cxinput" datatype="*" sucmsg="验证通过" nullmsg="请输入用户名" errormsg="请输入用户名"/>
				</div>			
	        <div class="kuang2">
			    <label for="password">密　码：</label>
		        <input style="width: 140px;" type="password" value="${password}" name="password" id="password" class="cxinput" datatype="*" sucmsg="验证通过" nullmsg="请输入密码"/>
		    </div>
			<div class="kuang2" style="position: relative;top:-10px;">
			    <label for="validateCode">验证码：</label>
		        <input type="text" style="width: 80px;" name="validateCode" id="validateCode" class="cxinput"/>
		        <img height='30' width="60" style="position:relative;top:10px" src="${pageContext.request.contextPath}/validateCode.img" 
                     onclick="this.src='${pageContext.request.contextPath}/validateCode.img?'+Math.random();" /><a href="javascript:void(0);" style="color: blue;text-decoration: underline;padding-left: 5px;">点击图片换一张</a>
		    </div>	
		    <div class="kuang2" style="position: relative;top:-10px;">
			    <input type="checkbox" name="wmima" id="wmima" /><label for="music">记住密码&nbsp;&nbsp;&nbsp;<a href="#">忘记密码</a></label> 
		    </div>
		    <div class="kuang2" style="position: relative;top:-10px;">
			    <input type="submit" name="button" class="bt01" id="button" value="立即登录" /><label style="color: red;font-size: 9pt">${msg}</label>
		    </div> 
		</div>
		</form>
     </div>
  </div>
<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">
$(function(){
   $("#loginForm").Validform({
       tiptype:3
   });
});
</script>
  </body>
</html>
