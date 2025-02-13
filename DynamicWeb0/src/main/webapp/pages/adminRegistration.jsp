<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles/registration.css" />
<title>Registration</title>
</head>
<body>

	<%@ include file="/fragments/login.html"%>
	<div class="content">
		<div class="container">
			<h1 class="margin-bottom registration-title">Administration
				registration - Education</h1>
			<div class="margin-bottom bordered-box bordered-box-left text">
				<span>Learners: Have you been told to register an account to
					take an exam? </span> <a class="link underlined" href="#">Go here!</a>
			</div>
			<div class="margin-bottom registration-info text">
				<h3 class="marbot16">Before you register please note</h3>
				<p class="marbot16">Free accounts can only save and review test
					results taken by pre-registered users in groups.</p>
				<p class="marbot16">
					You can <strong>upgrade</strong> your account to save and review
					test results taken via links.
				</p>
				<p class="marbot16">Learn the difference between giving tests
					via groups or links.</p>
			</div>
		</div>
		<div class="container form-container">
			<form method="post" action="Registration" class="form" id="registration-form">
				<input type="hidden" name="role" value="educator" />
				<div class="row">
					<div class="row-item">
						<label class="form-label" for="firstname">First name *</label> <input
							class="form-input" type="text" id="firstname" name="firstname" />
					</div>
					<div class="row-item">
						<label class="form-label" for="lastname">Last name *</label> <input
							class="form-input" type="text" id="lastname" name="lastname" />
					</div>
				</div>
				<div class="row">
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
				<div class="row">
					<button class="btn btn-orange" type="button"
						onclick="submitRegistrationData()">Register</button>
					<div id="error-msg" class="error-msg hidden">
						<p id="error-msg-text">Error message</p>
					</div>
				</div>
			</form>
		</div>
		<%@include file="/fragments/footer.jsp"%>
	</div>
	<script src="registration.js"></script>
</body>
</html>