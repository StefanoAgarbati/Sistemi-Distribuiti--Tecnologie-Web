/**
 * 
 */
class Validator {
	constructor() {
		this.rules = [];
		this.validationResult = new ValidationResult();
	}
	addRule(aRule) {
		this.rules.push(aRule);
	}
	validate() {
		rules.forEach(rule => {
			let result = rule.validate();
			this.validationResult.addRuleValidation(result);
		});
		return this.validationResult;
	}
}
class RuleValidationResult {
	constructor(ruleName, ruleResult) {
		this.name = ruleName;
		this.result = ruleResult;
	}
	getName() {
		return this.name;
	}
	isSatisfied() {
		return ruleResult;
	}

}
class ValidationResult {
	constructor() {
		this.rulesValidationResult = [];
	}

	addRuleValidation(aRuleValidationResult) {
		this.rulesValidationResult.push(aRuleValidationResult);
	}
	getRuleResults() {
		return rulesValidationResult;
	}
}
class Rule {
	constructor(name) {
		this.name = name;
	}
	getName() {
		return this.name;
	}
	validate() {
		return new RuleValidationResult(this.getName(), doValidate());
	}
	doValidate() {
		throw new Error('abstract method doValidate not implemented');
	}
}