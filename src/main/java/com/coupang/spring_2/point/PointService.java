package com.coupang.spring_2.point;

import java.util.ArrayList;

public class PointService {

	private PointDAO pointDAO;
	
	public PointService(PointDAO pointDAO) {
		this.pointDAO = pointDAO; 
	}

	//5. mod
	public int pointMod(PointVO pointVO) throws Exception{
		pointVO.setTotal(pointVO.getKor()+pointVO.getEng()+pointVO.getMath());
		pointVO.setAvg(pointVO.getTotal()/3.0);
		return pointDAO.pointMod(pointVO);
		
	}
	
	//4. add
	public int pointAdd(PointVO pointVO) throws Exception{
		pointVO.setTotal(pointVO.getKor()+pointVO.getEng()+pointVO.getMath());
		pointVO.setAvg(pointVO.getTotal()/3.0);
		int result =pointDAO.pointAdd(pointVO);
		return result;
	}
	
	//3. delete
	public int pointDelete(int num) throws Exception{
		return pointDAO.pointDelete(num);
	}
	
	//2. select
	public PointVO pointSelect(int num) throws Exception{
		return pointDAO.pointSelect(num);
	}
	
	
	//1. List
	public ArrayList<PointVO> pointList() throws Exception{
		return pointDAO.pointList();
	}
	
}
