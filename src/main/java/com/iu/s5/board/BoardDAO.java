package com.iu.s5.board;

import java.util.ArrayList;
import java.util.List;
public interface BoardDAO {
	// 멤버변수로 상수만을 가짐
	// 추상메서드
	// 접근제어자는 public abstract
	// 생략해도 자동으로 만들어짐
	
	// List
	public List<BoardVO> boardList() throws Exception;
	
	// Select
	public int boardSelect(BoardVO boardVO) throws Exception;
	
	// insert
	public int boardWrite(BoardVO boardVO) throws Exception;
	
	// delete
	public int boardDelete(long num) throws Exception;
	
	// update
	public int boardUpdate(BoardVO boardVO)throws Exception;
}
