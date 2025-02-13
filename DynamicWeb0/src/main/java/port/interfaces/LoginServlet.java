package port.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.AuthenticationService;
import application.LoginService;
import application.ServiceFactory;
import model.RegisteredUser;
import model.Roles;
import port.persistence.RegisteredUserDao;
import utils.OutUtils;
import utils.SessionUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AuthenticationService authService;
    
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
       
        this.authService = ServiceFactory.createAuthenticationService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(Pages.home);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		RegisteredUser aUser = this.authService.authenticateUser(username, password);
		if(aUser == null) {
			request.setAttribute("loginError", "No user with username/password ");
			request.getRequestDispatcher(Pages.home).forward(request, response);
		} else {
			OutUtils.out("LoginController: user != null");
			//SessionUtils.setAttribute("ownerId", aUser.getUserId(), request);
			//OutUtils.out("Session attribute ownerId " + (String)SessionUtils.getAttribute("ownerId", request));
			elabLogin(request, response, aUser);

		}
		System.out.println("Username is null " +username==null);
		System.out.println("Username received: " +username);
		System.out.println("Password received: " +password);
		
	}
	
	private void elabLogin(HttpServletRequest request, HttpServletResponse response, RegisteredUser aUser) throws IOException {
		if(hasRole(Roles.educator, aUser)) {
			this.handleEducatorLogin(request, response, aUser);
		} else if(hasRole(Roles.taker, aUser)) {
			this.handleTakerLogin(request, response, aUser);
		}
	}

	private void handleEducatorLogin(HttpServletRequest request, HttpServletResponse response, RegisteredUser aUser) throws IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username", aUser.getFirstname() + " " + aUser.getLastname());
		session.setAttribute("ownerId", aUser.getUserId());
		response.sendRedirect("TestServlet");
	}
	private void handleTakerLogin(HttpServletRequest request, HttpServletResponse response, RegisteredUser aUser) throws IOException {
		System.out.println("handleTakerLogin()");
		HttpSession session = request.getSession();
		session.setAttribute("username", aUser.getFirstname() + " " + aUser.getLastname());
		session.setAttribute("takerId", aUser.getUserId());
		System.out.println("handleTakerLogin - userId " + aUser.getUserId());
		response.sendRedirect("TakerHome");
	}
	private boolean hasRole(String role, RegisteredUser aUser) {
		boolean hasRole = aUser.getRoleId().equals(role);
		return hasRole;
	}
	
	

}
