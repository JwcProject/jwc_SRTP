<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>教师首页</title>
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
          	<s:if test="%{#session.user.userType == '02'}">
		  		<jsp:include page="teacher_leader_left.jsp"></jsp:include>
		  	</s:if>
		    <s:elseif test="%{#session.user.userType == '03'}">
		   		<jsp:include page="teacher_left.jsp"></jsp:include>
		    </s:elseif>
		    <s:elseif test="%{#session.user.userType == '04'}">
		    	<jsp:include page="reviewTeacher_left.jsp"></jsp:include>
		    </s:elseif>
		    <s:elseif test="%{#session.user.userType == '05'}">
		   		<jsp:include page="commonTeacher_left.jsp"></jsp:include>
		    </s:elseif>
		   </s:if>
		   <s:else>
		   		<jsp:forward  page="login.jsp"></jsp:forward>
		   </s:else>
        <!--中间区域-->
        <td width="88%" valign="top"  style="padding-top:10px; padding-left:4px;" ><!-- 公告区域-->
          
          <table width="99%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0" class="bd h193 " bgcolor="#f4f3f1">
                        <tr>
                          <td valign="top"><table width="100%" border="0" height="40" cellspacing="0" cellpadding="0" align="center" class="bottomline mb5">
                              <tr>
                                <td width="85%"><div class="shixiang">项目信息</div></td>
                                <td width="15%" align="right" class="morelink"><a href="ListProjectByUnitTeaCode" >更多>></a></td>
                              </tr>
                            </table>
                            <div class="shixiang_list">
                              <ul>
                                <s:iterator value="projects" id="projects">
                                <li><a href="#"><s:property value="#projects.projectName"/></a></li>
                                </s:iterator>
								
                              </ul>
                            </div>
							
							</td>
                        </tr>
                      </table></td>
  </tr>
</table>

          
          <!-- 优秀项目 -->
          <table width="99%" border="0" cellspacing="0" cellpadding="0"  height="31" align="center" style="padding-top:10px;">
            <tr>
              <td style="border:1px solid #bbd9e9" ><table width="100%" height="29" border="0" cellspacing="0" cellpadding="0" style="background:url(images/tbline.jpg) repeat-x;   border-left:1px solid #eaf5fc; border-right:1px solid #eaf5fc; border-bottom:1px solid #c8e2f2" >
                  <tr>
                    <td ><div class="zhuanjia">历史专家库</div></td>
                    <td width="15%" align="right" class="morelink"><a href="ListHistoryExpert" >更多>></a></td>
                  </tr>
                </table></td>
            </tr>
          </table>
          <div class="tablelist mb10">
            <table width="99%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="center">
              <tr>
                <td width="14%" class="jiaoshi">|教师编号</td>
                <td width="15%">|教师名称 </td>
                <td width="15%">|性别 </td>
                <td width="15%">|职称 </td>
                
                <td width="20%">|最近所属团队</td>
              </tr>
              <s:iterator value="expertTeachers" id="expertTeachers">
               <tr>
                <td bgcolor="#eef7ff"><s:property value="#expertTeachers.TTeacher.teaCode" /> </td>
                <td bgcolor="#eef7ff"><s:property value="#expertTeachers.TTeacher.teaName" /> </td>
                <td bgcolor="#eef7ff">
                <s:if test="%{#expertTeachers.TTeacher.teaSex==01}">
                	女
                </s:if>
                <s:elseif test="%{#expertTeachers.TTeacher.teaSex==02}">
                    	男
                </s:elseif>
                <s:else>
                	未知
                </s:else>
                </td>
                <td bgcolor="#eef7ff"><s:property value="#expertTeachers.TTeacher.teaTitle" /></td>
                
                <td bgcolor="#eef7ff"><s:property value="#expertTeachers.TExpertLib.TJieqi.jqYear+'年，第'+#expertTeachers.TExpertLib.TJieqi.qici+'期'" /></td>
              </tr>
              </s:iterator>
             
              
              <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></a></td>
              </tr>
            </table>
          </div>
          <!-- 优秀资源 -->
          <table width="99%" border="0" cellspacing="0" cellpadding="0"  height="31" align="center">
            <tr>
              <td style="border:1px solid #bbd9e9"><table width="100%" height="29" border="0" cellspacing="0" cellpadding="0" style="background:url(images/tbline.jpg) repeat-x;   border-left:1px solid #eaf5fc; border-right:1px solid #eaf5fc; border-bottom:1px solid #c8e2f2" >
                  <tr>
                    <td><div class="zhuanjia">统计分析</div></td>
                    <td width="15%" align="right" class="morelink"><a href="#" >更多>></a></td>
                  </tr>
                </table></td>
            </tr>
          </table>
          <div class="tablelist mb10">
            <table width="99%" border="0" cellspacing="0" cellpadding="0" style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;" align="center">
              <tr>
                <td width="10%" class="jiaoshi">软件学院srtp项目成交及通过率统计：</td>
              </tr>
              <tr>
                <td width="10%" class="tongjitu"><img src="images/tongjitu.jpg" alt="统计图" height="144" width="654" /></td>
              </tr>
            </table>
          </div></td>
        <!--  最右边-->
        <td width="12%"  valign="top" style="padding-top:10px;"><div class="w220 r_kuang h624 fr"  >
            <div class="bline centerdiv ">
              <div class="more"><a href="#">更多>></a></div>
              <div class="xiangmu">待办事项</div>
            </div>
            <div class="xm_lb">
              <dl>
                <dt><a href="#"><b>。软件学院2013年SRTP测试</b></a>
                  </li>
                <dd><a href="#">软件学院2013年SRTP测试项目软件学院2013年SRTP测试...</a>
                  </li>
              </dl>
              <dl>
                <dt><a href="#"><b>。软件学院2013年SRTP测试</b></a>
                  </li>
                <dd><a href="#">软件学院2013年SRTP测试项目软件学院2013年SRTP测试...</a>
                  </li>
              </dl>
              <dl>
                <dt><a href="#"><b>。软件学院2013年SRTP测试</b></a>
                  </li>
                <dd><a href="#">软件学院2013年SRTP测试项目软件学院2013年SRTP测试...</a>
                  </li>
              </dl>
            </div>
            <div class="bline centerdiv ">
              <div class="qmenu"> 快捷菜单</div>
            </div>
            <div class="qmenu_icon">
              <ul>
                <li> <a href="ListProjectByUnitTeaCode"><img src="images/2_icon1.png" width="45" height="44"/>
                  <p>项目信息</p>
                  </a></li>
                <li> <a href="#"><img src="images/2_icon2.png" width="48" height="45"/>
                  <p>过程管理</p>
                  </a></li>
                <li> 
                <a href="#"><img src="images/2_icon3.png" width="44" height="46"/>
                <p>个人中心</p>
				</a></li>
                <li> <a href="<%=basePath%>pages/announManage/announ_commit.jsp"><img src="images/2_icon4.png" width="47" height="44" />
                  <p>发布公告</p>
				  </a></li>
                <li> <a href="#"><img src="images/2_icon5.png" width="47" height="45" />
                  <p>项目变更</p>
                </a></li>
                <li> <a href="#"><img src="images/2_icon6.png" width="52" height="45"  />
				 </a></li>
				 
              </ul>
            </div>
          </div></td>
      </tr>
    </table>
    </td>
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
