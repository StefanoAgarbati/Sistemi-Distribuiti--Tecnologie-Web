<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="web.*"%>
<%AssignSuccess success = (AssignSuccess)request.getAttribute("success"); %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Assign Test End</title>
<link rel="stylesheet" href="styles/mainContainer.css" />
<link rel="stylesheet" href="styles/base.css" />
<link rel="stylesheet" href="styles/buttons.css" />
<link rel="stylesheet" href="styles/header.css" />
<style>
.assign-finish-card {
	display: flex;
	flex-direction: column;
	align-items: center;
	border-radius: 4px;
	background-color: #FFFFFF;
	box-shadow: 0 0 4px rgba(0, 40, 77, 0.2);
	margin-bottom: 20px;
}

.success-icon {
	margin-top: 40px;
}

.test-assigned-text {
	font-family: Poppins;
	font-size: 32px;
	font-weight: 500;
	margin-top: 24px;
	margin-bottom: 32px;
}

.test-info {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-bottom: 32px;
}

.name-text {
	margin: 0px 20px;
}

.assign-buttons-area {
	margin-top: 32px;
	margin-bottom: 40px;
}

.notification-area {
	display: flex;
	flex-direction: column;
	align-items: center;
	padding-top: 32px;
	padding-bottom: 32px;
}
</style>
</head>

<body>
	<%@include file="/fragments/header.jsp" %>
	
	<div class="main-container">
		<div class="assign-finish-card">
			<div class="success-icon">
				<img src="img/success-tick.svg" />
			</div>
			<p class="test-assigned-text">Your Test is assigned to your Group</p>
			<div class="test-info">
				<span class="name-text"><%=success.getTestName() %></span><img
					src="img/return_arrow.svg" /><span class="name-text">
					<%=success.getGroupName() %></span>
			</div>
			<div class="assign-buttons-area">
				<a class="button button-orange" href="#">Go to Results and
					Settings</a> <a class="button button-white" href="Groups">Add members to
					the group</a>
			</div>
			<div class="horizontal-divider"></div>
			<div class="notification-area">
				<p class="bold margin-bottom-20">You can now notify users from
					the Group Member Page</p>
				<a class="button button-green" href="Groups">Notify Members</a>
			</div>
		</div>
	</div>

</body>

</html>