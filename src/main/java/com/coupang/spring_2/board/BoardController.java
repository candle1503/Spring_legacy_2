package com.coupang.spring_2.board;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coupang.spring_2.member.MemberVO;

@Controller
@RequestMapping(value="/board/**")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="boardList")
	public ModelAndView boardList(ModelAndView mv) throws Exception {
		ArrayList<BoardVO> ar = boardService.boardList();
		mv.addObject("list", ar);
		
		return mv;
	}
	
	@RequestMapping(value="boardSelect")
	public ModelAndView boardSelect(ModelAndView mv, BoardVO boardVO) throws Exception{
		
		boardVO = boardService.boardSelect(boardVO.getNum());
		mv.addObject("dto", boardVO);
		 
		return mv;
	}
	
	@RequestMapping(value="boardMod")
	public ModelAndView boardMod(ModelAndView mv, BoardVO boardVO) throws Exception{
		mv.addObject("subject", boardVO.getSubject());
		mv.addObject("text", boardVO.getText());
		mv.addObject("num", boardVO.getNum());
		return mv;
	}
	
	@RequestMapping(value="boardMod", method = RequestMethod.POST)
	public ModelAndView boardModPost(ModelAndView mv, BoardVO boardVO, HttpSession session) throws Exception{
		MemberVO memberVO= (MemberVO)session.getAttribute("member");
		boardVO.setId(memberVO.getId());
		int result = boardService.boardMod(boardVO);
		
		if(result > 0){
			mv.addObject("result", "게시물 수정 완료");
			mv.addObject("path", "../board/boardSelect?num"+boardVO.getNum());
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	@RequestMapping(value="boardAdd")
	public ModelAndView boardAdd(ModelAndView mv) throws Exception{
		
		return mv;
	}
	
	@RequestMapping(value="boardAdd", method = RequestMethod.POST)
	public ModelAndView boardAddPost(ModelAndView mv, BoardVO boardVO, HttpSession session) throws Exception{
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		boardVO.setId(memberVO.getId());	
	int result = boardService.boardAdd(boardVO);
	
		mv.addObject("path", "../board/boardList");
		mv.addObject("result", "게시물 추가 완료");
		mv.setViewName("common/result");
	
		return mv;
	}
	
}

