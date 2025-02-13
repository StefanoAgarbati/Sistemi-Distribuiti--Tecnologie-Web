package port.persistence.inMemory;

import java.util.Collection;
import java.util.LinkedList;

import model.MemberRegistrationCode;
import port.persistence.IMemberRegistrationCodeDao;
import utils.CollectionsUtils;

public class InMemoryMemberRegistrationCodeDao implements IMemberRegistrationCodeDao {

	private Collection<MemberRegistrationCode> codes = new LinkedList<>();
	
	public InMemoryMemberRegistrationCodeDao() {
		init();
	}
	public boolean deleteMemberRegistrationCode(MemberRegistrationCode aCode) {
		MemberRegistrationCode cod = CollectionsUtils.filterOne(codes, code -> code.getCode().equals(aCode.getCode()));
		if(cod == null)
			return false;
		return codes.remove(cod);
	}
	@Override
	public boolean addMemberRegistrationCode(MemberRegistrationCode aCode) {
		return codes.add(aCode);
	}
	@Override
	public MemberRegistrationCode getMemberRegistrationCodebyId(String codeId) {
		MemberRegistrationCode regCode = CollectionsUtils.filterOne(codes, code -> code.getCode().equals(codeId));
		System.out.println("getMemberRegistrationCodeByIdDao " + regCode);
		return regCode;
	}
	@Override
	public Collection<MemberRegistrationCode> getMemberRegistrationCodeByGroup(String groupId) {
		return CollectionsUtils.filter(codes, code -> code.getGroupId().equals(groupId));
	}
	
	private void init() {
		MemberRegistrationCode c0 = MemberRegistrationCode.create("1", "1", "ABCD");
		MemberRegistrationCode c1 = MemberRegistrationCode.create("2", "2", "ZXCV");
		this.addMemberRegistrationCode(c0);
		this.addMemberRegistrationCode(c1);
	}
}
