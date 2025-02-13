<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/pages/home/home.css" />
</head>

<body>
	<div class="header">
		<div class="hleft">
			<a href="/DynamicWeb0/Home"><img src="/DynamicWeb0/img/logo.svg" /></a>
		</div>
		<div class="hright">
			<form method="post" action="<%=request.getContextPath() %>/Login">
				<input class="input" type="text" name="username"
					placeholder="Username" /> <input class="input" type="text"
					name="password" placeholder="Password" />
				<button class="btn" type="submit" value="login">Login</button>
			</form>
		</div>
	</div>
	<%
		String error = (String)request.getAttribute("loginError");
		if(error != null) {
	%>
		<div class="error-msg">
			<p>
				No username / password match.
			</p>
		</div>
	<% } %>
</body>

</html>
