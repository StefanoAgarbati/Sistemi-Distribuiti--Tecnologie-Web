/**
 * 
 */
let data = '';

function getAllTests() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(this.readyState==4 & this.status == 200) {
			onResponse(this.responseText);
		}
	}
	xhr.open('get', '../TestGet');
	xhr.send();
}
function onResponse(data) {
	console.log(data);
}
