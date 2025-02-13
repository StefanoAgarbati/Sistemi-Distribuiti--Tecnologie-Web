package port.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.RegistrationCodes;

/**
 * Servlet implementation class PrintRegistrationCodes
 */
@WebServlet("/PrintRegistrationCodes")
public class PrintRegistrationCodes extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintRegistrationCodes() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void handleGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String groupId = request.getParameter("groupId");
		RegistrationCodes codes = RegistrationCodes.create(groupId);
		request.setAttribute("codes", codes);
		request.getRequestDispatcher(Pages.printCodes).forward(request, response);
	}

	@Override
	protected void handlePost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
