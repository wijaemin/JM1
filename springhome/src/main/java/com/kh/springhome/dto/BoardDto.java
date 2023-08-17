package com.kh.springhome.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class BoardDto {
	
	private int boardNo;
	private String boardWriter, boardTitle, boardContent;
	private int boardReadcount, boardLikecount, boardReplycount;
	private Date boardCtime, boardUtime;
	private int boardGroup;
	private Integer boardParent;
	private int boardDepth;
	//작성자 출력용 메소드
	public String getBoardWriterString() {
		if(boardWriter ==null) 
			return "(알수없음)";
		return boardWriter;
	}
	//날짜에 따라 다른 값을 반환하는 메소드
	public String getBoardCtimeString() {
		LocalDate current=LocalDate.now();//현재날짜
		LocalDate ctime=boardCtime.toLocalDate();//작성일
		if(current.equals(ctime)) {//작성일 == 오늘
			Timestamp stamp=new Timestamp(boardCtime.getTime());
			LocalDateTime time=stamp.toLocalDateTime();
			LocalTime result=time.toLocalTime();
			return result.format(DateTimeFormatter.ofPattern("a h시m분"));
		}
		else {
			return ctime.toString();
		}
	}
}
