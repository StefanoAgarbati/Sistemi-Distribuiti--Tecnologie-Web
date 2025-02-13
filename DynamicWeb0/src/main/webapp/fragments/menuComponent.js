/**
 * 
 */
function MenuComponent(items) {
	
	let mItems = items;
	
	let rootEl = document.createElement('div');
	let menuEl = document.createElement('div');
	rootEl.setAttribute('class','menu-container');
	menuEl.setAttribute('class', 'menu');
	
	items.forEach(item => {
		let itemEl = new MenuItemComponent(item);
		menuEl.appendChild(itemEl);
	});
	
	return rootEl;
}
function MenuItemComponent(item) {
	
	let root = document.createElement('div');
	let linkEl = document.createElement('a');
	
	root.setAttribute('class', 'menu-item');
	
	linkEl.setAttribute('href', item.link);
	linkEl.innerText = item.text;
	
	root.appendChild(link);
	
	return root;
}