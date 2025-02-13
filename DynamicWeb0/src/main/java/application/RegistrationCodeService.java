package application;

import java.util.Collection;

import model.MemberRegistrationCode;
import port.persistence.IMemberRegistrationCodeDao;
import port.persistence.IdGenerator;
import utils.PasswordGenerator;

public class RegistrationCodeService {

	private IMemberRegistrationCodeDao memberRegistrationCodeDao;
	private PasswordGenerator passwordGenerator;
	
	public RegistrationCodeService(IMemberRegistrationCodeDao memberRegistrationCodeDao) {
		this.memberRegistrationCodeDao = memberRegistrationCodeDao;
		this.passwordGenerator = new PasswordGenerator();
	}
	
	public boolean addMemberRegistrationCodesForGroup(String groupId, int numbersOfCodes) {
		for(int i = 0; i < numbersOfCodes; i++) {
			this.addMemberRegistrationCodeForGroup(groupId);
		}
		return false;
		
	}
	public boolean addMemberRegistrationCodeForGroup(String groupId) {
		for(;;) {
			String aCode = this.passwordGenerator.generatePassword(14, true, true, false, false);
			MemberRegistrationCode memberCode = this.memberRegistrationCodeDao.getMemberRegistrationCodebyId(aCode);
			if(memberCode == null) {
				memberCode = MemberRegistrationCode.create(IdGenerator.generateId(), groupId, aCode);
				this.memberRegistrationCodeDao.addMemberRegistrationCode(memberCode);
				return true;
			}
		}
	}
	public boolean removeMemberRegistrationCodeForGroup(String groupId, int toRemove) {
		for(int i = 0; i < toRemove; i++) {
		
		}
		return false;
		
	}
	public MemberRegistrationCode getMemberRegistrationCodeById(String code) {
		return this.memberRegistrationCodeDao.getMemberRegistrationCodebyId(code);
	}
	public boolean hasMemberRegistrationCode(String code) {
		MemberRegistrationCode memberCode = this.memberRegistrationCodeDao.getMemberRegistrationCodebyId(code);
		return memberCode != null;
	}
	public Collection<MemberRegistrationCode> getMemberRegistrationCodeByGroup(String groupId) {
		return this.memberRegistrationCodeDao.getMemberRegistrationCodeByGroup(groupId);
	}
}
