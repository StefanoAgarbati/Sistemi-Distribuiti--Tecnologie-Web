package port.persistence;

import java.util.Collection;

import model.Participation;

public interface IParticipationDao {

	boolean createParticipation(Participation aParticipation);
	
	Collection<Participation> getParticipationByGroup(String groupId);
	
	Collection<Participation> getParticipationByMember(String memberId);
	
}
