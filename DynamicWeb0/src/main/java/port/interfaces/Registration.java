package port.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.GroupMemberService;
import application.RegistrationService;
import application.ServiceFactory;
import model.RegisteredUser;
import model.Role;
import model.Roles;
import port.persistence.DaoFactory;
import port.persistence.IRegisteredUserDao;
import port.persistence.RegisteredUserDao;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RegistrationService registrationService;
    private GroupMemberService memberService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        registrationService = ServiceFactory.createRegistrationService();
        this.memberService = ServiceFactory.createGroupMemberService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role = request.getParameter("role");
		
		request.getRequestDispatcher(getPage(role)).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String code = request.getParameter("code");
		
		boolean registrationResult = registerUser(role, username, password, firstname, lastname, code);
		
		request.setAttribute("registrationResult", registrationResult ? "ok" : "ko");
		
		System.out.println("Registration result: " + request.getAttribute("registrationResult"));
		
		request.getRequestDispatcher(getPage(role)).forward(request, response);
		
	}
	private boolean registerTaker(String username, String password, String firstname, String lastname, String code) {
		boolean registrationResult = registrationService.registerNewUser(Roles.taker, username, password, firstname, lastname);
		addTakerToGroup(username,code);
		return registrationResult;
	}
	private void addTakerToGroup(String userId, String code) {
		this.memberService.addMemberToGroupByCode(userId, code);
	}

	private boolean registerEducator(String username, String password, String firstname, String lastname) {
		boolean registrationResult = registrationService.registerNewUser(Roles.educator, username, password, firstname, lastname);
		return registrationResult;
	}
	private boolean registerUser(String role, String username, String password, String firstname, String lastname, String code) {
		boolean result = registrationService.registerNewUser(role, username, password, firstname, lastname);
		if(role.equals(Roles.taker)) {
			RegisteredUser user = this.registrationService.getUserByUsername(username);
			this.memberService.addMemberToGroupByCode(user.getUserId(), code);
		}
		return result;
	}
	private String getPage(String role) {
		String page = "";
		if(role.equals(Role.educator)) {
			page = Pages.educatorRegistration;
		} else if(role.equals(Role.taker)) {
			page = Pages.takerRegistration;
		}
		return page;
	}

}
