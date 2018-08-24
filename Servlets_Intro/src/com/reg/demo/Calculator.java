package com.reg.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Calculator implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		try {
		double n1=Integer.parseInt(req.getParameter("num1"));
		double n2=Integer.parseInt(req.getParameter("num2"));
		
		String op=req.getParameter("do");
		PrintWriter out=resp.getWriter();
	
		switch(op) {
		
		case "Addition":out.println("the sum of two numbers is : "+(n1+n2));
					break;
		case "substaction":out.println("the sum of two numbers is : "+(n1-n2));
					break;
		case "multiplication":out.println("the sum of two numbers is : "+(n1*n2));
					break;			
		case "division":out.println("the sum of two numbers is : "+(n1/n2));
					break;
		default:out.println("not qiute sure");			
		}
		}catch (Exception e) {
			PrintWriter out=resp.getWriter();
			out.println("Enter valid numbers");
		}
		
		}

}
