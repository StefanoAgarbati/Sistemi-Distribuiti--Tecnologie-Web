/**
 * 
 */
function setActiveTab(name) {
	let tabs = document.getElementById('tabs-container');
	let items = tabs.getElementsByClassName('t-tab');
	for(let i = 0; i < items.length; i++) {
		let child = items[i].firstChild;
		if(child.innerText == name) {
			items[i].classList.remove('taboff');
			items[i].classList.add('tabon');
		}
	}
}
