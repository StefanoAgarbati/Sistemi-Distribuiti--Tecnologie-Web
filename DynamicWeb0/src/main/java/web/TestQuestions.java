package web;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import model.PossibleResponse;
import model.Question;
import model.Test;

public class TestQuestions {

	private String testId;
	private String takerName = "Stefano Agarbati";
	private int totalQuestions = 3;
	private int questionNumber = 1;
	private Collection<Question> questions;
	private Test test;
	
	public Test getTest() {
		return this.test;
	}
	public String getTakerName() {
		return takerName;
	}
	public int questionNumber() {
		return this.questionNumber;
	}
	public int totalNumberOfQuestions() {
		return this.totalQuestions;
	}
	public Collection<Question> getQuestions() {
		Question aQuestion = Question.create("1", "Ma che domanda?", 1, "1", "1");
		return null;
	}
	public Collection<PossibleResponse> getResponses() {
		List<PossibleResponse> responses = new LinkedList<>();
		PossibleResponse rA = PossibleResponse.create("1", "1", false, "Risposta A", "Gino");
		PossibleResponse rB = PossibleResponse.create("2", "1", true, "Risposta B", "Gino");
		PossibleResponse rC = PossibleResponse.create("3", "1", false, "Risposta C", "Gino");
		responses.add(rA);
		responses.add(rB);
		responses.add(rC);
		return responses;
		
	}
	private void init() {
		this.test = Test.create("1", "TestName", "1", "1");
		
	}
	private Collection<Question> initQuestions() {
		List<Question> questions = new LinkedList<>();
		
	}
	
	
}
