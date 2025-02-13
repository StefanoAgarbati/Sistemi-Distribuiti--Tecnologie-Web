<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title></title>
	<link rel="stylesheet" href="question.css"/>
</head>
	
<body>
	<div class="question-card">
		<div class="question-card-item question-card-header">
			<span class="qcard-header-name">Question 1</span>
			<span class="qcard-header-cat">Category</span>
			<span class="qcard-header-points">4Pts</span>
		</div>
		<div class="question-info question-card-item">
			<div class="question-text">Question Text</div>
			<div class="question-info-answers hidden">
				<table class="question-info-answer-table">
					<tr class="answer correct-answer">
						<td class="answer-letter">A.</td>
						<td class="answer-text">Response</td>
						<td class="correct-icon"><img class="correct-icon-img" src="../img/correct.svg" /></td>
					</tr>
					<tr class="answer">
						<td class="answer-letter">A.</td>
						<td class="answer-text">Response</td>
						<td class="correct-icon hidden"><img class="correct-icon-img" src="../img/correct.svg" /></td>
					</tr>
					<tr class="answer">
						<td class="answer-letter">A.</td>
						<td class="answer-text">Response</td>
						<td class="correct-icon hidden"><img class="correct-icon-img" src="../img/correct.svg" /></td>
					</tr>
				</table>
			</div>
		</div>
		<div class="question-card-footer question-card-item">
			<div class="qcard-actions">
				<a class="qcard-action" href="javascript:void(0)" onclick="showHideAnswers()">Answers</a>
				<a class="qcard-action" href="">Edit</a>
				<a class="qcard-action" href="javascript:void(0)" onclick="showDelete()">Delete</a>
				<a class="qcard-action" href="javascript:void(0)">Used In</a>
			</div>
			<div class="qcard-footer-delete hidden">
				<p class="strong-text qcard-footer-delete-item">Are you sure you want to permanently delete this
					Question?</p>
				<p class="qcard-footer-delete-item">You will NOT be able to restore this Question once deleted</p>
				<div class="delete-buttons qcard-footer-delete-item">
					<a class="button button-orange delete-button" href="">Permanently Delete Question</a>
					<a class="button button-grey cancel-button" href="javascript:void(0)" onclick="hideDelete()">Cancel</a>
				</div>
			</div>
			<div class="qcard-footer-test">
				<div class="used-in-header no-test-msg">
					<p>No Tests are currently using this Question.</p>
					<img class="close" src="../img/close.svg"/>
				</div>
				<div class="some-test-msg">
					<div class="used-in-header"><p>Tests currently using this Question: <a href="">close</a></p></div>
					<p>1) <a href="">Test</a></p>
					<p>1) <a href="">Test</a></p>
				</div>
			</div>
		</div>
	</div>
	<script src="question.js"></script>
</body>

</html>