/**
 * 
 */
function Tab(anId, aName, isActive, aTabImpl) {
	let id = anId;
	let name = aName;
	let active = isActive;
	let tabImpl = aTabImpl;
	
	function activate () {
		setActive(true); 
	}
	function setActive(val) {
		active = val;
		activeChanged();
	}
	function deactivate(){
		setActive(false);
	}
	function getActive(){
		return active;
	}
	function getName() {
		return name;
	}
	function getId(){
		return id;
	}
	function activeChanged() {
		aTabImpl.setActive(active);
	}
	return {activate, deactivate, getActive, getName, getId}
	
}
function TabContainerView(root, props) {
	
	function createTabContainer(root, props) {
		let tabsRoot = document.createElement('div');
		tabsRoot.classList.add('tabs-container');
		root.appendChild(tabsRoot);
		
		let tabsList = document.createElement('ul');
		tabsRoot.appendChild(tabsList);
		
		for(let i = 0; i < props.tabs.length; i++) {
			let item = document.createElement('li');
			let anchor = document.createElement('a');
			item.appendChild(anchor);
			
			anchor.setAttribute('href', props.tabs[i].link);
			anchor.innerText = props.tabs[i].name;
			item.classList.add('t-tab');
			item.classList.add(props.tabs[i].active ? 'tabon' : 'taboff');	
			
			tabsList.appendChild(item);	
		}
	}
	createTabContainer(root, props);
	
}
var TabsContainerConfig = {
	tabs: [
		{name:'', active: false, link:'TestServlet'},
		{name:'', active: false, link:'#'},
		{name:'', active: false, link:'#'},
		{name:'', active: false, link:'#'},
	]
}