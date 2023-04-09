package multi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {

	// 리스트
	public ArrayList<MemberVO> list() {

		ResultSet rs = null;
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
			rs = ps.executeQuery();
			System.out.println("4. SQL문  mySQL로 보내기 성공");
			
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				
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
		System.out.println(list);
		return list;
	}
	
	// 검색
	public MemberVO one(String id) {

		ResultSet rs = null;
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
			rs = ps.executeQuery();
			System.out.println("4. SQL문  mySQL로 보내기 성공");
			
			if (rs.next()) {
				System.out.println("검색결과 있음");
				
				String id2 = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				
				bag = new MemberVO();
				bag.setId(id);
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
		System.out.println(bag);
		return bag;
	}

	// 수정
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
			ps.executeUpdate();
			System.out.println("4. SQL문  mySQL로 보내기 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	// 삭제
	public int delete(MemberVO bag) {

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
			ps.setString(1, bag.getId());
			System.out.println("3. SQL문 부품 만들어주기 성공");

			// 4.
			ps.executeUpdate();
			System.out.println("4. SQL문  mySQL로 보내기 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	// 등록
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
			ps.executeUpdate();
			System.out.println("4. SQL문  mySQL로 보내기 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
}
