package com.simplilearn.demo;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
@WebServlet("/save")
public class SaveServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out= resp.getWriter();
		
		SessionFactory factory= HibernateUtils.getSessionFactory();
		Session session= factory.openSession();
		
		
		Transaction tx= session.beginTransaction();
		
		Student s1=new Student("sarvesh", "sarvesh@gmail.com", "sarvesh@123");
		session.save(s1);
		
		tx.commit();
		
		session.close();
		out.print("Data inserted Successfully");
		
		 
		
		
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
}
}
