package port.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.GroupService;
import application.ServiceFactory;
import utils.SessionUtils;

/**
 * Servlet implementation class AddNewGroup
 */
@WebServlet("/CreateNewGroup")
public class CreateNewGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GroupService groupService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewGroup() {
        super();
       this.groupService = ServiceFactory.createGroupService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(Pages.createNewGroup).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionUtils.checkSession(request, response, Pages.home);
		String ownerId = SessionUtils.getSessionAttribute("ownerId", request);
		String groupName = request.getParameter("name");
		this.groupService.createNewGroup(groupName, ownerId);
		//request.getRequestDispatcher("Groups").forward(request, response);
		response.sendRedirect("Groups");
	}

}
