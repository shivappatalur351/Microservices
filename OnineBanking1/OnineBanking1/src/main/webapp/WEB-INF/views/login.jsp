<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}


.login-page {
	width: 360px;
	padding: 8% 0 0;
	margin: 4px 400px 10px 480px;
}

.form {
	position: relative;
	border-radius: 25px;
	z-index: 1;
	background: #d3d3d3;
	max-width: 360px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

.form input {
	font-family: 'Poppins', sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
	border-radius: 25px;
}

.form button {
	font-family: 'Poppins', sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: linear-gradient(-135deg, #346895, #2a2a72, #dcdcdc);
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
	border-radius: 25px;
}

.form button:hover, .form button:active, .form button:focus {
	background: linear-gradient(135deg, #483d8b, #483d8b);
}

.form .message {
	margin: 15px 0 0;
	color: #346895;
	font-size: 14px;
}

.form .message a:hover {
	color: green;
}

.form .message a {
	color: #4682B4;
	text-decoration: none;
	font-size: 16px;
}

.form .register-form {
	display: none;
}

.container {
	position: relative;
	z-index: 1;
	max-width: 300px;
	margin: 0 auto;
}

.container:before, .container:after {
	content: "";
	display: block;
	clear: both;
}

.container .info {
	margin: 50px auto;
	text-align: center;
}

.container .info h1 {
	margin: 0 0 15px;
	padding: 0;
	font-size: 36px;
	font-weight: 300;
	color: #1a1a1a;
}

.container .info span {
	color: #4d4d4d;
	font-size: 12px;
}

.container .info span a {
	color: #000000;
	text-decoration: none;
}

.container .info span .fa {
	color: #EF3B3A;
}

<!--
-->
body {
	background: linear-gradient(135deg, #2a2a72, #346895, #2a2a72);
	background-repeat: no-repeat;
	background-size: 100%, 100%;
	height: 625px;
	font-family: 'Poppins', sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	overflow-y: hidden;
	overflow-x: hidden;
}

.heading {
	background: #333;
	font-family: 'Poppins', sans-serif;
	text-align: center;
	color: #fff;
}

p {
	font-size: 25px;
	font-weight: 350;
	position: relative;
	font-family: Poppins, sans-serif;
}

.msg {
	border-radius: 10px;
	background: gray;
	opacity: .7;
	padding: 10px;
}
</style>

</head>
<body>


	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST" class="register-form">
		<div class="login-page">
			<div class="form">
				<p>
					<b>Login</b>
				</p>
				<br>
				<c:if test="${param.error != null}">

					<div class="msg">Invalid Credentials</div>

				</c:if>
				<c:if test="${param.logout != null}">

					<div class="msg">You have been logged out</div>

				</c:if>
				<div class="a">
					<input type="text" name="username" placeholder="User Name" /> <input
						type="password" name="password" placeholder="Password" />
					<button type="submit">Login</button>

					<p class="message">
						Not registered? <a href="/register">Create an account</a>
					</p>
				</div>
			</div>
		</div>
	</form:form>


</body>
</html>