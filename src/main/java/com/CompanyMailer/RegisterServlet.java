package com.CompanyMailer;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("We reached here");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		
		String name=request.getParameter("name");
		System.out.println(name);
		String password=request.getParameter("password");
		System.out.println(password);
		String email=request.getParameter("email");
		System.out.println(email);
		String gender=request.getParameter("gender");
		System.out.println(gender);
		String dob=request.getParameter("dob");
		System.out.println(dob);
		String addressLine=request.getParameter("addressLine");
		System.out.println(addressLine);
		String city=request.getParameter("city");
		System.out.println(city);
		String state=request.getParameter("state");
		System.out.println(state);
		String country=request.getParameter("country");
		System.out.println(country);
		String contact=request.getParameter("contact");
		System.out.println(contact);
		
		int status=RegisterDao.save(name, email+"@cmailer.com", password, gender, dob, addressLine, city, state, country, contact);
		if(status>0){
			out.print("<p>You are successfully registered!</p>");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
}
