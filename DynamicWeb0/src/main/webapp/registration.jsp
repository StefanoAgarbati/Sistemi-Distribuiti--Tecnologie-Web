<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<div>
		<div>
			<div>
				<div>logo image</div>
				<div>form login</div>
			</div>
			<div>
				
			</div>
		</div>
		<div>
			<div>
				<h1>Administration registration - Education</h1>
			</div>
			<div>
				<span>Learners: Have you been told to register an account to take an exam? </span> <a href="#">Go here!</a>
			</div>
			<div>
				<h3>Before you register please note</h3>
				<p>Free accounts can only save and review test results taken by pre-registered users in groups.</p>
				<p>You can upgrade your account to save and review test results taken via links.</p>
				<p>Learn the difference between giving tests via groups or links.</p>
			</div>
		</div>
		<div>
			<form id="registration-form">
				<input type="hidden" name="role" value="educator"/>
				<div>
					<div>
						<label for="firstname">First name *</label>
						<input type="text" id="firstname" name="firstname"/>
					</div>
					<div>
						<label for="lastname">Last name *</label>
						<input type="text" id="lastname" name="lastname"/>
					</div>
				</div>
				<div>
					<div>
						<label for="username">Username *</label>
						<input type="text" id="username" name="username"/>
					</div>
					<div>
						<label for="password">Password *</label>
						<input type="text" id="password" name="password"/>
					</div>
				</div>
				<div>
					<button type="button" onclick="submitRegistrationData()">Register</button>
				</div>
			</form>
		</div>
		<div>
			<% /*RegistrationResult regRes = (RegistrationResult)request.getAttribute("regRes"); 
				String resultText = "Registration result";
			   if(regRes != null) {
				   if(regRes.isSuccess()) {
				   resultText = "Registration success";
				   }*/
			%>
			<span></span>
		</div>
		<div>
			footerrrrr
		</div>
	</div>
	<script src="registration.js"></script>
</body>
</html>