function Answer(id) {
	let name = id;
	let isCorrect = false;
	let text = '';
	
	function setText(aText) {
		text = aText;
	}
	function getText() {
		return text;
	}
	function setCorrect(val ){
		isCorrect = val;
	}
	function getCorrect() {
		return isCorrect;
	}
	function getId() {
		return name;
	}
}
let answerTemplate = document.createElement('template');

class AnwerImpl extends HTMLElement {
	
	constructor() {
		
	}
	connectedCallback() {
		
	}
	
	
}
	