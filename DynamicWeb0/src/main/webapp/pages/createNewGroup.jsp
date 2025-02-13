<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Create New Group</title>
	<link rel="stylesheet" href="styles/header.css" />
	<link rel="stylesheet" href="styles/mainContainer.css" />
	<link rel="stylesheet" href="styles/buttons.css" />
	<style>
		.flexible {
			display: flex;
		}

		.card {
			padding: 32px;
			border-radius: 4px;
			background-color: #FFFFFF;
			box-shadow: 0 0 4px rgba(0, 40, 77, 0.2);
		}

		.card-content {
			padding: 32px;
		}

		.input {
			outline: none;
			padding: 6px 10px;
			border-radius: 4px;
			border: 1px solid #d9d9d9;
		}
		.input:hover {
			border:1px solid #000000;
		}
		.field-row {
			display: flex;
			align-items: center;
			margin-bottom: 25px;
		}
		.col-150 {
			width:150px;
		}
	</style>
</head>
<body>
	<%@include file="/fragments/header.jsp" %>
	
	<div class="main-container">
		<div >
			<div class="card-content">
				<form class="card" method="post" action="CreateNewGroup">
					<div class="field-row">
						<label class="col-150" for="name">Group Name: </label>
						<input class="input" size="40" type="text" name="name" />
					</div>
					<div class="field-row">
						<div class="col-150"></div>
						<button class="button button-orange"type="submit" name="cmd" value="createNewGroup">Create Group</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>