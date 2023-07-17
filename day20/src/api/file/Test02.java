package api.file;

import java.io.File;
<<<<<<< HEAD
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String name=sc.next();
		File file =new File(name);
		
		
		if(file.exists()) {
			if(file.isFile()) {
				String fileName=file.getName();
				String ext =fileName.substring(fileName.lastIndexOf(".")+1);
				System.out.println("파일명 : " +fileName);
				System.out.println("확장자 : " +ext);
				System.out.println("크기 : " +file.length() +"byte");
			}
			if(file.isDirectory()) {
				String fileName=file.getName();
				String ext =fileName.substring(fileName.lastIndexOf(".")+1);
				String[] names=file.list();
				for(String list:names) {
					System.out.println(list + "[폴더]");
				}
			}
		}
		else {
			System.out.println("존재하지 않는 파일 또는 폴더");
		}
	}
}
=======

public class Test02 {
	public static void main(String[] args) {
	
		//경로 준비
		String input = "A:/test.txt";	//파일
		//String input = "D:/study";		//디렉터리
		//String input = "D:/study2";	//존재하지 않는 대상
		
		//분석을 하려면 파일 객체를 생성해야함
		File target = new File(input);
		
		if(target.isFile()) {//파일이면
			System.out.println("파일");
		}
		else if(target.isDirectory()) {//디렉터리면
			System.out.println("디렉터리");
		}
		else {//없으면
			System.out.println("존재하지 않는 파일 또는 폴더");
		}
	}
}





>>>>>>> branch 'main' of https://github.com/wijaemin/JM1.git
