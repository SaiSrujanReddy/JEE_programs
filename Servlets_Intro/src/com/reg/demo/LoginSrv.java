package com.reg.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginSrv implements Servlet {
ServletConfig config;
int count;
Calendar cal=Calendar.getInstance();
	@Override
	public void destroy() {
		
		
	}

	@Override
	public ServletConfig getServletConfig() {

		return null;
	}

	@Override
	public String getServletInfo() {

		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("uname");
		out.println(name);
		String password=req.getParameter("pwd");
		out.println(password);
		
		
		count=count+1;
		out.print(count);
		ServletContext servletContext = config.getServletContext();
		servletContext.setAttribute("count", new Integer(count));
		Integer test = (Integer) servletContext.getAttribute("count");
		out.println(test);
		count=test;
		out.println("these many userd"+count);
		
		if(name.equals("srujan")&&password.equals("sunny"))	{
				servletContext.setAttribute("calendar", cal);
				Calendar demo = (Calendar) servletContext.getAttribute("calendar");
				out.print("last login is "+demo.getTime());
				cal=Calendar.getInstance();
				servletContext.setAttribute("calendar", cal);	
				out.println("sucessfully registered");
		}
		
		
		else if(name.equals("sai")&&password.equals("reddy")) {
				servletContext.setAttribute("calendar", cal);
				Calendar demo = (Calendar) servletContext.getAttribute("calendar");
				out.print("last login is "+demo.getTime());
				cal=Calendar.getInstance();
				servletContext.setAttribute("calendar", cal);	
				out.println("sucessfully registered");}
		
		else
		out.println("Invalid user name and password");

	}

}
