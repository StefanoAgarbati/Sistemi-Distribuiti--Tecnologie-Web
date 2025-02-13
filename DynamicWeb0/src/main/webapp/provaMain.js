/**
 * 
 */
import {HeaderComponent} from "./pages/addQuestionToBank.js";

function app() {
	let container = document.getElementById('header-container');
	let headerComponent = new HeaderComponent('Dandino');
	container.innerHTML = headerComponent.render();
}
app();