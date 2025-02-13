<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*, model.*, web.Tests" %>
<%@page session="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test</title>
<link rel="stylesheet" href="prove/test.css"/>
</head>
<body>
	<% Tests tests = (Tests)request.getAttribute("tests");%>
	<%@include file="/fragments/header.jsp" %>
	
	<div class="main-container">
			<div id="tabs-container" class="tabs-container">
				<ul>
					<li class="t-tab tabon"><a href="TestServlet">All Tests</a></li>
					<li class="t-tab taboff"><a href="questions">Question Bank</a></li>
					<li class="t-tab taboff"><a href="categories">Categories</a></li>
					<li class="t-tab taboff"><a href="#">Files</a></li>
					<li class="t-tab taboff"><a href="#">Community</a></li>
					<li class="t-tab taboff"><a href="#">Statistics</a></li>
				</ul>
			</div>
			<div class="new-test-action">
				<div class="search-filter-ctn">
					<div class="hi">
						<input class="input" type="search" name="search" placeholder="Search Test Name"/>
					</div>
				</div>
				<div class="new-test-btn-ctn"><a class="button button-orange new-test-btn" href="addNewTest">New Test</a></div>
			</div>
			<div class="test-list">
				<% Iterator<Test> it = tests.getAllTests().iterator(); %>
				<% while(it.hasNext()) { %>
				<% Test t = it.next(); %>
				<div class="test-list-item">
					<div class="test-list-item-accordion" onclick="testListItemClicked(this)">
						<div class="test-name-section"><%=t.getName() %></div>
						<div class="test-name-actions hidden">
							<a class="link" href="#">Assign</a>
							<a class="link" href="#">Statistics</a>
							<a class="button button-blue" href="EditTest?tid=<%=t.getId() %>">Edit Test</a>
						</div>
					</div>
					<div class="accordion-content closed">
						<div class="assign-count"><span>Assigned <%= tests.getTotalAssignmentsForTest(t.getId()) %> times</span></div>
						<ul class="group-list">
							<%Collection<Group> groups = tests.getGroupAssignedToTest(t.getId()); %>
							<% Iterator<Group> groupsIt = groups.iterator(); %>
							<% while(groupsIt.hasNext()) { %>
							<% Group group = groupsIt.next(); %>
							<li class="group-list-row">
								<div class="group-name"><span><%=group.getName() %></span></div>
								<div class="group-row-actions">
									<div class="status"><div class="settings"><a href="#"><img src="img/setting.svg"/></a></div><span class="status-info">Status</span></div>
									<div><a class="button button-green results-btn" href="#">Results</a></div>
								</div>
							</li>
							<%} %>
							<%Collection<Link> links = tests.getLinkAssignedToTest(t.getId()); %>
							<% Iterator<Link> linksIt = links.iterator(); %>
							<% while(linksIt.hasNext()) { %>
							<% Link link = linksIt.next(); %>
							<li class="group-list-row">
								<div class="group-name"><span><%=link.getName() %></span></div>
								<div class="group-row-actions">
									<div class="status"><div class="settings"><a href="#"><img src="img/setting.svg"/></a></div><span class="status-info">Status</span></div>
									<div><a class="button button-green results-btn" href="#">Results</a></div>
								</div>
							</li>
							<%} %>
						</ul>
						<div class="assign-test"><a class="link" href="#">Assign</a></div>
					</div>
				</div>
				<% } %>
			</div>
		</div>
	<script>
		
	</script>
	<script src="prove/test.js"></script>
</body>
</html>