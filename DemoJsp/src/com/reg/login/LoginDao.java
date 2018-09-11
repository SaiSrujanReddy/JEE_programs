package com.reg.login;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.reg.login.CipherDemo;

public class LoginDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public boolean validateUser(String userId, String password) {

		try {

			//Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "srujan");

		
			ps=con.prepareStatement("select PASSWORD from REGISTRATION where USERNAME =?");
			ps.setString(1,userId);
			  
				boolean execute = ps.execute();
			
				 if(execute==true) {
					 System.out.println("before while");
					rs = ps.executeQuery();
				
						while (rs.next()) {
							System.out.println("entered while");
							byte[] encryptionKey = "MZygpewJsCpRrfOr".getBytes(StandardCharsets.UTF_8);
							byte[] cipherText = rs.getString(1).getBytes();
							CipherDemo CipherDemo = new CipherDemo(
			 				        encryptionKey);
							
							try {
								byte[] decryptedCipherText = CipherDemo.decrypt(cipherText);
								String rpwd=new String(decryptedCipherText);
								rpwd=rpwd.trim();
								System.out.println("decripted"+rpwd);
								if(rpwd.equals(password))
								{
									return true;
								
								}else {
								return false;
								}
							}catch (Exception e) {
								System.out.println("Failed due to " + e);
							}
							
						}
						
					}
				else
				return false;
					
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
 
		return false;
	}
}
