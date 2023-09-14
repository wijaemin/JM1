package com.kh.spring12.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring12.dao.AttachDao;
import com.kh.spring12.dto.AttachDto;

//비동기통신에 대한 업로드를 처리하기 위한 컨트롤러
@CrossOrigin
@RestController
@RequestMapping("/restfile")
public class FileRestController {

	@Autowired
	private AttachDao attachDao;
	
	//비동기통신에서는 화면에서 다음 작업이 가능하도록 파일번호 등을 
	@PostMapping("/upload")
	public Map<String, Object> upload(@RequestParam MultipartFile attach) throws IllegalStateException, IOException{
		//절대규칙 -파일은 하드디스크에, 정보는 DB에!
		
		//[1] 시퀀스 번호를 생성한다
		int attachNo = attachDao.sequence();
		
		//[2] 시퀀스 번호를 파일명으로 하여 실제 파일을 저장한다
		// - 같은 이름에 대한 충돌을 방지하기 위해
		
		String home =System.getProperty("user.home");
		File dir= new File(home, "upload");
		dir.mkdirs();//디렉토리 생성
		
		File target= new File(dir, String.valueOf(attachNo));//저장할파일
		attach.transferTo(target);//저장
		
		//[3] DB에 저장한 파일의 정보를 모아서 INSERT
		AttachDto attachDto = new AttachDto();
		attachDto.setAttachNo(attachNo);
		attachDto.setAttachName(attach.getOriginalFilename());
		attachDto.setAttachSize(attach.getSize());
		attachDto.setAttachType(attach.getContentType());
		attachDao.insert(attachDto);
		
		//화면에서 사용할 수 있도록 파일번호 또는 다운주소를 반환
		//return 객체 or Map;
		return Map.of("attachNo",attachNo);
	}
	
	//다운로드는 비동기나 동기나 똑같음(파일번호만 알면 됨)
	@RequestMapping("/download")
	public ResponseEntity<ByteArrayResource>
						download(@RequestParam int attachNo) throws IOException{
		AttachDto attachDto = attachDao.selectOne(attachNo);
		if(attachDto ==null) {
			//throw new NoTargetException("파일없음");//내가 만든 예외로 통합
			return ResponseEntity.notFound().build();//404반환
		}
		String home =System.getProperty("user.home");
		File dir= new File(home,"upload");
		File target = new File(dir,String.valueOf(attachDto.getAttachNo()));
		
		byte[] data=FileUtils.readFileToByteArray(target);//실제파일정보 불러오기
		ByteArrayResource resource=new ByteArrayResource(data);
		
		//4,5-header(정보),body(내용)
		return ResponseEntity.ok()
									.header(HttpHeaders.CONTENT_ENCODING, StandardCharsets.UTF_8.name())
									.contentLength(attachDto.getAttachSize())
									.header(HttpHeaders.CONTENT_TYPE,attachDto.getAttachType())
									.contentType(MediaType.APPLICATION_OCTET_STREAM)
									.header("Content-Disposition","attachment;filename="+attachDto.getAttachName())

									.body(resource);
		
	}
}
