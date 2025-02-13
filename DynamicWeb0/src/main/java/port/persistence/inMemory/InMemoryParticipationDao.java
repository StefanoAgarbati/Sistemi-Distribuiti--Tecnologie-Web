package port.persistence.inMemory;

import java.util.Collection;
import java.util.LinkedList;

import model.Participation;
import port.persistence.IParticipationDao;
import utils.CollectionsUtils;
import utils.OutUtils;

public class InMemoryParticipationDao implements IParticipationDao {

	private Collection<Participation> participations = new LinkedList<>();
	
	public InMemoryParticipationDao() {
		init();
	}
	private void init() {
		Participation p0 = Participation.create("1", "1", "1");
		this.createParticipation(p0);
	}
	@Override
	public boolean createParticipation(Participation aParticipation) {
		boolean res = this.participations.add(aParticipation);
		OutUtils.out("ParticipationDao createParticipation() " + res);
		return res;
	}

	@Override
	public Collection<Participation> getParticipationByGroup(String groupId) {
		Collection<Participation> partis = CollectionsUtils.filter(participations, 
				participation -> participation.getGroupId().equals(groupId));
		OutUtils.out("ParticipationDao getParticipationByGroup() " + partis);
		return partis;
	}

	@Override
	public Collection<Participation> getParticipationByMember(String memberId) {
		return CollectionsUtils.filter(participations, p -> p.getMemberId().equals(memberId));
	}
	
	

}
