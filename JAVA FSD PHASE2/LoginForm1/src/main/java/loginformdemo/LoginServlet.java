package loginformdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		PrintWriter out= resp.getWriter();
		
		String username= req.getParameter("uname");
		String password= req.getParameter("pass");
		
		out.println("Welcome! "+username);
		out.println("Your Password is: "+password);
		
	}
	
}
