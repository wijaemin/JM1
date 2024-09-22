package com.wjm.springpractice.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wjm.springpractice.dao.AttachDao;
import com.wjm.springpractice.dao.PocketmonDao;
import com.wjm.springpractice.dto.AttachDto;
import com.wjm.springpractice.dto.PocketmonDto;

@Controller
@RequestMapping("/pocketmon")
public class PocketmonController {
	
	@Autowired
	private PocketmonDao pocketmonDao;
	
	@Autowired
	private AttachDao attachDao;
	
	@GetMapping("/insert")
	public String insert() {
		return "/WEB-INF/views/pocketmon/insert.jsp";
	}

	@PostMapping("/insert")
	public String insert(
			@ModelAttribute PocketmonDto pocketmonDto, 
			@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		//포켓몬 등록
		int no = pocketmonDao.sequence();
		pocketmonDto.setNo(no);
		pocketmonDao.insert(pocketmonDto);
		
		if(!attach.isEmpty()) {
			//첨부파일 등록(있을 때만)
			int attachNo = attachDao.sequence();
			
			String home=System.getProperty("user.home");
			File dir = new File(home,"upload");
			dir.mkdirs();
			File target = new File(dir, String.valueOf(attachNo));
			attach.transferTo(target);
			
			AttachDto attachDto = new AttachDto();
			attachDto.setAttachNo(attachNo);
			attachDto.setAttachName(attach.getOriginalFilename());
			attachDto.setAttachSize(attach.getSize());
			attachDto.setAttachType(attach.getContentType());
			attachDao.insert(attachDto);
			
			//연결(있을 때만)
			pocketmonDao.connect(no, attachNo);
		}
		
		
		return "redirect:insert";
	}
	
}
