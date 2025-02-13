/**
 * 
 */
var barConfig = {
	tabs: [
		{name: 'Tab1', state: 'on', link: '#'},
		{name: 'Tab2', state: 'off', link: '#'},
		{name: 'Tab3', state: 'off', link: '#'}
	]
};
function TabsBar(config) {
	let list = document.createElement('ul');
	let tabs = [];
	let currentActiveTab = '';
	
	for(let i = 0; i < config.tabs.length; i++) {
		let tab = Tab(config.tabs[i].name, config.tabs[i].link);
		tab.addTabToBar(this);
	}
	function addTab(aTab) {
		list.appendChild(aTab);
		tabs.push(aTab);
	}
	function Tab(aName, aLink, rEl) {
		let name = aName;
		let link = aLink;
		let state = 'off';
		
		let tab = document.createElement('li');
		let tabContent = document.createElement('a');
		tabContent.innerHTML = name;
		tabContent.setAttribute('href', link);
		tab.appendChild(tabContent);
		tab.classList.add('listItem', 'tabOff');
		rEl.appendChild(tab);
		
		function getName() {
			return name;
		}
		function activate() {
			state = 'on';
			replaceClass('tabOff', 'tabOn');
		}
		function deactivate() {
			state = 'off';
			replaceClass('tabOn', 'tabOff');
		}
		function replaceClass(current, target) {
			tab.classList.remove(current);
			tab.classList.add(target);
		}
		function setTabObserver(observer) {
			this.observer = observer;
		}
		function addTabToBar(bar) {
			bar.addTab(tab);
		}
		return {
			getName,
			activate,
			deactivate,
			addTabToBar
		}
	}
	function setActiveTab(name) {
		deactivateAll();
		activate(name);
	}
	function deactivateAll() {
		tabs.forEach(tab => {
			tab.deactivate();
		});
	}
	function activate(aName) {
		tabs.forEach(tab => {
			if(tab.getName() === aName) {
				tab.activate();
			}
		});
	}
	return {
		setActiveTab
	}
}
class BarTabController {
	constructor(model, view) {
		
	}
	setActiveTab(aTab) {
		
	}
	onSelectTab(aTab) {
		
	}
}
class TabView {
	constructor(id) {
		this.model = model;
		this.el = this.createElement();
	}
	createElement() {
		let tab = document.createElement('li');
		let tabContent = document.createElement('a');
		tabContent.innerHTML = name;
		tabContent.setAttribute('href', link);
		tab.appendChild(tabContent);
		tab.classList.add('listItem', 'tabOff');
		rEl.appendChild(tab);
	}
}
class BarWithTabs {
	constructor() {
		this.tabs = [];
	}
	addTab(aTab) {
		this.tabs.push(aTab);
	}
	getTab(name) {
		return this.tabs.filter(tab => tab.getName() === name);
	}
	setActiveTab(name) {
		deactivateAll();
		activateTab(name);
	}
	deactivateAll() {
		this.tabs.forEach(tab => tab.deactivate());
	}
	activateTab(name) {
		getTab(name).activate();
	}
}
class Tab {
	constructor(name, link) {
		this.name = name;
		this.state = 'off';
		this.link = link;
	}
	activate() {
		this.state = 'on';
		stateChanged(this.state);
	}
	deactivate() {
		this.state = 'off';
		stateChanged(this.state);
	}
	setOnStateChangedObserver(observer) {
		this.onStateChangedObserver = observer; 
		
	}
	stateChanged(newState) {
		this.onStateChangedObserver.update(newState);
	}
}
