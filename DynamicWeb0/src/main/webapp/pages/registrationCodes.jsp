<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="web.*,model.*, java.util.*"%>
    <%RegistrationCodes codes = (RegistrationCodes) request.getAttribute("codes"); %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Registration Codes</title>
	<link rel="stylesheet" href="styles/base.css" />
	<style>
		.padding-10,
		.codes-content {
			padding: 10px;
		}
		.width-70,
		.codes-content {
			width: 70%;
		}
		.width-30,
		.code-area {
			width: 30%;
		}
		.box-text,
		.code-area {
			font-size: 13px;
		}
		h3, h4, strong {
			color: #4C4C4C;
		}
		.code-area {
			margin-bottom: 10px;
			border-bottom: 1px dotted black;
			padding:16px;
		}
	</style>
</head>

<body>
	<div class="codes-content">
		<h1>
			<img src="img/quiz-maker.jpg" />
		</h1>
		<br>
		<br>
		<h3>Group Member Registration Codes</h3>
		<br>
		<p class="box box-grey box-text">Each registration code below is a unique code (each code can only be used once).</p>
		<div class="box box-grey box-text">
			<h3>Group: <%=codes.getGroup().getName()%></h3>
			<br>
			<p>These codes are for registering into the Group - <strong><%=codes.getGroup().getName() %></strong></p>
			<br>
			<p>Print and give one code to each user.</p>
			<br>
			<p>Alternatively you can batch upload users via the Manage members page for each Group you create.</p>
		</div>
		<br>
		<%Collection<MemberRegistrationCode> regCodes = codes.getMemberRegistrationCodes(); %>
		<%Iterator<MemberRegistrationCode> mit = regCodes.iterator(); %>
		<%while(mit.hasNext()) { %>
		<%MemberRegistrationCode code = mit.next(); %>
		<div class="code-area">
			<p><strong>Registration code: </strong><%=code.getCode() %></p>
		</div>
		<%} %>
	</div>
</body>

</html>