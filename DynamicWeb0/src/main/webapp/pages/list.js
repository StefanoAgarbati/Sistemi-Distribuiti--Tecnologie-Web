/**
 * 
 * <button onclick="switchVisibility(this)" class="test-item">Test 1</button>
			<div class="hidden test-details">
				<span>Test 1 details</span>
				<a href="#">
					<span class="test-item-action">Edit</span>
				</a>
			</div>
 */
function createTestItem(data) {
	let btn = document.createElement('button');
	let testDetail = document.createElement('div');
	let testDetailsText = document.createElement('span');
	let editLink = document.createElement('a');
	let editLinkText = document.createElement('span');
	
	
}
class List {
	
	constructor() {
		this.items = [];
	}
	addItem(anItem) {
		items.push(anItem);
	}
}
class ListItem {
	contructor(aDescription, anAction) {
		this.description = sDescription;
		this.action = anAction; 
	}
	getDescription() {
		return this.description;
	}
	getAction() {
		return this.action;
	}
}
class ListItemImpl {
	contructor(listItemModel) {
		this.model = listItemModel;
		init();
	}
	init() {
		let container = document.createElement('div');
		
	}
	
}

