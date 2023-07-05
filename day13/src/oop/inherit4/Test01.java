package oop.inherit4;

public class Test01 {
	public static void main(String[] args) {
		Mp4 mp1=new Mp4();
		mp1.setFilename("mp4");
		mp1.setFilesize(1000);
		mp1.setSpeed(10);
		mp1.Excute();
		mp1.Forward();
		mp1.Rewind();
		System.out.println();
		Mp3 mp2 =new Mp3();
		mp2.setFilename("mp3");
		mp2.setFilesize(9000);
		mp2.setDuration(2);
		mp2.Excute();
		mp2.forward();
		mp2.rewind();
		System.out.println();
		Hwp p1=new Hwp();
		p1.setFilename("Hwp");
		p1.setFilesize(800);
		p1.setPagesize(11);
		p1.Excute();
		p1.preview();
		System.out.println();
		Ppt p2=new Ppt();
		p2.setFilename("Ppt");
		p2.setFilesize(1);
		p2.setPagesize(22);
		p2.Excute();
		p2.slideShow();
		System.out.println();
	}
	
}
