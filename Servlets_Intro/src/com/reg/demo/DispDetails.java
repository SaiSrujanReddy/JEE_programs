package com.reg.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DispDetails implements Servlet{

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
	public void init(ServletConfig arg0) throws ServletException {
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
	/*	String name=req.getParameter("uname");
	//	int Marks=Integer.parseInt(req.getParameter("mrk"));
		int age=Integer.parseInt(req.getParameter("age"));*/
		//int n2=Integer.parseInt(req.getParameter("n2"));    
		PrintWriter out=resp.getWriter();
		out.println("Hi ");
	/*if(age>=18)
		out.println("you are eligible for voting");
	else
		out.println("Sorry you are not eligible for voting");*/
	}

}
