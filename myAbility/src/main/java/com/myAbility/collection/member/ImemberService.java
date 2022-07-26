package com.myAbility.collection.member;

import com.myAbility.collection.member.DAO.memberDTO;

public interface ImemberService {
	
	public int checkId(String userId);
	public int joinProc(memberDTO member);
	public int pwChangeProc(String newPw);
	
}
