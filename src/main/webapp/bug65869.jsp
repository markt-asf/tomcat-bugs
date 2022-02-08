<%@ page pageEncoding="UTF-8" import="java.net.URL" %>
<% Object obj = new org.apache.markt.Bug65869龍(); %>
<%
URL url = pageContext.getServletContext().getResource("/WEB-INF/classes/org/apache/markt/Bug65869龍.class");
%>
<p>URL to class file is: <%= url %></p>