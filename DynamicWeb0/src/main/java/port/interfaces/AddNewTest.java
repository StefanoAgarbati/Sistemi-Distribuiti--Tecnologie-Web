package port.interfaces;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.CategoryService;

import application.ServiceFactory;
import application.TestService;
import utils.OutUtils;
import utils.SessionUtils;
import web.NewTest;

/**
 * Servlet implementation class AddNewTest
 */
@WebServlet("/addNewTest")
public class AddNewTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryService categoryService;
    private TestService testService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewTest() {
        super();
        this.testService = ServiceFactory.createTestService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionUtils.checkSession(request, response, Pages.home);
		String ownerId = (String)SessionUtils.getAttribute("ownerId", request);
		NewTest newTest = new NewTest(ownerId);
		OutUtils.out("Categories : " + newTest.getCategories());
		request.setAttribute("newTest", newTest);
		this.forward(request,response,"pages/new.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionUtils.checkSession(request, response, Pages.home);
		//processCmd(getCommand(request));
		String ownerId = (String) SessionUtils.getAttribute("ownerId",request);
		String testName = request.getParameter("testName");
		String testCategoryId = request.getParameter("category");
		testService.addNewTest(testName, testCategoryId, ownerId);
		this.forward(request, response, "/TestServlet");
	}
	
	private String getCommand(HttpServletRequest request) {
		return request.getParameter("cmd");
	}

	private void processCmd(String cmd) {
		
	}

	private void createNewTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = (String) SessionUtils.getAttribute("userId",request);
		String testName = request.getParameter("testName");
		String testCategoryId = request.getParameter("categories");
		testService.addNewTest(testName, userId, testCategoryId);
		this.forward(request, response,"/test.jsp");
	}
	private void forward(HttpServletRequest req, HttpServletResponse res, String uri) throws ServletException, IOException {
		req.getRequestDispatcher(uri).forward(req, res);
		
	}

}
