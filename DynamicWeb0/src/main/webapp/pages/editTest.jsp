<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="web.Edit, model.*, java.util.*" %>
<%Edit edit = (Edit) request.getAttribute("edit"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edit Test</title>
	<link rel="stylesheet" href="styles/buttons.css" />
	<link rel="stylesheet" href="styles/question.css" />
	<link rel="stylesheet" href="styles/mainContainer.css" />
	<link rel="stylesheet" href="styles/edit.css" />
	<link rel="stylesheet" href="styles/message.css" />
	
</head>

<body>
	<div class="edit-header">
		<div class="edit-header-left">
			<a class="button button-dark-grey" href="TestServlet">Exit Test Editor</a>
		</div>
		<div class="edit-header-center"><%=edit.getTest().getName() %></div>
		<div class="edit-header-right">
			<div class="dropdown">
				<a class="button button-orange" href="#">Add Question</a>
				<ul class="edit-test-dropdown">
					<li><a href="AddQuestionToTest?tid=<%= edit.getTest().getId()%>">Add a new Question</a></li>
					<li><a href="#">Reuse from your question bank</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="main-container">
		<%String success = request.getParameter("success"); %>
		<%if(success != null && success.equals("ok")) { %>
		<div class="message">Your Question was saved in your Test</div>
		<%} %>
		<div class="test-info">
			<span class=""><%=edit.getNumberOfQuestions() %> fixed questions</span>
			<span class="">Question Bank: <%=edit.getNumberOfQuestionInBank() %> Questions</span>
		</div>
		<div class="test-intro">

		</div>
		<div class="question-container">
		<%Collection<Question> questions = edit.getQuestions(); %>
		<%Iterator<Question> qit = questions.iterator();%>
		<%int i = 0; %>
		<%while(qit.hasNext()) { i++;%>
		<%Question question = qit.next(); %>
			<div id="qc<%=i %>" class="question-card">
				<div class="question-card-item question-card-header">
					<span class="qcard-header-name">Question</span> <span class="qcard-header-cat"><%=edit.getQuestionCategory(question.getCategoryId()).getName() %></span>
					<span class="qcard-header-points"><%=question.getPoints() %></span>
				</div>
				<div class="question-info question-card-item">
					<div class="question-text"><%=question.getText() %></div>
					<div class="question-info-answers">
						<table class="question-info-answer-table">
						<%Collection<PossibleResponse> responses = edit.getPossibleResponsesForQuestion(question.getQuestionId());%>
						<%Iterator<PossibleResponse> pit = responses.iterator(); %>
						<%int k = 0; %>
						<%while(pit.hasNext()) { k++; %>
						<%PossibleResponse res = pit.next(); %>
							<tr class="answer correct-answer">
								<td class="answer-letter"><%=res.getName() %></td>
								<td class="answer-text"><%=res.getText() %></td>
								<%if(res.isCorrect()) { %>
								<td class="correct-icon ">
									<img class="correct-icon-img" src="img/correct.svg" />
								</td>
								<%} %>
							</tr>
						<%} %>
						</table>
					</div>
				</div>
				<div class="question-card-footer question-card-item">
					<div class="qcard-actions">
						<a class="qcard-action" href="javascript:void(0)" onclick="showHideAnswers('qc<%=i%>')">Answers</a>
						<a class="qcard-action" href="EditQuestion?qid=<%=question.getQuestionId()%>&tid=<%=edit.getTest().getId()%>">Edit</a> 
						<a class="qcard-action" href="javascript:void(0)"
							onClick="showHideTests('qc<%=i%>')">Used In</a>
						<div class="float-right">
							<a class="qcard-action" href="RemoveQuestion?from=test&tid=<%=edit.getTest().getId() %>&qid=<%=question.getQuestionId() %>" 
							onclick="removeFromTest()">Remove From
								Test</a>
						</div>
					</div>
					<div class="qcard-footer-delete hidden">
						<p class="strong-text qcard-footer-delete-item">Are you sure
							you want to permanently delete this Question?</p>
						<p class="qcard-footer-delete-item">You will NOT be able to
							restore this Question once deleted</p>
						<div class="delete-buttons qcard-footer-delete-item">
							<a class="button button-orange delete-button" href="#">Permanently
								Delete Question</a> <a class="button button-grey cancel-button"
								href="javascript:void(0)" onclick="hideDelete()">Cancel</a>
						</div>
					</div>
					<div class="qcard-footer-test hidden">
					<%Collection<Test> usedIn = edit.getTestsWithQuestion(question.getQuestionId()); %>
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
						<% int n = 0; %>
						<% while(itTests.hasNext()) { n++;%>
						<% Test aTest = itTests.next(); %>
						<p>
							<%= n %>) <a href=""><%=aTest.getName() %></a>
						</p>
						<% } %>
					</div>
					<% } %>
				</div>
				</div>
			</div>
			<%} %>
		</div>
	</div>
	<script src="pages/question.js"></script>
</body>

</html>