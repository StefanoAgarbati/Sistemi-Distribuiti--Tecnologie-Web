package port.persistence.inMemory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.PossibleResponse;
import port.persistence.IPossibleResponseDao;
import utils.CollectionsUtils;
import utils.OutUtils;

public class InMemoryPossibleResponseDao implements IPossibleResponseDao {

	private List<PossibleResponse> responses = new LinkedList<>();
	
	public InMemoryPossibleResponseDao() {
		init();
	}
	public boolean addResponseToQuestion(PossibleResponse response) {
		OutUtils.out("ResponsesDao-->addResponse");
		boolean res = responses.add(response);
		this.showResponses(this.responses);
		OutUtils.out("---------------------------");
		return res;
	}
	public PossibleResponse getResponseById(String responseId) {
		return CollectionsUtils.filterOne(responses, r -> r.getResponseId().equals(responseId));
	}
	@Override
	public void createNewResponse(PossibleResponse aResponse) {
		responses.add(aResponse);
	}
	@Override
	public void updateResponse(PossibleResponse aResponse) {
		this.deleteREsponse(aResponse);
		this.addResponseToQuestion(aResponse);
	}
	@Override
	public void updateResponses(List<PossibleResponse> resps, String questionId) {
		this.deleteResponsesFromQuestion(questionId);
		for(PossibleResponse res : resps) {
			this.addResponseToQuestion(res);
		}
		this.showResponses(this.responses);
	}
	@Override
	public void deleteResponsesFromQuestion(String questionId) {
		OutUtils.out("ResponseDao--> before delete responses size " + this.responses.size());
		this.showResponses(this.responses);
		List<PossibleResponse> toRemove = new ArrayList<>();
		for(int i = 0; i < this.responses.size(); i++) {
			PossibleResponse response = this.responses.get(i);
			OutUtils.out("deleteResponsesFromQuestion "+i+" response question id " +response.getQuestionId());
			if(response.getQuestionId().equals(questionId)) {
				OutUtils.out("deleteResponsesFromQuestion removeIf response question id " +response.getQuestionId());
				toRemove.add(response);
			}
				
		}
		for(PossibleResponse response : toRemove) {
			this.responses.remove(response);
		}
		OutUtils.out("---------------------------");
		OutUtils.out("ResponseDao--> post delete");
		this.showResponses(this.responses);
		OutUtils.out("---------------------------");
	}
	@Override
	public void deleteREsponse(PossibleResponse aResponse) {
		for(PossibleResponse r : this.responses) {
			if(r.getResponseId().equals(aResponse.getResponseId()))
				this.responses.remove(r);
		}
	}
	@Override
	public Collection<PossibleResponse> getReponsesByQuestion(String questionId) {
		Collection<PossibleResponse> list = CollectionsUtils.filter(responses, (response) -> response.getQuestionId().equals(questionId));
		return list;
	}
	private void showResponse(PossibleResponse response) {
		OutUtils.out("{resId:"+response.getResponseId()+",questionId:"+response.getQuestionId()
					+",text:"+response.getText()+",name:"+response.getName()+",isCorrect:"+response.isCorrect()+"}");
	}
	private void showResponses(Collection<PossibleResponse> responses) {
		responses.forEach(response -> showResponse(response));
	}
	private void init() {
		PossibleResponse r0 = new PossibleResponse("1", "1", true, "Answer 1", "A");
		PossibleResponse r1 = new PossibleResponse("2", "1", false, "Answer 2", "B");
		PossibleResponse r2 = new PossibleResponse("3", "1", false, "Answer 3", "C");
		
		PossibleResponse r3 = new PossibleResponse("4", "2", false, "Answer 1", "A");
		PossibleResponse r4 = new PossibleResponse("5", "2", true, "Answer 2", "B");
		PossibleResponse r5 = new PossibleResponse("6", "2", false, "Answer 3", "C");
		
		this.addResponseToQuestion(r0);
		this.addResponseToQuestion(r1);
		this.addResponseToQuestion(r2);
		this.addResponseToQuestion(r3);
		this.addResponseToQuestion(r4);
		this.addResponseToQuestion(r5);
	}
	
	
}
