package port.interfaces;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.CategoryService;
import application.QuestionService;
import application.ServiceFactory;
import utils.OutUtils;
import utils.SessionUtils;
import web.Categories;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/categories")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CategoryService categoryService;
	private QuestionService questionService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryController() {
		super();
		this.questionService = ServiceFactory.createQuestionService();
		this.categoryService = ServiceFactory.createCategoryService();
		OutUtils.out("CategoryController created");
	}

	private void doForward(String resource, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(resource).forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionUtils.checkSession(request, response, Pages.home);
		Categories categories = Categories.create((String) SessionUtils.getAttribute("ownerId", request));
		request.setAttribute("categories", categories);
		doForward(Pages.categories, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionUtils.checkSession(request, response, Pages.home);

		String command = this.getCommand(request);
		processCommand(command, request, response);
	}

	private String getCommand(HttpServletRequest request) {
		String cmd = (String) request.getParameter("cmd");
		return cmd;
	}

	private void handleChangeCategoryName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String categoryId = (String) request.getParameter("categoryId");
		String newName = (String) request.getParameter("categoryName");

		OutUtils.out("New category name received " + newName);
		boolean isSuccess = this.categoryService.changeCategoryName(categoryId, newName);

		response.sendRedirect("categories");
//		PrintWriter pw = response.getWriter();
//		String msg = "{\"msg\" : " + (isSuccess ? "\"success\"" : "\"nosuccess\"") + "}";
//		pw.print(msg);
	}

	private void handleDeleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isDeleted = this.categoryService.deleteCategory(request.getParameter("catId"));
		request.setAttribute("deleteResult", isDeleted ? "deleteOk" : "deleteKo");
		//forwardTo(request, response, "categories");
	}

	

	private void forwardTo(HttpServletRequest request, HttpServletResponse response, String resource) throws ServletException, IOException {
		request.getRequestDispatcher(resource).forward(request, response);
		
	}

	private void processCommand(String command, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		switch (command) {
		case "new":
			handleNewcategory(request, response);
		case "delete":
			handleDeleteCategory(request, response);
			break;
		case "update":
			handleChangeCategoryName(request, response);
			break;
		}
	}

	private void handleNewcategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryName = (String) request.getParameter("categoryName");
		OutUtils.out("Category name received :" + categoryName);
		boolean res = this.categoryService.addCategory(categoryName,(String) SessionUtils.getAttribute("ownerId", request));
		response.sendRedirect("categories");
	}

}
