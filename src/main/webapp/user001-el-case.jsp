<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="org.apache.markt.*" %>
<%
    final Bean bean = null;
    pageContext.setAttribute("bean", bean);
%>
<html>
<body>
<h2>Hello World!</h2>

<p>field1=${bean.field1}</p>
</body>