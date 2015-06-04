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

<div class="container">
    <div class="row">
        <s:form action="login" namespace="/" method="POST">
            <s:textfield name="user.userName"></s:textfield>
            <s:password name="user.userPassword"></s:password>
            <s:submit></s:submit>
        </s:form>
    </div>
</div>
