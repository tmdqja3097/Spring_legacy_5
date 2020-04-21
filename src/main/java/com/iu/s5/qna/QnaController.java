package com.iu.s5.qna;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s5.board.BoardVO;
import com.iu.s5.notice.NoticeService;
import com.iu.s5.notice.NoticeVO;
import com.iu.s5.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() throws Exception{
		return "qna";
	}
	
	@GetMapping("qnaWrite")
	public String boardWrite()throws Exception{
		return "board/boardWrite";
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView boardWrite(QnaVO qnaVO, ModelAndView mv)throws Exception{
		int result = qnaService.boardWrite(qnaVO);
		if(result>0) {
			mv.addObject("result", "Write Success");
		}else {
			mv.addObject("result", "Write Fail");	
		}
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView boardSelect(long num)throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardVO boardVO = qnaService.boardSelect(num);
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	
	@GetMapping("qnaList")
	public ModelAndView boardList(Pager pager, ModelAndView mv)throws Exception{
		
		List<BoardVO> ar = qnaService.boardList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@GetMapping("qnaDelete")
	public ModelAndView boardDelete(long num) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.boardDelete(num);
		if(result>0) {
			mv.addObject("result", "Delete Success");
		}else {
			mv.addObject("result", "Delete Fail");
		}
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		return mv;
	 
	}
	
	@GetMapping("qnaUpdate")
	public String boardUpdate(long num, Model model)throws Exception{
		BoardVO boardVO = qnaService.boardSelect(num);
		model.addAttribute("vo", boardVO);
		return "board/boardUpdate";	
	}
	
	@PostMapping("qnaUpdate")
	public String boardUpdate(QnaVO qnaVO)throws Exception{
		int result = qnaService.boardUpdate(qnaVO);
		String path = "";
		
		if(result>0){
			path="redirect:./qnaList";
		}else {
			path="redirect:./qnaSelect?num="+qnaVO.getNum();
		}
		return path;
	}
	
	@GetMapping("qnaReply")
	public ModelAndView boardReply(ModelAndView mv,long num)throws Exception{
		mv.addObject("num", num);
		mv.setViewName("board/boardReply");
		return mv;
	}
	
	@PostMapping("qnaReply")
	public ModelAndView boardReply(ModelAndView mv, QnaVO qnaVO)throws Exception{
		int result = qnaService.boardReply(qnaVO);
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.addObject("result", "Reply Write Fail");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
}
