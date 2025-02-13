package port.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.SessionUtils;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("")
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String resource = Pages.home;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		checkSession(request, response, resource);
		handleGet(request, response);
	}

	

	protected abstract void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	private void checkSession(HttpServletRequest request, HttpServletResponse response, String aResource) {
		SessionUtils.checkSession(request, response, aResource);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		checkSession(request, response, resource);
		handlePost(request, response);
	}

	protected abstract void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	protected void redirectTo(HttpServletResponse response, String resource) throws IOException {
		response.sendRedirect(resource);
	}
	
	

}
