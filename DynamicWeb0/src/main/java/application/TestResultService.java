package application;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.PossibleResponse;
import model.Question;
import model.TestResult;
import port.persistence.ITestResultDao;
import port.persistence.IdGenerator;
import utils.CollectionsUtils;

public class TestResultService {

	private QuestionService questionService;
	private ITestResultDao testResultDao;
	
	public TestResultService(ITestResultDao testResultDao, QuestionService questionService) {
		this.questionService = questionService;
		this.testResultDao = testResultDao;
	}
	public void addTestResult(String takerId, String testId, String duration, String date, Map<String, List<String>> questionsWithResponses) {
		float totalPoints = this.questionService.getTotalPointsForTest(testId);
		float points = this.getGainedPoints(questionsWithResponses);
		TestResult testResult = TestResult.create(IdGenerator.generateId(), takerId, testId, date, 
				duration, points, totalPoints);
		this.testResultDao.createTestResult(testResult);
	}
	private float getTotalPointsForTest(String testId) {
		return this.questionService.getTotalPointsForTest(testId);
		
	}
	private float getGainedPoints(Map<String,List<String>> questions) {
		float total = 0;
		Set<String> questionsIds = questions.keySet();
		for(String questionId: questionsIds) {
			List<String> responsesIds = questions.get(questionId);
			total += getPointsForQuestion(questionId, responsesIds);
		}
		System.out.println("Total gained points " + total);
		return total;
	}
	private float getPointsForQuestion(String questionId, List<String> selected) {
		
		Collection<PossibleResponse> responses = getResponsesForQuestion(questionId);
		Question aQuestion = getQuestion(questionId);
		
		if(selected.size() == 0)
			return 0;
		PossibleResponse correctResponse = CollectionsUtils.filterOne(responses, r -> r.isCorrect());
		String selectedId = selected.get(0);
		if(correctResponse.getResponseId().equals(selectedId))
			return aQuestion.getPoints();
		return 0;
//		float totalPoints = responses.size();
//		float gainedPoints = 0;
//		for(PossibleResponse response : responses) {
//			String selectedId = CollectionsUtils.filterOne(selected, r -> r.equals(response.getResponseId()));
//			if((selectedId == null && !response.isCorrect()) ||
//					(selectedId != null && response.isCorrect()))
//				gainedPoints++;
//			System.out.println("Points gained iteration " + gainedPoints);
//		}
//		float pointsForQuestion = (gainedPoints / totalPoints) *  aQuestion.getPoints();
//		System.out.println("Points for question " + questionId + " " + pointsForQuestion);
//		return pointsForQuestion;
	}
	
	private Question getQuestion(String questionId) {
		return questionService.getQuestionById(questionId);
	}

	private Collection<PossibleResponse> getResponsesForQuestion(String questionId) {
		return this.questionService.getResponsesForQuestion(questionId);
	}
}
