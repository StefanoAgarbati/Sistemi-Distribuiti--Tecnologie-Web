package port.persistence;

import java.util.Collection;
import java.util.List;

import model.PossibleResponse;

public interface IPossibleResponseDao {

	void createNewResponse(PossibleResponse aResponse);
	
	void updateResponse(PossibleResponse aResponse);
	
	void updateResponses(List<PossibleResponse> responses, String questionId);
	
	void deleteREsponse(PossibleResponse aResponse);
	
	void deleteResponsesFromQuestion(String questionId);
	
	Collection<PossibleResponse> getReponsesByQuestion(String questionId);

}
