package port.interfaces;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.MTestService;
import application.ServiceFactory;
import application.TestService;
import model.Category;
import model.QuestionRepository;
import model.Test;
import model.TestRepository;
import port.persistence.InMemoryQuestionRepository;
import port.persistence.InMemoryTestRepository;
import utils.SessionUtils;
import web.Tests;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TestService testService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		this.testService = ServiceFactory.createTestService();
		System.out.println("Test servlet created");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionUtils.checkSession(request, response, Pages.home);
		String userId = (String) SessionUtils.getAttribute("ownerId", request); // if null the user is not authenticated
																				// or the session is expired
		Tests tests = Tests.create(userId);
		request.setAttribute("tests", tests);
		request.getRequestDispatcher(Pages.tests).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
