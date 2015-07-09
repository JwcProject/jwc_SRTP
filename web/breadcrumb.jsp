<%--
  Created by IntelliJ IDEA.
  User: zl
  Date: 2015/7/2
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<ul class="breadcrumb">
  <li>
    <i class="ace-icon fa fa-home home-icon"></i>
    <a href="<%=basePath%>index">首页</a>
  </li>

</ul>
<!-- /.breadcrumb -->
