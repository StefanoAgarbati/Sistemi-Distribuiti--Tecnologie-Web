package port.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.QuestionService;
import application.ServiceFactory;
import utils.OutUtils;

/**
 * Servlet implementation class RemoveQuestion
 */
@WebServlet("/RemoveQuestion")
public class RemoveQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private QuestionService questionService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveQuestion() {
        super();
       this.questionService = ServiceFactory.createQuestionService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String removeFrom = request.getParameter("from");
		this.handleRemove(removeFrom, request);
		String testId = request.getParameter("tid");
		this.redirectTo(this.getReturnResource(removeFrom, testId), response);
	}
	private void redirectTo(String returnResource, HttpServletResponse response) throws IOException {
		response.sendRedirect(returnResource);
	}

	private String getReturnResource(String from, String testId) {
		switch(from) {
		case "test":
			return "EditTest?tid="+testId;
		case "bank":
			return "questions";
		}
		return Pages.home;
	}
	private void handleRemove(String from, HttpServletRequest request) {
		if(from.equals("test"))
			handleRemoveFromTest(request);
		else if(from.equals("bank"))
			handleRemoveFromBank(request);
	}
	private void handleRemoveFromBank(HttpServletRequest request) {
		String questionId = request.getParameter("qid");
		removeQuestionFromBank(questionId);
	}

	private void handleRemoveFromTest(HttpServletRequest request) {
		String testId = request.getParameter("tid");
		String questionId = request.getParameter("qid");
		removeQuestionFromTest(testId, questionId);
	}

	private void removeQuestionFromTest(String testId, String questionId) {
		this.questionService.deleteQuestionFromTest(testId, questionId);
	}
	private void removeQuestionFromBank(String questionId) {
		this.questionService.deleteQuestionFromBank(questionId);
	}

}
