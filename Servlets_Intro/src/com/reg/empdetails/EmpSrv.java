package com.reg.empdetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.NetworkChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EmpSrv extends GenericServlet{
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	 @Override
	public void init(ServletConfig config) throws ServletException {
		 try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srujan");
			System.out.println("done");
		} catch (SQLException | ClassNotFoundException e) {
		
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		Enumeration<String> s=req.getParameterNames();
		while(s.hasMoreElements()) {
			out.println(s.nextElement());
		}
/*		String firstName=req.getParameter("fname");
		String lastName=req.getParameter("lname");
		String gender=req.getParameter("gender");
		String address=req.getParameter("address");
		String birthday=req.getParameter("bday");
		
		*/
		
	
			
		int phoneNo=Integer.parseInt(req.getParameter("PhoneNo"));
		/*String mail=req.getParameter("mail");
		String[] Hobbie = req.getParameterValues("Hobbies");
		String Hobbies="";
		for(String s:Hobbie) {
			Hobbies=s+" "+Hobbies;
		}*/
		
		
		/*	ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, gender);
		ps.setString(4, birthday);
		ps.setString(5, address);
		ps.setInt(6,phoneNo );
		ps.setString(7, mail);
		ps.setString(8, Hobbies);*/
	Map<String, String[]> feild = req.getParameterMap();
		
		
		try {	
			
			out.print("Starting");
			ps=con.prepareStatement("insert into EMPREGSITER values(?,?,?,?,?,?,?,?)") ;
		
		Set<String> st = feild.keySet();
			
		Iterator<String> it = st.iterator();
		int i=1;
		while(it.hasNext()) {
			String Dfeild=it.next();
			if(Dfeild.equals("PhoneNo")) {
				ps.setInt(6, phoneNo);
				i=7;
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
			ps.setString(i, value);
			i++;
			
			}
		}     
		
			out.println("before update");
			
			int j=ps.executeUpdate();
		
			out.println(j+"rows updated");
			out.println("rows after updateing are ");
			ps=con.prepareStatement("select * from EMPREGSITER");
			rs = ps.executeQuery();
			while(rs.next()) {
				out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getInt(6)+"  "+rs.getString(7)+"  "+rs.getString(8));
			}
			
			
		} catch (SQLException e) {
			
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
