package port.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.AssignmentService;
import application.ServiceFactory;
import utils.SessionUtils;
import web.AssignTest;

/**
 * Servlet implementation class AssignTestToGroup
 */
@WebServlet("/AssignTestToGroup")
public class AssignTestToGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AssignmentService assignmentService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AssignTestToGroup() {
		super();
		this.assignmentService = ServiceFactory.createAssignmentService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		SessionUtils.checkSession(request, response, Pages.home);
//		String ownerId = SessionUtils.getSessionAttribute("ownerId", request);
//		String groupId = request.getParameter("groupId");
// 		AssignTest assignTest = AssignTest.create(ownerId, groupId);
// 		request.setAttribute("assign", assignTest);
// 		request.getRequestDispatcher(Pages.assignTestToGroup).forward(request, response);
		checkSession(request, response);
		String testId = request.getParameter("testId");
		String groupId = request.getParameter("groupId");
		boolean isAssigned = this.assignTestToGroup(testId, groupId);
		if(isAssigned) {
			redirectTo("AssignSuccess"+"?testId="+testId+"&groupId="+groupId, response);
		}
	}

	private void redirectTo(String resource, HttpServletResponse response) throws IOException {
		response.sendRedirect(resource);
	}

	private boolean assignTestToGroup(String testId, String groupId) {
		boolean isAssigned = this.assignmentService.assignTestToGroup(testId, groupId);
		return isAssigned;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

	}

	private void checkSession(HttpServletRequest request, HttpServletResponse response) {
		SessionUtils.checkSession(request, response, Pages.home);
	}

}
