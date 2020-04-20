package com.iu.s5.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;

public class MemberDAOTest extends AbstractTestCase{

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void daoTest() throws Exception {
		MemberDAOTest test = new MemberDAOTest();
		test.memberTest();
	}
	
	
	@Test
	public void memberTest() throws Exception {
		String id = "";
		String name = "";
		String phone = "";
		String email = "123@naver.com";

		for (int i = 0; i < 150; i++) {
			MemberVO memberVO = new MemberVO();
			if (i % 3 == 0) {
				id = "son";
				name = "iu";
				phone = "010";
			} else if (i % 3 == 1) {
				id = "park";
				name = "suji";
				phone = "070";
			} else {
				id = "ki";
				name = "choa";
				phone = "02";
			}
			memberVO.setId(id + i);
			memberVO.setName(name);
			memberVO.setPhone(phone + i);
			memberVO.setEmail(email);
			memberVO.setAge(10);
			memberVO.setPw("123");
					
			int result = memberDAO.memberJoin(memberVO);
			if (i == 50 || i == 100) {
				Thread.sleep(1000);
			}
		}
	}
}
