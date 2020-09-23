package com.yedam.app.member.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.yedam.app.member.MemberVO;

@Component
public class MemberSpringDAO implements MemberDAO{
	
	@Autowired JdbcTemplate template;
	
	final static String INSERT_MEMBER = "INSERT INTO MEMBERS (ID, PASS, GENDER, JOB, MAILYN, REASON, HOBBY, REGDATE) "
										+" VALUES(?,?,?,?,?,?,?,SYSDATE)"; 
	
	final static String DELETE_MEMBER = "DELETE FROM MEMBERS WHERE ID = ?";
	
	final static String SELECT_MEMBER = "SELECT * FROM MEMBERS WHERE ID = ?";
	
	final static String SELECT_ALL_MEMBER = "SELECT * FROM MEMBERS";
	
	
	@Override
	public int insert(MemberVO memberVO) {
		Object[] args = {memberVO.getId(), memberVO.getPass(), memberVO.getGender(), memberVO.getJob(),
						 memberVO.getMailYN(), memberVO.getReason(), memberVO.getHobby() };
		return template.update(INSERT_MEMBER, args);
	}
	
	@Override
	public int delete(MemberVO memberVO) {
		return template.update(DELETE_MEMBER, memberVO.getId());
	}
	
	@Override
	public ArrayList<MemberVO> selectAll() {
		return (ArrayList<MemberVO>) template.query(SELECT_ALL_MEMBER, new MemberRowMapper());
	}

	@Override
	public MemberVO selectOne(MemberVO memberVO) {
		Object[] args = {memberVO.getId()};
		return template.queryForObject(
										SELECT_MEMBER, 
										args , 
										new MemberRowMapper()
									  );
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
	public int update(MemberVO memberVO) {
		return 0;
	}

	class MemberRowMapper implements RowMapper<MemberVO> {

		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO member = new MemberVO();
			member.setId(rs.getString(1));
			member.setPass(rs.getString(2));
			member.setGender(rs.getString(3));
			member.setJob(rs.getString(4));
			member.setMailYN(rs.getString(5));
			member.setReason(rs.getString(6));
			member.setHobby(rs.getString(7));
			member.setRegdate(rs.getString(8));
			return member;
		}
	}
}
