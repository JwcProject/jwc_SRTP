<%@ page import="edu.cqu.no1.domain.TAuthority" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: zl
  Date: 2015/7/2
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="decortor" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>

  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
  <meta charset="utf-8"/>
  <title><decortor:title default="title"/></title>

  <meta name="description" content="overview &amp; stats"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

  <!-- bootstrap & fontawesome -->
  <link rel="stylesheet" href="<%=basePath%>assets/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="<%=basePath%>assets/css/font-awesome.min.css"/>

  <!-- page specific plugin styles -->

  <!-- text fonts -->
  <link rel="stylesheet" href="<%=basePath%>assets/css/ace-fonts.css"/>

  <!-- ace styles -->
  <link rel="stylesheet" href="<%=basePath%>assets/css/ace.min.css"/>

  <!--[if lte IE 9]>
  <link rel="stylesheet" href="<%=basePath%>assets/css/ace-part2.min.css"/>
  <![endif]-->
  <link rel="stylesheet" href="<%=basePath%>assets/css/ace-skins.min.css"/>
  <link rel="stylesheet" href="<%=basePath%>assets/css/ace-rtl.min.css"/>

  <!--[if lte IE 9]>
  <link rel="stylesheet" href="<%=basePath%>assets/css/ace-ie.min.css"/>
  <![endif]-->

  <link rel="stylesheet" href="<%=basePath%>assets/css/custom.css"/>

  <!-- ace settings handler -->
  <script src="<%=basePath%>assets/js/ace-extra.min.js"></script>

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

  <!--[if lte IE 8]>
  <script src="<%=basePath%>assets/js/html5shiv.js"></script>
  <script src="<%=basePath%>assets/js/respond.min.js"></script>
  <![endif]-->

  <!--[if !IE]> -->
  <script type="text/javascript">
    window.jQuery || document.write("<script src='<%=basePath%>assets/js/jquery.min.js'>" + "<" + "/script>");
  </script>
  <!-- <![endif]-->

  <!--[if IE]>
  <script type="text/javascript">
    window.jQuery || document.write("<script src='<%=basePath%>assets/js/jquery1x.min.js'>" + "<" + "/script>");
  </script>
  <![endif]-->

  <script type="text/javascript">
    if ('ontouchstart' in document.documentElement) document.write("<script src='<%=basePath%>assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
  </script>

  <script src="<%=basePath%>ueditor/ueditor.config.js"></script>
  <script src="<%=basePath%>ueditor/ueditor.all.js"></script>

  <script src="<%=basePath%>assets/js/bootstrap.min.js"></script>

  <script src="<%=basePath%>assets/js/custom.js"></script>

</head>
<body class="no-skin">
<s:include value="navbar.jsp"/>
<div class="main-container" id="main-container">
  <script type="text/javascript">
    try {
      ace.settings.check('main-container', 'fixed')
    } catch (e) {
    }
  </script>
  <s:include value="sidebar.jsp"/>

  <div class="main-content">
    <!-- #section:basics/content.breadcrumbs -->
    <div class="breadcrumbs" id="breadcrumbs">
      <script type="text/javascript">
        try {
          ace.settings.check('breadcrumbs', 'fixed')
        } catch (e) {
        }
      </script>
      <s:include value="breadcrumb.jsp"/>
      <s:include value="searchbox.jsp"/>
    </div>

    <!-- /section:basics/content.breadcrumbs -->
    <div class="page-content">
      <s:include value="settings-box.jsp"/>
      <div class="content-body">
        <decortor:body/>
      </div>
    </div>
    <!-- /.page-content -->
  </div>
  <!-- /.main-content -->
  <s:include value="footer.jsp"/>
  <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
  </a>
</div>
<!-- /.main-container -->

<!-- basic scripts -->


<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="<%=basePath%>assets/js/excanvas.min.js"></script>
<![endif]-->

<script src="<%=basePath%>assets/js/jquery-ui.custom.min.js"></script>
<script src="<%=basePath%>assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="<%=basePath%>assets/js/jquery.easypiechart.min.js"></script>
<script src="<%=basePath%>assets/js/jquery.sparkline.min.js"></script>
<script src="<%=basePath%>assets/js/flot/jquery.flot.min.js"></script>
<script src="<%=basePath%>assets/js/flot/jquery.flot.pie.min.js"></script>
<script src="<%=basePath%>assets/js/flot/jquery.flot.resize.min.js"></script>

<!-- ace scripts -->
<script src="<%=basePath%>assets/js/ace-elements.min.js"></script>
<script src="<%=basePath%>assets/js/ace.min.js"></script>


<script>
  //检测url变化
  $(function () {
    window.onhashchange = function () {
      var url = window.location.href;
      var index = url.indexOf("#");

      $('.breadcrumb > li + li').remove();

      if (index < 0) {
        return;
      }
      url = url.substring(index + 1);
      if (url == "") {
        return;
      }
      console.log(url);

      $('.nav-list > li').removeClass('active').removeClass('open');
      $('.nav-list .submenu > li').removeClass('active');


      var $nav_a = $('.nav-list > li > a[href="#' + url + '"]');
      var $submenu_a = $('.nav-list  .submenu > li > a[href="#' + url + '"]');
      var str1 = '';
      var str2 = '';
      //根据地址判断选中层级
      //选中.nav-list下的li
      if ($nav_a.size() != 0) {
        $nav_a.parent().addClass('active');

        str1 = $nav_a.parent().text().split(/\s+/)[1];

        $('.breadcrumb').append(
                '<li>' +
                str1 +
                '</li>'
        );
      }
      //选中.submenu 下的li
      else {
        $submenu_a.parent().addClass('active')
                .parent().parent().addClass('active').addClass('open');
        str1 = $submenu_a.parent().parent().parent().text().split(/\s+/)[1];
        str2 = $submenu_a.parent().text().split(/\s+/)[1];
        $('.breadcrumb').append(
                '<li>' + str1 +
                '</li>'
        ).append(
                '<li>' + str2 +
                '</li>'
        );
      }

      var path = $('.breadcrumb').text().replace(/ /g, '>');
      window.document.title = '重庆大学SRTP协作管理平台 >> ' + str1 + " >> " + str2;


      var map = {
        'announcement/mine': 'sortUserAnnouncement',
        'announcement/publish': 'pages/announManage/announ_commit.jsp',
        'announcement/maintain': 'sortUserAnnouncement',
        'declare/mine': 'sortMyDeclaration',
        'declare/apply': 'preAddDeclaration',
        'declare/list': 'sortDeclarationList',
        'declare/review/mine': 'PreMyReview',
        'declare/expert/create': 'PreCreateExpert',
        'declare/expert/list': 'ListUnitExperTeam',
        'declare/expert/history': 'ListHistoryExpert',
        'declare/expert/distribute': 'PreAssignExpert',
        'declare/review/organize': 'PreOrganizeReview',
        'declare/result/input': 'preDeclResultTypeIn',
        'declare/result/review': 'ResultReview',
        'project/mine': 'SortMyProject',
        'project/list': 'SortProjectList',
        'final/mine': 'PreMyEndProjects',
        'final/apply': 'PreEndProjectRequest',
        'final/list': 'listEndProjects',
        'final/review/mine': 'PreMyReview',
        'final/review/organize': 'PreOrganizeEndprojectReview',
        'final/expert/create': 'PreCreateEndProExpertTeam',
        'final/expert/list': 'FindEndproExpTeam',
        'final/expert/history': 'ListEndProHistoryExpert',
        'final/expert/distribute': 'PreAssignEndProExpert',
        'final/result/input': 'PreEndProResultTypeIn',
        'final/result/review': 'PreEndProScoreAudit',
        'statistic/grade': 'Statistic/ListSchoolProjectScore',
        'statistic/index': 'Statistic/SchoolResultDistribut',
        'knowledge': '#',
        'system/authority': 'ListPermission',
        'system/role': 'ListRole',
        'system/user': 'ListUser',
        'system/period': 'ListAllJieqi',
        'system/journal': 'ListJournal',
        'user/modify': 'findUserInfo'
      };
      if (url.indexOf('javascript') < 0 && map[url] != "#") {
        $.ajax({
          method: 'get',
          url: '<%=basePath%>' + map[url],
          success: function (data) {
            console.log('ajax success!');

            //返回的是网页
            if (typeof(data) == "string") {
              $('div.content-body').html(data);
              setAjax();

              //TODO: form
            }
            //返回的是json
            else {
              //TODO:
            }
          },
          error: function () {
            //TODO:
            throw new Error("service response error");
          }
        });
      }
    };

    window.onhashchange();
    setAjax();

  })
</script>
<decortor:head/>

<% for (TAuthority a : (List<TAuthority>) session.getAttribute("authorities")) {
  System.out.println(a);
}%>
</body>
</html>
