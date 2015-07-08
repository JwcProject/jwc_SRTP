<%@ page import="org.apache.struts2.ServletActionContext" %>
<%--
  Created by IntelliJ IDEA.
  User: zl
  Date: 2015/7/2
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<title>error</title>
<head>
  <script></script>
</head>
<body><%=ServletActionContext.getRequest().getSession().getAttribute("test")%>
</body>