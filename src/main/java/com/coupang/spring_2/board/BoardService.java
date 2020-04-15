package com.coupang.spring_2.board;

import java.util.ArrayList;

public class BoardService {
	private BoardDAO boardDAO;
	
	public BoardService(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}


	//5. Mod
	public int boardMod(BoardVO boardvo) throws Exception{
		return boardDAO.boardMod(boardvo);
	}
	
	//4. delete
	public int boardDelete(String num) throws Exception{
		return boardDAO.boardDelete(num);
	}
	
	//3. Add
	public int boardAdd(BoardVO boardvo) throws Exception{
		return boardDAO.boardAdd(boardvo);
	}
	
	//2. Select
	public BoardVO boardSelect(int num) throws Exception{
		return boardDAO.boardSelect(num);
	}
	
	//1. list
	public ArrayList<BoardVO> boardList() throws Exception{
		return boardDAO.boardList();
	}
	
}
