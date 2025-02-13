<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="web.Categories, java.util.*, model.Category"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categories</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/buttons.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/header.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/tabsContainer.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/categories.css" />
<style>
ul {
	list-style-type: none;
}

a {
	text-decoration: none;
	color: black;
}

.category-container {
	background-color: #ffffff;
	border-radius: 8px;
	box-shadow: 0 0px 3px rgba(0, 40, 77, .2);
}

.category-name-text {
	font-family: Inter, sans-serif;
	font-size: 14px;
	font-weight: 600;
}

.input-category-name-text {
	padding: 8px 16px;
	border: 1px solid #dce1e5;
	border-radius: 4px;
	font-family: Inter, sans-serif;
	font-size: 14px;
}

.input-category-name-text:hover {
	border: 1px solid black;
	border-radius: 4px;
}

.btn {
	border: none;
	padding: 8px 12px;
	background-color: #edf0f2;
	border-radius: 4px;
	font-size: 13px;
	font-weight: 600;
}

.btn-update {
	color: white;
	background-color: #3cb27a;
}

.btn-delete, .btn-cancel {
	margin-left: 8px;
}

.btn-edit, .btn-update {
	margin-right: 8px;
}

.btn:hover {
	background-color: #e7e8eb;
	color: #444;
}

.btn-update:hover {
	background-color: #349968;
	color: white;
}

.close-button {
	display: inline-block;
	float: right;
	height: 20px;
	width: 20px;
	background-image: url(../img/close.svg);
	background-color: white;
	border: none;
	cursor: pointer;
}

.row {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 18px 24px;
	border-bottom: 1px solid #dce1e5;
}

.last-row {
	border-bottom: none;
}

.question-count a {
	color: #fb3311;
}

.hidden {
	display: none;
}

.upd-msg {
	color: #00b300;
	font-size: 12px;
}

.explication {
	color: #6a7680;
	list-style-type: disc;
	margin-left: 20px;
	margin-bottom: 20px;
	line-height: 1.5em;
}

.add-new-header {
	padding-bottom: 30px;
}

.new-category {
	padding: 24px;
}

.close {
	display: flex;
	justify-content: flex-end;
}

.text-field-label {
	display: inline-block;
	width: 125px;
	text-align: right;
}

.text-field {
	color: black;
	padding: 8px 16px;
	border: 1px solid #dce1e5;
	border-radius: 4px;
}

.new-category-input {
	margin-bottom: 20px;
}

.add-new-category-btn {
	margin-left: 125px;
}
</style>
</head>
<body>
	<%@include file="/fragments/header.jsp"%>

	<div class="main-container">
		<%@include file="/fragments/tabsContainer.jsp"%>
		<div class="category-container">
			<div class="new-category hidden">
				<div class="close">
					<button type="button" class="close-button"
						onclick="closeAddNewCategory()"></button>
				</div>
				<h4 class="add-new-header">Categories</h4>

				<ul class="explication">
					<li>Create <strong>Categories</strong> to better organize and
						group.
					</li>
					<li>You can add multiple <strong>Categories</strong></li>
				</ul>

				<form action="categories" method="post">
					<div class="new-category-input">
						<label class="text-field-label" for="">Name:</label> <input
							class="text-field" id="" type="text" name="categoryName" /> <span
							class="explication">Maximum 30 characters</span>
					</div>
					<div class="add-new-category-btn">
						<button class="button button-orange" name="cmd" value="new" type="submit">Add
							New Category</button>
					</div>
				</form>
			</div>
			<div class="row">
				<div></div>
				<div>
					<button type="button" class="button button-orange"
						onclick="showAddNewCategory()">New Category</button>
				</div>
			</div>
			<ul>
				<%
				Categories categories = (Categories) request.getAttribute("categories");
				%>
				<%
				Collection<Category> categoryList = categories.getCategories();
				%>
				<%
				int i = 0;
				%>
				<%
				for (Category category : categoryList) {
					i++;
				%>
				<li>
					<form id="cat-delete<%=i%>">
						<div class="row <%=i >= categoryList.size() ? "last-row" : ""%>">
							<div class="category-name category-name-text">
								<span><%=category.getName()%></span>
							</div>
							<div class="question-count">
								<a href="#"><%=categories.getNumberOfQuestionsBelongingToCategory(category.getId())%></a>
							</div>
							<div class="upd-msg hidden">
								<span>Updated!</span>
							</div>
							<div class="category-actions">
								<button id="edit<%=i%>" type="button" class="btn btn-edit"
									onclick="editCategory('<%=i%>')">Edit</button> <button id="delete<%=i%>"
									type="submit" name="cmd" value="delete" class="btn btn-delete" >Delete</button>
							</div>
							<div class="hidden">
								<input type="hidden" name="catId" value="<%=category.getId()%>" />
							</div>
						</div>
					</form>
					<form action="categories" method="post" id="cat-upgrade<%=i%>" class="hidden">
						<div class="row <%=i >= categoryList.size() ? "last-row" : ""%>">
							<div class="">
								<input class="input-category-name-text" type="text"
									name="categoryName" value="<%=category.getName()%>" />
							</div>
							<div class="question-count">
								<a href="#"><%=categories.getNumberOfQuestionsBelongingToCategory(category.getId())%></a>
							</div>
							<div class="category-actions">
								<button class="btn btn-update" type="submit" name="cmd" value="update"
									onclick="">Update</button> <button type="button"
									class="btn btn-cancel" onclick="cancelOp('<%=i%>')">Cancel</button>
							</div>
							<div style="display: none;">
								<input type="hidden" class="categoryId" name="categoryId" value="<%=category.getId()%>" />
							</div>
						</div>
					</form>
				</li>
				<%
				}
				%>
				<li></li>
			</ul>
		</div>
	</div>
	<script src="scripts/tabs.js"></script>
	<script>setActiveTab('Categories')</script>
	<script>
		function registerListeners() {
			let editButtons = document.getElementsByClassName('btn-edit');
			for (button of editButtons) {
				button.addEventListener('click', function (buttonId) {
					console.log('Edit button clicked');
				});
			}
		}
		function toggleAddNewCategory() {
			let el = document.getElementsByClassName('new-category')[0];
			toggleClass('hidden', el);
		}
		function showAddNewCategory() {
			let el = document.getElementsByClassName('new-category')[0];
			removeClass('hidden', el);
		}
		function closeAddNewCategory() {
			console.log('close new add category');
			let el = document.getElementsByClassName('new-category')[0];
			addClass('hidden', el);
		}
		function editCategory(catId) {
			toggleView(catId);
		}
		function cancelOp(catId) {
			toggleView(catId);
		}
		function toggleView(catId) {
			let editRow = document.getElementById('cat-delete' + catId);
			let upgradeRow = document.getElementById('cat-upgrade' + catId);
			editRow.classList.toggle('hidden');
			upgradeRow.classList.toggle('hidden');
		}
		function updateCategory(catId) {
			let el = document.getElementById('cat-upgrade'+catId);
			let categoryName = el.getElementsByClassName('input-category-name-text')[0].value;
			let categoryId = el.getElementsByClassName('categoryId')[0].value;
			sendUpdate(categoryName, categoryId, 'http://localhost:8080/DynamicWeb0/categories/?cmd=update');
		}
		function sendUpdate(catName, catId, uri) {
			let aja = new Ajax('post', uri)
			aja.setAjaxListener(updateCategoryListener);
		}
		function UpdateCategoryListener() {
			
			function onSuccess(data) {
				
			}
			function onError(data) {
				
			}
			
			return {onSuccess, onError}
		}
		function addClass(aClass, el) {
			el.classList.add(aClass);
		}
		function removeClass(aClass, el) {
			el.classList.remove(aClass);
		}
		function toggleClass(aClass, el) {
			el.classList.toggle(aClass);
		}
		function Ajax(method, url) {
			let uri = url;
			let meth = method;
			let listener = function () { };
			let xhr = new XMLHttpRequest();

			function init() {
				console.log('xhr init ' + xhr);
				xhr.open(meth, uri);
				xhr.onreadystatechange = handleStateChange;
				xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

			}
			function setAjaxListener(aListener) {
				listener = aListener;
			}

			function send(data) {
				console.log('xhr' + this.xhr);
				xhr.send(data);
			}
			function handleStateChange() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					listener.onSuccess(xhr.responseText);
				} else {
					listener.onError(xhr.responseText);
				}
				/* console.log('xhr' + xhr); */
			}
			init();
			return {
				setAjaxListener, send
			}
		}
		
		/* let aja = new Ajax("post", "http://localhost:8080/DynamicWeb0/testAjax");
		aja.setAjaxListener(function (data) {
			console.log(data);
		});

		aja.send('catId=1&catName=giannanannini');
		console.log('Done ajax'); */
	</script>
</body>

</html>