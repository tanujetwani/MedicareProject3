<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

<style>
*{
   font-family: "Times New Roman", Times, serif;
}
body{
     background-color:hotpink;

}
</style>
</head>
<body>

<h1><i>Register</i></h1>
<form action="/registerUser" method="post">
Username: <input type=text name="name" class="form-control"><br>
Password: <input type=password name="pwd" class="form-control"><br>
Phone No.:<input type=text name="phone" class="form-control"><br>
Email:<input type=text name="email" class="form-control"><br>
Address:<input type=text name="address" class="form-control"><br>
UserType:<select class="custom-select" name="uType">
         <option value="Customer">Customer</option>
         <option value="Admin">Admin</option>
         </select>
<br><br><br>
 <button class="btn btn-primary" style="background-color:green;">Register</button>        
</form>
<br><br>
<h4>${msg}</h4>
</body>
</html>