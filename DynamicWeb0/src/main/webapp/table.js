/**
 * 
 */
function createTable(containerId) {
	const container = document.getElementById(containerId);
	const table = document.createElement('table');
	const th = document.createElement('th');
	const tr = document.createElement('tr');
}
function createElement(name) {
	return document.createElement(name);
}
function createTableHeader(data) {
	const th = createElement('th');
	
}
function createTableRow() {
	return createElement('tr');
}
function test() {
	const div = createElement('div');
	div.innerHTML = 'ciao ciao';
	return div;
}
document.body.appendChild(test());