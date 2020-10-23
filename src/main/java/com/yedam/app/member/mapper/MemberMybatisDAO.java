package com.yedam.app.member.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.app.member.MemberVO;

//@Repository
public class MemberMybatisDAO implements MemberDAO{
	
	@Autowired SqlSessionTemplate sqlsession;

	@Override
	public List<MemberVO> selectAll() {
		System.out.println("mybatis selectAll");
		return sqlsession.selectList("memberDAO.selectAll");
	}

	@Override
	public MemberVO selectOne(MemberVO memberVO) {
		return sqlsession.selectOne("memberDAO.selectOne",memberVO);
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
		return 0;
	}

	@Override
	public int update(MemberVO memberVO) {
		return 0;
	}

	@Override
	public int insert(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
