package com.kh.springhome.controller;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.springhome.dao.BoardDao;
import com.kh.springhome.dao.MemberDao;
import com.kh.springhome.dto.BoardDto;
import com.kh.springhome.dto.MemberDto;
import com.kh.springhome.error.NoTargetException;


@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("/list")
	public String list(Model model,@RequestParam (required = false)String keyword, 
			@RequestParam  (required = false)String type) {
		boolean isFind = (keyword !=null && type != null);
		
		if(isFind) {
			List<BoardDto>searchList=boardDao.searchList(type, keyword);
			model.addAttribute("list", searchList);
			return "/WEB-INF/views/board/list.jsp";
			
		}
		else {
//			List<BoardDto>list =boardDao.selectList();
//			model.addAttribute("list", list);
			model.addAttribute("list", boardDao.selectList());
			return "/WEB-INF/views/board/list.jsp";
			
		}
		
		
		
	}
	@GetMapping("/write")
	public String write(HttpSession session) {
		String memberId=(String) session.getAttribute("name");
		if(memberId !=null) {
			return"/WEB-INF/views/board/write.jsp";
		}
		else {
			return"/WEB-INF/views/member/login.jsp";
		}
	}
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto boardDto,HttpSession session) {
		//일단 시퀀스로 게시글 번호 가져오고 게시글 번호로 dto를 불러올수 있는가
		//게시글 번호랑 게시글 작성자가 필요한데
		//번호는 가져왔고
		//작성자를 어떻게 하지
		int boardNo =boardDao.sequence();
		String boardWriter=(String) session.getAttribute("name");
		boardDto.setBoardNo(boardNo);
		boardDto.setBoardWriter(boardWriter);
		//이 사용자의 마지막 글번호를 조회
		Integer lastNo=boardDao.selectMax(boardWriter);
		
		//글을 등록하고
		boardDao.insert(boardDto);
		
		//포인트 계산 작업
		//-lastNo가 null이라는 것은 처음글을 작성했다는 의미
		//-lastNo가 null이 아니면 조회한 다음 시간차를 비교
		if(lastNo==null ) {//글을 쓴게 처음이라면
			memberDao.increaseMemberPoint(boardWriter,10); //10점 주기
		}
		else {//처음이 아니라면 시간 차이를 계산
			BoardDto lastDto=boardDao.selectOne(lastNo);
			Timestamp stamp= new Timestamp(
					lastDto.getBoardCtime().getTime());
			LocalDateTime lastTime=stamp.toLocalDateTime();
			LocalDateTime currentTime= LocalDateTime.now();
			Duration duration= Duration.between(lastTime, currentTime);
			long seconds= duration.getSeconds();
			if(seconds>300) {//시간차가 300초보다 크다면(5분 초과)
				memberDao.increaseMemberPoint(boardWriter,10); //10점 주기
			}
		}
		
		return"redirect:detail?boardNo="+boardNo;
	}
	@RequestMapping("/detail")
	public String detail(@RequestParam int boardNo,Model model, 
			HttpSession session) {
		String memberId=(String) session.getAttribute("name");

		
	 Set<Integer> visitedBoards = (Set<Integer>) session.getAttribute("visitedBoards");
	 if (visitedBoards == null) {
	        visitedBoards = new HashSet<>();
	        session.setAttribute("visitedBoards", visitedBoards);
	    }
	 BoardDto boardDto = boardDao.selectOne(boardNo);
	 String writerId=boardDto.getBoardWriter();
	 MemberDto memberDto=memberDao.selectOne(writerId);
	 
	
	if(memberId!=null &&memberId.equals(boardDto.getBoardWriter())) {//아이디가 null이 아니거나 같을때
		model.addAttribute("boardDto", boardDto);
		model.addAttribute("memberDto", memberDto);
		 return "/WEB-INF/views/board/detail.jsp";
		}
	 if (visitedBoards.contains(boardNo)) {
		 model.addAttribute("boardDto", boardDto);
		 model.addAttribute("memberDto", memberDto);
		    return "/WEB-INF/views/board/detail.jsp";
	    }
	 else {
		    boardDao.readecountPlus(boardNo);
	        visitedBoards.add(boardNo);
	        model.addAttribute("boardDto", boardDto);
	        model.addAttribute("memberDto", memberDto);
		    return "/WEB-INF/views/board/detail.jsp";
		 
	 }
		
		
	}
//	@RequestMapping("/delete")
	//삭제
	//-만약 소유자 검사를 추가한다면
	//- 현재 로그인 한 사용자와 게시글 작성자가 같다면 소유자로 판정
//	public String delete(@RequestParam int boardNo,HttpSession session) {
//		BoardDto boardDto=boardDao.selectOne(boardNo);
//		String boardWriter=boardDto.getBoardWriter();
//		
//		
//		String memberId=(String)session.getAttribute("name");
//		if(memberId.equals(boardWriter)) {//소유자라면
//			boardDao.delete(boardNo);
//			return "redirect:list";
//		}
//		else {
//			throw new AuthorityException("글 작성자가 아닙니다");
//		}
//
//		
//	}
	@RequestMapping("/delete")
	//삭제
	//-만약 소유자 검사를 추가한다면
	//- 현재 로그인 한 사용자와 게시글 작성자가 같다면 소유자로 판정
	public String delete(@RequestParam int boardNo,HttpSession session) {

		boolean result=boardDao.delete(boardNo);
		if(result) {
			return "redirect:list";
		}
		else {
			throw new NoTargetException("없는 게시글 번호");
		}

		
	}
	@GetMapping("/edit")
	public String edit(@RequestParam int boardNo,Model model) {
		BoardDto boardDto=boardDao.selectOne(boardNo);
		model.addAttribute("boardDto", boardDto);
		
		return "/WEB-INF/views/board/edit.jsp";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto inputDto) {///edit.jsp에서 입력한 값 가져오기
		
		
		boardDao.update(inputDto);
		return "redirect:detail?boardNo="+inputDto.getBoardNo();
		
	}

	
	
}








