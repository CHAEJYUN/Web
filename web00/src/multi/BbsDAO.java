package multi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {

	// 리스트
	public ArrayList<BbsVO> list() {

		ResultSet rs = null;
		ArrayList<BbsVO> list = new ArrayList<>();
		BbsVO bag = null;

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
			String sql = "select * from bbs";
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, id);
			System.out.println("3. SQL문 부품 만들어주기 성공");

			// 4.
			rs = ps.executeQuery();
			System.out.println("4. SQL문  mySQL로 보내기 성공");
			
			while (rs.next()) {
				int no = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String writer = rs.getString(4);
				
				bag = new BbsVO();
				bag.setNo(no);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setWriter(writer);
				
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
	public BbsVO one(int no) {

		ResultSet rs = null;
		BbsVO bag = null;

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
			String sql = "select * from bbs where no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			System.out.println("3. SQL문 부품 만들어주기 성공");

			// 4.
			rs = ps.executeQuery();
			System.out.println("4. SQL문  mySQL로 보내기 성공");
			
			if (rs.next()) {
				System.out.println("검색결과 있음");
				
				int no2 = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String writer = rs.getString(4);
				
				bag = new BbsVO();
				bag.setNo(no2);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setWriter(writer);
				
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
	public int update(BbsVO bag) {

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
			String sql = "update bbs set content = ? where no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getContent());
			ps.setInt(2, bag.getNo());
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
	public int delete(BbsVO bag) {

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
			String sql = "delete from bbs where no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bag.getNo());
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
	public int insert(BbsVO bag) {

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
			String sql = "insert into bbs values(?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bag.getNo());
			ps.setString(2, bag.getTitle());
			ps.setString(3, bag.getContent());
			ps.setString(4, bag.getWriter());
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
