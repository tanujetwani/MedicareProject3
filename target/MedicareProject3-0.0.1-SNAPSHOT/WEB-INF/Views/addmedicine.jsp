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
body{ background-color:peachpuff;}


</style>
</head>
<body>

<h1 align="center">Add a medicine</h1>

<form action="/addmed" method="post">
Name:<input type=text name="name"><br><br>
Category:<select name="category">
         <option value="fever">Fever medicine</option>
         <option value="cold">Cold Medicine</option>
         <option value="cough">Cough Medicine</option>
         <option value="allergy">Allergy medicine</option>
         <option value="heart">Heart Medicine</option>
</select><br><br>
Description:<input type=text name="description"><br><br>
Seller:<input type=text name="seller"><br><br>
Price(in Rs):<input type=text name="price"><br><br>
Is Available:<select name="isAvailable">
             <option value="true">Yes</option>
             <option value="false">No</option>
</select><br><br>
<button class="btn btn-primary">Add medicine</button>
</form>

<h2>${msg}</h2>

<br><br><br>
<a href="/gotoadminhome">Go Back to Admin Home</a>
</body>
</html>