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
body{ background-color:peachpuff;

}

</style>
</head>
<body>


<h1><i>Payment Gateway</i></h1>
<br>

<h2>Amount to be paid=Rs.${sessionScope.tot_amt}</h2>
<br><br>
<h2><i>Enter your card details below</i></h2>
<form action="/paytheamount" method="post">
Card no.:<input type="number" name="first" pattern="[0-9]{4}">&nbsp;<input type=number name="second" pattern="[0-9]{4}" maxlength="4">&nbsp;<input type=number name="third" pattern="[0-9]{4}">&nbsp;
                <input type="number" name="fourth" pattern="[0-9]{4}">
<br><br>
Valid thru:<select name="validmonth">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option><option value="8">8</option>
            <option value="9">9</option><option value="10">10</option>
            <option value="11">11</option><option value="12">12</option>
            </select> /<select  name="validyear"><option value="24">24</option>
                                                 <option value="25">25</option>
                                                 <option value="26">26</option>
                                                 <option value="27">27</option>
                                               </select>
                                               <br><br>
CVV:<input type=number name="cvv" pattern="[1-9][0-9]{2}">
<br><br> 
Card Type: <select name="cardType">
           <option value="Visa">Visa</option>
           <option value="MasterCard">MasterCard</option>
           <option value="Citigroup">Citigroup</option>
           <option value="American Express">American Express</option>
</select>
<br><br>
<button style="background-color:green" class="btn btn-primary">Submit</button>   

</form>
      
<h3>${msg}</h3>

</body>
</html>