package com.yedam.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@Autowired 	//getBean("memberDAO")
				//new MemberDAO()
	
	DAO dao;	
	
	@RequestMapping("/memberList")
	public String memberList(Model model) {
		//회원조회
		model.addAttribute("list", dao.selectAll(null));
		
		
		return "/member/memberAll";
	}
	
	@RequestMapping("/memberInsert")
	public String memberInsert(MemberVO vo) {
		// Member vo -- request와 동일
		System.out.println(vo);
		return "/member/memberList";
	}
	
}
