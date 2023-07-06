package oop.poly1;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("노트북을 먼저 선택하세요");
		System.out.print("1.맥북    2.갤럭시북 : ");
		int type =sc.nextInt();
		
		System.out.println("테스트 할 기능을 선택하세요");
		System.out.print("1.전원    2.동영상재생    3.타이핑 : ");
		int test = sc.nextInt();
		//NoteBook book =맥북객체 or 갤럭시북객체;
		NoteBook book;
		if(type==1) {
			book=new MacBook(); //MacBook-->NoteBook(업캐스팅)
		}
		else {
			book=new GalaxyBook();//GalaxyBook-->NoteBook(업캐스팅)
		}
		//notebook에 들어간 객체의 기능을 실행
		if(test==1) {
			book.power();
		}
		else if(test==2) {
			book.video();
		}
		else {
			book.typing();
		}


	
		
		
	
		
		
		
		
		
		
	//	MacBook n1=new MacBook();
		
	//	n1.power();
	//	n1.video();
	//	n1.typing();
		
	//	GalaxyBook n2 =new GalaxyBook();
		
	//	n2.power();
	//	n2.video();
	//	n2.typing();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
