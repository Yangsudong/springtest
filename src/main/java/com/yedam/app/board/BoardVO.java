package com.yedam.app.board;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	private Integer boardNo;			//글번호
	private String boardSubject;		//제목
	private String contents; 	//내용
	private String poster;		//작성자
	private String lastpost;	//작성일자
	private Integer views;		//조회수
	private String filename;	//첨부파일
	private String sortCol;		//정렬순서
	private List<String> nos;
	private int first;
	private int last;
	
	
}
