package com.coupang.spring_2.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	
	 @Autowired private MemberDAO memberDAO;
	 
	/*
	 * @Autowired public MemberService(MemberDAO memberDAO) { 
	 * this.memberDAO =	 memberDAO; }
	 */

//	public void setMemberDAO(MemberDAO memberDAO) {			//property
//		this.memberDAO = memberDAO;
//	}

	public int memberUpdate(MemberVO memberVO) throws Exception {
		return memberDAO.memberUpdate(memberVO);
	}

	public int memberDelete(MemberVO memberVO) throws Exception {
		return memberDAO.memberDelete(memberVO);
	}

	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		return memberDAO.memberLogin(memberVO);
	}

	public int memberJoin(MemberVO memberVO) throws Exception {
		return memberDAO.memberJoin(memberVO);
	}
}
