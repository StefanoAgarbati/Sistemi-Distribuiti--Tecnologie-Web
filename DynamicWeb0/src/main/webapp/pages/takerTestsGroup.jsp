<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="web.*,model.*,java.util.*"%>
<%
TakerTests tests = (TakerTests) request.getAttribute("tests");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>My Tests</title>
<link rel="stylesheet" href="styles/taker.css" />
<link rel="stylesheet" href="styles/header.css" />
<link rel="stylesheet" href="styles/mainContainer.css" />
<link rel="stylesheet" href="styles/base.css" />
<link rel="stylesheet" href="styles/buttons.css" />
<style>
.header-text {
	padding-top: 0;
}

.header-text-sup {
	margin-top: 40px;
}

.extra-info {
	display: flex;
	flex-direction: column;
}

.link {
	padding: 0px;
	margin-bottom: 5px;
}

.table-data {
	vertical-align: top;
}

.prev-scores-table {
	border-collapse: collapse;
}

.prev-scores-table tbody tr {
	border-top: 1px solid #ddd;
}

.prev-scores-table tbody td {
	font-size: 14px;
	color: #000000;
	padding: 16px 10px;
}

.prev-scores-table thead th, .table-single-row th {
	font-size: 13px;
	color: #6a7680;
}

.prev-scores-table thead th {
	padding: 16px 10px;
}

.prev-table-container {
	display: flex;
}

.prev-table-content {
	max-height: 0;
	overflow: hidden;
	transition: max-height 0.4s ease;
}

.is-open {
	max-height: 100%;
}

.table-single-row th, .table-single-row td {
	border-bottom: 1px solid #DDDDDD;
}
</style>
</head>

<body>
	<%@include file="/fragments/headerTaker.jsp"%>

	<div class="main-container">
		<p class="header-text-sup">My groups</p>
		<h3 class="header-text"><%=tests.getGroup().getName()%></h3>
		<div class="card no-padding">
			<table class="">
				<thead class="">
					<tr class="table-single-row">
						<th class="table-data col-30">Name</th>
						<th class="table-data col-20">Percentage</th>
						<th class="table-data col-10">Score</th>
						<th class="table-data col-20">Duration</th>
						<th class="table-data col-10"></th>
					</tr>
				</thead>
				<tbody>
					<%
					Collection<Test> testList = tests.getTests();
					%>
					<%
					Iterator<Test> tit = testList.iterator();
					%>
					<%
					int i = 0;
					%>
					<%
					while (tit.hasNext()) {
						i++;
					%>
					<%
					Test test = tit.next();
					%>
					<%System.out.println("takerTestsGroup.jsp TtestId " + test.getId()); %>
					<tr class="table-single-row">
						<td class="table-data extra-info">
							<p class="bold margin-bottom-10"><%=test.getName()%></p>
							<p class="little margin-bottom-20">Attempts allowed:
								Unlimited</p> <a class="link link-orange" href="#"
							onclick="showHidePrev('prev<%=i%>')">Show previous scores</a>
							<div id="prev<%=i%>" class="prev-table-container">
								<div>
									<div class="prev-table-content">
										<table class="prev-scores-table">
											<thead>
												<tr>
													<th>%</th>
													<th>Score</th>
													<th>Duration</th>
													<th>Date started</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>10%</td>
													<td>10/100</td>
													<td>01:32:43</td>
													<td>Mon 15 Apr'24 14:28</td>
												</tr>
												<tr>
													<td>10%</td>
													<td>10/100</td>
													<td>01:32:43</td>
													<td>Mon 15 Apr'24 14:28</td>
												</tr>
												<tr>
													<td>10%</td>
													<td>10/100</td>
													<td>01:32:43</td>
													<td>Mon 15 Apr'24 14:28</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div> <a class="link link-orange"
							href="TakerTest?testId=<%=test.getId()%>">Retake</a>
						</td>
						<td class="table-data"><span>28.3%</span></td>
						<td class="table-data">2/8</td>
						<td class="table-data">00:13:45</td>
						<td class="table-data"><a class="button button-blue" href="#">Results</a>
						</td>
					</tr>
					<%
					}
					%>
					<tr class="table-single-row">
						<td class="table-data extra-info">
							<p class="bold margin-bottom-10">TestName</p>
							<p class="little margin-bottom-20">Attempts allowed:
								Unlimited</p> <a class="link link-orange" href="#">Retake</a>
						</td>
						<td class="table-data"><span>45%</span></td>
						<td class="table-data">45/100</td>
						<td class="table-data">00:23:45</td>
						<td class="table-data"><a class="button button-blue" href="#">Results</a>
						</td>
					</tr>
					<tr class="table-single-row">
						<td class="table-data extra-info">
							<p class="bold margin-bottom-10">TestName</p>
							<p class="little margin-bottom-20">Attempts allowed:
								Unlimited</p>
							<div>
								<a class="button button-green" href="#">Start</a>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<script>
		function showHidePrev(prevName) {
			let el = document.getElementById(prevName);
			let item = el.getElementsByClassName('prev-table-content')[0];
			item.classList.toggle('is-open');
		}
	</script>
</body>

</html>