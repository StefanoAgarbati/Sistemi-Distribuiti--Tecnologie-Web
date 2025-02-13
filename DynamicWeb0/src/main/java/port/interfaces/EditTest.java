package port.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.SessionUtils;
import web.Edit;

/**
 * Servlet implementation class EditTest
 */
@WebServlet("/EditTest")
public class EditTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionUtils.checkSession(request, response, Pages.home);
		String ownerId = (String)SessionUtils.getAttribute("ownerId", request);
		String testId = (String)request.getParameter("tid");
		Edit edit = new Edit(ownerId, testId);
		request.setAttribute("edit", edit);
		request.getRequestDispatcher(Pages.edit).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
