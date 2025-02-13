<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles/base.css" />
<link rel="stylesheet" href="styles/registration.css" />
<title>Registration</title>
</head>

<body>
	<div>
		<%@ include file="/fragments/login.html"%>
		
		<div class="container margin-bottom-50">
			<div class="">
				<h1 class="margin-bottom registration-title">Test taker
					registration</h1>
			</div>
			<div class="form-container">
				<form method="post" action="Registration" class="form" id="registration-form">
					<input type="hidden" name="role" value="taker" />
					<div class="row no-border">
						<div class="row-item">
							<label class="form-label" for="code">Enter the
								registration code provided by your instructor *</label> <input
								class="form-input" type="text" id="code" name="code" />
						</div>
					</div>
					<div class="empty-60"></div>
					<div class="row no-border">
						<div class="row-item">
							<label class="form-label" for="firstname">First name *</label> <input
								class="form-input" type="text" id="firstname" name="firstname" />
						</div>
						<div class="row-item">
							<label class="form-label" for="lastname">Last name *</label> <input
								class="form-input" type="text" id="lastname" name="lastname" />
						</div>
					</div>
					<div class="row no-border">
						<div class="row-item">
							<label class="form-label" for="username">Username *</label> <input
								class="form-input" type="text" id="username" name="username" />
						</div>
						<div class="row-item">
							<label class="form-label" for="password">Password *</label> <input
								class="form-input" type="text" id="password" name="password" />
						</div>
					</div>
					<div class="empty-row"></div>
					<div class="row no-border">
						<button class="btn btn-orange" type="button"
							onclick="submitRegistrationData()">Register</button>
						<div id="error-msg" class="error-msg hidden">
							<p id="error-msg-text">Error message</p>
						</div>
					</div>
				</form>
			</div>
		</div>

		<%@include file="/fragments/footer.jsp" %>
	</div>
	<script src="registration.js"></script>
</body>

</html>