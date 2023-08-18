<%@ page import="org.simplilearn.entities.Product" %>
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
<h2>Enable or Disable a Medicine</h2>

<form action="/searchwithid2">
Enter Id of medicine:<input type=text name="pid">
<button class="btn btn-primary">Search Medicine</button>
</form>
<br><br>
<h3>${msg1} </h3>

<%
    Product product=(Product)request.getAttribute("product2");
    
       if(product!=null){
%>

<h3>Name of Medicine :<%=product.getName() %></h3> 
<br>

<form action="/enableordisable" method="post">
<div class="form-check form-check-inline">
<input class="form-check-input" type=radio name="enable" value="true"><label>Enable</label>
</div>
<div class="form-check form-check-inline">
<input class="form-check-input" type=radio name="enable" value="false"><label>Disable</label>
</div>
<button class="btn btn-primary">Submit</button>
</form>

<%
       }
%>

<br><br><br>
<a href="gotoadminhome">Go To Admin Home</a>
</body>
</html>