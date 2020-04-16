package com.iu.s5.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;

public class NoticeDAOTest extends AbstractTestCase{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void daoIsNull()throws Exception{
		assertNotNull(noticeDAO);
	}
	
	@Test
	public void boardWriteTest()throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("test title");
		noticeVO.setWriter("test writer");
		noticeVO.setContents("test contents");
		int result= noticeDAO.boardWrite(noticeVO);
		assertEquals(1, result);
	}
	
	@Test
	public void boardDelete() throws Exception{		
		int result = noticeDAO.boardDelete(1);
		assertNotEquals(5, result);
	}
	
	@Test
	public void boardUpdate() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("Updated title");
		noticeVO.setContents("Updated contents");
		noticeVO.setNum(2L);
		int result= noticeDAO.boardUpdate(noticeVO);
		assertEquals(1, result);
	}
	
	@Test
	public void boardSelect() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNum(2L);
		int result= noticeDAO.boardSelect(noticeVO);
		assertEquals(1, result);
	}
	
	
}
