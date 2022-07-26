package com.myAbility.collection.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myAbility.collection.login.DAO.IloginDAO;
import com.myAbility.collection.login.DAO.loginDTO;

@Service
public class loginServiceImpl implements IloginService {
	
	@Autowired private HttpSession session;
	@Autowired private IloginDAO loginDAO;
	
	@Override
	public String loginProc(loginDTO login) {
		loginDTO info = loginDAO.selectLogininfo(login.getUserId());


		if(!(info.getUserId().equals(login.getUserId()) && info.getUserPw().equals(login.getUserPw()))) {
			return "실패";
		}
				
		if(info.getUserId().equals("admin")) {
			return "관리자";
		}else if(info.getUserId().startsWith("manager")) {
			return "매니저";
		}
		session.setAttribute("userInfo", info);
		return "일반";
	}

}

