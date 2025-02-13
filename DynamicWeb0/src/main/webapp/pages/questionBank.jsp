<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*, model.*, web.Questions"%>

<%
Questions questions = (Questions) request.getAttribute("questions");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Bank</title>
<link rel="stylesheet" href="styles/header.css" />
<link rel="stylesheet" href="styles/tabsContainer.css" />
<link rel="stylesheet" href="styles/question.css" />
<link rel="stylesheet" href="styles/mainContainer.css" />
<link rel="stylesheet" href="styles/buttons.css" />
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

.qbaction {
	padding: 18px 24px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin: 10px auto;
	border: 1px solid rgba(0, 0, 0, 0.3);
	border-radius: 4px;
}

.qbaction-border {
	border: 1px solid rgba(0, 0, 0, 0.3);
}

.qbaction-active {
	color: #ff3311;
	padding: 16px 24px;
	border-bottom: 2px solid #ff3311;
	border-bottom-left-radius: 4px;
}
</style>
</head>
<body>
	<%@include file="../fragments/header.jsp"%>

	<div class="main-container">
		<%@include file="../fragments/tabsContainer.jsp" %>

		<div class="qbaction">
			<% Collection<Question> qList = questions.getQuestions(); %>
			<span class="qbaction-active">Active <%= qList.size() %></span>
			<div class="button-ctn">
				<a class="button button-orange" href="AddQuestionToBank">Add
					Question</a>
			</div>
		</div>
		<% if(qList.isEmpty()) { %>
		<div>
			<p>No questions created yet</p>
		</div>
		<% }%>
		<% Iterator<Question> it = qList.iterator();%>
		<% int i = 0; %>
		<% while(it.hasNext()) { i++; %>
		<% Question aQuestion = it.next(); %>
		<div id="qc<%= i%>"class="question-card">
			<div class="question-card-item question-card-header">
				<span class="qcard-header-name">Question <%= i %></span> <span
					class="qcard-header-cat"><%=questions.getCategoryById(aQuestion.getCategoryId()).getName() %></span> <span
					class="qcard-header-points"><%= aQuestion.getPoints() %></span>
			</div>
			<div class="question-info question-card-item">
				<div class="question-text"><%= aQuestion.getText() %></div>
				<div class="question-info-answers">
					<table class="question-info-answer-table">
					<% Collection<PossibleResponse> responses = questions.getResponsesForQuestion(aQuestion.getQuestionId()); %>
					<% Iterator<PossibleResponse> itResponses = responses.iterator(); %>
					<% while(itResponses.hasNext()) { %>
					<% PossibleResponse aResponse = itResponses.next(); %>
						<tr class="answer correct-answer">
							<td class="answer-letter"><%= aResponse.getName() %></td>
							<td class="answer-text"><%= aResponse.getText() %></td>
							<td class="correct-icon <%= aResponse.isCorrect() ? "" : "hidden" %>">
								<img class="correct-icon-img" src="img/correct.svg" />
							</td>
						</tr>
					<% } %>
					</table>
				</div>
			</div>
			<div class="question-card-footer question-card-item">
				<div class="qcard-actions">
					<a class="qcard-action" href="javascript:void(0)"
						onclick="showHideAnswers('qc<%=i%>')">Answers</a> <a class="qcard-action"
						href="EditQuestion?qid=<%=aQuestion.getQuestionId()%>">Edit</a> <a class="qcard-action" href="javascript:void(0)"
						onclick="showHideDelete('qc<%=i%>')">Delete</a> <a class="qcard-action"
						href="javascript:void(0)" onClick="showHideTests('qc<%=i%>')">Used In</a>
				</div>
				<div class="qcard-footer-delete hidden">
					<p class="strong-text qcard-footer-delete-item">Are you sure
						you want to permanently delete this Question?</p>
					<p class="qcard-footer-delete-item">You will NOT be able to
						restore this Question once deleted</p>
					<div class="delete-buttons qcard-footer-delete-item">
						<a class="button button-orange delete-button" href="RemoveQuestion?from=bank&qid=<%= aQuestion.getQuestionId()%>">Permanently
							Delete Question</a> <a class="button button-grey cancel-button"
							href="javascript:void(0)" onclick="showHideDelete('qc<%=i%>')">Cancel</a>
					</div>
				</div>
				<div class="qcard-footer-test hidden">
					<%Collection<Test> usedIn = questions.getTestsWithQuestion(aQuestion.getQuestionId()); %>
					<% if(usedIn.isEmpty()) {%>
					<div class="used-in-header no-test-msg">
						<p>No Tests are currently using this Question.</p>
						<img class="close" src="img/close.svg" />
					</div>
					<% } else { %>
					<div class="some-test-msg">
						<div class="used-in-header">
							<p>
								Tests currently using this Question: <a href="">close</a>
							</p>
						</div>
						<% Iterator<Test> itTests = usedIn.iterator(); %>
						<% int k = 0; %>
						<% while(itTests.hasNext()) { k++;%>
						<% Test aTest = itTests.next(); %>
						<p>
							<%= k %>) <a href=""><%=aTest.getName() %></a>
						</p>
						<% } %>
					</div>
					<% } %>
				</div>
			</div>
		</div>
	<% } %>
	<%  %>
	</div>
	<script src="pages/question.js"></script>
	<script src="scripts/tabs.js"></script>
	<script>
		setActiveTab('Question Bank');
	</script>
</body>
</html>