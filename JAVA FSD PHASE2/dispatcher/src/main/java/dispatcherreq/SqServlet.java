package dispatcherreq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SqServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int k=0;
		Cookie cookies[] = req.getCookies();
		
		for(Cookie c : cookies)
		{
			if(c.getName().equals("key"))
				k=Integer.parseInt(c.getValue());
		}
		
		k=k*k;
		
		PrintWriter out = resp.getWriter();
        out.println("result is " +k);
		
		
		
		//(3) httpsession
		//HttpSession session = req.getSession();
        //int k =(int) session.getAttribute("key");
       // k=k*k;
        
        //PrintWriter out = resp.getWriter();
        //out.println("result is " +k);
		
		
		//(2)send redirect
		
		//int k = Integer.parseInt(req.getParameter("k"));
		
		//k=k*k;
		
		//PrintWriter out =  resp.getWriter();
		//out.println("result is " + k);
		
		
		
		
		//(1)request dispatcher
		//int k= (int) req.getAttribute("k");
		//k=k*k;
		//PrintWriter out = resp.getWriter();
		//out.println("square of number is " +k);
		
	}
	
	

}
