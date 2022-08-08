package CRUDEX;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class FetchDBServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	
	PrintWriter out= resp.getWriter();
	resp.setContentType("text/html");
	Properties  props= new Properties();
	
	InputStream in=getServletContext().getResourceAsStream("/WEB-INF/application.properties");
	props.load(in);
	
	
	Connection conn= DBConfig.getConnection(props);
	
	if(conn!=null)
	{
		try {//*important this try and catch for fetching data from database table eproduct 
		
			Statement stmt = conn.createStatement();
			ResultSet  rs=stmt.executeQuery("select * from eproduct");
		
			while(rs.next()) {
			out.println(rs.getInt(1)+" ,"+rs.getString(2)+", "
					+rs.getBigDecimal(3)+", "
					+rs.getTimestamp(4)+"<br>");
			}
		}
		
		
		
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	else {
		
		out.print("Error While Connecting Connections");
	}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
