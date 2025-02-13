<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="web.TestQuestions"%>
	<%TestQuestions test = new TestQuestions(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=test.getTest().getName() %></title>
<link rel="stylesheet" href="../styles/taker.css" />
<link rel="stylesheet" href="../styles/header.css" />
<link rel="stylesheet" href="../styles/mainContainer.css" />
<link rel="stylesheet" href="../styles/base.css" />
<link rel="stylesheet" href="../styles/buttons.css" />
<style>
	.test-title {
		margin-top: 100px;
		margin-bottom:10px;
		font-size: 16px;
		font-weight: 600;
	}
	.taker-name {
		color: #454f59;
	}
</style>
</head>
<body>
	<div class="main-container">
		<p class="test-title"><%=test.getTest().getName() %></p>
		<p class="taker-name"><%=test.getTakerName() %></p>
		
	</div>
</body>
</html>