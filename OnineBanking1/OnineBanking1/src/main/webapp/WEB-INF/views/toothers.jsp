<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!---<title> Responsive Registration Form | CodingLab </title>--->

<meta name="viewport" content="width=device-width, initial-scale=1.0">
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

body .nit {
	height: 90vh;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 10px;
	background-image: url(images/slider/deposit.jpg);
	background: linear-gradient(135deg, #2a2a72, #346895, #2a2a72);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}

.container {
	max-width: 700px;
	width: 100%;
	background: #d3d3d3;
	padding: 25px 30px;
	border-radius: 5px;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.15);
}

.container .title {
	font-size: 25px;
	font-weight: 500;
	position: relative;
}

.container .title::before {
	content: "";
	position: absolute;
	left: 0;
	bottom: 0;
	height: 3px;
	width: 30px;
	border-radius: 5px;
	background: linear-gradient(135deg, #71b7e6, #9b59b6);
}

.content form .user-details {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	margin: 20px 0 12px 0;
}

form .user-details .input-box {
	margin-bottom: 15px;
	width: calc(100%/ 2 - 20px);
}

form .input-box span.details {
	display: block;
	font-weight: 500;
	margin-bottom: 5px;
}

.user-details .input-box input {
	height: 45px;
	width: 100%;
	outline: none;
	font-size: 16px;
	border-radius: 5px;
	padding-left: 15px;
	border: 1px solid #ccc;
	border-bottom-width: 2px;
	transition: all 0.3s ease;
}

.user-details .input-box input:focus, .user-details .input-box input:valid
	{
	border-color: #9b59b6;
}

form .button {
	height: 30px;
	margin: 20px 0
}

form .button input {
	height: 100%;
	width: 100%;
	border-radius: 5px;
	border: none;
	color: #fff;
	font-size: 18px;
	font-weight: 500;
	letter-spacing: 1px;
	cursor: pointer;
	transition: all 0.3s ease;
	background: linear-gradient(135deg, #71b7e6, #00006b);
}

form .button input:hover {
	/* transform: scale(0.99); */
	background: linear-gradient(-135deg, #71b7e6, #00006b);
}

@media ( max-width : 584px) {
	.container {
		max-width: 100%;
	}
	form .user-details .input-box {
		margin-bottom: 15px;
		width: 100%;
	}
}

.content form .user-details {
	max-height: 300px;
	overflow-y: scroll;
}

.user-details::-webkit-scrollbar {
	width: 5px;
}

}
@media ( max-width : 459px) {
	.container .content .category {
		flex-direction: column;
	}
}

body {
	background-repeat: no-repeat;
	height: 100%;
	background-size: cover;
	background: #333;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}

.active {
	background-color: green;
}

.h {
	color: red;
}

.h1 {
	color: green;
}

.h3 {
	color: red;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: green;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}
</style>
</head>
<body>
	<div>
		<ul>
			<li><a href="/">Home</a></li>
			<li><a href="/deposit">Deposit</a></li>
			<li><a href="/withdrawl">Withdraw</a></li>
			<li><a href="/toself">Transfer to Self</a></li>
			<li class="active"><a href="/toothers">Transfer to Others</a></li>
			<li>
				<div class="dropdown">
					<button class="dropbtn">
						History <i class="fa fa-caret-down"></i>
					</button>
					<div class="dropdown-content">
						<a href="/depositHistory">Deposit</a> <a href="/withDrawHistory">Withdraw</a>
						<a href="/transactionHistory">Transcation-Others</a>
					</div>
				</div>
			</li>
			<li><a href="/admin/home">Admin</a></li>
			<li style="float: right"><a> <form:form
						action="${pageContext.request.contextPath}/logout" method="post">
						<input type="submit" value="Logout"
							style="color: white; background-color: #333; border-radius: 10px">
					</form:form></a></li>
		</ul>
	</div>
	<div class="nit">
		<div class="container">
			<div class="title">Other Account Transfer</div>
			<div class="content">
				<c:choose>
					<c:when test="${isToOthers == 1}">
						<h3 class="h1">Transferred Successful</h3>

						<br>
					</c:when>

					<c:when test="${isToOthers == 0}">
						<h3 class="h">Insufficient Balance</h3>
						<br>
					</c:when>


					<c:when test="${isToOthers == 2}">
						<h3 class="h3">Invalid Account Number</h3>

						<br>
					</c:when>

				</c:choose>


				<form:form action="/toothers" method="post"
					modelAttribute="toothers">
					<div class="user-details">
						<div class="input-box">
							<span class="details">From Account</span>
							<form:select path="acc1" items="${accType}" />
						</div>

						<div class="input-box">
							<span class="details">To Account</span>
							<form:select path="acc2" items="${accType}" />
						</div>

						<div class="input-box">
							<span class="details">To Account Number</span>
							<form:input path="accNumber" />
							<form:errors path="accNumber" style="color:red" />
						</div>

						<div class="input-box">
							<span class="details">Amount</span>
							<form:input path="amount" />
							<form:errors path="amount" style="color:red" />
						</div>
					</div>


					<div class="button">
						<input type="submit" value="Transfer">
					</div>


				</form:form>

			</div>
		</div>
	</div>


</body>


</html>