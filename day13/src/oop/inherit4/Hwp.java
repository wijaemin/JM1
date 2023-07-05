package oop.inherit4;

public class Hwp extends File {
	private int pagesize;
	
	
	public int getPagesize() {
		return pagesize;
	}



	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}



	public void preview() {
		System.out.println("미리보기 기능 실행");
	}
}
