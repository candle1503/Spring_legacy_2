package com.coupang.spring_2.point;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/point/**")
public class PointController {

	@Autowired
	private PointService pointService;
	
	@RequestMapping(value="pointList")
	public ModelAndView pointList(ModelAndView mv) throws Exception{
		ArrayList<PointVO> ar = pointService.pointList();
		mv.addObject("list", ar);
		
		return mv;
	}
	
	
	@RequestMapping(value="pointAdd")
	public ModelAndView pointAdd(ModelAndView mv) throws Exception {
		
		return mv;
	}
	
	@RequestMapping(value="pointAdd", method = RequestMethod.POST)
	public ModelAndView pointAddPost(ModelAndView mv, PointVO pointVO) throws Exception {
		
		System.out.println(pointVO.getEng()); 
		
		int result = pointService.pointAdd(pointVO);
		
			mv.addObject("result", "point 추가 성공");
			mv.addObject("path", "../point/pointList");
			mv.setViewName("common/result");
			
		return mv;
	}

	@RequestMapping(value="pointSelect")
	public ModelAndView pointSelect(ModelAndView mv, PointVO pointVO) throws Exception{
		
		pointVO = pointService.pointSelect(pointVO.getNum());
		
		mv.addObject("dto", pointVO);
		
		return mv;
	}
	
	
	
	
	
}
