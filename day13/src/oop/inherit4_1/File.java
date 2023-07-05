package oop.inherit4_1;

public class File {
	//공통 필드
	private String filename;
	private long filesize;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		if(filesize<0L) return;
		this.filesize = filesize;
	}
	
	//공통 메소드
	public void excute() {
		System.out.println("파일 실행");
	}
	
	
}
