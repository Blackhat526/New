package com.CompanyMailer;
import java.sql.*;
import java.util.Formatter;
public class RegisterDao {

	public static int save(String name,String email,String password,String gender,String dob,String addressLine,String city,String state,String country,String contact){
		int status=0;
		java.sql.Date sqlDOB=new java.sql.Date(System.currentTimeMillis());
		try{
			System.out.println("Getting connection");
			Connection con=ConProvider.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into company_mailer_user(name,email,password,gender,dob,addressLine,city,state,country,contact,registerddate,authorized) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			//ps.setInt(1,1);
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,password);
			ps.setString(4,gender);
			ps.setDate(5,sqlDOB);
			ps.setString(6,addressLine);
			ps.setString(7,city);
			ps.setString(8,state);
			ps.setString(9,country);
			ps.setString(10,contact);
			ps.setDate(11,sqlDOB);
			ps.setString(12,"yes");
			System.out.println("About to execute the query");
			status=ps.executeUpdate();
						
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
}
