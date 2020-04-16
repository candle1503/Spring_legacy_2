package com.coupang.spring_2.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.coupang.util.DBConnector;

@Repository
public class MemberDAO {


	
	//4. memberUpdate
		public int memberUpdate(MemberVO memberVO) throws Exception{
			int result =0;
			
			Connection con = DBConnector.getConnection();
			
			String sql = "update member set name=?, Phone=?, email=?, age=? where id=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, memberVO.getName());
			st.setString(2, memberVO.getPhone());
			st.setString(3, memberVO.getEmail());
			st.setInt(4, memberVO.getAge());
			st.setString(5, memberVO.getId());
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
			return result;
		}

	//3. memberDelete
		public int memberDelete(MemberVO memberVO) throws Exception{
			
			Connection con = DBConnector.getConnection();
			
			String sql = "delete from member where id=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, memberVO.getId());
			
			int result = st.executeUpdate();
			
			st.close();
			con.close();
			
			return result;
			
		}

	//2. memberLogin
		
		public MemberVO memberLogin(MemberVO memberVO)throws Exception{
			
			Connection con  = DBConnector.getConnection();
			String sql ="select * from member where id=? and password=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, memberVO.getId());
			st.setString(2, memberVO.getPassword());
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setPhone(rs.getString("Phone"));
				memberVO.setAge(rs.getInt("age"));
			}else {
				memberVO = null;
			}
			
			rs.close();
			st.close();
			con.close();
			
			return memberVO;
			
		}
	
	
	
	//1. memberJoin
	public int memberJoin(MemberVO memberVO) throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "insert into member values(?,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberVO.getId());
		st.setString(2, memberVO.getPassword());
		st.setString(3, memberVO.getName());
		st.setString(4, memberVO.getPhone());
		st.setString(5, memberVO.getEmail());
		st.setInt(6, memberVO.getAge());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
}
