package oop.inherit3;

public class Test01 {
	public static void main(String[] args) {
		//Browser는 생성하면 안된다
		//상속의 의미를 잃음
		Chrome a= new Chrome();
		a.setUrl("https://www.google.com");
		a.refresh();
		a.move();
		a.develop();
		a.chromeStore();
		System.out.println();
		Edge b= new Edge();
		b.setUrl("https://www.google.com");
		b.refresh();
		b.move();
		b.fullScreen();
		System.out.println();
		Whale c = new Whale();
		c.setUrl("https://www.google.com");
		c.refresh();
		c.move();
		c.papago();
		c.naverSearch();
		
	}
}
