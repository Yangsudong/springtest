package com.yedam.app.member.mapper;

import java.util.HashMap;
import java.util.List;

import com.yedam.app.member.MemberVO;

public interface MemberDAO {
	//전체조회
	List<MemberVO> selectAll();

	//단건조회
	MemberVO selectOne(MemberVO memberVO);

	//메일수신회원수 :  select count(id) cnt from members where mailYn='y'; 
	int getMailynCnt();

	// 성별인원수 : select gender, count(id) cnt from members group by gender;
	List<HashMap<String, Object>> getGenderCnt();

	int delete(MemberVO memberVO);

	int update(MemberVO memberVO);

	int insert(MemberVO memberVO);
}
