package com.yedam.app.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.board.mapper.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/*-context.xml"})
public class BoardDAOClient {
	
	@Autowired BoardDAO boardDAO;
	
	//@Test
	public void cntTest() {
		System.out.println(boardDAO.selectCnt());	
	}
	
	//@Test
	public void selectMapTest() {
		System.out.println(boardDAO.selectMap());
	}
	
	@Test 
	public void selectAllTest() {
		BoardVO vo = BoardVO.builder()
							//.poster("god")
							//.boardSubject("god")
							.first(5)
							.last(10)
							.build();
		
		List<BoardVO> list = boardDAO.selectAll(vo);
		for(BoardVO board : list) {
			System.out.println(board.getBoardNo() + ":" +
							   board.getBoardSubject() +
							   board.getPoster() + ":" + 
							   board.getLastpost());
		}
	}
	
	//@Test
	public void insertTest() {
		BoardVO vo = BoardVO.builder()
							.poster("god")
							.boardSubject("hey test")
							.contents("hey test")
							.build();
		boardDAO.insert(vo);
		System.out.println("글번호 : " + vo.getBoardNo() );
	}
	
	//@Test
	public void deleteAllTest() {
		List<String> list = Arrays.asList( new String[] {"2","3","4","5","6"} );
		BoardVO vo = BoardVO.builder()
							.nos(list)
							.build();
		boardDAO.deleteAll(vo);
	}
}
