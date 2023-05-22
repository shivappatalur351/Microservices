<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body style="background-color:lavender">


<!--  Design the page as per the requirements-->
<form:form method="post" action="bill" modelAttribute="product">
<h1>Sameeeenaaa</h1>

<form:errors></form:errors>
<center> <h2>Farm Fresh - A natural farm store!!</h2></center>

<table style="margin: 0px auto; margin-left: auto; margin-right:auto">
<tr>
<td>Select Product:</td>
<td><form:select path="productName" id="productName">
 <form:options items="${productNames}"/> 
</form:select></td>
<br>
<br>
</tr>
<tr>
<td> Quantity:</td>
<td><form:input path="quantity" id="quantity"/></td>
<td><form:errors path="quantity" id="errormsg"/></td> 
<form:form method="get" action="exception">

<br>
<br>
<tr>
<td><input type="submit" id="submit" name="submit" value="calculate cost"/></td>

</form:form>
</form:form>
</table>
</body>
</html>	 	  	    	    	     	      	 	
