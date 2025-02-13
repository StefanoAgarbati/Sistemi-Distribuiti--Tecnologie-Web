package port.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.TakerTest;

/**
 * Servlet implementation class TakerTest
 */
@WebServlet("/TakerTest")
public class TakerTestController extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TakerTestController() {
        super();
    }

	@Override
	protected void handleGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String testId = request.getParameter("testId");
		TakerTest test = TakerTest.create(testId);
		request.setAttribute("test", test);
		request.getRequestDispatcher(Pages.takerTest).forward(request, response);
	}

	@Override
	protected void handlePost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}


}
