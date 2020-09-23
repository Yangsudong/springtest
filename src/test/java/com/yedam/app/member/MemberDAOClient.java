package com.yedam.app.member;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.member.mapper.MemberSpringDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml",
								   "classpath:config/datasource-context.xml"})
public class MemberDAOClient {
	
	@Autowired MemberSpringDAO dao;
	
	@Test @Ignore
	public void selectAllTest() {
		dao.selectAll();
	}
	
	@Test @Ignore
	public void selectTest() {
		MemberVO memberVO = MemberVO.builder().id("ccc").pass("1111").build();
		memberVO = dao.selectOne(memberVO);
		assertEquals("1111", memberVO.getPass());
	}
	
	@Test @Ignore
	public void insertTest() {
		MemberVO memberVO = MemberVO.builder()
											.id("ggoodd")
											.pass("1111")
											.gender("man")
											.job("ttteessstttt")
											.hobby("ski")
											.reason("데헷")
											.build();
		dao.insert(memberVO);
	}
	
	public void deleteTest() {
		MemberVO memberVO = MemberVO.builder().id("abcde").build();
											
		dao.delete(memberVO);
	}
	
	
}
