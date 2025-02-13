/**
 * 
 */
class UsedInMsg {
	constructor(rootEl) {
		this.rootEl = rootEl;
	}
}
function showHide(id, elClass, toggleClass) {
	let el = document.getElementById(id);
	let item = el.getElementsByClassName(elClass)[0];
	item.classList.toggle(toggleClass);
}
function showHideTests(id) {
	showHide(id, 'qcard-footer-test', 'hidden');
}
function showHideAnswers(id) {
	showHide(id, 'question-info-answers', 'opened');
}
function showHideDelete(id) {
	showHide(id, 'qcard-footer-delete', 'hidden');
}
function showDelete() {
	let el = document.getElementsByClassName('qcard-footer-delete')[0];
	el.classList.remove('hidden');
}
function hideDelete() {
	let el = document.getElementsByClassName('qcard-footer-delete')[0];
	el.classList.add('hidden');
}
function NoTestMsg(rEl) {
	rEl.innerHTML = "No test defined yet";
}
