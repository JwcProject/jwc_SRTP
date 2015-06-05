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
<title>查看用户</title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
</head>
<body>
<div id="container">
  
<jsp:include page="../../../header.jsp" ></jsp:include>
  <!--  此处显示 id "maincontent" 的内容-->
  <div id="maincontent" class="h645">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
	  
        <!--  左边区域-->
         <jsp:include page="../../../dean_left.jsp" ></jsp:include>
		  
        <!--中间区域-->
        <td width="88%" valign="top"  style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc" bordercolor="#f4f3f1"  >
		<div class="midbox">
		<div class="midbox_gg">
		<div class="sblb">用户基本信息</div>
	    </div>
		<div class="ggzs_wz">
		<p>登录名：<s:property value="user.userId" /></p>
		<p>昵称：<s:property value="user.userName" /></p>
		<p>用户类型：
          <s:if test="user.userType=='00'">
											教务处领导
								  </s:if> 
						          <s:elseif test="user.userType=='01'">
						         			教务处主管教师
						          </s:elseif>	
									<s:elseif test="user.userType=='02'">
						         			 学院领导
						          </s:elseif>
						          <s:elseif test="user.userType=='03'">
						         			 学院主管教师
						          </s:elseif>	
									<s:elseif test="user.userType=='04'">
						         			评审教师
						          </s:elseif>
						          <s:elseif test="user.userType=='05'">
						         			 普通教师
						          </s:elseif>
						          <s:elseif test="user.userType=='06'">
						         			普通学生
						          </s:elseif>
						          <s:elseif test="user.userType=='07'">
						         			 项目成员
						          </s:elseif>
						          <s:elseif test="user.userType=='08'">
						         			 项目组长
						          </s:elseif>
						          <s:else>
						         			 错误代码
						          </s:else>
        </p>
		<p>登录状态：
		<s:if test="user.userState=='NN'">
											离线
								  </s:if> 
						          <s:elseif test="user.userState=='YY'">
						         			 在线
						          </s:elseif>	
									
						          <s:else>
						         			 错误代码
						          </s:else>
		</p>
		<p>用户简介：<s:property value="user.userIntroduction" /></p>
		
		
		
		
		
</div>
		<div class="xia_anniu" style="margin-left:30px">
		<ul>
		<li><a href="#" onclick="window.opener=null;window.close(this);" ><img src="<%=path%>/images/close.png" alt="关闭" /></a></li>
		
		</ul>
		</div>
		</div>
		</td>
          
        
		
	
	</tr>
	</table>
  </div>
   <jsp:include page="../../../footer.jsp" ></jsp:include>
</div>
<script src="<%=path%>/js/system.js" type="text/javascript"></script>
</body>
</html>
