package Dbconnection;

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

@WebServlet("/connect")
public class DBConnect extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out=resp.getWriter();
		
		Properties props=new Properties();
		
		resp.setContentType("text/html");
		
		InputStream in= getServletContext().getResourceAsStream("/WEB-INF/application.properties");
		props.load(in);
		
		Connection conn=DBConfig.getConnection(props);
		
		if(conn!=null)
		{
			out.println("Connection is established ");
		
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
		
		else
		{
			out.print("Error  While  Connecting");
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	

}
