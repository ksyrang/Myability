package com.myAbility.collection;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *
 * com.myAbility.collection
 * 
 * 
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);//로그를 남기기 위한 로거 생성
	
	@Autowired private HttpSession session;
	
	@RequestMapping(value = "/")
	public String enter(Model model) {
		logger.info("index to home");
		model.addAttribute("formpath", "home");
		return "index";
	}
	
	@RequestMapping(value = "home")
	public void home() { }	
	
	@RequestMapping(value = "index")
	public void index(String formpath,Model model, HttpSession seesion) { 
		model.addAttribute("formpath", formpath);
	}
		
	
	@RequestMapping(value = "login")
	public String login(Model model) {
		return "logIn/loginForm";
	}
	
	@RequestMapping(value = "join")
	public String join(Model model) {
		return "member/joinForm";
	}
	
	
	@RequestMapping(value="findInfo")
	public String findInfo(Model model) {
		return "logIn/findInfoForm";
	}	
	
	@RequestMapping(value="modifyInfo")
	public String modifyInfo(Model model) {
		return "member/modifyForm";
	}

		
	@RequestMapping(value="pwChange")
	public String pwChange(Model model) {
		return "member/pwChangeForm";
	}
	
	@RequestMapping(value = "logout")
	public String logout(Model model) {
		session.invalidate();
		return "redirect:/index?formpath=home";
	}	
}
