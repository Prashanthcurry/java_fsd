<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>

<div>
    
     Welcome to FlyAway
     
     User Registration 
     
     <form action="UserRegistration" method="post" >
        
        Name <input name="name"  type="text" maxlenght=50><br>
        Email <input name="email" type="text"  maxlength=100><br>
        Password <input name="password" type="password" maxlength="20"><br>
  
        <button type="submit" value="Submit">Sign Up</button>
     
     </form>
     
    
    </div>
    
    
</body>
</html>