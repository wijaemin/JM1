package com.wjm.springpractice.controller;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wjm.springpractice.dao.BoardDao;
import com.wjm.springpractice.dao.MemberDao;
import com.wjm.springpractice.dto.BoardDto;
import com.wjm.springpractice.dto.BoardListDto;
import com.wjm.springpractice.dto.MemberDto;
import com.wjm.springpractice.error.NoTargetException;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/write")
	public String write(Model model, 
			@RequestParam(required= false) Integer boardParent) {
		
		if(boardParent != null) {//있으면 답글
			BoardDto originDto = boardDao.selectOne(boardParent);
			model.addAttribute("originDto", originDto);
			model.addAttribute("isReply", true);	
		}
		else {//없으면 새글
			model.addAttribute("isReply", false);
		}
		
		
		return "/WEB-INF/views/board/write.jsp";
	}
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto boardDto, HttpSession session) {
		int no = boardDao.sequence();
		boardDto.setNo(no);
		
		String email=(String) session.getAttribute("email");
		boardDto.setWriter(email);
		
		
		if(boardDto.getBoardParent() == null) {//새 글인 경우
			boardDto.setBoardGroup(no);
		}
		else {//답급일 경우
			BoardDto originDto= boardDao.selectOne(boardDto.getBoardParent());//받은 boardDto에서 boardParent받아와서 originDto(원래 글) 생성
			boardDto.setBoardGroup(originDto.getBoardGroup());//받은boardDto의 group을 originDto에서 가져옴
			boardDto.setBoardDepth(originDto.getBoardDepth()+1);//차수는 originDto의 차수에 +1
		}
		
		//이 사용자의 마지막 글번호 조회
		Integer lastNo=boardDao.selectMaxNo(email);
		
		boardDao.insert(boardDto);//글 등록
		
		//포인트 계산 작업
		//-lastNo가 null이면 신규 작성이라는 것
		//-lastNo가 null이 아니면 조회한 다음 시간차 비교
		if(lastNo == null) {//첫 글이라면
			memberDao.updatePoint(email,10);
		}
		else {//처음이 아니라면
			BoardDto lastDto=boardDao.selectOne(lastNo);
			Timestamp stamp = new Timestamp(lastDto.getCreatedAt().getTime());//TimeStamp로 마지막 작성글의 작성일 시간 담기
			LocalDateTime lastTime=stamp.toLocalDateTime();//LocalDateTime으로 변환
			LocalDateTime currentTime=LocalDateTime.now();//현재시간 LocalDateTime으로 변환
			
			Duration duration =Duration.between(lastTime, currentTime); //시간차 값 구하기
			long seconds=duration.getSeconds();//기간차 값 초로 변환
			if(seconds>300) {//시간차가 300초보다 크다면(5분 초과)
				memberDao.updatePoint(email,10);
			}
			
			
		}
		
		
		
		
		return "redirect:detail?no=" + no;
	}
	
	
	//목록, 검색, 페이징
	//목록일 경우 type keyword 파라미터 없음
	//검색일 경우 type keyword 파라미터 있음
	
	@RequestMapping("/list")
	public String list(Model model,
			@RequestParam(required = false) String type,
			@RequestParam(required = false) String keyword, 
			@RequestParam(required = false, defaultValue="1") int page) {
		boolean isSearch = type !=null && keyword != null;
		
		//페이징과 관련된 값들을 계산해 jsp로 전달
		int begin=(page-1)/10 *10 +1;
		int end=begin+9;
		
		int count = isSearch ? 
				boardDao.countList(type, keyword): boardDao.countList();
		
		
		int pageCount =(count-1)/10+1;
		model.addAttribute("page", page);
		model.addAttribute("begin", begin);
		model.addAttribute("end", Math.min(pageCount, end));
		model.addAttribute("pageCount", pageCount);
		
		if(isSearch) {
//			List<BoardListDto>list= boardDao.selectList(type, keyword);
			List<BoardListDto>list = boardDao.selectListByPage(type, keyword, page);
			model.addAttribute("list", list);
			model.addAttribute("isSearch",true);
		}
		else {
//			List<BoardListDto>list =boardDao.selectList();
			List<BoardListDto>list= boardDao.selectListByPage(page);
			model.addAttribute("list", list);
			model.addAttribute("isSearch",false);
		}
		
		
		return "/WEB-INF/views/board/list.jsp";
		
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int no, 
			Model model,HttpSession session) {
		
		
		BoardDto boardDto = boardDao.selectOne(no);
	
		model.addAttribute("boardDto", boardDto);
		String writer= boardDto.getWriter();
		
		if(writer !=null){
			MemberDto memberDto = memberDao.selectOne(writer);
			
			model.addAttribute("memberDto",memberDto);
		}
		
		return "/WEB-INF/views/board/detail.jsp";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int no, Model model) {
		BoardDto boardDto = boardDao.selectOne(no);
		model.addAttribute("boardDto", boardDto);
		
		return "/WEB-INF/views/board/edit.jsp";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto) {
		boolean result=boardDao.edit(boardDto);
		if(result) {
			return "redirect:detail?no="+ boardDto.getNo();
		}
		else {
			throw new NoTargetException("존재하지 않는 글번호");
		}
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam int no) {
		boolean result=boardDao.delete(no);
		if(result) {
			return "redirect:list";
		}
		else {
			throw new NoTargetException("존재하지 않는 글번호");
		}
	}
	
	
}
