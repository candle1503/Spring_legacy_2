package com.coupang.spring_2.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/member/**")
public class MemberController {

	@Autowired			
	private MemberService memberservice;
	
	@RequestMapping(value="memberLogin")
	public void memberLogin(){
	}
	
	@RequestMapping(value="memberLogin", method = RequestMethod.POST)
	public ModelAndView memberLoginPost(MemberVO memberVO,HttpSession session, ModelAndView mv) throws Exception{
		
		memberVO = memberservice.memberLogin(memberVO);
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		}else {
			mv.addObject("result", "Login Fail");
			mv.addObject("path", "../member/memberLogin");
			mv.setViewName("common/result");
		}
		return mv;
	}
	@RequestMapping(value="memberLogout")
	public ModelAndView memberLogout(ModelAndView mv, HttpSession session) throws Exception {
		session.invalidate();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value = "memberJoin")
	public void memberJoin(Model model) {
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public ModelAndView memberJoinPost(MemberVO memberVO, ModelAndView mv) throws Exception {
		int result= memberservice.memberJoin(memberVO);
		if(result >0) {
			mv.setViewName("common/result");
			mv.addObject("result", memberVO.getId()+"님 환영합니다");
			mv.addObject("path", "../member/memberLogin");
		}else {
			mv.setViewName("common/result");
			mv.addObject("result", memberVO.getId()+"아이디 중복입니다");
			mv.addObject("path", "../");
		}
		return mv;
	}
	
	@RequestMapping(value = "memberPage")
	public void memberPage(MemberVO memberVO) throws Exception{
		
	}
	
	@RequestMapping(value = "memberUpdate")
	public void memberUpdate() {
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public ModelAndView memberUpdatePost(ModelAndView mv, MemberVO memberVO, HttpSession session) throws Exception {
		
		int result =memberservice.memberUpdate(memberVO);
		if(result>0) {
			session.setAttribute("member", memberVO);
		}
			mv.setViewName("index");
		
		return mv;
	}
	
	@RequestMapping(value = "memberDelete")
	public ModelAndView memberDelete(ModelAndView mv, MemberVO memberVO,HttpSession session) throws Exception {
			memberVO =(MemberVO) session.getAttribute("member");
			int result = memberservice.memberDelete(memberVO);
			mv.addObject("result", "삭제되었습니다");
			mv.addObject("path", "../");
			mv.setViewName("common/result");
			session.invalidate();
		return mv;
	}
	
}
