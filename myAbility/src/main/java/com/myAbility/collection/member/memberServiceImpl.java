package com.myAbility.collection.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myAbility.collection.login.DAO.IloginDAO;
import com.myAbility.collection.login.DAO.loginDTO;
import com.myAbility.collection.member.DAO.ImemberDAO;
import com.myAbility.collection.member.DAO.memberDTO;
import com.myAbility.collection.member.DAO.pwArchiveDTO;

@Service
public class memberServiceImpl implements ImemberService {
	
	@Autowired private ImemberDAO memDAO;
	@Autowired private HttpSession session;
	@Autowired private IloginDAO loginDAO;
	
	@Override
	public int checkId(String userId) {
		return memDAO.checkId(userId);//1 == 중복, 0 == 중복X
	}
	
	@Override
	public int joinProc(memberDTO member) {
		int result = 0;
		
		result += memDAO.isertLogin(member);//login table
		if(result != 1) return 10;
		result = 0;
		
		pwArchiveDTO pwArchive = new pwArchiveDTO();
		pwArchive.setUserId(member.getUserId());
		pwArchive.setPw1(member.getUserPw());
		
		result += memDAO.insertPw(pwArchive);//pw table
		if(result != 1) return 11;
		result = 0;
		
		result += memDAO.insertMem(member);//member table
		if(result != 1) return 12;
		
		return result;
	}
	
	@Override
	public int pwChangeProc(String newPw) {
		loginDTO userInfo = (loginDTO)session.getAttribute("userInfo");
		pwArchiveDTO pwArchive = memDAO.selectPwArchive(userInfo.getUserId());
		
		if(pwArchive.getPw1().equals(newPw)) return 10;
		else if(pwArchive.getPw2() != null && pwArchive.getPw2().equals(newPw)) return 10;
		else if(pwArchive.getPw3() != null && pwArchive.getPw3().equals(newPw)) return 10;
		
		userInfo.setUserPw(newPw);
		int result = loginDAO.updateLogininfo(userInfo);
		
		if(result != 1) return 100;
		
		int num = (pwArchive.getCount()+1)%3;
		switch(num) {
			case 0: 
				pwArchive.setPw1(newPw);
				break;
			case 1: 
				pwArchive.setPw2(newPw);
				break;
			case 2: 
				pwArchive.setPw3(newPw);
				break;
			default: 
				pwArchive.setPw1(newPw);
				break;
		}
		pwArchive.setCount(num);
		result = memDAO.updatePw(pwArchive);
		
		return result;
	}

}
