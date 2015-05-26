<%--
  Created by IntelliJ IDEA.
  User: zl
  Date: 2015/5/3
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse"
                    data-target=".bs-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="../" class="navbar-brand">s2sh_demo</a>
        </div>
        <nav class="collapse navbar-collapse bs-navbar-collapse">
            <ul class="nav nav-tabs nav-justified">
                <li
                        <s:if test='%{#parameters.type[0]=="1"}'>class="active"</s:if> ><a href="#">struts2</a></li>
                <li
                        <s:if test='%{#parameters.type[0]=="2"}'>class="active"</s:if> ><a href="#">hibernate</a></li>
                <li
                        <s:if test='%{#parameters.type[0]=="3"}'>class="active"</s:if> ><a href="#">spring</a></li>
                <li
                        <s:if test='%{#parameters.type[0]=="4"}'>class="active"</s:if> ><a href="#">combine</a></li>
            </ul>
        </nav>
    </div>
</header>

