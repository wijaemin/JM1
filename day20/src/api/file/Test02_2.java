package api.file;

import java.io.File;
<<<<<<< HEAD
import java.util.Scanner;

public class Test02_2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String name=sc.next();
		File target =new File(name);
		
		
		if(target.isFile()) { //파일이면 이름+확장자+크기
			System.out.println("<파일정보>");
			System.out.println("이름: " + target.getName());
			int index=target.getName().lastIndexOf(".");
			String extension;
			if(index==-1) {
				extension="없음";
			}
			else {
				extension=target.getName().substring(index+1);
			}
			System.out.println("확장자 :"+extension);
			System.out.println("크기 : " +target.length() + "bytes");
		}
		else if(target.isDirectory()) {//디렉터라면 목록[파일/폴더]
			File[] list=target.listFiles();
			for(File file: list) {
				if(file.isFile()) {//파일이면
					System.out.print("[파일]");
				}
				else if(file.isDirectory()) { //디렉터라면
					System.out.print("[폴더]");
				}
				System.out.println(file.getName());
			}
		}
		else {
			System.out.println("존재하지 않는 파일 또는 폴더");
		}
	}
}
=======

public class Test02_2 {
	public static void main(String[] args) {
	
		//경로 준비
		//String input = "D:/test.txt";	//파일
		String input = "A:/study";		//디렉터리
		//String input = "D:/study2";	//존재하지 않는 대상
		
		//분석을 하려면 파일 객체를 생성해야함
		File target = new File(input);
		
		if(target.isFile()) {//파일이면 이름+확장자+크기
			System.out.println("<파일 정보>");
			System.out.println("이름 : " + target.getName());
			System.out.println("확장자 : ?");
			System.out.println("크기 : " + target.length() + " bytes");
		}
		else if(target.isDirectory()) {//디렉터리면 목록[파일/폴더] 출력
			File[] list = target.listFiles();
			for(File file : list) {
				if(file.isFile()) {//파일이면
					System.out.print("[파일] ");
				}
				else if(file.isDirectory()) {//디렉터리면
					System.out.print("[폴더] ");
				}
				System.out.println(file.getName());
			}
		}
		else {//없으면
			System.out.println("존재하지 않는 파일 또는 폴더");
		}
	}
}





>>>>>>> branch 'main' of https://github.com/wijaemin/JM1.git
