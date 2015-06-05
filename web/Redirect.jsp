<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>重庆大学SRTP协作平台</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<style type="text/css">
.info {
	text-indent: 2em;
	margin-top: 10px;
	font-size: 14px;
	font-weight: bold;
	color: #007cd0;
	ine-height: 150%;
	height: 60px;
	overflow-x: hidden;
	overflow-y: auto;
}
</style>
	</head>
	<body>
		<div style="height: 500px"></div>
		<div id="divmessage">
			<%
				String action = request.getParameter("Action");
				String message = request.getParameter("Message");
				String http = request.getParameter("http");
				message = java.net.URLDecoder.decode(message, "UTF-8");

				String url = java.net.URLDecoder.decode(
						request.getParameter("url") != null ? request
								.getParameter("url") : "", "UTF-8");
			%>
			<div class="info"><%=message%></div>
			<div style="float: right; margin-right: 10px">
				<button id="btnOK">
					确 认
				</button>
			</div>
		</div>
		<script type="text/javascript">
		$(function(){
		 	var message="<%=message%>";
		 	
		 	var url="<%=url%>";
		 	if(message){
				showWin = cy.ui.window('divmessage', {
			        title:"信息",
			        height: 100,
			        width: 400,
			        moveable: false,
			        widhMask: true,
			        headerclose:false
			    });
			    showWin.show();
			    
			    $("#btnOK").click(function()
			    {
			    	<%
			    	if(http!=null&&http!="")
			    	{
			    	%>
			    	window.console&&console.log("<%=action%>" + "?url="+ unescape(url));
			    	
			    	window.location.href = unescape("<%=action%>" +  (url?"?url="+ unescape(url):""));
			    	<%}
			    	else
			    	{%>
			    	window.console&&console.log("<%=action%>" + "?url="+ unescape(url));
			    	window.location = "../<%=action%>" + (url?"?url="+ unescape(url):"");
			    	<%}%>
			    });
		    }else{
		    	window.console&&console.log("<%=action%>" + "?url="+ unescape(url));
		    	window.location.href = unescape("<%=action%>"+ url?"?url="+ unescape(url):"");
		    }
		});
	   </script>
	</body>
</html>
