package com.reg.login.forgot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MailDao {
Connection con;
PreparedStatement ps;
ResultSet rs;
	public boolean validate(String mailId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "srujan");

		
			ps=con.prepareStatement("select username from REGISTRATION where mail=?");
			ps.setString(1,mailId);
			  
				 rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			else
				return false;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

		
		
		
	
	}
	
	
}
