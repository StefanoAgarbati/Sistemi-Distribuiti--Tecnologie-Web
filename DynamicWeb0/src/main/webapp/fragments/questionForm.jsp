<div class="answers-container">
	<form class="answer-form" method="post" action="">
		<div>
			<h5 class="section-heading">Enter your question</h5>
			<textarea id="question-text" name="question" rows="6" cols="67"></textarea>
		</div>
		<div class="answers">
			<div>
				<h5 class="section-heading">Answers</h5>
			</div>
			<div class="answer">
				<div class="answer-top">
					<h5>(A)</h5>
					<input id="answerA" type="checkbox" name="answerA" value="correctA" />
					<label for="answerA">This answer option is correct</label>
				</div>
				<textarea id="answerAText" name="question" rows="3" cols="67"></textarea>
			</div>
			<div class="answer">
				<div class="answer-top">
					<h5>(B)</h5>
					<input class="isCorrect" id="answerB" type="checkbox"
						name="answerB" value="correctB" /> <label for="answerB">This
						answer option is correct</label>
				</div>
				<textarea id="answerBText" name="question" rows="3" cols="67"></textarea>
			</div>
			<div class="answer">
				<div class="answer-top">
					<h5>(C)</h5>
					<input id="answerC" type="checkbox" name="answerC" value="correctC" />
					<label for="answerC">This answer option is correct</label>
				</div>
				<textarea id="answerCText" name="question" rows="3" cols="67"></textarea>
			</div>
			<div class="answer">
				<div class="answer-top">
					<h5>(D)</h5>
					<input id="answerD" type="checkbox" name="answerD" value="correctD" />
					<label for="answerD">This answer option is correct</label>
				</div>
				<textarea id="answerDText" name="question" rows="3" cols="67"></textarea>
			</div>
			<div id="addmore" class="rounded-box" onclick="showMoreAnswers()">
				<span>Add more answer option</span>
			</div>
			<div id="moreanswers" class="more-answers closed">
				<div class="answer">
					<div class="answer-top">
						<h5>(E)</h5>
						<input id="answerE" type="checkbox" name="answerE"
							value="correctE" /> <label for="answerE">This answer
							option is correct</label>
					</div>
					<textarea id="answerEText" name="question" rows="3" cols="67"></textarea>
				</div>
				<div class="answer">
					<div class="answer-top">
						<h5>(F)</h5>
						<input id="answerF" type="checkbox" name="answerF"
							value="correctF" /> <label for="answerF">This answer
							option is correct</label>
					</div>
					<textarea id="answerFText" name="question" rows="3" cols="67"></textarea>
				</div>
				<div class="answer">
					<div class="answer-top">
						<h5>(G)</h5>
						<input id="answerG" type="checkbox" name="answerG"
							value="correctG" /> <label for="answerG">This answer
							option is correct</label>
					</div>
					<textarea id="answerGText" name="question" rows="3" cols="67"></textarea>
				</div>
				<div class="answer">
					<div class="answer-top">
						<h5>(H)</h5>
						<input id="answerH" type="checkbox" name="answerH"
							value="correctH" /> <label for="answerH">This answer
							option is correct</label>
					</div>
					<textarea id="answerHText" name="question" rows="3" cols="67"></textarea>
				</div>
			</div>
		</div>
		<div class="settings">
			<h5 class="section-heading">Settings</h5>
			<div class="settings-content">
				<div>
					<h5 class="section-heading">Points available</h5>
					<input class="input" type="text" name="points" value="1"
						maxlength="5" size="5" />
				</div>
				<div class="hline"></div>
				<div>
					<h5 class="section-heading">Randomize answers</h5>
					<input type="radio" checked="true" name="rand" value="no">
					<label>No</label>
					<div class="empty-row"></div>
					<input type="radio" name="rand" value="yes" /> <label>Yes</label>
				</div>
				<div class="hline"></div>
				<div>
					<h5 class="section-heading">Answer selection</h5>
					<input type="radio" checked="true" name="selection" value="single">
					<label>Single answer <span>- only one answer option
							can be selected</span></label>
					<div class="empty-row"></div>
					<input type="radio" name="selection" value="multi" /> <label>Multiple
						answers <span>- multiple answer option can be selected</span>
					</label>
				</div>
			</div>
		</div>
		<div class="add-question-btn">
			<button class="button button-orange" type="button" name="save"
				value="saveQuestion" onclick="onSave()">Save</button>
			<button class="button button-white" onclick="onCancel()">Cancel</button>
		</div>
		<div class="errormsg closed">
			<p class="error-text">You have not entered a question</p>
		</div>
		<div class="errormsg closed">
			<p class="error-text">You must select the correct answer</p>
		</div>
		<div class="errormsg closed">
			<p class="error-text">You must fill the first two boxes</p>
		</div>
	</form>
</div>