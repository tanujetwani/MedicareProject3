<%@ page import="org.simplilearn.entities.Orders" %>
<%@ page import="org.simplilearn.entities.OrderDetails" %>
<%@ page import="java.util.Set" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>


<style>
body{
    
    background-color:mistyrose;

}

</style>
<title>Insert title here</title>
</head>
<body>

<%
       Orders order=(Orders)request.getAttribute("order1");

       if(order!=null){            

%>

<h3>Thanks ${sessionScope.user1.uname} for Shopping with us.Your Order is confirmed.</h3><br><br>

<h3 align="center">Your Order Summary is as below:</h3>

<table class="table">
<tr class="table-success">

<th>Order Id</th>
<th>Order Date</th>
<th>Total Amount Paid(in Rs)</th>

</tr>

<tr class="table-danger">

<th scope="row"><%=order.getOrder_id() %></th>
<td><%=order.getOrder_date() %></td>
<td><%=order.getTotal_amount() %></td>

</tr>


</table>

<br><br><br>

<h3 align="center">Your order details are as below</h3>
<br>
<table class="table">
<tr class="table-success">

<th>Product Id</th>
<th>Product Name</th>
<th>Category</th>
<th>Description</th>
<th>Seller</th>
<th>Price(in Rs)</th>
<th>Quantity</th>
<th>Amount</th>

</tr>



<%
   Set<OrderDetails> ord_details=order.getOrd_details();
   
     for(OrderDetails o: ord_details){
    

%>
<tr class="table-warning">
<th scope="row"><%=o.getProduct().getPid() %></th>
<td><%=o.getProduct().getName() %></td>
<td><%=o.getProduct().getCategory() %></td>
<td><%=o.getProduct().getDescription() %></td>
<td><%=o.getProduct().getSeller() %></td>
<td><%=o.getProduct().getPrice() %></td>
<td><%=o.getQty() %></td>
<td><%=o.getAmount() %></td>

</tr>
<%
     }   //End of for

%>
</table>

<h3 align="center">Total Amount paid: Rs.${total_amount}</h3>
<%

       }    //End of if order!=null

%>

<h3 align="center">${msg}</h3>

<br><br><br>
<a href="/logout">Logout</a>
</body>
</html>