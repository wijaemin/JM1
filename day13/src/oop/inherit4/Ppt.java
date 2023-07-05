package oop.inherit4;

public class Ppt extends File {
	
	private int pagesize;
	
	
	
	
	
	public int getPagesize() {
		return pagesize;
	}





	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}





	public void slideShow() {
		System.out.println("슬라이드 쇼 기능 실행");
	}
}
