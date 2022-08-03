package hiddenfieldex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		
		String token= req.getParameter("userid");
		
		out.print("<form  action='dashboard' method='post'>");
		out.print("<input type='hidden'name='userid' value='"+token+"'>");
		out.print("<input type='submit' value='Dashboard'>");
		out.print("</form>");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
