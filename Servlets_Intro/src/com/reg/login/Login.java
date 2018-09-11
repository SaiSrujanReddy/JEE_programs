package com.reg.login;
import com.reg.login.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reg.demo.CipherDemo;;
/**
 * Servlet implementation class Login
 */
@WebServlet("")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		PrintWriter out=response.getWriter();
		
		RequestDispatcher rd;
		String uname=request.getParameter("uname");
		System.out.println(uname);
		String Password=request.getParameter("pwd");
		System.out.println("entered"+Password);
		LoginDao dao=new LoginDao();
		boolean status=dao.validateUser(uname, Password);
		if(status==true) {
			rd=request.getRequestDispatcher("Welcome.html");
			rd.forward(request, response);
		}
		else {
			rd=request.getRequestDispatcher("Login.html");
			request.setAttribute("Invalid", "Invalid userID Password");
			rd.forward(request, response);
		}
		try {
			dao.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		
		   

	}

}
