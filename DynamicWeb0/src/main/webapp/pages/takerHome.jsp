<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="web.*,model.*,java.util.*"%>
	<%TakerHome taker = (TakerHome)request.getAttribute("taker"); %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>My Groups</title>
<link rel="stylesheet" href="styles/header.css" />
<link rel="stylesheet" href="styles/base.css" />
<link rel="stylesheet" href="styles/mainContainer.css" />
<link rel="stylesheet" href="styles/taker.css" />
</head>

<body>
	<%@include file="/fragments/headerTaker.jsp" %>
	
	<div class="main-container">
		<h3 class="header-text">My Groups</h3>
		<div class="content-sections">
			<div class="left-section">
				<div class="card no-padding">
					<div class="header-row">
						<span>Select group</span>
					</div>
					<%Collection<Group> groups = taker.getGroups();%>
					<%Iterator<Group> git = groups.iterator(); %>
					<%while(git.hasNext()){ %>
					<%Group group = git.next(); %>
					<a href="TakerTestsGroup?groupId=<%= group.getGroupId()%>"><%=group.getName() %></a> 
					<%} %>
				</div>
			</div>
			<div class="right-section">
				<div class="card">
					<p class="student-message">
						When you are registered in multiple Groups, each Group may contain
						separate Tests for you to take. <br> <br> Change Groups
						to check for available Tests under each Group.
					</p>
				</div>
			</div>
		</div>
	</div>
</body>

</html>