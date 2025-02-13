/**
 * 
 */

function switchVisibility(el) {
	toggleClass(el, 'test-item-selected');
	console.log('clicked');
	let nextEl = el.nextElementSibling;
	toggleClass(nextEl, 'hidden');
}
function toggleClass(anElement, className) {
	let classes = anElement.classList;
	classes.toggle(className);
}