package com.wjm.springpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.wjm.springpractice.dao.CertDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RegularServiceImpl implements RegularService{
	
	@Autowired
	private CertDao certDao;
	
	//스케줄러 메소드는 언제 실행할 것인지에 대한 설정이 추가로 필요
//	@Scheduled(fixedRate = 1000)//1000ms에 한번씩 실행
//	@Scheduled(cron =  "* * * * * *")//매초 매분 매시 매일 매월 매요일
//	@Scheduled(cron = "*/2 * * * * *")
//	@Scheduled(cron = "0 * * * * * *")//0초 매분 매시 매일 매월 매요일
	@Scheduled(cron = "0 0 * * * *")//매 시 정각마다
//	@Scheduled(cron = "0 0 9 * * *")//매일 아침 9시
//	@Scheduled(cron = "0 30 9,18 * * *")//출근(9:30) 퇴근(18:30) 한번씩
//	@Scheduled(cron = "0 30 9-18 * * *")//출근부터 퇴근까지 1시간 마다
//	@Scheduled(cron = "0 30 9-18 * * 1-5")//월~금까지 근무시간 1시간 마다
//	@Scheduled(cron = "0 30 9-18 * * mon-fri")//월~금까지 근무시간 1시간 마다
//	@Scheduled(cron = "* * * 18 * ?")//요일 무관 매 18일 마다
//	@Scheduled(cron = "0 0 12 ? * 4L")//매월 마지막(L) 목요일(4) 12시 정각
//	@Scheduled(cron = "0 0 12 ? * thu#1")//매월 1주차(#1) 목요일(thu) 12시 정각
	@Override
	public void clearCert() {
//		log.debug("실행");
		certDao.deleteOver5min();
		
	}
	
	
}
