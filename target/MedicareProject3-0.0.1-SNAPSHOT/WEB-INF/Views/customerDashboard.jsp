<%@page import="java.util.List" %>
<%@page import="org.simplilearn.entities.Product" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cust Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<style>
body{
   
   background-color:lightgreen;

}


</style>
</head>
<body>
<h1 align="center">Welcome ${sessionScope.user1.uname} to Customer Dashboard </h1><br>
<h3 align="center">Search Form</h3><br>
<div align="center">
<form action="/searchProd" method="get" >

Enter your search keyword:<input type=text maxlength="100" name="searchkey" >

<button class="btn btn-primary btn-sm">Search</button>


</form>
</div>
<br><br><br>

<h2 align="center">${msg}</h2>
<%List<Product> products=(List<Product>)request.getAttribute("listofproducts");

if (products!=null){



%>

<h3 align="center">Search Results based on keyword "${keyword1}"</h3>
<table class="table">

<tr class="table-warning">

<th><a href="/sortByName">Name</a></th>
<th><a href="/sortByCategory">Category</a></th>
<th>Description</th>
<th><a href="/sortBySeller">Seller</a></th>
<th><a href="/sortByPrice">Price(in Rs)</a></th>

</tr>

<%// List<Product> products=(List<Product>)request.getAttribute("listofproducts") ;
      
      for(Product p : products){




%>
<tr class="table-danger">

<th scope="row"><%=p.getName() %></th>
<td><%=p.getCategory() %></td>
<td><%=p.getDescription() %></td>
<td><%=p.getSeller() %></td>
<td><%=p.getPrice() %></td>

<td>

<form action="/addToCart" method="post">
<input type=hidden name="pid" value="<%=p.getPid()%>">
<button class="btn btn-primary btn-sm" id="addtc" name="button1">Add To Cart</button>
</form>
</td>

<td>
<form action="/removefromcart" method="post">
<input type=hidden name="pid" value="<%=p.getPid() %>">
<button class="btn btn-primary btn-sm">Remove from Cart</button>
</form>
</td>
 
</tr>
<%
      }//End of for

      
//}   //End of if
%>
</table>
<br><br>
<h4 align="center">Clicking on the link of Table Column headings will sort the result in ascending order </h4>


 
<%

}   //End of if products!=null
%>
<h4 align="center">${msg2}</h4>

<div align="center">
<form action="/viewCart" method="get">
<button class="btn btn-primary ">View Cart</button>
</form>
</div>


</body>
</html>