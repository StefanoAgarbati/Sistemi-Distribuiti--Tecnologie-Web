<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="web.AddQuestionToBank, model.*, java.util.*" %>
<!DOCTYPE html>
<% String username = (String) request.getAttribute("username"); %>
<%System.out.println("username received " + username); %>
<% AddQuestionToBank toBank = (AddQuestionToBank)request.getAttribute("addQuestionToBank"); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Question</title>
<link rel="stylesheet" href="styles/header.css" />
<link rel="stylesheet" href="styles/buttons.css" />
<link rel="stylesheet" href="styles/addQuestionToBank.css" />
</head>
<body>

	<%@include file="/fragments/header.jsp" %>
	
	<div class="container">
		<div class="hline"></div>
		<div class="tname"></div>
		<div class="msgs" style="display: block;">
			<strong class="black-text">You are adding Questions to your
				Question bank, not to a Test.</strong> <br /> To add Questions to a Test
			instead, go to the <a class="link" href="TestServlet">Test section.</a>
		</div>
		<div class="answers-container">
			<form id="question-form" class="answer-form" method="post"
				action="AddQuestionToBank">
				<div>
					<h5 class="section-heading">Enter your question</h5>
					<textarea id="question-text" class="text-area" name="question"
						rows="6" cols="67"></textarea>
				</div>
				<div class="answers">
					<div>
						<h5 class="section-heading">Answers</h5>
					</div>
					<div class="answer">
						<div class="answer-top">
							<h5>(A)</h5>
							<input id="answerA" type="checkbox" name="answerA"
								value="correctA" /> <label for="answerA">This answer
								option is correct</label>
						</div>
						<textarea id="answerAText" class="text-area" name="answerAText"
							rows="3" cols="67"></textarea>
					</div>
					<div class="answer">
						<div class="answer-top">
							<h5>(B)</h5>
							<input class="isCorrect" id="answerB" type="checkbox"
								name="answerB" value="correctB" /> <label for="answerB">This
								answer option is correct</label>
						</div>
						<textarea id="answerBText" class="text-area" name="answerBText"
							rows="3" cols="67"></textarea>
					</div>
					<div class="answer">
						<div class="answer-top">
							<h5>(C)</h5>
							<input id="answerC" type="checkbox" name="answerC"
								value="correctC" /> <label for="answerC">This answer
								option is correct</label>
						</div>
						<textarea id="answerCText" class="text-area" name="answerCText"
							rows="3" cols="67"></textarea>
					</div>
					<div class="answer">
						<div class="answer-top">
							<h5>(D)</h5>
							<input id="answerD" type="checkbox" name="answerD"
								value="correctD" /> <label for="answerD">This answer
								option is correct</label>
						</div>
						<textarea id="answerDText" class="text-area" name="answerDText"
							rows="3" cols="67"></textarea>
					</div>
					<div id="addmore" class="rounded-box" onclick="showMoreAnswers()">
						<span>Add more answer option</span>
					</div>
					<div id="moreanswers" class="more-answers closed">
						<div class="answer">
							<div class="answer-top">
								<h5>(E)</h5>
								<input id="answerE" type="checkbox" name="answerE"
									value="correctE" /> <label for="answerE">This answer
									option is correct</label>
							</div>
							<textarea id="answerEText" class="text-area" name="answerEText"
								rows="3" cols="67"></textarea>
						</div>
						<div class="answer">
							<div class="answer-top">
								<h5>(F)</h5>
								<input id="answerF" type="checkbox" name="answerF"
									value="correctF" /> <label for="answerF">This answer
									option is correct</label>
							</div>
							<textarea id="answerFText" class="text-area" name="answerFText"
								rows="3" cols="67"></textarea>
						</div>
						<div class="answer">
							<div class="answer-top">
								<h5>(G)</h5>
								<input id="answerG" type="checkbox" name="answerG"
									value="correctG" /> <label for="answerG">This answer
									option is correct</label>
							</div>
							<textarea id="answerGText" class="text-area" name="answerGText"
								rows="3" cols="67"></textarea>
						</div>
						<div class="answer">
							<div class="answer-top">
								<h5>(H)</h5>
								<input id="answerH" type="checkbox" name="answerH"
									value="correctH" /> <label for="answerH">This answer
									option is correct</label>
							</div>
							<textarea id="answerHText" class="text-area" name="answerHText"
								rows="3" cols="67"></textarea>
						</div>
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
								<%Collection<Category> categories = toBank.getCategories(); %>
								<%Iterator<Category> cit = categories.iterator(); %>
								<%while(cit.hasNext()) {%>
								<%Category category = cit.next(); %>
								<option value="<%=category.getId()%>"><%=category.getName() %></option>
								<%} %>
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
				<div class="add-question-btn">
					<button id="submit-button" class="button button-orange"
						type="button" name="save" value="saveQuestion" onclick="">Save</button>
					<a class="button button-white" href="questions"
						onclick="onCancel()">Cancel</a>
				</div>
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
	<script src="scripts/addQuestionToBank.js"></script>
	<script type="text/javascript" src="script/addQuestionToBank.js"></script>
</body>
</html>