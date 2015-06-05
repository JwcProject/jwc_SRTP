<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网络评审</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<style type="text/css">
html,body{}
body{ background-repeat: repeat-y; background-position: 15px 0px; background-color: rgb(255, 255, 255); overflow-x: hidden; overflow-y:auto;}
.mytable {border-collapse:collapse;border:solid #6AA70B;border-width:0px 0 0 0px; margin:0px; padding:0px;}
.mytable ul li {list-style:none;font-family: "Verdana,宋体";font-size: 12px;color:#333;text-align:left; line-height:25px; margin:0px; padding:0px;overflow:hidden;zoom:1;}
.mytable ul li a{ text-decoration:none;float:left; display:inline-block; }
.mytable ul li span{ float:left; }
a.link80{ color:#06C; text-align:center; width:80px;}
a.link40{ color:#333; text-align:center; width:40px;}
a.link50{ color:#F30; text-align:center; width:50px;}
a.link100{ color:#333; text-align:left; width:600px; word-break:break-all; /*支持IE，chrome，FF不支持*/word-wrap:break-word;/*支持IE，chrome，FF*/}
.mytable ul li.t1 {background-color:#edf5fa;}/* 第一行的背景色 */
.mytable ul li.t2{background-color:#ffffff;}/* 第二行的背景色 */
.mytable ul li.t3 {background-color:#e5eff5;}/* 鼠标经过时的背景色 */
.logo{margin-top:0;}
</style>

<script src="<%=path%>/js/jquery-1.js"></script> 
<script src="<%=path%>/js/jquery-1.4.4.min.js"></script> 
<script type="text/javascript">
	    function saveComment(){
	    	$('#opinionForm').submit();   
	    }
</script>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/css1.css" />
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="container">
   <jsp:include page="../../header.jsp"></jsp:include>
   <!--  此处显示 id "maincontent" 的内容-->
   <div id="maincontent" class="h645">
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
           <tr>
              <!--  左边区域-->
              <jsp:include page="../../reviewTeacher_left.jsp"></jsp:include>
              <!--中间区域-->
              <td width="88%" valign="top" >
                  <div class="cxCalendarHead" id="content">
  
  <table class="cx_tablemain" border="1" bordercolor="#a9cfe2" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td class="cx_table"><div class="cx_title">结题网评表</div></td>
    </tr>
    <tr>
    	<td align="left" class="dbtitle"><div class="cx_title2">项目信息</div></td>
    </tr>
    <tr>
      <td height="35">
      <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="33%" height="25">项目名称：<s:property value="endProjectComment.TEndProjectExport.TEndProject.endprojectName" /></td>
          <s:hidden name="endprojectId" value="endProjectComment.TEndProjectExport.TEndProject.endprojectId"></s:hidden>
          <td width="34%" height="25">项目开展所在实验室：
			   <s:if test="endProjectComment.TEndProjectExport.TEndProject.TProject.projectLabtype=='01'">校级实验室</s:if> 
			   <s:elseif test="endProjectComment.TEndProjectExport.TEndProject.TProject.projectLabtype=='02'">院级实验室</s:elseif>
			   <s:elseif test="endProjectComment.TEndProjectExport.TEndProject.TProject.projectLabtype=='03'">其他实验室</s:elseif>	
			   <s:else> 错误代码</s:else></td>
		</tr>
		<tr>
		  <td width="33%" height="25">实验室名称：<s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.projectLabname" /></td>
          <td width="33%" height="25">项目组人数：<s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TDeclaration.memberAmount" /></td>
        </tr>
        <tr>
          <td height="25">项目实施时间：
          <s:date name="endProjectComment.TEndProjectExport.TEndProject.TProject.TDeclaration.startOn" format="yyyy-MM-dd"/> 至 <s:date name="endProjectComment.TEndProjectExport.TEndProject.TProject.TDeclaration.endOn" format="yyyy-MM-dd"/></td>
          <td height="25">项目所需经费：<s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TDeclaration.proFund" />元</td>
          <td height="25">&nbsp;</td>
        </tr>
        <tr>
          <td height="25" colspan="3">项目级成员（含申请项目成员信息）：</td>
        </tr>
        <tr>
          <td height="25" colspan="3" ><table width="100%" border="1" align="center" cellpadding="3" cellspacing="0" bordercolor="#a9cfe2" class="dbtable">
            <tr>
              <th width="12%">姓名</th>
              <th width="15%">学号</th>
              <th width="22%">学院</th>
              <th width="23%">联系电话</th>
              <th width="28%">邮箱</th>
            </tr>
            <s:if test="%{endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectLeader != null}">
		     <tr>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectLeader.studentName" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectLeader.studentNumber" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectLeader.TUnit.unitName" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectLeader.studentTelphone" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectLeader.studentEmail" /></td>
		     </tr>
		   </s:if>
		   <s:if test="%{endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectUser1 != null}">
		     <tr>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectUser1.studentName" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectUser1.studentNumber" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectUser1.TUnit.unitName" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectUser1.studentTelphone" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectUser1.studentEmail" /></td>
		     </tr>
		   </s:if>
		   <s:if test="%{endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectUser2 != null}">
		     <tr>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectUser2.studentName" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectUser2.studentNumber" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectUser2.TUnit.unitName" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectUser2.studentTelphone" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TStudentByProjectUser2.studentEmail" /></td>
		     </tr>
		   </s:if>
          </table></td>
        </tr>
        <tr>
          <td height="25" colspan="3">指导教师：</td>
        </tr>
        <tr>
          <td height="25" colspan="3"><table width="100%" border="1" align="center" cellpadding="3" cellspacing="0" bordercolor="#a9cfe2" class="dbtable">
            <tr>
              <th width="12%">姓名</th>
              <th width="15%">职称</th>
              <th width="22%">学院</th>
              <th width="23%">联系电话</th>
              <th width="28%">邮箱</th>
            </tr>
           <s:if test="%{endProjectComment.TEndProjectExport.TEndProject.TProject.TTeacherByProjectTeacher1 != null}">
		     <tr>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TTeacherByProjectTeacher1.teaName" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TTeacherByProjectTeacher1.teaCode" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TTeacherByProjectTeacher1.TUnit.unitName" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TTeacherByProjectTeacher1.teaTele" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TTeacherByProjectTeacher1.teaEmail" /></td>
		     </tr>
		   </s:if>
		   <s:if test="%{endProjectComment.TEndProjectExport.TEndProject.TProject.TTeacherByProjectTeacher2 != null}">
		     <tr>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TTeacherByProjectTeacher2.teaName" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TTeacherByProjectTeacher2.teaCode" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TTeacherByProjectTeacher2.TUnit.unitName" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TTeacherByProjectTeacher2.teaTele" /></td>
		       <td><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.TTeacherByProjectTeacher2.teaEmail" /></td>
		     </tr>
		   </s:if>
          </table></td>
        </tr>
        <tr>
          <td height="25" colspan="3">
          <dl class="artTabs"> 
                <dt id="tabs"><a href="#tabContent1" class="select">项目简介</a> <a href="#tabContent2">创新点</a> <a href="#tabContent3">研究成果</a></dt> 
                <dd id="tabContent1" style="display:block"><s:property value="endProjectComment.TEndProjectExport.TEndProject.TProject.projectIntroduction" /></dd> 
                <dd id="tabContent2"><s:property value="endProjectComment.TEndProjectExport.TEndProject.endprojectInnovate" /></dd> 
                <dd id="tabContent3" style="display:none"><s:property value="endProjectComment.TEndProjectExport.TEndProject.endprojectIntroduction" /></dd> 
                <!--<dd id="tabContent4" style="display:none">
                	<s:iterator value="attachments" id="attachment">
                	<a href="downLoadAttachment?attachementId=<s:property value="attaId" />">
                	<s:property value="fileName" /></a>&nbsp;&nbsp;</s:iterator>
                </dd>  -->
            </dl> 
          </td>
        </tr>
        <tr>
          <td height="25" colspan="3">相关附件：<a href="#" style="color:#06C">
				<s:iterator value="attachments" id="attachment">
                <a href="downLoadAttachment?attachementId=<s:property value="attaId" />">
                <s:property value="fileName" /></a>&nbsp;&nbsp;</s:iterator>
			</a></td>
        </tr>
        </table>
      </td>
    </tr>
    <tr>
       <td align="left" class="dbtitle"><div class="cx_title2">网评结果</div></td>
    </tr>
    <tr>
      <td height="35">
        <div>
        <form id="opinionForm" action="addEndProComment" method="post">
          <input type="hidden" name="endProjectCommentsId" value="<s:property value="endProjectComment.endProjectCommentsId" />"/>
          <table border="0" cellpadding="0" cellspacing="0" width="100%">
            <tr>
              <td height="30">网评意见：</td>
            </tr>
            <tr>
              <td height="30"><textarea name="endProjectComment.endprojectcommentAdvise" cols="80" rows="6" id="textfield2" style="border:1px solid #CCC;"
              							datatype="*" sucmsg="验证通过" nullmsg="请输入网评意见" errormsg="请正确输入"></textarea></td>
            </tr>
            <tr>
              <td height="30">综合评定：
                <select name="endProjectComment.endprojectcommentContent" id="select" class="cxselect">
                  <option value="02">-建议结题-</option>
				  <option value="01">-不建议结题-</option>
                </select>
　评分
<input name="endProjectComment.endprojectcommentScore" id="declComment.declScore" size="10" class="cxinput" type="text" 
		datatype="n1-3" sucmsg="验证通过" nullmsg="请输入分数" errormsg="请正确输入">
%　　<span style="color:#F33">（优秀：90-100；良好：80-90；中等：70-80；及格：60-70；不及格：60以下）</span></td>
            </tr>
            <tr>
              <td height="30"><a href="javascript:void(0);" onclick="saveComment();"><img src="images/tijiaowanping.png" height="22" width="86"></a> 
              <a href="javascript:void(0);" onclick="history.go(-1);"><img src="images//quxiao.png" height="22" width="86"></a></td>
            </tr>
          </table>
          </form>
        </div>
      </td>
    </tr>
  </table>

</div>
              </td>
           </tr>
       </table>
   </div>
   <jsp:include page="../../footer.jsp"></jsp:include>
</div>


<script> 
var artTabs = function (bar, config) {
	var gid = function (id) {return document.getElementById(id)};
	
	config = config || {};
	var bar = typeof bar === 'string' ? gid(bar) : bar,
		className = config.className || 'select',
		callback = config.callback || function () {},
		isMouseover = config.isMouseover,
		
		buttons = bar.getElementsByTagName('a'),
		selectButton = buttons[
			config.index ||
			function () {
				var ret = 0;
				for (i = 0; i < buttons.length; i++) {
					if (buttons[i].className === className) ret = i;
				};
				return ret;
			}()
		],
		showContent = gid(selectButton.href.split('#')[1]),
		fn = function (event) {
			event = event || window.event;
			var target = event.target || event.srcElement;
			
			if (target.nodeName.toLowerCase() === 'a') {
				showContent.style.display = 'none';
				showContent = gid(target.href.split('#')[1]);
				showContent.style.display = 'block';
				selectButton.className = '';
				selectButton = target;
				target.className = className;
				target.focus();
				callback(selectButton, showContent);
				return false;
			};
		};
 
	if (isMouseover) bar.onmouseover = fn;
	bar.onclick = fn;// click事件至少能保证手持设备可以使用
};
 
// 给jQuery添加插件
jQuery.fn.artTabs = function (config) {
	return this.each(function () {
		artTabs(this, config);
	});
};
 
 
// 演示代码
jQuery('.artTabs > dt').artTabs();
</script> 
<script type="text/javascript" src="<%=path%>/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=path%>/js/endproject.js"></script>
<script type="text/javascript">
        $(function(){
            $("#opinionForm").Validform({
                tiptype:3
             });
        });
        
       
   

   </script>
</body>
</html>
