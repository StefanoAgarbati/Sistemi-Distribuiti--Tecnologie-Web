<%String uname = (String)session.getAttribute("username"); %>
<div class="header">
	<div class="header-top">
		<div class="htleft">
			<a href="#"> <img src="img/logo.svg" />
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
			<div class="menu-item menu-item-active">
				<a href="#">My Groups</a>
			</div>
			<div class="menu-item right">
				<a href="#">Help</a>
			</div>
			<div class="menu-item right">
				<a href="#">My Details</a>
			</div>
		</div>
	</div>
</div>