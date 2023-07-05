package oop.inherit4_1;

public class Test01 {
	public static void main(String [] args) {
		Mp4 mp4 =new Mp4();
		mp4.setFilename("상속.mp4");
		mp4.setFilesize(100000L);
		mp4.setSpeed(1.2f);
		mp4.excute();
		mp4.forward();
		mp4.rewind();
		
		Mp3 mp3 =new Mp3();
		mp3.setFilename("자바의 정석.mp3");
		mp3.setFilesize(100000L);
		mp3.setDuration(180);
		mp3.excute();
		mp3.forward();
		mp3.rewind();
		
		Hwp hwp= new Hwp();
		hwp.setFilename("시험필기.hwp");
		hwp.setFilesize(999L);
		hwp.setPagesize(20);
		hwp.excute();
		hwp.preview();
		
		Ppt ppt= new Ppt();
		ppt.setFilename("발표자료.ppt");
		ppt.setFilesize(30);
		ppt.setPagesize(100);
		ppt.excute();
		ppt.slideShow();
		
		
	}
}
