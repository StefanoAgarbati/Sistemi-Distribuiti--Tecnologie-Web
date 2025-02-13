package port.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.SessionUtils;
import web.TakerHome;

/**
 * Servlet implementation class TakerHome
 */
@WebServlet("/TakerHome")
public class TakerHomeController extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TakerHomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void handleGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = SessionUtils.getSessionAttribute("takerId", request);
		System.out.println("TakerHomeController userId " + userId);
		TakerHome taker = new TakerHome(userId);
		request.setAttribute("taker", taker);
		request.getRequestDispatcher(Pages.takerHome).forward(request, response);
	}

	@Override
	protected void handlePost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
