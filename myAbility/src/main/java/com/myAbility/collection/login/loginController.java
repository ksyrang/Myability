package com.myAbility.collection.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.myAbility.collection.login.DAO.loginDTO;

import org.springframework.ui.Model;

@Controller
public class loginController {
	
	@Autowired private IloginService loginSVC;
	@Autowired private HttpSession session;
	
	
	@PostMapping("loginProc")
	public String loginProc(loginDTO login, Model model, HttpSession session) {
		
		String result = loginSVC.loginProc(login);
		session.setAttribute("userType", result);
		if(result.equals("일반")) {
			return "redirect:/index?formpath=home";
		}
		else if(result.equals("매니저")) {
			return "redirect:/managerindex?formpath=home";
		}
		else if(result.equals("관리자")) {
			return "redirect:/adminindex?formpath=home";
		}
		
		session.removeAttribute("userType");
		model.addAttribute("msg", "입력 정보를 확인해 주세요.");
		
		return "forward:/index?formpath=login";
	}
	
}
