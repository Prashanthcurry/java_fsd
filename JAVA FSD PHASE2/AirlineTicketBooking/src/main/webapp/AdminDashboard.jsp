<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
<%@page import="com.flyaway.AdminLogin"%>

<%
    String driverName = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/";
    String dbName = "flyawaydb";
    String userId = "root";
    String password = "Prashanth@30#2000";
    try {
        Class.forName(driverName);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
%>  


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
</head>
<body>

<%
    if (AdminLogin.isLoggedIn) {
%>
<h2 align="center"><b>Admin Dashboard</b></h2>

<div class="row">
        <div >
            <form method="post" action="${pageContext.request.contextPath}/PasswordChange.jsp">
                <button type="submit" >Change Password</button>
            </form>&ensp;
        </div>
       
        <div >
            <form method="post" action="${pageContext.request.contextPath}/AdminLogin.jsp">
                <button type="submit" >Logout</button>
            </form>
        </div>
        <br>
</div>



<section >
    <section >
        <section>
            <table >
                <thead>
                <tr>
                    <th scope="col">Flight ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Source</th>
                    <th scope="col">Destination</th>
                    <th scope="col">Day</th>
                    <th scope="col">Ticket Price</th>
                </tr>
                </thead>
                <tbody>
               
                <p align="center"><span><strong> Flight Table </strong></span></p>
                <%
                    try{
                        connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
                        statement=connection.createStatement();
                        String sql ="SELECT * FROM flight";
                        resultSet = statement.executeQuery(sql);
                        while(resultSet.next()){
                %>
                <tr>
                    <td><%=resultSet.getString("FlightId") %></td>
                    <td><%=resultSet.getString("Name") %></td>
                    <td><%=resultSet.getString("Source") %></td>
                    <td><%=resultSet.getString("Destination") %></td>
                    <td><%=resultSet.getString("Day") %></td>
                    <td><%=resultSet.getString("TicketPrice") %></td>
                </tr>
                
                
                <%
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        out.print("You must Login first");
                    }
                %>
                </tbody>
            </table>
        </section>
    </section>
</section>


</body>
</html>