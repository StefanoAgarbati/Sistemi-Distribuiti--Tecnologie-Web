package port.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.SessionUtils;
import web.EditGroup;

/**
 * Servlet implementation class EditGroup
 */
@WebServlet("/EditGroup")
public class EditGroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGroupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionUtils.checkSession(request, response, Pages.home);
		String groupId = request.getParameter("groupId");
		String codeAdded = request.getParameter("codeAdded");
		System.out.println("CodeAdded is " + codeAdded);
		EditGroup edit = EditGroup.create(groupId);
		request.setAttribute("edit", edit);
		request.getRequestDispatcher(Pages.editGroup).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
