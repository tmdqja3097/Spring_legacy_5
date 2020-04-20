package com.iu.s5.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;

public class NoticeDAOTest extends AbstractTestCase {

	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void daoTest() throws Exception {
	}

	@Test
	public void boardWriteTest() throws Exception {
		String writer = "";
		String title = "";
		String contents = "";

		for (int i = 0; i < 150; i++) {
			NoticeVO noticeVO = new NoticeVO();
			if (i % 3 == 0) {
				writer = "iu";
				title = "Alert";
				contents = "Samsung";
			} else if (i % 3 == 1) {
				writer = "choa";
				title = "apple";
				contents = "computer";
			} else {
				writer = "suji";
				title = "os";
				contents = "linux";
			}
			noticeVO.setTitle(title + i);
			noticeVO.setWriter(writer);
			noticeVO.setContents(contents + i);
			int result = noticeDAO.boardWrite(noticeVO);
			if (i == 50 || i == 100) {
				Thread.sleep(1000);
			}
		}
	}

	/*
	 * @Test public void boardDelete() throws Exception { int result =
	 * noticeDAO.boardDelete(1); assertNotEquals(5, result); }
	 * 
	 * @Test public void boardUpdate() throws Exception { NoticeVO noticeVO = new
	 * NoticeVO(); noticeVO.setTitle("Updated title");
	 * noticeVO.setContents("Updated contents"); noticeVO.setNum(2L); int result =
	 * noticeDAO.boardUpdate(noticeVO); assertEquals(1, result); }
	 */

}
