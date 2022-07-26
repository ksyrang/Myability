package com.myAbility.collection.member.DAO;

import org.springframework.stereotype.Repository;

import com.myAbility.collection.login.DAO.loginDTO;

@Repository
public interface ImemberDAO {
	
	public int insertMem(memberDTO member);
	
	public int checkId(String userId);

	public int isertLogin(loginDTO login);
	
	public int insertPw(pwArchiveDTO pwArchive);
	
	public pwArchiveDTO selectPwArchive(String userId);

	public int updatePw(pwArchiveDTO pwArchive);
	
	
}
