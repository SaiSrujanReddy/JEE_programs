<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String invalid=request.getParameter("Invalid"); 
if(invalid!=null){
	out.println(invalid);
}

%>
<form action="actiontags/forward.jsp">
<input type="text" name="name" placeholder="username">
<input type="text" name="password" placeholder="password">
<input type="submit" value="go">
</form>
</body>
</html>