package port.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.CategoryService;
import application.ServiceFactory;
import port.persistence.CategoryDao;
import utils.OutUtils;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/addCategory")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CategoryService categoryService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategory() {
        super();
        this.categoryService = ServiceFactory.createCategoryService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(Pages.home);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.checkSession(request, response);
		String ownerId = this.getSessionAttribute(request, "ownerId");
		String categoryName = (String) request.getParameter("categoryName");
		OutUtils.out("AddCategory categoryName : " + categoryName);
		boolean res = this.categoryService.addCategory(categoryName, ownerId);
		request.setAttribute("result", res ? "ok" : "ko");
		//this.forward(request, response, Pages.addNewTest);
		this.redirectTo(Pages.addNewTest, response);
		
	}
	
	private <T> T getSessionAttribute(HttpServletRequest request, String name) {
		return (T) request.getSession().getAttribute(name);
		
	}
	private void checkSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if(session == null)
			forward(request, response, "Home");
	}

	private void redirectTo(String resource, HttpServletResponse response) throws IOException {
		response.sendRedirect(resource);
	}
	private void forward(HttpServletRequest request, HttpServletResponse response, String page) {
		try {
			request.getRequestDispatcher(page).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
