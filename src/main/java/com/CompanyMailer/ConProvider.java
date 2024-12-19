package com.CompanyMailer;

import java.sql.*;
public class ConProvider {

	public static Connection getConnection(){
	Connection con=null;
	String Username="root";
	String pwd="12345";
	String url="jdbc:mysql://localhost:3306/CompanyMailer";
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,Username,pwd);
	}catch(Exception e)
	{
		System.out.println(e);
	}
	if(con==null)
	{
		System.out.println("con is null");
	}
	return con;
    }
}
