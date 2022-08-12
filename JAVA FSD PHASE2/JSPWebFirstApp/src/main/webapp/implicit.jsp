<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
  String responseCheck=request.getParameter("office");
	if(responseCheck!=null){
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "response-redirect.jsp?office="+responseCheck);
	}
%>

<%
String error=request.getParameter("error");
if(error!=null){
	throw new RuntimeException("Exception Occured");
}
%>

<a href="implicit.jsp?office=head_office">Check use of response and request object</a>

<a href="implicit.jsp?error=1">Check use of Exception Object</a>
<br><br>

<%
	String serverName=request.getServerName();
	out.print("Server Name: "+serverName+"<br>");
	out.print("Servlet Name: "+config.getServletName()+"<br>");
	out.print("Server Info: "+application.getServerInfo()+"<br>");
	out.print("Page Details: "+page.toString()+"<br>");
	pageContext.setAttribute("userid", "test@gmail.com");
	
	out.print("Page  Context Attributr: "+pageContext.getAttribute("userid"));
	
%>

</body>
</html>