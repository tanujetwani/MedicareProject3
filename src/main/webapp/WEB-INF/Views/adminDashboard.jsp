<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<style>
body{ background-color:peachpuff;}


</style>
</head>
<body>

<h1 align="center">Welcome ${sessionScope.user1.uname} to Admin Portal</h1>

 <a href="/addmedicine">Add A medicine to Product Line</a><br><br>
<a href="/removemedicine">Remove a medicine from Product Line</a><br><br>
<a href="/editdetails">Edit the details of medicine</a><br><br>
<a href="/enablemedicine">Enable or Disable a medicine</a>
 
<br><br><br>
<a href="/logout">Logout</a>
</body>
</html>