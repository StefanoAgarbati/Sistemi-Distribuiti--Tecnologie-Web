<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="web.*, model.*, java.util.*"%>
<%
TakerTest takerTest = (TakerTest) request.getAttribute("test");
%>
<!DOCTYPE html>
<html>
<%
String testName = takerTest.getTest().getName();
%>
<head>
<meta charset="ISO-8859-1">
<title><%=testName%></title>
<link rel="stylesheet" href="styles/buttons.css" />
<link rel="stylesheet" href="styles/question.css" />
<link rel="stylesheet" href="styles/base.css" />
<link rel="stylesheet" href="styles/mainContainer.css" />
<style>
.answer-letter, .answer-check {
	margin-right: 5px;
}

.answer, .answer-check {
	display: flex;
	align-items: center;
}

.question-card-header {
	background-color: #ababab2b;
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
}
</style>
</head>

<body>
	<div class="main-container">
		<h3 class="dark large"><%=testName%></h3>
		<br> <br> <br>
		<form method="post" action="CompleteTest">
			<%
			Collection<Question> questions = takerTest.getQuestions();
			Iterator<Question> qit = questions.iterator();
			int i = 0;
			int numberOfQuestions = questions.size();
			while (qit.hasNext()) {
				i++;
				Question question = qit.next();
			%>
			<div id="qc1" class="question-card">
				<div class="question-card-item question-card-header dark">
					<span class="qcard-header-name">Question <%=i%> of <%=numberOfQuestions%></span>
				</div>
				<div class="question-info question-card-item">
					<div class="question-text"><%=question.getText()%></div>
					<input type=hidden name="q<%=i%>"
						value="<%=question.getQuestionId()%>" />
					<div class="question-info-answers opened">
						<table class="question-info-answer-table">
							<%
							Collection<PossibleResponse> responses = takerTest.getResponsesForQuestion(question.getQuestionId());
							Iterator<PossibleResponse> rip = responses.iterator();
							while (rip.hasNext()) {
								PossibleResponse res = rip.next();
							%>
							<tr class="answer">
								<td class="answer-check"><input type="radio"
									name="r<%=i%>" value="<%=res.getResponseId()%>" /></td>
								<td class="answer-letter"><%=res.getName()%>.</td>
								<td class="answer-text"><%=res.getText()%></td>
							</tr>
							<%
							}
							%>
						</table>
					</div>
				</div>
			</div>
			<%
			}
			%>
			<br>
			<div class="flexy justify-center">
				<button type="submit" class="button button-large button-green">Finish
					Now</button>
			</div>
			<br> <br>
		</form>
</body>

</html>