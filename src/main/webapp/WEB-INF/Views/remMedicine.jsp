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
<h3>Remove Medicine By Id</h3>
<form action="/removeByid">
Id:<input type="text" name="id"><br><br>
<button class="btn btn-primary">Remove Medicine</button>

</form>

<br><br><br>

<h3>Remove Medicine By Category</h3>
<form action="remByCategory" method="post">
Category:<select name="category">
         <option value="fever">Fever Medicine</option>
         <option value="cold">Cold Medicine</option>
         <option value="cough">Cough Medicine</option>
         <option value="allergy">Allergy medicine</option>
         <option value="heart">Heart Medicine</option>

</select><br><br>
<button class="btn btn-primary">Remove Medicine</button>
</form>
<br><br><br>

<h3>Remove Medicine By Name</h3>
<form action="/remByName">
Name:<input type=text name="name">
<button class="btn btn-primary">Remove Medicine</button>

</form>
<br><br>
<h3>${msg}</h3>
<br><br>
<a href="/gotoadminhome">Go To Admin Home</a>
</body>
</html>