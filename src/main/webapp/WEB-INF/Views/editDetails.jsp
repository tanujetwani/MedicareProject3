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

<h1>Edit the Details</h1>

<form action="/searchwithid">
Enter Id of the medicine:<input type=text name="pid">
<button class="btn btn-primary btn-sm">Search Medicine</button> 
</form>

<br><br><br>
<%
         Product product=(Product)request.getAttribute("product2");

         if(product!=null){
%>
<h2>Below are the details of medicine</h2>
<form action="/editDet">
Id:<b><%=product.getPid() %></b><br><br> 
Name:<b><%=product.getName() %></b> <input type=text name="name"><br><br>
Category:<b><%=product.getCategory() %></b><select name="category">
                                  <option value="fever">Fever Medicine</option>
                                  <option value="cold">Cold Medicine</option>
                                  <option value="cough">Cough Medicine</option>
                                  <option value="allergy">Allergy medicine</option>
                                  <option value="heart">Heart Medicine</option>    
                                 </select><br><br>
                                 
Description:<b><%=product.getDescription() %></b><input type=text name="description"><br><br>
Seller:<b><%=product.getSeller() %></b><input type=text name="seller"><br><br>
Price:<b><%=product.getPrice() %></b><input type=text name="price"><br><br>
<button class="btn btn-primary">Edit the details</button> 
</form>   
<%
}  //End of if product!=null
%>
<h2>${msg1 }</h2>                            

<br><br><br>
<a href="/gotoadminhome">Go To Admin Home</a>
</body>
</html>