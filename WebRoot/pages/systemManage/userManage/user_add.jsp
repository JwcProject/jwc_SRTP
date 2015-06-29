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
<title>添加用户</title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
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
		<s:form action="AddUser" name="inforForm" id="userForm" method="post" theme="simple" >
		<div class="midbox">
		<div class="midbox_gg">
		<div class="sblb">添加用户</div>
	    </div>
		<div class="ggzs_wz">
		
		
		
		 
		<table align="left" style="margin-left:30px">
		<tr >
		  <td align="right" style="font-size: 18px">登录名:</td>
		  <td align="left">
		  <input type="text" name="user.userId" id="text_fabu" style="width: 300px; font-size: 18px" datatype="*"
												nullmsg="请输入登录名" />
		  </td>
		  <td>
		     <span class="Validform_checktip" id="checkSpan" ></span>
		  </td>
		</tr >
		<tr >
		  <td align="right" style="font-size: 18px">昵称:</td>
		  <td align="left" style="width:305px">
		  <input type="text" name="user.userName" id="text_fabu" style="width: 300px;font-size: 18px" datatype="*"
												nullmsg="请输入昵称" />
		  </td>
		  <td>
		     <span class="Validform_checktip" id="checkSpan" ></span>
		  </td>
		</tr>
		<tr >
		  <td align="right" style="font-size: 18px">密码:</td>
		  <td align="left">
		  <input type="text" name="userPassword" id="text_fabu" style="width: 300px;font-size: 18px" datatype="*"
												nullmsg="请输入密码" />
		  </td>
		  <td>
		     <span class="Validform_checktip" id="checkSpan" ></span>
		  </td>
		</tr>
		<tr >
		  <td align="right" style="font-size: 18px">确认密码:</td>
		  <td align="left">
		  <s:textfield name="user.userPassword" id="text_fabu" style="width: 300px;font-size: 18px" datatype="*"
								recheck="userPassword" nullmsg="请输入确认密码" />
		  </td>
		  <td>
		     <span class="Validform_checktip" id="checkSpan" ></span>
		  </td>
		</tr>
		<tr >
		   <td align="right" style="font-size: 18px">用户类型:</td>
		   <td align="left">
		   <s:radio name="user.userType" cssStyle="font-size:18px" list="#{'00':'教务处领导','01':'教务处主管教师','02':'学院领导','03':'学院主管教师','05':'普通教师','06':'学生'}" value="'06'" ></s:radio>
		   </td>
		   <td>
		     <span class="Validform_checktip" id="checkSpan" ></span>
		  </td>
		</tr>
		
		<tr >
			<td align="right" style="font-size: 18px">用户简介:</td>
			<td align="left" >
				<s:textarea name="user.userIntroduction" cssStyle="width: 300px;resize:none;margin-left:10px;overflow-y:scroll" datatype="*"
												nullmsg="请输入用户简介" />
			</td>
			 <td>
		     <span class="Validform_checktip" id="checkSpan" ></span>
		  </td>
		</tr>
		</table>
		
</div>
		<div class="xia_anniu" style="margin-left:130px">
		<ul>
		<li><input type="image" name="submit" src="<%=path%>/images/mima_anniu1.gif" alt="提交" /></li>
		<!-- <li><a href="javascript:document.inforForm.reset();" ><img src="<%=path%>/images/mima_anniu2.gif" alt="取消" /></a></li> -->
		<li><input type="reset" value="" style="background:url(<%=path%>/images/mima_anniu2.gif); border:0px; width:103px; height:26px;" /></li>
		</ul>
		</div>
		</div>
		</s:form>
		</td>
          
        
		
	
	</tr>
	</table>
  </div>
 <jsp:include page="../../../footer.jsp" ></jsp:include>
</div>
<script src="<%=path%>/js/Validform_v5.3.2_min.js" type="text/javascript"></script>
<script src="<%=path%>/js/system.js" type="text/javascript"></script>
<script type="text/javascript">

	
	$(function() {
		$('#userForm').Validform({
			tiptype : 2
		});
	});
</script>
</body>

</html>
