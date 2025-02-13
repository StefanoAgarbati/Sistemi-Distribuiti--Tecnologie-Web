package port.persistence.inMemory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import model.Question;
import port.persistence.IQuestionDao;
import utils.CollectionsUtils;
import utils.OutUtils;

public class InMemoryQuestionDao implements IQuestionDao {
	
	private Collection<Question> questions = new LinkedList<>();
	
	public InMemoryQuestionDao() {
		OutUtils.out("InMemoryQuestionDao created");
		init();
	}
	@Override
	public boolean addNewQuestion(Question aQuestion) {
		boolean res = questions.add(aQuestion);
		OutUtils.out("New question added to QuestionDao of id " + aQuestion.getQuestionId());
		return res;
	}
	@Override
	public boolean updateQuestion(Question aQuestion) {
		Question questionOld = CollectionsUtils.filterOne(questions, q -> q.getQuestionId().equals(aQuestion.getQuestionId()));
		questionOld.setText(aQuestion.getText());
		questionOld.setCategoryId(aQuestion.getCategoryId());
		questionOld.setPoints(aQuestion.getPoints());
		return true;
	}
	@Override
	public boolean deleteQuestion(String questionId) {
		Question q = CollectionsUtils.filterOne(this.questions, question -> question.getQuestionId().equals(questionId));
		if(q == null)
			return false;
		return this.questions.remove(q);
	}
	
	@Override
	public Question getQuestionById(String questionId) {
		List<Question> res = CollectionsUtils.filter(questions, q -> q.getQuestionId().equals(questionId));
		if(res.isEmpty())
			return null;
		return res.get(0);
	}
	
	@Override
	public Collection<Question> getQuestionsByCategory(String categoryId) {
		Collection<Question> list = new ArrayList<>();
		for(Question q : questions) {
			if(q.getCategoryId().equals(categoryId)) {
				list.add(q);
			}
		}
		OutUtils.out("InMemoryQuestionDao-getByCat questions " + list);
		return list;
	}
	
	@Override
	public Collection<Question> getQuestionsByOwner(String ownerId) {
		Collection<Question> list = new ArrayList<>();
		for(Question q : questions) {
			if(q.getOwnerId().equals(ownerId)) {
				list.add(q);
			}
		}
		return list;
	}
	private void init() {
		Question q0 = Question.create("1", "Question text 1", 1, "1", "1");
		Question q1 = Question.create("2", "Question text 2", 2, "1", "2");
		Question q2 = Question.create("3", "Question text 3", 1, "1", "2");
		
		this.addNewQuestion(q0);
		this.addNewQuestion(q1);
		this.addNewQuestion(q2);
	}
	
}
