/**
 * 
 */
function registerListeners() {
	let editButtons = document.getElementsByClassName('btn-edit');
	for (button of editButtons) {
		button.addEventListener('click', function(buttonId) {
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
	let el = document.getElementById('cat-upgrade' + catId);
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

	return { onSuccess, onError }
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
	let listener = function() { };
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