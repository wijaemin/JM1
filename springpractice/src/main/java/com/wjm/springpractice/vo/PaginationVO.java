package com.wjm.springpractice.vo;

import lombok.Data;

//VO(Value Object)
// - 내 입맛대로 데이터를 모아서 저장하는 클래스(DB무관)
// - 등록 x 필요할 때 마다 만들어서 사용
@Data
public class PaginationVO {
	private String type, keyword;//검색 분류 키워드
	private int page=1;//현재 페이지 번호(기본 1)
	private int size=10;//보여줄 게시판 글 수(기본 10)
	
	private int count;//전체 글 수
	private int navigatorSize=10;//하단 네비게이터 	표시 개수(기본 10)
	
	
	
	public boolean isSearch() {
		return type != null && keyword != null;
	}
	
	public int getBegin() { //네비게이터 시작번호 구하기 // 1~10이면 시작번호 1 11~20이면 시작번호 11
		return (page-1)/navigatorSize*navigatorSize+1;
	}
	
	public int getEnd() { //네비게이터 끝번호 구하기
		int end=getBegin() + navigatorSize-1;
		return Math.min(end, getPageCount());
	}
	public int getPageCount() {
		//만약 글 수가 총 12개고 size가 10이면 총 2페이지가 나오고 
		//size가 12면 1페이지가 나온다 그러므로 페이지수를 결정짓는건 navigatorSize가 아니라 size이다
		return 	(count-1)/size+1;
	}
	
	public boolean isFirst() { //네비게이터 화살표 표현을 위해 처음인지 아닌지 알려고 만든 코드
		return getBegin() == 1;
	}
	
	public String getPrevQueryString() {//검색인지 아닌지 확인해서 (이전)화살표 링크 다르게 하기
		if(isSearch()) {
			return "page=" + (getBegin()-1) + "&size= "+ size + "&type=" + type + "&keyword=" + keyword;
		}
		else {
			return "page=" + (getBegin()-1) + "&size= "+ size;
		}
	}
	
	public String getNextQueryString() {//검색인지 아닌지 확인해서 (다음)화살표 링크 다르게 하기
		if(isSearch()) {
			return "page=" + (getEnd()+1) + "&size= "+ size + "&type=" + type + "&keyword=" + keyword;
		}
		else {
			return "page=" + (getEnd()+1) + "&size= "+ size;
		}
	}
	
	public String getQueryString(int page) {
		if(isSearch()) {
			return "page=" + page + "&size= "+ size + "&type=" + type + "&keyword=" + keyword;
		}
		else {
			return "page=" + page + "&size= "+ size;
		}
	}
	
	public boolean isLast() {
		return getEnd()>= getPageCount();
	}
	
	public int getStartRow() {
		return getFinishRow()-(size-1);
	}
	
	public int getFinishRow() {
		return page*size;
	}

}
