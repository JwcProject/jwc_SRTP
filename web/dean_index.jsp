<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<title>教务处首页</title>

<body>
<div id="container">
  <!--  此处显示 id "maincontent" 的内容-->
  <div id="maincontent" class="h645">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <!--中间区域-->
        <td width="84%" valign="top"><!-- 公告区域-->
          <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center"
                 style="margin-bottom:10px;">
            <tr>
              <td width="100%" valign="top" style="padding-top:10px; padding-left:4px;">
                <table width="99%" border="0" cellspacing="0" cellpadding="0" class="bd h193 "
                       bgcolor="#f4f3f1">
                  <tr>
                    <td valign="top">
                      <table width="99%" border="0" height="40" cellspacing="0" cellpadding="0"
                             align="center" class="bottomline mb5">
                        <tr>
                          <td width="85%">
                            <div class="gonggao">教务处公告</div>
                          </td>
                          <td width="15%" align="right" class="morelink"><a
                                  href="<%=path%>/findIndexDeanAnnouncement">更多>></a></td>
                        </tr>
                      </table>
                      <div class="shixiang_list">
                        <ul>
                          <s:iterator value="deanAnnounList" id="announcements">
                            <li>
                              <a href="ViewAnnouncement?announId=<s:property value = '#announcements.announId' />"
                                 target="_blank">
                                <s:if test="%{#announcements.announTitle.length()>50}">
                                  <s:property
                                          value="%{#announcements.announTitle.substring(0,50)+'...'}"
                                          escape="#onlineList.frmTitle"/>
                                </s:if>
                                <s:else>
                                  <s:property value="#announcements.announTitle"/>
                                </s:else>
                              </a><span>
                                	<s:if test="null==#announcements.publishTime||#announcements.publishTime.isEmpty()">

                                  </s:if>
									<s:else>
                    <%--<s:text name="global.format.date">--%>
                    [<s:property value="#announcements.publishTime"/>]
                    <%--</s:text>--%>
                  </s:else>
                                </span></li>
                          </s:iterator>
                        </ul>
                      </div>
                    </td>
                  </tr>
                </table>
              </td>
            </tr>
          </table>
          <!-- 优秀项目 -->
          <div class="widget-box">
            <div class="widget-header widget-header-flat">
              <h4 class="widget-title">统计分析</h4>
            </div>
            <div class="widget-body">
              <div class="widget-main">
                <p>软件学院srtp项目成交及通过率统计：</p>
                <p><img src="images/3_tongjitu1.jpg" alt="统计图1"/></p>
                <p><img src="images/3_tongjitu2.jpg" alt="统计图2"/></p>
              </div>
            </div>
          </div>
          <div class="tablelist mb10">
            <table width="99%" border="0" cellspacing="0" cellpadding="0"
                   style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;"
                   align="center">
            </table>
          </div>
          <!-- 优秀资源 -->
          <table width="99%" border="0" cellspacing="0" cellpadding="0" height="31" align="center">
          </table>
          <div class="tablelist mb10">
            <table width="99%" border="0" cellspacing="0" cellpadding="0"
                   style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;"
                   align="center">
            </table>
          </div>
        </td>
        <!--  最右边-->
        <td width="14%" valign="top" style="padding-top:10px;">
          <div class="w220 r_kuang h624 fr">
            <div class="bline centerdiv ">
              <div class="widget-box">
                <div class="widget-header widget-header-flat">
                  <h4 class="widget-title">优秀项目</h4>
                </div>
                <div class="widget-body">
                  <div class="widget-main">
                    <ul>
                      <li><a href="#">关于“如何做研究”项目</a></li>
                      <li><a href="#">关于“如何做研究”项目</a></li>
                      <li><a href="#">关于“如何做研究”项目</a></li>
                      <li><a href="#">关于“如何做研究”项目</a></li>
                    </ul>
                  </div>
                </div>
              </div>

            <div class="widget-box">
              <div class="widget-header widget-header-flat">
                <h4 class="widget-title">快捷菜单</h4>
              </div>
              <div class="widget-body">
                <div class="widget-main">
                  <ul>
                    <li><a href="#"><img src="<%=path%>/images/2_icon3.png" width="45" height="44"/>

                      <p>个人中心</p>
                    </a></li>
                    <li><a href="<%=basePath%>pages/announManage/announ_commit.jsp"><img
                            src="<%=path%>/images/2_icon4.png" width="48" height="45"/>

                      <p>发布公告</p>
                    </a></li>
                    <li><a href="#"><img src="<%=path%>/images/2_icon1.png" width="44" height="46"/>

                      <p>项目变更</p>
                    </a></li>
                    <li><a href="#"><img src="<%=path%>/images/3_icon4.png" width="47" height="44"/>

                      <p>立项审核</p>
                    </a></li>
                    <li><a href="#"><img src="<%=path%>/images/3_icon5.png" width="47" height="45"/>

                      <p>二次答辩</p>
                    </a></li>
                    <li><a href="#"><img src="<%=path%>/images/2_icon6.png" width="52" height="45"/> </a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </td>
      </tr>
    </table>
  </div>
</div>

</body>


<head>
  <script type="text/javascript">
    $(document).ready(function () {
      $("#Left_menu .menu_body:eq(0)").show();
    });
  </script>
</head>