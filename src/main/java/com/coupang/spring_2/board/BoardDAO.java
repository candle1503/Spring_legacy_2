package com.coupang.spring_2.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.coupang.util.DBConnector;

public class BoardDAO {

	
	//5. boardMod
	public int boardMod(BoardVO boardDTO) throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "update board SET num = ?, subject=?,text=?,id=?,creatdate=sysdate,hit=?  where num = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, boardDTO.getNum());
		st.setString(2, boardDTO.getSubject());
		st.setString(3, boardDTO.getText());
		st.setString(4, boardDTO.getId());
		st.setInt(5, 1);
		st.setInt(6, boardDTO.getNum());
		
		int result = st.executeUpdate();
		
		return result;
	}
	
	
	//4. boardDelete
	public int boardDelete(int num) throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "delete board where num = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, num);
		
		int result = st.executeUpdate();
		
		return result;
	}
	
	//3. boardAdd
	public int boardAdd(BoardVO boardDTO) throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "insert into board values(count.NEXTVAL,?,?,?,sysdate,1)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, boardDTO.getSubject());
		st.setString(2, boardDTO.getText());
		st.setString(3, boardDTO.getId());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	//2. boardSelect
	public BoardVO boardSelect(int num) throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "select * from board where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		
		BoardVO boardDTO = new BoardVO();
		if(rs.next()) {
			boardDTO.setNum(rs.getInt("num"));
			boardDTO.setSubject(rs.getString("subject"));
			boardDTO.setId(rs.getString("id"));
			boardDTO.setCreatDate(rs.getDate("creatDate"));
			boardDTO.setHit(rs.getInt("hit"));
			boardDTO.setText(rs.getString("text"));
		}
		
		st.close();
		con.close();
		
		return boardDTO;
	}
	
	//1. boardList
	public ArrayList<BoardVO> boardList() throws Exception {
		ArrayList<BoardVO> ar = new ArrayList<BoardVO>();
		Connection con = DBConnector.getConnection();
		
		String sql = "Select * from board order by num asc";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BoardVO boardDTO = new BoardVO();
			boardDTO.setNum(rs.getInt("num"));
			boardDTO.setSubject(rs.getString("subject"));
			boardDTO.setId(rs.getString("id"));
			boardDTO.setCreatDate(rs.getDate("creatDate"));
			boardDTO.setHit(rs.getInt("hit"));
			ar.add(boardDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
}
