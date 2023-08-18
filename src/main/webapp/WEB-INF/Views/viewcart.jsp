<%@ page import="java.util.List" %>
<%@ page import="org.simplilearn.entities.Cart" %>
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
body{
    
    background-color:khaki;

}

</style>
</head>
<body>

<h2 align="center">Cart Details of User ${sessionScope.user1.uname}</h2>
<br><br><br>
<table class="table">

<tr class="table-danger">
<th>Product Id</th>
<th>Product Name</th>
<th>Category</th>
<th>Description</th>
<th>Seller</th>
<th>Price(in Rs)</th>
<th>Quantity</th>

</tr>



<%
       List<Cart> carts=(List<Cart>)request.getAttribute("listofcarts");

        for(Cart c: carts){



%>
<tr class="table-success">
<th scope="row"><%=c.getProd().getPid() %></th>
<td><%=c.getProd().getName() %></td>
<td><%=c.getProd().getCategory() %></td>
<td><%=c.getProd().getDescription() %></td>
<td><%=c.getProd().getSeller() %></td>
<td><%=c.getProd().getPrice() %></td>
<td><%=c.getQty() %></td>

<td>
<form action="/remfromcart">
<input type=hidden name="pid" value="<%=c.getProd().getPid() %>">
<button class="btn btn-primary" name="rembutton">Remove From Cart</button>

</form>
</td>

</tr>

<%

        }  //End of for
%>
</table>
<br><br><br>
<h3 align="center">${msg }</h3>
<br><br><br><br>
<div align="center">
<form action="/buytheproducts" >
<button class="btn btn-primary">Buy the Products</button>

</form>

</div>
<br><br><br>
<div align="center">
<form action="/gotosearchform">
<button class="btn btn-primary">Go back to Search form</button>

</form>

</div>
<!-- <h3 align="center">${msg}</h3> -->

</body>
</html>