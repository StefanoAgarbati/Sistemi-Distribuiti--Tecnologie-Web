package port.interfaces;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.RegistrationData;
import application.RegistrationService;
import port.persistence.IRegisteredUserDao;
import port.persistence.RegisteredUserDao;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationApi")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RegistrationService registrationService;
	private IRegisteredUserDao registeredUserDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        this.registeredUserDao = new RegisteredUserDao();
        this.registrationService = new RegistrationService(this.registeredUserDao);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RegistrationDataReader reader = RegistrationDataReader.create(request.getParameter("registrationData"));
		RegistrationData data = getRegistrationDataFrom(request);
		boolean registrationResult = registrationService.registerUser(data);
		String responseMsg = elabRegistrationResult(registrationResult);
		PrintWriter writer = response.getWriter();
		writer.println(responseMsg);
	}

	
	private RegistrationData getRegistrationDataFrom(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String role = req.getParameter("role");
		
		RegistrationData registrationData = RegistrationData.create(username, password, firstname, lastname, role);
		
		return registrationData;
	}
	private String elabRegistrationResult(boolean registrationResult) {
		if(registrationResult)
			return elabRegistrationSuccess();
		return elabRegistrationFailed();
	}

	private String elabRegistrationFailed() {
		String successMsg = "{result : RESULT}";
		successMsg=successMsg.replace("RESULT", "registrationKo");
		return successMsg;
	}

	private String elabRegistrationSuccess() {
		String successMsg = "{result : RESULT}";
		successMsg=successMsg.replace("RESULT", "registrationOk");
		return successMsg;
	}
	
	
	
}
