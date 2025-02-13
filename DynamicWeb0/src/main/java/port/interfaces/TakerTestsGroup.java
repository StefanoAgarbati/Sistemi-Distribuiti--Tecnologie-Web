package port.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.TakerTests;

/**
 * Servlet implementation class TakerTestsGroup
 */
@WebServlet("/TakerTestsGroup")
public class TakerTestsGroup extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see BaseServlet#BaseServlet()
     */
    public TakerTestsGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void handleGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String groupId = request.getParameter("groupId");
		TakerTests tests = TakerTests.create(groupId);
		request.setAttribute("tests", tests);
		request.getRequestDispatcher(Pages.takerTestsGroup).forward(request, response);
	}

	@Override
	protected void handlePost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	

}
