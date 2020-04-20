package com.iu.s5.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s5.board.BoardVO;
import com.iu.s5.board.page.Pager;
import com.iu.s5.member.memberPage.MemberPager;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s5.member.MemberDAO.";

	// count
	public long memberCount(MemberPager mp) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "memberCount", mp);
	}

	// List
	public List<MemberVO> memberList(MemberPager mp) throws Exception {
		return sqlSession.selectList(NAMESPACE + "memberList", mp);
	}

	// Join
	public int memberJoin(MemberVO memberVO) throws Exception {
		return sqlSession.insert(NAMESPACE + "memberJoin", memberVO);
	}
}
