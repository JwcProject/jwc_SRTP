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
      <decortor:body/>
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
<script src="<%=basePath%>assets/js/bootstrap.min.js"></script>

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

<script src="<%=basePath%>assets/js/custom.js"></script>
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
      //根据地址判断选中层级
      //选中.nav-list下的li
      if ($nav_a.size() != 0) {
        $nav_a.parent().addClass('active');

        $('.breadcrumb').append(
                '<li>' +
                $nav_a.parent().text().split(/\s+/)[1] +
                '</li>'
        );
      }
      //选中.submenu 下的li
      else {
        $submenu_a.parent().addClass('active')
                .parent().parent().addClass('active').addClass('open');

        $('.breadcrumb').append(
                '<li>' +
                $submenu_a.parent().parent().parent().text().split(/\s+/)[1] +
                '</li>'
        ).append(
                '<li>' +
                $submenu_a.parent().text().split(/\s+/)[1] +
                '</li>'
        );
      }

      $.ajax({
        method: 'get',
        url: '<%=basePath%>' + url,
        success: function (data) {
          //返回的是网页
          if (typeof(data) == "string") {
            //TODO:
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
      })
    };
    window.onhashchange();
  })
  //  //绑定sidebar点击函数
  //  $(function () {
  //
  //    $('.nav-list  .submenu > li > a ').click(function () {
  //
  //      $('.nav-list > li').removeClass('active');
  //
  //      $('.nav-list .submenu > li').removeClass('active');
  //
  //      var $li = $(this).parent();
  //      $li.addClass('active');
  //      $li.parent().parent().addClass('active');
  //    })
  //
  //    $('.nav-list > li >a').click(function () {
  //
  //      if ($(this).hasClass('dropdown-toggle')) {
  //        return;
  //      }
  //      $('.nav-list > li').removeClass('active');
  //
  //      $('.nav-list .submenu > li').removeClass('active');
  //      $(this).parent().addClass('active');
  //    })
  //
  //  })
  //  $(function () {
  //    var url = window.location.href;
  //    var index = url.indexOf("#");
  //    if (index < 0) {
  //      return;
  //    }
  //    url = url.substring(index + 1);
  //    if (url == "") {
  //      return;
  //    }
  //    var $nav_a = $('.nav-list > li > a[href="#' + url + '"]');
  //
  //    $nav_a.click();
  //    var $submenu_a = $('.nav-list  .submenu > li > a[href="#' + url + '"]');
  //    $submenu_a.click();
  //    if ($nav_a.size() == 0) {
  //      $submenu_a.parent().parent().parent().addClass('open');
  //    }
  //
  //  })
</script>
<decortor:head/>
</body>
</html>
