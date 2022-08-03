package formloginhttpex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class loginservlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		PrintWriter  out= resp.getWriter();
		resp.setContentType("text/html");
		
		String email =req.getParameter("userid");
		String password =req.getParameter("pass");
		
		 if(email.equalsIgnoreCase("prashanth") && password.equalsIgnoreCase("prashanth123")) {
	            //add  user in the session once the login is done
	            HttpSession session=req.getSession();
	            session.setAttribute("username", email);//(key,value)  key can be any characters
	            session.setAttribute("pass", password);
	            resp.sendRedirect("dashboard");
	        }
	        else {
	             out.println("invalid username or password");
	        }
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
