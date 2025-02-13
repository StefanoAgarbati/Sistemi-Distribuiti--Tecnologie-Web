/**
 * 
 */
/*let button = document.getElementById('new-test-button');
button.addEventListener('click', function() {
	addNewTest();
});

function addNewTest() {
	
}*/
function Validator() {
	
	const validate = (valImpl) => {
		return valImpl();
	}
	return {
		validate
	}
}
function validateUsername(username) {
	return minLength(username, 6);
}
function validateFirstname(firstname) {
	return notEmpty(firstname)
}
function validateLastname(lastname) {
	return notEmpty(lastname);
}
function validatePassword(password) {
	return {
		oneNumber : containsAtLeastOneNumber(password),
		oneLower : containsAtLeastOneLower(password),
		oneUpper : containsAtLeastOneUpper(password),
		minLength : minLength(password, 8),
		oneSpecial : containsAtLeastOneSpecial(password),
		isValid : function() {
			return this.oneNumber&&this.oneLower&&this.oneUpper&&this.minLength&&this.oneSpecial
		}
	};
}
function containsAtLeastOneNumber(password) {
	let pattern = /[0-9]/;
	return pattern.test(password);
	
}
function containsAtLeastOneUpper(password) {
	let pattern = /[A-Z]/;
	return pattern.test(password);
}
function containsAtLeastOneLower(password) {
	let pattern = /[a-z]/;
	return pattern.test(password);
}
function containsAtLeastOneSpecial(password) {
	let pattern = /[!$%&?{#@*}()\[\]^°=£|]/;
	return pattern.test(password);
}
function minLength(data, minLength) {
	return data.length >= minLength;
}
function notEmpty(value) {
	return value.length > 0;
}
class RegistrationFormImpl {
	constructor(formId) {
		this.formEl = document.getElementById(formId);
	}
	getUsername() {
		return this.formEl['username'].value;
	}
	getPassword() {
		return this.formEl['password'].value;
	}
	getFirstname() {
		return this.formEl['firstname'].value;
	}
	getLastname() {
		return this.formEl['lastname'].value;
	}
	getRole() {
		return this.formEl['role'].value;
	}
}
function submitRegistrationData() {
	console.log('form submit');
	
	let formi = document.getElementById('registration-form');
	let firstname = document.getElementById('firstname').value;
	let lastname = document.getElementById('lastname').value;
	let username = document.getElementById('username').value;
	let password = document.getElementById('password').value;
	let out = document.getElementById('error-msg');
	let validationResult = validateFormData(firstname, lastname, username, password);
	
	if(!validationResult.isFirstnameValid) {
		showOutput(out, 'Firstname empty. Enter a firstname');
		return;
	}
	if(!validationResult.isLastnameValid) {
		showOutput(out, 'Lastname empty. Enter a lasttname');
		return;
	}
	if(!validationResult.isUsernameValid) {
		showOutput(out, 'Username not valid');
		return;
	}
	if(!validationResult.isPasswordValid.isValid()) {
		console.log('password isValid ' + validationResult.isPasswordValid.isValid());
		let result = validationResult.isPasswordValid;
		let msg = 'Invalid password. ';
		if(!result.minLength) {
			console.log('minLength ' + result.minLength);
			msg += 'The password should contain at least 8 symbols';
		} else if(!result.oneNumber) {
			msg = msg + 'The password should contain at least one number'
		} else if(!result.oneLower) {
			msg += 'The password should contain at least one lowercase letter';
		} else if(!result.oneUpper) {
			msg += 'The password should contain at least one uppercase letter';
		} else if(!result.oneSpecial) {
			msg += 'The password should contain at least one special character';
		}
		showOutput(out, msg);
		return;
	}
	formi.submit();
	console.log('form submitted with success');
}
function showOutput(out, msg) {
	out.classList.remove('hidden');
	console.log(msg);
	out.firstElementChild.innerHTML = msg;
}
function validateFormData(firstname, lastname, username, password) {
	console.log('validate form data');
	return {
		isFirstnameValid : validateFirstname(firstname),
		isLastnameValid : validateLastname(lastname),
		isUsernameValid : validateUsername(username),
		isPasswordValid : validatePassword(password)
	}
}
function sendRegistrationData(data) {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
		}
	}
	xhr.on
	xhr.open('post', 'RegistrationApi');
	xhr.send(data);
}
function getFormData() {
	let regForm = document.getElementById(formId);
}
function RegistrationData(username,password,firstname,lastname) {
	this.username=username;
	this.password = password;
	this.firstname = firstname;
	this.lastname = lastname;
	
	this.getUsername = function() {
		return this.username;
	}
	this.getFirstname = function() {
		return this.firstname;
	}
	this.getLastname = function() {
		return this.lastname;
	}
	this.getPassword = function() {
		return this.password;
	}
	this.validate = function() {
		
	}
}
class RegistrationForm {
	constructor(username, password, firstname, lastname, role) {
		this.role = role;
		this.username=username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	validateData() {
		return {
			validUsername: validateUsername(),
			validPassword: validatePassword(),
			validFirstname: validateFirstname(),
			validLastname: validateLastname(),
			validRole: validateRole()
		}
	}
	validateUsername() {
		return this.username !== "";
	}
	validatePassword() {
		let minLength = this.password.length >= 4;
		let numberRule = this.password.search("/[0-9]/");
		let isValid = minLenght && numberRule && specialRule && upperRule; 
	}
	validateFirstname() {
		return this.firstname !== "";
	}
	validateLastname() {
		return this.lastname !== "";
	}
	validateRole() {
		return this.role === "educator" || this.role === "taker";
	}
}
class RegistrationFormValidator {
	constructor(aRegistrationForm) {
		this.regForm = aRegistrationForm;
	}	
	validate() {
		validateUsername();
		validatePassword();
		validateFirstname();
		validateLastname();
		validateRole();
	}
	validateUsername() {
		return this.regForm.getUsername().length >= 6;
	}
}

