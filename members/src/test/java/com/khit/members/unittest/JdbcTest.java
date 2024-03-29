package com.khit.members.unittest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JdbcTest {
	
	@Test  //main 메서드 처럼 실행됨
	public void testConnection() {
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/springdb?serverTime=Asia/Seoul";
		String username="springuser"; 
		String password="pwspring";
		
		try {
			Class.forName(className);
			Connection con = DriverManager.getConnection(url, username, password);
			//System.out.println("db 연결 객체 생성: " + con);
			log.info("db 연결 객체 생성: " + con);
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
