<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>First JSP Demo</h1>
<% out.print("Hello World"); %>
<br>
<h2>Screptlet Example</h2>
<% String name="Nikunj Soni"; %>
<% 
        int a=10;
    int b=20;
    int c  =a+b;
    out.print("Result is : "+c);
%>
<br>
<h2>Expression</h2>
<%="My name is: "+name %>
<br>
<!-- -jav code -->
<%! int cube(int n){
	 return n*n*n;
	}
%>
<%= "cube of 5 is: "+cube(5) %>
<br>
<%= new java.util.Date() %>

<br>
<a href="implicit.jsp">Click here For Implicit demo</a>

</body>
</html>