/**
 * 
 */
function main() {
	let questionId = 'question-text';
	let formId = 'question-form';
	let answersIds = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'];
	//build question with answers
	let questionModel = makeQuestion(questionId);
	out('makeQuestion called');
	out('questionModel ' + questionModel);
	console.log('questionModel ' + questionModel.getStringRep());
	let answers = makeAnswers(answersIds);
	console.log('Answers ' + answers.length);
	answers.forEach(answer => questionModel.addAnswer(answer));
	answers.forEach(a => console.log(a.getStringRep()));

	//question validator
	let questionValidator = new QuestionValidator(questionModel);

	//outView for validation errors messages
	let outViewImpl = new OutViewImpl();
	let outView = new OutView(outViewImpl);


	let formi = new FormView(formId);

	let controller = new FormController(questionValidator, formi, outView);

}
function showMoreAnswers() {
	let btn = document.querySelector('#addmore');
	let more = document.querySelector('#moreanswers');

	toggleClass(btn, 'hidden');
	toggleClass(more, 'opened');
	toggleClass(more, 'closed');
}
function toggleClass(el, cname) {
	el.classList.toggle(cname);
}

function makeQuestion(id) {
	let question = new Question();
	out('question cons() ' + question.constructor.name);
	let questionView = new QuestionView(id);
	let questionControl = new QuestionControl(question, questionView);
	out('makeQuestion called');
	
	return question;
}
function makeAnswers(ids) {
	let answers = [];

	for (let i = 0; i < ids.length; i++) {
		let answerModel = new Answer(ids[i]);
		let answerView = new AnswerView('answer' + ids[i] + 'Text', 'answer' + ids[i], answerModel);
		answers.push(answerModel);
	}
	return answers;
}
function out(msg) {
	console.log(msg);
}
class OutView {
	constructor(outViewImpl) {
		this.message = "";
		this.outViewImpl = outViewImpl;
	}
	showMsg(aMsg) {
		this.message = aMsg;
		this.update();
	}
	update() {
		this.outViewImpl.showMsg(this.message);
	}
}
class OutViewImpl {
	constructor() {

	}
	showMsg(aMsg) {
		alert(aMsg);
	}
}
class FormView {
	constructor(id) {
		this.onSubmitObserver = null;
		this.formi = document.getElementById(id);
		this.submitButton = document.getElementById('submit-button');

	}
	setOnSubmit(onSubmitObserver) {
		if (this.onSubmitObserver == null) {
			this.onSubmitObserver = onSubmitObserver;
			this.submitButton.addEventListener('click', (e) => {
				e.preventDefault();
				this.onSubmitObserver.onSubmit();
			});
			return;
		}
		console.log('Observer not null');

	}
	submit() {
		this.formi.submit();
	}
}
class FormController {
	constructor(validator, formi, outView) {
		this.validator = validator;
		this.outView = outView;
		this.formi = formi;
		this.formi.setOnSubmit(this);
		//console.log(this.onSubmit + ' FormController onSibmit proto');
	}
	onSubmit() {
		console.log('form onSubmit event');
		console.log('who is this ' + this.info());
		let canSubmit = true;
		let validationResult = this.validator.validate();
		var results = validationResult.getRuleResults();
		this.printResults(results);
		console.log('onSubmit this ' + this.constructor.name);
		for (let i = 0; i < results.length; i++) {
			console.log('aResult ' + results[i].constructor.name);
			if (!results[i].isSatisfied()) {
				canSubmit = false;
				this.showMsg(results[i].getMessage());
				return;
			}
		}
		if (canSubmit) {
			console.log('the form is submitted');
			this.formi.submit();
		}
	}
	printResult(res) {
		console.log('{Rule name: ' + res.getName() + ', isSatisfied: ' + res.isSatisfied() + ' , message: ' + res.getMessage() + '}');
	}
	printResults(results) {
		console.log('validation results on printResults()');
		results.forEach(res => {
			this.printResult(res);
		});
	}
	showMsg(aMsg) {
		this.outView.showMsg(aMsg);
	}
	info() {
		return "I'm FormController " + this.constructor.name;
	}
}

class Rule {
	constructor(name, message) {
		this.name = name;
		this.message = message;
	}
	getName() {
		return this.name;
	}
	getMessage() {
		return this.message;
	}
	setMessage(message) {
		this.message = message;
	}
	validate() {
		return new RuleValidationResult(this.getName(), this.doValidate(), this.message);
	}
	doValidate() {
		throw new Error('abstract method doValidate not implemented');
	}
}
class AtLeastTwoAnswers extends Rule {
	constructor(question, answerAName, answerBName) {
		super('atLeastTwoAnswers', 'You must fill in the first two answer boxes.');
		this.question = question;
		console.log('AtLeast2Answ question ' + this.question);
		this.answerAName = answerAName;
		this.answerBName = answerBName;
		console.log('answerAName ' + this.answerAName);
	}
	doValidate() {
		let answerA = this.question.getAnswer(this.answerAName);
		console.log('answerA ' + answerA);
		let answerB = this.question.getAnswer(this.answerBName);
		return !answerA.isEmpty() && !answerB.isEmpty();
	}
}
class AtLeastOneCorrectAnswer extends Rule {
	constructor(answers) {
		super('atLeastOneCorrectAnswer', 'You must select the correct answer.');
		this.answers = answers;
		console.log("AtLeastOneCorrect cons() answers " + this.answers);
	}
	doValidate() {
		let count = 0;
		this.answers.forEach(answer => {
			console.log('who is answer ' + answer.constructor.name);
			if (answer.isCorrect()) {
				count++;
				console.log('correct answers count ' + count);
			}
		});

		return count != 0;
	}
}
class CorrectAnswerNotEmpty extends Rule {
	constructor(answer) {
		super('correctAnswerNotEmpty' + answer.getName(), 'You have selected ' + answer.getName() + ') as a correct answer, however, you have not added an answer for it.');
		this.answer = answer;
	}
	doValidate() {
		console.log('doValidate in CorrectAnswerNotEmpty for answer ' + this.answer.getName());
		return this.answer.isCorrect() && !this.answer.isEmpty();
	}
}
class CorrectAnswersNotEmpty extends Rule {
	constructor(answers) {
		super('correctAnswersNotEmpty', 'You have selected NAME) as a correct answer, however, you have not added an answer for it.');
		this.answers = answers;
	}
	doValidate() {
		let result = false;
		let corrects = this.answers.filter(answer => answer.isCorrect())
			.filter(correct => correct.isEmpty());
		if (corrects.length != 0) {
			this.setMessage('You have selected ' + corrects[0].getName() + ') as a correct answer, however, you have not added an answer for it.');
			return false;
		}
		return corrects.length == 0;
	}
}
class QuestionNotEmptyRule extends Rule {
	constructor(question) {
		super('questionNotEmpty', 'You have not entered a question.');
		this.question = question;
	}
	doValidate() {
		if (!this.question.isEmpty()) {
			return true;
		}
		return false;
	}
}
class QuestionValidator {
	constructor(question) {
		this.question = question;
		this.validator = new Validator();
		console.log('QuestionValidator answers ' + this.question.getAnswers());
		this.validator.addRule(new QuestionNotEmptyRule(this.question));
		this.validator.addRule(new AtLeastTwoAnswers(this.question, this.question.getAnswers()[0].getName(), this.question.getAnswers()[1].getName()));
		this.validator.addRule(new AtLeastOneCorrectAnswer(this.question.getAnswers()));
		//this.validator.addRule(this.correctAnswerNotEmpty);
		this.validator.addRule(new CorrectAnswersNotEmpty(this.question.getAnswers()));
	}
	validate() {
		console.log('QuestionValidator validate()');
		let answers = this.question.getAnswers();
		this.showAnswers(answers);
		return this.validator.validate();
	}
	showAnswers(answers) {
		answers.forEach(a => this.showAnswer(a));
	}
	showAnswer(answer) {
		let rep = '[name:' + answer.getName() + ',text:' + answer.getText() + ',isCorrect:' + answer.isCorrect() + ']';
		console.log(rep);
	}
}
class Validator {
	constructor() {
		this.rules = [];
	}
	addRule(aRule) {
		console.log('Validator addRule() ' + aRule.getName());
		this.rules.push(aRule);
	}
	validate() {
		var validationResult = new ValidationResult();
		this.rules.forEach(rule => {
			let result = rule.validate();
			validationResult.addRuleValidation(result);
		});
		return validationResult;
	}
}
class RuleValidationResult {
	constructor(ruleName, ruleResult, message) {
		this.name = ruleName;
		this.result = ruleResult;
		this.message = message;
		console.log('RuleValidationResult cons() ' + this.name);
	}
	getName() {
		return this.name;
	}
	isSatisfied() {
		return this.result;
	}
	getMessage() {
		return this.message;
	}

}
class ValidationResult {
	constructor() {
		this.rulesValidationResult = [];
	}

	addRuleValidation(aRuleValidationResult) {
		console.log('ValidationResult addRuleValidation() ');
		this.rulesValidationResult.push(aRuleValidationResult);
	}
	getRuleResults() {
		return this.rulesValidationResult;
	}
}

class QuestionView {
	constructor(id) {
		this.el = document.getElementById(id);
		this.observer = null;
		out('questionView created');
	}
	registerObserver(observer) {
		this.observer = observer;
		this.el.addEventListener('input', (e) => {
			e.preventDefault();
			this.observer.onTextChange(this.el.value);
		});
		out('QuestionView observer registered');
		this.observer.onTextChange(this.el.value);
		out('QuestionView onTextChange ' + this.el.value);
	}
}
class QuestionControl {
	constructor(model, view) {
		this.model = model;
		this.view = view;
		this.view.registerObserver(this);
		out('QuestionController created');
		
	}
	onTextChange(text) {
		console.log('QuestionController onTextChange ' + text);
		this.model.setText(text);
	}
}
class Question {
	constructor() {
		this.text = '';
		this.answers = [];
		out('Question created');
	}
	setText(text) {
		console.log('setting text ' + text);
		this.text = text;
	}
	setAnswers(answers) {
		this.answers = answers;
	}
	getText() {
		return this.text;
	}
	isEmpty() {
		return this.text === '';
	}
	addAnswer(anAnswer) {
		this.answers.push(anAnswer);
	}
	getAnswer(answerName) {
		return this.answers.find(function(value, index, array) {
			return value.getId() == answerName;
		});
	}
	getAnswers() {
		return this.answers;
	}
	getStringRep() {
		let rep = '{text:' + this.text + '}';
		return rep;
	}

}
class AnswerView {
	constructor(textId, isCorrectId, model) {
		this.model = model;
		this.text = document.getElementById(textId);
		this.isCorrect = document.getElementById(isCorrectId);
		this.text.addEventListener('input', (e) => {
			e.preventDefault();
			this.onTextChanged(this.text.value);
		});
		this.isCorrect.addEventListener('input', (e) => {
			e.preventDefault();
			this.onCorrectChanged(this.isCorrect.checked);
		});
		this.onCorrectChanged(this.getCorrect());
		this.onTextChanged(this.getText());
	}

	setText(aText) {
		this.text.value = aText;
	}
	getText() {
		return this.text.value;
	}
	setCorrect(val) {
		this.isCorrect.checked = val;
	}
	getCorrect() {
		return this.isCorrect.checked;
	}
	onTextChanged(aText) {
		console.log('AnswerView onTextChanged ' + aText);
		this.model.setText(aText);
	}
	onCorrectChanged(isCorrect) {
		console.log('AnswerView onCorrectChanged ' + isCorrect);
		this.model.setCorrect(isCorrect);
	}
}
class Answer {
	constructor(id) {
		this.id = id
		this.text = '';
		this.correct = false;
	}
	setText(text) {
		console.log('AnswerModel' + this.id + ' setText ' + text);
		this.text = text;
	}
	getText() {
		return this.text;
	}
	getId() {
		return this.id;
	}
	getName() {
		return this.id;
	}
	isCorrect() {
		return this.correct;
	}
	setCorrect(isCorrect) {
		console.log('AnswerModel setCorrect ' + this.id + ') ' + isCorrect);
		this.correct = isCorrect;
	}
	isEmpty() {
		return this.text === '';
	}
	getStringRep() {
		let rep = '{id:' + this.id + ',text:' + this.text + ',isCorrect:' + this.correct + '}';
		return rep;
	}
}
main();