<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*, model.*, web.Groups"%>
<%Groups groups = (Groups) request.getAttribute("groups"); %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Groups</title>
	<link rel="stylesheet" href="styles/header.css" />
	<link rel="stylesheet" href="styles/mainContainer.css" />
	<link rel="stylesheet" href="styles/buttons.css" />
	<link rel="stylesheet" href="styles/groups.css" />
</head>

<body>
	<%@include file="../fragments/header.jsp"%>
	
	<div class="main-container">
		<div class="table">
			<div class="row utilities">
				<div class="col-6">
					<div class="hi">
						<input class="input" type="search" name="search" placeholder="Search Group Name" />
					</div>
				</div>
				<div class="col-4 new-btn-cnt"><a class="button button-orange" href="CreateNewGroup">New
						Group</a>
				</div>
			</div>
			<div class="">
			<%Collection<Group> groupsCollection = groups.getGroups(); %>
			<%Iterator<Group> git = groupsCollection.iterator(); %>
			<%while(git.hasNext()) { %>
			<%Group group = git.next(); %>
				<div class="row-content">
					<div class="row accordion" onclick="rowClicked(this)">
						<div class="col-6 name-section"><%=group.getName() %></div>
						<div class="col-4 hidden name-actions">
							<a class="link" href="Assign?groupId=<%= group.getGroupId()%>">Assign</a>
							<a class="link" href="#">Statistics</a>
							<a class="button button-blue" href="EditGroup?groupId=<%= group.getGroupId()%>">Edit</a>
						</div>
					</div>
					<div class="accordion-content">
					<%Collection<Test> tests = groups.getTestsAssignedToGroup(group.getGroupId()); %>
						<div class="row"><span class="">Assigned <%=tests.size() %> times</span></div>
						<ul class="">
						<%Iterator<Test> tit = tests.iterator(); %>
						<%while(tit.hasNext()) { %>
						<%Test aTest = tit.next(); %>
							<li class="row sub-row group-list-row">
								<div class="col-6 name-section tab-20"><span><%=aTest.getName() %></span></div>
								<div class="col-4 name-actions">
									<div class="action"><a class="link" href="#">Settings</a></div><span
										class="status-info action"><%=aTest.getStatus().getStatus() %></span>
									<div class="action"><a class="button button-green results-btn" href="#">Results</a>
									</div>
								</div>
							</li>
						<%} %>
						</ul>
						<div class="row"><a class="link link-orange" href="Assign?groupId=<%= group.getGroupId()%>">Assign</a></div>
					</div>
				</div>
				<%} %>
			</div>
		</div>
	</div>
	<script>
		function rowClicked(item) {
			console.log('rowClicked ');
			let actions = item.children[1].classList.toggle('hidden');
			let content = item.nextElementSibling;
			content.classList.toggle('opened');
		}
	</script>
</body>

</html>
