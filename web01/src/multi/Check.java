package multi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check.do")
public class Check extends HttpServlet {

	@Override
	public void init() throws ServletException { //init ==> 초기화
		System.out.println("Check 서블릿 객체가 하나 만들어짐");
	}

	@Override
	public void destroy() {
		System.out.println("Check서블릿 소멸됨");
	}

	// get요청, 클라이언트로 부터 전달되는 데이터는 주소와 함께 도착
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String today = request.getParameter("today");
		String result = "그냥 있을래"; //결과 받는 변수
		if (today.equals("맑음")) {
			result = "나갈래";
		} else if (today.equals("흐림")) {
			result = "코딩할래";
		} else if (today.equals("비옴")) {
			result = "쇼핑할래";
		}
		// setContentType은 out만들기 전에 설정
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pass = request.getParameter("pass");
		String result = "들어올 수 없음<img src='no.png'>"; //결과 받는 변수
		if (pass.equals("나는킹이다")) {
			result = "들어올 수 있음<img src='yes.png'>";
		}
		// setContentType은 out만들기 전에 설정
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
	}

}
