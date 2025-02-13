/**
 * 
 */
function Tab(aName) {
	let active = false;
	let name = aName;
	
	function activate() {
		active = true;
	}
	function deactivate() {
		active = false;
	}
	function getName() {
		return aName;
	}
	return {
		activate, deactivate, getName
	}
}
function TabContent(aName) {
	let name = aName;
	let visible = false;
	
	function show() {
		visible = true;
	}
	function hide() {
		visible = false;
	}
	function getName() {
		return name;
	}
	return {
		show, hide, getName
	}
}
function TabMenuItem(aName, aTab, aTabContent) {
	let tab = aTab;
	let tabContent = aTabContent;
	let name = aName;
	
	function activate() {
		tab.activate();
		tabContent.show();
	}
	function deactivate() {
		tab.deactivate();
		tabContent.hide();
	}
	function getName() {
		return name;
	}
	return {
		activate, deactivate, getName
	}
}

