package port.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestAjax
 */
@WebServlet("/testAjax")
public class TestAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String catId = (String) request.getAttribute("catId");
//		String catName = (String) request.getAttribute("catName");
//		response.getOutputStream().println("{\"method\": \"get\", \"catId\" : \""+catId+"\", \"catName\" : \""+catName+"\"}");
		this.handleRequest(request, response, "get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		handleRequest(request, response, "post");
	}

	private void handleRequest(HttpServletRequest request, HttpServletResponse response, String method) throws IOException {
		System.out.println("Received request with method " + method);;
		String catId = (String) request.getParameter("catId");
		String catName = (String) request.getParameter("catName");
		System.out.println("Params: catId="+catId+" catName="+catName);
		
		response.getOutputStream().println("{\"method\": \""+method+"\", \"catId\" : \""+catId+"\", \"catName\" : \""+catName+"\"}");
	}
	

}
