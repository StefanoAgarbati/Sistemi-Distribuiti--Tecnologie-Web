package port.interfaces;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.GroupMemberService;
import application.ServiceFactory;


/**
 * Servlet implementation class AddMemberToGroup
 */
@WebServlet("/AddMemberToGroup")
public class AddMemberToGroup extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	private GroupMemberService groupMemberService;
   
    public AddMemberToGroup() {
        super();
       this.groupMemberService = ServiceFactory.createGroupMemberService();
    }

	protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String groupId = request.getParameter("groupId");
		String[] members = request.getParameter("members").split("\r\n");
		for(String member : members) {
			String[] fields = member.replace(" ", "").split(",");
			this.groupMemberService.addMemberToGroup(fields[0], fields[1], fields[2], groupId);
		}
		redirectTo(response, "EditGroup?groupId="+groupId);
	}

}
