package port.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.RegistrationCodeService;
import application.ServiceFactory;
import utils.SessionUtils;

/**
 * Servlet implementation class AddMemberRegistrationCode
 */
@WebServlet("/AddMemberRegistrationCode")
public class AddMemberRegistrationCode extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	private RegistrationCodeService registrationCodeService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMemberRegistrationCode() {
        super();
        this.registrationCodeService = ServiceFactory.createRegistrationCodeService();
    }

	@Override
	protected void handleGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	@Override
	protected void handlePost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String groupId = request.getParameter("groupId");
		int numberOfCodesToAdd = Integer.parseInt(request.getParameter("codesToCreate"));
		boolean res = this.registrationCodeService.addMemberRegistrationCodesForGroup(groupId, numberOfCodesToAdd);
		String success = res ? "ok" : "ko";
		System.out.println("Code added success is " + success);
		this.redirectTo(response, "EditGroup?groupId="+groupId+"&codeAdded="+success);
	}


}
