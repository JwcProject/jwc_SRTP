<%--
  Created by IntelliJ IDEA.
  User: ljy
  Date: 2015/5/2
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>user login</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/common.css"/>
    <script src="/js/jquery-2.1.3.js"></script>
    <script src="/js/bootstrap.js"></script>
</head>
<body>

<jsp:include page="head.jsp">
    <jsp:param name="type" value="1"/>
</jsp:include>

<div class="container">
    <div class="row">
        <s:form action="login" namespace="/user" method="POST">
            <s:textfield name="user.username"></s:textfield>
            <s:password name="user.password"></s:password>
            <s:submit></s:submit>
        </s:form>
    </div>
</div>


<jsp:include page="foot.jsp"></jsp:include>
