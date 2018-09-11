package com.reg.login.forgot;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.reg.login.forgot.*; 
/**
 * Servlet implementation class mailCheck
 */

public class MailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String mail = request.getParameter("mail");
	MailDao dao=new MailDao();
	
	boolean status = dao.validate(mail);
	MailImpl mipl=new MailImpl();
	if(status==true) {
		try {
			  String name = (String) dao.rs.getObject(1);
			  mipl.send(mail,name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	}

}
