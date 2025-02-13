<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Online Testing App</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/pages/home/home.css" />
</head>

<body>
	<div class="">
		<%@ include file="/fragments/login.jsp" %>
		<div class="content">
			<h1 class="center-text info info-title">Register free for online testing</h1>
			<p class="center-text info info-subtitle">
				Secure, Trusted, Professional.
			</p>
			<div class="card-container">
				<div class="card">
					<h1 class="card-title">Education customers</h1>
					<p class="card-desc">Strictly not-for-profit organizations including Education & Government
						institutions.</p>
					<a class="card-btn" href="<%=request.getContextPath() %>/Registration?role=educator">Register</a>
				</div>
				<div class="card">
					<h1 class="card-title">Test takers</h1>
					<p class="card-desc">For users who have been given a ClassMarker Registration Code by an instructor
						or administrator.</p>
					<a class="card-btn card-btn-grey" href="<%=request.getContextPath() %>/Registration?role=taker">Register</a>
				</div>
			</div>
		</div>
		<%@include file="../fragments/footer.jsp" %>
	</div>
</body>

</html>