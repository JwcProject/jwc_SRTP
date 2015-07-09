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
  <title>Login Page - Ace Admin</title>

  <meta name="description" content="User login page"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

  <!-- bootstrap & fontawesome -->
  <link rel="stylesheet" href="<%=basePath%>assets/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="<%=basePath%>assets/css/font-awesome.min.css"/>

  <!-- text fonts -->
  <link rel="stylesheet" href="<%=basePath%>assets/css/ace-fonts.css"/>

  <!-- ace styles -->
  <link rel="stylesheet" href="<%=basePath%>assets/css/ace.min.css"/>

  <!--[if lte IE 9]>
  <link rel="stylesheet" href="<%=basePath%>assets/css/ace-part2.min.css"/>
  <![endif]-->
  <link rel="stylesheet" href="<%=basePath%>assets/css/ace-rtl.min.css"/>

  <!--[if lte IE 9]>
  <link rel="stylesheet" href="<%=basePath%>assets/css/ace-ie.min.css"/>
  <![endif]-->
  <link rel="stylesheet" href="<%=basePath%>assets/css/ace.onpage-help.css"/>

  <link rel="stylesheet" href="<%=basePath%>assets/css/custom.css"/>

  <script src="<%=basePath%>assets/js/ace-extra.min.js"></script>

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

  <!--[if lt IE 9]>
  <script src="<%=basePath%>assets/js/html5shiv.js"></script>
  <script src="<%=basePath%>assets/js/respond.min.js"></script>
  <![endif]-->
</head>
<body class="login-layout light-login bg-primary">

<div class="container login-main-container">
  <div class="row pad-xs">

    <div class="col-sm-8 col-sm-offset-2">
      <img src="<%=basePath%>assets/fig/logo_small.png" alt="chongqing nuiversity" class="img-responsive img-logo">

      <h1 class="login-header text-center">重庆大学SRTP协作平台
      </h1>
    </div>

  </div>
  <div class="row pad-xs">
    <div class="col-sm-offset-6 col-sm-6 col-md-offset-7 col-md-5 col-lg-offset-7 col-lg-4">
      <div class="login-container">
        <div class="position-relative">
          <div id="login-box" class="login-box visible widget-box no-border">
            <div class="widget-body">
              <div class="widget-main">
                <h4 class="header blue lighter bigger">
                  <i class="ace-icon fa fa-coffee green"></i>
                  请输入您的信息
                </h4>

                <div class="space-6"></div>

                <form id="login-form" action="user/login" method="post">
                  <fieldset>
                    <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input name="username" type="text" class="form-control" placeholder="用户名"/>
															<i class="ace-icon fa fa-user"></i>
														</span>
                    </label>

                    <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input name="password" type="password" class="form-control" placeholder="密码"/>
															<i class="ace-icon fa fa-lock"></i>
														</span>
                    </label>

                    <div class="space"></div>

                    <div class="clearfix">
                      <label class="inline">
                        <input type="checkbox" class="ace"/>
                        <span class="lbl">记住登陆</span>
                      </label>

                      <button id="login-submit" type="submit" class="width-35 pull-right btn btn-sm btn-primary">
                        <i class="ace-icon fa fa-key"></i>
                        <span class="bigger-110">登陆</span>
                      </button>
                    </div>

                    <div class="space-4"></div>
                  </fieldset>
                </form>

                <%--<div class="alert alert-block alert-success fade in ">

                  <button type="button" class="close" data-dismiss="alert">
                    <i class="ace-icon fa fa-times"></i>
                  </button>
                  密码错误
                </div>--%>

              </div>
              <!-- /.widget-main -->

              <div class="toolbar clearfix">
                <div>
                  <a href="#" data-target="#forgot-box" class="forgot-password-link">
                    <i class="ace-icon fa fa-arrow-left"></i>
                    忘记密码
                  </a>
                </div>

                <div>
                  <a href="#" data-target="#signup-box" class="user-signup-link">
                    新用户注册
                    <i class="ace-icon fa fa-arrow-right"></i>
                  </a>
                </div>
              </div>
            </div>
            <!-- /.widget-body -->
          </div>
          <!-- /.login-box -->

          <div id="forgot-box" class="forgot-box widget-box no-border">
            <div class="widget-body">
              <div class="widget-main">
                <h4 class="header red lighter bigger">
                  <i class="ace-icon fa fa-key"></i>
                  重置密码
                </h4>

                <div class="space-6"></div>
                <p>
                  请输入您的用户名和重庆大学E-mail：
                </p>

                <form id="reset-password-form" action="user/resetPassword" method="post">
                  <fieldset>

                    <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input name="username" type="text" class="form-control" placeholder="用户名"/>
															<i class="ace-icon fa fa-user"></i>
														</span>
                    </label>

                    <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" name="email" class="form-control" placeholder="E-mail"/>
															<i class="ace-icon fa fa-envelope"></i>
														</span>
                    </label>

                    <div class="clearfix">
                      <button id="reset-password-submit" type="submit"
                              class="width-35 pull-right btn btn-sm btn-danger">
                        <i class="ace-icon fa fa-lightbulb-o"></i>
                        <span class="bigger-110">确定</span>
                      </button>
                    </div>
                    <div class="space-4"></div>
                  </fieldset>
                </form>
              </div>
              <!-- /.widget-main -->

              <div class="toolbar center">
                <a href="#" data-target="#login-box" class="back-to-login-link">
                  返回登陆
                  <i class="ace-icon fa fa-arrow-right"></i>
                </a>
              </div>
            </div>
            <!-- /.widget-body -->
          </div>
          <!-- /.forgot-box -->

          <div id="signup-box" class="signup-box widget-box no-border">
            <div class="widget-body">
              <div class="widget-main">
                <h4 class="header green lighter bigger">
                  <i class="ace-icon fa fa-users blue"></i>
                  新用户注册
                </h4>

                <div class="space-6"></div>
                <p> 请输入您的重庆大学E-mail（@cqu.edu.cn）： </p>

                <form id="register-form" action="user/register" method="post">
                  <fieldset>
                    <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input name="email" type="email" class="form-control" placeholder="E-mail"/>
															<i class="ace-icon fa fa-envelope"></i>
														</span>
                    </label>

                    <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input name="username" type="text" class="form-control" placeholder="用户名"/>
															<i class="ace-icon fa fa-user"></i>
														</span>
                    </label>

                    <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input name="password" type="password" class="form-control" placeholder="密码"/>
															<i class="ace-icon fa fa-lock"></i>
														</span>
                    </label>

                    <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input name="password_again" type="password" class="form-control" placeholder="再次输入密码"/>
															<i class="ace-icon fa fa-retweet"></i>
														</span>
                    </label>

                    <div class="clearfix">
                      <button type="reset" class="width-30 pull-left btn btn-sm">
                        <i class="ace-icon fa fa-refresh"></i>
                        <span class="bigger-110">重置</span>
                      </button>

                      <button id="register-submit" type="submit" class="width-65 pull-right btn btn-sm btn-success">
                        <span class="bigger-110">注册</span>

                        <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                      </button>
                    </div>
                    <div class="space-4"></div>
                  </fieldset>
                </form>
              </div>

              <div class="toolbar center">
                <a href="#" data-target="#login-box" class="back-to-login-link">
                  <i class="ace-icon fa fa-arrow-left"></i>
                  返回登陆
                </a>
              </div>
            </div>
            <!-- /.widget-body -->
          </div>
          <!-- /.signup-box -->
        </div>
        <!-- /.position-relative -->
      </div>
    </div>
  </div>
</div>


<!-- basic scripts -->

<!--[if !IE]> -->
<script type="text/javascript">
  window.jQuery || document.write("<script src='<%=basePath%>assets/js/uncompressed/jquery.js'>" + "<" + "/script>");
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


<!-- inline scripts related to this page -->
<script type="text/javascript">
  jQuery(function ($) {
    $(document).on('click', '.toolbar a[data-target]', function (e) {
      e.preventDefault();
      var target = $(this).data('target');
      $('.widget-box.visible').removeClass('visible');//hide others
      $(target).addClass('visible');//show target
    });

    map = {
      "user/login": "login",
      "user/resetPassword": "resetPassword",
      "user/register": "register"

    }

    //login-form
    $('#login-submit').click(function (event) {
      event.preventDefault();

      var login_form = $('#login-form');

      console.log(login_form.attr('action'));

      $.ajax({
        type: login_form.attr('method'),
        url: '<%=basePath%>' + map[login_form.attr('action')],
        data: login_form.serialize(),
        success: function (data) {
          $('#login-form + div').remove();
          //返回的是页面
          if (typeof(data) == "string") {
            login_form.after('<div class="alert alert-block alert-danger fade in">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '<i class="ace-icon fa fa-times"></i>' +
            '</button>' +
            '服务器内部错误，请稍后再试' +
            '</div>');
            console.log(data);
            return;
          }
          //返回的json
          var result = data.result;

          if (result == "success") {
            login_form.after('<div class="alert alert-block alert-success fade in">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '<i class="ace-icon fa fa-times"></i>' +
            '</button>' +
            '登陆成功，即将为您跳转' +
            '</div>');
            setTimeout(function () {
              location.href = '<%=basePath%>index';
            }, 1000);
          } else if (result == "passwordWorry") {
            login_form.after('<div class="alert alert-block alert-danger fade in">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '<i class="ace-icon fa fa-times"></i>' +
            '</button>' +
            '登陆失败，密码错误，请检查密码' +
            '</div>');
          } else if (result == "noThisUser") {
            login_form.after('<div class="alert alert-block alert-danger fade in">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '<i class="ace-icon fa fa-times"></i>' +
            '</button>' +
            '登陆失败，无此用户' +
            '</div>');

          } else {
            login_form.after('<div class="alert alert-block alert-danger fade in">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '<i class="ace-icon fa fa-times"></i>' +
            '</button>' +
            '登陆失败，数据内部错误' +
            '</div>');
          }
        },
        error: function () {
          $('#login-form + div').remove();
          login_form.after('<div class="alert alert-block alert-danger fade in">' +
          '<button type="button" class="close" data-dismiss="alert">' +
          '<i class="ace-icon fa fa-times"></i>' +
          '</button>' +
          '服务器内部错误，请稍后再试' +
          '</div>');
        }
      });
    });


    //reset-password-form
    $('#reset-password-submit').click(function (event) {
      //$(this).disable();
      event.preventDefault();
      var reset_password_form = $('#reset-password-form');
      $.ajax({
        method: reset_password_form.attr('method'),
        url: '<%=basePath%>' + map[reset_password_form.attr('action')],
        data: reset_password_form.serialize(),
        success: function (data) {
          $('#reset-password-form + div').remove();
          //返回的是页面
          if (typeof(data) == "string") {
            reset_password_form.after('<div class="alert alert-block alert-danger fade in">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '<i class="ace-icon fa fa-times"></i>' +
            '</button>' +
            '服务器内部错误，请稍后再试' +
            '</div>');
            console.log(data);
            return;
          }
          //返回的是json
          var result = data.result;
          if (result == "success") {
            reset_password_form.after('<div class="alert alert-block alert-success fade in">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '<i class="ace-icon fa fa-times"></i>' +
            '</button>' +
            '密码重置成功，请到邮箱里查看新密码' +
            '</div>');
          } else if (result == "noThisUser") {
            reset_password_form.after('<div class="alert alert-block alert-danger fade in">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '<i class="ace-icon fa fa-times"></i>' +
            '</button>' +
            '无此用户，请检查' +
            '</div>');
          } else if (result == "emailWorry") {
            reset_password_form.after('<div class="alert alert-block alert-danger fade in">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '<i class="ace-icon fa fa-times"></i>' +
            '</button>' +
            'Email错误，请检查' +
            '</div>');
          } else {
            reset_password_form.after('<div class="alert alert-block alert-danger fade in">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '<i class="ace-icon fa fa-times"></i>' +
            '</button>' +
            '重置密码失败，数据内部错误，请收到再试' +
            '</div>');
          }
        },
        error: function () {
          $('#reset-password-form + div').remove();
          reset_password_form.after('<div class="alert alert-block alert-danger fade in">' +
          '<button type="button" class="close" data-dismiss="alert">' +
          '<i class="ace-icon fa fa-times"></i>' +
          '</button>' +
          '服务器内部错误，请稍后再试' +
          '</div>');
        }

      });
    });

    $('#register-submit').click(function (event) {
      event.preventDefault();
      var register_form = $('#register-form');
      $.ajax({
        method: register_form.attr('method'),
        url: '<%=basePath%>' + map[register_form.attr('action')],
        data: register_form.serialize(),
        success: function (data) {
          $('#register-form + div').remove();
          //返回的是页面
          if (typeof(data) == "string") {
            register_form.after('<div class="alert alert-block alert-danger fade in">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '<i class="ace-icon fa fa-times"></i>' +
            '</button>' +
            '服务器内部错误，请稍后再试' +
            '</div>');
            console.log(data);
            return;
          }

          //返回的是json
          var result = data.result;

          if (result == "success") {
            register_form.after('<div class="alert alert-block alert-success fade in">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '<i class="ace-icon fa fa-times"></i>' +
            '</button>' +
            '注册成功，请到邮箱中查看邮件' +
            '</div>');
          } else if (result == "redundancyUser") {
            register_form.after('<div class="alert alert-block alert-danger fade in">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '<i class="ace-icon fa fa-times"></i>' +
            '</button>' +
            '用户名已存在，请尝试其他用户名' +
            '</div>');

          } else if (result == "redundancyEmail") {
            register_form.after('<div class="alert alert-block alert-danger fade in">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '<i class="ace-icon fa fa-times"></i>' +
            '</button>' +
            '此邮箱已被注册，请尝试找回密码，如被他人恶意占用，请联系管理员' +
            '</div>');

          } else {
            register_form.after('<div class="alert alert-block alert-danger fade in">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '<i class="ace-icon fa fa-times"></i>' +
            '</button>' +
            '注册失败，数据库内部错误，请收到再试' +
            '</div>');
          }
        },
        error: function () {
          $('#register-form + div').remove();
          register_form.after('<div class="alert alert-block alert-danger fade in">' +
          '<button type="button" class="close" data-dismiss="alert">' +
          '<i class="ace-icon fa fa-times"></i>' +
          '</button>' +
          '服务器内部错误，请稍后再试' +
          '</div>');
        }

      });
    })
  });

</script>
</body>
</html>
