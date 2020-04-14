package com.coupang.spring_2.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {

	@RequestMapping(value="memberLogin")
	public void memberLogin(){
	}
	
	@RequestMapping(value="memberLogin", method = RequestMethod.POST)
	public String memberLoginPost(){
		return "redirect:../";
	}
	
	@RequestMapping(value = "memberJoin")
	public void memberJoin() {
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String memberJoinPost() {
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
