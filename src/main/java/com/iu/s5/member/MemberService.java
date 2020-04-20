package com.iu.s5.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s5.board.BoardVO;
import com.iu.s5.board.page.Pager;
import com.iu.s5.member.memberPage.MemberPager;
import com.iu.s5.notice.NoticeDAO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	public List<MemberVO> memberList(MemberPager mp) throws Exception {
		mp.makeRow();
		//---------------------------------------------
		long totalCount = memberDAO.memberCount(mp);
		mp.makePage(totalCount);
		return memberDAO.memberList(mp);			
	}
	
	public int memberJoin(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.memberJoin(memberVO);
	}

}
