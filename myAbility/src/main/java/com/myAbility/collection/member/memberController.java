package com.myAbility.collection.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myAbility.collection.member.DAO.memberDTO;


@Controller
public class memberController {
	
	@Autowired private ImemberService memSVC;
	@Autowired private HttpSession session;
	
	@PostMapping(value = "checkId", produces = "application/json; charset = UTF-8")
	@ResponseBody
	public String checkId(@RequestBody(required = false) String id) {
			
		int result = memSVC.checkId(id);
		String msg = "";
		if(result == 1) msg = "중복된 아이디 입니다.";
		else msg = "등록 가능한 아이디 입니다.";
		return msg;
	}

	
	@PostMapping("joinProc")
	public String joinProc(Model model, memberDTO mem) {
		int result = memSVC.joinProc(mem);
		if(result == 1) return "redirect:/index?formpath=login";
		else {
			model.addAttribute("joinInfo", mem);
			model.addAttribute("msg", "서버 이상 발생 코드 : "+result);
			return "forward:/index?formpath=join";
		}
	}
	
	
	@PostMapping("pwChangeProc")
	public String pwChangeProc(Model model, String newPw) {
		int result = memSVC.pwChangeProc(newPw);
		
		if(result == 1) {
			session.invalidate();
			return "redirect:/index?formpath=login";
		}
		else if(result == 100) {
			model.addAttribute("msg", "서버 이상 발생 코드 : "+ result);
			return "redirect:/index?formpath=login";
		}
		else {
			model.addAttribute("msg", "최근에 사용한 비밀번호 입니다.");
			return "forward:/index?formpath=pwChange";
		}
	}

}
