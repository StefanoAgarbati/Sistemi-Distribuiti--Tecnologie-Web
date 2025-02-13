/**
 * 
 */
var config = {
	questionTextId: 'question-text',
	answers: [
		{textId: 'answerAText', isCorrectId: 'isCorrectA'}
	]
};
function questionForm() {
	let questionText = document.getElementById(config.questionTextId);
	let answers = [];
	
	
}
class Question {
	constructor(parentId) {
		let parent = document.getElemenById('parentId');
		parent.innerHTML = '<h5 class="section-heading">Enter your question</h5>' +
						   '<textarea id="question-text" name="question" rows="6" cols="67"></textarea>';
	}
}
