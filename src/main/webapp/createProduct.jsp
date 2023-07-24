<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Product</title>
</head>
<body>
	<h1>Create Coupon</h1>
	<form action = "product" method = "post">
		<pre>
			Name : <input type = "text" name = "name"/>
			Description : <input type = "text" name = "description"/>
			Price : <input type = "text" name = "price"/>
			CouponCode : <input type = "text" name = "couponCode"/>
			<input type = "submit" value = "save"/>
		</pre>
	</form>
</body>
</html>