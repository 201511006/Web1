package com.kjw.controller2;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kjw.domain2.BoardVO;
import com.kjw.domain2.Criteria;
import com.kjw.domain2.PageMaker;
import com.kjw.service2.BoardService;

@Controller
/*@RequestMapping("/board/*")*/
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET) //등록 페이지로 이동
	public void registGET(BoardVO board, Model model)throws Exception{
		
		logger.info("register get......");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST) //실제 등록 작업 처리
//	public String registPOST(BoardVO board, Model model)throws Exception{
	public String registPOST(BoardVO board, RedirectAttributes rttr)throws Exception{
		
		logger.info("regist post......");
		logger.info(board.toString());
		
		service.regist(board);
		
//		model.addAttribute("result", "success"); //model클래스는 스프링 mvc에서 제공하는 데이터 전달용 객체!(uri에 보임)
		rttr.addFlashAttribute("msg", "success"); //리다이렉트 시점에 한 번만 사용되는 데이터 전송!(uri상에 보이지 않음)
		
		
//		return "/success";
		return "redirect:/listPage";
	}
	
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET) //전체 목록 보기
	public void listAll(Model model)throws Exception{
		
		logger.info("show all list......");
	
		model.addAttribute("list", service.listAll());
	}
	
/*	@RequestMapping(value = "/read", method = RequestMethod.GET) //글 하나 조회
	public void read(@RequestParam("bno") int bno, Model model)throws Exception{
		
		model.addAttribute(service.read(bno)); //BoardVO클래스의 객체임으로 boardVO로 저장됨!
	}*/
	
	
	@RequestMapping(value = "/readPage", method = RequestMethod.GET) //글 하나 조회
	public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model)throws Exception{
		
		model.addAttribute(service.read(bno)); //BoardVO클래스의 객체임으로 boardVO로 저장됨!
	}
	
	
	/*@RequestMapping(value = "/remove", method = RequestMethod.POST) //글 삭제
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr)throws Exception{
		
		service.remove(bno);
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/listAll";
	}*/
	
	@RequestMapping(value = "/removePage", method = RequestMethod.POST) //글 삭제
	public String remove(@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr)throws Exception{
		
		service.remove(bno);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/listPage";
	}
	
	
/*	@RequestMapping(value = "/modify", method = RequestMethod.GET) //
	public void modifyGET(int bno, Model model)throws Exception{
		
		logger.info("modify get......");
		
		model.addAttribute(service.read(bno));
	}*/
	
	/*	@RequestMapping(value = "/modify", method = RequestMethod.POST) //실제 수정 작업 처리
	public String modifyPOST(BoardVO board, RedirectAttributes rttr)throws Exception{
		
		logger.info("modify post......");
		
		service.modify(board);
		rttr.addAttribute("msg", "success");
		
		return "redirect:/listAll";
	}*/
	
	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET) //
	public void modifyPagingGET(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model)throws Exception{
		
		logger.info("modify get......");
		
		model.addAttribute(service.read(bno));
	}
	
	
	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST) //실제 수정 작업 처리
	public String modifyPOST(BoardVO board, Criteria cri, RedirectAttributes rttr)throws Exception{
		
		logger.info("modify post......");
		
		service.modify(board);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("msg", "success");
		
		return "redirect:/listPage";
	}
	
	
	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void listAll(Criteria cri, Model model)throws Exception{
		
		logger.info("show list Page with Criteria.............");
		
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(Criteria cri, Model model)throws Exception{
		
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		//pageMaker.setTotalCount(131);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
}
