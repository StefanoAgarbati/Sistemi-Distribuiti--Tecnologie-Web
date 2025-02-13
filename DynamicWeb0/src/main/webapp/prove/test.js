/**
 * 
 */
function testListItemClicked(item) {
	console.log('testListItemClicked ');
	let actions = item.children[1].classList.toggle('hidden');
	let content = item.nextElementSibling;
	content.classList.toggle('closed');
	content.classList.toggle('opened');
	
}