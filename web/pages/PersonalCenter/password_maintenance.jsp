<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生</title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
<style type="text/css">
.title{
   border-color: #E6E6E6;
   border-bottom-width: 0px;
   border-left-width: 0px;
   border-right-width: 0px;
   padding:0px;
}
.f_head{
   color: #333;
   font-size: 14px;
   font-weight: bold;
}
.info_box{
   text-align: left;
   color: #333;
}
.line_box{
   height: 30px;
   display: block;
   clear: both;
}
.line_box_left{
   color: gray;
   width: 53px;
   float: left;
}
.line_box_right{
   float: left;
   padding-left: 20px;
}
.passwordStrength{
    margin-bottom: 5px;
    margin-top: 5px;
}
.passwordStrength b{
	font-weight:normal;
}
.passwordStrength b,.passwordStrength span{
	display:inline-block; 
	vertical-align:middle;
	line-height:16px;
	line-height:18px\9;
	height:16px;
}
.passwordStrength span{
	width:45px; 
	text-align:center; 
	background-color:#d0d0d0; 
	border-right:1px solid #fff;
}
.passwordStrength .last{
	border-right:none;
}
.passwordStrength .bgStrength{
	color:#fff;
	background-color:#71b83d;
}
</style>
</head>
<body>
<div id="container">
  <jsp:include page="../../header.jsp"></jsp:include>
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
		   		<script type="text/javascript">
		   		    location.href = "../../login.jsp";
		   		</script>
		   </s:else>
        <!--中间区域-->
        <td width="88%" valign="top" >
       <!-- 公告区域-->
        <table width="100%" border="0" cellspacing="0" cellpadding="0"  align="right" >
            <tr>
              <td>
                <div style="text-align: center;margin-left: auto;margin-right: auto;width: 75%;">
                 <div>
                     <h1 style="margin-top: 20px;">个人信息维护</h1>
                 </div>
                 <div class="info_box">
                     <fieldset class="title">
                        <legend class="f_head">基本信息</legend>
                     </fieldset>
                     <div style="display: block;margin-top: 10px;">
                     <div class="line_box">
                        <div class="line_box_left" align="right">姓名</div>
                        <div class="line_box_right"><s:property value="#session.user.userName"/></div>
                     </div>
                     <div class="line_box">
                        <div class="line_box_left" align="right">学号</div>
                        <div class="line_box_right"><s:property value="#session.user.userId"/></div>
                     </div>
                     <s:if test="%{#session.user.userType == '06' || #session.user.userType == '07' || #session.user.userType == '08'}">                    
                     <div class="line_box">
                        <div class="line_box_left" align="right">学院</div>
                        <div class="line_box_right"><s:property value="%{student.TUnit.unitName}"/></div>
                     </div>
                     <div class="line_box">
                        <div class="line_box_left" align="right">性别</div>
                        <div class="line_box_right"><s:if test="%{student.studentSex == 01}">男</s:if><s:else>女</s:else></div>
                     </div>
                     <div class="line_box">
                        <div class="line_box_left" align="right">生日</div>
                        <div class="line_box_right"><s:date name="student.studentBirthday" format="yyyy-MM-dd"/></div>
                     </div>
                     <div class="line_box">
                        <div class="line_box_left" align="right">邮箱</div>
                        <div class="line_box_right"><s:property value="%{student.studentEmail}"/></div>
                     </div>
                     <div class="line_box">
                        <div class="line_box_left" align="right">电话</div>
                        <div class="line_box_right"><s:date name="student.studentTelphone" format="yyyy-MM-dd"/></div>
                     </div>
                     </s:if>
                     <s:else>                 
                     <div class="line_box">
                        <div class="line_box_left" align="right">学院</div>
                        <div class="line_box_right"><s:property value="%{teacher.TUnit.unitName}"/></div>
                     </div>
                     <div class="line_box">
                        <div class="line_box_left" align="right">性别</div>
                        <div class="line_box_right"><s:if test="%{teacher.teaSex == 01}">男</s:if><s:else>女</s:else></div>
                     </div>
                     <div class="line_box">
                        <div class="line_box_left" align="right">职称</div>
                        <div class="line_box_right"><s:property value="%{teacher.teaTitle}"/></div>
                     </div>
                     <div class="line_box">
                        <div class="line_box_left" align="right">邮箱</div>
                        <div class="line_box_right"><s:property value="%{teacher.teaEmail}"/></div>
                     </div>
                     <div class="line_box">
                        <div class="line_box_left" align="right">电话</div>
                        <div class="line_box_right"><s:property value="teacher.teaTele"/></div>
                     </div>
                     <div class="line_box">
                        <div class="line_box_left" align="right">简介</div>
                        <div class="line_box_right"><s:property value="teacher.teaIntro"/></div>
                     </div>
                     </s:else>
                     <div style="clear: both;"></div>
                     </div>
                 </div>
                 <div class="info_box">
                     <fieldset class="title">
                        <legend class="f_head">账号安全</legend>
                     </fieldset>
                     <form action="changePassword" id="changeForm">
                     <input  type="hidden" name="userId" value="<s:property value="#session.user.userId"/>"/> 
                     <div style="display: block;margin-top: 10px;">
                     <div class="line_box">
                        <div class="line_box_left" align="right">原密码</div>
                        <div class="line_box_right"><input type="password" name="password"/></div>
                     </div>
                     <div class="line_box">
                        <div class="line_box_left" align="right">新密码</div>
                        <div class="line_box_right">
                            <input type="password" name="newPassword" class="inputxt" plugin="passwordStrength"  datatype="*6-18" errormsg="密码至少6个字符,最多18个字符！"/>
                            <div class="passwordStrength">密码强度： <span>弱</span><span>中</span><span class="last">强</span></div>                                                       
                        </div>  
                        <div></div>                                            
                     </div>                     
                     <div class="line_box">
                        <div class="line_box_left" align="right">重复密码</div>
                        <div class="line_box_right"><input type="password" name="rpassword" class="inputxt" recheck="newPassword"  datatype="*6-18" errormsg="两次输入的密码不一致！"/></div>
                        <div></div>
                     </div>
                     <input  type="submit" value="确认修改" style="margin-left: 100px;"/>
                     </div>
                     </form>
                 </div>
               </div>
              </td>
            </tr>
          </table></td>
      </tr>
    </table>
  </div>
  <jsp:include page="../../footer.jsp"></jsp:include>
</div>
<script type="text/javascript" src="<%=path%>/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=path%>/js/passwordStrength-min.js"></script>
 <script type="text/javascript">
       $(document).ready(function(){  	   
	       $("#Left_menu .menu_body:last").show();	
	       $("#changeForm").Validform({
	   		tiptype:2,
	   		usePlugin:{
	   			passwordstrength:{
	   				minLen:6,
	   				maxLen:18
	   			}
	   		},
	   		ajaxPost:true,
			callback:function(data){
				if(data == true){
					setTimeout(function(){
						$.Hidemsg(); //公用方法关闭信息提示框;显示方法是$.Showmsg("message goes here.");
						alert('修改成功');
					},2000);					
				}
				if(data == false){
					$.Hidemsg();
					alert('输入的原密码错误');
				}
			}
	   	});
       });
 </script>
</body>
</html>
