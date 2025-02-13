package port.interfaces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.QuestionService;
import application.ServiceFactory;
import application.TestResultService;
import model.PossibleResponse;
import model.Question;
import utils.CollectionsUtils;
import utils.DateUtils;
import utils.OutUtils;
import utils.SessionUtils;

/**
 * Servlet implementation class CompleteTest
 */
@WebServlet("/CompleteTest")
public class CompleteTest extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private TestResultService testResultService;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompleteTest() {
		super();
		this.testResultService = ServiceFactory.createTestResultService();
	}

	@Override
	protected void handleGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void handlePost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String takerId = SessionUtils.getSessionAttribute("takerId", request);
		String testId = request.getParameter("testId");
		String duration = request.getParameter("duration");
		String date = DateUtils.getDateRep();
		Map<String, List<String>> questionsWithSelectedResponses = this.getQuestionsWithSelectedResponses(request.getParameterMap());
		this.testResultService.addTestResult(takerId, testId, duration, date, questionsWithSelectedResponses);
		response.sendRedirect(Pages.takerTestsGroup);
	}
	

	private Map<String, List<String>> getQuestionsWithSelectedResponses(Map<String, String[]> params) {
		List<String> questionsKeys = this.questionsIds(params);

		Map<String, List<String>> questionsWithSelectedResponses = new HashMap<>();
		int i = 0;
		for (String qid : questionsKeys) {
			i++;
			questionsWithSelectedResponses.put(qid, this.responsesIds(params, "q" + i));
		}
		return questionsWithSelectedResponses;
	}

	private List<String> extractIds(Map<String, String[]> map, String startWith) {
		List<String> ids = new ArrayList<>();
		Set<String> keys = map.keySet();
		keys.forEach(key -> {
			if (key.startsWith(startWith)) {
				String[] values = map.get(key);
				for (String value : values) {
					ids.add(value);
				}
			}

		});
		return ids;
	}

	private List<String> responsesIds(Map<String, String[]> map, String qid) {
		List<String> ids = new ArrayList<>();
		String index = getIndex(qid);
		String[] values = map.get("r" + index);
		if (values != null) {
			ids = Arrays.asList(values);
		}
		return ids;
	}

	private List<String> questionsIds(Map<String, String[]> map) {
		return extractIds(map, "q");
	}

	private String getIndex(String qid) {
		return qid.substring(1);
	}

}
