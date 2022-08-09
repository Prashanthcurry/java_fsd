package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
@WebServlet("/fetch")
public class AddProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out= resp.getWriter();
		resp.setContentType("text/html");
		SessionFactory factory= HibernateUtils.getSessionFactory();
		Session session= factory.openSession();
		
		
		Transaction tx= session.beginTransaction();
		
		
		String name =req.getParameter("pname");
		BigDecimal price = new BigDecimal(req.getParameter("pprice"));
		
		Product p1= new Product();
		p1.setName(name);
		p1.setPrice(price);
		session.save(p1);
		tx.commit();
		
		session.close();
		out.print("<h2>Product Successfully Added !</h2>");
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}


}
