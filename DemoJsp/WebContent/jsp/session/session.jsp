<html> 
<head>
<title>Passing the input value to a session variable</title>
</head>
<body> 
<%-- <%@ page session="false" >--%>
<% 
String uname=request.getParameter("name"); 
out.print("Welcome "+ uname);
session.setAttribute("sessname",uname); 
%> 
<a href="output.jsp">Check Output Page Here </a>
</body> 
</html>