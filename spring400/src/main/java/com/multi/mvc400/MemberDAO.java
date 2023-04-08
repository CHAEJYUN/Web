package com.multi.mvc400;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

//import 화면DB 연결 MemberVO;
//싱글톤으로 하나만 만들어서 설정해야 함
//(1)어노테이션 방법과 (2)XML 방법
@Component //(1)
public class MemberDAO {

	// login
	public int login(MemberVO bag) {
		
		int result = 0;
		try {
			// 1.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공");
			
			// 2.
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mySQL 연결 성공");
			
			// 3.
			String sql = "select * from member where id=? and pw=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPw());
			System.out.println("3. SQL문 부품으로 만들어주기 성공");
			
			// 4.
			ResultSet rs = ps.executeQuery();
			System.out.println("4. SQL문 mySQL로 보내기 성공");
			if (rs.next()) {
				System.out.println("검색결과 있음");
				result = 1;
			}
			System.out.println("검색 결과 없음");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// list
	public ArrayList<MemberVO> list() {

		ResultSet rs = null; //항목명 + 결과 데이터를 담고 있는 테이블
		//가방들 넣어 줄 큰 컨테이너 역할 부품 필요
		//MemberVO만 들어간 arraylist임
		ArrayList<MemberVO> list = new ArrayList<>();
		MemberVO bag = null;
		try {
			// 1.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1 .mySQL과 자바 연결할 부품 설정 성공");

			// 2.
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mySQL 연결 성공");

			// 3.
			String sql = "select * from member";
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, id);
			System.out.println("3. SQL문 부품 만들어주기 성공");

			// 4.
			rs = ps.executeQuery(); //select문 전송시
			System.out.println("4. SQL문  mySQL로 보내기 성공");
			while (rs.next()) {
				System.out.println("검색결과 있음");
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);
				
				bag = new MemberVO();
				bag.setId(id);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
				
				list.add(bag);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// one
	public MemberVO one(String id) {

		ResultSet rs = null; //항목명 + 결과 데이터를 담고 있는 테이블
		//참조형 변수를 초기화 할 때는 null
		MemberVO bag = null;
		try {
			// 1.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1 .mySQL과 자바 연결할 부품 설정 성공");

			// 2.
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mySQL 연결 성공");

			// 3.
			String sql = "select * from member where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("3. SQL문 부품 만들어주기 성공");

			// 4.
			rs = ps.executeQuery(); //select문 전송시
			System.out.println("4. SQL문  mySQL로 보내기 성공");
			if (rs.next()) {
				System.out.println("검색결과 있음");
				String id2 = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);
				
				bag = new MemberVO();
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
				
				System.out.println(bag.toString());
			} else {
				System.out.println("검색결과 없음");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bag;
	}
	
	// delete
	public int delete(String id) {

			int result = 0;
			try {
				// 1.
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("1 .mySQL과 자바 연결할 부품 설정 성공");

				// 2.
				String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
				String user = "root";
				String password = "1234";
				Connection con = DriverManager.getConnection(url, user, password);
				System.out.println("2. mySQL 연결 성공");

				// 3.
				String sql = "delete from member where id = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, id);
				System.out.println("3. SQL문 부품 만들어주기 성공");

				// 4.
				result = ps.executeUpdate();
				//insert, update, delete은 sql문 실행결과가 int
				System.out.println("4. SQL문  mySQL로 보내기 성공");
				if (result == 1) {
					System.out.println("탈퇴 성공");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}

	// update
	public int update(MemberVO bag) {

		int result = 0;
		try {
			// 1.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1 .mySQL과 자바 연결할 부품 설정 성공");

			// 2.
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mySQL 연결 성공");

			// 3.
			String sql = "update member set tel = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getTel());
			ps.setString(2, bag.getId());
			System.out.println("3. SQL문 부품 만들어주기 성공");

			// 4.
			result = ps.executeUpdate();
			//insert, update, delete은 sql문 실행결과가 int
			System.out.println("4. SQL문  mySQL로 보내기 성공");
			if (result == 1) {
				System.out.println("수정 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// insert
	public int insert(MemberVO bag) {

		int result = 0;
		try {
			// 1.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1 .mySQL과 자바 연결할 부품 설정 성공");

			// 2.
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mySQL 연결 성공");

			// 3.
			String sql = "insert into member values(?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPw());
			ps.setString(3, bag.getName());
			ps.setString(4, bag.getTel());
			System.out.println("3. SQL문 부품 만들어주기 성공");

			// 4.
			result = ps.executeUpdate();
			//insert, update, delete은 sql문 실행결과가 int
			System.out.println("4. SQL문  mySQL로 보내기 성공");
			if (result == 1) {
				System.out.println("가입 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
