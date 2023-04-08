package com.multi.mvc400;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //스프링에서 제어하는 역할
public class MemberController {
	
	@Autowired //싱글톤 객체 ram의 어디에 있는지 찾아서
	//그 주소를 아래 변수에 넣어주세요
	MemberDAO dao;
	
	// login
	@RequestMapping("login")
	public String login(MemberVO bag, HttpSession session) {
		System.out.println(bag);
		int result = dao.login(bag); //1 or 0
		if(result == 1) {
			//로그인 성공하면 세션을 잡아두자
			session.setAttribute("id", bag.getId());
			return "ok"; //views 아래 파일 이름.jsp
		} else {
			//views 아래가 아니라 webapp 아래
			//member.jsp로 돌아가고 싶은 경우
			return "redirect:member.jsp";
		}
	}
	
	// insert
	@RequestMapping("insert")
	public void insert(MemberVO bag) {
		//메서드의 입력번수(파라메터)로 변수를 선언해두면
		//컨트롤러 내의 메서드 내에서는
		//1)bag을 만들어
		//2)클라이언트로부터 전달된 데이터 받아줌
		//3)bag에 데이터 다 넣어줌
		System.out.println("insert 요쳥됨");
		System.out.println(bag);
		//MemberDAO dao = new MemberDAO();
		dao.insert(bag);
	}
	
	// update
	@RequestMapping("update")
	public void update(MemberVO bag) {
		System.out.println("update 요쳥됨");
		System.out.println(bag);
		dao.update(bag);
	}
	
	// delete
	@RequestMapping("delete")
	public void delete(String id) {
		System.out.println("delete 요쳥됨");
		System.out.println(id);
		dao.delete(id);
	}
	
	// one
	@RequestMapping("one")
	public void one(String id, Model model) {
		System.out.println("one 요쳥됨");
		System.out.println(id);
		MemberVO bag = dao.one(id);
		//bag에 검색결과 다 들어있음
		//views 아래 one.jsp로 쓸 수 있도록 설정해줘야 함
		model.addAttribute("bag", bag);
		//views까지 전달할 속성으로 추가해주세요
	}
	
	// one
		@RequestMapping("one5")
		public void one5(String id, Model model) {
			System.out.println("one 요쳥됨");
			System.out.println(id);
			MemberVO bag = dao.one(id);
			//bag에 검색결과 다 들어있음
			//views 아래 one.jsp로 쓸 수 있도록 설정해줘야 함
			model.addAttribute("bag", bag);
			//views까지 전달할 속성으로 추가해주세요
		}
	
	// list
	@RequestMapping("list")
	public void list(Model model) {
		//Model은 컨트롤러의 list를 views/list.jsp까지만 전달할 수 있는 객체
		System.out.println("list 요쳥됨");
		ArrayList<MemberVO> list = dao.list();
		System.out.println(list);
		model.addAttribute("list", list);
	}
	
	// list
	@RequestMapping("list7")
	public void list7(Model model) {
		//Model은 컨트롤러의 list를 views/list.jsp까지만 전달할 수 있는 객체
		System.out.println("list 요쳥됨");
		ArrayList<MemberVO> list = dao.list();
		System.out.println(list);
		model.addAttribute("list", list);
	}

}
