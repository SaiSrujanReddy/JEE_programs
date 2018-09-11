<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="one.jsp" %>
<%@ include file="Two.jsp" %>
<html>
<body>
<%="in impl"%>
<%String name=config.getInitParameter("uname");
String password=config.getInitParameter("password");

%>
<h3><%=name %></h3>

<h3><%=password %></h3>
</body>
</html>