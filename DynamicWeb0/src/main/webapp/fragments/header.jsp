<%String uname = (String)session.getAttribute("username"); %>
<div class="header">
	<div class="header-top">
		<div class="htleft">
			<a href="Home"> <img src="img/logo.svg" />
			</a>
		</div>
		<div class="htright">
			<ul>
				<li><a id="user" href="#">Hi <%=uname %></a></li>
				<li>|</li>
				<li><a id="logout" href="Logout">Logout</a></li>
			</ul>
		</div>
	</div>
	<div class="menu-container">
		<div class="menu">
			<div class="menu-item">
				<a href="#">Dashboard</a>
			</div>
			<div class="menu-item">
				<a href="TestServlet">Test</a>
			</div>
			<div class="menu-item">
				<a href="#">Links</a>
			</div>
			<div class="menu-item">
				<a href="Groups">Groups</a>
			</div>
			<div class="menu-item">
				<a href="#">Help</a>
			</div>
			<div class="menu-item">
				<a href="#">My Account</a>
			</div>
		</div>
	</div>
</div>