package port.interfaces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PossibleResponse;
import model.Question;
import port.persistence.IdGenerator;
import utils.OutUtils;
import utils.SessionUtils;

public class QuestionUtils {

	public static void redirectTo(HttpServletResponse response, String resource) throws IOException {
		response.sendRedirect(resource);
	}

	public static void showQuestion(Question aQuestion) {
		OutUtils.out("{questionId:"+aQuestion.getQuestionId()+",categoryId:"+aQuestion.getCategoryId()
					+",text:"+aQuestion.getText()+",points:"+aQuestion.getPoints()+",ownerId:"+aQuestion.getOwnerId()+"}");
	}
	public static void showResponse(PossibleResponse response) {
		OutUtils.out("{resId:"+response.getResponseId()+",questionId:"+response.getQuestionId()
					+",text:"+response.getText()+",name:"+response.getName()+"}");
	}
	public static Question getQuestion(HttpServletRequest request) {
		String questionId = (request.getParameter("qid") == null) ? (IdGenerator.generateId()) : request.getParameter("questionId") ;
		String categoryId = request.getParameter("categoryId");
		String questionText = request.getParameter("question");
		String ownerId = (String) SessionUtils.getAttribute("ownerId", request);
		float points = Float.parseFloat((String)request.getParameter("points"));
		return Question.create(questionId, questionText, points, ownerId, categoryId);
	}

	public static PossibleResponse getPossibleResponse(HttpServletRequest request, String name, String questionId) {
		String responseText = (String) request.getParameter("answer" + name + "Text");
		boolean isCorrect = ((String) request.getParameter("answer" + name)==null) ? false : true;
		String responseId = request.getParameter("responseId");
		return PossibleResponse.create(IdGenerator.generateId(), questionId, isCorrect,
				responseText, name);
	}

	private List<PossibleResponse> getResponses(HttpServletRequest request, String names[], String questionId) {
		List<PossibleResponse> responses = new ArrayList<>();
		for (String name : names) {
			PossibleResponse possibleResponse = this.getPossibleResponse(request, name, questionId);
			if(!possibleResponse.getText().isEmpty())
				responses.add(possibleResponse);
		}
		return responses;
	}
}
