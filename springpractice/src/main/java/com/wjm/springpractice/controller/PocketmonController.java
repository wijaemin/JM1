package com.wjm.springpractice.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	//파일 다운로드
	//파일번호(attach_no)를 이용하여 정보를 조회
	//실물 파일을 불러와서 사용자에게 전송
	//화면이 아니라 파일을 전송해야 하므로 RestController 처럼 처리
	//매핑 위에 @ResponseBody라고 추가하면 가능
	@ResponseBody
	@RequestMapping("/image")
	public ResponseEntity<ByteArrayResource> image(@RequestParam int no) throws IOException{
		
		//[1]포켓몬 번호로 파일번호를 찾는다
		//[2]파일번호로 파일 정보를 불러와야한다
		//[3]실제 파일을 불러와야한다
		//[4] 앞에서 불러온 정보로 ResponseEntity를 생성한다
		//[5]사용자에게 준다
		
		//1,2
		AttachDto attachDto = pocketmonDao.findImage(no);
		if(attachDto == null) {
//			throw new NoTargetException("파일 없음");//내가 만든 예외
			return ResponseEntity.notFound().build();//404 반환
		}
		
		//3
		String home = System.getProperty("user.home");
		File dir = new File(home, "upload");
		File target= new File(dir,String.valueOf(attachDto.getAttachNo()));
		
		byte[] data= FileUtils.readFileToByteArray(target);//실제 파일 정보 불러오기
		ByteArrayResource resource = new ByteArrayResource(data);
		//4,5 header(정보), body(내용)
		return ResponseEntity.ok()
							.header("Content-Encoding","UTF-8")
							.header("Content-Length",String.valueOf(attachDto.getAttachSize()))
							.header("Content-Type",attachDto.getAttachType())//저장된유형
//							.header("Content-Disposition","attachment;filename="+attachDto.getAttachName())
							.header(HttpHeaders.CONTENT_DISPOSITION, 
									ContentDisposition.attachment()
												.filename(attachDto.getAttachName(),StandardCharsets.UTF_8)
												.build().toString()
									)
							.body(resource);
	}
	
	//상세 페이지
	@RequestMapping("/detail")
	public String detail(@RequestParam int no,Model model) {
		PocketmonDto pocketmonDto = pocketmonDao.selectOne(no);
		model.addAttribute("pocketmonDto",pocketmonDto);
		return "/WEB-INF/views/pocketmon/detail.jsp";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<PocketmonDto> list =pocketmonDao.selectList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/pocketmon/list.jsp";
	}
	
	//삭제
	//[1] 포켓몬 삭제[2] 파일 정보 삭제 [3] 실제파일 삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam int no) {
		AttachDto attachDto = pocketmonDao.findImage(no);
		pocketmonDao.delete(no);//포켓몬 + 이미지 연결 정보 삭제
		if(attachDto !=null) {
			String home= System.getProperty("user.home");
			File dir= new File(home,"upload");
			File target =new File(dir,String.valueOf(attachDto.getAttachNo()));
			target.delete();//실제파일 삭제
			attachDao.delete(attachDto.getAttachNo());//파일 정보 삭제
		}
		return "redirect:list";
	}
	
	//수정
	@GetMapping("/edit")
	public String edit(@RequestParam int no, Model model) {
		PocketmonDto pocketmonDto =pocketmonDao.selectOne(no);
		model.addAttribute("pocketmonDto", pocketmonDto);
		return "/WEB-INF/views/pocketmon/edit.jsp";
	}
	
	//수정 처리를 할 때 첨부파일 유무에 따라 다른 처리를 해야 한다
	//첨부파일이 없으면 기존 첨부파일을 유지(아무것도 안하면 됨)
	//첨부 파일이 있으면 기존 첨부파일을 변경(변경 대신 삭제+등록)
	@PostMapping("/edit")
	public String edit(@ModelAttribute PocketmonDto pocketmonDto, 
						@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		//포켓몬스터 정보 변경
		pocketmonDao.update(pocketmonDto);
		if(!attach.isEmpty()) {//파일 있으면
			//파일 삭제
			AttachDto attachDto = 
					pocketmonDao.findImage(pocketmonDto.getNo());
			
			String home= System.getProperty("user.home");
			File dir= new File(home,"upload");
			if(attachDto != null) {
				attachDao.delete(attachDto.getAttachNo());
				File target= new File(dir, String.valueOf(attachDto.getAttachNo()));
				target.delete();
			}
			
			//파일 추가 및 연결
			int attachNo= attachDao.sequence();//파일번호 생성
			
			File insertTarget= new File(dir, String.valueOf(attachNo));
			attach.transferTo(insertTarget);//신규파일 저장
			
			
			//신규파일정보 저장
			AttachDto insertDto =new AttachDto();
			insertDto.setAttachNo(attachNo);
			insertDto.setAttachName(attach.getOriginalFilename());
			insertDto.setAttachSize(attach.getSize());
			insertDto.setAttachType(attach.getContentType());
			attachDao.insert(insertDto);
			
			//포켓몬+파일 연결
			pocketmonDao.connect(pocketmonDto.getNo(), attachNo);
		}
		
		return "redirect:detail?no=" + pocketmonDto.getNo();
	}
}
