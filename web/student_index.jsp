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
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
</head>
<body>
<div id="container">
  <jsp:include page="header.jsp"></jsp:include>
  <!--  此处显示 id "maincontent" 的内容-->
  <div id="maincontent" class="h645">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <!--  左边区域-->
       <s:if test="null!=#session.user">
          	<s:if test="%{#session.user.userType == '06'}">
		  		<jsp:include page="student_left.jsp"></jsp:include>
		  	</s:if>
		    <s:elseif test="%{#session.user.userType == '07'}">
		    	<jsp:include page="student_member_left.jsp"></jsp:include>
		    </s:elseif>
		    <s:elseif test="%{#session.user.userType == '08'}">
		   		<jsp:include page="student_leader_left.jsp"></jsp:include>
		    </s:elseif>
		   </s:if>
		   <s:else>
		   		<jsp:forward  page="login.jsp"></jsp:forward>
		   </s:else>
        <!--中间区域-->
        <td width="88%" valign="top" >
       <!-- 公告区域-->
        <table width="100%" border="0" cellspacing="0" cellpadding="0"  align="right" >
            <tr>
              <td width="88%"  valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" style="margin-bottom:10px;">
                  <tr>
                    <td width="50%" valign="top" style="padding-top:10px; padding-left:4px;"><table width="99%" border="0" cellspacing="0" cellpadding="0" class="bd h193 " bgcolor="#f4f3f1">
                        <tr>
                          <td valign="top"><table width="99%" border="0" height="40" cellspacing="0" cellpadding="0" align="center" class="bottomline mb5">
                              <tr>
                                <td width="85%"><div class="gonggao">教务处公告</div></td>
                                <td width="15%" align="right" class="morelink"><a href="ListIndexDeanAnnouncement" >更多>></a></td>
                              </tr>
                            </table>
                            <div class="gonggaolist">
                              <ul>
                              <s:iterator value="announcements" id="announcements">
								<li><a href="ViewAnnouncement?announId=<s:property value = '#announcementList.announId' />" target="_blank">
								    <s:if test="%{#announcements.announTitle.length()>50}">
										<s:property value="%{#announcements.announTitle.substring(0,50)+'...'}" escape="#onlineList.frmTitle" />
									</s:if>
									<s:else>
										<s:property value="#announcements.announTitle" />
									</s:else>
							    </a></li>
                               </s:iterator>
                              </ul>
                            </div></td>
                        </tr>
                      </table>
         
                    </td>
                    <td width="50%" valign="top" style="padding-top:10px;padding-left:6px;"><table width="99%" border="0" cellspacing="0" cellpadding="0" class="bd h193 " bgcolor="#f4f3f1">
                        <tr>
                          <td valign="top"><table width="99%" border="0" height="40" cellspacing="0" cellpadding="0" align="center" class="bottomline mb5">
                              <tr>
                                <td width="85%"><div class="gonggao">学院公告</div></td>
                                <td width="15%" align="right" class="morelink"><a href="ListIndexUnitAnnouncement" >更多>></a></td>
                              </tr>
                            </table>
                            <div class="gonggaolist">
                              <ul>
                                <s:iterator value="announcementList" id="announcementList">
								<li><a href="ViewAnnouncement?announId=<s:property value = '#announcementList.announId' />" target="_blank">
								    <s:if test="%{#announcementList.announTitle.length()>50}">
										<s:property value="%{#announcementList.announTitle.substring(0,50)+'...'}" escape="#onlineList.frmTitle" />
									</s:if>
									<s:else>
										<s:property value="#announcementList.announTitle" />
									</s:else>
							    </a></li>
                               </s:iterator>
                              </ul>
                            </div></td>
                        </tr>
                      </table></td>
                  </tr>
                </table>
                  <!-- 优秀项目 -->
                <table width="99%" border="0" cellspacing="0" cellpadding="0"  height="31" align="center">
  <tr>
    <td style="border:1px solid #bbd9e9"><table width="100%" height="29" border="0" cellspacing="0" cellpadding="0" style="background:url(images/tbline.jpg) repeat-x;   border-left:1px solid #eaf5fc; border-right:1px solid #eaf5fc; border-bottom:1px solid #c8e2f2" >
  <tr>
    <td><div class="goodpro">优秀项目</div></td>
          <td width="15%" align="right" class="morelink"><a href="#" >更多>></a></td>
  </tr>
</table>
</td>
  </tr>
</table>
                   <div class="tablelist mb10"> <table width="99%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="center">
                      <tr>
                        <td width="14%" class="NoNewline">项目类型</td>
                        <td width="20%">|项目名 </td>
                        <td width="15%"> |负责人 </td>
                        <td width="17%"> |所属期次 </td>
                        <td width="34%">|操作</td>
                      </tr>
                      <tr>
                        <td bgcolor="#eef7ff">基础研究 </td>
                        <td bgcolor="#eef7ff">如何做研究 </td>
                        <td bgcolor="#eef7ff"> 张飞 </td>
                        <td bgcolor="#eef7ff">2013年第一期 </td>
                        <td bgcolor="#eef7ff"><a href="#"><img src="images/mid5.jpg" width="86" height="22" /></a></td>
                     </tr>
                      <tr>
                        <td>工程类 </td>
                        <td>如何写代码 </td>
                        <td> 李四 </td>
                        <td> 2012年第一期</td>
                        <td><a href="#"><img src="images/mid5.jpg" width="86" height="22" /></a></td>
                      </tr>
                       <tr>
                        <td bgcolor="#eef7ff">基础研究 </td>
                        <td bgcolor="#eef7ff">如何做研究 </td>
                        <td bgcolor="#eef7ff"> 张飞 </td>
                        <td bgcolor="#eef7ff">2013年第一期 </td>
                        <td bgcolor="#eef7ff"><a href="#"><img src="images/mid5.jpg" width="86" height="22" /></a></td>
                     </tr>
                      <tr>
                        <td>工程类 </td>
                        <td>如何写代码 </td>
                        <td> 李四 </td>
                        <td> 2012年第一期</td>
                        <td><a href="#"><img src="images/mid5.jpg" width="86" height="22" /></a></td>
                      </tr>
                       
                </table></div>
                
                 <!-- 优秀资源 -->
                <table width="99%" border="0" cellspacing="0" cellpadding="0"  height="31" align="center">
  <tr>
    <td style="border:1px solid #bbd9e9"><table width="100%" height="29" border="0" cellspacing="0" cellpadding="0" style="background:url(images/tbline.jpg) repeat-x;   border-left:1px solid #eaf5fc; border-right:1px solid #eaf5fc; border-bottom:1px solid #c8e2f2" >
  <tr>
    <td><div class="goodpro">优秀资源</div></td>
          <td width="15%" align="right" class="morelink"><a href="#" >更多>></a></td>
  </tr>
</table>
</td>
  </tr>
</table>
                   <div class="tablelist mb10"> <table width="99%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="center">
                      <tr>
                        <td width="10%" class="NoNewline">资料名</td>
                        <td width="13%">|项目名 </td>
                        <td width="6%" > |上传者 </td>
                        <td width="15%"> |资源类型   </td>
                         <td width="12%"> |内别    </td>
                          <td width="10%"> |上传时间     </td>
                        <td width="34%">|操作</td>
                      </tr>
                      <tr>
                        <td bgcolor="#eef7ff">C程序完全手册 </td>
                        <td bgcolor="#eef7ff">C语音学习资料</td>
                        <td bgcolor="#eef7ff"> 张飞 </td>
                        <td bgcolor="#eef7ff"> 内部资料   </td>
                          <td bgcolor="#eef7ff"> 文献类 </td>
                        <td bgcolor="#eef7ff">2013-05-10 </td>
                        <td bgcolor="#eef7ff"><a href="#"><img src="images/mid5.jpg" width="86" height="22" /> <img src="images/mid6.jpg" width="86" height="22" /></a></td>
                     </tr>
                      <tr>
                        <td>工程类 </td>
                        <td>如何写代码 </td>
                        <td> 资源类型   </td>
                          <td> 资源类型   </td>
                        <td> 李四 </td>
                        <td>2013-05-10 </td>
                        <td><a href="#"><img src="images/mid5.jpg" width="86" height="22" /></a></td>
                      </tr>
                       <tr>
                        <td bgcolor="#eef7ff">基础研究 </td>
                        <td bgcolor="#eef7ff">如何做研究 </td>
                        <td bgcolor="#eef7ff"> 张飞 </td>
                          <td bgcolor="#eef7ff">如何做研究 </td>
                        <td bgcolor="#eef7ff"> 张飞 </td>
                        <td bgcolor="#eef7ff">2013-05-10 </td>
                        <td bgcolor="#eef7ff"><a href="#"><img src="images/mid5.jpg" width="86" height="22" /></a></td>
                     </tr>
                      <tr>
                        <td>工程类 </td>
                        <td>如何写代码 </td>
                         <td>工程类 </td>
                        <td>如何写代码 </td>
                        <td> 李四 </td>
                        <td>2013-05-10 </td>
                        <td><a href="#"><img src="images/mid5.jpg" width="86" height="22" /></a></td>
                      </tr>
                       
                </table></div>
                
                </td>
              <!--  最右边-->
              <td width="14%"  valign="top" style="padding-top:10px;"><div class="w220 r_kuang h624 fr"  >
                  <div class="bline centerdiv ">
                    <div class="more"><a href="ListCommonAnnouncement">更多>></a></div>
                    <div class="team"> 组队信息</div>
                  </div>
                  <div class="teamlist centerdiv">
                    <ul>
                     <s:iterator value="commonAnnouncement" id="commonAnnouncement">
								<li><a href="ViewAnnouncement?announId=<s:property value = '#commonAnnouncement.announId' />" target="_blank">
								    <s:if test="%{#commonAnnouncement.announTitle.length()>30}">
										<s:property value="%{#commonAnnouncement.announTitle.substring(0,30)+'...'}" escape="#onlineList.frmTitle" />
									</s:if>
									<s:else>
										<s:property value="#commonAnnouncement.announTitle" />
									</s:else>
							    </a></li>
                     </s:iterator>
                    </ul>
                  </div>
                  <div class="bline centerdiv ">
                    <div class="qmenu"> 快捷菜单</div>
                  </div>
                  <div class="qmenulist centerdiv">
                    <ul>
                      <li> <a href="<%=path%>/ListDeclaration"><img src="images/right1.jpg" width="70" height="60" />
                        <p>项目信息</p>
                        </a></li>
                      <li> <a href="#"><img src="images/right2.jpg" width="70" height="60" />
                        <p>过程管理</p>
                        </a></li>
                      <li> <a href="#"><img src="images/right3.jpg" width="70" height="60" />
                        <p>个人中心</p>
                        </a></li>
                      <li> <a href="#"><img src="images/right4.jpg" width="70" height="60"  style="margin-top:10px;"/> </a></li>
                    </ul>
                  </div>
                </div></td>
            </tr>
          </table></td>
      </tr>
    </table>
  </div>
  <jsp:include page="footer.jsp"></jsp:include>
</div>
 <script type="text/javascript">
       $(document).ready(function(){
	       $("#Left_menu .menu_body:eq(0)").show();	      
       });
 </script>
</body>
</html>
