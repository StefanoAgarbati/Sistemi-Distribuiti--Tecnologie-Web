<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="port.interfaces.web.ManageTestBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Test</title>
</head>
<body>
	<div class="title-card">
	<% ManageTestBean manageBean = new ManageTestBean(); %>
		<div class="card-header"><%= manageBean.getTestName() %></div>
		<div class="card-content">
			<div class="options-left">
				<button></button>
				<button></button>
				<button></button>
			</div>
			<div class="options-right">
			</div>
		</div>
	</div>
	<div class="info">
		<div class="tqcount"><%= manageBean.getNumberOfQuestions() %> Questions</div>
		<div class="qcount">Question bank: <%= manageBean.getQuestionsInBank() %> Questions</div>
	</div>
	<div>
		<div class="tabs">
			<button>Test Questions <span><%=manageBean.getNumberOfQuestions() %></span></button>
			<button><span>Assigned Test</span></button>
		</div>
		<div>Test question content action</div>
		<div>Test question content</div>
		<div>Assignment content</div>
	</div>
</body>
</html>