package multi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Locale;


public class MockDAO2 {
	public int insert(MockVO2 bag) {

		int result = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL과 자바 연결할 부품 설정 성공.");

			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); 
			System.out.println("2. mySQL 연결 성공.");

			String sql = "insert into mock2 values (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, bag.getOwner_first_name()); 
			ps.setString(2, bag.getCar_make());
			ps.setString(3, bag.getCar_model());
			ps.setString(4, bag.getCar_model_year());
			ps.setString(5, bag.getCar_vin());
			ps.setString(6, bag.getCar_color());

			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			result = ps.executeUpdate();
			System.out.println("4. SQL문 mySQL로 보내기 성공.");
			if (result == 1) {
				System.out.println("회원가입 성공!");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
}