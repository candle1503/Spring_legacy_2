package com.coupang.spring_2.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/member/**")
public class MemberController {

	@Autowired			//controller에서는 autowired로
	private MemberService memberservice;
	
	@RequestMapping(value="memberLogin")
	public void memberLogin(){
	}
	
	@RequestMapping(value="memberLogin", method = RequestMethod.POST)
	public String memberLoginPost(MemberVO memberVO,HttpSession session,Model model) throws Exception{
		
		System.out.println("성공");
		
		memberVO = memberservice.memberLogin(memberVO);
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
			return "redirect:../";
		}else {
			model.addAttribute("result", "Login Fail");
			model.addAttribute("path", "./memberLogin");
			return "common/result.jsp";
		}
		
		//로그인 성공이면 intdex
		//실패하면 로그인 실패 alert 후  
		
		
	}
	
	@RequestMapping(value = "memberJoin")
	public void memberJoin(Model model) {
		String id = "test";
		model.addAttribute(id);
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String memberJoinPost(MemberVO memberVO) {
		System.out.println(memberVO.getId());
		System.out.println(memberVO.getPassword());
		return "redirect:../";
	}
	
	@RequestMapping(value = "memberPage")
	public void memberPage() {
	}
	
	@RequestMapping(value = "memberUpdate")
	public String memberUpdatePost() {
		return "redirect:../";
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public void memberUpdate() {
	}
	
	@RequestMapping(value = "memberDelete")
	public void memberDelete() {
	}
	
}
