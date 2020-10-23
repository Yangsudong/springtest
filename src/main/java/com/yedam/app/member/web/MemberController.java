package com.yedam.app.member.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.member.MemberVO;
import com.yedam.app.member.service.impl.MemberService;

@Controller
public class MemberController {
	@Autowired 	//getBean("memberDAO") == new MemberDAO()
	MemberService memberService;	
	
	@RequestMapping("/memberList")
	public String memberList(Model model, 
							 HttpServletRequest reqeust, 
							 HttpSession session) {
		//회원조회
		model.addAttribute("list", memberService.selectAll());
		
		
		return "member/memberAll";
	}
	//등록페이지
	@RequestMapping(value="/memberInsert", method=RequestMethod.GET)
	public String memberInsertForm() {
		return "member/memberInsert";
	}
	
	//등록처리
	@RequestMapping(value="/memberInsert", method=RequestMethod.POST)
	public String memberInsert(MemberVO memberVO) {
		// Member vo -- request와 동일
		System.out.println(memberVO);
		memberService.insert(memberVO);
		return "redirect:/memberList";
	}
	
	//단건조회
//	@RequestMapping(value="/memberSelect")
//	public String memberSelectOne(MemberVO memberVO, Model model) {
//		model.addAttribute("member", memberService.selectOne(memberVO));
//		return "member/memberSelect";
//	}
	
	
	//단건조회(위와같음)
	@RequestMapping(value="/memberSelect")
	public String memberSelectOne( @RequestParam(name="id", 
												 required=false,
												 defaultValue = "hello") 
								  String mid,
								  Model model,
								  HttpServletRequest request) {
		//String mid = request.getParameter("id"); ↑↑↑같은말
		if(mid != null) {
			mid = "hello";
		}
		MemberVO vo = new MemberVO();
		vo.setId(mid);
		model.addAttribute("member", memberService.selectOne(vo));
		return "member/memberSelect";
	}
	
	//경로명에 변수가 포함(pathvariable)
	@RequestMapping("/userSelectPath/{id}")
	public String userSelectPath(Model model, @PathVariable String id) {
		MemberVO vo = new MemberVO();
		vo.setId(id);
		model.addAttribute("member", memberService.selectOne(vo));
		return "member/memberSelect";
	}
	
	//파라미터를 맵에
	@RequestMapping("/userSelectMap")
	public String userSelectMap(@RequestParam Map map) {
		System.out.println(map);
		return "";
	}
	
	@RequestMapping("/memberListAjax")
	@ResponseBody
	public List<MemberVO> memberListAjax() {
		//회원조회
		return memberService.selectAll();
	}
	
	
	@RequestMapping("/memberSelectOneAjax")
	@ResponseBody
	public MemberVO memberSelectOneAjax(MemberVO memberVO) {
		//회원조회
		return memberService.selectOne(memberVO);
	}
}

