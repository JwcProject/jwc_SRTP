<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>信息提示</title>
    
	<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/js//themes/icon.css" rel="stylesheet" type="text/css" >  
	
	<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>  
    <script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script> 
    <script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
  </head>
  
  <body>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<div id="abc" class="tipsClass" style="background:8FBC8F;padding:20px;position:absolute; left:92px; top:38px; width:200px; height:169px; z-index:1">
  	</div>
    <script type="text/javascript">
    
    	//$.messager.alert('提示','当前数据执出现一个小错误，请您稍后再试或与管理员联系!','error');
    	
		var i=5;
		clock();
		
		function closewin()
		{
			self.opener=null;
			self.close();
		}
		function clock()
		{
			i=i-1;
			var tips = "当前数据执出现一个小错误，请您稍后再试或与管理员联系!<br>本窗口将在" + i + "秒后自动关闭!";
			document.title="本窗口将在" + i + "秒后自动关闭!";
			
			var windowWidth = document.documentElement.clientWidth;
			var windowHeight = document.documentElement.clientHeight;
			document.getElementById("abc").innerHTML= tips;
	    	
	    	$('div.tipsClass').css({
		    	'top' : (windowHeight/3) + 'px',
		    	'left' : ( windowWidth / 3 )+ 'px',
		    	'position' : 'absolute',
		    	'padding' : '3px 5px',
		    	'background': '#8FBC8F',
		    	'font-size' : 18 + 'px',
		    	'margin' : '0 auto',
		    	'text-align': 'center',
		    	'width' : 'auto',
		    	'color' : '#fff',
		    	'opacity' : '0.8'
	    	}).show();
	    	
			if(i>0)setTimeout("clock();",1000);
			else closewin();
		}
		
    	//history.back();
    </script>
  </body>
</html>
