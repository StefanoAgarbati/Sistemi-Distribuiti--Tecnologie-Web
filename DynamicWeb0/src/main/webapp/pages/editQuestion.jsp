<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="web.EditQuestion, model.*, java.util.*"%>
<%EditQuestion edit = (EditQuestion)request.getAttribute("edit"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Question</title>
<link rel="stylesheet" href="styles/header.css" />
<link rel="stylesheet" href="styles/buttons.css" />
<link rel="stylesheet" href="styles/edit.css" />
<link rel="stylesheet" href="styles/addQuestionToBank.css" />
</head>
<body>
	<%Question question = edit.getQuestion(); %>
	<%Test test = edit.getTest(); %>
	<%Collection<PossibleResponse> responses = edit.getResponses(); %>
	<%if(test != null) { %>
	<div class="edit-header">
		<div class="edit-header-left">
			<a class="button button-dark-grey"
				href="EditTest?tid=<%=test.getId()%>">Back</a>
		</div>
		<div class="edit-header-center"><%=test.getName()%>
			/ Edit question
		</div>
		<div class="edit-header-right">
			<button id="submit-button" class="button button-orange" type="button"
				name="save" value="saveQuestion">Save</button>
		</div>
	</div>
	<%} else {%>
	<div class="edit-header">
		<div class="edit-header-left">
			<a class="button button-dark-grey"
				href="questions">Back</a>
		</div>
		<div class="edit-header-center">Question Bank
			/ Edit question
		</div>
		<div class="edit-header-right">
			<button id="submit-button" class="button button-orange" type="button"
				name="save" value="saveQuestion">Save</button>
		</div>
	</div>
	<%} %>
	<div class="container">
		<div class="answers-container">
			<form id="question-form" class="answer-form" method="post"
				action="EditQuestion?qid=<%=question.getQuestionId()%>
				<%if(test != null) {%>&tid=<%=test.getId()%><%}%>">
				<div>
					<h5 class="section-heading">Enter your question</h5>
					<textarea id="question-text" class="text-area" name="question"
						rows="6" cols="67"><%=question.getText() %></textarea>
				</div>
				<div class="answers">
					<div>
						<h5 class="section-heading">Answers</h5>
					</div>
					<%String[] names = new String[]{"A","B","C","D"}; %>
					<%for(String name : names) { %>
					<div class="answer">
						<%PossibleResponse res = edit.getResponseByName(name); %>
						<div class="answer-top">
							<h5>(<%=name %>)</h5>
							<input id="answer<%=name %>" type="checkbox" name="answer<%=name %>"
								value="correct<%=name %>" <%if(res!=null && res.isCorrect()) {%> checked <%} %>/> <label for="answer<%=name%>">This answer
								option is correct</label>
						</div>
						<textarea id="answer<%=name %>Text" class="text-area" name="answer<%=name %>Text"
							rows="3" cols="67"><%=(res!=null) ? res.getText() : "" %></textarea>
					</div>
					<%} %>
					<div id="addmore" class="rounded-box" onclick="showMoreAnswers()">
						<span>Add more answer option</span>
					</div>
					<div id="moreanswers" class="more-answers closed">
					<%names = new String[]{"E","F","G","H"}; %>
					<%for(String name : names) { %>
					<div class="answer">
						<%PossibleResponse res = edit.getResponseByName(name); %>
						<div class="answer-top">
							<h5>(<%=name %>)</h5>
							<input id="answer<%=name %>" type="checkbox" name="answer<%=name %>"
								value="correct<%=name %>" <%if(res!=null && res.isCorrect()) {%> checked <%} %>/> <label for="answer<%=name%>">This answer
								option is correct</label>
						</div>
						<textarea id="answer<%=name %>Text" class="text-area" name="answer<%=name %>Text"
							rows="3" cols="67"><%=(res!=null) ? res.getText() : "" %></textarea>
					</div>
					<%} %>
					</div>
				</div>
				<div class="settings">
					<h5 class="section-heading">Question Settings</h5>
					<div class="settings-content">
						<div>
							<h5 class="section-heading">Category</h5>
							<p class="cat-expl">
								- Categories help you <strong>analyze low-performing
									areas</strong>in your Tests
							</p>
							<select id="category-name" class="category-select"
								name="categoryId">
								<%
								Collection<Category> categories = edit.getCategories();
								%>
								<%
								Iterator<Category> cit = categories.iterator();
								%>
								<%
								while (cit.hasNext()) {
								%>
								<%
								Category category = cit.next();
								%>
								<option value="<%=category.getId()%>"><%=category.getName()%></option>
								<%
								}
								%>
							</select>
						</div>
						<div class="hline"></div>
						<div>
							<h5 class="section-heading">Points available</h5>
							<input class="input" type="text" name="points" value="1"
								maxlength="5" size="5" />
						</div>
						<div class="hline"></div>
						<div>
							<h5 class="section-heading">Randomize answers</h5>
							<input type="radio" checked="true" name="rand" value="no">
							<label>No</label>
							<div class="empty-row"></div>
							<input type="radio" name="rand" value="yes" /> <label>Yes</label>
						</div>
						<div class="hline"></div>
						<div>
							<h5 class="section-heading">Answer selection</h5>
							<input type="radio" checked="true" name="selection"
								value="single"> <label>Single answer <span>-
									only one answer option can be selected</span></label>
							<div class="empty-row"></div>
							<input type="radio" name="selection" value="multi" /> <label>Multiple
								answers <span>- multiple answer option can be selected</span>
							</label>
						</div>
					</div>
				</div>
				<%-- <% if(test == null) { %>
				<div class="add-question-btn">
					<button id="submit-button" class="button button-orange"
						type="button" name="save" value="saveQuestion" onclick="">Save</button>
					<a class="button button-white" href="questions"
						onclick="onCancel()">Cancel</a>
				</div>
				<% } %> --%>
				<div class="errormsg closed">
					<p class="error-text">You have not entered a question</p>
				</div>
				<div class="errormsg closed">
					<p class="error-text">You must select the correct answer</p>
				</div>
				<div class="errormsg closed">
					<p class="error-text">You must fill the first two boxes</p>
				</div>
			</form>
		</div>
	</div>
	<br/><br/>
	<script src="scripts/addQuestionToBank.js"></script>
</body>
</html>