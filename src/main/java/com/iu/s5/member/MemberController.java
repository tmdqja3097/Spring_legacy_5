package com.iu.s5.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.iu.s5.member.memberPage.MemberPager;
import com.iu.s5.notice.NoticeVO;


@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberList", method = RequestMethod.GET)
	public ModelAndView memberList(MemberPager mp, ModelAndView mv)throws Exception{
		
		List<MemberVO> ar = memberService.memberList(mp);
		System.out.println(mp.getTotalPage());
		mv.addObject("list", ar);
		mv.addObject("mp", mp);
		mv.setViewName("member/memberList");
		return mv;
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
	public String boardWrite()throws Exception{
		return "member/memberJoin";
	}
	
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public ModelAndView memberJoin(MemberVO memberVO, ModelAndView mv)throws Exception{
		int result = memberService.memberJoin(memberVO);
		if(result>0) {
			mv.setViewName("redirect:./memberList");
		}else {
			mv.addObject("result", "Join Fail");
			mv.addObject("path", "./memberList");
			mv.setViewName("common/result");
		}
		return mv;
	}
}
