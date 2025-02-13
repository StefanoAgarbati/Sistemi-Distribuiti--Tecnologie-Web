<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="web.*,java.util.*, model.*"%>
<%AssignTest assign = (AssignTest)request.getAttribute("assign"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Test</title>
<link rel="stylesheet" href="styles/mainContainer.css" />
<link rel="stylesheet" href="styles/base.css" />
<link rel="stylesheet" href="styles/buttons.css" />
<link rel="stylesheet" href="styles/header.css" />
<style>
.assign {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 18px 24px;
	border-bottom: 1px solid #dce1e5;
}

.assign:hover {
	background-color: #f6f6f8;
}

.card ul {
	list-style-type: none;
}

.assign a {
	text-decoration: none;
	font-size: 14px;
}
</style>
</head>

<body>
	<%@include file="/fragments/header.jsp" %>
	
	<div class="main-container">
		<p class="bold margin-bottom-20">Select a Test to continue</p>
		<div class="card no-padding">
			<ul class="">
			<%Iterator<Test> tit = assign.getTests().iterator(); %>
			<%while(tit.hasNext()) { %>
			<%Test test = tit.next(); %>
				<%if(!assign.isTestAssignedToGroup(test.getId())) { %>
				<li class="assign">
						<div class=""><%=test.getName() %></div> 
						<a class="link link-orange" href="AssignTestToGroup?testId=<%=test.getId()%>&groupId=<%=assign.getGroupId()%>">
							Assign to test
						</a>
				</li>
				<%} %>
			<%} %>
			</ul>
		</div>
	</div>

</body>

</html>