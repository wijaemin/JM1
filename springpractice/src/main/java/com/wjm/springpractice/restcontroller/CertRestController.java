package com.wjm.springpractice.restcontroller;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wjm.springpractice.dao.CertDao;
import com.wjm.springpractice.dto.CertDto;

@CrossOrigin
@RestController
@RequestMapping("/rest/cert")
public class CertRestController {

	@Autowired
	private CertDao certDao;
	
	@Autowired
	private JavaMailSender sender;
	
	@PostMapping("/send")
	public void send(@RequestParam String email) {
		//[1]인증번호 생성
		Random r= new Random();
		int number = r.nextInt(1000000);
		DecimalFormat fm =new DecimalFormat("000000");
		String certNum = fm.format(number);
		
		//[2] 이메일 발송
		SimpleMailMessage message= new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("인증번호");
		message.setText("인증번호는 [" + certNum + "]입니다");
		sender.send(message);
		
		//[3] DB 저장(기존 데이터 삭제)
		certDao.delete(email);
		CertDto certDto = new CertDto();
		certDto.setEmail(email);
		certDto.setNum(certNum);
		certDao.insert(certDto);
	}
	
//	@PostMapping("/check")
}
