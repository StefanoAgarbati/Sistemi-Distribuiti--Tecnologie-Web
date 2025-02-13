<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
	* {
		border-sizing: border-box;
	}
	.form-input {
		padding: 6px 10px;
	}
</style>
</head>
<body>
	<div>
		<form method="post" action="Login">
			<div>
				<input class="form-input" type="text" name="username" placeholder="Username"/>
			</div>
			<div>
				<input class="form-input" type="text" name="password" placeholder="Password"/>
			</div>
			<div>
				<button type="submit" name="login" value="login">Login</button>
			</div>
		</form>
	</div>
	<%
		String error = (String)request.getAttribute("loginError");
		if(error != null) {
	%>
		<div class="error-output">No username / password match. Please try again or try our Forgot details page.</div>
	<% }%>
	<script src="login.js"></script>
</body>
</html>