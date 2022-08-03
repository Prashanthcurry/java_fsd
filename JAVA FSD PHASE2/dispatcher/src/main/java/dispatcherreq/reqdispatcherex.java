package dispatcherreq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class reqdispatcherex extends HttpServlet {
	    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	    {
	    	int i =Integer.parseInt( req.getParameter("num1"));
	    	int j = Integer.parseInt(req.getParameter("num2"));
	    	int k = i+j;
	    	
	    	Cookie cookie = new Cookie("key", k +"");
	    	res.addCookie(cookie);
	    	
	    	//(3)httpsessions
	    	
	    	//HttpSession session = req.getSession();
	    	//session.setAttribute("key",k);
	    	
	    	
	    	//(2) sendredirect
	    	res.sendRedirect("square");// for http session send redirect is necessary
	    	
	    	
	    	//(1)request dispatcher
	    	//req.setAttribute("k", k);
	    	//RequestDispatcher rd = req.getRequestDispatcher("square");
	    	//rd.forward(req, res);
	    
	    	
	    	//res.sendredirect("square?k="+k)//url rewriting
	    	
	    }
}
