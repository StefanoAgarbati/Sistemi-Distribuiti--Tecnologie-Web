<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="web.*, java.util.*, model.*"%>
<%
EditGroup edit = (EditGroup) request.getAttribute("edit");
%>
<!DOCTYPE html>
<html>

<head>
<!-- registration code group 3K42119853810E7 -->
<meta charset="ISO-8859-1">
<title>Edit Group</title>
<link rel="stylesheet" href="styles/header.css" />
<link rel="stylesheet" href="styles/mainContainer.css" />
<link rel="stylesheet" href="styles/buttons.css" />
<link rel="stylesheet" href="styles/base.css" />
<style>
.member-data-footer, .members-tab-content, .member-data,
	.member-code-area, .member-access {
	display: flex;
}

.member-access, .members-tab-content {
	align-items: center;
}

.members-tab-content {
	flex-direction: column;
	justify-content: center;
	height: 300px;
}

.members-tab-content p {
	margin-bottom: 20px;
}

.simple-row {
	padding: 18px 24px;
	border-bottom: 1px solid #dce1e5;
}

.member-data, .member-data-footer, .member-code-area {
	justify-content: space-between;
}

.member-data-list {
	list-style-type: disc;
}

.member-data-list li {
	padding: 3px 0;
}

.member-data-left {
	min-width: 90px;
}

.member-data-container {
	padding: 20px 40px 10px 70px;
}

.member-data-footer {
	padding: 16px 0;
}

.margin-right-5, .member-access label {
	margin-right: 5px;
}
</style>
</head>

<body>
	<%@include file="/fragments/header.jsp"%>

	<div class="main-container">
	<% String codeAdded = (String) request.getParameter("codeAdded"); %>
	<%if(codeAdded!=null && codeAdded.equals("ok")){ %>
		<div class="message">
			<p>Your Member registration codes have been added.</p>
			<p>You can now print these from the Print Member registration codes link at below.</p>
		</div>
	<%} %>
		<div class="card">
			<div class="card-header">
				<h2><%=edit.getGroup().getName()%></h2>
			</div>
			<div class="menu-options">
				<div class="col-8 options ">
					<a class="option" onclick="showHideTab('add-member')">Add
						Members</a>
					<div class="divider"></div>
					<a class="option">Notify Members</a>
					<div class="divider"></div>
					<a class="option">Member Settings</a>
					<div class="divider"></div>
					<a class="option">Delete Options</a>
				</div>
				<div class="col-2">
					<a class="button button-orange button-large right" href="Assign?groupId=<%=edit.getGroupId()%>">Assign
						Test</a>
				</div>
			</div>
			<div id="add-member" class="accord closed">
				<div class="box">
					<div class="table-row">
						<div class="col-45">
							<h5 class="space-bottom-15">Register Now</h5>
							<ul class="little dark tab-15 space-bottom-15">
								<li>You Register User into this Group</li>
							</ul>
							<a class="anchor show-caret" href="#"
								onclick="toggleRegistrationTabs('manual')">View</a>
						</div>
						<div class="col-1"></div>
						<div class="col-45">
							<h5 class="space-bottom-15">Self Registration</h5>
							<ul class="little dark tab-15 space-bottom-15">
								<li>Allow Users to register themselves</li>
							</ul>
							<a class="anchor show-caret" href="#"
								onclick="toggleRegistrationTabs('self')">View</a>
						</div>
					</div>
					<div class="empty-60"></div>
					<div id="manual-registration" class="accord closed">
						<div class="message">
							<p>Manually register Users into this Group now. Have their
								username and password emailed to them. Note: Self Registration
								codes are a separate way to register Users and are not required
								with this option.</p>
						</div>
						<div class="box">
							<form method="post"
								action="AddMemberToGroup?groupId=<%=edit.getGroup().getGroupId()%>">
								<div class="field-row no-margin-bottom">
									<label class="col-150">*New Members:</label>
									<textarea name="members" class="textarea" type="text"
										placeholder="firstname, lastname, email" rows="3" cols="50"></textarea>
								</div>
								<span class="tab-150 little dark">(ClassMarker will
									create unique Usernames for each user)</span>
								<div class="empty-60"></div>
								<div class="hline tab-150"></div>
								<div class="empty-60"></div>
								<div>
									<button class="button button-orange" type="submit">Register
										New Users</button>
								</div>
							</form>
						</div>
					</div>
					<div id="self-registration" class="accord closed">
						<div class="message">
							<p>Create Member Registration codes to hand out and allow
								Users to register themselves into this Group from
								https://www.classmarker.com/register/</p>
						</div>
						<%Collection<MemberRegistrationCode> codes = edit.getMemberRegistrationCodeByGroup(); %>
						<%if(!codes.isEmpty()) {%>
						<div class="message">
							<p class="bold margin-bottom-20">Member Registration</p>
							<p class="margin-bottom-20">
								You currently have <strong><%=codes.size() %> Member Registration Codes</strong>
								available to use in this Group.
							</p>
							<p class="margin-bottom-20">You can always delete existing
								Users you no longer need on your account to create new Member
								Registration Codes.</p>
							<p class="margin-bottom-20">
								<a class="button button-green" target="_blank" href="PrintRegistrationCodes?groupId=<%=edit.getGroupId()%>">Print Member
									Registration Codes</a> for this Group. (Opens in new browser
								window)
							</p>
						</div>
						<%} %>
						<div class="member-code-area">
							<div class="box-squared col-49">
								<h4 class="margin-bottom-20">Create Member Registration
									Codes</h4>
								<form method="post"
									action="AddMemberRegistrationCode?groupId=<%=edit.getGroupId()%>">
									<p class="margin-bottom-20">
										Create <select class="selection" name="codesToCreate">
											<% 
												for(int i = 1; i <= 50; i++) {
											%>
												<option value="<%=i%>"><%=i%></option>
											<% } %>
										</select> Registration Codes for this Group
									</p>
									<p>
										<button class="button button-grey" type="submit">Add
											Member Registration Code</button>
										(Max 50 at a time)
									</p>
								</form>
							</div>
							<div class="box-squared col-49">
								<h4 class="margin-bottom-20">Remove Member Registration
									Codes</h4>
								<%if(codes.isEmpty()) { %>
								<div>
									<p>No Registration codes are waiting to be used for this
										group</p>
								</div>
								<%} else { %>
								<div>
									<p class="margin-bottom-20">
										You have <strong><%=codes.size() %></strong> unused member registration codes
										in this Group
									</p>
									<form method="post" action="RemoveMemberRegistrationCode?groupId=<%=edit.getGroupId()%>">
										<p class="margin-bottom-20">
											Remove <select class="selection" name="codesToRemove">
											<% 
												for(int i = 1; i <= 50; i++) {
											%>
												<option value="<%=i%>"><%=i%></option>
											<% } %>
											</select> Registration codes
										</p>
										<button class="button button-grey" type="submit">Remove
											Member Registration Codes</button>
									</form>
								</div>
								<%} %>
							</div>
						</div>
					</div>
					<div class="empty-30"></div>
					<div class="hline"></div>
					<div class="empty-30"></div>
					<div>
						<a class="anchor" href="#">View Member & Registration code
							usage across all Groups</a>
					</div>
				</div>
			</div>
		</div>
		<div class="card no-padding">
			<div class="table-row tab-btn-container">
				<%Collection<GroupMember> members = edit.getMembersByGroup();%>
				<a id="members-tab-btn" class="tab-btn tab-btn-on" href="#"
					onclick="showTab('members')">Group Members <span class="badge"><%=members.size() %></span></a>
				<a id="tests-tab-btn" class="tab-btn tab-btn-off" href="#"
					onclick="showTab('tests')">Tests Assigned <span class="badge"><%=edit.getTestsAssignedToGroup().size() %></span></a>
			</div>
			<div id="members-tab-content">
				<%
				if (members.isEmpty()) {
				%>
				<div class="members-tab-content">
					<p>No groups members yet</p>
					<a class="button button-blue" href="#">Add new members</a>
				</div>
				<%
				} else {
				%>
				<div>
					<div class="table">
						<div class="row utilities">
							<div class="col-6"></div>
							<div class="col-4 new-btn-cnt">
								<a class="button button-blue" href="">Add new member</a>
							</div>
						</div>
						<div class="">
							<div class="">
								<%
								Iterator<GroupMember> git = members.iterator();
								while (git.hasNext()) {
								GroupMember member = git.next();
								RegisteredUser user = edit.getUserById(member.getUserId());
								%>
								<div class="row-content">
									<div class="row accordion" onclick="rowClicked(this)">
										<div class="col-6 name-section"><%=user.getFirstname()%><%=" "%><%=user.getLastname()%></div>
									</div>
									<div class="accordion-content">
										<div class="member-data-container">
											<div class="member-data">
												<ul class="member-data-list">
													<li><span class="member-data-left">Username: </span> <span><%=user.getUsername()%></span>
													</li>
													<li><span class="member-data-left">Password: </span> <span><%=user.getPassword()%></span>
													</li>
													<li><span class="member-data-left">Email: </span> <span>-</span>
													</li>
													<li><span class="member-data-left">Registered:
													</span> <span>Sun 19th May 2024 6:53pm</span></li>
													<li><span class="member-data-left">Last login:
													</span> <span>ier sera o ier matina</span></li>
												</ul>
												<div>
													<a class="button button-green" href="#">Results</a>
												</div>
											</div>
											<div class="empty-30"></div>
											<div class="horizontal-divider"></div>
											<div class="member-data-footer">
												<div class="member-actions">
													<a class="link link-orange">Edit details & message</a> <a
														class="link link-orange">Transfer user</a> <a
														class="link link-orange">Delete user</a>
												</div>
												<div class="member-access">
													<label>Can access this group</label> <input type="checkbox"
														checked="true" />
												</div>
											</div>
										</div>
									</div>
								</div>
								<%
								}
								%>
							</div>
						</div>
					</div>
				</div>
				<%
				}
				%>
			</div>
			<div id="tests-tab-content" class="hidden">
				<div class="simple-row"></div>
				<%Collection<Test> tests = edit.getTestsAssignedToGroup(); %>
				<%if(tests.isEmpty()) { %>
				<div class="simple-row">
					<span class="explication">You need to Assign Tests to this
						Group before they can be taken by these Group members.</span>
				</div>
				<% } else { %>
				<%Iterator<Test> tit = tests.iterator(); %>
				<%while(tit.hasNext()) { %>
				<%Test test = tit.next(); %>
				<div class="row table-row">
					<div class="col-6"><span><%=test.getName() %></span></div>
					<div class="col-4 name-actions">
						<a class="action link link-grey" href="#">Settings</a>
						<span class="action status-info"><%=test.getStatus().getStatus() %></span>
						<a href="#" class="action button button-green">Result</a>
					</div>
				</div>
				<%} %>
				<%} %>
			</div>
		</div>
	</div>
	<script>
		let selfRegistrationTab = document.getElementById('self-registration');
		let manualRegistrationTab = document
				.getElementById('manual-registration');
		let membersTabButton = document.getElementById('members-tab-btn');
		let testsTabButton = document.getElementById('tests-tab-btn');
		let membersTabContent = document.getElementById('members-tab-content');
		let testsTabContent = document.getElementById('tests-tab-content');

		function showTab(name) {
			if (isMembers(name)) {
				testsTabOff();
				membersTabOn();
			} else if (isTests(name)) {
				testsTabOn();
				membersTabOff();
			}
			toggleTabContent();

			function isTests(name) {
				return name === 'tests';
			}
			function isMembers(name) {
				return name === 'members';
			}
			function membersTabOff() {
				membersTabButton.classList.add('tab-btn-off');
				membersTabButton.classList.remove('tab-btn-on');
			}
			function membersTabOn() {
				membersTabButton.classList.add('tab-btn-on');
				membersTabButton.classList.remove('tab-btn-off');
			}
			function testsTabOff() {
				testsTabButton.classList.add('tab-btn-off');
				testsTabButton.classList.remove('tab-btn-on');
			}
			function testsTabOn() {
				testsTabButton.classList.add('tab-btn-on');
				testsTabButton.classList.remove('tab-btn-off');
			}
			function toggleTabContent() {
				toggleClass(membersTabContent, 'hidden');
				toggleClass(testsTabContent, 'hidden');
			}
		}
		function showMembersTab() {

		}
		function hideMembersTab() {

		}
		function toggleRegistrationTabs(name) {
			if (name === 'manual') {
				if (isTabOpened(manualRegistrationTab)) {
					closeTab(manualRegistrationTab);
					return;
				}
				openTab(manualRegistrationTab);
				closeTab(selfRegistrationTab);
				return;
			}
			if (name === 'self') {
				if (isTabOpened(selfRegistrationTab)) {
					closeTab(selfRegistrationTab);
					return;
				}
				openTab(selfRegistrationTab);
				closeTab(manualRegistrationTab);
				return;
			}
		}
		function isTabOpened(aTab) {
			return aTab.classList.contains('opened');
		}
		function openTab(aTab) {
			aTab.classList.add('opened');
			aTab.classList.remove('closed');
		}
		function closeTab(aTab) {
			aTab.classList.add('closed');
			aTab.classList.remove('opened');
		}
		function showHideTab(id) {
			let el = document.getElementById(id);
			console.log('el ' + el);
			toggleClass(el, 'closed');
			toggleClass(el, 'opened');
		}
		function toggleClass(el, aClass) {
			el.classList.toggle(aClass);
		}
		function rowClicked(item) {
			console.log('rowClicked ');
			let content = item.nextElementSibling;
			content.classList.toggle('opened');
		}
	</script>
</body>

</html>