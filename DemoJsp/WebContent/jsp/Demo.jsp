

 program for addition of two numbers static way


<%-- <%! 	 
int x=10;
int y=20;
%>
<%

int x=20;

%>

<%=x%>
<%=this.x %>
 --%>
<html>  
<body>  

<%   
  
String name=request.getParameter("uname");  
out.print("Welcome "+name);  
  
session.setAttribute("user",name);  
  
out.println("<a href='index.jsp'>logout</a>");  
  
%>  
</body>  
</html>  