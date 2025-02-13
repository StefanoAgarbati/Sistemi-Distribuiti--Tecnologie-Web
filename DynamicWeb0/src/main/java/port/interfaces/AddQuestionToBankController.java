package port.interfaces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.QuestionService;
import application.ServiceFactory;
import model.PossibleResponse;
import model.Question;
import port.persistence.IdGenerator;
import utils.OutUtils;
import utils.SessionUtils;
import web.AddQuestionToBank;

/**
 * Servlet implementation class AddQuestionToBank
 */
@WebServlet("/AddQuestionToBank")
public class AddQuestionToBankController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QuestionService questionService;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddQuestionToBankController() {
		super();
		this.questionService = ServiceFactory.createQuestionService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionUtils.checkSession(request, response, Pages.home);
		request.setAttribute("username", (String)SessionUtils.getAttribute("username", request));
		request.setAttribute("addQuestionToBank", new AddQuestionToBank((String)SessionUtils.getAttribute("ownerId", request)));
		request.getRequestDispatcher(Pages.addQuestionToBank).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionUtils.checkSession(request, response, Pages.home);
		//for the question
		Question aQuestion = this.getQuestion(request);
		
		//for answers
		String names[] = {"A","B","C","D","E","F","G","H"};
		List<PossibleResponse> responses = this.getResponses(request, names, aQuestion.getQuestionId());
		
		showQuestion(aQuestion);
		
		responses.forEach(res -> showResponse(res));
		this.questionService.addQuestionToBank(aQuestion, responses);
		
		redirectTo(response, "questions");
	}

	

	private void redirectTo(HttpServletResponse response, String resource) throws IOException {
		response.sendRedirect(resource);
	}

	private void showQuestion(Question aQuestion) {
		OutUtils.out("{questionId:"+aQuestion.getQuestionId()+",categoryId:"+aQuestion.getCategoryId()
					+",text:"+aQuestion.getText()+",points:"+aQuestion.getPoints()+",ownerId:"+aQuestion.getOwnerId()+"}");
	}
	private void showResponse(PossibleResponse response) {
		OutUtils.out("{resId:"+response.getResponseId()+",questionId:"+response.getQuestionId()
					+",text:"+response.getText()+",name:"+response.getName()+"}");
	}
	private Question getQuestion(HttpServletRequest request) {
		String questionId = IdGenerator.generateId();
		String categoryId = request.getParameter("categoryId");
		String questionText = request.getParameter("question");
		String ownerId = (String) SessionUtils.getAttribute("ownerId", request);
		float points = Float.parseFloat((String)request.getParameter("points"));
		return Question.create(questionId, questionText, points, ownerId, categoryId);
	}

	private PossibleResponse getPossibleResponse(HttpServletRequest request, String name, String questionId) {
		String responseText = (String) request.getParameter("answer" + name + "Text");
		boolean isCorrect = ((String) request.getParameter("answer" + name)==null) ? false : true;
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
