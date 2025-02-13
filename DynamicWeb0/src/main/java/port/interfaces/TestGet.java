package port.interfaces;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.TestService;
import model.QuestionRepository;
import model.Test;
import model.TestRepository;
import port.persistence.InMemoryQuestionRepository;
import port.persistence.InMemoryTestRepository;

/**
 * Servlet implementation class TestGet
 */
@WebServlet("/TestGet")
public class TestGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TestService testService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestGet() {
        super();
    
        this.testService = createTestService();
        System.out.println("Test servlet created");
    }

	private TestService createTestService() {
		TestRepository testRepo = createTestRepository();
		QuestionRepository questionRepo = createQuestionRepository();
		return new TestService(testRepo, questionRepo);
	}

	private QuestionRepository createQuestionRepository() {
		return InMemoryQuestionRepository.create();
	}

	private TestRepository createTestRepository() {
		TestRepository repo = InMemoryTestRepository.create();
		return repo;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<Test> allTests = testService.getAllTests();
		String jsonData = TestUtils.serialize(allTests);
		response.getWriter().write(jsonData);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
