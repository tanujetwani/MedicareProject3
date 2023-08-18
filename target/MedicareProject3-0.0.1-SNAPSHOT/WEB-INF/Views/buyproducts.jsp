<%@ page import="java.util.List" %>
<%@ page import="org.simplilearn.entities.Cart" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

<title>Insert title here</title>
<style>
body{
    
    background-color:pink;

}

</style>
</head>
<body>

<h2 align="center">List of products to be bought </h2>

<%  List<Cart> carts=(List<Cart>)request.getAttribute("listofcarts");

    if(carts!=null){

%>

<table class="table">
<tr class="table-success">

<th>Product ID</th>
<th>Product Name</th>
<th>Category</th>
<th>Description</th>
<th>Seller</th>
<th>Price(in Rs)</th>
<th>Quantity</th>
<th>Amount of Product</th>

</tr>



<%  // List<Cart> carts=(List<Cart>)request.getAttribute("listofcarts");

      for(Cart c:carts){

%>
<tr class="table-warning">
<th scope="row"><%=c.getProd().getPid() %></th>
<td><%=c.getProd().getName() %></td>
<td><%=c.getProd().getCategory() %></td>
<td><%=c.getProd().getDescription() %></td>
<td><%=c.getProd().getSeller() %></td>
<td><%=c.getProd().getPrice() %></td>
<td><%=c.getQty() %></td>
<td><%=c.getQty()*(c.getProd().getPrice()) %></td>

</tr>

<%
   // double total_amt=+(c.getQty()*(c.getProd().getPrice()));

      } //End of for

%>

</table>
<br><br><br>
<h2 align="center">Total amount to be paid : ${total_amount}</h2>
<br><br>


<div align="center">
<form action="/paymentGateway">
<button class="btn btn-primary" style="background-color:green;">Pay the Amount</button>
</form>

</div>
<%
    } //End of if carts!=null

%>
<!--  <h3 align="center">${msg1 }</h3> -->
<br><br><br>
<div align="center">
<form action="/viewCart">
<button class="btn btn-primary">Go Back to View Cart</button>
</form>
</div>
<br><br>
<a href="/logout">Logout</a>
</body>
</html>