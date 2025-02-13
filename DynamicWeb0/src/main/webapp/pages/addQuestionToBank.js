function HeaderComponent(aUsername='None') {
	let username = aUsername;
	let logoutText = 'Logout';
	let logoImg = '../img/logo.svg';
	let menuItems = [{name:'Dashboard', link:'#'},{name:'Test', link:'#'},
			{name:'Link', link:'#'},{name:'Group', link:'#'},{name:'Help', link:'#'},{name:'MyAccount', link:'#'}];
	
	let template = `<div class="header">
		<div class="header-top">
			<div class="htleft">
				<a href="#">
					<img src="./img/logo.svg" />
				</a>
			</div>
			<div class="htright">
				<ul>
					<li><a id="user" href="#">Hi `+username+`</a></li>
					<li>|</li>
					<li><a id="logout" href="#">Logout</a></li>
				</ul>
			</div>
		</div>
		<div class="menu-container">
			<div class="menu">
				<div class="menu-item"><a href="`+menuItems[0].link+`">`+menuItems[0].name+`</a></div>
				<div class="menu-item"><a href="`+menuItems[1].link+`">`+menuItems[1].name+`</a></div>
				<div class="menu-item"><a href="`+menuItems[2].link+`">`+menuItems[2].name+`</a></div>
				<div class="menu-item"><a href="`+menuItems[3].link+`">`+menuItems[3].name+`</a></div>
				<div class="menu-item"><a href="`+menuItems[4].link+`">`+menuItems[4].name+`</a></div>
				<div class="menu-item"><a href="`+menuItems[5].link+`">`+menuItems[5].name+`</a></div>
			</div>
		</div>
	</div>`;
	
	function render() {
		return template;
	}
	
	return {render}
};

export {HeaderComponent};