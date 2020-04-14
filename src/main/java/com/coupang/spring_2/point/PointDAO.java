package com.coupang.spring_2.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.coupang.util.DBConnector;

public class PointDAO {
	// DAO (Data Access Object)

	//5. Mod
	public int pointMod(PointVO pointVO) throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql= "update point set name=?,kor=?,eng=?,math=?,total=?,avg=? where num = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, pointVO.getName());
		st.setInt(2, pointVO.getKor());
		st.setInt(3, pointVO.getEng());
		st.setInt(4, pointVO.getMath());
		st.setInt(5, pointVO.getTotal());
		st.setDouble(6, pointVO.getAvg());
		st.setInt(7, pointVO.getNum());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	//4. Add
	public int pointAdd(PointVO pointVO) throws Exception{
		int result = 0;
		
		Connection con = DBConnector.getConnection();
		
		String sql= "insert into point values(?,?,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, pointVO.getName());
		st.setInt(2, pointVO.getNum());
		st.setInt(3, pointVO.getKor());
		st.setInt(4, pointVO.getEng());
		st.setInt(5, pointVO.getMath());
		st.setInt(6, pointVO.getTotal());
		st.setDouble(7, pointVO.getAvg());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	
	
	//3. Delete
	public int pointDelete(int num) throws Exception{
		PointVO pointVO = null;
		
		Connection con = DBConnector.getConnection();
		
		String sql = "delete from point where num = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, num);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	
	//2. Select
	public PointVO pointSelect(int num) throws Exception{
		PointVO pointVO = null;
	
		Connection con = DBConnector.getConnection();
		
		String sql = "select * from point where num = ?";
		
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		
		
		if(rs.next()) {
			pointVO = new PointVO();
			pointVO.setName(rs.getString("name"));
			pointVO.setNum(rs.getInt("num"));
			pointVO.setKor(rs.getInt("kor"));
			pointVO.setEng(rs.getInt("eng"));
			pointVO.setMath(rs.getInt("math"));
			pointVO.setTotal(rs.getInt("total"));
			pointVO.setAvg(rs.getDouble("avg"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return pointVO;
	}
		
	
	
	// 1. List
	public ArrayList<PointVO> pointList() throws Exception {
		// 1. DB 연결
		Connection con = DBConnector.getConnection();
		// 2. SQL문 작성
		String sql = "Select * from point order by num asc";
		// 3. SQL 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		// 4. ? 세팅

		// 5. 최종 전송 후 결과 처리
		ArrayList<PointVO> ar = new ArrayList<PointVO>();
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			PointVO pointVO = new PointVO();
			pointVO.setName(rs.getString("name"));
			pointVO.setNum(rs.getInt("num"));
			pointVO.setKor(rs.getInt("kor"));
			pointVO.setEng(rs.getInt("eng"));
			pointVO.setMath(rs.getInt("math"));
			pointVO.setTotal(rs.getInt("total"));
			pointVO.setAvg(rs.getDouble("avg"));
			ar.add(pointVO);
			
		}
		// 6. 자원 해제
		rs.close();
		st.close();
		con.close();

		return ar;
	}

	// 2. SelectOne

	// 3. Insert
	public int insert(PointVO pointVO) {
		int result = 0;

		return result;
	}

	// 4. Update

	// 5. Delete

}
