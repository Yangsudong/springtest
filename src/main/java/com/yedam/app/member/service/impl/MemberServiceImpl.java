package com.yedam.app.member.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.member.MemberVO;
import com.yedam.app.member.mapper.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberDAO memberDAO;

	@Override
	public ArrayList<MemberVO> selectAll() {
		return memberDAO.selectAll();
	}

	@Override
	public MemberVO selectOne(MemberVO memberVO) {
		return memberDAO.selectOne(memberVO);
	}

	@Override
	public int getMailynCnt() {
		return 0;
	}

	@Override
	public List<HashMap<String, Object>> getGenderCnt() {
		return null;
	}

	@Override
	public int delete(MemberVO memberVO) {
		return memberDAO.delete(memberVO);
	}

	@Override
	public int update(MemberVO memberVO) {
		return memberDAO.update(memberVO);
	}

	@Override
	public int insert(MemberVO memberVO) {
		return memberDAO.insert(memberVO);
	}

}
