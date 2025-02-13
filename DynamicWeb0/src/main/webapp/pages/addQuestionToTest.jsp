<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="web.*, model.*, java.util.*" %>
<%AddQuestionToTest toTest = (AddQuestionToTest)request.getAttribute("addQuestion"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Question</title>
<link rel="stylesheet" href="styles/header.css" />
<link rel="stylesheet" href="styles/buttons.css" />
<link rel="stylesheet" href="styles/edit.css" />
<link rel="stylesheet" href="styles/addQuestionToBank.css" />
<style>
/* * {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

.answers-container {
	background-color: white;
	border-radius: 8px;
	border: 1px solid rgba(0, 0, 0, 0.3);
	padding: 32px;
}

.container {
	width: 64%;
	padding: 30px 0;
	margin: auto;
}

.section-heading {
	margin: 20px 0;
	font-size: 14px;
}

.answer-top {
	display: flex;
	align-items: center;
	justify-content: space-between;
	max-width: 250px;
	margin-bottom: 12px;
}

.answer {
	margin-bottom: 10px;
}

.tname {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin: 32px 0;
}

.hline {
	margin: 60px 0 20px 0;
	border: 1px solid #dce1e5;
}

.rounded-box {
	border: 1px solid rgba(0, 0, 0, 0.3);
	border-radius: 4px;
	padding: 20px 0;
	text-align: center;
}

.rounded-box:hover {
	color: #fb3311;
	cursor: pointer;
}

.rounded-box span {
	font-size: 13px;
	font-weight: 600;
}

.hidden {
	display: none;
}

.opened {
	max-height: 300px;
}

.closed {
	max-height: 0px;
}

.more-answers, .errormsg {
	overflow: hidden;
	transition: max-height 0.4s ease-in;
}

#addmore {
	margin: 25px 0;
}

.settings-content {
	background-color: #f6f6f8;
	border-radius: 4px;
}

.answer-form {
	width: 70%;
}

.settings-content {
	padding: 15px 10px;
}

.input {
	padding: 8px 16px;
	border: 1px solid black;
	border-radius: 4px;
	font-size: 16px;
}

.empty-row {
	height: 10px;
}

.add-question-btn {
	display: flex;
	justify-content: space-between;
	margin-top: 20px;
}

.link {
	text-decoration: none;
	color: #fb3311;
}

.msgs {
	margin-top: 5px;
	margin-bottom: 16px;
	padding: 16px;
	color: #4e824e;
	border-left: 3px solid #5dbb5d;
	background-color: #f8fff8;
}

.errormsg {
	background-color: #fff6f3;
	border-left: 3px solid #f50808;
	color: #b5514f;
	margin-top: 15px;
	margin-bottom: 15px;
}

.error-text {
	padding: 16px;
}*/
</style>
</head>
<body>
	<div class="edit-header">
		<div class="edit-header-left">
			<a class="button button-dark-grey" href="EditTest?tid=<%=toTest.getTest().getId() %>">Back</a>
		</div>
		<div class="edit-header-center"><%=toTest.getTest().getName() %> / Add a new question</div>
		<div class="edit-header-right">
			<button id="submit-button" class="button button-orange"
						type="button" name="save" value="saveQuestion">Save</button>
		</div>
	</div>
	<div class="container">
		<div class="msgs hidden">
			<strong>Success</strong> Your Question was saved in your Test. <a
				class="link" href="/TestServlet">Go back to your Test</a> or add
			more Questions.
		</div>
		<div class="answers-container">
			<form id="question-form" class="answer-form" method="post" action="AddQuestionToTest?tid=<%=toTest.getTest().getId() %>">
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
								<%Collection<Category> categories = toTest.getCategories(); %>
								<%Iterator<Category> cit = categories.iterator(); %>
								<%while(cit.hasNext()) { %>
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
</body>

</html>