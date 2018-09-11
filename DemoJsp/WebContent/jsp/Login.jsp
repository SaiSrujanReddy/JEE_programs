 <%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.reg.login.LoginDao" %>
<html>
 <body>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%


RequestDispatcher rd;
String uname=request.getParameter("name");
System.out.println(uname);
String Password=request.getParameter("password");
System.out.println("entered"+Password);



LoginDao dao=new LoginDao();
boolean status=dao.validateUser(uname, Password);
if(status==true) {
	rd=request.getRequestDispatcher("Demo.jsp");
	rd.forward(request, response);
}
else {
	rd=request.getRequestDispatcher("index.jsp");
	request.setAttribute("Invalid", "Invalid userID Password");
	rd.forward(request, response);
}



/* if(name.equals("srujan")){
	
 	 rd=request.getRequestDispatcher("Demo.jsp");
	rd.forward(request,response); 
	

}
else{
	out.println("enter valid user name and password ");
	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	rd.include(request,response);
} */
%>
</body>
</html>