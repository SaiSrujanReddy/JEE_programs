package com.reg.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.reg.demo.CipherDemo;


public class Registration extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	 @Override
	public void init(ServletConfig config) throws ServletException {
		 ServletContext context = config.getServletContext();
		 String path = context.getInitParameter("path");
		 System.out.println(path);
		 String uname = context.getInitParameter("uname");
		 System.out.println(uname);
		 String password=context.getInitParameter("password");
		 System.out.println(password);
		 try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection(path,uname,password);
			System.out.println("Regis connection done");
		} catch (SQLException | ClassNotFoundException e) {
		
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	
	}
	
	
  
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		long phoneNo=Integer.parseInt(request.getParameter("PhoneNo"));
		System.out.println(phoneNo);
Map<String, String[]> feild = request.getParameterMap();
		
		
		try {	
			
			out.print("Starting");
			ps=con.prepareStatement("insert into Registration values(?,?,?,?,?,?)") ;
		
		Set<String> st = feild.keySet();
			
		Iterator<String> it = st.iterator();
		int i=1;
		while(it.hasNext()) {
			String Dfeild=it.next();
			
			if(Dfeild.equals("password")) {
					String password=request.getParameter(Dfeild);
					byte[] encryptionKey = "MZygpewJsCpRrfOr".getBytes(StandardCharsets.UTF_8);
				byte[] plainText = password.getBytes(StandardCharsets.UTF_8);
				CipherDemo CipherDemo = new CipherDemo(
				        encryptionKey);
				try {
					byte[] cipherText = CipherDemo.encrypt(plainText);
					ps.setString(2, new String(cipherText));
					i=3;
					System.out.println("done");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			else if(Dfeild.equals("PhoneNo")) {
				ps.setLong(5, phoneNo);
				i=6;
				System.out.println("done");	
			}
			else{
			String[] values = feild.get(Dfeild);
			String value="";
			for(String val:values) {
				value=value+" "+val;
				
			}
			System.out.println(value);
			System.out.println(i);
			value=value.trim();
			ps.setString(i, value);
			i++;
			
			}
		}     
		
			out.println("before update");
			
			int j=ps.executeUpdate();
		
			out.println(j+"rows updated");
			out.println("rows after updateing are ");
			response.sendRedirect("Login.html");
	}
		 catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			
		}
		@Override
		public void destroy() {
			try {			
				con.close();			
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			super.destroy();
		}

}
