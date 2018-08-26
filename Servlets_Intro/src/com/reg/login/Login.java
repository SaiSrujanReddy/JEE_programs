package com.reg.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.reg.demo.CipherDemo;;
/**
 * Servlet implementation class Login
 */
@WebServlet("")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
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


	public void destroy() {
		
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		
		String uname=request.getParameter("uname");
		System.out.println(uname);
		String Password=request.getParameter("pwd");
		System.out.println(Password);
		try {
			ps=con.prepareStatement("select USERNAME from Registration");
			 rs = ps.executeQuery();
			while(rs.next()) {
				String runame=rs.getString(1);
				runame=runame.trim();
				System.out.println(runame);
				if(uname.equals(runame)) {
					ps=con.prepareStatement("select PASSWORD from Registration");
					 rs = ps.executeQuery();
					while (rs.next()) {
						byte[] encryptionKey = "MZygpewJsCpRrfOr".getBytes(StandardCharsets.UTF_8);
						byte[] cipherText = rs.getString(1).getBytes();
						CipherDemo CipherDemo = new CipherDemo(
						        encryptionKey);
						try {
							byte[] decryptedCipherText = CipherDemo.decrypt(cipherText);
							String rpwd=new String(decryptedCipherText);
							rpwd=rpwd.trim();
							System.out.println(rpwd);
							if(rpwd.equals(Password))
							{
								out.println("success");
							
							}else {
								out.print("incorrect password");
							}
						}catch (Exception e) {
							// TODO: handle exception
						}
						
					}
					
				}
				else {
					out.println("Invalid username");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
