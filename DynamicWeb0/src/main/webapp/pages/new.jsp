<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="web.NewTestViewModel,web.CategoryViewModel, model.Category, web.NewTest, java.util.*" %>

<% NewTest newTest = (NewTest)request.getAttribute("newTest"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles/newStyle.css" />
<link rel="stylesheet" href="styles/header.css" />
<title>Add New Test</title>
</head>
<body>

	<%@include file="../fragments/header.jsp" %>
	
	<div class="margin-top-big">
		<form class="container card" action="addNewTest" method="post">
			<div class="row">
				<label class="col-100 label" for="testName">Test name</label>
				<input id="testName" class="input" size="40" type="text" name="testName"/>
			</div>
			<div class="row">
				<label class="col-100 label">Category:</label>
				<select class="selection" name="category">
					<% Collection<Category> categories = newTest.getCategories(); %>
					<% Iterator<Category> it = categories.iterator(); %>
					<% while(it.hasNext()) { %>
					<% Category category = it.next(); %>
					<option value="<%= category.getId()%>"><%=category.getName() %></option>
					<%} %>
				</select>
				<div class="empty-col-20"></div>
				<a class="col-100" href="javascript:void(0)" onclick="openNewCategoryModal()">New category</a>
			</div>
			<div class="row">
				<div class="col-100"></div>
				<button class="button button-orange" type="submit">Create Test</button>
			</div>
		</form>
	</div>
	<div class="hidden">
		<span>The test has been successfully added</span>
	</div>
	<div class="modal hidden">
		<div class="modal-container">
			<div class="modal-header">
				<h3>Add New Category</h3>
				<span class="close" onclick="closeNewCategoryModal()"></span>
			</div>
			<div class="modal-content">
				<form class="table" action="addCategory" method="post">
					<div class="row">
						<label class="col-20">Category</label>
						<input class="input col-40" type="text" name="categoryName"/>
						<span class="padleft col-40">Maximum 30 Characters</span>
					</div>
					<div class="row">
						<div class="emptycol20"></div>
						<button class="button button-orange" type="submit">Create</button>
						<div class="empty-col-10"></div>
						<button class="button button-grey" type="button" onclick="closeNewCategoryModal()">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="prove/addNewTest.js"></script>
</body>
</html>