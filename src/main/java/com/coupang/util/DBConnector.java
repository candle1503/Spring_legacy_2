package com.coupang.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

	public static void main(String[] args) {
		try {
			Connection con = DBConnector.getConnection();
			System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		//1. 로그인 정보 4가지
		
		//logon deny
		//1. ID/PW가 틀렸을 경우
		//2. DB에 해당 유저가 생성되지 않은 경우
		//3. 유저의 권한이 적용 되지 않은 경우
		
		String user = "user02";
		String password = "user02";
		
		//not connect
		//1. ip, port, xe 정보가 틀린경우
		//2. 물리적으로 연결이 안되거나, 서버가 종료된 경우
		//3. Listener문제, DB 재시동
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		
		//class not fount 
		//1. driver명이 틀린 경우
		//2. jdbc(ojdbc6.jar)가 없는 경우
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2. 드라이버를 메모리에 로딩
		Class.forName(driver);
		
		//3. 로그인 Connection 객체 반환
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
}
