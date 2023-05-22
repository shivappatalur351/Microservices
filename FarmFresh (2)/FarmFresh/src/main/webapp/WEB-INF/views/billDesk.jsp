<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<body bgcolor="lavender"> <center>
<h2>Farm Fresh - A natural farm store!!</h2>
					
			<!--  Design the page as per the requirements-->
			
			Product Name:${product.productName}<br>
			Quantity    :${product.quantity }<br>
			Cost Per Kg :${product.costPerKg }<br>
			TotalCost Rs:${cost}
			
	</center>	
	
	</body>
</html>